/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mibarrioG10.grupoO1810.Services;

import com.mibarrioG10.grupoO1810.Models.Factura;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface FacturaService {
    public Factura save(Factura factura);
    public void delete(int id_fac);
    public Factura findById(int id_fac);
    public List<Factura>findAll();
}
