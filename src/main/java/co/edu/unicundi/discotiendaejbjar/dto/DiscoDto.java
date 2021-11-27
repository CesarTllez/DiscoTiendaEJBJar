/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.dto;

import java.io.Serializable;

/**
 *
 * @author cesar
 */
public class DiscoDto implements Serializable{
    
    private Integer id;

    private String nombre;

    private double precio;

    private Long numCanciones;

    private String anio;
    
    private String portada;
    
    private Integer idArtista;

    public DiscoDto() {
    }

    public DiscoDto(Integer id, String nombre, double precio, Long numCanciones, String anio, String portada, Integer idArtista) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.numCanciones = numCanciones;
        this.anio = anio;
        this.portada = portada;
        this.idArtista = idArtista;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Long getNumCanciones() {
        return numCanciones;
    }

    public void setNumCanciones(Long numCanciones) {
        this.numCanciones = numCanciones;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public Integer getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Integer idDisco) {
        this.idArtista = idDisco;
    }
    
}
