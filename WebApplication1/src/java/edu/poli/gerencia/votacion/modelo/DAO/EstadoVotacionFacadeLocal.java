/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.poli.gerencia.votacion.modelo.DAO;

import edu.poli.gerencia.votacion.modelo.VO.EstadoVotacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author andres.marulanda
 */
@Local
public interface EstadoVotacionFacadeLocal {

    void create(EstadoVotacion estadoVotacion);

    void edit(EstadoVotacion estadoVotacion);

    void remove(EstadoVotacion estadoVotacion);

    EstadoVotacion find(Object id);

    List<EstadoVotacion> findAll();

    List<EstadoVotacion> findRange(int[] range);

    int count();
    
}
