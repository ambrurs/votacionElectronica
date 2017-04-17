/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.poli.gerencia.votacion.modelo.DAO;

import edu.poli.gerencia.votacion.modelo.VO.Votacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author andres.marulanda
 */
@Local
public interface VotacionFacadeLocal {

    void create(Votacion votacion);

    void edit(Votacion votacion);

    void remove(Votacion votacion);

    Votacion find(Object id);

    List<Votacion> findAll();

    List<Votacion> findRange(int[] range);

    int count();
    
}
