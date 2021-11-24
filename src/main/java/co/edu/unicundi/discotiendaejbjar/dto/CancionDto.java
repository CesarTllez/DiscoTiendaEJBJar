/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.dto;

/**
 *
 * @author cesar
 */
public class CancionDto {
    
    private Integer id;
    
    private String nombre;
    
    private String duracion;
    
    private double precio;
    
    private String portada;
    
    private Integer idDisco;

    public CancionDto() {
    }

    public CancionDto(Integer id, String nombre, String duracion, double precio, String portada, Integer idDisco) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.precio = precio;
        this.portada = portada;
        this.idDisco = idDisco;
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

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public Integer getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(Integer idDisco) {
        this.idDisco = idDisco;
    }
    
}
