function loadData(){
    let request=sendRequest('factura/list', 'GET', '')
    let tablaProd = document.getElementById('tabla-facturas');
    tablaProd.innerHTML="";
    request.onload=function(){

        let data= request.response;
        data.array.forEach(element => {
            tablaProd.innerHTML += `

            <tr>
                <th scope="row">${element.id_fac}</th>
                <td>${element.id_tienda}</td>
                <td>${element.id_cliente}</td>
                <td>${element.fecha_fac}</td>
                <td>${element.hora_fac}</td>
                <td>${element.Descripcion_fac}</td>
                <td>${element.total_fac}</td>
                <td>
                    <button type="button" class="btn btn-dark" 
                    onclick='window.location="formFac.html?id=${element.id_fac}"'>Editar</button>
                    <button type="button" class="btn btn-danger"
                    onclick='deleteProducto(${element.id_fac})'>Eliminar</button>
                </td>
            </tr>

            `
        });
    }
    request.onerror=function(){
        tablaProd.innerHTML =`

            <tr>
                <td colspan="9">Error al recuperar los datos...</td>
            </tr>

        `;
    }
}

function deleteProducto(id_fac) {

    let request = sendRequest('factura/' + id_fac, 'DELETE', '')
    request.onload = function () {
        loadData()
    }
}

function saveFactura() {

    let factura=document.getElementById('id_factura')
    let tienda = document.getElementById('id_tienda')
    let cliente = document.getElementById('id_cliente')
    let fecha =document.getElementById('fecha_fac')
    let hora=document.getElementById('hora_fac')
    let descripcionFac=document.getElementById('descripcion_fac')
    let total=document.getElementById('total_fac')
    let data={'id_fac': factura, 'id_tienda': tienda, 'id_cliente': cliente, 
        'fecha_fac':fecha, 'hora_fac': hora, 'descripcion_fac':descripcionFac, 'total_fac':total }
    let request=sendRequest('factura/', id_fac ? 'PUT' : 'POST', data)
    request.onload=function(){
        window.location='facturas.html';
    }
    request.onerror = function(){
        alert('error al guardar cambios')
    }