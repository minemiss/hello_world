function divEscapedContentElement(message){//可疑文本显示
    return $('<div></div>').text(message);
}
function divSystemContentElement(message){//授信数据显示
    return $('<div></div>').html('<i>'+message+'</i>');
}

function processUserInput(chatApp,socket){//处理原始用户输入
    var message = $('#send-message').val();
    var systemMessage;
    if(message.charAt(0)=='/'){//如果已/开头的聊天指令作为命令处理
        systemMessage = chatApp.processCommand(message);
        if(systemMessage){
            $('#messages').append(divSystemContentElement(systemMessage));
        }
    }else{
        chatApp.sendMessage($('#room').text(),message);//非命令输入广博给其他用户
        $('#messages').append(divEscapedContentElement(message));
        $('#messages').scrollTop($('messages').prop('scrollHeight'));
    }
    $('#send-message').val('');
}

var socket = io.connent();
$(document).ready(function(){
    var chatApp = new Chat(socket);
    socket.on('nameResult',function(result){//显示更名结果
        var message;
        if(result.success){
            message='you are now known as '+result.name+'.';
        }else{
            message = result.message;
        }
        $('#messages').append(divSystemContentElement(message));
    });
    socket.on('joinResult',function(result){//显示房间变更结果
        $('#room').text(result.room);
        $('#messages').append(divSystemContentElement('Room changed'));
    });
    socket.on('message',function(message){//显示接受到的消息
        var newElement = $('<div></div>').text(message.text);
        $('#messages').append(newElement);
    });
    socket.on('rooms',function(rooms){//显示可用房间列表
        $('#room-list').empty();
        for(var room in rooms){
            room = room.substring(1,room.length);//可用房间列表
            if(room!=''){
                $('#room-list').append(divEscapedContentElement(room));
            }
        }
        $('#room-list div').click(function(){//点击列表加入房间
            chatApp.processCommand('/join'+$(this).text());
            $('#send-message').focus();
        });
    });
    setInterval(function(){//定期请求房间列表
        socket.emit('rooms');
    },1000);
    $('#send-message').focus();
    $('#send-form').submit(function(){
        processUserInput(chatApp,socket);
        return false;
    });
});