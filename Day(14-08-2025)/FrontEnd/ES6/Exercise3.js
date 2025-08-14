class Util {
    getDate(){
      let d = new Date();

     let d1 = d.toDateString();
     return d1;
    }

    getPIValue(){
        return Math.PI;
    }

    convertC2F(Centigrade){
       return   (Centigrade * 1.8) + 32;    
    }

    getFibonacci(num) {
    let n1 = 0, n2 = 1, nextTerm;
    let fibNumbers = [];

    for (let i = 1; i <= num; i++) {
        fibNumbers.push(n1);
        nextTerm = n1 + n2;
        n1 = n2;
        n2 = nextTerm;
    }

    return fibNumbers;
}

    }

let u =new Util();

console.log(u.getDate());
console.log(u.getPIValue());
console.log(u.convertC2F(0));
console.log(u.getFibonacci(6));