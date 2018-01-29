function $1(elem: string) {
    return document.getElementById(elem);
}

function showHelloToUser() {
    const username = $1('username');
    const password = $1('password');
    console.log(username + " " + password);
    event.preventDefault();
}

function intialiseIndexPage() {
    const welcomePage = $1('welcome-page');
    if (welcomePage === null) {
        return;
    }

    const greeting = $1('greeting');
    greeting.innerText = `As per Bobs request we've \
    created an application to help him manage his convenience store. \
    Click the link below to go to Bob's convenience store page`;
    const indexButton = $1('indexButton');
    indexButton.onclick = () => {
        window.location.href = './login.html'
    }
}

function initialiseLoginPage() {
    const loginPage = $1('login-page');
    if (loginPage === null) {
        return;
    }

    const loginForm = $1('loginform');
    loginForm.onsubmit = (event: Event) => {
        const username = $1('username') as HTMLInputElement;
        const password = $1('password') as HTMLInputElement;
        if (username.value === 'admin') {
            sessionStorage.setItem('username', username.value);
            sessionStorage.setItem('password', password.value);
            window.location.href = './home.html';
        } else {
            const usernameError = $1('username-error');
            usernameError.innerText = 'Invalid username';
            username.classList.add('is-danger');
        }
        event.preventDefault();
    }
}

function initialiseHomePage() {
    const homePage = $1('home-page');
    if (homePage === null) {
        return;
    }

    const username = sessionStorage.getItem('username');
    const welcomeMessage = `Welcome ${username}`;
    const welcomeMessageDiv = $1('welcome-message');
    welcomeMessageDiv.innerText = welcomeMessage;
    document.title = welcomeMessage;
}

function initaliseApp() {
    intialiseIndexPage();
    initialiseLoginPage();
    initialiseHomePage();
}

window.onload = initaliseApp;