/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.TreeMap;
import utils.Pickle;

/**
 *
 * @author Pepito
 */
public class Capitolato implements Serializable{
    
    private TreeMap<String, Voce> capitolatoClienti, capitolatoSubappaltatori;
    private static final String FILEPATH = System.getProperty("user.dir") + "/capitolato.hhc";
    
    public Capitolato() {
        capitolatoClienti = new TreeMap<>();
        capitolatoSubappaltatori = new TreeMap<>();
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
    
    public TreeMap<String, Voce> getCapitolatoClienti() {
        return capitolatoClienti;
    }

    public TreeMap<String, Voce> getCapitolatoSubappaltatori() {
        return capitolatoSubappaltatori;
    }
    
    public Voce getVoceCliente(String codice) {
        return capitolatoClienti.get(codice);
    }
    
    public Voce getVoceSubappaltatore(String codice) {
        return capitolatoSubappaltatori.get(codice);
    }
    
    public void salvaCapitolato() throws FileNotFoundException, IOException {
        Pickle.save(FILEPATH, this);
    }
    
    public static Capitolato caricaCapitolato() throws FileNotFoundException, IOException, ClassNotFoundException {
        return (Capitolato) Pickle.load(FILEPATH);
    }
}
