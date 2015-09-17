package com.vetanimals.jsf.controllers;

import com.vetanimals.jpa.entities.Rol;
import com.vetanimals.jpa.sessions.RolSession;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author @DavidAlzate88
 */
@ManagedBean
@ViewScoped
public class RolController implements Serializable {
    
    @EJB //Enterprise Java Beans
    private RolSession rolSession;
    
    private Rol selectedRol;
    private List<Rol> itemsRol = null;

    public RolController() {
    }

    public Rol getSelectedRol() {
        if (selectedRol == null) {
            selectedRol = new Rol();
        }
        return selectedRol;
    }

    public void setSelectedRol(Rol selectedRol) {
        this.selectedRol = selectedRol;
    }

    public RolSession getRolSession() {
        return rolSession;
    }
    
    public void create () {
        try {
            getRolSession().create(selectedRol);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<Rol> getItemsRol() {
        if (itemsRol == null) {
            try {
                itemsRol = getRolSession().findAll();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        return itemsRol;
    }    
}