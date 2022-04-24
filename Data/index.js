const DATA_USER = require('./Data_User.json')
const DATA_CAST = require('./Data_Cast.json')
const DATA_MOVIE = require('./Data_Movie.json')
const DATA_COMMENT = require('./Data_Comment.json')
const DATA_SHOWTIMES = require('./Data_ShowTimes.json')
const DATA_SYSTEM_CINEMA = require('./Data_System_Cinema.json')
const DATA_THEATER_CLUSTER = require('./Data_Theater_Cluster.json')

console.log('DATA_USER', DATA_USER.length)
console.log('DATA_CAST', DATA_CAST.length)
console.log('DATA_MOVIE', DATA_MOVIE.length)
console.log('DATA_COMMENT', DATA_COMMENT.length)
console.log('DATA_SHOWTIMES', DATA_SHOWTIMES.length)
console.log('DATA_SYSTEM_CINEMA', DATA_SYSTEM_CINEMA.length)
console.log('DATA_THEATER_CLUSTER', DATA_THEATER_CLUSTER.length)


/*** 
 * 
DATA_USER: target 30 item, about: modetator 1, admin 5, user: 24
 *
DATA_CAST: target 600 item, each movie has 10 actors
 *
DATA_MOVIE: target 60 item
 *
DATA_COMMENT: target 300 item, each movie has 5 comment
 *
DATA_SHOWTIMES: target 600 item, each theater cluster has 10 showtimes
 *
DATA_THEATER_CLUSTER: target 60 item, each system cinema has 7- 10 theater cluster
 *
DATA_SYSTEM_CINEMA: target 6 item
 *
***/



