/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.poli.gerencia.votacion.modelo.DAO;

import edu.poli.gerencia.votacion.modelo.VO.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author andres.marulanda
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> implements PersonaFacadeLocal {
    @PersistenceContext(unitName = "WebApplication1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }

    @Override
    public Persona buscarPersonaPorNit(String nit) {
        Query query = null;
        Persona persona = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT *  FROM persona ");
            sql.append(" WHERE NUMERO_DOCUMENTO = ? AND ID_TIPO_DOCUMENTO = 2 ");
            query = em.createNativeQuery(sql.toString(), Persona.class);
            query.setParameter(1, nit);
        } catch (Exception e) {
            System.out.println("Error buscando a la persona :"+e.getMessage());
        }
        List<Persona> listResult = query.getResultList();
        if( listResult.size() > 0){
            persona = listResult.get(0);
        }
        return persona;
    }
    
}
