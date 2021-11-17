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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Clase que mapea la entidad que representa al administrador en la base de datos.
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Entity
@Table(name = "administradores" )
public class Administrador implements Serializable {
    
    /**
     * Almacena el id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    /**
     * Almacena los nombres.
     */
    @NotNull(message = "Debe ingresar un nombre.")
    @Size(min = 3, max = 25, message = "Longitud requerida: Minimo 3 - Maximo 25 caracteres")
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;
    
    /**
     * Almacena el correo.
     */
    @NotNull(message = "El correo es obligatorio.")
    @Size(min = 9, max = 90, message = "Longitud requerida: Minimo 9 - Maximo 90 caracteres")
    @Pattern(regexp ="^[^@]+@[^@]+\\.[a-zA-Z]{2,}$", message = "Formato del correo no valido")
    @Column(name = "correo", nullable = false, unique = true, length = 90)
    private String correo;
    
    /**
     * Almacena la contraseña.
     */
    @NotNull (message = "La contrasena es obligatoria.")
    @Size(min = 6, max = 20, message = "Longitud requerida: Minimo 6 - Maximo 20 caracteres")
    @Column(name = "contrasena", nullable = false, length = 20)
    private String contrasena;
    
    /*Rol*/

    /**
     * Contructor pot defecto de la clase.
     */
    public Administrador() {
    }

    /**
     * Constructor en donde se inicializan los atributos de la clase.
     * @param id
     * @param nombre
     * @param correo
     * @param contrasena 
     */
    public Administrador(Integer id, String nombre, String correo, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
}
