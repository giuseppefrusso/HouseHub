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
    private LinkedList<Computo> computo;

    public Progetto(Cliente cliente, LinkedList<Computo> computo) {
        this.cliente = cliente;
        this.computo = computo;
    }
    public Progetto(Cliente cliente){
        this.cliente = cliente;
    }

    public Cliente getUtente() {
        return cliente;
    }

    public LinkedList<Computo> getComputo() {
        return computo;
    }
    
}
