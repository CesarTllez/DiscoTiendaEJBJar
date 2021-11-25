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
 *
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Stateless
public class CancionRepImp implements ICancionRep {

    /**
     * Permite realizar operaciones sobre la base de datos.
     */
    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;

    /**
     * Metodo que permite buscar una cancion por medio de la id
     *
     * @param id
     * @return
     */
    @Override
    public Cancion buscarPorId(Integer id) {
        TypedQuery<Cancion> query = this.manager.createNamedQuery("Cancion.buscarPorId", Cancion.class);
        return query.setParameter("id", id).getSingleResult();
    }

    /**
     * Metodo que permite buscar una cancion por medio del nombre
     *
     * @param nombre
     * @return
     */
    @Override
    public Cancion buscarPorNombre(String nombre) {
        TypedQuery<Cancion> query = this.manager.createNamedQuery("Cancion.buscarPorNombre", Cancion.class);
        return query.setParameter("nombre", nombre).getSingleResult();
    }
    
    /**
     * Metodo que permite buscar todas las canciones por id del disco en la base de datos.
     * @return 
     */
    @Override
    public List<Cancion> buscarTodosPorIdDisco(Integer idDisco) {
       TypedQuery<Cancion> query = this.manager.createNamedQuery("Cancion.buscarTodosPorIdDisco", Cancion.class);
       return query.setParameter("idDisco", idDisco).getResultList();
    }

    /**
     * Metodo que permite validar la existencia de la cancion por medio de la id
     * en la Bd
     *
     * @param id
     * @return
     */
    @Override
    public Long validarExistenciaPorId(Integer id) {
        Long query = (Long) this.manager.createNamedQuery("Cancion.validarExistenciaPorId")
                .setParameter(1, id)
                .getSingleResult();
        return query;
    }

    /**
     * Metodo que permite validar la existencia de la cancion por medio del
     * nombre en la Bd
     *
     * @param nombre
     * @return
     */
    @Override
    public Long validarExistenciaPorNombre(String nombre) {
        Long query = (Long) this.manager.createNamedQuery("Cancion.validarExistenciaPorNombre")
                .setParameter(1, nombre)
                .getSingleResult();
        return query;
    }

    /**
     * Metodo que permite buscar todas las canciones de la base de datos
     *
     * @return
     */
    @Override
    public List<Cancion> buscarTodo() {
        TypedQuery<Cancion> query = this.manager.createNamedQuery("Cancion.buscarTodos", Cancion.class);
        return query.getResultList();
    }

    /**
     * Metodo que permite registrar las canciones a la base de datos.
     * @param objeto
     */
    @Override
    public void registrar(Cancion objeto) {
        this.manager.persist(objeto);
    }

    /**
     * Metodo que permite actualizar la información de las canciones y lo guarda
     * en la base de datos
     *
     * @param objeto
     */
    @Override
    public void actualizar(Cancion objeto) {
        this.manager.createNamedQuery("Cancion.actualizar")
                .setParameter("id", objeto.getId())
                .setParameter("nombre", objeto.getNombre())
                .setParameter("duracion", objeto.getDuracion())
                .setParameter("precio", objeto.getPrecio())
                .executeUpdate();
    }

    /**
     * Método que permite eliminar una cancion por JPQL de la base de datos.
     *
     * @param id
     */
    @Override
    public void eliminarJPQL(Integer id) {
        this.manager.createNamedQuery("Cancion.eliminarPorIdJPQL")
                .setParameter("id", id)
                .executeUpdate();
    }

    /**
     * Método que permite eliminar una cancion por SQL de la base de datos.
     *
     * @param id
     */
    @Override
    public void eliminarSQL(Integer id) {
        this.manager.createNamedQuery("Cancion.eliminarPorIdSQL")
                .setParameter(1, id)
                .executeUpdate();
    }

    /**
     * Método que permite registrar en la base de datos una compra de una canción.
     * @param idCancion
     * @param idUsuario 
     */
    @Override
    public void registrarCompra(Integer idCancion, Integer idUsuario) {
        this.manager.createNamedQuery("UsuarioCancion.registrar")
                .setParameter(1, idCancion)
                .setParameter(2, idUsuario)
                .executeUpdate();
    }

}
