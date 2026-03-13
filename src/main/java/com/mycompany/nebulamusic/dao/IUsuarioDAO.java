package com.mycompany.nebulamusic.dao;

import com.mycompany.nebulamusic.models.Usuario;
import java.util.List;

public interface IUsuarioDAO {

    void guardar(Usuario usuario);

    Usuario buscarPorId(Long id);

    Usuario buscarPorCorreo(String correo);

    Usuario buscarPorCorreoYContrasenia(String correo, String contrasenia);

    Usuario buscarPorPseudonimo(String pseudonimo);

    List<Usuario> listarTodos();

    void actualizar(Usuario usuario);

    void eliminar(Long id);
}