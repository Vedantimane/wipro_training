// Ex10: Write a function sumNumbersusing the rest operator to take any number of arguments and return their sum.
 
// Ex11: Create a function separateFirstRest that takes any number of arguments using the rest operator. It should return an object with first (the first argument)
//  and rest (an array of remaining arguments).

function sum(...nums) {
  return nums.reduce((sum, value) => sum + value, 0);
}

console.log(sum(1, 2, 3, 4, 5)); 
