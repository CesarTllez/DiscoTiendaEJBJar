/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio.implementacion;

import co.edu.unicundi.discotiendaejbjar.dto.CancionDto;
import co.edu.unicundi.discotiendaejbjar.dto.CompraDto;
import co.edu.unicundi.discotiendaejbjar.entidad.Cancion;
import co.edu.unicundi.discotiendaejbjar.entidad.Disco;
import co.edu.unicundi.discotiendaejbjar.entidad.Formato;
import co.edu.unicundi.discotiendaejbjar.excepciones.EntityValidationException;
import co.edu.unicundi.discotiendaejbjar.excepciones.ResourceConflictException;
import co.edu.unicundi.discotiendaejbjar.excepciones.ResourceNotFoundException;
import co.edu.unicundi.discotiendaejbjar.repositorio.ICancionRep;
import co.edu.unicundi.discotiendaejbjar.repositorio.IDiscoRep;
import co.edu.unicundi.discotiendaejbjar.repositorio.ITokenRep;

import co.edu.unicundi.discotiendaejbjar.servicio.ICancionServicio;
import co.edu.unicundi.discotiendaejbjar.vista.HistorialVentaCancion;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class CancionServicioImp implements ICancionServicio {

    /**
     * Permite acceder a los métodos que operan la base de datos.
     */
    @EJB
    private ICancionRep repositorio;
    
    /**
     * Permite acceder a los métodos que operan la base de datos.
     */
    @EJB
    private IDiscoRep repositorioDisco;
    
    /**
     * Permite acceder a los métodos que operan la base de datos.
     */
    @EJB
    private ITokenRep repositorioToken;

    /**
     * Método que comprueba si el nombre existe, si es así, busca la cancion con
     * dicho nombre.
     * @param nombre
     * @return
     */
    @Override
    public CancionDto buscarPorNombre(String nombre)throws ResourceNotFoundException{
        if (this.repositorio.validarExistenciaPorNombre(nombre) == 1) {
            CancionDto cancionDto = new CancionDto();
            ModelMapper mapper = new ModelMapper();
            mapper.map( this.repositorio.buscarPorNombre(nombre), cancionDto);
            cancionDto.setIdDisco(this.repositorio.buscarPorNombre(nombre).getDisco().getId());
            cancionDto.setIdFormato(this.repositorio.buscarPorNombre(nombre).getFormato().getId());
            return cancionDto;
        } else {
            throw new ResourceNotFoundException("Ese nombre de la cancion no existe en la base de datos."); 
        }

    }

    /**
     * Método que comprueba si el id existe, si es así, busca la cancion con
     * dicho id.
     * @param id
     * @return
     */
    @Override
    public CancionDto buscarPorId(Integer id)throws ResourceNotFoundException{
        if (this.repositorio.validarExistenciaPorId(id) == 1) {
            CancionDto cancionDto = new CancionDto();
            ModelMapper mapper = new ModelMapper();
            mapper.map( this.repositorio.buscarPorId(id), cancionDto);
            cancionDto.setIdDisco(this.repositorio.buscarPorId(id).getDisco().getId());
            cancionDto.setIdFormato(this.repositorio.buscarPorId(id).getFormato().getId());
            return cancionDto;
        } else {
            throw new ResourceNotFoundException("Ese id no existe en la base de datos."); 
          
        }
   
    }
    
    /**
     * Metodo que hace una busqueda de todas las canciones por id del disco en la base de datos.
     * @return 
     */
    @Override
    public List<CancionDto> buscarTodosPorIdDisco(Integer idDisco) {
        ModelMapper mapper = new ModelMapper();
        
        //Mapeo de listas con TypeToken.
        List<CancionDto> cancionDto = mapper.map(
                this.repositorio.buscarTodosPorIdDisco(idDisco), 
                new TypeToken<List<CancionDto>>(){}.getType());
        
        for (CancionDto cancionDtoAux : cancionDto) {
            cancionDtoAux.setIdDisco(this.repositorio.buscarPorId(cancionDtoAux.getId()).getDisco().getId());
            cancionDtoAux.setIdFormato(this.repositorio.buscarPorId(cancionDtoAux.getId()).getFormato().getId());
        }
        return cancionDto;
    }

    /**
     * Metodo que hace una busqueda de todas las canciones en la base de datos
     *
     * @return
     */
    @Override
    public List<CancionDto> buscarTodo() {
        ModelMapper mapper = new ModelMapper();
        
        //Mapeo de listas con TypeToken.
        List<CancionDto> cancionDto = mapper.map(
                this.repositorio.buscarTodo(), 
                new TypeToken<List<CancionDto>>(){}.getType());
        
        for (CancionDto cancionDtoAux : cancionDto) {
            cancionDtoAux.setIdDisco(this.repositorio.buscarPorId(cancionDtoAux.getId()).getDisco().getId());
            cancionDtoAux.setIdFormato(this.repositorio.buscarPorId(cancionDtoAux.getId()).getFormato().getId());
        }
        return cancionDto;
    }

    /**
     * Metodo que comprueba si hay una cancion que existe con el mismo nombre
     *
     * @param objeto
     */
    @Override
    public void registrar(Cancion objeto) throws ResourceConflictException, ResourceNotFoundException{
        if (this.repositorio.validarExistenciaPorNombre(objeto.getNombre()) == 1) {
            throw new ResourceConflictException("Actualmente hay una cancion registrada con ese nombre.");
        } else {
            if(this.repositorioDisco.validarExistenciaPorId(objeto.getIdDisco()) == 1){
                Disco disco = new Disco();
                disco.setId(objeto.getIdDisco());
                Formato formato = new Formato();
                formato.setId(objeto.getIdFormato());
                objeto.setDisco(disco);
                objeto.setFormato(formato);
                this.repositorio.registrar(objeto);
            }else{
                throw new ResourceNotFoundException("El id del disco ingresado no existe en la base de datos.");
                
            }
        }
    }

    /**
     * Método que comprueba si el id existe y los datos proporcionados (nombre)
     * no están registrados con otra cancion, si es así, permite modificar la
     * cancion.
     *
     * @param objeto
     */
    @Override
    public void actualizar(Cancion objeto)throws ResourceNotFoundException, EntityValidationException{
        if ((objeto.getId() != null)) {
            if (this.repositorio.validarExistenciaPorId(objeto.getId()) == 1) {
                if (this.repositorio.validarExistenciaPorNombre(objeto.getNombre()) == 1){
                    System.out.println("Excepcion: Ya existe una cancion con ese nombre.");
                }else{
                    this.repositorio.actualizar(objeto);
                }
            } else {
                throw new ResourceNotFoundException("No existe ese id en la base de datos.");
              
            }
        } else {
            throw new EntityValidationException("Es necesario ingresar un id.");
        }
    }

    /**
     * Método que comprueba si el id ingresado existe, si es así, procede a
     * eliminar la cancion de dicho id.
     * @param id
     */
    @Override
    public void eliminarJPQL(Integer id)throws ResourceNotFoundException{
        if (this.repositorio.validarExistenciaPorId(id) == 1) {
            this.repositorio.eliminarJPQL(id);
        } else {
            throw new ResourceNotFoundException("No existe ese id en la base de datos.");
                   
        }
    }

    /**
     * Método que comprueba si el id ingresado existe, si es así, procede a
     * eliminar la cancion de dicho id.
     *
     * @param id
     */
    @Override
    public void eliminarSQL(Integer id)throws ResourceNotFoundException{
        if (this.repositorio.validarExistenciaPorId(id) == 1) {
            this.repositorio.eliminarSQL(id);
        } else {
            throw new ResourceNotFoundException("No existe ese id en la base de datos.");
        }
    }

    @Override
    public void registrarCompra(CompraDto idCompra, String token) throws ResourceConflictException{
        if(this.repositorio.validarExistenciaPorIdsUC(idCompra.getId(), 
                this.repositorioToken.buscarPorContenido(token).getUsuario().getId()) == 1){
            throw new ResourceConflictException("Esta cancion ya ha sido comprada.");
        }else{
            LocalDateTime fecha = LocalDateTime.now();
            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String fechaFInal = fecha.format(formatoFecha);
            this.repositorio.registrarCompra(idCompra.getId(), 
                this.repositorioToken
                      .buscarPorContenido(token)
                      .getUsuario()
                      .getId(), fechaFInal);
        }
    }

    @Override
    public List<HistorialVentaCancion> historialVentaCancion() {
       return this.repositorio.historialVentaCancion();   //To change body of generated methods, choose Tools | Templates.
    }

 

}
