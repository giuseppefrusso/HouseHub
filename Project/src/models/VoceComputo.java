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
public class VoceComputo implements Serializable{
    
    private int numeroProgressivo;
    private Voce voceBase;
    private double[] dimensioni;
    private double prezzoComplessivo;
    private double quantita;

    public VoceComputo(int numeroProgressivo, Voce voceBase, double[] dimensioni, double prezzoComplessivo) {
        this.numeroProgressivo = numeroProgressivo;
        this.voceBase = voceBase;
        this.dimensioni = dimensioni;
        this.quantita = calcolaQuantita(voceBase.getUnitaDiMisura(), dimensioni);
        this.prezzoComplessivo = this.quantita * voceBase.getPrezzoUnitario();
    }

    private double calcolaQuantita(String unitaDiMisura, double dimensioni[]) {
        double partiUguali = dimensioni[0];
        double lunghezza = dimensioni[1];
        double larghezza = dimensioni[2];
        double altezza_peso = dimensioni[3];
        
        if(unitaDiMisura.equalsIgnoreCase("A corpo") || unitaDiMisura.equalsIgnoreCase("Cadauno"))
            return partiUguali;
        else if(unitaDiMisura.equals("m"))
            return lunghezza * partiUguali;
        else if(unitaDiMisura.equals("m2"))
            return lunghezza * larghezza * partiUguali;
        else if(unitaDiMisura.equals("m3")) 
            return lunghezza * larghezza * altezza_peso * partiUguali;
        else
            return altezza_peso * partiUguali;
    }
    
    public int getNumeroProgressivo() {
        return numeroProgressivo;
    }

    public void setNumeroProgressivo(int numeroProgressivo) {
        this.numeroProgressivo = numeroProgressivo;
    }

    public Voce getVoceBase() {
        return voceBase;
    }

    public void setVoceBase(Voce voceBase) {
        this.voceBase = voceBase;
        this.quantita = calcolaQuantita(voceBase.getUnitaDiMisura(), this.dimensioni);
        this.prezzoComplessivo = this.quantita * voceBase.getPrezzoUnitario();
    }

    public double[] getDimensioni() {
        return dimensioni;
    }

    public void setDimensioni(double[] dimensioni) {
        this.dimensioni = dimensioni;
        this.quantita = calcolaQuantita(this.voceBase.getUnitaDiMisura(), dimensioni);
        this.prezzoComplessivo = this.quantita * voceBase.getPrezzoUnitario();
    }

    public double getPrezzoComplessivo() {
        return prezzoComplessivo;
    }

    public double getQuantita() {
        return quantita;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.voceBase);
        return hash;
    }

    //togliere se si vuole permettere di avere più vociComputo con lo stesso id nello stesso computo
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
        final VoceComputo other = (VoceComputo) obj;
        return Objects.equals(this.voceBase, other.voceBase);
    }
}
