// var onlyNames = litsEmployee.reduce((acc, emp) => {
//   acc.push(emp.name);
//   return acc;
// }, []);

var litsEmployee = [
  {
    id:1,
    name: "John Doe",
    age: 30,
    position: "manager",
    salary:45000
  },
  {
    id:2,
    name: "Mark Freeman",
    age: 32,
    position: "Software Engineer",
    salary:45000
  },
  {
    id:3,
    name: "Patricia  Dark",
    age: 35,
    position: "manager",
    salary:45009
  },
];



var totalManagerSalary = litsEmployee.filter(emp => emp.position ==="manager").reduce((acc, emp) => {

    acc = acc + emp.salary;
  
  return acc; 
}, 0);

console.log("Total Manager Salary:", totalManagerSalary);