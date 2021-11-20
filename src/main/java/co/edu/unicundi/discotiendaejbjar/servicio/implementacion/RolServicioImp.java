/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio.implementacion;

import co.edu.unicundi.discotiendaejbjar.entidad.Rol;
import co.edu.unicundi.discotiendaejbjar.excepciones.BussinessException;
import co.edu.unicundi.discotiendaejbjar.excepciones.ResourceConflictException;
import co.edu.unicundi.discotiendaejbjar.excepciones.ResourceNotFoundException;
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
    
    /**
     * Permite acceder a los métodos que operan la base de datos.
     */
    @EJB
    private IRolRep repositorio;

    /**
     * Método que comprueba si el id existe, si es así, busca el rol
     * con dicho id.
     * @param id
     * @return 
     */
    @Override
    public Rol buscarPorId(Integer id) throws ResourceNotFoundException{
        if(this.repositorio.validarExistenciaPorId(id) == 1){
            return this.repositorio.buscarPorId(id);
        }else{
            throw new ResourceNotFoundException("Ese id no existe en la base de datos.");

        }

    }

    /**
     * Método que busca a todos los roles.
     * @return 
     */
    @Override
    public List<Rol> buscarTodo() {
        return this.repositorio.buscarTodo();
    }

    /**
     * Método que comprueba si el nombre no están registrado con 
     * otro rol, si es así, permite efectur el registro.
     * @param objeto 
     */
    @Override
    public void registrar(Rol objeto)throws ResourceConflictException{
        if(this.repositorio.validarExistenciaPorNombre(objeto.getNombre()) == 1){
                throw new ResourceConflictException("Actualmente hay un rol registrado con ese nombre.");
            }else{
                this.repositorio.registrar(objeto);
            }
    }

    /**
     * Método que comprueba si el id existe y el nombre no 
     * está registrado con otro rol, si es así, permite modificar el rol.
     * @param objeto 
     */
    @Override
    public void actualizar(Rol objeto) throws ResourceConflictException, ResourceNotFoundException, BussinessException{
        if((objeto.getId() != null)){
            if(this.repositorio.validarExistenciaPorId(objeto.getId()) == 1){
                if((!objeto.getNombre().equals(this.repositorio.buscarPorId(objeto.getId()).getNombre()))){
                    this.repositorio.actualizar(objeto);
                }else{
                    throw new ResourceConflictException("No ingreso un nombre diferente.");

                }
            }else{
                throw new ResourceNotFoundException("No existe ese id en la base de datos.");
            }
        }else{
            throw new BussinessException("Es necesario ingresar un id.");
        }
    }

    /**
     * Método que comprueba si el id ingresado existe, si es así, procede
     * a eliminar el rol por dicho id.
     * @param id 
     */
    @Override
    public void eliminarJPQL(Integer id)throws ResourceNotFoundException {
        if(this.repositorio.validarExistenciaPorId(id) == 1){
            this.repositorio.eliminarJPQL(id);
        }else{
             throw new ResourceNotFoundException("No existe ese id en la base de datos..");
        }
    }

    /**
     * Método que comprueba si el id ingresado existe, si es así, procede
     * a eliminar el cliente por dicho id.
     * @param id 
     */
    @Override
    public void eliminarSQL(Integer id) throws ResourceNotFoundException{
        if(this.repositorio.validarExistenciaPorId(id) == 1){
            this.repositorio.eliminarSQL(id);
        }else{
            throw new ResourceNotFoundException("No existe ese id en la base de datos.");
        }
    }
    
}
