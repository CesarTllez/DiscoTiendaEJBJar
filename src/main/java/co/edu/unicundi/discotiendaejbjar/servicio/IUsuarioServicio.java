/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio;

import co.edu.unicundi.discotiendaejbjar.dto.UsuarioDto;
import co.edu.unicundi.discotiendaejbjar.entidad.Token;
import co.edu.unicundi.discotiendaejbjar.entidad.Usuario;
import co.edu.unicundi.discotiendaejbjar.excepciones.ResourceNotFoundException;
import javax.ejb.Local;

/**
 * Interfaz que hereda de "ICRUDServicio". Contiene todos los métodos
 * de dicha interfaz y dos propios para buscar usuario por correo y cedula.
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Local
public interface IUsuarioServicio extends ICRUDServicio<Usuario, Integer, UsuarioDto>{
    
    /**
     * Método que permite buscar a un usuario por apodo.
     * @param apodo
     * @return 
     */
    public Usuario buscarPorApodo(String apodo);
    
    /**
     * Método que permite buscar a un usuario por correo.
     * @param correo
     * @return 
     */
    public UsuarioDto buscarPorCorreo(String correo)throws ResourceNotFoundException;
    
    /**
     * Método que permite buscar a un usuario por cédula.
     * @param cedula
     * @return 
     */
    public UsuarioDto buscarPorCedula(String cedula)throws ResourceNotFoundException;
    
    /**
     * Método que permite obtener el token e iniciar sesion.
     * @param apodo
     * @param contrasena
     * @return 
     */
    public Token iniciarSesion(String apodo, String contrasena);
    
    /**
     * Método que permite cerrar la sesión del usuario.
     * @param token 
     */
    public void cerrarSesion(String token);
    
}
