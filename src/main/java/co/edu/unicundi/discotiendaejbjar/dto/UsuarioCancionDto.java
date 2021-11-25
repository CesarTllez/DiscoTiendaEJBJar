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
public class UsuarioCancionDto implements Serializable{
    
    private UsuarioDto usuarioDto;
    
    private CancionDto cancionDto;

    public UsuarioCancionDto() {
    }

    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }

    public CancionDto getCancionDto() {
        return cancionDto;
    }

    public void setCancionDto(CancionDto cancionDto) {
        this.cancionDto = cancionDto;
    }
    
}
