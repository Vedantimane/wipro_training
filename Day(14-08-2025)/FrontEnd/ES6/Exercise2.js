// Ex2: Exercise: Write an ES6 function doubleNumbers that takes an array of numbers as input and returns a new array with each number doubled using map().
// Example Input: [1, 2, 3, 4]
// Example Output: [2, 4, 6, 8]

let array=[1,2,3,4]

let f=(array)=>{
  return array.map(i => i * 2); 
}

console.log(array);
console.log(f(array));