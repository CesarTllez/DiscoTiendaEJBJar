/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.repositorio.implementacion;

import co.edu.unicundi.discotiendaejbjar.entidad.Cancion;
import co.edu.unicundi.discotiendaejbjar.repositorio.ICancionRep;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Clase que contiene los métodos necesarios para operar sobre la base de datos
 * haciendo uso del EntityManager.
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Stateless
public class CancionReplmp implements ICancionRep{
        
    /**
     * Permite realizar operaciones sobre la base de datos.
     */
    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;  
 
    @Override
    public Cancion buscarPorId(Integer id) {
        TypedQuery<Cancion> query = this.manager.createNamedQuery("Cancion.buscarPorId", Cancion.class);
        return query.setParameter("id", id).getSingleResult();
    }
    @Override
    public Cancion buscarPorNombre(String nombre) {
              TypedQuery<Cancion> query = this.manager.createNamedQuery("Cancion.buscarPorNombre", Cancion.class);
        return query.setParameter("nombre", nombre).getSingleResult();
    }

    @Override
    public Long validarExistenciaPorId(Integer id) {
       Long query = (Long)this.manager.createNamedQuery("Cancion.validarExistenciaPorId")
                .setParameter(1, id)
                .getSingleResult();
        return query;
    }

    @Override
    public Long validarExistenciaPorNombre(String nombre) {
              Long query = (Long)this.manager.createNamedQuery("Cancion.validarExistenciaPorNombre")
                .setParameter(1, nombre)
                .getSingleResult();
        return query;
    }

    @Override
    public List<Cancion> buscarTodo() {
              TypedQuery<Cancion> query = this.manager.createNamedQuery("Cliente.buscarTodos", Cancion.class);
        return query.getResultList();
    }

    @Override
    public void registrar(Cancion objeto) {
        this.manager.createNamedQuery("Cancion.registrar")
                .setParameter( 1, objeto.getNombre())
                .setParameter( 2, objeto.getDuracion())
                .setParameter( 3, objeto.getPrecio())
                .executeUpdate();
    }

    @Override
    public void actualizar(Cancion objeto) {
                this.manager.createNamedQuery("Cancion.actualizar")
                .setParameter("nombre", objeto.getNombre())
                .setParameter("duracion", objeto.getDuracion())
                .setParameter("precio", objeto.getPrecio())
                .executeUpdate();
    }

    @Override
    public void eliminarJPQL(Integer id) {
              this.manager.createNamedQuery("Cancion.eliminarPorIdJPQL")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void eliminarSQL(Integer id) {
                this.manager.createNamedQuery("Cancion.eliminarPorIdSQL")
                .setParameter( 1, id)
                .executeUpdate();
    }


}
