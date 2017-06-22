function toggleMenu() {
    var sidebar = document.getElementById("sidebar");
    var rect = sidebar.getBoundingClientRect();
    if (rect.left === 0) {
        sidebar.className = "sidebar flex-container fixed flex-column flex-start hidesidebar"
    } else {
        sidebar.className = "sidebar flex-container fixed flex-column flex-start showsidebar"
    }
}

function toggleSearch() {
    var searchBar = document.getElementById("search-bar");
    var style = window.getComputedStyle(searchBar);
    
    if (style.display === "none" || style.display === "") {
        searchBar.className = "flex-item show"
    } else {
        searchBar.className = "flex-item hide"
    }
}

