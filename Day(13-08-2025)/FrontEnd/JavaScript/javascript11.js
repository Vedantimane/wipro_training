// Create a  date object for 13 th of August 2030 and find out which day it would be.

let date = new Date(2025, 7, 13);

let days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
let day = days[date.getDay()];

// let day1 = date.getDay();

console.log(date);
console.log(day);