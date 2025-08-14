// Ex12:Create a module user.js that exports a class User with a constructor taking name and a method getName(). Import and use User in app.js.
 
// Ex13:Create a module operations.js that exports two functions: multiply(a, b) and divide(a, b). Handle division by zero in divide. Import and test these in calc.js.

export class User {
    constructor(name) {
        this.name = name;
    }

    getName() {
        return `Hello ${this.name}`;
    }
}