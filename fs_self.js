'use strick'
//为什么非得把this保存起来呢？这是因为，内部函数（比如本函数里面包含的两个匿名函数）
//在搜索this变量时，只会搜索到属于它自己的this，而不会搜索到包含它的那个函数的this。
//所以，为了在内部函数能使用外部函数的this对象，要给它赋值了一个名叫self的变量。
var fs = require('fs');
function FileObject(){
    this.filename='';
    var self=this;
    this.file_exists = function(callback){
        console.log("about to open"+this.filename);
        fs.open(this.filename,'r',function(err,handle){
            if(err){
                console.log("Can't open:"+self.filename);
                console.log("Can't open:"+this.filename);
                callback(err);
                return;
            }
            fs.close(handle,function(){});
            callback(null,true);
        });
    };
}

var fo = new FileObject();
fo.filename = "abc..ooo";
fo.file_exists(function(err,results){
    if(err){
        console.log("aaaa"+JSON.stringify(err));
        return;
    }
    console.log("file exists!");
});