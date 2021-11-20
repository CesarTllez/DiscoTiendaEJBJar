/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio;

import co.edu.unicundi.discotiendaejbjar.entidad.Artista;
import javax.ejb.Local;

/**
 *
 * @author cesar
 */
@Local
public interface IArtistaServicio extends ICRUDServicio<Artista, Integer, Artista>{
    
}
