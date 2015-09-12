package com.example.jsf.controllers;

import com.example.jpa.entities.Ciudad;
import com.example.jpa.entities.Departamento;
import com.example.jpa.entities.Rol;
import com.example.jpa.entities.Usuario;
import com.example.jpa.sessions.UsuarioSession;
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
    private Usuario selectedUsuario;
    private int idCiudad;
    private int idDepartamento;
    private String idRol;
    private List<Usuario> itemsUsuario = null;

    /**
     * Crea nueva instancia de UsuarioController
     */
    public UsuarioController() {
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

    public String getCiudad() {
        return idCiudad + "," + idDepartamento;
    }

    public void setCiudad(String ciudad) {
        StringTokenizer tokens = new StringTokenizer(ciudad, ",");
        idCiudad = Integer.parseInt(tokens.nextToken());
        idDepartamento = Integer.parseInt(tokens.nextToken());
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public UsuarioSession getUsuarioSession() {
        return usuarioSession;
    }

    public List<Usuario> getItemsUsuario() {
        if (itemsUsuario == null) {
             try {
                itemsUsuario = getUsuarioSession().findAll();
            } catch (Exception ex){
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
