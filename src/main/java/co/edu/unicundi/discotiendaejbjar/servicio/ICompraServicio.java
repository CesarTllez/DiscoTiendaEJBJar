/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio;

import co.edu.unicundi.discotiendaejbjar.entidad.Compra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cesar
 */
@Local
public interface ICompraServicio {
    
    /**
     * Método que permite buscar todas las compras.
     * @return 
     */
    public List<Compra> buscarTodo();
    
    /**
     * Método que permite registrar una compra.
     */
    public void registrar(Compra objeto);
    
}
