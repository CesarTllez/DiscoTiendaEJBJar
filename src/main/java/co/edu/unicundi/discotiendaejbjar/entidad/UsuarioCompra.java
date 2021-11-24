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
@Table(name = "usuario_compra")
public class UsuarioCompra implements Serializable {
    
    @EmbeddedId
    private UsuarioCompraPK usuarioCompraId;
    
    @ManyToOne()
    @MapsId("idUsuario")
    private Usuario usuario;
    
    @ManyToOne()
    @MapsId("idCompra")
    private Compra compra;

    public UsuarioCompra() {
    }

    public UsuarioCompra(UsuarioCompraPK usuarioCompraId, Usuario usuario, Compra compra) {
        this.usuarioCompraId = usuarioCompraId;
        this.usuario = usuario;
        this.compra = compra;
    }

    public UsuarioCompraPK getUsuarioCompraId() {
        return usuarioCompraId;
    }

    public void setUsuarioCompraId(UsuarioCompraPK usuarioCompraId) {
        this.usuarioCompraId = usuarioCompraId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    
}
