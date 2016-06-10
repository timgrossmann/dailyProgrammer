var Todos = require("../models/todoMod");

module.exports = function (app) {

  app.get("/api/setupDBContr", function (req, res) {

    //inital DB Seed
    var dbSeed =
      [
        {
          "username"  : "Tim",
          "todo"      : "Buy Pizza",
          "done"      : false,
          "hasAttch"  : false
        },
        {
          "username"  : "Frank",
          "todo"      : "Drink Beer",
          "done"      : false,
          "hasAttch"  : true
        },
        {
          "username"  : "John",
          "todo"      : "Feed Cat",
          "done"      : false,
          "hasAttch"  : false
        },
        {
          "username"  : "Sam",
          "todo"      : "Get Car",
          "done"      : true,
          "hasAttch"  : true
        }
      ];

    Todos.create(dbSeed, function (err, respond) {
      if(err) console.log(err);

      res.send(respond);
    });

  });

};