/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio.implementacion;

import co.edu.unicundi.discotiendaejbjar.entidad.Administrador;
import co.edu.unicundi.discotiendaejbjar.repositorio.IAdministradorRep;
import co.edu.unicundi.discotiendaejbjar.servicio.IAdministradorServicio;
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
public class AdministradorServicioImp implements IAdministradorServicio{
    
    /**
     * Permite acceder a los métodos que operan la base de datos.
     */
    @EJB
    private IAdministradorRep repositorio;

    /**
     * Método que comprueba si el correo existe, si es así, busca al administrador
     * con dicho correo.
     * @param correo
     * @return 
     */
    @Override
    public Administrador buscarPorCorreo(String correo) {
        if(this.repositorio.validarExistenciaPorCorreo(correo) == 1){
            return this.repositorio.buscarPorCorreo(correo);
        }else{
             System.out.println("Excepcion: Ese correo no existe en la base de datos.");
        }
        /*Objeto que debe borrarse cuando se implementen las excepciones.
        */Administrador a = new Administrador();
        /**/return a;
        /*---------------------------------------------------------*/
    }

    /**
     * Método que comprueba si el id existe, si es así, busca al administrador
     * con dicho id.
     * @param id
     * @return 
     */
    @Override
    public Administrador buscarPorId(Integer id) {
        if(this.repositorio.validarExistenciaPorId(id) == 1){
            return this.repositorio.buscarPorId(id);
        }else{
             System.out.println("Excepcion: Ese id no existe en la base de datos.");
        }
        /*Objeto que debe borrarse cuando se implementen las excepciones.
        */Administrador a = new Administrador();
        /**/return a;
        /*---------------------------------------------------------*/
    }

    /**
     * Método que busca a todos los administradores.
     * @return 
     */
    @Override
    public List<Administrador> buscarTodo() {
        return this.repositorio.buscarTodo();
    }

    /**
     * Método que comprueba si el correo proporcionado no 
     * está registrado con otro usuario, si es así, permite efectur el registro.
     * @param objeto 
     */
    @Override
    public void registrar(Administrador objeto) {
        if(this.repositorio.validarExistenciaPorCorreo(objeto.getCorreo()) == 1){
                System.out.println("Excepcion: Actualmente hay un usuario registrado con ese correo.");
            }else{
                this.repositorio.registrar(objeto);
            }
    }

    /**
     * Método que comprueba si el id existe, si es así, permite modificar el administrador.
     * @param objeto 
     */
    @Override
    public void actualizar(Administrador objeto) {
        if((objeto.getId() != null)){
            if(this.repositorio.validarExistenciaPorId(objeto.getId()) == 1){
                this.repositorio.actualizar(objeto);
            }else{
                System.out.println("Excepcion: No existe ese id en la base de datos.");
            }
        }else{
            System.out.println("Excepcion: Es necesario ingresar un id.");
        }
    }

    /**
     * Método que comprueba si el id ingresado existe, si es así, procede
     * a eliminar al administrador por dicho id.
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
     * a eliminar al administrador por dicho id.
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
