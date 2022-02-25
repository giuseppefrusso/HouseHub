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
public class VoceComputo extends Voce{
    
    private int numeroProgressivo;
    private double[] dimensioni;
    private double prezzoComplessivo;
    private double quantita;
    private VoceComputo vediVoce;

    public VoceComputo(int numeroProgressivo, String codice, String descrizione, VoceComputo vediVoce, String unitaDiMisura, double[] dimensioni, double prezzoUnitario) {
        super(codice, descrizione, unitaDiMisura, prezzoUnitario);
        this.numeroProgressivo = numeroProgressivo;
        this.dimensioni = dimensioni;
        this.vediVoce = vediVoce;
        this.quantita = calcolaQuantita(vediVoce, dimensioni);
        this.prezzoComplessivo = this.quantita * prezzoUnitario;
    }

    public double calcolaQuantita(VoceComputo vediVoce, double dimensioni[]) {
        double partiUguali = dimensioni[0];
        double lunghezza = dimensioni[1];
        double larghezza = dimensioni[2];
        double altezza_peso = dimensioni[3];
        
        if(lunghezza == 0) 
            lunghezza = 1;
        if(larghezza == 0)
            larghezza = 1;
        if(altezza_peso == 0)
            altezza_peso = 1;
        
        if(vediVoce == null) 
            return partiUguali*lunghezza*larghezza*altezza_peso;
        else
            return partiUguali*lunghezza*larghezza*altezza_peso*vediVoce.getQuantita();
    }
    
    public int getNumeroProgressivo() {
        return numeroProgressivo;
    }

    public void setNumeroProgressivo(int numeroProgressivo) {
        this.numeroProgressivo = numeroProgressivo;
    }

    public double[] getDimensioni() {
        return dimensioni;
    }

    public void setDimensioni(double[] dimensioni) {
        this.dimensioni = dimensioni;
        this.quantita = calcolaQuantita(vediVoce, dimensioni);
        this.prezzoComplessivo = this.quantita * this.getPrezzoUnitario();
    }

    public double getPrezzoComplessivo() {
        return prezzoComplessivo;
    }

    public double getQuantita() {
        return quantita;
    }

    public VoceComputo getVediVoce() {
        return vediVoce;
    }

    public void setVediVoce(VoceComputo vediVoce) {
        this.vediVoce = vediVoce;
        this.quantita = calcolaQuantita(vediVoce, dimensioni);
    }
    
    //ridefinire equals() solo se si vuole rendere VociComputo uguali sulla base del numero progressivo   
}
