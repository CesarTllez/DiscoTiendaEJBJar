/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.repositorio;

import co.edu.unicundi.discotiendaejbjar.entidad.Usuario;
import co.edu.unicundi.discotiendaejbjar.entidad.UsuarioCancion;
import co.edu.unicundi.discotiendaejbjar.entidad.UsuarioDisco;
import java.util.List;
import javax.ejb.Local;

/**
 * Interfaz que hereda de "ICRUDRep". Contiene todos los métodos
 * de dicha interfaz y cinco propios para buscar usuario por correo - cedula y validar 
 * la existencia.
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Local
public interface IUsuarioRep extends ICRUDRep<Usuario, Integer>{
    
    /**
     * Método que permite buscar a un usuario por correo.
     * @param correo
     * @return 
     */
    public Usuario buscarPorCorreo(String correo);
    
    /**
     * Método que permite buscar a un usuario por cédula.
     * @param cedula
     * @return 
     */
    public Usuario buscarPorCedula(String cedula);
    
    /**
     * Método que permite buscar a un usuario por apodo.
     * @param apodo
     * @return 
     */
    public Usuario buscarPorApodo(String apodo);
    
    /**
     * Método que permite validar con el id si un usuario existe en la base de datos.
     * @param id
     * @return existencia
     */
    public Long validarExistenciaPorId(Integer id);
    
    /**
     * Método que permite validar con el apodo si un usuario existe en la base de datos.
     * @param apodo
     * @return existencia
     */
    public Long validarExistenciaPorApodo(String apodo);
    
    /**
     * Método que permite validar con la cédula si un usuario existe en la base de datos.
     * @param cedula
     * @return existencia
     */
    public Long validarExistenciaPorCedula(String cedula);
    
    /**
     * Método que permite validar con el correo si un usuario existe en la base de datos.
     * @param correo
     * @return existencia
     */
    public Long validarExistenciaPorCorreo(String correo);
    
    /**
     * Método que permite buscar los id de las canciones compradas por el id del usuario.
     * @param idUsuario
     * @return 
     */
    public List<UsuarioCancion> buscarCancionesPorIdUsuario(Integer idUsuario);
    
    /**
     * Método que permite buscar los id de los discos comprados por el id del usuario.
     * @param idUsuario
     * @return 
     */
    public List<UsuarioDisco> buscarDiscosPorIdUsuario(Integer idUsuario);
    
}
