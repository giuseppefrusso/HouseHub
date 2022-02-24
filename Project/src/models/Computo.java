/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;

/**
 *
 * @author Pepito
 */
public class Computo implements Serializable{
    
    private final String nome, data;
    private double totale;
    private HashSet<VoceComputo> listaVoci;
    
    public Computo(String nome) {
        this.nome = nome;
        this.data = LocalDate.now().toString();
        totale = 0.0;
        listaVoci = new HashSet<>();
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
        boolean result = listaVoci.add(voce);
        if(result)
            totale += voce.getPrezzoComplessivo();
        return result;
    }
    
    public boolean rimuoviVoce(VoceComputo voce) {
        boolean result = listaVoci.remove(voce);
        if(result)
            totale -= voce.getPrezzoComplessivo();
        return result;
    }
    
    public HashSet<VoceComputo> getVociComputo() {
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
