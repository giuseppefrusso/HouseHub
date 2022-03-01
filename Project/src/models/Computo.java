/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.TreeMap;

/**
 *
 * @author Pepito
 */
public class Computo implements Serializable {

    private final String nome, data;
    private double totale;
    private TreeMap<Integer, VoceComputo> listaVoci;
    private HashSet<String> codici;

    public Computo(String nome) {
        this.nome = nome;
        this.data = LocalDate.now().toString();
        totale = 0.0;
        listaVoci = new TreeMap<>();
        codici = new HashSet<>();
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

    public HashSet<String> getCodici() {
        return codici;
    }

    public boolean aggiungiVoce(VoceComputo voce) {
        VoceComputo result = listaVoci.put(voce.getNumeroProgressivo(), voce);
        if (result != null) {
            totale += result.getPrezzoComplessivo();
            codici.add(result.getCodice());
            return true;
        }
        return false;
    }

    public boolean rimuoviVoce(VoceComputo voce) {
        VoceComputo result = listaVoci.remove(voce.getNumeroProgressivo());
        if (result != null) {
            totale -= voce.getPrezzoComplessivo();
            codici.remove(result.getCodice());
            return true;
        }
        return false;
    }

    public void svuotaVociComputo() {
        listaVoci.clear();
    }

    public TreeMap<Integer, VoceComputo> getVociComputo() {
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

    public static Computo caricaComputoDaProgetto(String fileProgetto, String nomeComputo) throws IOException, ClassNotFoundException {
        Progetto p = Progetto.caricaProgetto(fileProgetto);
        return p.getListaComputi().get(nomeComputo);
    }

    public void salvaComputoInProgetto(String fileProgetto) throws IOException, ClassNotFoundException {
        Progetto p = Progetto.caricaProgetto(fileProgetto);
        p.rimuoviComputo(this);

        p.aggiungiComputo(this);
        p.salvaProgetto(fileProgetto);
    }
}
