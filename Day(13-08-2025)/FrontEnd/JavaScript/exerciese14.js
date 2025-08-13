let cities = ["mumbai", "pune", "gujrat", "satara", "delhi"];
console.log(cities);

function addCity() {
    let dropdown = document.getElementById("cityDropdown");
    

  let sortedCities = cities.sort();
   for (let city of sortedCities) {
        let option = document.createElement("option");
        option.text = city;
        dropdown.add(option);
    }
}
