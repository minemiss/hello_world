'use strick'

var fs = require('fs'),
    url = require('url'),
    path = require('path'),
    http = require('http');
    
    var  root = path.resolve(process.argv[2]||'.');
    console.log('Static root dir:'+root);

    var server = http.createServer(function(request,response){
        var pathname = url.parse(request.url).pathname;
        var filepath = path.join(root,pathname);
        var defaultpath = [filepath,path.join(filepath,'default.html'),path.join(filepath,'index.html')];
        var f = function(defaultpath,index){
            fs.stat(defaultpath[index],function(err,stats){
                if(!err&&stats.isFile()){
                    console.log('200'+request.url);
                    response.writeHead(200);
                    fs.createReadStream(defaultpath[index]).pipe(response);
                }else{
                    if(!err||(err&&index<defaultpath.length-1)){  
                        f(defaultpath,index+1);
                    }else{
                        console.log('404'+request.url);
                        response.writeHead(404);
                        response.end('404 NOT FOUND');
                    }
                  
                }
            });
        }
       f(defaultpath,0);
    });
    server.listen(8080);
    console.log('server is running at http://127.0.0.1:8080/');