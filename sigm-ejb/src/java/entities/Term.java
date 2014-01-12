/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mario
 */
@Entity
@Table(name = "TERM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Term.findAll", query = "SELECT t FROM Term t"),
    @NamedQuery(name = "Term.findByIdTerm", query = "SELECT t FROM Term t WHERE t.idTerm = :idTerm"),
    @NamedQuery(name = "Term.findByTermStart", query = "SELECT t FROM Term t WHERE t.termStart = :termStart"),
    @NamedQuery(name = "Term.findByTermEnd", query = "SELECT t FROM Term t WHERE t.termEnd = :termEnd"),
    @NamedQuery(name = "Term.findByTermCreatedAt", query = "SELECT t FROM Term t WHERE t.termCreatedAt = :termCreatedAt")})
public class Term implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TERM")
    private Integer idTerm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TERM_START")
    @Temporal(TemporalType.TIMESTAMP)
    private Date termStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TERM_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date termEnd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TERM_CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date termCreatedAt;
    @JoinColumn(name = "ID_TERM_TYPE", referencedColumnName = "ID_TERM_TYPE")
    @ManyToOne(optional = false)
    private TermType idTermType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTerm")
    private Collection<Inscription> inscriptionCollection;

    public Term() {
    }

    public Term(Integer idTerm) {
        this.idTerm = idTerm;
    }

    public Term(Integer idTerm, Date termStart, Date termEnd, Date termCreatedAt) {
        this.idTerm = idTerm;
        this.termStart = termStart;
        this.termEnd = termEnd;
        this.termCreatedAt = termCreatedAt;
    }

    public Integer getIdTerm() {
        return idTerm;
    }

    public void setIdTerm(Integer idTerm) {
        this.idTerm = idTerm;
    }

    public Date getTermStart() {
        return termStart;
    }

    public void setTermStart(Date termStart) {
        this.termStart = termStart;
    }

    public Date getTermEnd() {
        return termEnd;
    }

    public void setTermEnd(Date termEnd) {
        this.termEnd = termEnd;
    }

    public Date getTermCreatedAt() {
        return termCreatedAt;
    }

    public void setTermCreatedAt(Date termCreatedAt) {
        this.termCreatedAt = termCreatedAt;
    }

    public TermType getIdTermType() {
        return idTermType;
    }

    public void setIdTermType(TermType idTermType) {
        this.idTermType = idTermType;
    }

    @XmlTransient
    public Collection<Inscription> getInscriptionCollection() {
        return inscriptionCollection;
    }

    public void setInscriptionCollection(Collection<Inscription> inscriptionCollection) {
        this.inscriptionCollection = inscriptionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTerm != null ? idTerm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Term)) {
            return false;
        }
        Term other = (Term) object;
        if ((this.idTerm == null && other.idTerm != null) || (this.idTerm != null && !this.idTerm.equals(other.idTerm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Term[ idTerm=" + idTerm + " ]";
    }
    
}
