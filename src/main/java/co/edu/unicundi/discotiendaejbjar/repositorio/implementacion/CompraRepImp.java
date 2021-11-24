/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.repositorio.implementacion;

import co.edu.unicundi.discotiendaejbjar.entidad.Compra;
import co.edu.unicundi.discotiendaejbjar.repositorio.ICompraRep;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author cesar
 */
@Stateless
public class CompraRepImp implements ICompraRep{
    
    /**
     * Permite realizar operaciones sobre la base de datos.
     */
    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;

    /**
     * Método que permite buscar todas las compras en BD.
     * @return 
     */
    @Override
    public List<Compra> buscarTodo() {
        TypedQuery<Compra> query = this.manager.createNamedQuery("Compra.buscarTodos", Compra.class);
        return query.getResultList();
    }

    /**
     * Método que permite registrar una compra en BD.
     * @param objeto 
     */
    @Override
    public void registrar(Compra objeto) {
        this.manager.persist(objeto);
    }

    /**
     * Método que permite buscar compra por nombre y precio del producto.
     * @param nombrePd
     * @param precioPd
     * @return 
     */
    @Override
    public Compra buscarPorNombrePdYPrecio(String nombrePd, double precioPd) {
        TypedQuery<Compra> query = this.manager.createNamedQuery("Compra.buscarPorNombrePdYPrecio", Compra.class);
        return query
                .setParameter("nombreProducto", nombrePd)
                .setHint("precioProducto", precioPd)
                .getSingleResult();
    }
    
}
