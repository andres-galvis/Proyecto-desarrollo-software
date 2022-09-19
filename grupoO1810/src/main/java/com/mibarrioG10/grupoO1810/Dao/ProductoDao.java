/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mibarrioG10.grupoO1810.Dao;

import com.mibarrioG10.grupoO1810.Models.Producto;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Usuario
 */
public interface ProductoDao extends CrudRepository<Producto,Integer> {
    
}
