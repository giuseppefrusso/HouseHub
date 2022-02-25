/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 *
 * @author Pepito
 */
public class Computo implements Serializable{
    
    private final String nome, data;
    private double totale;
    private HashMap<Integer, VoceComputo> listaVoci;
    
    public Computo(String nome) {
        this.nome = nome;
        this.data = LocalDate.now().toString();
        totale = 0.0;
        listaVoci = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }
    
    public String getData() {
        return data;
    }

    public double getTotale() {
        return totale;
    }
    
    public boolean aggiungiVoce(VoceComputo voce) {
        VoceComputo result = listaVoci.put(voce.getNumeroProgressivo(), voce);
        if(result != null) {
            totale += voce.getPrezzoComplessivo();
            return true;
        }
        return false;
    }
    
    public boolean rimuoviVoce(VoceComputo voce) {
        VoceComputo result = listaVoci.remove(voce.getNumeroProgressivo());
        if(result != null) {
            totale -= voce.getPrezzoComplessivo();
            return true;
        }
        return false;
    }
    
    public void svuotaVociComputo() {
        listaVoci.clear();
    }
    
    public HashMap<Integer, VoceComputo> getVociComputo() {
        return listaVoci;
    }
    
    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Computo other = (Computo) obj;
        return Objects.equals(this.nome, other.nome);
    }
}
