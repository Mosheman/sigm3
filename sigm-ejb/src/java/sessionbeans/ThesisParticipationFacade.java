/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import entities.ThesisParticipation;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mario
 */
@Stateless
public class ThesisParticipationFacade extends AbstractFacade<ThesisParticipation> implements ThesisParticipationFacadeLocal {
    @PersistenceContext(unitName = "sigm-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ThesisParticipationFacade() {
        super(ThesisParticipation.class);
    }
    
}
