'use strick'
var fs = require("fs");
// var ws = fs.createWriteStream('sample.txt','utf-8');
// ws.write("开始写入\n");
// ws.write('end.');
// ws.end();

var ws = fs.createWriteStream('sample.txt');
ws.write(new Buffer("开始写入2\n",'utf-8'));
ws.write(new Buffer('end.','utf-8'));
ws.end();
//第一种为使用stream写入文本数据
//第二种为使用Stream写入二进制数据