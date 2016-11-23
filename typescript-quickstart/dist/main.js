"use strict";
var greet_1 = require("./greet");
function hello(compiler) {
    console.log("Hello from " + compiler + " main.ts");
}
hello("Typescript");
console.log(greet_1.sayHello("Typescript"));
