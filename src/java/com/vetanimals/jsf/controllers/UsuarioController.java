package com.vetanimals.jsf.controllers;

import com.vetanimals.jpa.entities.Ciudad;
import com.vetanimals.jpa.entities.Departamento;
import com.vetanimals.jpa.entities.Rol;
import com.vetanimals.jpa.entities.Usuario;
import com.vetanimals.jpa.sessions.UsuarioSession;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import java.util.List;
import java.util.StringTokenizer;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author @DavidAlzate88
 */
@ManagedBean
@ViewScoped
public class UsuarioController implements Serializable {

    @EJB
    private UsuarioSession usuarioSession;
    
    //Crear variables temporales para las claves foraneas
    private int idCiudad;
    private int idDepartamento;
    private int idRol;
    private Usuario selectedUsuario;
    private List<Usuario> itemsUsuario = null;

    //Crea nueva instancia de UsuarioController
    
    public String getIdCiudad() {
        return idCiudad + "," + idDepartamento;
    }
    
    public void setCiudad(String ciudad) {
        StringTokenizer tokens = new StringTokenizer(ciudad, ",");
        idCiudad = Integer.parseInt(tokens.nextToken());
        idDepartamento = Integer.parseInt(tokens.nextToken());
    }
    
    public int getIdRol() {
        return idRol;
    }
    
    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
    
    public int getIdDepartamento(){
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
    public Usuario getSelectedUsuario() {
        if (selectedUsuario == null) {
            selectedUsuario = new Usuario();
        }
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }
    
    public UsuarioSession getUsuarioSession(){
        return usuarioSession;
    }

    public List<Usuario> getItemsUsuario(){
        if (itemsUsuario == null){
            try {
                itemsUsuario = getUsuarioSession().findAll();
            }catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        return itemsUsuario;
    }    

    public void create(){
        try {
            selectedUsuario.setCiudad(new Ciudad(idCiudad, new Departamento(idDepartamento)));
            selectedUsuario.setRol(new Rol(idRol));
            getUsuarioSession().create(selectedUsuario);
        } catch (Exception ex) {
             System.err.println(ex.getMessage());
        }
    }
}
