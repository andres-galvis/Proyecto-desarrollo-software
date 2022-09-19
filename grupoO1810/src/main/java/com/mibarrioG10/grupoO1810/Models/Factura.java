/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mibarrioG10.grupoO1810.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="facturas")
public class Factura {
    @Id 
    @Column(name="id_fac")
    private int id_fac;

    @Column(name="id_tien")
    private int id_tien;

    @Column(name="id_clien")
    private int id_clien;

    @Column(name="fecha_fac")
    private String fecha_fac;

    @Column(name="hora_fac")
    private String hora_fac;           

    @Column(name="descripcion_fac")
    private String descripcion_fac;

    @Column(name="total_fac")
    private double total_fac; 

    public int getId_fac() {
        return id_fac;
    }

    public void setId_fac(int id_fac) {
        this.id_fac = id_fac;
    }

    public int getId_tien() {
        return id_tien;
    }

    public void setId_tien(int id_tien) {
        this.id_tien = id_tien;
    }

    public int getId_clien() {
        return id_clien;
    }

    public void setId_clien(int id_clien) {
        this.id_clien = id_clien;
    }

    public String getFecha_fac() {
        return fecha_fac;
    }

    public void setFecha_fac(String fecha_fac) {
        this.fecha_fac = fecha_fac;
    }

    public String getHora_fac() {
        return hora_fac;
    }

    public void setHora_fac(String hora_fac) {
        this.hora_fac = hora_fac;
    }

    public String getDescripcion_fac() {
        return descripcion_fac;
    }

    public void setDescripcion_fac(String descripcion_fac) {
        this.descripcion_fac = descripcion_fac;
    }

    public double getTotal_fac() {
        return total_fac;
    }

    public void setTotal_fac(double total_fac) {
        this.total_fac = total_fac;
    }






























}
