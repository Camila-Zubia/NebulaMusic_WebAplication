/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.nebulamusic.controllers;

import com.mycompany.nebulamusic.models.Usuario;
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
    private final IUsuarioService usuarioService = new UsuarioService();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String contra = request.getParameter("contra");

        try{
            Usuario usuario = usuarioService.autenticar(correo, contra);
            HttpSession sesionAnterior = request.getSession(false);
            if (sesionAnterior != null) {
                sesionAnterior.invalidate();
            }
            HttpSession sesion = request.getSession(true);
            
            sesion.setAttribute("usuario", usuario);
            
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            
        }catch(IllegalArgumentException e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/views/auth/iniciar-ssesion.jsp").forward(request, response);
        }catch(Exception e){
            throw new ServletException("Error al autenticar al usuario", e);
        }
    }
    
    

}
