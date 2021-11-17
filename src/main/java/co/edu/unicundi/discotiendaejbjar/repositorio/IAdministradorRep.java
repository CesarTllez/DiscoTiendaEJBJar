/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.repositorio;

import co.edu.unicundi.discotiendaejbjar.entidad.Administrador;
import javax.ejb.Local;

/**
 *
 * @author cesar
 */
@Local
public interface IAdministradorRep extends ICRUDRep<Administrador, Integer>{
    
    /**
     * Método que permite buscar a un administrador por correo.
     * @param correo
     * @return 
     */
    public Administrador buscarPorCorreo(String correo);
    
    /**
     * Método que permite validar con el id si un administrador existe en la base de datos.
     * @param id
     * @return existencia
     */
    public Long validarExistenciaPorId(Integer id);
    
    /**
     * Método que permite validar con el correo si un administrador existe en la base de datos.
     * @param correo
     * @return existencia
     */
    public Long validarExistenciaPorCorreo(String correo);
    
}
