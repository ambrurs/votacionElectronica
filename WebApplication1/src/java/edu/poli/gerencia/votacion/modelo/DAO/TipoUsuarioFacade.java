/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.poli.gerencia.votacion.modelo.DAO;

import edu.poli.gerencia.votacion.modelo.VO.TipoUsuario;
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
public class TipoUsuarioFacade extends AbstractFacade<TipoUsuario> implements TipoUsuarioFacadeLocal {
    @PersistenceContext(unitName = "WebApplication1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoUsuarioFacade() {
        super(TipoUsuario.class);
    }

    @Override
    public List<TipoUsuario> obtenerTipoUsuarioRegistro() {
        Query query = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT * FROM tipo_usuario  ");
            sql.append(" WHERE ID_TIPO_USUARIO NOT IN(1) ");
            query = em.createNativeQuery(sql.toString(),TipoUsuario.class);
        } catch (Exception e) {
            System.out.println("Error obteniendo los tipos  de usuario :"+e.getMessage());
        }
        return query.getResultList();
    }
    
}
