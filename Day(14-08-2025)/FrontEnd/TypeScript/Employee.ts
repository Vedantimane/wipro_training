interface Employee {
    employeeName:string;
    employeeId:number;
    employeeSalary:number;

}

function printEmployee(employees:Employee[]):number{
    console.log("Emplyee List");
    employees.forEach(emp =>{
        console.log(`ID: ${emp.employeeId}, Name: ${emp.employeeName}, Salary: ${emp.employeeSalary}`);
    });

    return employees.length;
}

let empList: Employee[] = [
    { employeeId: 1, employeeName: "Vedanti", employeeSalary: 50000 },
     { employeeId: 2, employeeName: "John", employeeSalary: 40000 },
    { employeeId: 3, employeeName: "Alice", employeeSalary: 30000 },
];

let count = printEmployee(empList);
console.log("Total Employees:", count);