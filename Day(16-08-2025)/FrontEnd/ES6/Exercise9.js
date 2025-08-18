// Ex9: Use the spread operator to pass elements of an array numbers = [1, 2, 3] as 
// arguments to a function sum(a, b, c) that returns the sum of its arguments.


function sum(a,b,c) {
  
  return a+b+c;
}

let arr = [1, 2, 3, 4, 5,1];
console.log(sum(...arr));
