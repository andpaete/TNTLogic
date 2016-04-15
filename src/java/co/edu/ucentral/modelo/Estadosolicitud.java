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
@Table(name = "estadosolicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadosolicitud.findAll", query = "SELECT e FROM Estadosolicitud e"),
    @NamedQuery(name = "Estadosolicitud.findByIdestadosolicitud", query = "SELECT e FROM Estadosolicitud e WHERE e.idestadosolicitud = :idestadosolicitud"),
    @NamedQuery(name = "Estadosolicitud.findByDescripcion", query = "SELECT e FROM Estadosolicitud e WHERE e.descripcion = :descripcion")})
public class Estadosolicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idestadosolicitud")
    private Integer idestadosolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestado")
    private List<Logsolicitud> logsolicitudList;

    public Estadosolicitud() {
    }

    public Estadosolicitud(Integer idestadosolicitud) {
        this.idestadosolicitud = idestadosolicitud;
    }

    public Estadosolicitud(Integer idestadosolicitud, String descripcion) {
        this.idestadosolicitud = idestadosolicitud;
        this.descripcion = descripcion;
    }

    public Integer getIdestadosolicitud() {
        return idestadosolicitud;
    }

    public void setIdestadosolicitud(Integer idestadosolicitud) {
        this.idestadosolicitud = idestadosolicitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Logsolicitud> getLogsolicitudList() {
        return logsolicitudList;
    }

    public void setLogsolicitudList(List<Logsolicitud> logsolicitudList) {
        this.logsolicitudList = logsolicitudList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestadosolicitud != null ? idestadosolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadosolicitud)) {
            return false;
        }
        Estadosolicitud other = (Estadosolicitud) object;
        if ((this.idestadosolicitud == null && other.idestadosolicitud != null) || (this.idestadosolicitud != null && !this.idestadosolicitud.equals(other.idestadosolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.modelo.Estadosolicitud[ idestadosolicitud=" + idestadosolicitud + " ]";
    }
    
}
