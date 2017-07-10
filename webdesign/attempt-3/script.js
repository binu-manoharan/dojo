function sayHello() {
    alert("hello!");
}

function togglesidebar() {
    var sidebar = $1("sidebar");
    var rect = sidebar.getBoundingClientRect();
    if (rect.left === 0) {
        sidebar.className = "hidesidebar";
    } else {
        sidebar.className = "showsidebar";
    }
}