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
public class Cliente {
    private final String nome;
    private final String cognome;
    private final String telefono;
    private final String indirizzoCantiere;
    private final String email;
    private final String tecnico;

    public Cliente(String nome, String cognome, String telefono, String indirizzoCantiere, String email, String tecnico) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.indirizzoCantiere = indirizzoCantiere;
        this.email = email;
        this.tecnico = tecnico;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getIndirizzoCantiere() {
        return indirizzoCantiere;
    }

    public String getEmail() {
        return email;
    }

    public String getTecnico() {
        return tecnico;
    }
    
    
    
}
