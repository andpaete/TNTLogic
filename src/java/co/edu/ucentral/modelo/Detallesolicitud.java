/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author paez
 */
@Entity
@Table(name = "detallesolicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallesolicitud.findAll", query = "SELECT d FROM Detallesolicitud d"),
    @NamedQuery(name = "Detallesolicitud.findByIddetallesolicitud", query = "SELECT d FROM Detallesolicitud d WHERE d.iddetallesolicitud = :iddetallesolicitud"),
    @NamedQuery(name = "Detallesolicitud.findByDistancia", query = "SELECT d FROM Detallesolicitud d WHERE d.distancia = :distancia"),
    @NamedQuery(name = "Detallesolicitud.findByCostotransporte", query = "SELECT d FROM Detallesolicitud d WHERE d.costotransporte = :costotransporte")})
public class Detallesolicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddetallesolicitud")
    private Integer iddetallesolicitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "distancia")
    private BigInteger distancia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costotransporte")
    private BigInteger costotransporte;
    @JoinColumn(name = "idsolicitud", referencedColumnName = "idsolicitud")
    @ManyToOne(optional = false)
    private Solicitud idsolicitud;
    @JoinColumn(name = "idmercancia", referencedColumnName = "idmercancia")
    @ManyToOne(optional = false)
    private Mercancia idmercancia;

    public Detallesolicitud() {
    }

    public Detallesolicitud(Integer iddetallesolicitud) {
        this.iddetallesolicitud = iddetallesolicitud;
    }

    public Detallesolicitud(Integer iddetallesolicitud, BigInteger distancia, BigInteger costotransporte) {
        this.iddetallesolicitud = iddetallesolicitud;
        this.distancia = distancia;
        this.costotransporte = costotransporte;
    }

    public Integer getIddetallesolicitud() {
        return iddetallesolicitud;
    }

    public void setIddetallesolicitud(Integer iddetallesolicitud) {
        this.iddetallesolicitud = iddetallesolicitud;
    }

    public BigInteger getDistancia() {
        return distancia;
    }

    public void setDistancia(BigInteger distancia) {
        this.distancia = distancia;
    }

    public BigInteger getCostotransporte() {
        return costotransporte;
    }

    public void setCostotransporte(BigInteger costotransporte) {
        this.costotransporte = costotransporte;
    }

    public Solicitud getIdsolicitud() {
        return idsolicitud;
    }

    public void setIdsolicitud(Solicitud idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    public Mercancia getIdmercancia() {
        return idmercancia;
    }

    public void setIdmercancia(Mercancia idmercancia) {
        this.idmercancia = idmercancia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetallesolicitud != null ? iddetallesolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallesolicitud)) {
            return false;
        }
        Detallesolicitud other = (Detallesolicitud) object;
        if ((this.iddetallesolicitud == null && other.iddetallesolicitud != null) || (this.iddetallesolicitud != null && !this.iddetallesolicitud.equals(other.iddetallesolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.modelo.Detallesolicitud[ iddetallesolicitud=" + iddetallesolicitud + " ]";
    }
    
}
