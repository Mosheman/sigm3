/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.DocumentType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mario
 */
@Local
public interface DocumentTypeFacadeLocal {

    void create(DocumentType documentType);

    void edit(DocumentType documentType);

    void remove(DocumentType documentType);

    DocumentType find(Object id);

    List<DocumentType> findAll();

    List<DocumentType> findRange(int[] range);

    int count();
    
}
