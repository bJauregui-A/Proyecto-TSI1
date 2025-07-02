function toggleForm() {
    const formDiv = document.getElementById("cursoForm");
    const isVisible = formDiv.style.display === "block";
    formDiv.style.display = isVisible ? "none" : "block";

    if (!isVisible) {
        window.scrollTo({
            top: formDiv.offsetTop - 100,
            behavior: 'smooth'
        });
    }
}
