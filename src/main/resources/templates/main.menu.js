function pagesLogin(){
    window.location.href = "login/login.html";
}

const loginButton = document.getElementById("Login");

loginButton.addEventListener("click", pagesLogin);

