
let names = ["Vedanti", "Aarav", "Priya", "John", "Suresh", "Anita"];

let filteredNames = names.filter(name => name.length > 5);

let upperCaseNames = filteredNames.map(name => name.toUpperCase());

console.log("Original Names:", names);
console.log("Filtered & Uppercase:", upperCaseNames);
