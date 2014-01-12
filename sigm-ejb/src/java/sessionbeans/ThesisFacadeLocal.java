/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.Thesis;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mario
 */
@Local
public interface ThesisFacadeLocal {

    void create(Thesis thesis);

    void edit(Thesis thesis);

    void remove(Thesis thesis);

    Thesis find(Object id);

    List<Thesis> findAll();

    List<Thesis> findRange(int[] range);

    int count();
    
}
