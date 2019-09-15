function toggleMenu() {
    var sidebar = document.getElementById("sidebar");
    var style = window.getComputedStyle(sidebar);
    if (style.display === "none" || style.display === "") {
        sidebar.style.display = "block";
    } else {
        sidebar.style.display = "none";
    }
}

function myFunction(x) {
    x.classList.toggle("change");
    toggleMenu();
}