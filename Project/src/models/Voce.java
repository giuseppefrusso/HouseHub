/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Pepito
 */
public class Voce implements Serializable{
    
    private final String codice;
    private String descrizione, unitaDiMisura;
    private double prezzoUnitario;

    public Voce(String codice, String descrizione, String unitaDiMisura, double prezzoUnitario) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.unitaDiMisura = unitaDiMisura;
        this.prezzoUnitario = prezzoUnitario;
    }

    public String getCodice() {
        return codice;
    }
    
    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getUnitaDiMisura() {
        return unitaDiMisura;
    }

    public void setUnitaDiMisura(String unitaDiMisura) {
        this.unitaDiMisura = unitaDiMisura;
    }

    public double getPrezzoUnitario() {
        return prezzoUnitario;
    }

    public void setPrezzo(double prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;
    }       

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Voce other = (Voce) obj;
        return Objects.equals(this.codice, other.codice);
    }
}
