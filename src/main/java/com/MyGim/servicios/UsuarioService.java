package com.MyGim.servicios;

import com.MyGim.entidades.Usuario;
import com.MyGim.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario createUsuario(Usuario usuario) throws Exception {
        if (usuarioRepository.findByNombre(usuario.getNombre()) != null) {
            throw new Exception("Usuario with the same name already exists");
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Long id, Usuario usuarioDetails) throws Exception {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) {
            throw new Exception("Usuario not found");
        }
        if (!usuario.getNombre().equals(usuarioDetails.getNombre()) && usuarioRepository.findByNombre(usuarioDetails.getNombre()) != null) {
            throw new Exception("Usuario with the same name already exists");
        }
        usuario.setNombre(usuarioDetails.getNombre());
        usuario.setEdad(usuarioDetails.getEdad());
        usuario.setSexo(usuarioDetails.getSexo());
        usuario.setPeso(usuarioDetails.getPeso());
        return usuarioRepository.save(usuario);
    }

    public boolean deleteUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            usuarioRepository.delete(usuario);
            return true;
        }
        return false;
    }
}
