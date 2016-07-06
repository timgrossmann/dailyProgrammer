var https = require('https');
var cheerio = require('cheerio');

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


download(url, function (data) {
    if (data) {
        
        var cio = cheerio.load(data); 
        
        cio('a.storylink').each(function (i, e) {
            console.log(cio(e).attr('href'));
        });
        
       
    } else {
        console.log('error');
    }
});