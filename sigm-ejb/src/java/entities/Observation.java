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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mario
 */
@Entity
@Table(name = "OBSERVATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Observation.findAll", query = "SELECT o FROM Observation o"),
    @NamedQuery(name = "Observation.findByIdObservation", query = "SELECT o FROM Observation o WHERE o.idObservation = :idObservation"),
    @NamedQuery(name = "Observation.findByObservationName", query = "SELECT o FROM Observation o WHERE o.observationName = :observationName"),
    @NamedQuery(name = "Observation.findByObservationCreatedAt", query = "SELECT o FROM Observation o WHERE o.observationCreatedAt = :observationCreatedAt"),
    @NamedQuery(name = "Observation.findByObservationUpdatedAt", query = "SELECT o FROM Observation o WHERE o.observationUpdatedAt = :observationUpdatedAt")})
public class Observation implements Serializable {
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    @ManyToOne(optional = false)
    private User idUser;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_OBSERVATION")
    private Integer idObservation;
    @Size(max = 40)
    @Column(name = "OBSERVATION_NAME")
    private String observationName;
    @Lob
    @Size(max = 65535)
    @Column(name = "OBSERVATION_DETAIL")
    private String observationDetail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OBSERVATION_CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date observationCreatedAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OBSERVATION_UPDATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date observationUpdatedAt;
    @JoinColumn(name = "ID_THESIS", referencedColumnName = "ID_THESIS")
    @ManyToOne(optional = false)
    private Thesis idThesis;

    public Observation() {
    }

    public Observation(Integer idObservation) {
        this.idObservation = idObservation;
    }

    public Observation(Integer idObservation, Date observationCreatedAt, Date observationUpdatedAt) {
        this.idObservation = idObservation;
        this.observationCreatedAt = observationCreatedAt;
        this.observationUpdatedAt = observationUpdatedAt;
    }

    public Integer getIdObservation() {
        return idObservation;
    }

    public void setIdObservation(Integer idObservation) {
        this.idObservation = idObservation;
    }

    public String getObservationName() {
        return observationName;
    }

    public void setObservationName(String observationName) {
        this.observationName = observationName;
    }

    public String getObservationDetail() {
        return observationDetail;
    }

    public void setObservationDetail(String observationDetail) {
        this.observationDetail = observationDetail;
    }

    public Date getObservationCreatedAt() {
        return observationCreatedAt;
    }

    public void setObservationCreatedAt(Date observationCreatedAt) {
        this.observationCreatedAt = observationCreatedAt;
    }

    public Date getObservationUpdatedAt() {
        return observationUpdatedAt;
    }

    public void setObservationUpdatedAt(Date observationUpdatedAt) {
        this.observationUpdatedAt = observationUpdatedAt;
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
        hash += (idObservation != null ? idObservation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Observation)) {
            return false;
        }
        Observation other = (Observation) object;
        if ((this.idObservation == null && other.idObservation != null) || (this.idObservation != null && !this.idObservation.equals(other.idObservation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Observation[ idObservation=" + idObservation + " ]";
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }
    
}
