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
public class Progetto implements Serializable{

    private final Cliente cliente;
    private LinkedList<Computo> listaComputi;

    public Progetto(Cliente cliente) {
        this.cliente = cliente;
        this.listaComputi = new LinkedList<>();
    }

    public Cliente getUtente() {
        return cliente;
    }

    public LinkedList<Computo> getListaComputi() {
        return listaComputi;
    }

    public void aggiungiComputo(Computo computo) {
        listaComputi.add(computo);
    }

    public void rimuoviComputo(Computo computo) {
        listaComputi.remove(computo);
    }
    
    public boolean salvaProgetto(String path) {
        return Pickle.save(path, this);
    }
    
    public static Progetto caricaProgetto(String path) {
        return (Progetto) Pickle.load(path);
    }
}
