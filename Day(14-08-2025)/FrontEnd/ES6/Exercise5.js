// Ex5: Create an ES6 class Vehicle with:
// A constructor taking make, model, and year.
// A method getInfo() returning a string with make, model, and year.
// Extend Vehicle with a subclass Car that adds a numDoorsproperty and overrides getInfo() to include numDoors.

class vehicle{
    constructor(make, model, year){

        this.make=make;
        this.model=model;
        this.year=year;

    }

    getInfo(make, model, year){
        return `Vehicle Make: ${make} Vehicle model: ${model} Vehicel Year: ${year}`
    }

}

class Car extends vehicle {
    constructor(make, model, year, numDoors) {
        super(make, model, year); 
        this.numDoors = numDoors;
    }

  
    getInfo() {
        return `${super.getInfo()}, Number of Doors: ${this.numDoors}`;
    }
}
let newcar = new vehicle("tata","ambani",2000);

let newcar2 = new Car("tata","ambani",2000,2);

console.log(newcar);
console.log(newcar2);