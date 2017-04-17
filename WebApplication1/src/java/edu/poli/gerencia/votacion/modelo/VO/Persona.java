/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.poli.gerencia.votacion.modelo.VO;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andres.marulanda
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByConsPersona", query = "SELECT p FROM Persona p WHERE p.consPersona = :consPersona"),
    @NamedQuery(name = "Persona.findBySegundoApellido", query = "SELECT p FROM Persona p WHERE p.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Persona.findByPrimerNombre", query = "SELECT p FROM Persona p WHERE p.primerNombre = :primerNombre"),
    @NamedQuery(name = "Persona.findBySegundoNombre", query = "SELECT p FROM Persona p WHERE p.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "Persona.findByPrimerApellido", query = "SELECT p FROM Persona p WHERE p.primerApellido = :primerApellido"),
    @NamedQuery(name = "Persona.findByNombreEmpresa", query = "SELECT p FROM Persona p WHERE p.nombreEmpresa = :nombreEmpresa"),
    @NamedQuery(name = "Persona.findByCorreo", query = "SELECT p FROM Persona p WHERE p.correo = :correo"),
    @NamedQuery(name = "Persona.findByNumeroDocumento", query = "SELECT p FROM Persona p WHERE p.numeroDocumento = :numeroDocumento")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CONS_PERSONA")
    private Integer consPersona;
    @Size(max = 50)
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Size(max = 50)
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    @Size(max = 50)
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    @Size(max = 50)
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    @Size(max = 50)
    @Column(name = "NOMBRE_EMPRESA")
    private String nombreEmpresa;
    @Size(max = 50)
    @Column(name = "CORREO")
    private String correo;
    @Size(max = 50)
    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;
    @JoinColumn(name = "CONS_USUARIO", referencedColumnName = "CONS_USUARIO")
    @ManyToOne(optional = false)
    private Usuario consUsuario;
    @JoinColumn(name = "ID_TIPO_DOCUMENTO", referencedColumnName = "ID_TIPO_DOCUMENTO")
    @ManyToOne(optional = false)
    private TipoDocumento idTipoDocumento;
    @OneToMany(mappedBy = "consPersonaAsociada")
    private List<Persona> personaList;
    @JoinColumn(name = "CONS_PERSONA_ASOCIADA", referencedColumnName = "CONS_PERSONA")
    @ManyToOne
    private Persona consPersonaAsociada;

    public Persona() {
    }

    public Persona(Integer consPersona) {
        this.consPersona = consPersona;
    }

    public Integer getConsPersona() {
        return consPersona;
    }

    public void setConsPersona(Integer consPersona) {
        this.consPersona = consPersona;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
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

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Usuario getConsUsuario() {
        return consUsuario;
    }

    public void setConsUsuario(Usuario consUsuario) {
        this.consUsuario = consUsuario;
    }

    public TipoDocumento getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(TipoDocumento idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    public Persona getConsPersonaAsociada() {
        return consPersonaAsociada;
    }

    public void setConsPersonaAsociada(Persona consPersonaAsociada) {
        this.consPersonaAsociada = consPersonaAsociada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consPersona != null ? consPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.consPersona == null && other.consPersona != null) || (this.consPersona != null && !this.consPersona.equals(other.consPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.poli.gerencia.votacion.modelo.VO.Persona[ consPersona=" + consPersona + " ]";
    }
    
}
