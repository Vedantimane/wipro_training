let str = "madame";
let reversedStr = ""; 

for (let i = str.length - 1; i >= 0; i--) {
    reversedStr += str[i];
}

if (str === reversedStr) {
    console.log("palindrome");
} else {
    console.log("non palindrome");
}
