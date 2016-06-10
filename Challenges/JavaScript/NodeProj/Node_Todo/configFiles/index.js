var config = require("./config");

module.exports = {

  "getDBConnection" : function getDBConnection() {
      return `mongodb://${config.username}:${config.pwd}@ds013004.mlab.com:13004/node_testing`;
  }
  
}