/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Pepito
 */
public class Progetto {
    private Cliente utente;
    private Computo computo;

    public Progetto(Cliente utente, Computo computo) {
        this.utente = utente;
        this.computo = computo;
    }
    public Progetto(){
        
    }
    
}
