/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.dto;

import java.io.Serializable;

/**
 *
 * @author cesar
 */
public class UsuarioCompraDto implements Serializable{
    
    private UsuarioDto usuarioDto;
    
    private CompraDto compraDto;

    public UsuarioCompraDto() {
    }

    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }

    public CompraDto getCompraDto() {
        return compraDto;
    }

    public void setCompraDto(CompraDto compraDto) {
        this.compraDto = compraDto;
    }
    
}
