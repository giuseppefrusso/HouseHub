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
public class VoceComputo {
    
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

    public double calcolaQuantita(String unitaDiMisura, double dimensioni[]) {
        if(unitaDiMisura.equals("m")) {
            
        }
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
    }

    public double[] getDimensioni() {
        return dimensioni;
    }

    public void setDimensioni(double[] dimensioni) {
        this.dimensioni = dimensioni;
    }

    public double getPrezzoComplessivo() {
        return prezzoComplessivo;
    }

    public double getQuantita() {
        return quantita;
    }
    
}
