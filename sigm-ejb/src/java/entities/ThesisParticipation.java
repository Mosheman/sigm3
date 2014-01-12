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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mario
 */
@Entity
@Table(name = "THESIS_PARTICIPATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThesisParticipation.findAll", query = "SELECT t FROM ThesisParticipation t"),
    @NamedQuery(name = "ThesisParticipation.findByIdThesisParticipation", query = "SELECT t FROM ThesisParticipation t WHERE t.idThesisParticipation = :idThesisParticipation"),
    @NamedQuery(name = "ThesisParticipation.findByThesisParticipationName", query = "SELECT t FROM ThesisParticipation t WHERE t.thesisParticipationName = :thesisParticipationName"),
    @NamedQuery(name = "ThesisParticipation.findByThesisParticipationStart", query = "SELECT t FROM ThesisParticipation t WHERE t.thesisParticipationStart = :thesisParticipationStart"),
    @NamedQuery(name = "ThesisParticipation.findByThesisParticipationEnd", query = "SELECT t FROM ThesisParticipation t WHERE t.thesisParticipationEnd = :thesisParticipationEnd")})
public class ThesisParticipation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_THESIS_PARTICIPATION")
    private Integer idThesisParticipation;
    @Size(max = 20)
    @Column(name = "THESIS_PARTICIPATION_NAME")
    private String thesisParticipationName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "THESIS_PARTICIPATION_START")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thesisParticipationStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "THESIS_PARTICIPATION_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thesisParticipationEnd;
    @JoinColumn(name = "ID_THESIS", referencedColumnName = "ID_THESIS")
    @ManyToOne(optional = false)
    private Thesis idThesis;
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    @ManyToOne(optional = false)
    private User idUser;
    @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID_ROLE")
    @ManyToOne(optional = false)
    private Role idRole;

    public ThesisParticipation() {
    }

    public ThesisParticipation(Integer idThesisParticipation) {
        this.idThesisParticipation = idThesisParticipation;
    }

    public ThesisParticipation(Integer idThesisParticipation, Date thesisParticipationStart, Date thesisParticipationEnd) {
        this.idThesisParticipation = idThesisParticipation;
        this.thesisParticipationStart = thesisParticipationStart;
        this.thesisParticipationEnd = thesisParticipationEnd;
    }

    public Integer getIdThesisParticipation() {
        return idThesisParticipation;
    }

    public void setIdThesisParticipation(Integer idThesisParticipation) {
        this.idThesisParticipation = idThesisParticipation;
    }

    public String getThesisParticipationName() {
        return thesisParticipationName;
    }

    public void setThesisParticipationName(String thesisParticipationName) {
        this.thesisParticipationName = thesisParticipationName;
    }

    public Date getThesisParticipationStart() {
        return thesisParticipationStart;
    }

    public void setThesisParticipationStart(Date thesisParticipationStart) {
        this.thesisParticipationStart = thesisParticipationStart;
    }

    public Date getThesisParticipationEnd() {
        return thesisParticipationEnd;
    }

    public void setThesisParticipationEnd(Date thesisParticipationEnd) {
        this.thesisParticipationEnd = thesisParticipationEnd;
    }

    public Thesis getIdThesis() {
        return idThesis;
    }

    public void setIdThesis(Thesis idThesis) {
        this.idThesis = idThesis;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Role getIdRole() {
        return idRole;
    }

    public void setIdRole(Role idRole) {
        this.idRole = idRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idThesisParticipation != null ? idThesisParticipation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThesisParticipation)) {
            return false;
        }
        ThesisParticipation other = (ThesisParticipation) object;
        if ((this.idThesisParticipation == null && other.idThesisParticipation != null) || (this.idThesisParticipation != null && !this.idThesisParticipation.equals(other.idThesisParticipation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ThesisParticipation[ idThesisParticipation=" + idThesisParticipation + " ]";
    }
    
}
