/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mibarrioG10.grupoO1810.Services;

import com.mibarrioG10.grupoO1810.Models.Producto;
import java.util.List;
/**
 *
 * @author Usuario
 */
public interface ProductoService {
    public Producto save(Producto producto);
    public void delete(int codigo_prod);
    public Producto findById(int codigo_prod);
    public List<Producto>findAll();
}
