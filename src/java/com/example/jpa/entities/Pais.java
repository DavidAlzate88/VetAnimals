package com.example.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author @DavidAlzate88
 */
@Entity
@Table(name = "PAISES")
public class Pais implements Serializable {
    
    @Id //Clave Primaria
    @Column (name = "id_pais")
    private String idPais;
    
    @Column (name = "nombre_pais")
    @Size(max = 60)
    private String nombrePais;
    
    @OneToMany(mappedBy = "pais")
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
