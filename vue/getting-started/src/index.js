if (process.env.NODE_ENV !== 'production') {
    console.log('We are not in production mode');
}

function getComponent() {
    return import(/* webpackChunkName: "lodash" */ 'lodash')
        .then(({ default: _ }) => {
            var element = document.createElement('div');

            element.innerHTML = _.join(['Hello', 'webpack'], ' ');

            return element;
        }).catch(error => 'Error occurred during component loading')
}

getComponent().then(component => {
    document.body.appendChild(component);
})
