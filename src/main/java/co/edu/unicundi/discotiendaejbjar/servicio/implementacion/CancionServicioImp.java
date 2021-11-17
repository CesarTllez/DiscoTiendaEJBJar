/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio.implementacion;

import co.edu.unicundi.discotiendaejbjar.entidad.Cancion;
import co.edu.unicundi.discotiendaejbjar.repositorio.ICancionRep;


import co.edu.unicundi.discotiendaejbjar.servicio.ICancionServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author eison
 */
@Stateless
public class CancionServicioImp implements ICancionServicio{

     /**
     * Permite acceder a los métodos que operan la base de datos.
     */
    @EJB
    private ICancionRep repositorio;
     
    /**
     * Método que comprueba si el nombre existe, si es así, busca la cancion
     * con dicho nombre.
     * @param nombre
     * @return 
     */
    @Override
    public Cancion buscarPorNombre(String nombre) {
        if(this.repositorio.validarExistenciaPorNombre(nombre) == 1){
            return this.repositorio.buscarPorNombre(nombre);
        }else{
             System.out.println("Excepcion: Ese nombre de la cancion no existe en la base de datos.");
        }
        /*Objeto que debe borrarse cuando se implementen las excepciones.
        */Cancion c = new Cancion();
        /**/return c;
    }

     /**
     * Método que comprueba si el id existe, si es así, busca la cancion
     * con dicho id.
     * @param id
     * @return 
     */
    @Override
    public Cancion buscarPorId(Integer id) {
        if(this.repositorio.validarExistenciaPorId(id) == 1){
            return this.repositorio.buscarPorId(id);
        }else{
             System.out.println("Excepcion: Ese id no existe en la base de datos.");
        }
        /*Objeto que debe borrarse cuando se implementen las excepciones.
        */Cancion c = new Cancion();
        /**/return c;
    }
    /**
     * Metodo que hace una busqueda de todas las canciones en la base de datos
     * @return 
     */
    @Override
    public List<Cancion> buscarTodo() {
      return this.repositorio.buscarTodo(); 
    }

    /**
     * Metodo que comprueba si hay una cancion que existe con el mismo nombre
     * @param objeto 
     */
    @Override
    public void registrar(Cancion objeto) {
         if(this.repositorio.validarExistenciaPorNombre(objeto.getNombre()) == 1){
                    System.out.println("Excepcion: Actualmente hay una cancion registrada con ese nombre.");
                }else{
                    this.repositorio.registrar(objeto);
                }
    }

    /**
     * Método que comprueba si el id existe y los datos proporcionados (nombre) no 
     * están registrados con otra cancion, si es así, permite modificar la cancion.
     * @param objeto 
     */
    @Override
    public void actualizar(Cancion objeto) {
              if((objeto.getId() != null)){
            if(this.repositorio.validarExistenciaPorId(objeto.getId()) == 1){
                if((!objeto.getNombre().equals(this.repositorio.buscarPorId(objeto.getId()).getNombre()))){
                    if(this.repositorio.validarExistenciaPorNombre(objeto.getNombre()) == 1){
                        System.out.println("Excepcion: Actualmente, hay un usuario registrado con esa cedula.");
                    }else{
                        this.repositorio.actualizar(objeto);
                    }
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
     * a eliminar la cancion de dicho id.
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
     * a eliminar la cancion de dicho id.
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