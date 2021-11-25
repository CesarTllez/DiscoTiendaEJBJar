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
@Table(name = "usuario_cancion")
//Anotación para queries SQL's
@NamedNativeQueries({
    //Registrar usuario - disco..
    @NamedNativeQuery(name = "UsuarioCancion.registrar", query = "INSERT INTO usuario_cancion (cancion_id, usuario_id) VALUES (?, ?)"),
     //Registrar usuario - disco..
    @NamedNativeQuery(name = "UsuarioCancion.buscarUCPorIdUsuario", query = "SELECT cancion_id FROM usuario_cancion WHERE usuario_id = ?"),
})
public class UsuarioCancion implements Serializable{
    
    @EmbeddedId
    private UsuarioCancionPK usuarioCancionId;
    
    @ManyToOne()
    @MapsId("idUsuario")
    private Usuario usuario;
    
    @ManyToOne()
    @MapsId("idCancion")
    private Cancion cancion;

    public UsuarioCancion() {
    }

    public UsuarioCancion(UsuarioCancionPK usuarioCancionId, Usuario usuario, Cancion cancion) {
        this.usuarioCancionId = usuarioCancionId;
        this.usuario = usuario;
        this.cancion = cancion;
    }

    public UsuarioCancionPK getUsuarioCancionId() {
        return usuarioCancionId;
    }

    public void setUsuarioCancionId(UsuarioCancionPK usuarioCancionId) {
        this.usuarioCancionId = usuarioCancionId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }
    
}