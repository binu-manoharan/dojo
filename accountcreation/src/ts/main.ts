import { sayHello } from "./greet";

function $1(elem: string) {
    return document.getElementById(elem);
}

function showHello(divName: string, name: string) {
    const elt = document.getElementById(divName);
    elt.innerText = sayHello(name);
}

// showHello("greeting", "Click the button below to go to Bob's convenience store page");

function showHelloToUser(): string {
    const username = $1('username');
    const password = $1('password');
    console.log(username + " " + password);
    event.preventDefault();
    return 2;
}