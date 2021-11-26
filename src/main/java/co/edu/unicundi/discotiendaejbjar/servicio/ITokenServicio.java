/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio;

import javax.ejb.Local;

/**
 * Interfaz que contiene un método que permite validar si 
 * existe un token en la base de datos.
 * de dicha interfaz.
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Local
public interface ITokenServicio {
    
    /**
     * Método que permite validar si un token existe en la base de datos.
     * @param contenido
     * @return 
     */
    public Long validarExistenciaPorContenido(String contenido);
    
}
