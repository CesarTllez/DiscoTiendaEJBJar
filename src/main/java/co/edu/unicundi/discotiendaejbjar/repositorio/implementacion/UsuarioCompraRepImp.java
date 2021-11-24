/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.repositorio.implementacion;

import co.edu.unicundi.discotiendaejbjar.entidad.UsuarioCompra;
import co.edu.unicundi.discotiendaejbjar.repositorio.IUsuarioCompraRep;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cesar
 */
@Stateless
public class UsuarioCompraRepImp implements IUsuarioCompraRep{
    
    /**
     * Permite realizar operaciones sobre la base de datos.
     */
    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;

    @Override
    public void registrar(UsuarioCompra objeto) {
        this.manager.persist(objeto);
    }
    
}
