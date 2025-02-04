package com.MyGim.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Rutina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int cantidadEjercicios;
    private int repeticiones;
    private int tiempo;
    private double peso;

    @ManyToMany
    private List<Exercise> ejercicios;

    @ManyToOne
    private Usuario usuario;

    // Constructor sin argumentos
    public Rutina() {}

    // Constructor con argumentos
    public Rutina(String nombre, int cantidadEjercicios, int repeticiones, int tiempo, double peso, List<Exercise> ejercicios, Usuario usuario) {
        this.nombre = nombre;
        this.cantidadEjercicios = cantidadEjercicios;
        this.repeticiones = repeticiones;
        this.tiempo = tiempo;
        this.peso = peso;
        this.ejercicios = ejercicios;
        this.usuario = usuario;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadEjercicios() {
        return cantidadEjercicios;
    }

    public void setCantidadEjercicios(int cantidadEjercicios) {
        this.cantidadEjercicios = cantidadEjercicios;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public List<Exercise> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<Exercise> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
