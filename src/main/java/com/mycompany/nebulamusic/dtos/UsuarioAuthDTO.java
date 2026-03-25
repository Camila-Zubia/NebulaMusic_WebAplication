/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nebulamusic.dtos;

/**
 *
 * @author Usuario
 */
public class UsuarioAuthDTO {
    
    private String correo;
    private String contra;

    public UsuarioAuthDTO() {
    }

    public UsuarioAuthDTO(String correo, String contra) {
        this.correo = correo;
        this.contra = contra;
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
    
    
}
