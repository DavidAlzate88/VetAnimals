package com.vetanimals.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author @DavidAlzate88
 */
@Entity
@Table(name = "PAISES")
public class Pais implements Serializable {
    
    @Id
    @Column (name = "id_pais")
    private String idPais;
    @Column (name = "nombre_pais")
    private String nombrePais;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pais")
    private List<Departamento> departamentos;

    public Pais() {
    }

    public Pais(String idPais) {
        this.idPais = idPais;
    }

    public String getIdPais() {
        return idPais;
    }

    public void setIdPais(String idPais) {
        this.idPais = idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
}
