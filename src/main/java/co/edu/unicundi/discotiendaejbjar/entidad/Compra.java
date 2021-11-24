/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.discotiendaejbjar.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author cesar
 */
@Entity
@Table(name = "compra")
//Anotación para queries JPQL's.
@NamedQueries({
    //Buscar compra por el id del usuario.
    @NamedQuery(name = "Compra.buscarTodos", query = "SELECT c FROM Compra c"),
    //Buscar compra por el nombre del producto y el precio del mismo
    @NamedQuery(name = "Compra.buscarPorNombrePdYPrecio", query = "SELECT c FROM Compra c WHERE c.nombreProducto = :nombreProducto AND c.precioProducto = :precioProducto"),
})
public class Compra implements Serializable{
    
    /**
     * Almacena el id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    /**
     * Almacena el nombre del producto.
     */
    @NotNull(message = "Debe ingresar un nombre.")
    @Size(min = 3, max = 25, message = "Longitud requerida: Minimo 3 - Maximo 25 caracteres")
    @Column(name = "nombre_producto", nullable = false, unique = true, length = 25)
    private String nombreProducto;
    
    /**
     * Almacena el precio del producto.
     */
    @NotNull(message = "Debe ingresar un precio.")
    @Column(name = "precio_producto", nullable = false)
    private double precioProducto;
    
    /**
     * Almacena la fecha.
     */
    @Column(name = "fecha", nullable = false)
    private String fecha;

    /**
     * Relación uno a muchos con usuario.
     */
    @OneToMany(mappedBy = "compra", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<UsuarioCompra> usuarioCompra;
    
    /**
     * Contructor pot defecto de la clase.
     */
    public Compra() {
    }

    /**
     * Constructor en donde se inicializan los atributos de la clase.
     * @param id
     * @param nombreProducto
     * @param precioProducto
     */
    public Compra(Integer id, String nombreProducto, double precioProducto) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.fecha = new Date().toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<UsuarioCompra> getUsuarioCompra() {
        return usuarioCompra;
    }

    public void setUsuarioCompra(List<UsuarioCompra> usuarioCompra) {
        this.usuarioCompra = usuarioCompra;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Compra other = (Compra) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
