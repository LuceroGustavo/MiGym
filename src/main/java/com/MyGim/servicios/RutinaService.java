package com.MyGim.servicios;

import com.MyGim.entidades.Rutina;
import com.MyGim.entidades.Usuario;
import com.MyGim.repositorios.RutinaRepository;
import com.MyGim.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinaService {

    @Autowired
    private RutinaRepository rutinaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Rutina> getAllRutinas() {
        return rutinaRepository.findAll();
    }

    public Rutina getRutinaById(Long id) {
        return rutinaRepository.findById(id).orElse(null);
    }

    public Rutina createRutina(Rutina rutina, Long usuarioId) throws Exception {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        if (usuario == null) {
            throw new Exception("Usuario not found");
        }
        rutina.setUsuario(usuario);
        return rutinaRepository.save(rutina);
    }

    public Rutina updateRutina(Long id, Rutina rutinaDetails) throws Exception {
        Rutina rutina = rutinaRepository.findById(id).orElse(null);
        if (rutina == null) {
            throw new Exception("Rutina not found");
        }
        rutina.setNombre(rutinaDetails.getNombre());
        rutina.setCantidadEjercicios(rutinaDetails.getCantidadEjercicios());
        rutina.setRepeticiones(rutinaDetails.getRepeticiones());
        rutina.setTiempo(rutinaDetails.getTiempo());
        rutina.setPeso(rutinaDetails.getPeso());
        rutina.setEjercicios(rutinaDetails.getEjercicios());
        return rutinaRepository.save(rutina);
    }

    public boolean deleteRutina(Long id) {
        Rutina rutina = rutinaRepository.findById(id).orElse(null);
        if (rutina != null) {
            rutinaRepository.delete(rutina);
            return true;
        }
        return false;
    }
}
