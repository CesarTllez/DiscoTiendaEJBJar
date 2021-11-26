/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio;

import co.edu.unicundi.discotiendaejbjar.dto.CompraDto;
import co.edu.unicundi.discotiendaejbjar.dto.DiscoDto;
import co.edu.unicundi.discotiendaejbjar.entidad.Disco;
import co.edu.unicundi.discotiendaejbjar.excepciones.ResourceConflictException;
import co.edu.unicundi.discotiendaejbjar.excepciones.ResourceNotFoundException;
import co.edu.unicundi.discotiendaejbjar.vista.HistorialVentaDisco;
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
public interface IDiscoServicio extends ICRUDServicio<Disco, Integer, DiscoDto> {

    /**
     * Método que permite buscar un disco por nombre.
     * @param nombre
     * @return
     */
    public DiscoDto buscarPorNombre(String nombre) throws ResourceNotFoundException;
    
    /**
     * Método que permite buscar todos los discos con el id del artista
     * si existe en la base de datos.
     * @param idArtista
     * @return 
     */
    public List<DiscoDto> buscarTodosPorIdArtista(Integer idArtista);
    
    /**
     * Método que permite registrar una compra de un disco en la base de datos.
     * @param idDisco
     * @param token
     */
    public void registrarCompra(CompraDto idDisco, String token) throws ResourceConflictException;
    
    public List<HistorialVentaDisco> historialVentaDisco();
    
}
