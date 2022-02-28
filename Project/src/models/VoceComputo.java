/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Pepito
 */
public class VoceComputo extends Voce {

    private int numeroProgressivo;
    private LinkedList<Double> partiUguali;
    private LinkedList<Double> lunghezze;
    private LinkedList<Double> larghezze;
    private LinkedList<Double> altezze_pesi;
    private double prezzoComplessivo;
    private double quantita;
    private HashMap<Integer, VoceComputo> vediVoce;

    
    public VoceComputo(int numeroProgressivo, String codice, String descrizione, String unitaDiMisura, double prezzoUnitario) {
        super(codice, descrizione, unitaDiMisura, prezzoUnitario);
        this.numeroProgressivo = numeroProgressivo;
        partiUguali = new LinkedList<>();
        lunghezze = new LinkedList<>();
        larghezze = new LinkedList<>();
        altezze_pesi = new LinkedList<>();
        this.vediVoce = new HashMap<>();
        calcolaQuantita();
        this.prezzoComplessivo = this.quantita * prezzoUnitario;
    }

    public void calcolaQuantita() {

        quantita = 0;

        for (int i = 0; i < partiUguali.size(); i++) {
            double lunghezza = lunghezze.get(i), larghezza = larghezze.get(i), altezza_peso = altezze_pesi.get(i);

            if (lunghezza == 0) {
                lunghezza = 1;
            }
            if (larghezza == 0) {
                larghezza = 1;
            }
            if (altezza_peso == 0) {
                altezza_peso = 1;
            }

            quantita += (partiUguali.get(i) * lunghezza * larghezza * altezza_peso);
        }

        for (int numProgr : vediVoce.keySet()) {
            quantita *= vediVoce.get(numProgr).quantita;
        }
    }

    public int getNumeroProgressivo() {
        return numeroProgressivo;
    }

    public void setNumeroProgressivo(int numeroProgressivo) {
        this.numeroProgressivo = numeroProgressivo;
    }

    public double getPrezzoComplessivo() {
        return prezzoComplessivo;
    }

    public double getQuantita() {
        return quantita;
    }

    public LinkedList<Double> getPartiUguali() {
        return partiUguali;
    }

    public LinkedList<Double> getLunghezze() {
        return lunghezze;
    }

    public LinkedList<Double> getLarghezze() {
        return larghezze;
    }

    public LinkedList<Double> getAltezze_pesi() {
        return altezze_pesi;
    }

    public void aggiungiDimensioni(double pu, double lung, double larg, double alt_p) {
        partiUguali.add(pu);
        lunghezze.add(lung);
        larghezze.add(larg);
        altezze_pesi.add(alt_p);
        calcolaQuantita();
    }

    public void rimuoviDimensioni(int index) {
        partiUguali.remove(index);
        lunghezze.remove(index);
        larghezze.remove(index);
        altezze_pesi.remove(index);
        calcolaQuantita();
    }
    
    public HashMap<Integer, VoceComputo> getVediVoce() {
        return vediVoce;
    }
    
    public void aggiungiVediVoce(VoceComputo voce) {
        vediVoce.put(voce.numeroProgressivo, voce);
        calcolaQuantita();
    }
    
    public VoceComputo rimuoviVediVoce(int numeroProgressivo) {
        return vediVoce.remove(numeroProgressivo);
    }
    
    private String dimensioneToString(LinkedList<Double> dimensione) {
        StringBuffer sb = new StringBuffer();
        
        for(int i = 0; i < dimensione.size(); i++) {
            sb.append(dimensione.get(i));
            if(i != dimensione.size()-1)
                sb.append(", ");
        }
        
        return sb.toString();
    }
    
    public String partiUgualiToString() {
        return dimensioneToString(partiUguali);
    }
    
    public String lunghezzeToString() {
        return dimensioneToString(lunghezze);
    }
    
    public String larghezzeToString() {
        return dimensioneToString(larghezze);
    }
    
    public String altezzePesiToString() {
        return dimensioneToString(altezze_pesi);
    }

    public String vediVoceToString() {
        StringBuffer sb = new StringBuffer();
        
        int count = 0;
        int size = vediVoce.keySet().size();
        for(int nP : vediVoce.keySet()) {
            sb.append(nP);
            count ++;
            if(count != size) {
                sb.append(", ");
            }
        }
        
        return sb.toString();
    }

    //ridefinire equals() solo se si vuole rendere VociComputo uguali sulla base del numero progressivo   
}
