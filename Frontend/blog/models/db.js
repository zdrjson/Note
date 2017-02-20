var settings = require('../setings'),
    Db = require('mongodb').Db,
    Connection = require('mongodb').Connection,
    Server = require('mongodb').Server;
module.exports = new Db(setings.db, new Server(settings.host, settings.port), {safe: true});