/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.entidad;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author cesar
 */
@Embeddable
public class UsuarioDiscoPK implements Serializable {
    
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;
    
    @Column(name = "id_disco", nullable = false)
    private Integer idDisco;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idUsuario);
        hash = 67 * hash + Objects.hashCode(this.idDisco);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuarioDiscoPK other = (UsuarioDiscoPK) obj;
        if (!Objects.equals(this.idUsuario, other.idUsuario)) {
            return false;
        }
        if (!Objects.equals(this.idDisco, other.idDisco)) {
            return false;
        }
        return true;
    }
    
}
