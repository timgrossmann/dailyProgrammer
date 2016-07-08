var https = require('https');
var express = require('express');
var cheerio = require('cheerio');

var app = express();

var url = 'https://news.ycombinator.com';

function download (url, callback) {
    
    https.get(url, function (res) {
        
        var data = '';
        res.on('data', function (chunk) {
            data += chunk;
        });
        
        res.on('end', function () {
            callback(data);
        });
        
    }).on('error', function () {
        callback(null);
    });
    
}


app.get('/', function (req, res) {
    
    
    res.writeHead(200, {
    'Content-Type': 'text/html'
    });

        for(var i = 1; i <= 10; i++) {

            download(`${url}?p=${i}`, function (data) {
            if (data) {

                var cio = cheerio.load(data); 

                cio('a.storylink').each(function (i, e) {
                    res.write(`<h4>${cio(e).text()}</h4>`);
                    res.write("- ");
                    res.write(`<a href="${cio(e).attr('href')}" target="_blank">${cio(e).attr('href')}</a>`);
                    res.write("<hr />");
                });


            } else {
                console.log('error');
            }

        });     
           
    }
      
});

app.listen(3000);

