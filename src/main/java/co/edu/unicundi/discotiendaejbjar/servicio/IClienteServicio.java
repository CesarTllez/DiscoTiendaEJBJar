/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio;

import co.edu.unicundi.discotiendaejbjar.entidad.Cliente;
import javax.ejb.Local;

/**
 * Interfaz que hereda de "ICRUDServicio". Contiene todos los métodos
 * de dicha interfaz y dos propios para buscar cliente por correo y cedula.
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Local
public interface IClienteServicio extends ICRUDServicio<Cliente, Integer>{
    
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
    
}
