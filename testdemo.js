'use strict';

// var xiaoming = {
//     name: '小明',
//     age: 14,
//     gender: true,
//     height: 1.65,
//     grade: null,
//     'middle-school': '\"W3C\" Middle School',
//     skills: ['JavaScript', 'Java', 'Python', 'Lisp'],
//     toJSON:function(){
//         return {
//             'Name':this.name,
//             'Age':this.age
//         };
//     }
// };

/*function convert(key,value){
    if(typeof value == 'string'){
        return value.toUpperCase();
    }
    return value;
}
var s = JSON.stringify(xiaoming,convert,' ');*/


var obj = JSON.parse('{"name":"小明","age":14}',function(key,value){
    if(key ==='name'){
        return value+'同学';
    }
    return value;
});
console.log(JSON.stringify(obj));


// var url = ' https://weather-ydn-yql.media.yahoo.com/forecastrss';
// // 从远程地址获取JSON:
// $.getJSON(url, function (data) {
//     var city = data.query.results.channel.location.city;
//     var forecast = data.query.results.channel.item.forecast;
//     var result = {
//         city: city,
//         forecast: forecast
//     };
//     alert(JSON.stringify(result, null, '  '));
// });
// function Student(props){
//     this.name = props.name;
// }
// function PrimaryStudent(props){
//     Student.call(this,props);
//     this.grade = props.grade;
// }
// function F(){}
// F.prototype = Student.prototype;
// PrimaryStudent.prototype = new F();
// PrimaryStudent.prototype.constructor = PrimaryStudent;
// PrimaryStudent.prototype.getGrade = function(){
//     return this.grade;
// }
// var xiaoming = new PrimaryStudent({
//     name:'xiaoming',
//     grade:2
// });
// xiaoming.name;
// xiaoming.grade;

// xiaoming.__proto__===PrimaryStudent.prototype;
// xiaoming.__proto__===Student.prototype;
// if(xiaoming instanceof PrimaryStudent)
// {
//     console.log("a");
// }
// if(xiaoming instanceof Student)
// {
//     console.log("b");
// }


