package com.vetanimals.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author @DavidAlzate88
 */
@Entity
@Table(name = "CIUDADES")
@IdClass(value = CiudadPK.class)
public class Ciudad implements Serializable {

    @Id
    @Column(name = "id_ciudad")
    private int idCiudad;
    
    @Column(name = "nombre_ciudad")
    private String nombreCiudad;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "ciudad")
    private List<Usuario> usuarios;
       
    public Ciudad() {
    }

    public Ciudad(int idCiudad, Departamento idDepartamento) {
        this.idCiudad = idCiudad;
        this.departamento = idDepartamento;
    }
    
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
