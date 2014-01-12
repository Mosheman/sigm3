/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mario
 */
@Entity
@Table(name = "TERM_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TermType.findAll", query = "SELECT t FROM TermType t"),
    @NamedQuery(name = "TermType.findByIdTermType", query = "SELECT t FROM TermType t WHERE t.idTermType = :idTermType"),
    @NamedQuery(name = "TermType.findByTermTypeName", query = "SELECT t FROM TermType t WHERE t.termTypeName = :termTypeName")})
public class TermType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TERM_TYPE")
    private Integer idTermType;
    @Size(max = 40)
    @Column(name = "TERM_TYPE_NAME")
    private String termTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTermType")
    private Collection<Term> termCollection;

    public TermType() {
    }

    public TermType(Integer idTermType) {
        this.idTermType = idTermType;
    }

    public Integer getIdTermType() {
        return idTermType;
    }

    public void setIdTermType(Integer idTermType) {
        this.idTermType = idTermType;
    }

    public String getTermTypeName() {
        return termTypeName;
    }

    public void setTermTypeName(String termTypeName) {
        this.termTypeName = termTypeName;
    }

    @XmlTransient
    public Collection<Term> getTermCollection() {
        return termCollection;
    }

    public void setTermCollection(Collection<Term> termCollection) {
        this.termCollection = termCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTermType != null ? idTermType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TermType)) {
            return false;
        }
        TermType other = (TermType) object;
        if ((this.idTermType == null && other.idTermType != null) || (this.idTermType != null && !this.idTermType.equals(other.idTermType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TermType[ idTermType=" + idTermType + " ]";
    }
    
}
