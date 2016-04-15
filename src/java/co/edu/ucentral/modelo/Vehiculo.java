/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucentral.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author paez
 */
@Entity
@Table(name = "vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v"),
    @NamedQuery(name = "Vehiculo.findByIdvehiculo", query = "SELECT v FROM Vehiculo v WHERE v.idvehiculo = :idvehiculo"),
    @NamedQuery(name = "Vehiculo.findByPlaca", query = "SELECT v FROM Vehiculo v WHERE v.placa = :placa"),
    @NamedQuery(name = "Vehiculo.findByMarca", query = "SELECT v FROM Vehiculo v WHERE v.marca = :marca"),
    @NamedQuery(name = "Vehiculo.findByModelo", query = "SELECT v FROM Vehiculo v WHERE v.modelo = :modelo"),
    @NamedQuery(name = "Vehiculo.findByPesomax", query = "SELECT v FROM Vehiculo v WHERE v.pesomax = :pesomax"),
    @NamedQuery(name = "Vehiculo.findByVolumenmax", query = "SELECT v FROM Vehiculo v WHERE v.volumenmax = :volumenmax"),
    @NamedQuery(name = "Vehiculo.findByConductor", query = "SELECT v FROM Vehiculo v WHERE v.conductor = :conductor"),
    @NamedQuery(name = "Vehiculo.findByFechacrea", query = "SELECT v FROM Vehiculo v WHERE v.fechacrea = :fechacrea")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idvehiculo")
    private Integer idvehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "placa")
    private String placa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modelo")
    private int modelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pesomax")
    private int pesomax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "volumenmax")
    private int volumenmax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "conductor")
    private int conductor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacrea")
    @Temporal(TemporalType.DATE)
    private Date fechacrea;
    @JoinColumn(name = "idsede", referencedColumnName = "idsede")
    @ManyToOne(optional = false)
    private Sede idsede;
    @JoinColumn(name = "idestado", referencedColumnName = "idvehiculo")
    @ManyToOne(optional = false)
    private Estadovehiculo idestado;
    @OneToMany(mappedBy = "idvehiculo")
    private List<Solicitud> solicitudList;

    public Vehiculo() {
    }

    public Vehiculo(Integer idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public Vehiculo(Integer idvehiculo, String placa, String marca, int modelo, int pesomax, int volumenmax, int conductor, Date fechacrea) {
        this.idvehiculo = idvehiculo;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.pesomax = pesomax;
        this.volumenmax = volumenmax;
        this.conductor = conductor;
        this.fechacrea = fechacrea;
    }

    public Integer getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Integer idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public int getPesomax() {
        return pesomax;
    }

    public void setPesomax(int pesomax) {
        this.pesomax = pesomax;
    }

    public int getVolumenmax() {
        return volumenmax;
    }

    public void setVolumenmax(int volumenmax) {
        this.volumenmax = volumenmax;
    }

    public int getConductor() {
        return conductor;
    }

    public void setConductor(int conductor) {
        this.conductor = conductor;
    }

    public Date getFechacrea() {
        return fechacrea;
    }

    public void setFechacrea(Date fechacrea) {
        this.fechacrea = fechacrea;
    }

    public Sede getIdsede() {
        return idsede;
    }

    public void setIdsede(Sede idsede) {
        this.idsede = idsede;
    }

    public Estadovehiculo getIdestado() {
        return idestado;
    }

    public void setIdestado(Estadovehiculo idestado) {
        this.idestado = idestado;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
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
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.idvehiculo == null && other.idvehiculo != null) || (this.idvehiculo != null && !this.idvehiculo.equals(other.idvehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.modelo.Vehiculo[ idvehiculo=" + idvehiculo + " ]";
    }
    
}
