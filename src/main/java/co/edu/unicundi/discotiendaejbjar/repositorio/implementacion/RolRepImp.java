/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.repositorio.implementacion;

import co.edu.unicundi.discotiendaejbjar.entidad.Rol;
import co.edu.unicundi.discotiendaejbjar.repositorio.IRolRep;
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
public class RolRepImp implements IRolRep {
    
    /**
     * Permite realizar operaciones sobre la base de datos.
     */
    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;

    /**
     * Método que permtie buscar un rol por id en la base de datos.
     * @param id
     * @return Rol
     */
    @Override
    public Rol buscarPorId(Integer id) {
        TypedQuery<Rol> query = this.manager.createNamedQuery("Rol.buscarPorId", Rol.class);
        return query.setParameter("id", id).getSingleResult();
    }

    /**
     * Método que permtie buscar a todos los roles en la base de datos.
     * @return roles
     */
    @Override
    public List<Rol> buscarTodo() {
        TypedQuery<Rol> query = this.manager.createNamedQuery("Rol.buscarTodos", Rol.class);
        return query.getResultList();
    }

    /**
     * Método que permite registrar un rol en la base de datos.
     * @param objeto 
     */
    @Override
    public void registrar(Rol objeto) {
         this.manager.createNamedQuery("Rol.registrar")
                .setParameter( 1, objeto.getNombre())
                 .executeUpdate();
    }

    /**
     * Método que permite actualizar a rol en la base de datos.
     * @param objeto 
     */
    @Override
    public void actualizar(Rol objeto) {
        this.manager.createNamedQuery("Rol.actualizar")
                .setParameter("id", objeto.getId())
                .setParameter("nombre", objeto.getNombre())
                .executeUpdate();
    }

    /**
     * Método que permite eliminar un rol por JPQL de la base de datos.
     * @param id 
     */
    @Override
    public void eliminarJPQL(Integer id) {
        this.manager.createNamedQuery("Rol.eliminarPorIdJPQL")
                .setParameter("id", id)
                .executeUpdate();
    }

    /**
     * Método que permite eliminar un rol por SQL de la base de datos.
     * @param id 
     */
    @Override
    public void eliminarSQL(Integer id) {
        this.manager.createNamedQuery("Rol.eliminarPorIdSQL")
                .setParameter( 1, id)
                .executeUpdate();
    }
    
    /**
     * Método que permite validar con el id si un rol existe en la base de datos.
     * @param id
     * @return 
     */
    @Override
    public Long validarExistenciaPorId(Integer id) {
        Long query = (Long)this.manager.createNamedQuery("Rol.validarExistenciaPorId")
                .setParameter(1, id)
                .getSingleResult();
        return query;
    }

    /**
     * Método que permite validar con el nombre si un rol existe en la base de datos.
     * @param nombre
     * @return 
     */
    @Override
    public Long validarExistenciaPorNombre(String nombre) {
        Long query = (Long)this.manager.createNamedQuery("Rol.validarExistenciaPorNombre")
                .setParameter(1, nombre)
                .getSingleResult();
        return query;
    }
    
}
