function updateCount() {
    let remaining = 50 - document.getElementById("input1").value.length;
    document.getElementById("charCount").innerText = remaining + " characters remaining";
}
