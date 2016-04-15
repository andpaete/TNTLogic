/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author paez
 */
@Entity
@Table(name = "mercancia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mercancia.findAll", query = "SELECT m FROM Mercancia m"),
    @NamedQuery(name = "Mercancia.findByIdmercancia", query = "SELECT m FROM Mercancia m WHERE m.idmercancia = :idmercancia"),
    @NamedQuery(name = "Mercancia.findByNombre", query = "SELECT m FROM Mercancia m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Mercancia.findByPeso", query = "SELECT m FROM Mercancia m WHERE m.peso = :peso"),
    @NamedQuery(name = "Mercancia.findByVolumen", query = "SELECT m FROM Mercancia m WHERE m.volumen = :volumen")})
public class Mercancia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmercancia")
    private Integer idmercancia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso")
    private BigInteger peso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "volumen")
    private BigInteger volumen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmercancia")
    private List<Detallesolicitud> detallesolicitudList;

    public Mercancia() {
    }

    public Mercancia(Integer idmercancia) {
        this.idmercancia = idmercancia;
    }

    public Mercancia(Integer idmercancia, String nombre, BigInteger peso, BigInteger volumen) {
        this.idmercancia = idmercancia;
        this.nombre = nombre;
        this.peso = peso;
        this.volumen = volumen;
    }

    public Integer getIdmercancia() {
        return idmercancia;
    }

    public void setIdmercancia(Integer idmercancia) {
        this.idmercancia = idmercancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigInteger getPeso() {
        return peso;
    }

    public void setPeso(BigInteger peso) {
        this.peso = peso;
    }

    public BigInteger getVolumen() {
        return volumen;
    }

    public void setVolumen(BigInteger volumen) {
        this.volumen = volumen;
    }

    @XmlTransient
    public List<Detallesolicitud> getDetallesolicitudList() {
        return detallesolicitudList;
    }

    public void setDetallesolicitudList(List<Detallesolicitud> detallesolicitudList) {
        this.detallesolicitudList = detallesolicitudList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmercancia != null ? idmercancia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mercancia)) {
            return false;
        }
        Mercancia other = (Mercancia) object;
        if ((this.idmercancia == null && other.idmercancia != null) || (this.idmercancia != null && !this.idmercancia.equals(other.idmercancia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.modelo.Mercancia[ idmercancia=" + idmercancia + " ]";
    }
    
}
