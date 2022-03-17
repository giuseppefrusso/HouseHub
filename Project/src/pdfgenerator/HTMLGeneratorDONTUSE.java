/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfgenerator;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringJoiner;
import models.*;
import utils.Format;

/**
 *
 * @author Pepito
 */
public class HTMLGeneratorDONTUSE {
    
    public static void generateHTML(String fileProgetto, Computo computo, String HTMLfilepath, boolean cliente) throws IOException, FileNotFoundException, ClassNotFoundException {
        //Load necessary files
        Progetto progetto = Progetto.caricaProgetto(fileProgetto);
        Capitolato capitolato = Capitolato.caricaCapitolato();
        Cliente utente = progetto.getUtente();
        //
        
        try (FileWriter writer = new FileWriter(HTMLfilepath)) {
            writer.write("<!doctype html>");
            writer.write("<html lang=\"it\">");
            
            writer.write("<head><title>Computo metrico</title>"
                    + "<link href='style.css', rel='stylesheet' type='text/css'>"
                    + "</head>");
            
            writer.write("<body>");
            
            String informationTable = String.format("<table id='client'><tbody>"
                    + "<tr><th>Cliente</th>"
                    + "<td>%s %s</td></tr>"
                    + "<tr><th>Indirizzo del cantiere</th>"
                    + "<td>%s</td></tr>"
                    + "<tr><th>Tecnico</th>"
                    + "<td>%s</td></tr>"
                    + "</tbody></table>", 
                    utente.getNome(),utente.getCognome(),utente.getIndirizzoCantiere(),utente.getTecnico());
            writer.write(informationTable);
            
            writer.write("<br>");
            
            writer.write("<table id='data'><thead>" 
                    + "<tr><th rowspan='2'>N°</th>"
                    + "<th rowspan='2'>Codice</th>"
                    + "<th rowspan='2'>Designazione dei lavori</th>"
                    + "<th colspan='6'>Dimensioni</th>"
                    + "<th rowspan='2'>Quantità</th>"
                    + "<th colspan='2'>Importi</th>"
                    
                    + "</tr><tr><th>Unità di misura</th>"
                    + "<th>Misurazione</th>"
                    + "<th>Parti uguali</th>"
                    + "<th>Lunghezza</th>"
                    + "<th>Larghezza</th>"
                    + "<th>Altezza/peso</th>"
                    + "<th>Unitario</th>"
                    + "<th>Complessivo</th>"
                    + "</tr></thead>");
            
            double totale = cliente ? computo.getTotale() : computo.getTotaleSubappaltatore();
            String footer = String.format("<tfoot><tr><th colspan='11'>Totale</th>"
                    + "<th>%s</th></tr></tfoot>", 
                    Format.formatDouble(totale));
            writer.write(footer);
            
            writer.write("<tbody>");
            for(VoceComputo vc : computo.getVociComputo().values()) {
                String descrizione = cliente ? vc.getDescrizione() : vc.getDescrizioneSubappaltatore();
                StringJoiner joiner = new StringJoiner("", descrizione, "");
                for(Integer n : vc.getVediVoce())
                    joiner.add(String.format("<br>Vedi voce n°%d [%s %s]", n, 
                            computo.getVociComputo().get(n).getUnitaDiMisura(), 
                            computo.getVociComputo().get(n).getQuantita(computo)));
                descrizione = joiner.toString();
                
                String m, pu, lung, larg, altP;
                
                joiner = new StringJoiner("<br>", "", "");
                for(String x : vc.getMisurazioni())
                    joiner.add(x);
                m = joiner.toString();
                
                joiner = new StringJoiner("<br>", "", "");
                for(Double x : vc.getPartiUguali()) 
                    joiner.add(x.toString());
                pu = joiner.toString();
                
                joiner = new StringJoiner("<br>", "", "");
                for(Double x : vc.getLunghezze()) 
                    joiner.add(x.toString());
                lung = joiner.toString();
                
                joiner = new StringJoiner("<br>", "", "");
                for(Double x : vc.getLarghezze()) 
                    joiner.add(x.toString());
                larg = joiner.toString();
                
                joiner = new StringJoiner("<br>", "", "");
                for(Double x : vc.getAltezze_pesi()) 
                    joiner.add(x.toString());
                altP = joiner.toString();
                
                double prezzoUnitario = cliente ? vc.getPrezzoUnitario() : vc.getPrezzoUnitarioSubappaltatore();
                double prezzoComplessivo = cliente ? vc.getPrezzoComplessivo(computo) : vc.getPrezzoComplessivoSubappaltatore(computo);
                String row = String.format("<tr><th>%d</th>"
                        + "<td>%s</td>"
                        + "<td>%s</td>"
                        + "<td>%s</td>"
                        + "<td>%s</td>"
                        + "<td>%s</td>"
                        + "<td>%s</td>"
                        + "<td>%s</td>"
                        + "<td>%s</td>"
                        + "<td>%s</td>"
                        + "<td>%s</td>"
                        + "<td>%s</td></tr>", 
                        vc.getNumeroProgressivo(), vc.getCodice(), descrizione, vc.getUnitaDiMisura(), 
                        m, pu, lung, larg, altP, vc.getQuantita(computo), Format.formatDouble(prezzoUnitario), 
                        Format.formatDouble(prezzoComplessivo));
                writer.write(row);
            }
            writer.write("</tbody></table>");
            
            writer.write("</body>");
            writer.write("</html>");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        String filePath = "C:\\Users\\Pepito\\Desktop\\House Hub Manager\\";
        String fileProgetto = filePath + "progetto.hhp";
        String nomeComputo = "computo";
        
        Progetto p = Progetto.caricaProgetto(fileProgetto);
        Computo c = p.getListaComputi().get(nomeComputo);
        
        String fileHTML = filePath + nomeComputo + "_cliente.html";
        HTMLGeneratorDONTUSE.generateHTML(fileProgetto, c, fileHTML, true);
    }
    
}
