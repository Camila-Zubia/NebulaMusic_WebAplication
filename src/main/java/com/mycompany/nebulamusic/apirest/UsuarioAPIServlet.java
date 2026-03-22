/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.nebulamusic.apirest;

import com.mycompany.nebulamusic.dtos.ResponseMessageDTO;
import com.mycompany.nebulamusic.dtos.UsuarioDTO;
import com.mycompany.nebulamusic.dtos.UsuarioRequestDTO;
import com.mycompany.nebulamusic.service.IUsuarioService;
import com.mycompany.nebulamusic.service.UsuarioService;
import com.mycompany.nebulamusic.util.JSONMapper;
import com.mycompany.nubulamusicwebaplication.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
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

        try {
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
            } else {
                Long id = Long.valueOf(pathInfo.substring(1));
                Usuario usuario = usuarioService.buscarPorId(id);
                if (usuario == null) {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    ResponseMessageDTO mensaje = new ResponseMessageDTO();
                    mensaje.setSuccess(false);
                    mensaje.setMessage("No se encontro el usuario buscado");
                    JSONMapper.mapper.writeValue(response.getWriter(), mensaje);
                } else {
                    UsuarioDTO dto = new UsuarioDTO();
                    dto.setId(usuario.getId());
                    dto.setNombre(usuario.getNombre());
                    dto.setCorreo(usuario.getCorreo());
                    dto.setPseudonimo(usuario.getPseudonimo());
                    JSONMapper.mapper.writeValue(response.getWriter(), dto);
                }
            }
        } catch (IOException e) {
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
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        ResponseMessageDTO apiResponse = new ResponseMessageDTO();
        try {
            UsuarioRequestDTO req = JSONMapper.mapper
                    .readValue(request.getInputStream(), UsuarioRequestDTO.class);
            usuarioService.registrar(
                    req.getNombre(),
                    req.getCorreo(),
                    req.getContra(),
                    req.getPseudonimo(),
                    req.getEstado(),
                    req.getCuenta(),
                    req.getFechaNacimiento(),
                    req.isTerminos());
            response.setStatus(HttpServletResponse.SC_CREATED);
            apiResponse.setSuccess(true);
            apiResponse.setMessage("Usuario creado correctamente");
            JSONMapper.mapper.writeValue(response.getWriter(), apiResponse);
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            apiResponse.setSuccess(false);
            apiResponse.setMessage(e.getMessage());
            JSONMapper.mapper.writeValue(response.getWriter(), apiResponse);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        ResponseMessageDTO mensaje = new ResponseMessageDTO();
        try {
            String pathInfo = request.getPathInfo();
            if (pathInfo == null || pathInfo.equals("/")) {
                throw new IllegalAccessException("El id es obligatorio.");
            }
            Long id = Long.valueOf(pathInfo.substring(1));
            UsuarioRequestDTO req = JSONMapper.mapper.readValue(request.getInputStream(), UsuarioRequestDTO.class);
            Usuario usuario = new Usuario();
            usuario.setNombre(req.getNombre());
            usuario.setCorreo(req.getCorreo());
            usuario.setPseudonimo(req.getPseudonimo());
            usuario.setEstado(req.getEstado());
            usuario.setCuenta(req.getCuenta());
            usuario.setFechaNacimiento(req.getFechaNacimiento());
            usuarioService.actualizarUsuario(usuario);
            mensaje.setSuccess(true);
            mensaje.setMessage("El usuario se ha actualizado correctamente.");
            JSONMapper.mapper.writeValue(response.getWriter(), mensaje);
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            mensaje.setSuccess(false);
            mensaje.setMessage(e.getMessage());
            JSONMapper.mapper.writeValue(response.getWriter(), mensaje);
        } catch (IllegalAccessException ex) {
            System.getLogger(UsuarioAPIServlet.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        ResponseMessageDTO mensaje = new ResponseMessageDTO();
        try {
            String pathInfo = request.getPathInfo();
            if (pathInfo == null || pathInfo.equals("/")) {
                throw new IllegalAccessException("El id es obligatorio.");
            }
            Long id = Long.valueOf(pathInfo.substring(1));
            usuarioService.eliminarUsuario(id);
            mensaje.setSuccess(true);
            mensaje.setMessage("Usuario elimindado correctamente.");
            JSONMapper.mapper.writeValue(response.getWriter(), mensaje);
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            mensaje.setSuccess(false);
            mensaje.setMessage(e.getMessage());
            JSONMapper.mapper.writeValue(response.getWriter(), mensaje);
        }catch (IllegalAccessException ex) {
            System.getLogger(UsuarioAPIServlet.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
