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
 * @author mario
 */
@Entity
@Table(name = "QUESTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
    @NamedQuery(name = "Question.findByIdQuestion", query = "SELECT q FROM Question q WHERE q.idQuestion = :idQuestion"),
    @NamedQuery(name = "Question.findByQuestionName", query = "SELECT q FROM Question q WHERE q.questionName = :questionName"),
    @NamedQuery(name = "Question.findByQuestionCreatedAt", query = "SELECT q FROM Question q WHERE q.questionCreatedAt = :questionCreatedAt"),
    @NamedQuery(name = "Question.findByQuestionUpdatedAt", query = "SELECT q FROM Question q WHERE q.questionUpdatedAt = :questionUpdatedAt")})
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_QUESTION")
    private Integer idQuestion;
    @Size(max = 40)
    @Column(name = "QUESTION_NAME")
    private String questionName;
    @Lob
    @Size(max = 65535)
    @Column(name = "QUESTION_DETAIL")
    private String questionDetail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUESTION_CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date questionCreatedAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUESTION_UPDATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date questionUpdatedAt;
    @Lob
    @Column(name = "QUESTION_VISIBILITY")
    private byte[] questionVisibility;
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    @ManyToOne(optional = false)
    private User idUser;
    @JoinColumn(name = "ID_TOPIC", referencedColumnName = "ID_TOPIC")
    @ManyToOne
    private Topic idTopic;
    @OneToMany(mappedBy = "idQuestion")
    private Collection<Answer> answerCollection;

    public Question() {
    }

    public Question(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Question(Integer idQuestion, Date questionCreatedAt, Date questionUpdatedAt) {
        this.idQuestion = idQuestion;
        this.questionCreatedAt = questionCreatedAt;
        this.questionUpdatedAt = questionUpdatedAt;
    }

    public Integer getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionDetail() {
        return questionDetail;
    }

    public void setQuestionDetail(String questionDetail) {
        this.questionDetail = questionDetail;
    }

    public Date getQuestionCreatedAt() {
        return questionCreatedAt;
    }

    public void setQuestionCreatedAt(Date questionCreatedAt) {
        this.questionCreatedAt = questionCreatedAt;
    }

    public Date getQuestionUpdatedAt() {
        return questionUpdatedAt;
    }

    public void setQuestionUpdatedAt(Date questionUpdatedAt) {
        this.questionUpdatedAt = questionUpdatedAt;
    }

    public byte[] getQuestionVisibility() {
        return questionVisibility;
    }

    public void setQuestionVisibility(byte[] questionVisibility) {
        this.questionVisibility = questionVisibility;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Topic getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(Topic idTopic) {
        this.idTopic = idTopic;
    }

    @XmlTransient
    public Collection<Answer> getAnswerCollection() {
        return answerCollection;
    }

    public void setAnswerCollection(Collection<Answer> answerCollection) {
        this.answerCollection = answerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuestion != null ? idQuestion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.idQuestion == null && other.idQuestion != null) || (this.idQuestion != null && !this.idQuestion.equals(other.idQuestion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Question[ idQuestion=" + idQuestion + " ]";
    }
    
}
