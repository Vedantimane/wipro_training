let result = 0;


const num1 = document.getElementById("num1");
const num2 = document.getElementById("num2");
const resultDisplay = document.getElementById("result");

function add() {
    let num11 = Number(num1.value);
    let num22 = Number(num2.value);
    result = num11 + num22;
    resultDisplay.textContent = result;
}

function minus() {
   
    result = num1.value - num2.value;
    resultDisplay.textContent = result;
}

function multiply() {
  
    result = num1.value * num2.value;
    resultDisplay.textContent = result;
}

function divide() {
   
    if (num2.value == 0) {
        resultDisplay.textContent = "Cannot divide by zero!";
    } else {
        result = num1.value / num2.value;
        resultDisplay.textContent = result;
    }
}
