import { sayHello } from "./greet";
import { createGraph } from "./blah";

function hello(compiler: string) {
    console.log(`Hello from ${compiler} main.ts again`);
}

function showHello(divName: string, name: string) {
    const elt = document.getElementById(divName);
    elt.innerText = sayHello(name) + ' ' + new Date();
    let newDiv = document.createElement("Div");
    elt.appendChild(newDiv)
}

showHello("greeting", "Typescript");