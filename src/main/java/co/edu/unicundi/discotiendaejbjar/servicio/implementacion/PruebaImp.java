/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio.implementacion;

import co.edu.unicundi.discotiendaejbjar.entidad.Prueba;
import co.edu.unicundi.discotiendaejbjar.repositorio.IPruebaRep;
import javax.ejb.Stateless;
import co.edu.unicundi.discotiendaejbjar.servicio.IPruebaServicio;
import javax.ejb.EJB;

/**
 *
 * @author cesar
 */
@Stateless
public class PruebaImp implements IPruebaServicio{
    @EJB
    private IPruebaRep repositorio;
    @Override
    public void mostrar(Prueba object) {
        this.repositorio.mostrar(object);
    }
    
}
