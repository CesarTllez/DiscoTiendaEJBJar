/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio;

import co.edu.unicundi.discotiendaejbjar.dto.UsuarioDto;
import co.edu.unicundi.discotiendaejbjar.entidad.Token;
import co.edu.unicundi.discotiendaejbjar.entidad.Usuario;
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
     * Método que permite buscar a un usuario por correo.
     * @param correo
     * @return 
     */
    public UsuarioDto buscarPorCorreo(String correo);
    
    /**
     * Método que permite buscar a un usuario por cédula.
     * @param cedula
     * @return 
     */
    public UsuarioDto buscarPorCedula(String cedula);
    
    /**
     * Método que permite obtener el token a logearse.
     * @param apodo
     * @param contrasena
     * @return 
     */
    public Token login(String apodo, String contrasena);
    
}
