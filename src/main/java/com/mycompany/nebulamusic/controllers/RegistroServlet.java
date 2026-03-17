/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.nebulamusic.controllers;

import com.mycompany.nebulamusic.service.IUsuarioService;
import com.mycompany.nebulamusic.service.UsuarioService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "RegistroServlet", urlPatterns = {"/registro"})
public class RegistroServlet extends HttpServlet {
    private final IUsuarioService usuarioService = new UsuarioService();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String nombre = request.getParameter("txt_name");
        String correo = request.getParameter("txt_correo");
        String contra = request.getParameter("txt_contra");
        String pseudonimo = request.getParameter("txt_pseudonimo");
        String estado = request.getParameter("rad_estado");
        String tipoCuenta = request.getParameter("sel_cuenta");
        String fechaNacimientoStr = request.getParameter("txt_fecha_nacimiento");
        String terminos = request.getParameter("chk_terminos");
        try{
            LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
            boolean aceptoTerminos = terminos.equals("aceptado");
            
            usuarioService.registrar(nombre, correo, contra, pseudonimo, estado, tipoCuenta, fechaNacimiento, aceptoTerminos);
            request.setAttribute("mensaje", "Registro exitoso. Ahora puedes iniciar sesion");
            request.getRequestDispatcher("/views/auth/iniciar-sesion.jsp").forward(request, response);
        }catch(IllegalArgumentException | ServletException | IOException e){
            throw new ServletException("Error al autenticar usuario", e);
        }
    }
    
    

}
