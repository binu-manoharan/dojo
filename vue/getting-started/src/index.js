import _ from 'lodash';
import './style.css';
import BackgroundImage from './one-piece.jpeg';

function component() {
    let element = document.createElement('div');

    element.innerHTML = _.join(['Hello', 'webpack'], ' ');
    element.classList.add('hello');

    var myImage = new Image();
    myImage.src = BackgroundImage;

    element.appendChild(myImage);

    return element;
}

document.body.appendChild(component());