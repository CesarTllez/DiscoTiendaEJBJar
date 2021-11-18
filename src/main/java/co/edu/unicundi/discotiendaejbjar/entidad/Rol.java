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
 * Clase que mapea la entidad que representa al rol en la base de datos.
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Entity
@Table(name = "roles")
//Anotación para queries JPQL's.
@NamedQueries({
    //Buscar todos los roles.
    @NamedQuery(name = "Rol.buscarTodos", query = "SELECT r FROM Rol r"),
    //Buscar rol por id.
    @NamedQuery(name = "Rol.buscarPorId", query = "SELECT r FROM Rol r WHERE r.id = :id"),
    //Actualizar rol.
    @NamedQuery(name = "Rol.actualizar", query = "UPDATE Rol r SET r.nombre = :nombre WHERE r.id = :id"),
    //Eliminar rol por id.
    @NamedQuery(name = "Rol.eliminarPorIdJPQL", query = "DELETE FROM Rol r WHERE r.id = :id")
})
//Anotación para queries SQL's
@NamedNativeQueries({
    //Registrar rol.
    @NamedNativeQuery(name = "Rol.registrar", query = "INSERT INTO roles (nombre) VALUES (?)"),
    //Validar la existencia del rol en la BD por id.
    @NamedNativeQuery(name = "Rol.validarExistenciaPorId", query = "SELECT COUNT(*) FROM roles WHERE id = ?") ,
    //Validar la existencia del rol en la BD por nombre.
    @NamedNativeQuery(name = "Rol.validarExistenciaPorNombre", query = "SELECT COUNT(*) FROM roles WHERE nombre = ?") ,
    //Eliminar rol por id.
    @NamedNativeQuery(name = "Rol.eliminarPorIdSQL", query = "DELETE FROM roles WHERE id = ?") 
})
public class Rol  implements Serializable{
    
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
    @Size(min = 7, max = 13, message = "Longitud requerida: Minimo 7 - Maximo 13 caracteres")
    @Column(name = "nombre", nullable = false, length = 13, unique = true)
    private String nombre;
    
    /**
     * Relación uno a muchos con cliente.
     */
    @OneToMany(mappedBy = "rol", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Cliente> cliente;

    /**
     * Contructor pot defecto de la clase.
     */
    public Rol() {
    }

    /**
     * Constructor en donde se inicializan los atributos de la clase.
     * @param id
     * @param nombre 
     */
    public Rol(Integer id, String nombre) {
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