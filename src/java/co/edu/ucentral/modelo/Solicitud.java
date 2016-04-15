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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author paez
 */
@Entity
@Table(name = "solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s"),
    @NamedQuery(name = "Solicitud.findByIdsolicitud", query = "SELECT s FROM Solicitud s WHERE s.idsolicitud = :idsolicitud"),
    @NamedQuery(name = "Solicitud.findByIdclienteorigen", query = "SELECT s FROM Solicitud s WHERE s.idclienteorigen = :idclienteorigen"),
    @NamedQuery(name = "Solicitud.findByIdestado", query = "SELECT s FROM Solicitud s WHERE s.idestado = :idestado"),
    @NamedQuery(name = "Solicitud.findByIdclientedestino", query = "SELECT s FROM Solicitud s WHERE s.idclientedestino = :idclientedestino")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsolicitud")
    private Integer idsolicitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idclienteorigen")
    private int idclienteorigen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idestado")
    private int idestado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idclientedestino")
    private int idclientedestino;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsolicitud")
    private List<Detallesolicitud> detallesolicitudList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsolicitud")
    private List<Logsolicitud> logsolicitudList;
    @JoinColumn(name = "idvehiculo", referencedColumnName = "idvehiculo")
    @ManyToOne
    private Vehiculo idvehiculo;
    @JoinColumn(name = "idsede", referencedColumnName = "idsede")
    @ManyToOne(optional = false)
    private Sede idsede;

    public Solicitud() {
    }

    public Solicitud(Integer idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    public Solicitud(Integer idsolicitud, int idclienteorigen, int idestado, int idclientedestino) {
        this.idsolicitud = idsolicitud;
        this.idclienteorigen = idclienteorigen;
        this.idestado = idestado;
        this.idclientedestino = idclientedestino;
    }

    public Integer getIdsolicitud() {
        return idsolicitud;
    }

    public void setIdsolicitud(Integer idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    public int getIdclienteorigen() {
        return idclienteorigen;
    }

    public void setIdclienteorigen(int idclienteorigen) {
        this.idclienteorigen = idclienteorigen;
    }

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public int getIdclientedestino() {
        return idclientedestino;
    }

    public void setIdclientedestino(int idclientedestino) {
        this.idclientedestino = idclientedestino;
    }

    @XmlTransient
    public List<Detallesolicitud> getDetallesolicitudList() {
        return detallesolicitudList;
    }

    public void setDetallesolicitudList(List<Detallesolicitud> detallesolicitudList) {
        this.detallesolicitudList = detallesolicitudList;
    }

    @XmlTransient
    public List<Logsolicitud> getLogsolicitudList() {
        return logsolicitudList;
    }

    public void setLogsolicitudList(List<Logsolicitud> logsolicitudList) {
        this.logsolicitudList = logsolicitudList;
    }

    public Vehiculo getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Vehiculo idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public Sede getIdsede() {
        return idsede;
    }

    public void setIdsede(Sede idsede) {
        this.idsede = idsede;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsolicitud != null ? idsolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.idsolicitud == null && other.idsolicitud != null) || (this.idsolicitud != null && !this.idsolicitud.equals(other.idsolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.modelo.Solicitud[ idsolicitud=" + idsolicitud + " ]";
    }
    
}
