/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.repositorio.implementacion;

import co.edu.unicundi.discotiendaejbjar.entidad.Token;
import co.edu.unicundi.discotiendaejbjar.repositorio.ITokenRep;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Clase que contiene los métodos necesarios para operar sobre la base de datos
 * haciendo uso del EntityManager.
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Stateless
public class TokenRepImp implements ITokenRep{

    /**
     * Permite realizar operaciones sobre la base de datos.
     */
    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;
    
    /**
     * Método que permite registrar un token en la base de datos.
     * @param token 
     */
    @Override
    public void registrar(Token token) {
        this.manager.createNamedQuery("Token.registrar")
                .setParameter(1, token.getContenido())
                .setParameter(2, token.getIdUsuario())
                .executeUpdate();
    }
    
    /**
     * Método que permite eliminar un token en la base de datos.
     * @param idUsuario 
     */
    @Override
    public void eliminarPorIdJPQL(Integer idUsuario) {
        this.manager.createNamedQuery("Token.eliminarPorIdJPQL")
                .setParameter("idUsuario", idUsuario)
                .executeUpdate();
    }
    
    /**
     * Método que permite validar la existencia de un token por contenido.
     * en la base de datos.
     * @param contenido
     * @return 
     */
    @Override
    public Long validarExistenciaPorContenido(String contenido) {
       Long query = (Long)this.manager.createNamedQuery("Token.validarExistenciaPorContenido")
                .setParameter("contenido", contenido)
                .getSingleResult();
        return query;
    }

    /**
     * Método que permite validar la existencia de un token por id del usuario.
     * @param idUsuario
     * @return 
     */
    @Override
    public Long validarExistenciaPorIdUsuario(Integer idUsuario) {
        Long query = (Long)this.manager.createNamedQuery("Token.validarExistenciaPorIdUsuario")
                .setParameter("idUsuario", idUsuario)
                .getSingleResult();
        return query;
    }
    
}
