var socketio = require('socket.io');
var io;
var guestNumber = 1;
var nickNames={};
var namesUsed=[];
var currentRoom = {};

exports.listen = function(server){//启动IO服务器
    io = socketio.listen(server);//启动SocketIO服务器，允许搭建在已有的HTTP服务上
    io.set('log level',1);
    console.log("a");
    io.sockets.on('connection',function(socket){//定义用户链接处理逻辑
        console.log("b");
        guestNumber = assignGuestName(socket,guestNumber,nickNames,namesUsed);//赋予这个用户访客名
        joinRoom(socket,'Lobby');//把这个用户链接上LObby聊天室里
        handleMessageBroadcasting(socket,nickNames);//处理用户消息
        handleNameChangeAttempts(socket,nickNames,namesUsed);//处理用户名更改
        handleRoomJoining(socket);//处理聊天室创建和更改
        socket.on('rooms',function(){
            socket.emit('rooms',io.sockets.manager.rooms);
        });
        handleClientDisconnection(socket,nickNames,namesUsed);//断开后清除
    });
};
function assignGuestName(socket,guestNumber,nickNames,namesUsed){
    var name = 'Guest'+guestNumber;//生成新的昵称
    nickNames[socket.id] = name;//把用户昵称和客户端的ID联系
    socket.emit('nameResult',{//让用户知道自己的用户名
        success:true,
        name:name
    });
    namesUsed.push(name);//放入已占用的用户名列表
    return guestNumber+1;
}
function joinRoom(socket,room){
    socket.join(room);//用户进入房间
    currentRoom[socket.id]=room;//记录用户当前房间
    socket.emit('joinResult',{room:room});//让用户知道他们进入了新房间
    socket.broadcast.to(room).emit('message',{//让房间里的其他人知道有人进入了房间
        text:nickNames[socket.id]+'has joined'+ room+'.'
    });
    var usersInRoom = io.sockets.clients(room);
    if(usersInRoom.length>1){//确定下这个房间的人有哪些
        var usersInRoomSummary = 'Users currently in '+ room +';';
        for(var index in usersInRoom){
            var userSocketId = usersInRoom[index].id;
            if(userSocketId!=socket.id){
                if(index>0){
                    usersInRoomSummary += nickNames[userSocketId];      
                }
            }
            usersInRoomSummary += '.';
            socket.emit('message',{text:usersInRoomSummary});//将房间里的其他用户发送给新人
        }
    }
}

function handleNameChangeAttempts(socket,nickNames,namesUsed){//改名请求
    socket.on('nameAttempt',function(name){
        if(name.indexOf('Guest')==0){
            socket.emit('nameResult',{
                success:false,
                message:'Names cannot begin with "Guest".'
            });
        }else{
            if(namesUsed.indexOf(name)==-1){
                var previousName = nickNames[socket.id];
                var previousNameIndex = namesUsed.indexOf(previousName);
                namesUsed.push(name);
                nickNames[socket.id]=name;
                delete namesUsed[previousNameIndex];
                socket.emit('nameResult',{
                    success:true,
                    name:name
                });
                socket.broadcast.to(currentRoom[socket.id]).emit('message',{
                    text:previousName+'is now known as '+name+'.'
                });
            }else{//用户名被占用
                socket.emit('nameResult',{
                    success:falsem,
                    message:'That name is already in use'
                });
            }
        }
    });
}

function handleMessageBroadcasting(socket){//broadcast用来转发消息
    socket.on('message',function(message){
        socket.broadcast.to(message.room).emit('message',{
            text:nickNames[socket.id]+':'+message.text
        });
    });
}

function handleRoomJoining(socket){
    socket.on('join',function(room){
        socket.leave(currentRoom[socket.id]);
        joinRoom(socket,room.newRoom);
    });
}
function handleClientDisconnection(socket){
    socket.on('disconnect',function(){
        var nameIndex = namesUsed.indexOf(nickNames[socket.id]);
        delete namesUsed[nameIndex];
        delete nickNames[socket.id];
    });
}

