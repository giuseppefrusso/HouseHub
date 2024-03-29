/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.LinkedList;
import java.util.StringJoiner;
import java.util.TreeSet;
import utils.Format;

/**
 *
 * @author Pepito
 */
public class VoceComputo extends Voce {

    private int numeroProgressivo;

    private LinkedList<String> misurazioni;
    private LinkedList<Double> partiUguali;
    private LinkedList<Double> lunghezze;
    private LinkedList<Double> larghezze;
    private LinkedList<Double> altezze_pesi;

    private TreeSet<Integer> vediVoce;
    private LinkedList<Double> lunghezzeVV;
    private LinkedList<Double> larghezzeVV;
    private LinkedList<Double> altezze_pesiVV;

    private String descrizioneSubappaltatore;
    private double prezzoUnitarioSubappaltatore;
    
    public static final String SUPER_SEPARATOR = ";                                                                                          ";

    public VoceComputo(int numeroProgressivo, String codice, String descrizione, String unitaDiMisura, double prezzoUnitario, String descrizioneSubappaltatore, double prezzoUnitarioSubappaltatore) {
        super(codice, descrizione, unitaDiMisura, prezzoUnitario);
        this.numeroProgressivo = numeroProgressivo;

        misurazioni = new LinkedList<>();
        partiUguali = new LinkedList<>();
        lunghezze = new LinkedList<>();
        larghezze = new LinkedList<>();
        altezze_pesi = new LinkedList<>();

        this.vediVoce = new TreeSet<>();
        lunghezzeVV = new LinkedList<>();
        larghezzeVV = new LinkedList<>();
        altezze_pesiVV = new LinkedList<>();
        this.aggiungiDimensioni("default", 0, 0, 0, 0);

        this.descrizioneSubappaltatore = descrizioneSubappaltatore;
        this.prezzoUnitarioSubappaltatore = prezzoUnitarioSubappaltatore;
    }

    public boolean controllaMisurazione(int index) {
        double parteUguale = partiUguali.get(index),
                lunghezza = lunghezze.get(index),
                larghezza = larghezze.get(index),
                altezza_peso = altezze_pesi.get(index);

        return !(parteUguale == 0 && lunghezza == 0 && larghezza == 0 && altezza_peso == 0);
    }

    private double calcolaQuantita(Computo computo) {

        double quantita = 0;

        for (int i = 0; i < misurazioni.size(); i++) {
            double parteUguale = partiUguali.get(i),
                    lunghezza = lunghezze.get(i),
                    larghezza = larghezze.get(i),
                    altezza_peso = altezze_pesi.get(i);

            if (parteUguale == 0 && lunghezza == 0 && larghezza == 0 && altezza_peso == 0) {
                continue;
            }

            if (parteUguale == 0) {
                parteUguale = 1;
            }
            if (lunghezza == 0) {
                lunghezza = 1;
            }
            if (larghezza == 0) {
                larghezza = 1;
            }
            if (altezza_peso == 0) {
                altezza_peso = 1;
            }

            quantita += (parteUguale * lunghezza * larghezza * altezza_peso);
        }

        int i = 0;
        for (int numProgr : vediVoce) {
            double lunghezzaVV = lunghezzeVV.get(i) != 0 ? lunghezzeVV.get(i) : 1;
            double larghezzaVV = larghezzeVV.get(i) != 0 ? larghezzeVV.get(i) : 1;
            double altezza_pesoVV = altezze_pesiVV.get(i) != 0 ? altezze_pesiVV.get(i) : 1;
            quantita += computo.getVociComputo().get(numProgr).getQuantita(computo) * lunghezzaVV * larghezzaVV * altezza_pesoVV;
            i++;
        }
        return quantita;
        //this.prezzoComplessivo = this.quantita * getPrezzoUnitario();
    }

    public int getNumeroProgressivo() {
        return numeroProgressivo;
    }

    public void setNumeroProgressivo(int numeroProgressivo) {
        this.numeroProgressivo = numeroProgressivo;
    }

    public String getDescrizioneSubappaltatore() {
        return descrizioneSubappaltatore;
    }

    public void setDescrizioneSubappaltatore(String descrizioneSubappaltatore) {
        this.descrizioneSubappaltatore = descrizioneSubappaltatore;
    }

    public double getPrezzoUnitarioSubappaltatore() {
        return prezzoUnitarioSubappaltatore;
    }

    public void setPrezzoUnitarioSubappaltatore(double prezzoUnitarioSubappaltatore) {
        this.prezzoUnitarioSubappaltatore = prezzoUnitarioSubappaltatore;
    }

    public double getPrezzoComplessivoSubappaltatore(Computo computo) {
        double quantita = calcolaQuantita(computo);
        double prezzoComplessivo = quantita * getPrezzoUnitarioSubappaltatore();
        prezzoComplessivo = Math.round(prezzoComplessivo * 100.0) / 100.0;
        return prezzoComplessivo;
    }

    public double getPrezzoComplessivo(Computo computo) {
        double quantita = calcolaQuantita(computo);
        double prezzoComplessivo = quantita * getPrezzoUnitario();
        prezzoComplessivo = Math.round(prezzoComplessivo * 100.0) / 100.0;
        return prezzoComplessivo;
    }

    public double getQuantita(Computo computo) {
        double quantita = calcolaQuantita(computo);
        quantita = Math.round(quantita * 100.0) / 100.0;
        return quantita;
    }

    public LinkedList<String> getMisurazioni() {
        return misurazioni;
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
    
    public LinkedList<Double> getLunghezzeVV() {
        return lunghezzeVV;
    }

    public LinkedList<Double> getLarghezzeVV() {
        return larghezzeVV;
    }

    public LinkedList<Double> getAltezze_pesiVV() {
        return altezze_pesiVV;
    }

    public void aggiungiDimensioni(String m, double pu, double lung, double larg, double alt_p) {
        misurazioni.add(m);
        partiUguali.add(pu);
        lunghezze.add(lung);
        larghezze.add(larg);
        altezze_pesi.add(alt_p);
        //calcolaQuantita();
    }

    public void rimuoviDimensioni(int index) {
        misurazioni.remove(index);
        partiUguali.remove(index);
        lunghezze.remove(index);
        larghezze.remove(index);
        altezze_pesi.remove(index);
        //calcolaQuantita();
    }

    public void setMisurazione(int index, String misurazione) {
        misurazioni.remove(index);
        misurazioni.add(index, misurazione);
    }

    public void setDimensione(int index, int dimensione, double newValue) throws Exception {
        switch (dimensione) {
            case 1:
                partiUguali.remove(index);
                partiUguali.add(index, newValue);
                break;
            case 2:
                lunghezze.remove(index);
                lunghezze.add(index, newValue);
                break;
            case 3:
                larghezze.remove(index);
                larghezze.add(index, newValue);
                break;
            case 4:
                altezze_pesi.remove(index);
                altezze_pesi.add(index, newValue);
                break;
            default:
                throw new Exception("Devi specificare un numero da 1 a 4!");
        }
    }

    public void setDimensioneVediVoce(int index, int dimensione, double newValue) throws Exception {
        switch(dimensione) {
            case 2:
                lunghezzeVV.remove(index);
                lunghezzeVV.add(index, newValue);
                break;
            case 3:
                larghezzeVV.remove(index);
                larghezzeVV.add(index, newValue);
                break;
            case 4:
                altezze_pesiVV.remove(index);
                altezze_pesiVV.add(index, newValue);
                break;
            default:
                throw new Exception("Devi specificare un numero da 2 a 4!");
        }
    
    }

    public void svuotaDimensioni() {
        misurazioni.clear();
        partiUguali.clear();
        lunghezze.clear();
        larghezze.clear();
        altezze_pesi.clear();
        //calcolaQuantita();
    }

    public TreeSet<Integer> getVediVoce() {
        return vediVoce;
    }

    public void aggiungiVediVoce(int numeroProgressivo, double lung, double larg, double alt_p) {
        vediVoce.add(numeroProgressivo);
        lunghezzeVV.add(lung);
        larghezzeVV.add(larg);
        altezze_pesiVV.add(alt_p);
        //calcolaQuantita();
    }

    public boolean rimuoviVediVoce(int numeroProgressivo) {
        int index = 0;
        for (Integer curr : vediVoce) {
            if (curr == numeroProgressivo) {
                break;
            }
            index++;
        }

        lunghezzeVV.remove(index);
        larghezzeVV.remove(index);
        altezze_pesiVV.remove(index);
        return vediVoce.remove(numeroProgressivo);
    }

    private String misurazioniToString() {
        StringJoiner sb = new StringJoiner(SUPER_SEPARATOR, "", "");

        for (int i = 0; i < misurazioni.size(); i++) {
            sb.add(misurazioni.get(i));
        }

        return sb.toString();
    }

    private String dimensioneToString(LinkedList<Double> dimensione) {
        StringJoiner sb = new StringJoiner(";  ", "", "");

        for (int i = 0; i < dimensione.size(); i++) {
            sb.add(Format.formatDouble(dimensione.get(i)));
        }

        return sb.toString();
    }

    public String partiUgualiToString() {
        StringJoiner joiner = new StringJoiner(SUPER_SEPARATOR, "", "");

        for (int i = 0; i < partiUguali.size(); i++) {
            joiner.add(misurazioni.get(i) + ": " + Format.formatDouble(partiUguali.get(i)));
        }

        return joiner.toString();
    }

    public String lunghezzeToString() {
        return dimensioneToString(lunghezze);
    }
    
    public String lunghezzeVVToString() {
        return dimensioneToString(lunghezzeVV);
    }

    public String larghezzeToString() {
        return dimensioneToString(larghezze);
    }
    
    public String larghezzeVVToString() {
        return dimensioneToString(larghezzeVV);
    }

    public String altezzePesiToString() {
        return dimensioneToString(altezze_pesi);
    }
    
    public String altezzePesiVVToString() {
        return dimensioneToString(altezze_pesiVV);
    }

    public String vediVoceToString(Computo computo) {
        StringBuffer sb = new StringBuffer();

        int count = 0;
        int size = vediVoce.size();
        for (int nP : vediVoce) {
            sb.append("Voce ").append(nP).append(": ")
                    .append(Format.formatDouble(computo.getVociComputo().get(nP).getQuantita(computo)));
            count++;
            if (count != size) {
                sb.append(SUPER_SEPARATOR);
            }
        }

        return sb.toString();
    }

    //ridefinire equals() solo se si vuole rendere VociComputo uguali sulla base del numero progressivo   
}
