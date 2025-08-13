function addTask() {
    const taskText = document.getElementById("task").value;
 

    if (taskText === "") {
        console.log("Task cannot be empty");
        return;
    }

    const li = document.createElement("li");
    li.textContent = taskText + " ";

    const delBtn = document.createElement("button");
    delBtn.textContent = "Delete";
    delBtn.onclick = function() {
        li.remove();
    };

   li.append(delBtn);
document.getElementById("taskList").append(li);

document.getElementById("task").value = "";

}
