const express = require("express");
const path = require("path");
const bodyPar = require("body-parser");
const nodemail = require("nodemailer");

var app = express();

app.set("views", path.join(__dirname, "views"));
app.set("view engine", "jade");

app.use(bodyPar.json());
app.use(bodyPar.urlencoded({extended: false}));
app.use(express.static(path.join(__dirname, "public")));

app.get("/", (req, res) => {
    res.render("index", {"title": "Welcome"});
});

app.get("/about", (req, res) => {
    res.render("about", {"title": "About"});
});

app.get("/contact", (req, res) => {
    res.render("contact", {"title": "Contact Us"});
});

app.post("/contact/send", (req, res) => {
    
    var transporter = nodemail.createTransport({
        service: "Gmail",
        auth: {
            user: "grossmanntim1994@gmail.com",
            pass: "Hawaitim1994!"
        }
    });
    
    var options = {
        from: "Tim Großmann <grossmanntim1994@gmail.com>",
        to: "t.grossmann1994@web.de",
        subject: "Testing Nodemailer",
        text: req.body.name + " " + req.body.email + " " + req.body.message
    };
    
    transporter.sendMail(options, (error, info) => {
        if(error) {
            console.log(error);
            res.redirect("/");
        } else {
            console.log(info.response);
            res.redirect("/");
        }
    });
    
});

app.listen(3000);
console.log("running");