'use strick'
var fs = require("fs");
var rs = fs.createReadStream('sample.txt','utf-8');
rs.on('data',function(chunk){
    console.log('DATA:');
    console.log(chunk);
});
rs.on('end',function(){
    console.log('END');
});
rs.on('error',function(err){
    console.log('error:'+err);
})
//data表示数据已经可以读取了
//end 表示数据已经结束了
// error 表示事件出错