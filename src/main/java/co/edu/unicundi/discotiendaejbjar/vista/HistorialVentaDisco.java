/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.vista;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table( name = "historial_venta_disco")
@NamedQueries({
    //Buscar todos los canciones.
    @NamedQuery(name = "HistorialVentaDisco.buscarTodos", query = "SELECT c FROM HistorialVentaDisco c"),
})
public class HistorialVentaDisco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id_usuario;
    
     @Column(name = "nombre_usuario", nullable= false, length = 25, insertable = false, updatable = false)
    private String nombre_usuario;
     
    @Column(name = "cedula", nullable= false, length = 25, insertable = false, updatable = false)
    private String cedula;
    
     @Id
     @Column(name = "id_disco")
     private Integer id_disco;
     
     
     @Column(name = "nombre_disco", nullable= false, length = 25, insertable = false, updatable = false)
    private String nombre_disco;
     
     @Column(name = "precio", nullable= false, length = 25, insertable = false, updatable = false)
    private double precio;

    public HistorialVentaDisco() {
    }

    public HistorialVentaDisco(Integer id_usuario, String nombre_usuario, String cedula, Integer id_disco, String nombre_disco, double precio) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.cedula = cedula;
        this.id_disco = id_disco;
        this.nombre_disco = nombre_disco;
        this.precio = precio;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Integer getId_disco() {
        return id_disco;
    }

    public void setId_disco(Integer id_disco) {
        this.id_disco = id_disco;
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
      
    
}
