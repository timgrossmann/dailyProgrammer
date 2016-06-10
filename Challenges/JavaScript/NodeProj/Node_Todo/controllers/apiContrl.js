var Todo = require("../models/todoMod");
var bodyParser = require("body-parser");

module.exports = function (app) {

  app.use(bodyParser.json());
  app.use(bodyParser.urlencoded({ extended : true }));

  app.get("/api/todos", function (req, res) {

    Todo.find({}, function (err, respond) {

      if(err) throw err;

      res.send(respond);
    });

  });
  
  app.get("/api/todos/user=:user", function (req, res) {

    Todo.find({ username : req.params.user }, function (err, respond) {

      if(err) throw err;

      res.send(respond);
    });
  });

  app.get("/api/todos/id=:id", function (req, res) {

    Todo.findById({ _id : req.params.id }, function (err, respond) {

      if(err) throw err;

      res.send(respond);
    });
  });

  app.get("/api/todos/done=:done", function (req, res) {

    Todo.find( { done :  req.params.done }, function (err, respond) {

      if(err) throw err;

      res.send(respond);
    });
  });

  app.get("/api/todos/attch=:attch", function (req, res) {

    Todo.find( { hasAttch : req.params.attch } , function (err, respond) {

      if(err) throw err;

      res.send(respond);
    });
  });

  app.post("/api/todos", function (req, res) {

    if(req.body.id) {
      Todo.findByIdAndUpdate(req.body.id, {
        username: req.body.username,
        todo: req.body.todo,
        done: req.body.done,
        hasAttch: req.body.hasAttch
      }, function (err, respond) {

        if (err) throw err;
        res.send("Updated");
      });
    } else {

      var newTodo = Todo( {
        username : req.body.username,
        todo : req.body.todo,
        done : req.body.done,
        hasAttch : req.body.hasAttch
      });

      newTodo.save(function (err, respond) {

        if(err) throw err;

        res.send("Added");
      });

    }

  });

  app.delete("/api/todos/delete", function (req, res) {

    Todo.findByIdAndRemove(req.body.id, function (err, respond) {

      if(err) throw err;

      res.send("Deleted");
    });


  });

};