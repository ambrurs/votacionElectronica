/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.poli.gerencia.votacion.modelo.DAO;

import edu.poli.gerencia.votacion.modelo.VO.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author andres.marulanda
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {
    @PersistenceContext(unitName = "WebApplication1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public Usuario validarUsuarioRegistrado(String usuario) {
        Query query = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM votar.usuario ");
            sql.append(" WHERE NOMBRE_USUARIO =  ? ");
            query = em.createNativeQuery(sql.toString(),Usuario.class);
            query.setParameter(1, usuario);
        } catch (Exception e) {
            System.out.println("Error al consultar el usuario");
        }
        
        return (Usuario) query.getSingleResult();
    }
    
    
    
    
}
