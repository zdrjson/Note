/**
 * Created by json on 16/5/28.
 */

// var person ={
//     name:"iwen",
//     age:30,
//     eate:function () {
//         alert("能吃")
//     }
// }
//
// // person.height = 100;
// alert(person.name);


function Person() {
    
}
Person.prototype={
    name:"iwen",
    age:30,
    eat:function () {
        alert("我在吃")
    }
}

var p = new Person();
// p.age
// p.name
// p.eat()