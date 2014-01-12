/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.TermType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mario
 */
@Local
public interface TermTypeFacadeLocal {

    void create(TermType termType);

    void edit(TermType termType);

    void remove(TermType termType);

    TermType find(Object id);

    List<TermType> findAll();

    List<TermType> findRange(int[] range);

    int count();
    
}
