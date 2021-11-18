/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio.implementacion;

import co.edu.unicundi.discotiendaejbjar.entidad.Artista;
import co.edu.unicundi.discotiendaejbjar.repositorio.IArtistaRep;
import co.edu.unicundi.discotiendaejbjar.servicio.IArtistaServicio;
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
public class ArtistaServicioImp implements IArtistaServicio{
    
    /**
     * Permite acceder a los métodos que operan la base de datos.
     */
    @EJB
    private IArtistaRep repositorio;

    /**
     * Método que comprueba si el id existe, si es así, busca el artista
     * con dicho id.
     * @param id
     * @return 
     */
    @Override
    public Artista buscarPorId(Integer id) {
        if(this.repositorio.validarExistenciaPorId(id) == 1){
            return this.repositorio.buscarPorId(id);
        }else{
             System.out.println("Excepcion: Ese id no existe en la base de datos.");
        }
        /*Objeto que debe borrarse cuando se implementen las excepciones.
        */Artista a = new Artista();
        /**/return a;
        /*---------------------------------------------------------*/
    }

    /**
     * Método que busca a todos los artistas.
     * @return 
     */
    @Override
    public List<Artista> buscarTodo() {
        return this.repositorio.buscarTodo();
    }

    /**
     * Método que comprueba si el nombre no están registrado con 
     * otro artista, si es así, permite efectur el registro.
     * @param objeto 
     */
    @Override
    public void registrar(Artista objeto) {
        if(this.repositorio.validarExistenciaPorNombre(objeto.getNombre()) == 1){
                System.out.println("Excepcion: Actualmente hay un artista registrado con ese nombre.");
            }else{
                this.repositorio.registrar(objeto);
            }
    }

    /**
     * Método que comprueba si el id existe y el nombre no 
     * está registrado con otro artista, si es así, permite modificar al artista.
     * @param objeto 
     */
    @Override
    public void actualizar(Artista objeto) {
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
     * a eliminar al artista por dicho id.
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
     * a eliminar al artista por dicho id.
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
