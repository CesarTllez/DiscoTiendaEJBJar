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
public class TokenInterceptor {
    
    private String sub;
    
    private Integer iat;
    
    private Integer exp;
    
    private RolDto rol;

    public TokenInterceptor() {
    }

    public TokenInterceptor(String sub, Integer iat, Integer exp, RolDto rol) {
        this.sub = sub;
        this.iat = iat;
        this.exp = exp;
        this.rol = rol;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public Integer getIat() {
        return iat;
    }

    public void setIat(Integer iat) {
        this.iat = iat;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public RolDto getRol() {
        return rol;
    }

    public void setRol(RolDto rol) {
        this.rol = rol;
    }
    
}
