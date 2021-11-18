/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.repositorio.implementacion;

import co.edu.unicundi.discotiendaejbjar.entidad.Cliente;
import co.edu.unicundi.discotiendaejbjar.repositorio.IClienteRep;
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
public class ClienteRepImp implements IClienteRep{
    
    /**
     * Permite realizar operaciones sobre la base de datos.
     */
    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;

    /**
     * Método que permtie buscar a un cliente por id en la base de datos.
     * @param id
     * @return Cliente
     */
    @Override
    public Cliente buscarPorId(Integer id) {
        TypedQuery<Cliente> query = this.manager.createNamedQuery("Cliente.buscarPorId", Cliente.class);
        return query.setParameter("id", id).getSingleResult();
    }
    
    /**
     * Método que permtie buscar a un cliente por correo en la base de datos.
     * @param correo
     * @return Cliente
     */
    @Override
    public Cliente buscarPorCorreo(String correo) {
        TypedQuery<Cliente> query = this.manager.createNamedQuery("Cliente.buscarPorCorreo", Cliente.class);
        return query.setParameter("correo", correo).getSingleResult();
    }

    /**
     * Método que permtie buscar a un cliente por cedula en la base de datos.
     * @param cedula
     * @return Cliente
     */
    @Override
    public Cliente buscarPorCedula(String cedula) {
        TypedQuery<Cliente> query = this.manager.createNamedQuery("Cliente.buscarPorCedula", Cliente.class);
        return query.setParameter("cedula", cedula).getSingleResult();
    }

    /**
     * Método que permtie buscar a todos los clientes en la base de datos.
     * @return clientes
     */
    @Override
    public List<Cliente> buscarTodo() {
        TypedQuery<Cliente> query = this.manager.createNamedQuery("Cliente.buscarTodos", Cliente.class);
        return query.getResultList();
    }

    /**
     * Método que permite registrar a un empleado en la base de datos.
     * @param objeto 
     */
    @Override
    public void registrar(Cliente objeto) {
        this.manager.createNamedQuery("Cliente.registrar")
                .setParameter( 1, objeto.getCedula())
                .setParameter( 2, objeto.getNombres())
                .setParameter( 3, objeto.getApellidos())
                .setParameter( 4, objeto.getCorreo())
                .setParameter( 5, objeto.getContrasena())
                .setParameter( 6, objeto.getFechaNacimiento())
                .setParameter( 7, objeto.getRol().getId())
                .executeUpdate();
    }

    /**
     * Método que permite actualizar a un empleado en la base de datos.
     * @param objeto 
     */
    @Override
    public void actualizar(Cliente objeto) {
        this.manager.createNamedQuery("Cliente.actualizar")
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
     * Método que permite eliminar a un cliente por JPQL de la base de datos.
     * @param id 
     */
    @Override
    public void eliminarJPQL(Integer id) {
        this.manager.createNamedQuery("Cliente.eliminarPorIdJPQL")
                .setParameter("id", id)
                .executeUpdate();
    }

    /**
     * Método que permite eliminar a un cliente por SQL de la base de datos.
     * @param id 
     */
    @Override
    public void eliminarSQL(Integer id) {
        this.manager.createNamedQuery("Cliente.eliminarPorIdSQL")
                .setParameter( 1, id)
                .executeUpdate();
    }

    /**
     * Método que permite validar con el id si un cliente existe en la base de datos.
     * @param id
     * @return 
     */
    @Override
    public Long validarExistenciaPorId(Integer id) {
        Long query = (Long)this.manager.createNamedQuery("Cliente.validarExistenciaPorId")
                .setParameter(1, id)
                .getSingleResult();
        return query;
    }

    /**
     * Método que permite validar con la cédula si un cliente existe en la base de datos.
     * @param cedula
     * @return 
     */
    @Override
    public Long validarExistenciaPorCedula(String cedula) {
        Long query = (Long)this.manager.createNamedQuery("Cliente.validarExistenciaPorCedula")
                .setParameter(1, cedula)
                .getSingleResult();
        return query;
    }

    /**
     * Método que permite validar con el correo si un cliente existe en la base de datos.
     * @param correo
     * @return 
     */
    @Override
    public Long validarExistenciaPorCorreo(String correo) {
        Long query = (Long)this.manager.createNamedQuery("Cliente.validarExistenciaPorCorreo")
                .setParameter(1, correo)
                .getSingleResult();
        return query;
    }
    
}
