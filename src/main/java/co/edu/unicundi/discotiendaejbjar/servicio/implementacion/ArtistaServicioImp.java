/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio.implementacion;

import co.edu.unicundi.discotiendaejbjar.entidad.Artista;

import co.edu.unicundi.discotiendaejbjar.excepciones.EntityValidationException;
import co.edu.unicundi.discotiendaejbjar.excepciones.ResourceConflictException;
import co.edu.unicundi.discotiendaejbjar.excepciones.ResourceNotFoundException;
import co.edu.unicundi.discotiendaejbjar.repositorio.IArtistaRep;
import co.edu.unicundi.discotiendaejbjar.servicio.IArtistaServicio;
import co.edu.unicundi.discotiendaejbjar.vista.Vista;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import org.modelmapper.ValidationException;

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
    public Artista buscarPorId(Integer id)throws ResourceNotFoundException{
        if(this.repositorio.validarExistenciaPorId(id) == 1){
            return this.repositorio.buscarPorId(id);
        }else{
            throw new ResourceNotFoundException("Ese id no existe en la base de datos.");
           
        }
    
    }

    /**
     * Método que busca a todos los artistas.
     * @return 
     */
    @Override
    public List<Artista> buscarTodo() {
        return this.repositorio.buscarTodo();
    }

      @Override
    public List<Vista> vistaBuscar() {
    return this.repositorio.vistaBuscar();
    }
    /**
     * Método que comprueba si el nombre no están registrado con 
     * otro artista, si es así, permite efectur el registro.
     * @param objeto 
     */
    @Override
    public void registrar(Artista objeto) throws ResourceConflictException{
        if(this.repositorio.validarExistenciaPorNombre(objeto.getNombre()) == 1){
            throw  new ResourceConflictException("Actualmente hay un artista registrado con ese nombre.");
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
    public void actualizar(Artista objeto) throws  EntityValidationException, ResourceNotFoundException, ResourceConflictException{
        if((objeto.getId() != null)){
            if(this.repositorio.validarExistenciaPorId(objeto.getId()) == 1){
                if((!objeto.getNombre().equals(this.repositorio.buscarPorId(objeto.getId()).getNombre()))){
                    this.repositorio.actualizar(objeto);
                }else{
                    throw  new ResourceConflictException("No ingreso un nombre diferente.");
                }
            }else{
                throw  new ResourceNotFoundException("No existe ese id en la base de datos.");
            }
        }else{
            throw  new EntityValidationException("Es necesario ingresar un id.");
        }
    }

    /**
     * Método que comprueba si el id ingresado existe, si es así, procede
     * a eliminar al artista por dicho id.
     * @param id 
     */
    @Override
    public void eliminarJPQL(Integer id) throws ResourceNotFoundException{
        if(this.repositorio.validarExistenciaPorId(id) == 1){
            this.repositorio.eliminarJPQL(id);
        }else{
            throw new ResourceNotFoundException("Excepcion: No existe ese id en la base de datos.");
        }
    }

    /**
     * Método que comprueba si el id ingresado existe, si es así, procede
     * a eliminar al artista por dicho id.
     * @param id 
     */
    @Override
    public void eliminarSQL(Integer id) throws ResourceNotFoundException{
        if(this.repositorio.validarExistenciaPorId(id) == 1){
            this.repositorio.eliminarSQL(id);
        }else{
            throw new ResourceNotFoundException(" No existe ese id en la base de datos.");

        }
    }
    
}
