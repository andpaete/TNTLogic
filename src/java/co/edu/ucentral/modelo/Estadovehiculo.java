/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.modelo;

import java.io.Serializable;
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
@Table(name = "estadovehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadovehiculo.findAll", query = "SELECT e FROM Estadovehiculo e"),
    @NamedQuery(name = "Estadovehiculo.findByIdvehiculo", query = "SELECT e FROM Estadovehiculo e WHERE e.idvehiculo = :idvehiculo"),
    @NamedQuery(name = "Estadovehiculo.findByDescripcion", query = "SELECT e FROM Estadovehiculo e WHERE e.descripcion = :descripcion")})
public class Estadovehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idvehiculo")
    private Integer idvehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestado")
    private List<Vehiculo> vehiculoList;

    public Estadovehiculo() {
    }

    public Estadovehiculo(Integer idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public Estadovehiculo(Integer idvehiculo, String descripcion) {
        this.idvehiculo = idvehiculo;
        this.descripcion = descripcion;
    }

    public Integer getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Integer idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvehiculo != null ? idvehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadovehiculo)) {
            return false;
        }
        Estadovehiculo other = (Estadovehiculo) object;
        if ((this.idvehiculo == null && other.idvehiculo != null) || (this.idvehiculo != null && !this.idvehiculo.equals(other.idvehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.modelo.Estadovehiculo[ idvehiculo=" + idvehiculo + " ]";
    }
    
}
