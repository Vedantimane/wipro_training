// Ex7: Create a list of persons having name , age and city of residence. Filter out the people who are eligible to vote.

let listofVoters =[
    {name: "vedanti",
        age:23,
        city:"mumbai"
    },

     {name: "john",
        age:13,
        city:"mumbai"
    },
];

let filteredvoters = listofVoters.filter(person => person.age >=18);
console.log("original",listofVoters);
console.log("filetered",filteredvoters);