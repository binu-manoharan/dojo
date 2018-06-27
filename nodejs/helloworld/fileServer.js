const http = require('http');
const fs = require('fs');

const hostname = 'localhost';
const port = 3000;

const server = http.createServer((req, res) => {
    fs.readFile('demofile1.html', (err, data) => {
        res.writeHeader(200, {'Content-Type': 'text/plain'});
	res.write(data);
	res.end();
    });

    fs.appendFile('mynewfile1.txt', 'Hello content!', (err) => {
	if (err)
	    throw err;

	console.log('Saved!');
    });

    fs.open('mynewfile2.txt', 'w', (err, file) => {
	if (err)
	    throw err;
	
	console.log('Saved!');
    });
});

server.listen(port, hostname, () => {
    console.log(`Server running at http://${hostname}:${port}/`);
});
