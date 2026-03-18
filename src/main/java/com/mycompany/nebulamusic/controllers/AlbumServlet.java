/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.nebulamusic.controllers;

import com.mycompany.nebulamusic.service.AlbumService;
import com.mycompany.nebulamusic.service.IAlbumService;
import com.mycompany.nubulamusicwebaplication.model.Album;
import com.mycompany.nubulamusicwebaplication.model.Usuario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.util.List;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "AlbumServlet", urlPatterns = {"/albums"})
public class AlbumServlet extends HttpServlet {
    
    private final IAlbumService albumService = new AlbumService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(false);
        Usuario usuario =(Usuario) sesion.getAttribute("usuario");
        String action = request.getParameter("accion");
        if (action == null) {
            action = "list";
        }
        try{
            switch(action){
                case "new":
                    request.getRequestDispatcher("/views/admin/album-form.jsp").forward(request, response);
                    break;
                case "edit":
                    Long id = Long.valueOf(request.getParameter("id"));
                    Album album = albumService.obtenerAlbum(id, usuario.getId());
                    request.setAttribute("album", album);
                    request.getRequestDispatcher("/views/admin/album-form.jsp").forward(request, response);
                    break;
                case "delete":
                    Long deleteId = Long.valueOf(request.getParameter("id"));
                    albumService.eliminarAlbum(deleteId, usuario.getId());
                    response.sendRedirect("/albums");
                    break;
                default:
                    List<Album> albums =albumService.obtenerAlbumsUsuario(usuario.getId());
                    request.setAttribute("albums", albums);
                    request.getRequestDispatcher("/views/admin/mis-albums.jsp").forward(request, response);
                    
            }
        }catch(ServletException | IOException | NumberFormatException e){
                    throw new ServletException(e);
                    }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(false);
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
        String idParam = request.getParameter("id");
        String titulo = request.getParameter("titulo");
        String descripcion = request.getParameter("descripcion");
        Part filePart = request.getPart("imagen");
        String fileName = filePart.getSubmittedFileName();
        if (!fileName.endsWith(".png")) {
            throw new ServletException("Solo se permiten imagenes en formato .png");
        }
        
        String newFileName = System.currentTimeMillis() + "_" + fileName;
        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        String filePath = uploadPath + File.separator + newFileName;
        filePart.write(filePath);
        String imagenUrl = "upload/" + newFileName;
        Album album = new Album();
        album.setTitulo(titulo);
        album.setDescripcion(descripcion);
        album.setImageUrl(imagenUrl);
        album.setUsuario(usuario);
        try{
            if (idParam == null || idParam.isEmpty()) {
                albumService.crearAlbum(album);
            }else{
                album.setId(Long.valueOf(idParam));
                albumService.actualizarAlbum(album, usuario.getId());
            }
            response.sendRedirect("albums");
        }catch(NumberFormatException e){
            request.setAttribute("error", e.getMessage());
            request.setAttribute("album", album);
            request.getRequestDispatcher("/views/admin/album-form.jsp").forward(request, response);
        }
    }

}
