package com.mycompany.nebulamusic.service;

import com.mycompany.nebulamusic.models.Usuario;
import java.time.LocalDate;
import java.util.List;

public interface IUsuarioService {
    
     void registrar(String nombre,
                   String correo,
                   String contrasenia,
                   String pseudonimo,
                   String estado,
                   String cuenta,
                   LocalDate fechaNacimiento,
                   boolean terminosAceptados);

    Usuario autenticar(String correo, String contrasenia);

    Usuario buscarPorId(Long id);

    Usuario buscarPorCorreo(String correo);

    List<Usuario> listarTodos();

    void actualizarUsuario(Usuario usuario);

    void eliminarUsuario(Long id);
    
    List<Usuario> listaTop(int limite);
    
    List<Usuario> listarPaginado(int pagina, int tamañoPag);
    
    long contarUsuarios();
}