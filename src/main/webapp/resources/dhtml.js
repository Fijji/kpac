function toggleElementVisibility(elementId) {
    var element = document.getElementById(elementId);
    if (element.style.display === "none") {
        element.style.display = "block";
    } else {
        element.style.display = "none";
    }
}

function validateForm() {
    var title = document.getElementById("title").value;
    var description = document.getElementById("description").value;
    if (title === "" || description === "") {
        alert("Please fill in all fields.");
        return false;
    }
    return true;
}
