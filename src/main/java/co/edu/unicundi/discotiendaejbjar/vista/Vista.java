/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.vista;

import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * Clase que permite traer la informacion de la vista
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */

@Entity
@Table( name = "vista")
@NamedQueries({
    //Buscar todos los canciones.
    @NamedQuery(name = "Vista.buscarTodos", query = "SELECT c FROM Vista c"),
})
public class Vista implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_artista")
    private Integer id_artista;
    
    @Column(name = "nombre_cancion", nullable= false, length = 25, insertable = false, updatable = false)
    private String nombre_cancion;
    
    @Column(name = "nombre_artista", nullable= false, length = 25, insertable = false, updatable = false)
    private String nombre_artista;

     @Column(name = "nombre_disco", nullable= false, length = 25, insertable = false, updatable = false)
     private String nombre_disco;
    
     @Column(name = "precio", nullable= false, length = 25, insertable = false, updatable = false)
     private double precio;
     
      @Column(name = "anio", nullable= false, length = 25, insertable = false, updatable = false)
      private String anio;
      
     public Vista() {
    }

    public Vista(Integer id_artista, String nombre_cancion, String nombre_artista, String nombre_disco, double precio, String anio) {
        this.id_artista = id_artista;
        this.nombre_cancion = nombre_cancion;
        this.nombre_artista = nombre_artista;
        this.nombre_disco = nombre_disco;
        this.precio = precio;
        this.anio = anio;
    }

    public Integer getId_artista() {
        return id_artista;
    }

    public void setId_artista(Integer id_artista) {
        this.id_artista = id_artista;
    }

    public String getNombre_cancion() {
        return nombre_cancion;
    }

    public void setNombre_cancion(String nombre_cancion) {
        this.nombre_cancion = nombre_cancion;
    }

    public String getNombre_artista() {
        return nombre_artista;
    }

    public void setNombre_artista(String nombre_artista) {
        this.nombre_artista = nombre_artista;
    }

    public String getNombre_disco() {
        return nombre_disco;
    }

    public void setNombre_disco(String nombre_disco) {
        this.nombre_disco = nombre_disco;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }
     
     
     
}
