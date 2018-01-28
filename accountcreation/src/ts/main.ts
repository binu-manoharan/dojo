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
    
    const greeting = $1('greeting');
    if (greeting !== null) {
        greeting.innerText = `As per Bobs request we've \
        created an application to help him manage his convenience store. \
        Click the link below to go to Bob's convenience store page`;
    }
    const indexButton = $1('indexButton');
    if (indexButton !== null) {
        indexButton.onclick = () => {
            window.location.href = './login.html'
        }
    }
}

function initialiseLoginPage() {
    const loginForm = $1('loginform');
    if(loginForm !== null) {
        loginForm.onsubmit = (event: Event) => {
            const username = $1('username') as HTMLInputElement;
            const password = $1('password') as HTMLInputElement;
            if (username.value === 'admin') {
                sessionStorage.setItem('username', username.value);
                sessionStorage.setItem('password', password.value);
                window.location.href = './adminpage.html';
            } else {
                const usernameError = $1('username-error');
                usernameError.innerText = 'Invalid username';
                username.classList.add('is-danger');
            }
            event.preventDefault();
            
        }
    }
}

function initialiseAdminPage() {
    const username = sessionStorage.getItem('username');
    const welcomeMessage = `Welcome ${username}`;
    const welcomeMessageDiv = $1('welcome-message');
    if (welcomeMessageDiv !== null) {
        welcomeMessageDiv.innerText = welcomeMessage;
        document.title = welcomeMessage;
    }
}

function initaliseApp() {
    intialiseIndexPage();
    initialiseLoginPage();
    initialiseAdminPage();
}

window.onload = initaliseApp;