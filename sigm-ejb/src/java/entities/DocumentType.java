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
@Table(name = "DOCUMENT_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentType.findAll", query = "SELECT d FROM DocumentType d"),
    @NamedQuery(name = "DocumentType.findByIdDoctype", query = "SELECT d FROM DocumentType d WHERE d.idDoctype = :idDoctype"),
    @NamedQuery(name = "DocumentType.findByDoctypeName", query = "SELECT d FROM DocumentType d WHERE d.doctypeName = :doctypeName")})
public class DocumentType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DOCTYPE")
    private Integer idDoctype;
    @Size(max = 40)
    @Column(name = "DOCTYPE_NAME")
    private String doctypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDoctype")
    private Collection<Document> documentCollection;

    public DocumentType() {
    }

    public DocumentType(Integer idDoctype) {
        this.idDoctype = idDoctype;
    }

    public Integer getIdDoctype() {
        return idDoctype;
    }

    public void setIdDoctype(Integer idDoctype) {
        this.idDoctype = idDoctype;
    }

    public String getDoctypeName() {
        return doctypeName;
    }

    public void setDoctypeName(String doctypeName) {
        this.doctypeName = doctypeName;
    }

    @XmlTransient
    public Collection<Document> getDocumentCollection() {
        return documentCollection;
    }

    public void setDocumentCollection(Collection<Document> documentCollection) {
        this.documentCollection = documentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDoctype != null ? idDoctype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentType)) {
            return false;
        }
        DocumentType other = (DocumentType) object;
        if ((this.idDoctype == null && other.idDoctype != null) || (this.idDoctype != null && !this.idDoctype.equals(other.idDoctype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DocumentType[ idDoctype=" + idDoctype + " ]";
    }
    
}
