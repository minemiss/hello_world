var http = require('http');
var fs = require('fs');
var path = require('path');
var mime = require('mime');
var cache = {};

function send404(response){
    response.writeHead(404,{'Content-Type':'text/plain'});
    response.write('Error 404:resource not found.');
    response.end();
}

function sendFile(response,filePath,fileContents){
    response.writeHead(200,{"content-type":mime.lookup(path.basename(filePath))});
    response.end(fileContents);
}

function serveStatic(response,cache,absPath){//文件是否存在内存中
    if(cache[absPath]){
        sendFile(response,absPath,cache[absPath]);//从内存中返回文件
    }else{
        fs.exists(absPath,function(exists){//检查文件存在
            if(exists){
                fs.readFile(absPath,function(err,data){//从硬盘中读文件
                    if(err){
                        send404(response);
                    }else{
                        cache[absPath]= data;
                        sendFile(response,absPath,data);
                    }
                });
            }else{
                send404(response);
            }
        });
    }
}

var server = http.createServer(function(request,response){
    var filePath = false;
    if(request.url  == '/'){
        filePath = 'chatroom/public/index.html';//返回默认HTML
    }else{
        filePath = 'chatroom/public'+request.url;//将文件路径转化为相对路径
    }
    var absPath = './'+filePath;
    serveStatic(response,cache,absPath);//返回静态文件
}); 


server.listen(3000,function(){
    console.log("server listening on port 3000");
});
var chatServer = require('./lib/chat_server');
chatServer.listen(server);
