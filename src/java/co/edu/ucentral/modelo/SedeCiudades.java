/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.modelo;

import java.io.Serializable;
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
@Table(name = "sede_ciudades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SedeCiudades.findAll", query = "SELECT s FROM SedeCiudades s"),
    @NamedQuery(name = "SedeCiudades.findByCiudadprincipal", query = "SELECT s FROM SedeCiudades s WHERE s.ciudadprincipal = :ciudadprincipal")})
public class SedeCiudades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ciudadprincipal")
    private Boolean ciudadprincipal;
    @JoinColumn(name = "idsede", referencedColumnName = "idsede")
    @ManyToOne(optional = false)
    private Sede idsede;
    @JoinColumn(name = "idciudad", referencedColumnName = "idciudad")
    @ManyToOne(optional = false)
    private Ciudad idciudad;

    public SedeCiudades() {
    }

    public SedeCiudades(Boolean ciudadprincipal) {
        this.ciudadprincipal = ciudadprincipal;
    }

    public Boolean getCiudadprincipal() {
        return ciudadprincipal;
    }

    public void setCiudadprincipal(Boolean ciudadprincipal) {
        this.ciudadprincipal = ciudadprincipal;
    }

    public Sede getIdsede() {
        return idsede;
    }

    public void setIdsede(Sede idsede) {
        this.idsede = idsede;
    }

    public Ciudad getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Ciudad idciudad) {
        this.idciudad = idciudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciudadprincipal != null ? ciudadprincipal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SedeCiudades)) {
            return false;
        }
        SedeCiudades other = (SedeCiudades) object;
        if ((this.ciudadprincipal == null && other.ciudadprincipal != null) || (this.ciudadprincipal != null && !this.ciudadprincipal.equals(other.ciudadprincipal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.modelo.SedeCiudades[ ciudadprincipal=" + ciudadprincipal + " ]";
    }
    
}
