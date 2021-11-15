/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.repositorio.implementacion;

import co.edu.unicundi.discotiendaejbjar.entidad.Prueba;
import co.edu.unicundi.discotiendaejbjar.repositorio.IPruebaRep;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cesar
 */
@Stateless
public class PruebaImpRep implements IPruebaRep{
    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;
    @Override
    public void mostrar(Prueba object) {    
      this.manager.persist(object);
  
    }
    
}
