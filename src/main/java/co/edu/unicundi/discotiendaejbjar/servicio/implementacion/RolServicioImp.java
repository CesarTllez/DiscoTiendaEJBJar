/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio.implementacion;

import co.edu.unicundi.discotiendaejbjar.entidad.Rol;
import co.edu.unicundi.discotiendaejbjar.repositorio.IRolRep;
import co.edu.unicundi.discotiendaejbjar.servicio.IRolServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Clase que permite acceder a los métodos que operan la base de datos y
 * valida los datos que proporciona el api.
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Stateless
public class RolServicioImp implements IRolServicio {
    
    @EJB
    private IRolRep repositorio;

    /**
     * Método que comprueba si el id existe, si es así, busca el rol
     * con dicho id.
     * @param id
     * @return 
     */
    @Override
    public Rol buscarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método que busca a todos los roles.
     * @return 
     */
    @Override
    public List<Rol> buscarTodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método que comprueba si el nombre no están registrado con 
     * otro rol, si es así, permite efectur el registro.
     * @param objeto 
     */
    @Override
    public void registrar(Rol objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método que comprueba si el id existe y el nombre no 
     * está registrado con otro rol, si es así, permite modificar el rol.
     * @param objeto 
     */
    @Override
    public void actualizar(Rol objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método que comprueba si el id ingresado existe, si es así, procede
     * a eliminar el rol por dicho id.
     * @param id 
     */
    @Override
    public void eliminarJPQL(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método que comprueba si el id ingresado existe, si es así, procede
     * a eliminar el cliente por dicho id.
     * @param id 
     */
    @Override
    public void eliminarSQL(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
