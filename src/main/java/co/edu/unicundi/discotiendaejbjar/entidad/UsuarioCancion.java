/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.entidad;

import java.io.Serializable;
import javax.persistence.Column;
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
//Anotación para queries JPQL's.
@NamedQueries({
    //Buscar usuario - cancion por id del usuario.
    @NamedQuery(name = "UsuarioCancion.buscarUCPorIdUsuario", query = "SELECT uc FROM UsuarioCancion uc WHERE uc.usuario.id = :idUsuario"),
})
//Anotación para queries SQL's
@NamedNativeQueries({
    //Registrar usuario - cancion.
    @NamedNativeQuery(name = "UsuarioCancion.registrar", query = "INSERT INTO usuario_cancion (cancion_id, usuario_id, fecha_compra) VALUES (?, ?, ?)"),
    //Registrar usuario - cancion.
    @NamedNativeQuery(name = "UsuarioCancion.validarExistenciaPorIds", query = "SELECT COUNT(*) FROM usuario_cancion WHERE cancion_id = ? AND usuario_id = ?"),
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
    
    @Column(name = "fecha_compra")
    private String fechaCompra;

    public UsuarioCancion() {
    }

    public UsuarioCancion(UsuarioCancionPK usuarioCancionId, Usuario usuario, Cancion cancion, String fechaCompra) {
        this.usuarioCancionId = usuarioCancionId;
        this.usuario = usuario;
        this.cancion = cancion;
        this.fechaCompra = fechaCompra;
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

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    
}
