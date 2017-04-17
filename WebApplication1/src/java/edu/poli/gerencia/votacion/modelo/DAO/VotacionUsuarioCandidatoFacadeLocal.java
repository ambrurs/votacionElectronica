/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.poli.gerencia.votacion.modelo.DAO;

import edu.poli.gerencia.votacion.modelo.VO.VotacionUsuarioCandidato;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author andres.marulanda
 */
@Local
public interface VotacionUsuarioCandidatoFacadeLocal {

    void create(VotacionUsuarioCandidato votacionUsuarioCandidato);

    void edit(VotacionUsuarioCandidato votacionUsuarioCandidato);

    void remove(VotacionUsuarioCandidato votacionUsuarioCandidato);

    VotacionUsuarioCandidato find(Object id);

    List<VotacionUsuarioCandidato> findAll();

    List<VotacionUsuarioCandidato> findRange(int[] range);

    int count();
    
}
