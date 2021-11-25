/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.repositorio;

import co.edu.unicundi.discotiendaejbjar.entidad.Formato;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cesar
 */
@Local
public interface IFormatoRep {
    
    /**
     * Método que permite buscar todos los formatos en BD.
     * @return 
     */
    public List<Formato> buscarTodos();
    
    /**
     * Método que permite buscar un formato por id en BD.
     * @param id
     * @return 
     */
    public Formato buscarPorId(Integer id);
    
    /**
     * Método que permite registrar un formato en BD.
     * @param formato 
     */
    public void registrar(Formato formato);
    
    /**
     * Método que permite validar la existencia de un formato por id en BD.
     * @param id
     * @return 
     */
    public Long validarExistenciaPorId(Integer id);
    
    /**
     * Método que permite validar la existencia de un formato por nombre en BD.
     * @param nombre
     * @return 
     */
    public Long validarExistenciaPorNombre(String nombre);
    
}