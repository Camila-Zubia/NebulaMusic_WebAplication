/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.nebulamusic.apirest;

import com.mycompany.nebulamusic.dtos.ResponseMessageDTO;
import com.mycompany.nebulamusic.dtos.UsuarioAuthDTO;
import com.mycompany.nebulamusic.service.IUsuarioService;
import com.mycompany.nebulamusic.service.UsuarioService;
import com.mycompany.nebulamusic.util.JSONMapper;
import com.mycompany.nebulamusic.util.JWTUtil;
import com.mycompany.nubulamusicwebaplication.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "AuthServletAPI", urlPatterns = {"/api/auth/login"})
public class AuthServletAPI extends HttpServlet {

    private final IUsuarioService usuarioService = new UsuarioService();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioAuthDTO req = JSONMapper.mapper.readValue(request.getInputStream(), UsuarioAuthDTO.class);
        Usuario usuario = usuarioService.autenticar(req.getCorreo(), req.getContra());
        if (usuario == null) {
            response.setStatus(401);
            return;
        }
        String token = JWTUtil.generarToken(usuario.getCorreo());
        ResponseMessageDTO mensaje = new ResponseMessageDTO();
        mensaje.setSuccess(true);
        mensaje.setMessage(token);
        response.setContentType("application/json");
        JSONMapper.mapper.writeValue(response.getWriter(), mensaje);
    }

}
