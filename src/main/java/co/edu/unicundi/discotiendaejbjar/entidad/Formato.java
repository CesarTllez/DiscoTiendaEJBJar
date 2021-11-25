/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.entidad;

import java.io.Serializable;
import java.util.List;
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
 * Clase que mapea la entidad que representa al formato en la base de datos.
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Entity
@Table(name = "formato")
//Anotación para queries JPQL's.
@NamedQueries({
    //Buscar todos los formatos.
    @NamedQuery(name = "Formato.buscarTodos", query = "SELECT f FROM Formato f"),
    //Buscar formato por id.
    @NamedQuery(name = "Formato.buscarPorId", query = "SELECT f FROM Formato f WHERE f.id = :id"),
})
//Anotación para queries SQL's
@NamedNativeQueries({
    //Registrar formato.
    @NamedNativeQuery(name = "Formato.registrar", query = "INSERT INTO formato (nombre) VALUES (?)"),
    //Validar la existencia del formato en la BD por id.
    @NamedNativeQuery(name = "Formato.validarExistenciaPorId", query = "SELECT COUNT(*) FROM formato WHERE id = ?") ,
    //Validar la existencia del formato en la BD por nombre.
    @NamedNativeQuery(name = "Formato.validarExistenciaPorNombre", query = "SELECT COUNT(*) FROM formato WHERE nombre = ?") ,
})
public class Formato implements Serializable{
    
    /**
     * Almacena el id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    /**
     * Almacena el nombre.
     */
    @NotNull(message = "Debe ingresar un formato.")
    @Size(min = 3, max = 4, message = "Longitud requerida: Minimo 3 - Maximo 4 caracteres")
    @Column(name = "nombre", nullable = false, unique = true, length = 4)
    private String nombre;
    
    /**
     * Relación uno a muchos con canción.
     */
    @OneToMany(mappedBy = "formato", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Cancion> cancion;

    /**
     * Constructor por defecto de la clase.
     */
    public Formato() {
    }
    
    /**
     * Constructot que inicializa los atributos de la clase.
     * @param id
     * @param nombre 
     */
    public Formato(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
    
}
