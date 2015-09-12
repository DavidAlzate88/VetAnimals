package com.example.jsf.controllers;

import com.example.jpa.entities.Ciudad;
import com.example.jpa.entities.Departamento;
import com.example.jpa.sessions.CiudadSession;
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
    private int idDepartamento;
    private List<Ciudad> itemsCiudad = null;
    
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

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
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
            selectedCiudad.setDepartamento(new Departamento(idDepartamento));
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