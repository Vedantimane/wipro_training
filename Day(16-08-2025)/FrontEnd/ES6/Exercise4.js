// Ex4: Create an ES6 class BankAccountwith:
// A constructor taking accountNumber and balance.
// A method deposit(amount) to add money to the balance.
// A method withdraw(amount) to subtract money if balance is sufficient.

class BankAccount{

    
    constructor(accountNumber, balance){

        this.accountNumber=accountNumber;
        this.balance=balance;

    }

    deposit(amount){
        return this.balance +=amount;
    }

    withdraw(amount){
        if(this.balance<amount){
            console.log("balance is not enough")
          
        }else{
            return this.balance -=amount;
        }
          return this.balance;
    }
}

let newacc = new BankAccount("Bank101",80000);

console.log(newacc.deposit(500));
console.log(newacc.withdraw(700));
