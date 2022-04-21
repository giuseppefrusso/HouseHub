/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.TreeMap;
import utils.Pickle;

/**
 *
 * @author Pepito
 */
public class Capitolato implements Serializable{
    
    private TreeMap<LocalDateTime, Voce> capitolatoClienti, capitolatoSubappaltatori;
    private static final String FILEPATH = System.getProperty("user.dir") + "/capitolato.hhc";
    
    public Capitolato() {
        capitolatoClienti = new TreeMap<>();
        capitolatoSubappaltatori = new TreeMap<>();
    }
    
    public Voce addVoceCliente(Voce voce) {
        return capitolatoClienti.put(LocalDateTime.now(), voce);
    }
    
    public Voce addVoceSubappaltori(Voce voce) {
        return capitolatoSubappaltatori.put(LocalDateTime.now(), voce);
    }

    public Voce removeVoceCliente(String codice) {
        for(LocalDateTime key : capitolatoClienti.keySet()) {
            Voce v = capitolatoClienti.get(key);
            if(v.getCodice().equalsIgnoreCase(codice)) {
                return capitolatoClienti.remove(key);
            }
        }
        return null;
    }
    
    public Voce removeVoceSubappaltatori(String codice) {
        for(LocalDateTime key : capitolatoSubappaltatori.keySet()) {
            Voce v = capitolatoSubappaltatori.get(key);
            if(v.getCodice().equalsIgnoreCase(codice)) {
                return capitolatoSubappaltatori.remove(key);
            }
        }
        return null;
    }
    
    public Collection<Voce> getCapitolatoClienti() {
        return capitolatoClienti.values();
    }

    public Collection<Voce> getCapitolatoSubappaltatori() {
        return capitolatoSubappaltatori.values();
    }
    
    public Voce getVoceCliente(String codice) {
        for(LocalDateTime key : capitolatoClienti.keySet()) {
            Voce v = capitolatoClienti.get(key);
            if(v.getCodice().equalsIgnoreCase(codice)) {
                return v;
            }
        }
        return null;
    }
    
    public Voce getVoceSubappaltatore(String codice) {
        for(LocalDateTime key : capitolatoSubappaltatori.keySet()) {
            Voce v = capitolatoSubappaltatori.get(key);
            if(v.getCodice().equalsIgnoreCase(codice)) {
                return v;
            }
        }
        return null;
    }
    
    public void salvaCapitolato() throws FileNotFoundException, IOException {
        Pickle.save(FILEPATH, this);
    }
    
    public static Capitolato caricaCapitolato() throws FileNotFoundException, IOException, ClassNotFoundException {
        return (Capitolato) Pickle.load(FILEPATH);
    }
}
