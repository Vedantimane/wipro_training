function printEmployee(employees) {
    console.log("Emplyee List");
    employees.forEach(function (emp) {
        console.log("ID: ".concat(emp.employeeId, ", Name: ").concat(emp.employeeName, ", Salary: ").concat(emp.employeeSalary));
    });
    return employees.length;
}
var empList = [
    { employeeId: 1, employeeName: "Vedanti", employeeSalary: 50000 },
    { employeeId: 2, employeeName: "John", employeeSalary: 40000 },
    { employeeId: 3, employeeName: "Alice", employeeSalary: 30000 },
];
var count = printEmployee(empList);
console.log("Total Employees:", count);
