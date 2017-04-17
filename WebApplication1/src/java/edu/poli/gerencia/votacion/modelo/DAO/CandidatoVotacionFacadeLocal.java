/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.poli.gerencia.votacion.modelo.DAO;

import edu.poli.gerencia.votacion.modelo.VO.CandidatoVotacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author andres.marulanda
 */
@Local
public interface CandidatoVotacionFacadeLocal {

    void create(CandidatoVotacion candidatoVotacion);

    void edit(CandidatoVotacion candidatoVotacion);

    void remove(CandidatoVotacion candidatoVotacion);

    CandidatoVotacion find(Object id);

    List<CandidatoVotacion> findAll();

    List<CandidatoVotacion> findRange(int[] range);

    int count();
    
}
