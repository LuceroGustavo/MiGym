// src/main/java/com/MyGim/servicios/ImagenServicio.java
package com.MyGim.servicios;

import com.MyGim.entidades.Imagen;
import com.MyGim.repositorios.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class ImagenServicio {

    @Autowired
    private ImagenRepository imagenRepository;

    @Transactional
    public Imagen guardar(MultipartFile archivo) {
        if (archivo == null || archivo.isEmpty()) {
            throw new IllegalArgumentException("El archivo está vacío o es nulo");
        }

        try {
            Imagen imagen = new Imagen();
            imagen.setMime(archivo.getContentType());
            imagen.setNombre(archivo.getOriginalFilename());
            imagen.setContenido(archivo.getBytes());
            return imagenRepository.save(imagen);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la imagen", e);
        }
    }

    @Transactional
    public Imagen guardar(byte[] archivoBytes, String nombreArchivo) {
        if (archivoBytes == null || archivoBytes.length == 0) {
            throw new IllegalArgumentException("El archivo está vacío o es nulo");
        }

        try {
            Imagen imagen = new Imagen();
            imagen.setMime("image/png");
            imagen.setNombre(nombreArchivo);
            imagen.setContenido(archivoBytes);
            return imagenRepository.save(imagen);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la imagen", e);
        }
    }

    @Transactional
    public Imagen actualizar(MultipartFile archivo, String idImagen) {
        if (archivo != null) {
            try {
                Optional<Imagen> optionalImagen = imagenRepository.findById(idImagen);
                if (optionalImagen.isPresent()) {
                    eliminarImagen(idImagen);
                }

                Imagen nuevaImagen = new Imagen();
                nuevaImagen.setMime(archivo.getContentType());
                nuevaImagen.setNombre(archivo.getOriginalFilename());
                nuevaImagen.setContenido(archivo.getBytes());
                return imagenRepository.save(nuevaImagen);
            } catch (Exception e) {
                throw new RuntimeException("Error al actualizar la imagen", e);
            }
        }
        return null;
    }

    @Transactional
    public void eliminarImagen(String idImagen) {
        try {
            Optional<Imagen> optionalImagen = imagenRepository.findById(idImagen);
            optionalImagen.ifPresent(imagenRepository::delete);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar la imagen con ID: " + idImagen, e);
        }
    }

    @Transactional(readOnly = true)
    public List<Imagen> listarTodos() {
        return imagenRepository.findAll();
    }
}