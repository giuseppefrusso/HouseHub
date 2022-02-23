/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.LinkedList;

/**
 *
 * @author Pepito
 */
public class Capitolato {
    
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
}
