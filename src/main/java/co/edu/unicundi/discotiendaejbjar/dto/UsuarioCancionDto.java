/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.dto;

/**
 *
 * @author cesar
 */
public class UsuarioCancionDto {
    
    private CancionDto cancion;
    
    private String fechaCompra;
    
    public UsuarioCancionDto(){
        
    }

    public CancionDto getCancion() {
        return cancion;
    }

    public void setCancion(CancionDto cancion) {
        this.cancion = cancion;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    
}
