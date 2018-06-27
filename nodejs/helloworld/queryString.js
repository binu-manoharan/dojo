const http = require('http');
const myDate = require('./myfirstmodule');
const url = require('url');

const hostname = 'localhost';
const port = 3000;

const server = http.createServer((req, res) => {
    const queryString = url.parse(req.url, true).query;
    const text = `${queryString.url} ${queryString.year} ${queryString.month}` 
    res.writeHeader(200, {'Content-Type': 'text/plain'});
    res.write('The date and time are currently: ' + myDate.myDateTime());
    res.write(`\n\nHello World! from ${myDate.num}\n`);
    res.write(`\n - ${text}\n`);
    res.end();
});

server.listen(port, hostname, () => {
    console.log(`Server running at http://${hostname}:${port}/`);
});
