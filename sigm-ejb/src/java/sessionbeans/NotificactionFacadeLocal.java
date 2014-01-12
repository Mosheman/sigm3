/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.Notificaction;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mario
 */
@Local
public interface NotificactionFacadeLocal {

    void create(Notificaction notificaction);

    void edit(Notificaction notificaction);

    void remove(Notificaction notificaction);

    Notificaction find(Object id);

    List<Notificaction> findAll();

    List<Notificaction> findRange(int[] range);

    int count();
    
}
