/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.HashSet;
import utils.Pickle;

/**
 *
 * @author Pepito
 */
public class Progetto implements Serializable{

    private final Cliente cliente;
    private HashSet<Computo> listaComputi;

    public Progetto(Cliente cliente) {
        this.cliente = cliente;
        this.listaComputi = new HashSet<>();
    }

    public Cliente getUtente() {
        return cliente;
    }

    public HashSet<Computo> getListaComputi() {
        return listaComputi;
    }

    public boolean aggiungiComputo(Computo computo) {
        return listaComputi.add(computo);
    }

    public boolean rimuoviComputo(Computo computo) {
        return listaComputi.remove(computo);
    }
    
    public boolean salvaProgetto(String path) {
        return Pickle.save(path, this);
    }
    
    public static Progetto caricaProgetto(String path) {
        return (Progetto) Pickle.load(path);
    }
}
