/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.repositorio.implementacion;

import co.edu.unicundi.discotiendaejbjar.entidad.Usuario;
import co.edu.unicundi.discotiendaejbjar.repositorio.IUsuarioRep;
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
public class UsuarioRepImp implements IUsuarioRep{
    
    /**
     * Permite realizar operaciones sobre la base de datos.
     */
    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;

    /**
     * Método que permtie buscar a un usuario por id en la base de datos.
     * @param id
     * @return 
     */
    @Override
    public Usuario buscarPorId(Integer id) {
        TypedQuery<Usuario> query = this.manager.createNamedQuery("Usuario.buscarPorId", Usuario.class);
        return query.setParameter("id", id).getSingleResult();
    }
    
    /**
     * Método que permtie buscar a un usuario por apodo en la base de datos.
     * @param apodo
     * @return 
     */
    @Override
    public Usuario buscarPorApodo(String apodo) {
        TypedQuery<Usuario> query = this.manager.createNamedQuery("Usuario.buscarPorApodo", Usuario.class);
        return query.setParameter("apodo", apodo).getSingleResult();
    }
    
    /**
     * Método que permtie buscar a un usuario por correo en la base de datos.
     * @param correo
     * @return 
     */
    @Override
    public Usuario buscarPorCorreo(String correo) {
        TypedQuery<Usuario> query = this.manager.createNamedQuery("Usuario.buscarPorCorreo", Usuario.class);
        return query.setParameter("correo", correo).getSingleResult();
    }

    /**
     * Método que permtie buscar a un usuario por cedula en la base de datos.
     * @param cedula
     * @return 
     */
    @Override
    public Usuario buscarPorCedula(String cedula) {
        TypedQuery<Usuario> query = this.manager.createNamedQuery("Usuario.buscarPorCedula", Usuario.class);
        return query.setParameter("cedula", cedula).getSingleResult();
    }

    /**
     * Método que permtie buscar a todos los usuarios en la base de datos.
     * @return 
     */
    @Override
    public List<Usuario> buscarTodo() {
        TypedQuery<Usuario> query = this.manager.createNamedQuery("Usuario.buscarTodos", Usuario.class);
        return query.getResultList();
    }

    /**
     * Método que permite registrar a un usuario en la base de datos.
     * @param objeto 
     */
    @Override
    public void registrar(Usuario objeto) {
        this.manager.createNamedQuery("Usuario.registrar")
                .setParameter( 1, objeto.getApodo())
                .setParameter( 2, objeto.getCedula())
                .setParameter( 3, objeto.getNombres())
                .setParameter( 4, objeto.getApellidos())
                .setParameter( 5, objeto.getCorreo())
                .setParameter( 6, objeto.getContrasena())
                .setParameter( 7, objeto.getFechaNacimiento())
                .setParameter( 8, objeto.getRol().getId())
                .executeUpdate();
    }

    /**
     * Método que permite actualizar a un usuario en la base de datos.
     * @param objeto 
     */
    @Override
    public void actualizar(Usuario objeto) {
        this.manager.createNamedQuery("Usuario.actualizar")
                .setParameter("id", objeto.getId())
                .setParameter("cedula", objeto.getCedula())
                .setParameter("nombres", objeto.getNombres())
                .setParameter("apellidos", objeto.getApellidos())
                .setParameter("correo", objeto.getCorreo())
                .setParameter("contrasena", objeto.getContrasena())
                .setParameter("fechaNacimiento", objeto.getFechaNacimiento())
                .executeUpdate();
    }

    /**
     * Método que permite eliminar a un usuario por JPQL de la base de datos.
     * @param id 
     */
    @Override
    public void eliminarJPQL(Integer id) {
        this.manager.createNamedQuery("Usuario.eliminarPorIdJPQL")
                .setParameter("id", id)
                .executeUpdate();
    }

    /**
     * Método que permite eliminar a un usuario por SQL de la base de datos.
     * @param id 
     */
    @Override
    public void eliminarSQL(Integer id) {
        this.manager.createNamedQuery("Usuario.eliminarPorIdSQL")
                .setParameter( 1, id)
                .executeUpdate();
    }
    
     /**
     * Método que permite validar con el id si un usuario existe en la base de datos.
     * @param id
     * @return 
     */
    @Override
    public Long validarExistenciaPorId(Integer id) {
        Long query = (Long)this.manager.createNamedQuery("Usuario.validarExistenciaPorId")
                .setParameter(1, id)
                .getSingleResult();
        return query;
    }
    
    /**
     * Método que permite validar con el apodo si un usuario existe en la base de datos.
     * @param apodo
     * @return 
     */
    @Override
    public Long validarExistenciaPorApodo(String apodo) {
        Long query = (Long)this.manager.createNamedQuery("Usuario.validatExistenciaPorApodo")
                .setParameter("apodo", apodo)
                .getSingleResult();
        return query;
    }

    /**
     * Método que permite validar con la cédula si un usuario existe en la base de datos.
     * @param cedula
     * @return 
     */
    @Override
    public Long validarExistenciaPorCedula(String cedula) {
        Long query = (Long)this.manager.createNamedQuery("Usuario.validarExistenciaPorCedula")
                .setParameter(1, cedula)
                .getSingleResult();
        return query;
    }

    /**
     * Método que permite validar con el correo si un usuario existe en la base de datos.
     * @param correo
     * @return 
     */
    @Override
    public Long validarExistenciaPorCorreo(String correo) {
        Long query = (Long)this.manager.createNamedQuery("Usuario.validarExistenciaPorCorreo")
                .setParameter(1, correo)
                .getSingleResult();
        return query;
    }
    
}
