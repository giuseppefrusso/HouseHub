/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author Pepito
 */
public class Capitolato {
    
    private List<Voce> capitolatoClienti, capitolatoSubappaltatori;
    
    public Capitolato() {
        capitolatoClienti = new LinkedList<>();
        capitolatoSubappaltatori = new LinkedList<>();
    }
    
    
    
}
