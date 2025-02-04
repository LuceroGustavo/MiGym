package com.MyGim.entidades;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
import java.util.Base64;

@SuppressWarnings("deprecation")
@Data
@Entity
public class Imagen {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private String mime;
    
    private String nombre;
    
    @Lob 
    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition="LONGBLOB")
    private byte[] contenido;

    // El campo base64Encoded ya no es necesario como atributo almacenado
    // Se calculará cada vez que se acceda al getter

    // Getter para base64Encoded que codifica el contenido en base64
    public String getBase64Encoded() {
        if (this.contenido != null) {
            return Base64.getEncoder().encodeToString(this.contenido);
        }
        return null;
    }

    // No se necesita setter para base64Encoded ya que no se almacenará
}
