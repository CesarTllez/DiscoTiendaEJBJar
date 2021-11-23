/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio;

import co.edu.unicundi.discotiendaejbjar.excepciones.BussinessException;
import co.edu.unicundi.discotiendaejbjar.excepciones.EntityValidationException;
import co.edu.unicundi.discotiendaejbjar.excepciones.ResourceConflictException;
import co.edu.unicundi.discotiendaejbjar.excepciones.ResourceNotFoundException;
import co.edu.unicundi.discotiendaejbjar.excepciones.UnauthorizedException;
import java.util.List;

/**
 * Interfaz que contiene los métodos referentes a un CRUD y que será
 * heredada por las demás interfaces del servicio.
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
public interface ICRUDServicio <OBJETO, ID, OBJETODTO> {
    
    /**
     * Método que permite buscar por id.
     * @param id
     * @return 
     */
    public OBJETODTO buscarPorId(ID id)throws ResourceNotFoundException;
    
    /**
     * Método que permite buscar todo.
     * @return 
     */
    public List<OBJETODTO> buscarTodo();
    
    /**
     * Método que permite registrar.
     * @param objeto 
     */
    public void registrar(OBJETO objeto)throws ResourceNotFoundException, EntityValidationException, ResourceConflictException, UnauthorizedException;
    
    /**
     * Método que permite actualizar.
     * @param objeto 
     */
    public void actualizar(OBJETO objeto)throws BussinessException, ResourceNotFoundException,  EntityValidationException, ResourceConflictException;
    
    /**
     * Método que permite eliminar por JPQL.
     * @param id 
     */
    public void eliminarJPQL(ID id)throws ResourceNotFoundException;
    
    /**
     * Método que permite eliminar por SQL
     * @param id 
     */
    public void eliminarSQL(ID id)throws ResourceNotFoundException;
    
}
