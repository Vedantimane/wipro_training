// Ex7:Use the spread operator to merge two objects, obj1 and obj2, 
// into a new object mergedObj. obj1 = { a: 1, b: 2 } and obj2 = { b: 3, c: 4 }.
//  What will be the value of mergedObj?
 
// Ex8: Use the spread operator to create a new array newArr by combining arr1 = [1, 2, 3] and arr2 = [4, 5, 6] in between some additional elements. E.g[4,5,<content of arr1>,6,7, ,<content of arr2>,8,9]
 
// Ex9: Use the spread operator to pass elements of an array numbers = [1, 2, 3] as arguments to a function sum(a, b, c) that returns the sum of its arguments.
 
let obj =["a","b"];

let obj2=["c","d"];
let mergeObj=[...obj,...obj2]
console.log(mergeObj)