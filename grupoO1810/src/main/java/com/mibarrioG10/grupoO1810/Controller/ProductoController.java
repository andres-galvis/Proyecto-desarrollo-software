/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mibarrioG10.grupoO1810.Controller;

import com.mibarrioG10.grupoO1810.Models.Producto;
import com.mibarrioG10.grupoO1810.Services.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping(value = "/")
    public ResponseEntity<Producto> agregar(@RequestBody Producto producto) {
        Producto obj = productoService.save(producto);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{codigo_prod}")
    public ResponseEntity<Producto> eliminar(@PathVariable int codigo_prod) {
        Producto obj = productoService.findById(codigo_prod);
        if (obj != null) {
            productoService.delete(codigo_prod);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Producto> editar(@RequestBody Producto producto) {
        Producto obj = productoService.findById(producto.getCodigo_prod());
        if (obj != null) {
            obj.setNombre_prod(producto.getNombre_prod());
            obj.setMarca_prod(producto.getMarca_prod());
            obj.setDescripcion_prod(producto.getDescripcion_prod());
            obj.setUrl_imagen(producto.getUrl_imagen());
            obj.setPrecio_prod(producto.getPrecio_prod());
            obj.setCantidad_prod(producto.getCantidad_prod());
            productoService.save(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<Producto> consultarTodo() {
        return productoService.findAll();
    }

    @GetMapping("/list/{codigo_prod}")
    public Producto consultaPorId(@PathVariable int codigo_prod) {
        return productoService.findById(codigo_prod);
    }

}
