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
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Clase que mapea la entidad que representa al cliente en la base de datos.
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Entity
@Table(name = "clientes")
//Anotación para queries JPQL's.
@NamedQueries({
    //Buscar todos los clientes.
    @NamedQuery(name = "Cliente.buscarTodos", query = "SELECT c FROM Cliente c"),
    //Buscar cliente por id.
    @NamedQuery(name = "Cliente.buscarPorId", query = "SELECT c FROM Cliente c WHERE c.id = :id"),
    //Buscar cliente por correo.
    @NamedQuery(name = "Cliente.buscarPorCorreo", query = "SELECT c FROM Cliente c WHERE c.correo = :correo"),
    //Buscar cliente por cédula.
    @NamedQuery(name = "Cliente.buscarPorCedula", query = "SELECT c FROM Cliente c WHERE c.cedula = :cedula"),
    //Actualizar cliente.
    @NamedQuery(name = "Cliente.actualizar", query = "UPDATE Cliente c SET c.cedula = :cedula, c.nombres = :nombres, c.apellidos = :apellidos, c.correo = :correo, c.contrasena = :contrasena, c.fechaNacimiento = :fechaNacimiento WHERE c.id = :id"),
    //Eliminar cliente por id.
    @NamedQuery(name = "Cliente.eliminarPorIdJPQL", query = "DELETE FROM Cliente c WHERE c.id = :id")
})
//Anotación para queries SQL's
@NamedNativeQueries({
    //Registrar cliente.
    @NamedNativeQuery(name = "Cliente.registrar", query = "INSERT INTO clientes (cedula, nombres, apellidos, correo, contrasena, fecha_nacimiento) VALUES (?, ?, ?, ?, ?, ?)"),
    //Validar la existencia del cliente en la BD por id.
    @NamedNativeQuery(name = "Cliente.validarExistenciaPorId", query = "SELECT COUNT(*) FROM clientes WHERE id = ?") ,
    //Validar la existencia del cliente en la BD por cédula.
    @NamedNativeQuery(name = "Cliente.validarExistenciaPorCedula", query = "SELECT COUNT(*) FROM clientes WHERE cedula = ?") ,
    //Validar la existencia del cliente en la BD por correo.
    @NamedNativeQuery(name = "Cliente.validarExistenciaPorCorreo", query = "SELECT COUNT(*) FROM clientes WHERE correo = ?") ,
    //Eliminar cliente por id.
    @NamedNativeQuery(name = "Cliente.eliminarPorIdSQL", query = "DELETE FROM clientes WHERE id = ?") 
})
public class Cliente implements Serializable{
    
    /**
     * Almacena el id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    /**
     * Almacena la cèdula.
     */
    @NotNull(message = "La cedula es obligatoria.")
    @Size(min = 8, max = 12, message = "Longitud requerida: Minimo 8 - Maximo 12 caracteres")
    @Column(name = "cedula", nullable = false, unique = true, length = 12)
    private String cedula;
    
    /**
     * Almacena los nombres.
     */
    @NotNull(message = "Debe ingresar minimo un nombre.")
    @Size(min = 3, max = 25, message = "Longitud requerida: Minimo 3 - Maximo 25 caracteres")
    @Column(name = "nombres", nullable = false, length = 25)
    private String nombres;
    
    /**
     * Almacena los apellidos.
     */
    @NotNull(message = "Debe ingresar minimo un apellido.")
    @Size(min = 3, max = 30, message = "Longitud requerida: Minimo 3 - Maximo 30 caracteres")
    @Column(name = "apellidos", nullable = false, length = 30)
    private String apellidos;
    
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
    
    /**
     * Almacena la fecha de nacimiento.
     */
    @Column(name = "fecha_nacimiento", nullable = false)
    private String fechaNacimiento;
    
    /*Rol*/

    /**
     * Contructor pot defecto de la clase.
     */
    public Cliente() {
    }

    /**
     * Constructor en donde se inicializan los atributos de la clase.
     * @param cedula
     * @param nombres
     * @param apellidos
     * @param correo
     * @param contrasena
     * @param fechaNacimiento 
     */
    public Cliente(String cedula, String nombres, String apellidos, String correo, String contrasena, String fechaNacimiento) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasena = contrasena;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
}
