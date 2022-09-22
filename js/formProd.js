function loadProducto(codigo_prod){

        let request=sendRequest('producto/list/'+codigo_prod, 'GET', '')
        let codigo=document.getElementById('codigo_prod')
        let nombre = document.getElementById('nombre_prod')
        let marca = document.getElementById('marca_prod')
        let descripcion =document.getElementById('descripcion_prod')
        let imagen=document.getElementById('imagen_prod')
        let precio=document.getElementById('precio_prod')
        let cantidad=document.getElementById('cantidad_prod')
        request.onload=function(){

            let data=request.response;
            codigo.value=data.codigo_prod
            nombre.value=data.nombre_prod
            marca.value=data.marca_prod
            descripcion.value=data.descripcion_prod
            imagen.value=data.imagen_prod
            precio.value=data.precio_prod
            cantidad.value=data.cantidad_prod
            
        }
        request.onerror=function(){
            alert("error al recuperar los datos.")
        }

    }