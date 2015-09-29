package com.palmirasoft.vetanimals.jsf.controllers;

import com.palmirasoft.vetanimals.jpa.entities.Departamento;
import com.palmirasoft.vetanimals.jpa.sessions.DepartamentoSession;
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
public class DepartamentoController implements Serializable {

    @EJB
    private DepartamentoSession departamentoSession;

    private Departamento selectedDepartamento;
    private List<Departamento> itemsDepartamentos = null;
    
    public Departamento getSelectedDepartamento() {
        if (selectedDepartamento == null) {
            selectedDepartamento = new Departamento();
        }
        return selectedDepartamento;
    }

    public void setSelectedDepartamento(Departamento selectedDepartamento) {
        this.selectedDepartamento = selectedDepartamento;
    }

    public DepartamentoSession getDepartamentoSession() {
        return departamentoSession;
    }

    public List<Departamento> getItemsDepartamentos() {
        if (itemsDepartamentos == null) {
            try {
                itemsDepartamentos = getDepartamentoSession().findAll();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        return itemsDepartamentos;
    }

    public void create() {
        try {
            getDepartamentoSession().create(selectedDepartamento);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}