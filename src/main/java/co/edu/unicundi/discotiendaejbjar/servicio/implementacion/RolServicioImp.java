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
    public Rol buscarPorId(Integer id) {
        if(this.repositorio.validarExistenciaPorId(id) == 1){
            return this.repositorio.buscarPorId(id);
        }else{
             System.out.println("Excepcion: Ese id no existe en la base de datos.");
        }
        /*Objeto que debe borrarse cuando se implementen las excepciones.
        */Rol r = new Rol();
        /**/return r;
        /*---------------------------------------------------------*/
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
    public void registrar(Rol objeto) {
        if(this.repositorio.validarExistenciaPorNombre(objeto.getNombre()) == 1){
                System.out.println("Excepcion: Actualmente hay un usuario registrado con ese nombre.");
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
    public void actualizar(Rol objeto) {
        if((objeto.getId() != null)){
            if(this.repositorio.validarExistenciaPorId(objeto.getId()) == 1){
                if((!objeto.getNombre().equals(this.repositorio.buscarPorId(objeto.getId()).getNombre()))){
                    this.repositorio.actualizar(objeto);
                }else{
                    System.out.println("Excepcion: No ingreso un nombre diferente.");
                }
            }else{
                System.out.println("Excepcion: No existe ese id en la base de datos.");
            }
        }else{
            System.out.println("Excepcion: Es necesario ingresar un id.");
        }
    }

    /**
     * Método que comprueba si el id ingresado existe, si es así, procede
     * a eliminar el rol por dicho id.
     * @param id 
     */
    @Override
    public void eliminarJPQL(Integer id) {
        if(this.repositorio.validarExistenciaPorId(id) == 1){
            this.repositorio.eliminarJPQL(id);
        }else{
             System.out.println("Excepcion: No existe ese id en la base de datos.");
        }
    }

    /**
     * Método que comprueba si el id ingresado existe, si es así, procede
     * a eliminar el cliente por dicho id.
     * @param id 
     */
    @Override
    public void eliminarSQL(Integer id) {
        if(this.repositorio.validarExistenciaPorId(id) == 1){
            this.repositorio.eliminarSQL(id);
        }else{
             System.out.println("Excepcion: No existe ese id en la base de datos.");
        }
    }
    
}
