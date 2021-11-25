/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.repositorio.implementacion;

import co.edu.unicundi.discotiendaejbjar.entidad.Formato;
import co.edu.unicundi.discotiendaejbjar.repositorio.IFormatoRep;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author cesar
 */
@Stateless
public class FormatoRepImp implements IFormatoRep{

    /**
     * Permite realizar operaciones sobre la base de datos.
     */
    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;
    
    @Override
    public List<Formato> buscarTodos() {
        TypedQuery<Formato> query = this.manager.createNamedQuery("Formato.buscarTodos", Formato.class);
        return query.getResultList();
    }

    @Override
    public Formato buscarPorId(Integer id) {
        TypedQuery<Formato> query = this.manager.createNamedQuery("Formato.buscarPorId", Formato.class);
        return query
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void registrar(Formato formato) {
        this.manager.createNamedQuery("Formato.registrar")
                .setParameter(1, formato.getNombre())
                .executeUpdate();
    }

    @Override
    public Long validarExistenciaPorId(Integer id) {
        Long query = (Long)this.manager.createNamedQuery("Formato.validarExistenciaPorId")
                .setParameter(1, id)
                .getSingleResult();
        return query;
    }

    @Override
    public Long validarExistenciaPorNombre(String nombre) {
        Long query = (Long)this.manager.createNamedQuery("Formato.validarExistenciaPorNombre")
                .setParameter(1, nombre)
                .getSingleResult();
        return query;
    }
    
}
