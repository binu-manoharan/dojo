import {sayHello } from "./greet";

function hello(compiler: string) {
    console.log(`Hello from ${compiler} main.ts again`);
}

hello("Typescript");

console.log(sayHello("Typescript"));