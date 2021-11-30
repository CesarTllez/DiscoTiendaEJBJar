/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.vista;

import java.io.Serializable;
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
@Table( name = "historial_venta_cancion")
@NamedQueries({
    //Buscar todo el historial de venta canciones.
    @NamedQuery(name = "HistorialVentaCancion.buscarTodos", query = "SELECT c FROM HistorialVentaCancion c"),
})
public class HistorialVentaCancion implements Serializable {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id_usuario;
    
     @Column(name = "nombre_usuario", nullable= false, length = 25, insertable = false, updatable = false)
    private String nombre_usuario;
     
     @Column(name = "cedula", nullable= false, length = 25, insertable = false, updatable = false)
    private String cedula;
     
     @Id
     @Column(name = "id_cancion")
     private Integer id_cancion;
     
     
     @Column(name = "nombre_cancion", nullable= false, length = 25, insertable = false, updatable = false)
    private String nombre_cancion;
     
     @Column(name = "precio", nullable= false, length = 25, insertable = false, updatable = false)
    private double precio;
    
     @Column(name = "fecha_compra", nullable= false, length = 25, insertable = false, updatable = false)
    private String fecha_compra;

    public HistorialVentaCancion() {
        
    }

    public HistorialVentaCancion(Integer id_usuario, String nombre_usuario, String cedula, Integer id_cancion, String nombre_cancion, double precio, String fecha_compra) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.cedula = cedula;
        this.id_cancion = id_cancion;
        this.nombre_cancion = nombre_cancion;
        this.precio = precio;
        this.fecha_compra = fecha_compra;
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

    public Integer getId_cancion() {
        return id_cancion;
    }

    public void setId_cancion(Integer id_cancion) {
        this.id_cancion = id_cancion;
    }

    public String getNombre_cancion() {
        return nombre_cancion;
    }

    public void setNombre_cancion(String nombre_cancion) {
        this.nombre_cancion = nombre_cancion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

   

   
     
    
}
