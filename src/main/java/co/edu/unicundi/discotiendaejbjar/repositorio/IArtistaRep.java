/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.repositorio;

import co.edu.unicundi.discotiendaejbjar.entidad.Artista;
import javax.ejb.Local;

/**
 * Interfaz que hereda de "ICRUDServicio". Contiene todos los métodos
 * de dicha interfaz y dos propios para validar la existencia del artista por id y nombre.
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Local
public interface IArtistaRep extends ICRUDRep<Artista, Integer>{
    
    /**
     * Método que permite validar con el id si un artista existe en la base de datos.
     * @param id
     * @return existencia
     */
    public Long validarExistenciaPorId(Integer id);
    
    /**
     * Método que permite validar con el nombre si un artista existe en la base de datos.
     * @param nombre
     * @return existencia
     */
    public Long validarExistenciaPorNombre(String nombre);
    
}
