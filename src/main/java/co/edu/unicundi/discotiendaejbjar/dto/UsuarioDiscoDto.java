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
public class UsuarioDiscoDto {
    
    public DiscoDto disco;
    
    private String fechaCompra;

    public DiscoDto getDisco() {
        return disco;
    }

    public void setDisco(DiscoDto disco) {
        this.disco = disco;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    
}
