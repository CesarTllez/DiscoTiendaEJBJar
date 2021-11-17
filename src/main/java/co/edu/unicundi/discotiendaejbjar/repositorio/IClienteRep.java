/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.repositorio;

import co.edu.unicundi.discotiendaejbjar.entidad.Cliente;
import javax.ejb.Local;

/**
 * Interfaz que hereda de "ICRUDRep". Contiene todos los métodos
 * de dicha interfaz y cinco propios para buscar cliente por correo y cedula y validar 
 * la existencia.
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Local
public interface IClienteRep extends ICRUDRep<Cliente, Integer>{
    
    /**
     * Método que permite buscar a un cliente por correo.
     * @param correo
     * @return 
     */
    public Cliente buscarPorCorreo(String correo);
    
    /**
     * Método que permite buscar a un cliente por cédula.
     * @param cedula
     * @return 
     */
    public Cliente buscarPorCedula(String cedula);
    
    /**
     * Método que permite validar con el id si un cliente existe en la base de datos.
     * @param id
     * @return existencia
     */
    public Long validarExistenciaPorId(Integer id);
    
    /**
     * Método que permite validar con la cédula si un cliente existe en la base de datos.
     * @param cedula
     * @return existencia
     */
    public Long validarExistenciaPorCedula(String cedula);
    
    /**
     * Método que permite validar con el correo si un cliente existe en la base de datos.
     * @param correo
     * @return existencia
     */
    public Long validarExistenciaPorCorreo(String correo);
    
}
