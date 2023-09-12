
function guardarReserva(){
    const fecha1Input = document.getElementById('fecha-ingreso');
    const fecha2Input = document.getElementById('fecha-salida');
    const tipaDePago = document.getElementById('forma-de-pago');
    const valorDeReserva = document.getElementById("valor-a-pagar");

    switch (true) {
        case fecha1Input.value == "":
            alert('Por favor ingrese la FECHA DE CHECK IN');
            break;
        case fecha2Input.value == "":
            alert('Por favor ingrese la FECHFECHA DE CHECK OUT');
            break;
        case tipaDePago.value == "":
            alert('Por favor seleccione una forma de pago');
            break;
        case valorDeReserva.value == "$":
            alert('Por favor ingrese el valor de la reserva');
            break;    
        default:
            let registrarReserva = document.getElementById("registrar-reserva");
            let seleccionDeHuesped = document.getElementById("seleccion-huesped");
            registrarReserva.style.display = "none";
            seleccionDeHuesped.style.display = "flex"
            break;
    }
}


const getInButton = document.getElementById("click-siguiente");

getInButton.addEventListener("click", guardarReserva);