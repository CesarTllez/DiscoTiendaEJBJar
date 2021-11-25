/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.entidad;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author cesar
 */
@Entity
@Table(name = "usuario_disco")
public class UsuarioDisco implements Serializable {
    
    @EmbeddedId
    private UsuarioDiscoPK usuarioDiscoId;
    
    @ManyToOne()
    @MapsId("idUsuario")
    private Usuario usuario;
    
    @ManyToOne()
    @MapsId("idDisco")
    private Disco disco;

    public UsuarioDisco() {
    }

    public UsuarioDisco(UsuarioDiscoPK usuarioDiscoId, Usuario usuario, Disco disco) {
        this.usuarioDiscoId = usuarioDiscoId;
        this.usuario = usuario;
        this.disco = disco;
    }

    public UsuarioDiscoPK getUsuarioDiscoId() {
        return usuarioDiscoId;
    }

    public void setUsuarioDiscoId(UsuarioDiscoPK usuarioDiscoId) {
        this.usuarioDiscoId = usuarioDiscoId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Disco getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }
    
}
