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
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase que mapea la entidad que representa al artista en la base de datos.
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Entity
@Table(name = "artista" )
//Anotación para queries JPQL's.
@NamedQueries({
    //Buscar a todos los artistas.
    @NamedQuery(name = "Artista.buscarTodos", query = "SELECT a FROM Artista a"),
    //Buscar artista por id.
    @NamedQuery(name = "Artista.buscarPorId", query = "SELECT a FROM Artista a WHERE a.id = :id"),
    //Actualizar artista.
    @NamedQuery(name = "Artista.actualizar", query = "UPDATE Artista a SET a.nombre = :nombre, a.portada = :portada WHERE a.id = :id"),
    //Eliminar artista por id.
    @NamedQuery(name = "Artista.eliminarPorIdJPQL", query = "DELETE FROM Artista a WHERE a.id = :id")
})
//Anotación para queries SQL's
@NamedNativeQueries({
    //Registrar artista.
    @NamedNativeQuery(name = "Artista.registrar", query = "INSERT INTO artista (nombre, portada) VALUES (?, ?)"),
    //Validar la existencia del artista en la BD por id.
    @NamedNativeQuery(name = "Artista.validarExistenciaPorId", query = "SELECT COUNT(*) FROM artista WHERE id = ?") ,
    //Validar la existencia del artista en la BD por nombre.
    @NamedNativeQuery(name = "Artista.validarExistenciaPorNombre", query = "SELECT COUNT(*) FROM artista WHERE nombre = ?") ,
    //Eliminar artista por id.
    @NamedNativeQuery(name = "Artista.eliminarPorIdSQL", query = "DELETE FROM artista WHERE id = ?") 
})
public class Artista implements Serializable {
    
    /**
     * Almacena el id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    /**
     * Almacena el nombre.
     */
    @NotNull(message = "Debe ingresar un nombre.")
    @Size(min = 3, max = 25, message = "Longitud requerida: Minimo 3 - Maximo 25 caracteres")
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;
    
    @Column(name = "portada", nullable = false)
    private String portada;
    
    /**
     * Relación uno a muchos con disco.
     */
    @OneToMany(mappedBy = "artista", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Disco> disco;

    /**
     * Contructor pot defecto de la clase.
     */
    public Artista() {
    }

    /**
     * Constructor en donde se inicializan los atributos de la clase.
     * @param id
     * @param nombre 
     * @param portada
     */
    public Artista(Integer id, String portada, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.portada = portada;
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

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }
    
}
