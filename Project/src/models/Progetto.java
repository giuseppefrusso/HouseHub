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
public class Progetto {

    private Cliente cliente;
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
}
