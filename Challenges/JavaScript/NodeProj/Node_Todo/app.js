//Done with the Udemy Course "Learn and Understand Node.js"

var express = require("express");
var app = express();
var mongoose = require("mongoose");
var config = require("./configFiles");
var dbSetup = require("./controllers/setupDBContrl");
var apiContrl = require("./controllers/apiContrl");

var port = process.env.PORT || 3000;


app.use("/assets", express.static(__dirname + "/public"));
app.set("view engine", "ejs");


mongoose.connect(config.getDBConnection());
dbSetup(app);
apiContrl(app);

app.listen(port);