package com.example.jsf.controllers;

import com.example.jpa.entities.Departamento;
import com.example.jpa.sessions.DepartamentoSession;
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
public class DepartamentoController {

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