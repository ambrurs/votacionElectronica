/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.poli.gerencia.votacion.controlador;

import edu.poli.gerencia.votacion.modelo.VO.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author andres.marulanda
 */
public class ValidarSesion implements Serializable{
    protected Usuario usuario;
    
    @PostConstruct
    public void validarSesion(){
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            Object objetoUsuario = getSesion().getAttribute("usuario"); 
            if(objetoUsuario != null){
                redireccionar("login.xhtml");
                FacesContext.getCurrentInstance().addMessage("Error", null);
           } else if (!request.getRequestURL().toString().contains("paginamaestra.xhtml") && request.getMethod().equalsIgnoreCase("GET")) {
                redireccionar("menu.xhtml");
                FacesContext.getCurrentInstance().addMessage("Error", null);
           }else{
               objetoUsuario = (Usuario) usuario;
           }
        } catch (Exception e) {
            e.getMessage();
            throw e;
        }
    }
   
    
     public void redireccionar(String pagina) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(pagina);
        } catch (IOException ex) {
            Logger.getLogger(ValidarSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
     
    public void cerrarSesion() {
        getSesion().invalidate();
        redireccionar("index.xhtml");
    }     
     
    public HttpSession getSesion(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) contexto.getExternalContext().getSession(false);
        return sesion;        
    }
    
}
