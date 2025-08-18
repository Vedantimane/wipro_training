// Ex13:Create a module operations.js that exports two functions: multiply(a, b) and divide(a, b).
//  Handle division by zero in divide. Import and test these in calc.js.

export function multiply(a, b) {
    return a * b;
}
export function divide(a, b) {

    return b!=0? a/b:"you cant divide by 0";
}