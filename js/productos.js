function loadData() {
    let request = sendRequest('producto/list', 'GET', '')
    let tablaProd = document.getElementById('tabla-productos');
    tablaProd.innerHTML = "";
    request.onload = function () {

        let data = request.response;
        data.array.forEach(element => {
            tablaProd.innerHTML += `

            <tr>
                <th scope="row">${element.codigo_prod}</th>
                <td>${element.nombre_prod}</td>
                <td>${element.id_cat}</td>
                <td>${element.marca_prod}</td>
                <td>${element.descripcion_prod}</td>
                <td>${element.imagen_prod}</td>
                <td>${element.precio_prod}</td>
                <td>${element.cantidad_prod}</td>
                <td>
                    <button type="button" class="btn btn-dark" 
                    onclick='window.location="formularioProd.html?id=${element.codigo_prod}"'>Editar</button>
                    <button type="button" class="btn btn-danger"
                    onclick='deleteProducto(${element.codigo_prod})'>Eliminar</button>
                </td>
            </tr>

            `
        });
    }
    request.onerror = function () {
        tablaProd.innerHTML = `

            <tr>
                <td colspan="9">Error al recuperar los datos...</td>
            </tr>

        `;
    }
}

function deleteProducto(codigo_prod) {

    let request = sendRequest('producto/' + codigo_prod, 'DELETE', '')
    request.onload = function () {
        loadData()
    }
}

function saveProducto() {

    let codigo = document.getElementById('codigo_prod')
    let nombre = document.getElementById('nombre_prod')
    let marca = document.getElementById('marca_prod')
    let descripcion = document.getElementById('descripcion_prod')
    let imagen = document.getElementById('imagen_prod')
    let precio = document.getElementById('precio_prod')
    let cantidad = document.getElementById('cantidad_prod')
    let data={'codigo_prod':codigo, 'nombre_prod': nombre, 'marca_prod': marca_prod, 
        'descripcion_prod':descripcion, 'url_imagen': imagen, 'precio_prod':precio, 'cantidad_prod':cantidad }
    let request=sendRequest('producto/', codigo_prod ? 'PUT' : 'POST', data)
    request.onload=function(){
        window.location='productos.html';
    }
    request.onerror = function(){
        alert('error al guardar cambios')
    }

}