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
public class TokenRemImp implements ITokenRep{

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
        this.manager.persist(token);
    }
    
    /**
     * Método que permite validar la existencia de un token
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
    
}
