/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Pepito
 */
public class Computo implements Serializable{
    
    private final String nome;
    private double totale;
    private List<VoceComputo> listaVoci;
    
    public Computo(String nome) {
        this.nome = nome;
        totale = 0.0;
        listaVoci = new LinkedList<>();
    }

    public String getNome() {
        return nome;
    }

    public double getTotale() {
        return totale;
    }
    
    public void aggiungiVoce(VoceComputo voce) {
        listaVoci.add(voce);
        totale += voce.getPrezzoComplessivo();
    }
    
    public void rimuoviVoce(VoceComputo voce) {
        listaVoci.remove(voce);
        totale -= voce.getPrezzoComplessivo();
    }
    
}
