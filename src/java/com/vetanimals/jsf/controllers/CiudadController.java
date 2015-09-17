package com.vetanimals.jsf.controllers;

import com.vetanimals.jpa.entities.Ciudad;
import com.vetanimals.jpa.sessions.CiudadSession;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author @DavidAlzate88
 */
@Named
@ViewScoped
public class CiudadController implements Serializable {
    
    @EJB //Enterprise Java Beans
    private CiudadSession ciudadSession;
    
    private Ciudad selectedCiudad;
    private List<Ciudad> itemsCiudad=null;
    private int idDepartamento;
    
    public CiudadController() {
    }

    public Ciudad getSelectedCiudad() {
        if (selectedCiudad == null) {
            selectedCiudad = new Ciudad();
        }
        return selectedCiudad;
    }

    public void setSelectedCiudad(Ciudad selectedCiudad) {
        this.selectedCiudad = selectedCiudad;
    }

    public CiudadSession getCiudadSession() {
        return ciudadSession;
    }

    public List<Ciudad> getItemsCiudad() {
        if (itemsCiudad == null) {
            try {
                itemsCiudad = getCiudadSession().findAll();
            } catch (Exception ex){
                System.err.println(ex.getMessage());
            }
        }
        return itemsCiudad;
    }
    
    public void create(){
        try {
            getCiudadSession().create(selectedCiudad);
        } catch (Exception ex) {
             System.err.println(ex.getMessage());
        }
    }
    
    public void remove(){
        try {
            getCiudadSession().remove(selectedCiudad);
            itemsCiudad = null;
        } catch (Exception ex) {
             System.err.println(ex.getMessage());
        }
    }    
}