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
@Table(name = "NOTIFICACTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notificaction.findAll", query = "SELECT n FROM Notificaction n"),
    @NamedQuery(name = "Notificaction.findByIdNotification", query = "SELECT n FROM Notificaction n WHERE n.idNotification = :idNotification"),
    @NamedQuery(name = "Notificaction.findByNotificationTitle", query = "SELECT n FROM Notificaction n WHERE n.notificationTitle = :notificationTitle"),
    @NamedQuery(name = "Notificaction.findByNotificationCreatedAt", query = "SELECT n FROM Notificaction n WHERE n.notificationCreatedAt = :notificationCreatedAt"),
    @NamedQuery(name = "Notificaction.findByNotificationUpdatedAt", query = "SELECT n FROM Notificaction n WHERE n.notificationUpdatedAt = :notificationUpdatedAt")})
public class Notificaction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_NOTIFICATION")
    private Integer idNotification;
    @Size(max = 40)
    @Column(name = "NOTIFICATION_TITLE")
    private String notificationTitle;
    @Lob
    @Size(max = 65535)
    @Column(name = "NOTIFICATION_DETAIL")
    private String notificationDetail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOTIFICATION_CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date notificationCreatedAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOTIFICATION_UPDATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date notificationUpdatedAt;
    @JoinColumn(name = "ID_MESSAGE", referencedColumnName = "ID_MESSAGE")
    @ManyToOne(optional = false)
    private Message idMessage;
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    @ManyToOne(optional = false)
    private User idUser;

    public Notificaction() {
    }

    public Notificaction(Integer idNotification) {
        this.idNotification = idNotification;
    }

    public Notificaction(Integer idNotification, Date notificationCreatedAt, Date notificationUpdatedAt) {
        this.idNotification = idNotification;
        this.notificationCreatedAt = notificationCreatedAt;
        this.notificationUpdatedAt = notificationUpdatedAt;
    }

    public Integer getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(Integer idNotification) {
        this.idNotification = idNotification;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getNotificationDetail() {
        return notificationDetail;
    }

    public void setNotificationDetail(String notificationDetail) {
        this.notificationDetail = notificationDetail;
    }

    public Date getNotificationCreatedAt() {
        return notificationCreatedAt;
    }

    public void setNotificationCreatedAt(Date notificationCreatedAt) {
        this.notificationCreatedAt = notificationCreatedAt;
    }

    public Date getNotificationUpdatedAt() {
        return notificationUpdatedAt;
    }

    public void setNotificationUpdatedAt(Date notificationUpdatedAt) {
        this.notificationUpdatedAt = notificationUpdatedAt;
    }

    public Message getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Message idMessage) {
        this.idMessage = idMessage;
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
        hash += (idNotification != null ? idNotification.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notificaction)) {
            return false;
        }
        Notificaction other = (Notificaction) object;
        if ((this.idNotification == null && other.idNotification != null) || (this.idNotification != null && !this.idNotification.equals(other.idNotification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Notificaction[ idNotification=" + idNotification + " ]";
    }
    
}
