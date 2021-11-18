/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.entidad;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase que mapea la entidad que representa al disco en la base de datos.
 *
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Entity
@Table(name = "discos")
//Anotación para queries JPQL's.
@NamedQueries({
    //Buscar todos los canciones.
    @NamedQuery(name = "Disco.buscarTodos", query = "SELECT c FROM Disco c"),
    //Buscar canciones por id.
    @NamedQuery(name = "Disco.buscarPorId", query = "SELECT c FROM Disco c WHERE c.id = :id"),
    //Buscar canciones por nombre.
    @NamedQuery(name = "Disco.buscarPorNombre", query = "SELECT c FROM Disco c WHERE c.nombre = :nombre"),
    //Actualizar canciones por id.
    @NamedQuery(name = "Disco.actualizar", query = "UPDATE Disco c SET c.nombre = :nombre, c.precio = :precio, c.numCanciones = :numCanciones, c.anio = :anio WHERE c.id = :id"),
    //Eliminar cancion por id.
    @NamedQuery(name = "Disco.eliminarPorIdJPQL", query = "DELETE FROM Disco c WHERE c.id = :id")
})
//Anotación para queries SQL's
@NamedNativeQueries({
    //Registrar cancion.
    @NamedNativeQuery(name = "Disco.registrar", query = "INSERT INTO discos (nombre, precio, numCanciones, anio) VALUES (?, ?, ?, ?)"),
    //Validar la existencia del canciones en la BD por id.
    @NamedNativeQuery(name = "Disco.validarExistenciaPorId", query = "SELECT COUNT(*) FROM discos WHERE id = ?"),
    //Validar la existencia del canciones en la BD por nombre.
    @NamedNativeQuery(name = "Disco.validarExistenciaPorNombre", query = "SELECT COUNT(*) FROM discos WHERE nombre = ?"),
    //Validar la existencia del canciones en la BD.
    @NamedNativeQuery(name = "Disco.eliminarPorIdSQL", query = "DELETE FROM discos WHERE id = ?")
})

public class Disco implements Serializable {

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
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;

    /**
     * Almacena el precio del disco
     */
    @NotNull(message = "Debe ingresar minimo un precio.")
    @Column(name = "precio", nullable = false, length = 25)
    private double precio;

    /**
     * Almacena el numero canciones
     */
    @NotNull(message = "Debe ingresar minimo un numero de canciones.")
    @Min(value = 1, message = "Debe tener como minimo una cancion")
    @Max(value = 1000, message = "maximo son 1000")
    @Column(name = "numCanciones", nullable = false, length = 25)
    private Integer numCanciones;

    /**
     * Almacena un año
     */
    @NotNull(message = "Debe ingresar minimo un año.")
    @Size(min = 2, max = 4, message = "Longitud requerida: Minimo 3 - Maximo 25 caracteres")
    @Column(name = "anio", nullable = false, length = 25)
    private String anio;
    
    /**
     * Relación muchos a uno con artista.
     */
    @ManyToOne()
    @JoinColumn(name = "id_artista", nullable = false)
    private Artista artista;

    /**
     * Relación uno a muchos con cliente.
     */
    @OneToMany(mappedBy = "disco", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Cancion> cancion;
    
    /**
     * Contructor pot defecto de la clase.
     */
    public Disco() {

    }

    /**
     * Constructor en donde se inicializan los atributos de la clase.
     * @param id
     * @param nombre
     * @param precio
     * @param numCanciones
     * @param anio
     * @param artista
     */
    public Disco(Integer id, String nombre, double precio, Integer numCanciones, String anio, Artista artista) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.numCanciones = numCanciones;
        this.anio = anio;
        this.artista = artista;
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

    public int getNumCanciones() {
        return numCanciones;
    }

    public void setNumCanciones(int numCanciones) {
        this.numCanciones = numCanciones;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
    
}
