/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.nebulamusic.controllers;

import com.mycompany.nebulamusic.service.IUsuarioService;
import com.mycompany.nebulamusic.service.UsuarioService;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "AutenticacionServlet", urlPatterns = {"/autenticacion"})
public class AutenticacionServlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String contra = request.getParameter("contra");
        IUsuarioService uService = new UsuarioService();
        boolean valido = uService.autenticar(correo, contra);
        if (valido) {
            HttpSession sesion = request.getSession(true);
            sesion.setAttribute("usuario", correo);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }else{
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
    
    

}
