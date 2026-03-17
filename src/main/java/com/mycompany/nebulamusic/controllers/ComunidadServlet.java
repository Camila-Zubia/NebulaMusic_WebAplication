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
import java.util.List;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "ComunidadServlet", urlPatterns = {"/comunidad"})
public class ComunidadServlet extends HttpServlet {
private final IUsuarioService usuarioService = new UsuarioService();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int pagina = 1;
        int tamañoPag = 10;
        String paginaParam = request.getParameter("pagina");
        if (paginaParam != null && !paginaParam.isBlank()) {
            try{
                pagina = Integer.parseInt(paginaParam);
            }catch(NumberFormatException e){
                pagina = 1;
            }
        }
        List<Usuario> usuarios = usuarioService.listarPaginado(pagina, tamañoPag);
        long totalUsuarios = usuarioService.contarUsuarios();
        long totalPag = (long) Math.ceil((double)totalUsuarios/tamañoPag);
        request.setAttribute("usuarios", usuarios);
        request.setAttribute("paginaActual", pagina);
        request.setAttribute("totalPaginas", totalPag);
        request.setAttribute("totalUsuarios", totalUsuarios);
        
        request.getRequestDispatcher("/views/aplication/comunidad.jsp").forward(request, response);
    }
}
