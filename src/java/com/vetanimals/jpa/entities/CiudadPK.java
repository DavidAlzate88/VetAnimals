package com.vetanimals.jpa.entities;

import com.sun.org.apache.xalan.internal.utils.Objects;
import java.io.Serializable;

/**
 *
 * @author @DavidAlzate88
 */
public class CiudadPK implements Serializable {
    private int idCiudad;
    private int departamento;

    public CiudadPK() {
    }

    public CiudadPK(int idCiudad, int idDepartamento) {
        this.idCiudad = idCiudad;
        this.departamento = idDepartamento;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idCiudad);
        hash = 23 * hash + Objects.hashCode(this.departamento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CiudadPK other = (CiudadPK) obj;
        if (!Objects.equals(this.idCiudad, other.idCiudad)) {
            return false;
        }
        if (!Objects.equals(this.departamento, other.departamento)) {
            return false;
        }
        return true;
    }
}