/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.entidad;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Clase que mapea la entidad que representa al usuario en la base de datos.
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Entity
@Table(name = "usuarios")
//Anotación para queries JPQL's.
@NamedQueries({
    //Buscar todos los usuarios.
    @NamedQuery(name = "Usuario.buscarTodos", query = "SELECT u FROM Usuario u"),
    //Buscar usuario por id.
    @NamedQuery(name = "Usuario.buscarPorId", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    //Buscar usuario por apodo.
    @NamedQuery(name = "Usuario.buscarPorApodo", query = "SELECT u FROM Usuario u WHERE u.apodo = :apodo"),
    //Validar existencia del usuario en la BD por apodo.
    @NamedQuery(name = "Usuario.validatExistenciaPorApodo", query = "SELECT COUNT(u) FROM Usuario u WHERE u.apodo = :apodo"),
    //Buscar usuario por correo.
    @NamedQuery(name = "Usuario.buscarPorCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo"),
    //Buscar usuario por cédula.
    @NamedQuery(name = "Usuario.buscarPorCedula", query = "SELECT u FROM Usuario u WHERE u.cedula = :cedula"),
    //Actualizar usuario.
    @NamedQuery(name = "Usuario.actualizar", query = "UPDATE Usuario u SET u.cedula = :cedula, u.nombres = :nombres, u.apellidos = :apellidos, u.correo = :correo, u.contrasena = :contrasena, u.fechaNacimiento = :fechaNacimiento WHERE u.id = :id"),
    //Eliminar usuario por id.
    @NamedQuery(name = "Usuario.eliminarPorIdJPQL", query = "DELETE FROM Usuario u WHERE u.id = :id")
})
//Anotación para queries SQL's
@NamedNativeQueries({
    //Registrar usuario.
    @NamedNativeQuery(name = "Usuario.registrar", query = "INSERT INTO usuarios (apodo, cedula, nombres, apellidos, correo, contrasena, fecha_nacimiento, id_rol) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"),
    //Validar la existencia del usuario en la BD por id.
    @NamedNativeQuery(name = "Usuario.validarExistenciaPorId", query = "SELECT COUNT(*) FROM usuarios WHERE id = ?") ,
    //Validar la existencia del usuario en la BD por cédula.
    @NamedNativeQuery(name = "Usuario.validarExistenciaPorCedula", query = "SELECT COUNT(*) FROM usuarios WHERE cedula = ?") ,
    //Validar la existencia del usuario en la BD por correo.
    @NamedNativeQuery(name = "Usuario.validarExistenciaPorCorreo", query = "SELECT COUNT(*) FROM usuarios WHERE correo = ?") ,
    //Eliminar usuario por id.
    @NamedNativeQuery(name = "Usuario.eliminarPorIdSQL", query = "DELETE FROM usuarios WHERE id = ?") 
})
public class Usuario implements Serializable{
    
    /**
     * Almacena el id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    /**
     * Almacena el apodo.
     */
    @NotNull(message = "Debe ingresar un apodo.")
    @Size(min = 3, max = 15, message = "Longitud requerida: Minimo 3 - Maximo 15 caracteres")
    @Column(name = "apodo", nullable = false, length = 15)
    private String apodo;
    
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
    @Size(min = 6, message = "Longitud requerida: Minimo 6")
    @Column(name = "contrasena", nullable = false)
    private String contrasena;
    
    /**
     * Almacena la fecha de nacimiento.
     */
    @Column(name = "fecha_nacimiento", nullable = false)
    private String fechaNacimiento;
    
    /**
     * Relación muchos a uno con rol.
     */
    @ManyToOne()
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;
    
    /**
     * Relación uno a uno con el token.
     */
    @OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY, orphanRemoval = true)
    private Token token;
    
    /**
     * Almacena el id del rol en un atributo volátil.
     */
    @Transient
    private Integer idRol;

    /**
     * Contructor pot defecto de la clase.
     */
    public Usuario() {
    }

    /**
     * Constructor en donde se inicializan los atributos de la clase.
     * @param id
     * @param apodo
     * @param cedula
     * @param nombres
     * @param apellidos
     * @param correo
     * @param contrasena
     * @param fechaNacimiento
     * @param rol 
     */
    public Usuario(Integer id, String apodo, String cedula, String nombres, String apellidos, String correo, String contrasena, String fechaNacimiento, Rol rol) {
        this.id = id;
        this.apodo = apodo;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasena = contrasena;
        this.fechaNacimiento = fechaNacimiento;
        this.rol = rol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public Token getToken() {
        return token;
    }
    
}
