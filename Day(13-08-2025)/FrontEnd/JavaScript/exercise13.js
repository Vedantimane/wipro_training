function validateEmail() {
    const email = document.getElementById("email").value;
    const pattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (email === "") {
        console.log("Email cannot be empty");
        return false;
    } else if (pattern.test(email)) {
        // console.log("Valid email");
        return true;
    } else {
        console.log("Invalid email");
        return false;
    }
}

function validatePassword() {
    const password = document.getElementById("password").value;

    if (password === "") {
        console.log("Password cannot be empty");
        return false;
    } else {
        // console.log("Valid password");
        return true;
    }
}

function validateForm() {
    const emailValid = validateEmail();
    const passwordValid = validatePassword();

    if (emailValid && passwordValid) {
        console.log("Login successful");
    } else {
        console.log("Login failed");
    }
}
