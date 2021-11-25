/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.repositorio;

import co.edu.unicundi.discotiendaejbjar.entidad.Cancion;
import java.util.List;

import javax.ejb.Local;

/**
 * Interfaz que hereda de "ICRUDRep". Contiene todos los métodos
 * de dicha interfaz y cinco propios para buscar la Cancion por el nombre y validar 
 * la existencia.
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Local
public interface ICancionRep extends ICRUDRep<Cancion, Integer> {
    
    /**
     * Método que permite buscar la informacion con el nombre de una cancion 
     * si existe en la base de datos.
     * @param nombre
     * @return 
     */
    public Cancion buscarPorNombre(String nombre);
        /**
     * Método que permite validar con el id si una cancion existe en la base de datos.
     * @param id
     * @return 
     */
    public Long validarExistenciaPorId(Integer id);
    
    /**
     * Método que permite validar con el nombre si una cancion existe en la base de datos.
     * @param nombre
     * @return 
     */
    public Long validarExistenciaPorNombre(String nombre);
    
    /**
     * Método que permite buscar todas las canciones por id del disco.
     * @param idDisco
     * @return 
     */
    public List<Cancion> buscarTodosPorIdDisco(Integer idDisco);
    
    /**
     * Método que permite registrar una compra de una canción en la base de datos.
     * @param idCancion
     * @param idUsuario 
     */
    public void registrarCompra(Integer idCancion, Integer idUsuario);
    
}
