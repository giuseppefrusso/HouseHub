/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.HashMap;
import utils.Pickle;

/**
 *
 * @author Pepito
 */
public class Capitolato implements Serializable{
    
    private HashMap<String, Voce> capitolatoClienti, capitolatoSubappaltatori;
    
    public Capitolato() {
        capitolatoClienti = new HashMap<>();
        capitolatoSubappaltatori = new HashMap<>();
    }
    
    public void addVoceCliente(Voce voce) {
        capitolatoClienti.put(voce.getCodice(), voce);
    }
    
    public void addVoceSubappaltori(Voce voce) {
        capitolatoSubappaltatori.put(voce.getCodice(), voce);
    }

    public HashMap<String, Voce> getCapitolatoClienti() {
        return capitolatoClienti;
    }

    public HashMap<String, Voce> getCapitolatoSubappaltatori() {
        return capitolatoSubappaltatori;
    }
    
    public Voce getVoceCliente(String codice) {
        return capitolatoClienti.get(codice);
    }
    
    public Voce getVoceSubappaltatore(String codice) {
        return capitolatoSubappaltatori.get(codice);
    }
    
    public boolean salvaCapitolato(String path) {
        return Pickle.save(path, this);
    }
    
    public static Capitolato caricaCapitolato(String path) {
        return (Capitolato) Pickle.load(path);
    }
}
