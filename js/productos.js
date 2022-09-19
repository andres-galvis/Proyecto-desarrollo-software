function loadData(){
    let request=sendRequest('producto/list', 'GET', '')
    let tablaProd = document.getElementById('tabla-productos');
    tablaProd.innerHTML="";
    request.onload=function(){

        let data= request.response;
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
                    onclick='window.location="productos.html?id=${element.codigo_prod}"'>Editar</button>
                    <button type="button" class="btn btn-danger"
                    onclick='deleteProducto(${element.codigo_prod})'>Eliminar</button>
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

    /*function deleteProducto(codigo_prod){

        let request=sendRequest('producto/'+codigo_prod, 'DELETE', '')
        request.onload=function(){
            loadData()
        }
        ...
    }*/

    /*function loadProductos(codigo_prod){

        let request=sendRequest('producto/list/'+codigo_prod, 'GET', '')
        let id=document.getElementById('codigo_prod')
        let nombre = document.getElementById('nombre_prod')
        let categoria = document.getElementById('id_cat')
        let marca=document.getElementById('marca_prod')
        let descripcion=document.getElementById('descripcion_prod')
        let imagen=document.getElementById('imagen_prod')
        let precio=document.getElementById('precio_prod')
        let cantidad=document.getElementById('cantidad_prod')
        let nitProv=document.getElementById('nit_prov')
        request.onload=function(){

            let data=request.response;
            nombre.value=data.nombre_prod
            categoria.value=data.id_cat
            marca.value=data.marca_prod
            descripcion.value=data.descripcion_prod
            imagen.value=data.imagen_prod
            precio.value=data.precio_prod
            cantidad.value=data.cantidad_prod
            nitProv.value=data.nit_prov
            
        }
        request.onerror=function(){
            alert("error al recuperar los datos.")
        }

    }*/

    /*function guardarProductos(){

        let id=document.getElementById('codigo_prod')
        let nombre = document.getElementById('nombre_prod')
        let categoria = document.getElementById('id_cat')
        let marca=document.getElementById('marca_prod')
        let descripcion=document.getElementById('descripcion_prod')
        let imagen=document.getElementById('imagen_prod')
        let precio=document.getElementById('precio_prod')
        let cantidad=document.getElementById('cantidad_prod')
        let nitProv=document.getElementById('nit_prov')
        let data={'codigo_prod':''} ////////////////////////////
        let request=sendRequest('producto/', codigo_prod ? 'PUT': 'POST', data)
        request.onload=function(){
            window.location='productos.html';
        }
        request.onerror=function(){
            alert('error al guardar los cambios')
        }
    }*/


}