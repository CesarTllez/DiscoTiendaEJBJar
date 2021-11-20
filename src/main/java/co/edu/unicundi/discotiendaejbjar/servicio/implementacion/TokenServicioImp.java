/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio.implementacion;

import co.edu.unicundi.discotiendaejbjar.repositorio.ITokenRep;
import co.edu.unicundi.discotiendaejbjar.servicio.ITokenServicio;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Clase que permite acceder a los métodos que operan la base de datos y
 * valida los datos que proporciona el api.
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Stateless
public class TokenServicioImp implements ITokenServicio{

    /**
     * Permite acceder a los métodos que operan la base de datos.
     */
    @EJB
    private ITokenRep repositorio;
    
    /**
     * Método que permite validar si existe un token existe
     * en la base de datos.
     * @param contenido
     * @return 
     */
    @Override
    public Long validarExistenciaPorContenido(String contenido) {
        return this.repositorio.validarExistenciaPorContenido(contenido);
    }
    
}
