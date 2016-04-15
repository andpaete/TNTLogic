/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author paez
 */
@Entity
@Table(name = "logsolicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logsolicitud.findAll", query = "SELECT l FROM Logsolicitud l"),
    @NamedQuery(name = "Logsolicitud.findByIdlogsolicitud", query = "SELECT l FROM Logsolicitud l WHERE l.idlogsolicitud = :idlogsolicitud"),
    @NamedQuery(name = "Logsolicitud.findByFecharegistro", query = "SELECT l FROM Logsolicitud l WHERE l.fecharegistro = :fecharegistro")})
public class Logsolicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idlogsolicitud")
    private Integer idlogsolicitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecharegistro")
    @Temporal(TemporalType.DATE)
    private Date fecharegistro;
    @JoinColumn(name = "idsolicitud", referencedColumnName = "idsolicitud")
    @ManyToOne(optional = false)
    private Solicitud idsolicitud;
    @JoinColumn(name = "idestado", referencedColumnName = "idestadosolicitud")
    @ManyToOne(optional = false)
    private Estadosolicitud idestado;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne
    private Clientes idcliente;

    public Logsolicitud() {
    }

    public Logsolicitud(Integer idlogsolicitud) {
        this.idlogsolicitud = idlogsolicitud;
    }

    public Logsolicitud(Integer idlogsolicitud, Date fecharegistro) {
        this.idlogsolicitud = idlogsolicitud;
        this.fecharegistro = fecharegistro;
    }

    public Integer getIdlogsolicitud() {
        return idlogsolicitud;
    }

    public void setIdlogsolicitud(Integer idlogsolicitud) {
        this.idlogsolicitud = idlogsolicitud;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Solicitud getIdsolicitud() {
        return idsolicitud;
    }

    public void setIdsolicitud(Solicitud idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    public Estadosolicitud getIdestado() {
        return idestado;
    }

    public void setIdestado(Estadosolicitud idestado) {
        this.idestado = idestado;
    }

    public Clientes getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Clientes idcliente) {
        this.idcliente = idcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlogsolicitud != null ? idlogsolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logsolicitud)) {
            return false;
        }
        Logsolicitud other = (Logsolicitud) object;
        if ((this.idlogsolicitud == null && other.idlogsolicitud != null) || (this.idlogsolicitud != null && !this.idlogsolicitud.equals(other.idlogsolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.modelo.Logsolicitud[ idlogsolicitud=" + idlogsolicitud + " ]";
    }
    
}
