/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.nebulamusic.apirest;

import com.mycompany.nebulamusic.dtos.ResponseMessageDTO;
import com.mycompany.nebulamusic.dtos.UsuarioDTO;
import com.mycompany.nebulamusic.service.IUsuarioService;
import com.mycompany.nebulamusic.service.UsuarioService;
import com.mycompany.nebulamusic.util.JSONMapper;
import com.mycompany.nubulamusicwebaplication.model.Usuario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "UsuarioAPIServlet", urlPatterns = {"/api/usuarios/*"})
public class UsuarioAPIServlet extends HttpServlet {

    private final IUsuarioService usuarioService = new UsuarioService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        try{
            String pathInfo = request.getPathInfo();
            if (pathInfo == null || pathInfo.equals("/")) {
                List<Usuario> usuarios = usuarioService.listarTodos();
                List<UsuarioDTO> usuariosDto = usuarios.stream().map(u -> {
                   UsuarioDTO dto = new UsuarioDTO();
                   dto.setId(u.getId());
                   dto.setNombre(u.getNombre());
                   dto.setCorreo(u.getCorreo());
                   dto.setPseudonimo(u.getPseudonimo());
                   return dto;
                }).collect(Collectors.toList());
                JSONMapper.mapper.writeValue(response.getWriter(), usuariosDto);
            }else{
                Long id = Long.valueOf(pathInfo.substring(1));
                Usuario usuario = usuarioService.buscarPorId(id);
                if (usuario == null) {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    ResponseMessageDTO mensaje = new ResponseMessageDTO();
                    mensaje.setSuccess(false);
                    mensaje.setMessage("No se encontro el usuario buscado");
                    JSONMapper.mapper.writeValue(response.getWriter(), mensaje);
                }else{
                    UsuarioDTO dto = new UsuarioDTO();
                    dto.setId(usuario.getId());
                    dto.setNombre(usuario.getNombre());
                    dto.setCorreo(usuario.getCorreo());
                    dto.setPseudonimo(usuario.getPseudonimo());
                    JSONMapper.mapper.writeValue(response.getWriter(), dto);
                }
            }
        }catch(IOException e){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            ResponseMessageDTO mensaje = new ResponseMessageDTO();
            mensaje.setSuccess(false);
            mensaje.setMessage("Ocurrio un error al procesar la solicitud");
            JSONMapper.mapper.writeValue(response.getWriter(), mensaje);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
