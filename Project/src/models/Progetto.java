/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import utils.Pickle;

/**
 *
 * @author Pepito
 */
public class Progetto implements Serializable{

    private final Cliente cliente;
    private HashMap<String, Computo> listaComputi;

    public Progetto(Cliente cliente) {
        this.cliente = cliente;
        this.listaComputi = new HashMap<>();
    }

    public Cliente getUtente() {
        return cliente;
    }

    public HashMap<String, Computo> getListaComputi() {
        return listaComputi;
    }

    public Computo aggiungiComputo(Computo computo) {
        return listaComputi.put(computo.getNome(), computo);
    }

    public Computo rimuoviComputo(Computo computo) {
        return listaComputi.remove(computo.getNome());
    }
    
    public void salvaProgetto(String path) throws FileNotFoundException, IOException {
        Pickle.save(path, this);
    }
    
    public static Progetto caricaProgetto(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
        return (Progetto) Pickle.load(path);
    }
}
