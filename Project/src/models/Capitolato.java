/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.LinkedList;
import utils.Pickle;

/**
 *
 * @author Pepito
 */
public class Capitolato implements Serializable{
    
    private LinkedList<Voce> capitolatoClienti, capitolatoSubappaltatori;
    
    public Capitolato() {
        capitolatoClienti = new LinkedList<>();
        capitolatoSubappaltatori = new LinkedList<>();
    }
    
    public void addVoceCliente(Voce voce) {
        capitolatoClienti.add(voce);
    }
    
    public void addVoceSubappaltori(Voce voce) {
        capitolatoSubappaltatori.add(voce);
    }

    public LinkedList<Voce> getCapitolatoClienti() {
        return capitolatoClienti;
    }

    public LinkedList<Voce> getCapitolatoSubappaltatori() {
        return capitolatoSubappaltatori;
    }
    
    public boolean salvaProgetto(String path) {
        return Pickle.save(path, this);
    }
    
    public static Progetto caricaProgetto(String path) {
        return (Progetto) Pickle.load(path);
    }
}
