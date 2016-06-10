var Clarifai = require('clarifai');

process.env.CLARIFAI_ID = "C19wWgY6_y1iw7x6O4R-xPi5XQ8CGwEEcyWbV6z8";
process.env.CLARIFAI_SECRET = "SWdun2nBu7vHF-q721I_AKZsJ1QMATJHwF5r6-w4";

var client = new Clarifai();


////Tag get
/*
client.getAccessToken(function(err, accessToken) {
    

    client.tagFromUrls('image', "http://www.clouds365.com/blog/wp-content/uploads/2013/01/1-29-13-StormOverFarm.jpg", function(err, results) {

        console.log(results);
        
        
}, ["en"]);
     
});

*/



////Color get
/*
var https = require("https");

client.getAccessToken(function(err, accessToken) {
    
    https.get(`https://api.clarifai.com/v1/color/?access_token=${accessToken}&url=http://www.patrasevents.gr/imgsrv/f/full/613802.png`, (res) => {
        
        res.setEncoding('utf8');
    
        res.on("data", (d) => {
            console.log(d);
        })
        
        
        
    }).on("error", (e) => {
        console.log(e);
    });
    
     
});
*/