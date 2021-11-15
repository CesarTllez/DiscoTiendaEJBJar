/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.servicio.implementacion;

import javax.ejb.Stateless;
import co.edu.unicundi.discotiendaejbjar.servicio.IPruebaServicio;

/**
 *
 * @author cesar
 */
@Stateless
public class PruebaImp implements IPruebaServicio{

    @Override
    public String mostrar() {
        return "Funciona";
    }
    
}
