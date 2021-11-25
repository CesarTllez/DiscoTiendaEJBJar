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
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * Clase que mapea la entidad que representa al token en la base de datos.
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Entity
@Table(name = "token")
//Anotación para queries JPQL's.
@NamedQueries({
    //Buscar token por el id del usuario..
    @NamedQuery(name = "Token.buscarPorIdUsuario", query = "SELECT t FROM Token t WHERE t.usuario.id = :idUsuario"),
    //Buscar token por el id del usuario..
    @NamedQuery(name = "Token.buscarPorContenido", query = "SELECT t FROM Token t WHERE t.contenido = :contenido"),
    //Validar existencia token por contenido.
    @NamedQuery(name = "Token.validarExistenciaPorContenido", query = "SELECT COUNT(t) FROM Token t WHERE t.contenido = :contenido"),
    //Validar existencia token por id del usuario.
    @NamedQuery(name = "Token.validarExistenciaPorIdUsuario", query = "SELECT COUNT(t) FROM Token t WHERE t.usuario.id = :idUsuario"),
    //Eliminar token por id.
    @NamedQuery(name = "Token.eliminarPorIdJPQL", query = "DELETE FROM Token t WHERE t.usuario.id = :idUsuario"),
    //Eliminar token por contenido.
    @NamedQuery(name = "Token.eliminarPorContenidoJPQL", query = "DELETE FROM Token t WHERE t.contenido = :contenido")
})
//Anotación para queries SQL's
@NamedNativeQueries({
    //Registrar token.
    @NamedNativeQuery(name = "Token.registrar", query = "INSERT INTO token (contenido, id_usuario) VALUES (?, ?)")
})
public class Token implements Serializable{
    
    /**
     * Almacena el id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    /**
     * Almacena el contenido (token)
     */
    @NotNull
    @Column(name = "contenido", nullable = false, unique = true)
    private String contenido;
    
    /**
     * Relación uno a uno con usuario.
     */
    @OneToOne()
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
    
    /**
     * Almacena el id del usuario en un atributo volátil.
     */
    @Transient
    private Integer idUsuario;

    /**
     * Contructor pot defecto de la clase.
     */
    public Token() {
    }

    /**
     * Constructor en donde se inicializan los atributos de la clase.
     * @param id
     * @param contenido
     * @param usuario
     * @param idUsuario 
     */
    public Token(Integer id, String contenido, Usuario usuario, Integer idUsuario) {
        this.id = id;
        this.contenido = contenido;
        this.usuario = usuario;
        this.idUsuario = idUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
