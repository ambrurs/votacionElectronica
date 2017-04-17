/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.poli.gerencia.votacion.modelo.DAO;

import edu.poli.gerencia.votacion.modelo.VO.TipoEstadoVotacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author andres.marulanda
 */
@Local
public interface TipoEstadoVotacionFacadeLocal {

    void create(TipoEstadoVotacion tipoEstadoVotacion);

    void edit(TipoEstadoVotacion tipoEstadoVotacion);

    void remove(TipoEstadoVotacion tipoEstadoVotacion);

    TipoEstadoVotacion find(Object id);

    List<TipoEstadoVotacion> findAll();

    List<TipoEstadoVotacion> findRange(int[] range);

    int count();
    
}
