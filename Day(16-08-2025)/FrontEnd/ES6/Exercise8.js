// Ex8: Use the spread operator to create a new array newArr by combining arr1 = [1, 2, 3] and arr2 = [4, 5, 6] in 
// between some additional elements. E.g[4,5,<content of arr1>,6,7, ,<content of arr2>,8,9]

let arr=[1,2,3];
let arr2=[4,5,6];

let arr3=["vedu",...arr,"mane",...arr2]
console.log(arr3);