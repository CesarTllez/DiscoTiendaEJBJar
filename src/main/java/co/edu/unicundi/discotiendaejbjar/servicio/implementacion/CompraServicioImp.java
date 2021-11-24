/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio.implementacion;

import co.edu.unicundi.discotiendaejbjar.entidad.Compra;
import co.edu.unicundi.discotiendaejbjar.entidad.Usuario;
import co.edu.unicundi.discotiendaejbjar.repositorio.ICompraRep;
import co.edu.unicundi.discotiendaejbjar.repositorio.IUsuarioCompraRep;
import co.edu.unicundi.discotiendaejbjar.servicio.ICompraServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author cesar
 */
@Stateless
public class CompraServicioImp implements ICompraServicio{
    
    @EJB
    private ICompraRep repositorio;
    
    @EJB
    private IUsuarioCompraRep repositorioCU;

    @Override
    public List<Compra> buscarTodo() {
        return this.repositorio.buscarTodo();
    }

    @Override
    public void registrar(Compra objeto) {
        this.repositorio.registrar(objeto);
    }
    
}
