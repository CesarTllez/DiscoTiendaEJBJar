/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.repositorio.implementacion;

import co.edu.unicundi.discotiendaejbjar.entidad.Administrador;
import co.edu.unicundi.discotiendaejbjar.repositorio.IAdministradorRep;
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
public class AdministradorRepimp implements IAdministradorRep{
    
    /**
     * Permite realizar operaciones sobre la base de datos.
     */
    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;

    /**
     * Método que permtie buscar a un administrador por id en la base de datos.
     * @param id
     * @return 
     */
    @Override
    public Administrador buscarPorId(Integer id) {
        TypedQuery<Administrador> query = this.manager.createNamedQuery("Administrador.buscarPorId", Administrador.class);
        return query.setParameter("id", id).getSingleResult();
    }
    
    /**
     * Método que permtie buscar a un administrador por correo en la base de datos.
     * @param correo
     * @return 
     */
    @Override
    public Administrador buscarPorCorreo(String correo) {
        TypedQuery<Administrador> query = this.manager.createNamedQuery("Administrador.buscarPorCorreo", Administrador.class);
        return query.setParameter("correo", correo).getSingleResult();
    }

    /**
     * Método que permtie buscar a todos los administradores en la base de datos.
     * @return 
     */
    @Override
    public List<Administrador> buscarTodo() {
        TypedQuery<Administrador> query = this.manager.createNamedQuery("Administrador.buscarTodos", Administrador.class);
        return query.getResultList();
    }

    /**
     * Método que permite registrar a un administrador en la base de datos.
     * @param objeto 
     */
    @Override
    public void registrar(Administrador objeto) {
        this.manager.createNamedQuery("Administrador.registrar")
                .setParameter( 1, objeto.getNombre())
                .setParameter( 2, objeto.getCorreo())
                .setParameter( 3, objeto.getContrasena())
                .executeUpdate();
    }

    /**
     * Método que permite actualizar a un administrador en la base de datos.
     * @param objeto 
     */
    @Override
    public void actualizar(Administrador objeto) {
        this.manager.createNamedQuery("Administrador.actualizar")
                .setParameter("id", objeto.getId())
                .setParameter("nombre", objeto.getNombre())
                .setParameter("correo", objeto.getCorreo())
                .setParameter("contrasena", objeto.getContrasena())
                .executeUpdate();
    }

    /**
     * Método que permite eliminar a un administrador por JPQL de la base de datos.
     * @param id 
     */
    @Override
    public void eliminarJPQL(Integer id) {
        this.manager.createNamedQuery("Administrador.eliminarPorIdJPQL")
                .setParameter("id", id)
                .executeUpdate();
    }

    /**
     * Método que permite eliminar a un administrador por SQL de la base de datos.
     * @param id 
     */
    @Override
    public void eliminarSQL(Integer id) {
        this.manager.createNamedQuery("Administrador.eliminarPorIdSQL")
                .setParameter( 1, id)
                .executeUpdate();
    }
    
    /**
     * Método que permite validar con el id si un administrador existe en la base de datos.
     * @param id
     * @return 
     */
    @Override
    public Long validarExistenciaPorId(Integer id) {
        Long query = (Long)this.manager.createNamedQuery("Administrador.validarExistenciaPorId")
                .setParameter(1, id)
                .getSingleResult();
        return query;
    }

    /**
     * Método que permite validar con el correo si un administrador existe en la base de datos.
     * @param correo
     * @return 
     */
    @Override
    public Long validarExistenciaPorCorreo(String correo) {
        Long query = (Long)this.manager.createNamedQuery("Administrador.validarExistenciaPorCorreo")
                .setParameter(1, correo)
                .getSingleResult();
        return query;
    }
    
}
