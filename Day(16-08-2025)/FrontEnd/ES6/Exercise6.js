// Ex 6 :  Create a movie object having movieName, movieLanguage,imdbRating 
// and using ES6 destructing split 
// them into individual values and print it.

let movie = {
    movieName: "Stuart Little",
    movieLanguage: "English",
    imdbRating: 8.8
};


let { movieName, movieLanguage, imdbRating } = movie;


console.log(movieName);       
console.log(movieLanguage);  
console.log(imdbRating);      
