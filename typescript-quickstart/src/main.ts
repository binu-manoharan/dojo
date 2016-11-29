import {sayHello } from "./greet";

function hello(compiler: string) {
    console.log(`Hello from ${compiler} main.ts again`);
}

function showHello(divName: string, name: string) {
    const elt = document.getElementById(divName);
    elt.innerText = sayHello(name);
}

showHello("greeting","Typescript");