/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.poli.gerencia.votacion.controlador;

import edu.poli.gerencia.votacion.modelo.DAO.PersonaFacadeLocal;
import edu.poli.gerencia.votacion.modelo.DAO.TipoDocumentoFacadeLocal;
import edu.poli.gerencia.votacion.modelo.DAO.TipoUsuarioFacadeLocal;
import edu.poli.gerencia.votacion.modelo.DAO.UsuarioFacadeLocal;
import edu.poli.gerencia.votacion.modelo.VO.Persona;
import edu.poli.gerencia.votacion.modelo.VO.TipoDocumento;
import edu.poli.gerencia.votacion.modelo.VO.TipoUsuario;
import edu.poli.gerencia.votacion.modelo.VO.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author andres.marulanda
 */
@ManagedBean
@ViewScoped
public class CrearUsuariosControlller implements Serializable{

    /**
     * Objetos de la calse
     *
     */
     private Usuario usuario;
     private Integer tipoUsuario;
     private Integer tipoDocumento;
     private String nitBusqueda;
     private String empresaSearch;
     private String nitSearch;
     private Integer consPersonaSearch;
     private String primerNombre;
     private String segundoNombre;
     private String primerApellido;
     private String segundoApellido;
     private String correoElectronico;
     private String nombreEmpresa;
     private String nombreUsuario;
     private String numeroDocumento;
     
     
     private Persona persona;
     private List<TipoDocumento> listDocumento;
     private List<TipoUsuario> listUsuario;
     private List<TipoDocumento> listDocumentoEmpresa;
     private List<TipoDocumento> listDocumentoEmpleado;
      
     
     
     /**Ejbs*/
    
    @EJB
    private UsuarioFacadeLocal usuarioDao;
    
    @EJB
    private TipoDocumentoFacadeLocal tipoDocumentoDao;
    
    @EJB
    private TipoUsuarioFacadeLocal tipoUsuarioDao;
    
    @EJB
    private PersonaFacadeLocal personaDao;
    
    public CrearUsuariosControlller() {
    }
    
    @PostConstruct
    public void init(){
        listUsuario = tipoUsuarioDao.obtenerTipoUsuarioRegistro();
        listDocumentoEmpresa = tipoDocumentoDao.obtenerDocumentoEmpresa();
        listDocumentoEmpleado = tipoDocumentoDao.obtenerDocumentoEmpleado();
    }
    
    
    
    public void obtenerTipoDocumento(){
        if(this.tipoUsuario == 2){
            listDocumento = listDocumentoEmpleado;
        }else{
            listDocumento = listDocumentoEmpresa;
        }
    }
            
            
    public boolean validarUsuario(String usuario){        
        boolean resultado = false;
        if(usuarioDao.validarUsuarioRegistrado(usuario) == null){
           resultado = true;
        }
        return resultado;
    }
    
    public void buscarEmpresa(){
        System.out.println(this.empresaSearch);
        Persona persona = personaDao.buscarPersonaPorNit(getEmpresaSearch());
        if(persona != null){
            empresaSearch = persona.getNombreEmpresa();
            nitSearch = persona.getNumeroDocumento();
            consPersonaSearch = persona.getConsPersona();
        }else{
            FacesMessage msg = new FacesMessage("No se encontro una empresa con el nit ingersado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    /**
     **/
    public String crearUsuario(){
        String mensaje = "";
        String redireccionar = "";
        try{
           if(validarUsuario(nombreUsuario)){
                Integer consUsuario = guardarUsuario();
                gudardarPersona(consUsuario);
                mensaje = "Usuario registrado satisfactoriamente ";
                redireccionar ="index.xhtml";
           }else{
               mensaje = "El nombre de usuario ya se encuentra registrado";
           }
         }catch(Exception e){
           e.getMessage();
           mensaje = "No se pudo crear el usuario debido a un problema en la aplicacion";
        }
            
        FacesMessage msg = new FacesMessage(mensaje);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return redireccionar;
    }

    private Integer guardarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setActivo('N');
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setIdTipoUsuario(new TipoUsuario(this.tipoUsuario));
        usuarioDao.create(usuario);
        return usuario.getConsUsuario();
    }
    
    private void gudardarPersona(Integer consUsuario){
        Persona persona = new Persona();
        persona.setConsUsuario(new Usuario(consUsuario));
        persona.setNumeroDocumento(this.numeroDocumento);
        persona.setIdTipoDocumento(new TipoDocumento(this.tipoDocumento));
        persona.setCorreo(this.correoElectronico);
        if(this.tipoUsuario == 2){
          persona.setNombreEmpresa(this.nombreEmpresa);
        }else{
          persona.setPrimerNombre(this.primerNombre);
          persona.setSegundoNombre(this.segundoNombre);
          persona.setPrimerApellido(this.primerApellido);
          persona.setSegundoApellido(this.segundoApellido);
          persona.setConsPersonaAsociada(new Persona(this.consPersonaSearch));
        }
        personaDao.create(persona);
    }
    
    /**Get and set**/
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<TipoDocumento> getListDocumento() {
        return listDocumento;
    }

    public void setListDocumento(List<TipoDocumento> listDocumento) {
        this.listDocumento = listDocumento;
    }

    public List<TipoUsuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<TipoUsuario> listUsuario) {
        this.listUsuario = listUsuario;
    }

    public List<TipoDocumento> getListDocumentoEmpresa() {
        return listDocumentoEmpresa;
    }

    public void setListDocumentoEmpresa(List<TipoDocumento> listDocumentoEmpresa) {
        this.listDocumentoEmpresa = listDocumentoEmpresa;
    }

    public List<TipoDocumento> getListDocumentoEmpleado() {
        return listDocumentoEmpleado;
    }

    public void setListDocumentoEmpleado(List<TipoDocumento> listDocumentoEmpleado) {
        this.listDocumentoEmpleado = listDocumentoEmpleado;
    }

    public Integer getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Integer tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNitBusqueda() {
        return nitBusqueda;
    }

    public void setNitBusqueda(String nitBusqueda) {
        this.nitBusqueda = nitBusqueda;
    }



    public String getEmpresaSearch() {
        return empresaSearch;
    }

    public void setEmpresaSearch(String empresaSearch) {
        this.empresaSearch = empresaSearch;
    }

    public String getNitSearch() {
        return nitSearch;
    }

    public void setNitSearch(String nitSearch) {
        this.nitSearch = nitSearch;
    }

    public Integer getConsPersonaSearch() {
        return consPersonaSearch;
    }

    public void setConsPersonaSearch(Integer consPersonaSearch) {
        this.consPersonaSearch = consPersonaSearch;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    
    
}
