/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio.implementacion;

import co.edu.unicundi.discotiendaejbjar.entidad.Artista;
import co.edu.unicundi.discotiendaejbjar.entidad.Disco;
import co.edu.unicundi.discotiendaejbjar.repositorio.IArtistaRep;
import co.edu.unicundi.discotiendaejbjar.repositorio.IDiscoRep;
import co.edu.unicundi.discotiendaejbjar.servicio.IDiscoServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

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
    public Disco buscarPorNombre(String nombre) {
        if (this.repositorio.validarExistenciaPorNombre(nombre) == 1) {
            return this.repositorio.buscarPorNombre(nombre);
        } else {
            System.out.println("Excepcion: Ese nombre del disco no existe en la base de datos.");
        }
        /*Objeto que debe borrarse cuando se implementen las excepciones.
         */
        Disco c = new Disco();
        /**/
        return c;
    }

    /**
     * Método que comprueba si el id existe, si es así, busca el disco con dicho
     * id.
     * @param id
     * @return
     */
    @Override
    public Disco buscarPorId(Integer id) {
        if (this.repositorio.validarExistenciaPorId(id) == 1) {
            return this.repositorio.buscarPorId(id);
        } else {
            System.out.println("Excepcion: Ese id no existe en la base de datos.");
        }
        /*Objeto que debe borrarse cuando se implementen las excepciones.
         */
        Disco c = new Disco();
        /**/
        return c;
    }

    /**
     * Metodo que hace una busqueda de todos los discos en la base de datos.
     * @return
     */
    @Override
    public List<Disco> buscarTodo() {
        return this.repositorio.buscarTodo();
    }

    /**
     * Metodo que comprueba si hay un disco que existe con el mismo nombre.
     * @param objeto
     */
    @Override
    public void registrar(Disco objeto) {
        if (this.repositorio.validarExistenciaPorNombre(objeto.getNombre()) == 1) {
            System.out.println("Excepcion: Actualmente hay un disco registrado con ese nombre.");
        } else {
            if(this.repositorioArtista.validarExistenciaPorId(objeto.getIdArtista()) == 1){
                Artista artista = new Artista();
                artista.setId(objeto.getIdArtista());
                objeto.setArtista(artista);
                this.repositorio.registrar(objeto);
            }else{
                System.out.println("Excepcion: El id del artista ingresado no existe en la base de datos.");
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
    public void actualizar(Disco objeto) {
        if ((objeto.getId() != null)) {
            if (this.repositorio.validarExistenciaPorId(objeto.getId()) == 1) {
                this.repositorio.actualizar(objeto);
            } else {
                System.out.println("Excepcion: No existe ese id en la base de datos.");
            }
        } else {
            System.out.println("Excepcion: Es necesario ingresar un id.");
        }
    }

    /**
     * Método que comprueba si el id ingresado existe, si es así, procede a
     * eliminar el disco de dicho id.
     * @param id
     */
    @Override
    public void eliminarJPQL(Integer id) {
        if (this.repositorio.validarExistenciaPorId(id) == 1) {
            this.repositorio.eliminarJPQL(id);
        } else {
            System.out.println("Excepcion: No existe ese id en la base de datos.");
        }
    }

    /**
     * Método que comprueba si el id ingresado existe, si es así, procede a
     * eliminar el disco de dicho id.
     * @param id
     */
    @Override
    public void eliminarSQL(Integer id) {
        if (this.repositorio.validarExistenciaPorId(id) == 1) {
            this.repositorio.eliminarSQL(id);
        } else {
            System.out.println("Excepcion: No existe ese id en la base de datos.");
        }
    }

}
