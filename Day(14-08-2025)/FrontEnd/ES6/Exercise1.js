// Ex 1 : Lets have an array of numbers , write an arrowfunction 
// to return the summation of all numbers in the array,

let array=[1,2,3,4,5,6,7,8];

let f= (a, array) => {
 for (let i of array) {
        a = a + i;
    }
    return a;
};
console.log(f(0, array));