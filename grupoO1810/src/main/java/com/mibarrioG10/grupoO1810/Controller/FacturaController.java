/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mibarrioG10.grupoO1810.Controller;

import com.mibarrioG10.grupoO1810.Models.Factura;
import com.mibarrioG10.grupoO1810.Services.FacturaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class FacturaController {
    
 @Autowired
    private FacturaService facturaService;

    @PostMapping(value = "/")
    public ResponseEntity<Factura> agregar(@RequestBody Factura factura) {
        Factura obj = facturaService.save(factura);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id_fac}")
    public ResponseEntity<Factura> eliminar(@PathVariable int id_fac) {
        Factura obj = facturaService.findById(id_fac);
        if (obj != null) {
            facturaService.delete(id_fac);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Factura> editar(@RequestBody Factura factura) {
        Factura obj = facturaService.findById(factura.getId_fac());
        if (obj != null) {
            obj.setId_tien(factura.getId_tien());
            obj.setId_clien(factura.getId_clien());
            obj.setFecha_fac(factura.getFecha_fac());
            obj.setHora_fac(factura.getHora_fac());
            obj.setDescripcion_fac(factura.getDescripcion_fac());
            obj.setTotal_fac(factura.getTotal_fac());
            facturaService.save(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<Factura> consultarTodo() {
        return facturaService.findAll();
    }

    @GetMapping("/list/{id_fac}")
    public Factura consultaPorId(@PathVariable int id_fac) {
        return facturaService.findById(id_fac);
    }
}
