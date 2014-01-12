/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.ThesisParticipation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mario
 */
@Local
public interface ThesisParticipationFacadeLocal {

    void create(ThesisParticipation thesisParticipation);

    void edit(ThesisParticipation thesisParticipation);

    void remove(ThesisParticipation thesisParticipation);

    ThesisParticipation find(Object id);

    List<ThesisParticipation> findAll();

    List<ThesisParticipation> findRange(int[] range);

    int count();
    
}
