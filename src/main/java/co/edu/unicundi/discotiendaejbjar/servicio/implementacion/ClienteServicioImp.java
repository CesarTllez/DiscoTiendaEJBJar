/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio.implementacion;

import co.edu.unicundi.discotiendaejbjar.entidad.Cliente;
import co.edu.unicundi.discotiendaejbjar.entidad.Rol;
import co.edu.unicundi.discotiendaejbjar.repositorio.IClienteRep;
import co.edu.unicundi.discotiendaejbjar.servicio.IClienteServicio;
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
public class ClienteServicioImp implements IClienteServicio{
    
    /**
     * Permite acceder a los métodos que operan la base de datos.
     */
    @EJB
    private IClienteRep repositorio;

    /**
     * Método que comprueba si el correo existe, si es así, busca el cliente
     * con dicho correo.
     * @param correo
     * @return 
     */
    @Override
    public Cliente buscarPorCorreo(String correo) {
        if(this.repositorio.validarExistenciaPorCorreo(correo) == 1){
            return this.repositorio.buscarPorCorreo(correo);
        }else{
             System.out.println("Excepcion: Ese correo no existe en la base de datos.");
        }
        /*Objeto que debe borrarse cuando se implementen las excepciones.
        */Cliente c = new Cliente();
        /**/return c;
        /*---------------------------------------------------------*/
    }

    /**
     * Método que comprueba si la cédula existe, si es así, busca el cliente
     * con dicha cédula.
     * @param cedula
     * @return 
     */
    @Override
    public Cliente buscarPorCedula(String cedula) {
        if(this.repositorio.validarExistenciaPorCedula(cedula) == 1){
            return this.repositorio.buscarPorCedula(cedula);
        }else{
             System.out.println("Excepcion: Esa cedula no existe en la base de datos.");
        }
        /*Objeto que debe borrarse cuando se implementen las excepciones.
        */Cliente c = new Cliente();
        /**/return c;
        /*---------------------------------------------------------*/
    }

    /**
     * Método que comprueba si el id existe, si es así, busca el cliente
     * con dicho id.
     * @param id
     * @return 
     */
    @Override
    public Cliente buscarPorId(Integer id) {
        if(this.repositorio.validarExistenciaPorId(id) == 1){
            return this.repositorio.buscarPorId(id);
        }else{
             System.out.println("Excepcion: Ese id no existe en la base de datos.");
        }
        /*Objeto que debe borrarse cuando se implementen las excepciones.
        */Cliente c = new Cliente();
        /**/return c;
        /*---------------------------------------------------------*/
    }

    /**
     * Método que busca a todos los clientes.
     * @return clientes
     */
    @Override
    public List<Cliente> buscarTodo() {
        return this.repositorio.buscarTodo();
    }

    /**
     * Método que comprueba si los datos proporcionados (cédula y correo) no 
     * están registrados con otro usuario, si es así, permite efectur el registro.
     * @param objeto 
     */
    @Override
    public void registrar(Cliente objeto) {
        if(this.repositorio.validarExistenciaPorCedula(objeto.getCedula()) == 1 &&
                this.repositorio.validarExistenciaPorCorreo(objeto.getCorreo()) == 1){
             System.out.println("Excepcion: Actualmente hay un usuario registrado con esa cedula y ese correo.");
        }else{
            if(this.repositorio.validarExistenciaPorCorreo(objeto.getCorreo()) == 1){
                System.out.println("Excepcion: Actualmente hay un usuario registrado con ese correo.");
            }else{
                if(this.repositorio.validarExistenciaPorCedula(objeto.getCedula()) == 1){
                    System.out.println("Excepcion: Actualmente hay un usuario registrado con esa cedula.");
                }else{
                    Rol rol = new Rol();
                    rol.setId(2);
                    objeto.setRol(rol);
                    this.repositorio.registrar(objeto);
                }
            }
        }
    }

    /**
     * Método que comprueba si el id existe y los datos proporcionados (cédula y correo) no 
     * están registrados con otro usuario, si es así, permite modificar el cliente.
     * @param objeto 
     */
    @Override
    public void actualizar(Cliente objeto) {
        if((objeto.getId() != null)){
            if(this.repositorio.validarExistenciaPorId(objeto.getId()) == 1){
                if((!objeto.getCedula().equals(this.repositorio.buscarPorId(objeto.getId()).getCedula()))){
                    if(this.repositorio.validarExistenciaPorCedula(objeto.getCedula()) == 1){
                        System.out.println("Excepcion: Actualmente, hay un usuario registrado con esa cedula.");
                    }else{
                        this.repositorio.actualizar(objeto);
                    }
                }else{
                    System.out.println("Excepcion: No ingreso una cedula diferente.");
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
     * a eliminar el cliente por dicho id.
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
