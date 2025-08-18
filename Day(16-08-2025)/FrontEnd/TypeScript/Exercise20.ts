class Pair<T, U> {
    private value1: T;
    private value2: U;

    constructor(value1: T, value2: U) {
        this.value1 = value1;
        this.value2 = value2;
    }

    getData(): [T, U] {
        return [this.value1, this.value2];
    }
}


let p1 = new Pair<number, string>(1, "vedanti");
console.log(p1.getData()); 

let p2 = new Pair<boolean, string>(true, "tuple");
console.log(p2.getData()); 
