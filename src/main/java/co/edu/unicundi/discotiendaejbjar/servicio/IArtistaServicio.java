/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio;

import co.edu.unicundi.discotiendaejbjar.entidad.Artista;
import co.edu.unicundi.discotiendaejbjar.vista.Vista;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.TypedQuery;

/**
 *
 * @author cesar
 */
@Local
public interface IArtistaServicio extends ICRUDServicio<Artista, Integer, Artista>{
    
    public List<Vista> vistaBuscar();
    
}
