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
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author cesar
 */
@Entity
@Table(name = "usuario_disco")
//Anotación para queries JPQL's.
@NamedQueries({
    //Buscar usuario - cancion por id del usuario.
    @NamedQuery(name = "UsuarioDisco.buscarUCPorIdUsuario", query = "SELECT ud FROM UsuarioDisco ud WHERE ud.usuario.id = :idUsuario"),
})
//Anotación para queries SQL's
@NamedNativeQueries({
    //Registrar usuario - disco..
    @NamedNativeQuery(name = "UsuarioDisco.registrar", query = "INSERT INTO usuario_disco (disco_id, usuario_id) VALUES (?, ?)"),
    //Registrar usuario - disco.
    @NamedNativeQuery(name = "UsuarioDisco.validarExistenciaPorIds", query = "SELECT COUNT(*) FROM usuario_disco WHERE disco_id = ? AND usuario_id = ?"),
})
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
