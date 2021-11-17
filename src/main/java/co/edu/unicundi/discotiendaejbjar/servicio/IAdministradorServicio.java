/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio;

import co.edu.unicundi.discotiendaejbjar.entidad.Administrador;
import javax.ejb.Local;

/**
 * Interfaz que hereda de "ICRUDServicio". Contiene todos los métodos
 * de dicha interfaz y uno propio para buscar cliente por correo.
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Local
public interface IAdministradorServicio extends ICRUDServicio<Administrador, Integer>{
    
    /**
     * Método que permite buscar a un administrador por correo.
     * @param correo
     * @return 
     */
    public Administrador buscarPorCorreo(String correo);
    
}
