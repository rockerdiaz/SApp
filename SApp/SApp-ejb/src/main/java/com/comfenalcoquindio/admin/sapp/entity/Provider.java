/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comfenalcoquindio.admin.sapp.entity;

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
 * @author rockerW7
 */
@Entity
@Table(name = "provider")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provider.findAll", query = "SELECT p FROM Provider p"),
    @NamedQuery(name = "Provider.findByIdprovider", query = "SELECT p FROM Provider p WHERE p.idprovider = :idprovider"),
    @NamedQuery(name = "Provider.findByName", query = "SELECT p FROM Provider p WHERE p.name = :name")})
public class Provider implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idprovider")
    private Integer idprovider;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "providerIdprovider")
    private List<Quotation> quotationList;

    public Provider() {
    }

    public Provider(Integer idprovider) {
        this.idprovider = idprovider;
    }

    public Provider(Integer idprovider, String name) {
        this.idprovider = idprovider;
        this.name = name;
    }

    public Integer getIdprovider() {
        return idprovider;
    }

    public void setIdprovider(Integer idprovider) {
        this.idprovider = idprovider;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Quotation> getQuotationList() {
        return quotationList;
    }

    public void setQuotationList(List<Quotation> quotationList) {
        this.quotationList = quotationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprovider != null ? idprovider.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provider)) {
            return false;
        }
        Provider other = (Provider) object;
        if ((this.idprovider == null && other.idprovider != null) || (this.idprovider != null && !this.idprovider.equals(other.idprovider))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.comfenalcoquindio.admin.sapp.entity.Provider[ idprovider=" + idprovider + " ]";
    }
    
}
