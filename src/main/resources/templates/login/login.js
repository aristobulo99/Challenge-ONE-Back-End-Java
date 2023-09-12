
function userMenu(){
    var usuario = userInput.value;
    var contraseña = paswordInput.value;
    fetch("http://localhost:8080/auth",{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json' 
        },
        body: JSON.stringify({usuario, contraseña}) 
    }).then(response => {
        if (!response.ok) {
            throw new Error('Error al iniciar sesión.');
        }
        return response.json();
    }).then(data => {
        if (data === true) {
            window.location.href = "../userMenu/userMenu.html";
          } else {
            alert('Usuario y Contraseña inválidos')
          }
    }).catch(error => {
        console.error('Error:', error);
    });
}

const userInput = document.getElementById("usuario");
const paswordInput = document.getElementById("password");

const getInButton = document.getElementById("getIn");

getInButton.addEventListener("click", userMenu);
