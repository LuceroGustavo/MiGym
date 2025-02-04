package com.MyGim.servicios;

import com.MyGim.entidades.Imagen;
import com.MyGim.repositorios.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class StorageService {

    @Autowired
    private ImagenRepository imagenRepository;

    public Imagen store(MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            Imagen imagen = new Imagen();
            imagen.setMime(file.getContentType());
            imagen.setNombre(file.getOriginalFilename());
            imagen.setContenido(file.getBytes());
            return imagenRepository.save(imagen);
        }
        throw new IOException("El archivo está vacío o es nulo");
    }

    public Imagen findById(String id) {
        return imagenRepository.findById(id).orElse(null);
    }
}
