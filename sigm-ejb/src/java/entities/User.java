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
@Table(name = "USER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByIdUser", query = "SELECT u FROM User u WHERE u.idUser = :idUser"),
    @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.userName = :userName"),
    @NamedQuery(name = "User.findByUserPass", query = "SELECT u FROM User u WHERE u.userPass = :userPass"),
    @NamedQuery(name = "User.findByUserEmail", query = "SELECT u FROM User u WHERE u.userEmail = :userEmail"),
    @NamedQuery(name = "User.findByUserStatus", query = "SELECT u FROM User u WHERE u.userStatus = :userStatus"),
    @NamedQuery(name = "User.findByUserCreatedAt", query = "SELECT u FROM User u WHERE u.userCreatedAt = :userCreatedAt"),
    @NamedQuery(name = "User.findByUserUpdatedAt", query = "SELECT u FROM User u WHERE u.userUpdatedAt = :userUpdatedAt"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "User.findByRut", query = "SELECT u FROM User u WHERE u.rut = :rut"),
    @NamedQuery(name = "User.findByAddress", query = "SELECT u FROM User u WHERE u.address = :address"),
    @NamedQuery(name = "User.findByBirthday", query = "SELECT u FROM User u WHERE u.birthday = :birthday"),
    @NamedQuery(name = "User.findByPhone", query = "SELECT u FROM User u WHERE u.phone = :phone"),
    @NamedQuery(name = "User.findByDepartament", query = "SELECT u FROM User u WHERE u.departament = :departament"),
    @NamedQuery(name = "User.findByEnrollmentType", query = "SELECT u FROM User u WHERE u.enrollmentType = :enrollmentType"),
    @NamedQuery(name = "User.findByLastEnrollment", query = "SELECT u FROM User u WHERE u.lastEnrollment = :lastEnrollment")})
public class User implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Collection<Observation> observationCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USER")
    private Integer idUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "USER_NAME")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "USER_PASS")
    private String userPass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "USER_EMAIL")
    private String userEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_STATUS")
    private short userStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userCreatedAt;
    @Basic(optional = true)
    @NotNull
    @Column(name = "USER_UPDATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date userUpdatedAt;
    @Basic(optional = true)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Size(max = 10)
    @Column(name = "RUT")
    private String rut;
    @Size(max = 80)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BIRTHDAY")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 15)
    @Column(name = "PHONE")
    private String phone;
    @Size(max = 60)
    @Column(name = "DEPARTAMENT")
    private String departament;
    @Lob
    @Size(max = 65535)
    @Column(name = "INTERESTS")
    private String interests;
    @Lob
    @Size(max = 65535)
    @Column(name = "COMMENTS")
    private String comments;
    @Size(max = 40)
    @Column(name = "ENROLLMENT_TYPE")
    private String enrollmentType;
    @Column(name = "LAST_ENROLLMENT")
    @Temporal(TemporalType.DATE)
    private Date lastEnrollment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Collection<Question> questionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Collection<Document> documentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Collection<Topic> topicCollection;
    @JoinColumn(name = "ID_USER_TYPE", referencedColumnName = "ID_USER_TYPE")
    @ManyToOne(optional = false)
    private UserType idUserType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Collection<Answer> answerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Collection<Notificaction> notificactionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Collection<ThesisParticipation> thesisParticipationCollection;

    public User() {
        
        java.util.Date date = new java.util.Date();
        this.userCreatedAt = (Date) date.clone();
        this.userUpdatedAt = (Date) date.clone();
    }

    public User(Integer idUser) {
        this.idUser = idUser;
                        
        java.util.Date date = new java.util.Date();
        this.userCreatedAt = (Date) date.clone();
        this.userUpdatedAt = (Date) date.clone();
    }

    public User(Integer idUser, String userName, String userPass, String userEmail, short userStatus, Date userCreatedAt, Date userUpdatedAt, String firstName, String lastName, Date birthday) {
        
        
        java.util.Date date = new java.util.Date();
        
        this.idUser = idUser;
        this.userName = userName;
        this.userPass = userPass;
        this.userEmail = userEmail;
        this.userStatus = userStatus;
        this.userCreatedAt = (Date) date.clone();
        this.userUpdatedAt = (Date) date.clone();
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public short getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(short userStatus) {
        this.userStatus = userStatus;
    }

    public Date getUserCreatedAt() {
        return userCreatedAt;
    }

    public void setUserCreatedAt(Date userCreatedAt) {
        java.util.Date date = new java.util.Date();
        this.userCreatedAt = (Date) date.clone();
    }

    public Date getUserUpdatedAt() {
        return userUpdatedAt;
    }

    public void setUserUpdatedAt(Date userUpdatedAt) {
        java.util.Date date = new java.util.Date();
        this.userUpdatedAt = (Date) date.clone();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getEnrollmentType() {
        return enrollmentType;
    }

    public void setEnrollmentType(String enrollmentType) {
        this.enrollmentType = enrollmentType;
    }

    public Date getLastEnrollment() {
        return lastEnrollment;
    }

    public void setLastEnrollment(Date lastEnrollment) {
        this.lastEnrollment = lastEnrollment;
    }

    @XmlTransient
    public Collection<Question> getQuestionCollection() {
        return questionCollection;
    }

    public void setQuestionCollection(Collection<Question> questionCollection) {
        this.questionCollection = questionCollection;
    }

    @XmlTransient
    public Collection<Document> getDocumentCollection() {
        return documentCollection;
    }

    public void setDocumentCollection(Collection<Document> documentCollection) {
        this.documentCollection = documentCollection;
    }

    @XmlTransient
    public Collection<Topic> getTopicCollection() {
        return topicCollection;
    }

    public void setTopicCollection(Collection<Topic> topicCollection) {
        this.topicCollection = topicCollection;
    }

    public UserType getIdUserType() {
        return idUserType;
    }

    public void setIdUserType(UserType idUserType) {
        this.idUserType = idUserType;
    }

    @XmlTransient
    public Collection<Answer> getAnswerCollection() {
        return answerCollection;
    }

    public void setAnswerCollection(Collection<Answer> answerCollection) {
        this.answerCollection = answerCollection;
    }

    @XmlTransient
    public Collection<Notificaction> getNotificactionCollection() {
        return notificactionCollection;
    }

    public void setNotificactionCollection(Collection<Notificaction> notificactionCollection) {
        this.notificactionCollection = notificactionCollection;
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
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.User[ idUser=" + idUser + " ]";
    }

    @XmlTransient
    public Collection<Observation> getObservationCollection() {
        return observationCollection;
    }

    public void setObservationCollection(Collection<Observation> observationCollection) {
        this.observationCollection = observationCollection;
    }
    
}
