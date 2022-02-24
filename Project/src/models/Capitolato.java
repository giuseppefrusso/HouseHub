/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.FileNotFoundException;
import java.io.IOException;
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
    
    public Voce addVoceCliente(Voce voce) {
        return capitolatoClienti.put(voce.getCodice(), voce);
    }
    
    public Voce addVoceSubappaltori(Voce voce) {
        return capitolatoSubappaltatori.put(voce.getCodice(), voce);
    }

    public Voce removeVoceCliente(String codice) {
        return capitolatoClienti.remove(codice);
    }
    
    public Voce removeVoceSubappaltatori(String codice) {
        return capitolatoSubappaltatori.remove(codice);
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
    
    public void salvaCapitolato(String path) throws FileNotFoundException, IOException {
        Pickle.save(path, this);
    }
    
    public static Capitolato caricaCapitolato(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
        return (Capitolato) Pickle.load(path);
    }
}
