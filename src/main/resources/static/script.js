document.addEventListener("DOMContentLoaded", function () {
    const formTitle = document.getElementById("form-title");
    const authForm = document.getElementById("auth-form");
    const toggleFormText = document.getElementById("toggle-form");
    let isLogin = true;

    toggleFormText.addEventListener("click", function () {
        isLogin = !isLogin;
        if (isLogin) {
            formTitle.textContent = "Login";
            toggleFormText.innerHTML = "Don't have an account? <span>Sign Up</span>";
        } else {
            formTitle.textContent = "Sign Up";
            toggleFormText.innerHTML = "Already have an account? <span>Login</span>";
        }
    });
});
