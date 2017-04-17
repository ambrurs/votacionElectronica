/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.poli.gerencia.votacion.modelo.DAO;

import edu.poli.gerencia.votacion.modelo.VO.TipoDocumento;
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
public class TipoDocumentoFacade extends AbstractFacade<TipoDocumento> implements TipoDocumentoFacadeLocal {
    @PersistenceContext(unitName = "WebApplication1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoDocumentoFacade() {
        super(TipoDocumento.class);
    }

    @Override
    public List<TipoDocumento> obtenerDocumentoEmpresa() {
        Query query = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT * FROM tipo_documento WHERE ID_TIPO_DOCUMENTO NOT IN(2) ");
            query = em.createNativeQuery(sql.toString(),TipoDocumento.class);
        } catch (Exception e) {
            System.out.println("Error consultando los tipos de documentos");
        }
        return query.getResultList();
    }

    @Override
    public List<TipoDocumento> obtenerDocumentoEmpleado() {
        Query query = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT * FROM tipo_documento WHERE ID_TIPO_DOCUMENTO  IN(2) ");
            query = em.createNativeQuery(sql.toString(),TipoDocumento.class);
        } catch (Exception e) {
            System.out.println("Error consultando los tipos de documentos");
        }
        return query.getResultList();
    }
    
}
