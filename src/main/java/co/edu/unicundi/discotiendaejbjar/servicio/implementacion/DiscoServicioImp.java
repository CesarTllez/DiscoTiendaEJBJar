/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio.implementacion;

import co.edu.unicundi.discotiendaejbjar.dto.DiscoDto;
import co.edu.unicundi.discotiendaejbjar.entidad.Artista;
import co.edu.unicundi.discotiendaejbjar.entidad.Disco;
import co.edu.unicundi.discotiendaejbjar.excepciones.BussinessException;
import co.edu.unicundi.discotiendaejbjar.excepciones.ResourceConflictException;
import co.edu.unicundi.discotiendaejbjar.excepciones.ResourceNotFoundException;
import co.edu.unicundi.discotiendaejbjar.repositorio.IArtistaRep;
import co.edu.unicundi.discotiendaejbjar.repositorio.IDiscoRep;
import co.edu.unicundi.discotiendaejbjar.servicio.IDiscoServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

/**
 * Clase que permite acceder a los métodos que operan la base de datos y valida
 * los datos que proporciona el api.
 * @author César Rodríguez
 * @author Eison Morales
 * @author Juan Páez
 * @author Diego Cobos
 */
@Stateless
public class DiscoServicioImp implements IDiscoServicio {

    /**
     * Permite acceder a los métodos que operan la base de datos.
     */
    @EJB
    private IDiscoRep repositorio;
    
    /**
     * Permite acceder a los métodos que operan la base de datos.
     */
    @EJB
    private IArtistaRep repositorioArtista;

    /**
     * Método que comprueba si el nombre existe, si es así, busca el disco con
     * dicho nombre.
     * @param nombre
     * @return
     */
    @Override
    public DiscoDto buscarPorNombre(String nombre) throws ResourceNotFoundException{
        if (this.repositorio.validarExistenciaPorNombre(nombre) == 1) {
            DiscoDto discoDto = new DiscoDto();
            ModelMapper mapper = new ModelMapper();
            mapper.map( this.repositorio.buscarPorNombre(nombre), discoDto);
            discoDto.setIdArtista(this.repositorio.buscarPorNombre(nombre).getArtista().getId());
            return discoDto;
        } else {
            throw new ResourceNotFoundException("Ese nombre del disco no existe en la base de datos.");
        }
    }

    /**
     * Método que comprueba si el id existe, si es así, busca el disco con dicho
     * id.
     * @param id
     * @return
     */
    @Override
    public DiscoDto buscarPorId(Integer id) throws ResourceNotFoundException{
        if (this.repositorio.validarExistenciaPorId(id) == 1) {
            DiscoDto discoDto = new DiscoDto();
            ModelMapper mapper = new ModelMapper();
            mapper.map( this.repositorio.buscarPorId(id), discoDto);
            discoDto.setIdArtista(this.repositorio.buscarPorId(id).getArtista().getId());
            return discoDto;
        } else {
         throw new ResourceNotFoundException("Ese id no existe en la base de datos.");
        }
        /*Objeto que debe borrarse cuando se implementen las excepciones.
         */

    }

    /**
     * Metodo que hace una busqueda de todos los discos en la base de datos.
     * @return
     */
    @Override
    public List<DiscoDto> buscarTodo() {
        ModelMapper mapper = new ModelMapper();
        
        //Mapeo de listas con TypeToken.
        List<DiscoDto> discoDto = mapper.map(
                this.repositorio.buscarTodo(), 
                new TypeToken<List<DiscoDto>>(){}.getType());
        
        for (DiscoDto discoDtoAux : discoDto) {
            discoDtoAux.setIdArtista(this.repositorio.buscarPorId(discoDtoAux.getId()).getArtista().getId());
        }
        return discoDto;
    }

    /**
     * Metodo que comprueba si hay un disco que existe con el mismo nombre.
     * @param objeto
     */
    @Override
    public void registrar(Disco objeto) throws ResourceConflictException, ResourceNotFoundException{
        if (this.repositorio.validarExistenciaPorNombre(objeto.getNombre()) == 1) {
            throw new ResourceConflictException("Actualmente hay un disco registrado con ese nombre.");
        } else {
            if(this.repositorioArtista.validarExistenciaPorId(objeto.getIdArtista()) == 1){
                Artista artista = new Artista();
                artista.setId(objeto.getIdArtista());
                objeto.setArtista(artista);
                this.repositorio.registrar(objeto);
            }else{
                throw new ResourceNotFoundException("El id del artista ingresado no existe en la base de datos.");
            }
        }
    }

    /**
     * Método que comprueba si el id existe y los datos proporcionados (nombre)
     * no están registrados con otro disco, si es así, permite modificar el
     * disco.
     * @param objeto
     */
    @Override
    public void actualizar(Disco objeto) throws ResourceNotFoundException, BussinessException{
        if ((objeto.getId() != null)) {
            if (this.repositorio.validarExistenciaPorId(objeto.getId()) == 1) {
                this.repositorio.actualizar(objeto);
            } else {
                 throw new ResourceNotFoundException("No existe ese id en la base de datos.");
            }
        } else {
            throw new BussinessException("Es necesario ingresar un id.");
        }
    }

    /**
     * Método que comprueba si el id ingresado existe, si es así, procede a
     * eliminar el disco de dicho id.
     * @param id
     */
    @Override
    public void eliminarJPQL(Integer id) throws ResourceNotFoundException {
        if (this.repositorio.validarExistenciaPorId(id) == 1) {
            this.repositorio.eliminarJPQL(id);
        } else {
            throw new ResourceNotFoundException("No existe ese id en la base de datos.");

        }
    }

    /**
     * Método que comprueba si el id ingresado existe, si es así, procede a
     * eliminar el disco de dicho id.
     * @param id
     */
    @Override
    public void eliminarSQL(Integer id) throws ResourceNotFoundException {
        if (this.repositorio.validarExistenciaPorId(id) == 1) {
            this.repositorio.eliminarSQL(id);
        } else {  
            throw new ResourceNotFoundException("No existe ese id en la base de datos.");

        }
    }

}
