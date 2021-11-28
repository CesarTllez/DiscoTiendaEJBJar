/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.repositorio.implementacion;

import co.edu.unicundi.discotiendaejbjar.entidad.Disco;
import co.edu.unicundi.discotiendaejbjar.repositorio.IDiscoRep;
import co.edu.unicundi.discotiendaejbjar.vista.HistorialVentaDisco;
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
public class DiscoRepImp implements IDiscoRep {

    /**
     * Permite realizar operaciones sobre la base de datos.
     */
    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;

    /**
     * Metodo que permite buscar un disco por medio del nombre.
     * @param nombre
     * @return
     */
    @Override
    public Disco buscarPorNombre(String nombre) {
        TypedQuery<Disco> query = this.manager.createNamedQuery("Disco.buscarPorNombre", Disco.class);
        return query.setParameter("nombre", nombre).getSingleResult();
    }

    /**
     * Metodo que permite validar la existencia del disco por medio de la id en
     * la Base de datos.
     * @param id
     * @return
     */
    @Override
    public Long validarExistenciaPorId(Integer id) {
        Long query = (Long) this.manager.createNamedQuery("Disco.validarExistenciaPorId")
                .setParameter(1, id)
                .getSingleResult();
        return query;
    }

    /**
     * Metodo que permite validar la existencia del disco por medio del nombre
     * en la Base de datos.
     * @param nombre
     * @return
     */
    @Override
    public Long validarExistenciaPorNombre(String nombre) {
        Long query = (Long) this.manager.createNamedQuery("Disco.validarExistenciaPorNombre")
                .setParameter(1, nombre)
                .getSingleResult();
        return query;
    }

    /**
     * Metodo que permite buscar un disco por medio de la id.
     * @param id
     * @return
     */
    @Override
    public Disco buscarPorId(Integer id) {
        TypedQuery<Disco> query = this.manager.createNamedQuery("Disco.buscarPorId", Disco.class);
        return query.setParameter("id", id).getSingleResult();
    }

    /**
     * Metodo que permite buscar todos los discos en la base de datos.
     * @return
     */
    @Override
    public List<Disco> buscarTodo() {
        TypedQuery<Disco> query = this.manager.createNamedQuery("Disco.buscarTodos", Disco.class);
        return query.getResultList();
    }
    
    /**
     * Metodo que permite buscar todos los discos por id del artista en la base de datos.
     * @param id
     * @return
     */
    @Override
    public List<Disco> buscarTodosPorIdArtista(Integer id) {
        TypedQuery<Disco> query = this.manager.createNamedQuery("Disco.buscarTodosPorIdArtista", Disco.class);
        return query
                .setParameter("idArtista", id)
                .getResultList();
    }

    /**
     * Metodo que permite registrar el disco en la base de datos.
     * @param objeto
     */
    @Override
    public void registrar(Disco objeto) {
        this.manager.createNamedQuery("Disco.registrar")
                .setParameter(1, objeto.getNombre())
                .setParameter(2, objeto.getPrecio())
                .setParameter(3, objeto.getAnio())
                .setParameter(4, objeto.getPortada())
                .setParameter(5, objeto.getArtista().getId())
                .executeUpdate();
    }

    /**
     * Metodo que permite actualizar la información del disco y lo guarda en la
     * base de datos.
     * @param objeto
     */
    @Override
    public void actualizar(Disco objeto) {
        this.manager.createNamedQuery("Disco.actualizar")
                .setParameter("id", objeto.getId())
                .setParameter("nombre", objeto.getNombre())
                .setParameter("precio", objeto.getPrecio())
                .setParameter("anio", objeto.getAnio())
                .setParameter("portada", objeto.getPortada())
                .executeUpdate();
    }

    /**
     * Método que permite eliminar un disco por JPQL de la base de datos.
     * @param id
     */
    @Override
    public void eliminarJPQL(Integer id) {
        this.manager.createNamedQuery("Disco.eliminarPorIdJPQL")
                .setParameter("id", id)
                .executeUpdate();
    }

    /**
     * Método que permite eliminar un disco por SQL de la base de datos.
     * @param id
     */
    @Override
    public void eliminarSQL(Integer id) {
        this.manager.createNamedQuery("Disco.eliminarPorIdSQL")
                .setParameter(1, id)
                .executeUpdate();
    }
    
    /**
     * Método que permite registrar en la base de datos una compra del disco.
     * @param idDisco
     * @param idUsuario 
     * @param fecha
     */
    @Override
    public void registrarCompra(Integer idDisco, Integer idUsuario, String fecha) {
        this.manager.createNamedQuery("UsuarioDisco.registrar")
                .setParameter(1, idDisco)
                .setParameter(2, idUsuario)
                .setParameter(3, fecha)
                .executeUpdate();
    }

    @Override
    public List<HistorialVentaDisco> historialVentaDisco() {
       TypedQuery<HistorialVentaDisco> query = this.manager.createNamedQuery("HistorialVentaDisco.buscarTodos", HistorialVentaDisco.class);
        return query.getResultList();
    }

    /**
     * Método que valida la existencia de las dos llaves de la tabla usuario - disco.
     * @param idDisco
     * @param idUsuario
     * @return 
     */
    @Override
    public Long validarExistenciaPorIdsUD(Integer idDisco, Integer idUsuario) {
        Long query = (Long)this.manager.createNamedQuery("UsuarioDisco.validarExistenciaPorIds")
                .setParameter(1, idDisco)
                .setParameter(2, idUsuario)
                .getSingleResult();
        return query;
    }

}
