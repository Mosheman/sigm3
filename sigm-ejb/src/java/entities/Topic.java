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
@Table(name = "TOPIC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Topic.findAll", query = "SELECT t FROM Topic t"),
    @NamedQuery(name = "Topic.findByIdTopic", query = "SELECT t FROM Topic t WHERE t.idTopic = :idTopic"),
    @NamedQuery(name = "Topic.findByTopicName", query = "SELECT t FROM Topic t WHERE t.topicName = :topicName"),
    @NamedQuery(name = "Topic.findByTopicCreation2", query = "SELECT t FROM Topic t WHERE t.topicCreation2 = :topicCreation2"),
    @NamedQuery(name = "Topic.findByTopicCreation", query = "SELECT t FROM Topic t WHERE t.topicCreation = :topicCreation")})
public class Topic implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TOPIC")
    private Integer idTopic;
    @Size(max = 40)
    @Column(name = "TOPIC_NAME")
    private String topicName;
    @Lob
    @Size(max = 65535)
    @Column(name = "TOPIC_DETAIL")
    private String topicDetail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOPIC_CREATION_2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date topicCreation2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOPIC_CREATION_")
    @Temporal(TemporalType.TIMESTAMP)
    private Date topicCreation;
    @Lob
    @Column(name = "TOPIC_VISIBILITY")
    private byte[] topicVisibility;
    @OneToMany(mappedBy = "idTopic")
    private Collection<Question> questionCollection;
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    @ManyToOne(optional = false)
    private User idUser;

    public Topic() {
    }

    public Topic(Integer idTopic) {
        this.idTopic = idTopic;
    }

    public Topic(Integer idTopic, Date topicCreation2, Date topicCreation) {
        this.idTopic = idTopic;
        this.topicCreation2 = topicCreation2;
        this.topicCreation = topicCreation;
    }

    public Integer getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(Integer idTopic) {
        this.idTopic = idTopic;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicDetail() {
        return topicDetail;
    }

    public void setTopicDetail(String topicDetail) {
        this.topicDetail = topicDetail;
    }

    public Date getTopicCreation2() {
        return topicCreation2;
    }

    public void setTopicCreation2(Date topicCreation2) {
        this.topicCreation2 = topicCreation2;
    }

    public Date getTopicCreation() {
        return topicCreation;
    }

    public void setTopicCreation(Date topicCreation) {
        this.topicCreation = topicCreation;
    }

    public byte[] getTopicVisibility() {
        return topicVisibility;
    }

    public void setTopicVisibility(byte[] topicVisibility) {
        this.topicVisibility = topicVisibility;
    }

    @XmlTransient
    public Collection<Question> getQuestionCollection() {
        return questionCollection;
    }

    public void setQuestionCollection(Collection<Question> questionCollection) {
        this.questionCollection = questionCollection;
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
        hash += (idTopic != null ? idTopic.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Topic)) {
            return false;
        }
        Topic other = (Topic) object;
        if ((this.idTopic == null && other.idTopic != null) || (this.idTopic != null && !this.idTopic.equals(other.idTopic))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Topic[ idTopic=" + idTopic + " ]";
    }
    
}
