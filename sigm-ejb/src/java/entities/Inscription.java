/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author mario
 */
@Entity
@Table(name = "INSCRIPTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscription.findAll", query = "SELECT i FROM Inscription i"),
    @NamedQuery(name = "Inscription.findByIdInscription", query = "SELECT i FROM Inscription i WHERE i.idInscription = :idInscription"),
    @NamedQuery(name = "Inscription.findByProposalDate", query = "SELECT i FROM Inscription i WHERE i.proposalDate = :proposalDate"),
    @NamedQuery(name = "Inscription.findByThesisIncriptionDate", query = "SELECT i FROM Inscription i WHERE i.thesisIncriptionDate = :thesisIncriptionDate")})
public class Inscription implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_INSCRIPTION")
    private Integer idInscription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROPOSAL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date proposalDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "THESIS_INCRIPTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thesisIncriptionDate;
    @JoinColumn(name = "ID_TERM", referencedColumnName = "ID_TERM")
    @ManyToOne(optional = false)
    private Term idTerm;
    @JoinColumn(name = "ID_THESIS", referencedColumnName = "ID_THESIS")
    @ManyToOne(optional = false)
    private Thesis idThesis;

    public Inscription() {
    }

    public Inscription(Integer idInscription) {
        this.idInscription = idInscription;
    }

    public Inscription(Integer idInscription, Date proposalDate, Date thesisIncriptionDate) {
        this.idInscription = idInscription;
        this.proposalDate = proposalDate;
        this.thesisIncriptionDate = thesisIncriptionDate;
    }

    public Integer getIdInscription() {
        return idInscription;
    }

    public void setIdInscription(Integer idInscription) {
        this.idInscription = idInscription;
    }

    public Date getProposalDate() {
        return proposalDate;
    }

    public void setProposalDate(Date proposalDate) {
        this.proposalDate = proposalDate;
    }

    public Date getThesisIncriptionDate() {
        return thesisIncriptionDate;
    }

    public void setThesisIncriptionDate(Date thesisIncriptionDate) {
        this.thesisIncriptionDate = thesisIncriptionDate;
    }

    public Term getIdTerm() {
        return idTerm;
    }

    public void setIdTerm(Term idTerm) {
        this.idTerm = idTerm;
    }

    public Thesis getIdThesis() {
        return idThesis;
    }

    public void setIdThesis(Thesis idThesis) {
        this.idThesis = idThesis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInscription != null ? idInscription.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscription)) {
            return false;
        }
        Inscription other = (Inscription) object;
        if ((this.idInscription == null && other.idInscription != null) || (this.idInscription != null && !this.idInscription.equals(other.idInscription))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Inscription[ idInscription=" + idInscription + " ]";
    }
    
}
