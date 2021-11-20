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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Clase que mapea la entidad que representa al token en la base de datos.
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Entity
@Table(name = "tokens")
//Anotación para queries JPQL's.
@NamedQueries({
    //Validar existencia token por contenido.
    @NamedQuery(name = "Token.validarExistenciaPorContenido", query = "SELECT COUNT(t) FROM Token t WHERE t.contenido = :contenido"),
    //Eliminar token por id.
    @NamedQuery(name = "Token.eliminarPorIdJPQL", query = "DELETE FROM Token t WHERE t.id = :id")
})
public class Token implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Column(name = "contenido", nullable = false, unique = true)
    private String contenido;

    public Token() {
    }
    
    public Token(Integer id, String contenido) {
        this.id = id;
        this.contenido = contenido;
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
    
}
