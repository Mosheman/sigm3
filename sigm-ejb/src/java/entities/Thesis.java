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
@Table(name = "THESIS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Thesis.findAll", query = "SELECT t FROM Thesis t"),
    @NamedQuery(name = "Thesis.findByIdThesis", query = "SELECT t FROM Thesis t WHERE t.idThesis = :idThesis"),
    @NamedQuery(name = "Thesis.findByThesisTitle", query = "SELECT t FROM Thesis t WHERE t.thesisTitle = :thesisTitle"),
    @NamedQuery(name = "Thesis.findByThesisSubject", query = "SELECT t FROM Thesis t WHERE t.thesisSubject = :thesisSubject"),
    @NamedQuery(name = "Thesis.findByThesisStatus", query = "SELECT t FROM Thesis t WHERE t.thesisStatus = :thesisStatus")})
public class Thesis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_THESIS")
    private Integer idThesis;
    @Size(max = 40)
    @Column(name = "THESIS_TITLE")
    private String thesisTitle;
    @Size(max = 40)
    @Column(name = "THESIS_SUBJECT")
    private String thesisSubject;
    @Column(name = "THESIS_STATUS")
    private Short thesisStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idThesis")
    private Collection<Inscription> inscriptionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idThesis")
    private Collection<Document> documentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idThesis")
    private Collection<Observation> observationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idThesis")
    private Collection<ThesisParticipation> thesisParticipationCollection;

    public Thesis() {
    }

    public Thesis(Integer idThesis) {
        this.idThesis = idThesis;
    }

    public Integer getIdThesis() {
        return idThesis;
    }

    public void setIdThesis(Integer idThesis) {
        this.idThesis = idThesis;
    }

    public String getThesisTitle() {
        return thesisTitle;
    }

    public void setThesisTitle(String thesisTitle) {
        this.thesisTitle = thesisTitle;
    }

    public String getThesisSubject() {
        return thesisSubject;
    }

    public void setThesisSubject(String thesisSubject) {
        this.thesisSubject = thesisSubject;
    }

    public Short getThesisStatus() {
        return thesisStatus;
    }

    public void setThesisStatus(Short thesisStatus) {
        this.thesisStatus = thesisStatus;
    }

    @XmlTransient
    public Collection<Inscription> getInscriptionCollection() {
        return inscriptionCollection;
    }

    public void setInscriptionCollection(Collection<Inscription> inscriptionCollection) {
        this.inscriptionCollection = inscriptionCollection;
    }

    @XmlTransient
    public Collection<Document> getDocumentCollection() {
        return documentCollection;
    }

    public void setDocumentCollection(Collection<Document> documentCollection) {
        this.documentCollection = documentCollection;
    }

    @XmlTransient
    public Collection<Observation> getObservationCollection() {
        return observationCollection;
    }

    public void setObservationCollection(Collection<Observation> observationCollection) {
        this.observationCollection = observationCollection;
    }

    @XmlTransient
    public Collection<ThesisParticipation> getThesisParticipationCollection() {
        return thesisParticipationCollection;
    }

    public void setThesisParticipationCollection(Collection<ThesisParticipation> thesisParticipationCollection) {
        this.thesisParticipationCollection = thesisParticipationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idThesis != null ? idThesis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thesis)) {
            return false;
        }
        Thesis other = (Thesis) object;
        if ((this.idThesis == null && other.idThesis != null) || (this.idThesis != null && !this.idThesis.equals(other.idThesis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Thesis[ idThesis=" + idThesis + " ]";
    }
    
}
