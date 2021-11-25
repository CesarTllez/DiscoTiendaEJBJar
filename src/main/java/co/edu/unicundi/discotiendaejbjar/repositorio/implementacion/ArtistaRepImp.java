/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.repositorio.implementacion;

import co.edu.unicundi.discotiendaejbjar.entidad.Artista;
import co.edu.unicundi.discotiendaejbjar.repositorio.IArtistaRep;
import co.edu.unicundi.discotiendaejbjar.vista.Vista;
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
public class ArtistaRepImp implements IArtistaRep{
    
    /**
     * Permite realizar operaciones sobre la base de datos.
     */
    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;

    /**
     * Método que permtie buscar a un artista por id en la base de datos.
     * @param id
     * @return 
     */
    @Override
    public Artista buscarPorId(Integer id) {
        TypedQuery<Artista> query = this.manager.createNamedQuery("Artista.buscarPorId", Artista.class);
        return query.setParameter("id", id).getSingleResult();
    }

    /**
     * Método que permtie buscar a todos los artistas en la base de datos.
     * @return 
     */
    @Override
    public List<Artista> buscarTodo() {
        TypedQuery<Artista> query = this.manager.createNamedQuery("Artista.buscarTodos", Artista.class);
        return query.getResultList();
    }

    /**
     * Método que permite registrar a un artista en la base de datos.
     * @param objeto 
     */
    @Override
    public void registrar(Artista objeto) {
        this.manager.createNamedQuery("Artista.registrar")
                .setParameter( 1, objeto.getNombre())
                 .executeUpdate();
    }

    /**
     * Método que permite actualizar a un artista en la base de datos.
     * @param objeto 
     */
    @Override
    public void actualizar(Artista objeto) {
        this.manager.createNamedQuery("Artista.actualizar")
                .setParameter("id", objeto.getId())
                .setParameter("nombre", objeto.getNombre())
                .executeUpdate();
    }

    /**
     * Método que permite eliminar a un artista por JPQL de la base de datos.
     * @param id 
     */
    @Override
    public void eliminarJPQL(Integer id) {
        this.manager.createNamedQuery("Artista.eliminarPorIdJPQL")
                .setParameter("id", id)
                .executeUpdate();
    }

    /**
     * Método que permite eliminar a un artista por SQL de la base de datos.
     * @param id 
     */
    @Override
    public void eliminarSQL(Integer id) {
        this.manager.createNamedQuery("Artista.eliminarPorIdSQL")
                .setParameter( 1, id)
                .executeUpdate();
    }
    
    /**
     * Método que permite validar con el id si un artista existe en la base de datos.
     * @param id
     * @return 
     */
    @Override
    public Long validarExistenciaPorId(Integer id) {
        Long query = (Long)this.manager.createNamedQuery("Artista.validarExistenciaPorId")
                .setParameter(1, id)
                .getSingleResult();
        return query;
    }

    /**
     * Método que permite validar con el nombre si un artista existe en la base de datos.
     * @param nombre
     * @return 
     */
    @Override
    public Long validarExistenciaPorNombre(String nombre) {
        Long query = (Long)this.manager.createNamedQuery("Artista.validarExistenciaPorNombre")
                .setParameter(1, nombre)
                .getSingleResult();
        return query;
    }

    @Override
    public List<Vista> vistaBuscar() {
                TypedQuery<Vista> query = this.manager.createNamedQuery("Vista.buscarTodos", Vista.class);
        return query.getResultList();
    }
    
}
