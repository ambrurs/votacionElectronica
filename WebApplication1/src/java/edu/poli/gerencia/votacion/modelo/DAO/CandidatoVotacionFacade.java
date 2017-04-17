/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.poli.gerencia.votacion.modelo.DAO;

import edu.poli.gerencia.votacion.modelo.VO.CandidatoVotacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author andres.marulanda
 */
@Stateless
public class CandidatoVotacionFacade extends AbstractFacade<CandidatoVotacion> implements CandidatoVotacionFacadeLocal {
    @PersistenceContext(unitName = "WebApplication1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CandidatoVotacionFacade() {
        super(CandidatoVotacion.class);
    }
    
}
