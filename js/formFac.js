function loadProducto(id_fac){

    let request=sendRequest('factura/list/'+ id_fac, 'GET', '')
    let factura=document.getElementById('id_factura')
    let tienda = document.getElementById('id_tienda')
    let cliente = document.getElementById('id_cliente')
    let fecha =document.getElementById('fecha_fac')
    let hora=document.getElementById('hora_fac')
    let descripcionFac=document.getElementById('descripcion_fac')
    let total=document.getElementById('total_fac')
    request.onload=function(){

        let data=request.response;
        factura.value=data.id_fac
        tienda.value=data.id_tienda
        cliente.value=data.id_cliente
        fecha.value=data.fecha_fac
        hora.value=data.hora_fac
        descripcionFac.value=data.descripcion_fac
        total.value=data.toral_fac
        
    }
    request.onerror=function(){
        alert("error al recuperar los datos.")
    }

}