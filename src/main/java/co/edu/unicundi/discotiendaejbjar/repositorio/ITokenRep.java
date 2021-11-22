/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.repositorio;

import co.edu.unicundi.discotiendaejbjar.entidad.Token;
import javax.ejb.Local;

/**
 * Interfaz que contiene un método para registrar un token en la base de datos.
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Local
public interface ITokenRep {
    
    /**
     * Método que permite registrar un token en la base de datos.
     * @param token 
     */
    public void registrar(Token token);
    
    /**
     * Método que permite eliminar un token.
     * @param idUsuario 
     */
    public void eliminarPorIdJPQL(Integer idUsuario);
    
    /**
     * Método que permite eliminar un token.
     * @param token 
     */
    public void eliminarPorContenidoJPQL(String token);
    
    /**
     * Método que permite validar si un token existe en la base de datos
     * por contenido.
     * @param contenido
     * @return 
     */
    public Long validarExistenciaPorContenido(String contenido);
    
    /**
     * Método que permite validar si un token existe en la base de datos
     * por id del usuario.
     * @param idUsuario
     * @return 
     */
    public Long validarExistenciaPorIdUsuario(Integer idUsuario);
    
}
