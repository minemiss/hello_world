'use strick'

var fs = require('fs'),
    url = require('url'),
    path = require('path'),
    http = require('http');
    
    var  root = path.resolve(process.argv[2]||'.');
    console.log('Static root dir:'+root);

    var server = http.createServer(function(request,response){
        console.log(url.parse(request.url));
        var pathname = url.parse(request.url).pathname;
        var filepath = path.join(root,pathname);
        fs.stat(filepath,function(err,stats){
            if(!err&&stats.isFile()){
                console.log('200'+request.url);
                response.writeHead(200);
                fs.createReadStream(filepath).pipe(response);
            }else{
                console.log('404'+request.url);
                response.writeHead(404);
                response.end('404 NOT FOUND');
            }
        });
    });
    server.listen(8080);
    console.log('server is running at http://127.0.0.1:8080/');