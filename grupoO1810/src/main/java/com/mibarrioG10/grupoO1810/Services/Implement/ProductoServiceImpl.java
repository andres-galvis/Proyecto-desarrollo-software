/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mibarrioG10.grupoO1810.Services.Implement;

import com.mibarrioG10.grupoO1810.Dao.ProductoDao;
import com.mibarrioG10.grupoO1810.Models.Producto;
import com.mibarrioG10.grupoO1810.Services.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly=false)
    public Producto save(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(int codigo_prod) {
        productoDao.deleteById(codigo_prod);
    }

    @Override
    @Transactional(readOnly=true)
    public Producto findById(int codigo_prod) {
        return productoDao.findById(codigo_prod).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return (List<Producto>) productoDao.findAll();
    }

}
