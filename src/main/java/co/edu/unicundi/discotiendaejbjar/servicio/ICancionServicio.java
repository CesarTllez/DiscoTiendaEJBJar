/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio;

import co.edu.unicundi.discotiendaejbjar.entidad.Cancion;
import co.edu.unicundi.discotiendaejbjar.excepciones.EntityValidationException;
import co.edu.unicundi.discotiendaejbjar.excepciones.ResourceConflictException;
import co.edu.unicundi.discotiendaejbjar.excepciones.ResourceNotFoundException;
import java.util.List;
import javax.ejb.Local;

/**
 * Interfaz que contiene los métodos referentes a un CRUD y que será heredada
 * por las demás interfaces del servicio.
 *
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Local
public interface ICancionServicio extends ICRUDServicio<Cancion, Integer, Cancion> {

    /**
     * Método que permite buscar a una cancion por nombre.
     *
     * @param nombre
     * @return
     */
    public Cancion buscarPorNombre(String nombre)throws ResourceNotFoundException;
    
    /**
     * Método que permite buscar todas las canciones por id del disco.
     * @return 
     */
    public List<Cancion> buscarTodosPorIdDisco(Integer idDisco)throws  ResourceNotFoundException;

}
