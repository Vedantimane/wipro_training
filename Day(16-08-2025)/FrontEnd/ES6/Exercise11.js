// Ex11: Create a function separateFirstRest that takes any number of arguments using the rest operator.
//  It should return an object with first (the first argument)
//  and rest (an array of remaining arguments).


f=(a, ...arr)=> {
  return {
    first: a,
    rest: arr
  };
}

console.log(f(1,2,3,4,5));
