/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mibarrioG10.grupoO1810.Services.Implement;

import com.mibarrioG10.grupoO1810.Dao.FacturaDao;
import com.mibarrioG10.grupoO1810.Models.Factura;
import com.mibarrioG10.grupoO1810.Services.FacturaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service
public class FacturaServiceImpl implements FacturaService {
    @Autowired
    private FacturaDao facturaDao;

    @Override
    @Transactional(readOnly=false)
    public Factura save(Factura factura) {
        return facturaDao.save(factura);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(int id_fac) {
        facturaDao.deleteById(id_fac);
    }

    @Override
    @Transactional(readOnly=true)
    public Factura findById(int id_fac) {
        return facturaDao.findById(id_fac).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Factura> findAll() {
        return (List<Factura>) facturaDao.findAll();
    }
}
