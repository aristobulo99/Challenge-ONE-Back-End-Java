const url = 'http://localhost:8080/huespedes/huespedes';
const lista = document.getElementById('lista');
let identificadorRespuest = 0;

fetch(url)
.then(response => {
    if (!response.ok) {
    throw new Error('Error en la solicitud.');
    }
    return response.json();
})
.then(data => {
    data.forEach(
        item => {
            const itemList = document.createElement('a');
            itemList.className = 'list-group-item list-group-item-action';
            const itemContent = document.createElement('div');
            itemContent.className = 'text-list';
            const itemSubTitle = document.createElement('h2');
            itemSubTitle.className = 'sub-title';
            const itemTextDescrip = document.createElement('p');
            itemTextDescrip.className = 'text-descripcion';
            const itemContent2 = document.createElement('div');
            itemContent2.className = 'text-list';
            const itemSubTitle2 = document.createElement('h2');
            itemSubTitle2.className = 'sub-title';
            const itemTextDescrip2 = document.createElement('p');
            itemTextDescrip2.className = 'text-descripcion';

            itemSubTitle.textContent = 'Identificador';
            itemSubTitle2.textContent = 'Nombre';
            itemTextDescrip.textContent = item.hue_id;
            itemTextDescrip2.textContent = item.hue_nom + ' ' + item.hue_ape;
            itemContent.appendChild(itemSubTitle);
            itemContent2.appendChild(itemSubTitle2);
            itemContent.appendChild(itemTextDescrip);
            itemContent2.appendChild(itemTextDescrip2);
            itemList.appendChild(itemContent);
            itemList.appendChild(itemContent2);
            itemList.addEventListener('click', () => {
                if(identificadorRespuest == 0){
                    const elementosA = document.querySelectorAll('#lista a.list-group-item');
                    elementosA.forEach(elementoA => {
                      elementoA.addEventListener('click', function() {
                        if(identificadorRespuest !=0){
                            const textDescripcion = elementoA.querySelector('.text-descripcion');
                            if(identificadorRespuest == textDescripcion.textContent){                                
                                elementoA.className = "list-group-item list-group-item-action"
                                identificadorRespuest = 0;
                                console.log('Identificador:', identificadorRespuest);
                            }
                            
                        }else{
                            const textDescripcion = elementoA.querySelector('.text-descripcion');
                            elementoA.className = "list-group-item list-group-item-action active"
                            identificadorRespuest = textDescripcion.textContent;
                            console.log('Identificador:', identificadorRespuest);
                        }

                        
                      });
                    });
                    
                    
                }  
            })

            lista.appendChild(itemList);

        }
    );
})
.catch(error => {
    console.error('Error:', error);
});

function limpiarLista() {

    while (lista.firstChild) {
        lista.removeChild(lista.firstChild);
    }
  }

function getHuespedes(){
    fetch(url)
    .then(response => {
        if (!response.ok) {
        throw new Error('Error en la solicitud.');
        }
        return response.json();
    })
    .then(data => {
        data.forEach(
            item => {
                const itemList = document.createElement('a');
                itemList.className = 'list-group-item list-group-item-action';
                const itemContent = document.createElement('div');
                itemContent.className = 'text-list';
                const itemSubTitle = document.createElement('h2');
                itemSubTitle.className = 'sub-title';
                const itemTextDescrip = document.createElement('p');
                itemTextDescrip.className = 'text-descripcion';
                const itemContent2 = document.createElement('div');
                itemContent2.className = 'text-list';
                const itemSubTitle2 = document.createElement('h2');
                itemSubTitle2.className = 'sub-title';
                const itemTextDescrip2 = document.createElement('p');
                itemTextDescrip2.className = 'text-descripcion';

                itemSubTitle.textContent = 'Identificador';
                itemSubTitle2.textContent = 'Nombre';
                itemTextDescrip.textContent = item.hue_id;
                itemTextDescrip2.textContent = item.hue_nom + ' ' + item.hue_ape;
                itemContent.appendChild(itemSubTitle);
                itemContent2.appendChild(itemSubTitle2);
                itemContent.appendChild(itemTextDescrip);
                itemContent2.appendChild(itemTextDescrip2);
                itemList.appendChild(itemContent)
                itemList.appendChild(itemContent2)

                lista.appendChild(itemList);

            }
        );
    })
    .catch(error => {
        console.error('Error:', error);
});
}

function getHuesped(){
    
    fetch('http://localhost:8080/huespedes/huesped/'+busquedaInput.value)
    .then(response => {
        if (!response.ok) {
        throw new Error('Error en la solicitud.');
        }
        return response.json();
    })
    .then(data => {
        const itemList = document.createElement('a');
        itemList.className = 'list-group-item list-group-item-action';
        const itemContent = document.createElement('div');
        itemContent.className = 'text-list';
        const itemSubTitle = document.createElement('h2');
        itemSubTitle.className = 'sub-title';
        const itemTextDescrip = document.createElement('p');
        itemTextDescrip.className = 'text-descripcion';
        const itemContent2 = document.createElement('div');
        itemContent2.className = 'text-list';
        const itemSubTitle2 = document.createElement('h2');
        itemSubTitle2.className = 'sub-title';
        const itemTextDescrip2 = document.createElement('p');
        itemTextDescrip2.className = 'text-descripcion';

        itemSubTitle.textContent = 'Identificador';
        itemSubTitle2.textContent = 'Nombre';
        itemTextDescrip.textContent = data.hue_id;
        itemTextDescrip2.textContent = data.hue_nom + ' ' + data.hue_ape;
        itemContent.appendChild(itemSubTitle);
        itemContent2.appendChild(itemSubTitle2);
        itemContent.appendChild(itemTextDescrip);
        itemContent2.appendChild(itemTextDescrip2);
        itemList.appendChild(itemContent)
        itemList.appendChild(itemContent2)

        lista.appendChild(itemList);
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

function eventoGet(){
    limpiarLista()
    if(busquedaInput.value == ''){
        getHuespedes();
    }else{
        getHuesped();
    }
}

const busquedaInput = document.getElementById('busqueda-de-huesped');
busquedaInput.addEventListener('input',eventoGet );

document.addEventListener('DOMContentLoaded', function () {
    // Obtén una referencia a todos los elementos <a> dentro de #lista
    const elementosA = document.querySelectorAll('#lista a.list-group-item');
  
    elementosA.forEach(elementoA => {
      elementoA.addEventListener('click', function() {
        // Encuentra el elemento .text-descripcion dentro de este elemento <a>
        const textDescripcion = elementoA.querySelector('.text-descripcion');
        
        // Obtiene el valor del "Identificador" (el primer párrafo)
        const identificador = textDescripcion.textContent;
        
        console.log('Identificador:', identificador);
      });
    });
  });
  
  
  
  
  
  

