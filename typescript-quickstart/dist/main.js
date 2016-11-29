"use strict";
var greet_1 = require("./greet");
function hello(compiler) {
    console.log("Hello from " + compiler + " main.ts again");
}
function showHello(divName, name) {
    var elt = document.getElementById(divName);
    elt.innerText = greet_1.sayHello(name);
}
showHello("greeting", "Typescript");
