/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Pepito
 */
public class Voce {
    
    private final String codice;
    private String descrizione, unitaDiMisura;
    private double prezzoUnitario;

    public Voce(String codice, String descrizione, String unitaDiMisura, double prezzoUnitario) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.unitaDiMisura = unitaDiMisura;
        this.prezzoUnitario = prezzoUnitario;
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
}
