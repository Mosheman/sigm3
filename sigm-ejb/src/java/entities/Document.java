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
@Table(name = "DOCUMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d"),
    @NamedQuery(name = "Document.findByIdDocument", query = "SELECT d FROM Document d WHERE d.idDocument = :idDocument"),
    @NamedQuery(name = "Document.findByDocumentReceiptDate", query = "SELECT d FROM Document d WHERE d.documentReceiptDate = :documentReceiptDate")})
public class Document implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DOCUMENT")
    private Integer idDocument;
    @Lob
    @Size(max = 65535)
    @Column(name = "DOCUMENT_ADDRESS")
    private String documentAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOCUMENT_RECEIPT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date documentReceiptDate;
    @JoinColumn(name = "ID_THESIS", referencedColumnName = "ID_THESIS")
    @ManyToOne(optional = false)
    private Thesis idThesis;
    @JoinColumn(name = "ID_DOCTYPE", referencedColumnName = "ID_DOCTYPE")
    @ManyToOne(optional = false)
    private DocumentType idDoctype;
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    @ManyToOne(optional = false)
    private User idUser;

    public Document() {
    }

    public Document(Integer idDocument) {
        this.idDocument = idDocument;
    }

    public Document(Integer idDocument, Date documentReceiptDate) {
        this.idDocument = idDocument;
        this.documentReceiptDate = documentReceiptDate;
    }

    public Integer getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(Integer idDocument) {
        this.idDocument = idDocument;
    }

    public String getDocumentAddress() {
        return documentAddress;
    }

    public void setDocumentAddress(String documentAddress) {
        this.documentAddress = documentAddress;
    }

    public Date getDocumentReceiptDate() {
        return documentReceiptDate;
    }

    public void setDocumentReceiptDate(Date documentReceiptDate) {
        this.documentReceiptDate = documentReceiptDate;
    }

    public Thesis getIdThesis() {
        return idThesis;
    }

    public void setIdThesis(Thesis idThesis) {
        this.idThesis = idThesis;
    }

    public DocumentType getIdDoctype() {
        return idDoctype;
    }

    public void setIdDoctype(DocumentType idDoctype) {
        this.idDoctype = idDoctype;
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
        hash += (idDocument != null ? idDocument.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.idDocument == null && other.idDocument != null) || (this.idDocument != null && !this.idDocument.equals(other.idDocument))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Document[ idDocument=" + idDocument + " ]";
    }
    
}
