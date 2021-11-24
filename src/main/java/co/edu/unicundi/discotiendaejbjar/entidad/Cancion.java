/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase que mapea la entidad que representa la canción en la base de datos.
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
 @Entity
 @Table(name = "cancion")
 //Anotación para queries JPQL's.
@NamedQueries({
    //Buscar todos los canciones.
    @NamedQuery(name = "Cancion.buscarTodos", query = "SELECT c FROM Cancion c"),
    //Buscar canciones por id.
    @NamedQuery(name = "Cancion.buscarPorId", query = "SELECT c FROM Cancion c WHERE c.id = :id"),
    //Buscar canciones por nombre.
    @NamedQuery(name = "Cancion.buscarPorNombre", query = "SELECT c FROM Cancion c WHERE c.nombre = :nombre"),
    //Buscar canciones por disco.
    @NamedQuery(name = "Cancion.buscarTodosPorIdDisco", query = "SELECT c FROM Cancion c WHERE c.disco.id = :idDisco"),
    //Actualizar canciones por id.
    @NamedQuery(name = "Cancion.actualizar", query = "UPDATE Cancion c SET c.nombre = :nombre, c.duracion = :duracion, c.precio = :precio  WHERE c.id = :id"),
    //Eliminar cancion por id.
    @NamedQuery(name = "Cancion.eliminarPorIdJPQL", query = "DELETE FROM Cancion c WHERE c.id = :id")
})
//Anotación para queries SQL's
@NamedNativeQueries({
     //Registrar cancion.
    @NamedNativeQuery(name = "Cancion.registrar", query = "INSERT INTO cancion (nombre, duracion, precio, id_disco) VALUES (?, ?, ?, ?)"),
    //Validar la existencia de la canción en la BD por id.
    @NamedNativeQuery(name = "Cancion.validarExistenciaPorId", query = "SELECT COUNT(*) FROM cancion WHERE id = ?") ,
    //Validar la existencia de la canción en la BD por nombre.
    @NamedNativeQuery(name = "Cancion.validarExistenciaPorNombre", query = "SELECT COUNT(*) FROM cancion WHERE nombre = ?") ,
    //Validar la existencia de la canción en la BD.
    @NamedNativeQuery(name = "Cancion.eliminarPorIdSQL", query = "DELETE FROM cancion WHERE id = ?") 
})
 
public class Cancion implements Serializable{
        
    /**
     * Almacena el id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
     /**
     * Almacena los nombres.
     */
    @NotNull(message = "Debe ingresar minimo un nombre.")
    @Size(min = 3, max = 25, message = "Longitud requerida: Minimo 3 - Maximo 25 caracteres")
    @Column(name = "nombre", nullable = false, unique = true, length = 25)
    private String nombre;
    
     /**
     * Almacena la duracion de la cancion
     */
    @NotNull(message = "Debe ingresar minimo un nombre.")
    @Size(min = 3, max = 25, message = "Longitud requerida: Minimo 3 - Maximo 25 caracteres")
    @Column(name = "duracion", nullable = false, length = 25)
    private String duracion;
    
     /**
     * Almacena el precio.
     */
    @NotNull(message = "Debe ingresar un precio.")
    @Column(name = "precio", nullable = false)
    private double precio;
    
    /**
     * Relación muchos a uno con rol.
     */
    @ManyToOne
    @JoinColumn(name = "id_disco", nullable = false)
    private Disco disco;
    
    /**
     * Atributo volàtil que almacena el id del disco.
     */
    @Transient
    private Integer idDisco;

     /**
     * Contructor pot defecto de la clase.
     */
    public Cancion(){
    
    }

    /**
     * Constructor en donde se inicializan los atributos de la clase.
     * @param id
     * @param nombre
     * @param duracion
     * @param precio
     * @param disco 
     */
    public Cancion(Integer id, String nombre, String duracion, double precio, Disco disco) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.precio = precio;
        this.disco = disco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
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

    public Disco getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }

    public Integer getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(Integer idDisco) {
        this.idDisco = idDisco;
    }
    
}
