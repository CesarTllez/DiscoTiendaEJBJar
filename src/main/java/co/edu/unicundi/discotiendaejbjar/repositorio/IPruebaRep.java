/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.repositorio;

import co.edu.unicundi.discotiendaejbjar.entidad.Prueba;
import javax.ejb.Local;

/**
 *
 * @author cesar
 */
@Local
public interface IPruebaRep {
    
    public void mostrar(Prueba object);
    
}
