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
@Table(name = "ANSWER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Answer.findAll", query = "SELECT a FROM Answer a"),
    @NamedQuery(name = "Answer.findByIdAnswer", query = "SELECT a FROM Answer a WHERE a.idAnswer = :idAnswer"),
    @NamedQuery(name = "Answer.findByAnswerName", query = "SELECT a FROM Answer a WHERE a.answerName = :answerName"),
    @NamedQuery(name = "Answer.findByAnswerCreatedAt", query = "SELECT a FROM Answer a WHERE a.answerCreatedAt = :answerCreatedAt"),
    @NamedQuery(name = "Answer.findByAnwerUpdatedAt", query = "SELECT a FROM Answer a WHERE a.anwerUpdatedAt = :anwerUpdatedAt")})
public class Answer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ANSWER")
    private Integer idAnswer;
    @Size(max = 40)
    @Column(name = "ANSWER_NAME")
    private String answerName;
    @Lob
    @Size(max = 65535)
    @Column(name = "ANSWER_DETAIL")
    private String answerDetail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANSWER_CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date answerCreatedAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANWER_UPDATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date anwerUpdatedAt;
    @Lob
    @Column(name = "ANSWER_VISIBILITY")
    private byte[] answerVisibility;
    @JoinColumn(name = "ID_QUESTION", referencedColumnName = "ID_QUESTION")
    @ManyToOne
    private Question idQuestion;
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    @ManyToOne(optional = false)
    private User idUser;

    public Answer() {
    }

    public Answer(Integer idAnswer) {
        this.idAnswer = idAnswer;
    }

    public Answer(Integer idAnswer, Date answerCreatedAt, Date anwerUpdatedAt) {
        this.idAnswer = idAnswer;
        this.answerCreatedAt = answerCreatedAt;
        this.anwerUpdatedAt = anwerUpdatedAt;
    }

    public Integer getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(Integer idAnswer) {
        this.idAnswer = idAnswer;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName;
    }

    public String getAnswerDetail() {
        return answerDetail;
    }

    public void setAnswerDetail(String answerDetail) {
        this.answerDetail = answerDetail;
    }

    public Date getAnswerCreatedAt() {
        return answerCreatedAt;
    }

    public void setAnswerCreatedAt(Date answerCreatedAt) {
        this.answerCreatedAt = answerCreatedAt;
    }

    public Date getAnwerUpdatedAt() {
        return anwerUpdatedAt;
    }

    public void setAnwerUpdatedAt(Date anwerUpdatedAt) {
        this.anwerUpdatedAt = anwerUpdatedAt;
    }

    public byte[] getAnswerVisibility() {
        return answerVisibility;
    }

    public void setAnswerVisibility(byte[] answerVisibility) {
        this.answerVisibility = answerVisibility;
    }

    public Question getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Question idQuestion) {
        this.idQuestion = idQuestion;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnswer != null ? idAnswer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Answer)) {
            return false;
        }
        Answer other = (Answer) object;
        if ((this.idAnswer == null && other.idAnswer != null) || (this.idAnswer != null && !this.idAnswer.equals(other.idAnswer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Answer[ idAnswer=" + idAnswer + " ]";
    }
    
}
