/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nebulamusic.dtos;

import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class UsuarioRequestDTO {
    
    private String nombre;
    private String correo;
    private String contra;
    private String pseudonimo;
    private String estado;
    private String cuenta;
    private LocalDate fechaNacimiento;
    private boolean terminos;

    public UsuarioRequestDTO() {
    }

    public UsuarioRequestDTO(String nombre, String correo, String contra, String pseudonimo, String estado, String cuenta, LocalDate fechaNacimiento, boolean terminos) {
        this.nombre = nombre;
        this.correo = correo;
        this.contra = contra;
        this.pseudonimo = pseudonimo;
        this.estado = estado;
        this.cuenta = cuenta;
        this.fechaNacimiento = fechaNacimiento;
        this.terminos = terminos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getPseudonimo() {
        return pseudonimo;
    }

    public void setPseudonimo(String pseudonimo) {
        this.pseudonimo = pseudonimo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isTerminos() {
        return terminos;
    }

    public void setTerminos(boolean terminos) {
        this.terminos = terminos;
    }
    

    
}
