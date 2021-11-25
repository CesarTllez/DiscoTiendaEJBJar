/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio.implementacion;

import co.edu.unicundi.discotiendaejbjar.entidad.Formato;
import co.edu.unicundi.discotiendaejbjar.repositorio.IFormatoRep;
import co.edu.unicundi.discotiendaejbjar.servicio.IFormatoServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author cesar
 */
@Stateless
public class FormatoServicioImp implements IFormatoServicio {
    
    /**
     * Permite acceder a los métodos que operan la base de datos.
     */
    @EJB
    private IFormatoRep repositorio;

    @Override
    public List<Formato> buscarTodos() {
        return this.repositorio.buscarTodos();
    }

    @Override
    public Formato buscarPorId(Integer id) {
        if(this.repositorio.validarExistenciaPorId(id) == 1){
            return this.repositorio.buscarPorId(id);
        }else{
            //Colocar la excecipción que es.
            throw new UnsupportedOperationException("El id ingresado no existe en la base de datos.");
        }
    }

    @Override
    public void registrar(Formato formato) {
        if(this.repositorio.validarExistenciaPorNombre(formato.getNombre()) == 1){
            //Colocar la excecipción que es.
            throw new UnsupportedOperationException("El nombre del formato ingresado ya existe en la base de datos.");
        }else{
            this.repositorio.registrar(formato);
        }
    }
    
}
