/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfgenerator;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.*;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.*;
import com.itextpdf.layout.element.*;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import models.*;

/**
 *
 * @author Pepito
 */
public class PDFGenerator {

    public static void generatePDF(String fileProgetto, Computo computo, String PDFfilepath, boolean cliente) throws IOException, ClassNotFoundException {
        //Load necessary files
        Progetto progetto = Progetto.caricaProgetto(fileProgetto);
        Capitolato capitolato = Capitolato.caricaCapitolato();
        Cliente utente = progetto.getUtente();
        //

        PdfWriter writer = new PdfWriter(PDFfilepath);

        // Creating a PdfDocument       
        PdfDocument pdf = new PdfDocument(writer);

        try (Document document = new Document(pdf)) {
            //Dichiarazione delle variabili;
            Paragraph paragraph;
            Text text;
            Table table;
            Cell cell;
            PdfFont helveticaBold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);

            //Intestazione del computo metrico
            paragraph = new Paragraph("COMPUTO METRICO");
            document.add(paragraph);

            paragraph = new Paragraph("Committente: " + utente.getNome() + " " + utente.getCognome());
            document.add(paragraph);

            paragraph = new Paragraph("Indirizzo del cantiere: " + utente.getIndirizzoCantiere());
            document.add(paragraph);

            paragraph = new Paragraph("Tecnico: " + utente.getTecnico());
            document.add(paragraph);

            document.add(new AreaBreak());

            table = new Table(9);

            //Intestazione della tabella
            cell = new Cell(2, 1);
            cell.add(new Paragraph("Num. ord.\nTariffa").setFont(helveticaBold));
            table.addHeaderCell(cell);

            cell = new Cell(2, 1);
            cell.add(new Paragraph("Designazione dei lavori").setFont(helveticaBold));
            table.addHeaderCell(cell);

            cell = new Cell(1, 4);
            cell.add(new Paragraph("Dimensioni").setFont(helveticaBold));
            table.addHeaderCell(cell);

            cell = new Cell(2, 1);
            cell.add(new Paragraph("Quantità").setFont(helveticaBold));
            table.addHeaderCell(cell);

            cell = new Cell(1, 2);
            cell.add(new Paragraph("Importi").setFont(helveticaBold));
            table.addHeaderCell(cell);

            cell = new Cell(1, 1);
            cell.add(new Paragraph("Par. ug.").setFont(helveticaBold));
            table.addHeaderCell(cell);
            cell = new Cell(1, 1);
            cell.add(new Paragraph("Lung.").setFont(helveticaBold));
            table.addHeaderCell(cell);
            cell = new Cell(1, 1);
            cell.add(new Paragraph("Larg.").setFont(helveticaBold));
            table.addHeaderCell(cell);
            cell = new Cell(1, 1);
            cell.add(new Paragraph("H/peso").setFont(helveticaBold));
            table.addHeaderCell(cell);

            cell = new Cell(1, 1);
            cell.add(new Paragraph("Unitario").setFont(helveticaBold));
            table.addHeaderCell(cell);
            cell = new Cell(1, 1);
            cell.add(new Paragraph("Totale").setFont(helveticaBold));
            table.addHeaderCell(cell);
            //
            
            for(Integer numProgr : computo.getVociComputo().keySet()) {
                VoceComputo vc = computo.getVociComputo().get(numProgr);
                String codice = vc.getCodice();
                String descrizione;
                
                if(cliente) {
                    descrizione = vc.getDescrizione();
                } else {
                    descrizione = capitolato.getCapitolatoSubappaltatori().get(codice).getDescrizione();
                }
                
                cell = new Cell(1, 1);
                cell.add(new Paragraph(numProgr.toString()+"\n"+codice));
                table.addCell(cell);
                
                cell = new Cell(1, 1);
                cell.add(new Paragraph(descrizione));
                table.addCell(cell);
            }

            document.add(table);
        }

        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(new File(PDFfilepath));
        }
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "C:\\Users\\Pepito\\Desktop\\";
        String fileProgetto = filePath + "progetto.hhp";
        String nomeComputo = "computo1";

        Progetto p = Progetto.caricaProgetto(fileProgetto);
        Computo c = p.getListaComputi().get(nomeComputo);

        String filePDF = filePath + nomeComputo + "_cliente.pdf";
        PDFGenerator.generatePDF(fileProgetto, c, filePDF, true);
    }

}

//OPENPDF
/*try (Document document = new Document()) {
            PdfWriter.getInstance(document, new FileOutputStream(PDFfilepath));
            document.open();

            //Dichiarazione delle variabili;
            Paragraph paragraph;
            Font font;
            PdfPTable table;
            PdfPCell cell;

            //Intestazione del computo metrico
            paragraph = new Paragraph("COMPUTO METRICO");
            document.add(paragraph);

            paragraph = new Paragraph("Committente: " + u.getNome() + " " + u.getCognome());
            document.add(paragraph);

            paragraph = new Paragraph("Indirizzo del cantiere: " + u.getIndirizzoCantiere());
            document.add(paragraph);

            paragraph = new Paragraph("Tecnico: " + u.getTecnico());
            document.add(paragraph);

            document.newPage();
            //

            //Intestazione della tabella
            font = new Font(Font.HELVETICA, 12, Font.BOLD);
            table = new PdfPTable(9);

            cell = new PdfPCell(new Paragraph("Numero ordine\nTariffa", font));
            cell.setRowspan(2);
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("Designazione dei lavori", font));
            cell.setRowspan(2);
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("Dimensioni", font));
            cell.setColspan(4);
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("Quantità", font));
            cell.setRowspan(2);
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("Importi", font));
            cell.setColspan(2);
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("Parti uguali", font));
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("Lunghezza", font));
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("Larghezza", font));
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("Altezza/peso", font));
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("Unitario", font));
            table.addCell(cell);
            cell = new PdfPCell(new Paragraph("Totale", font));
            table.addCell(cell);

            table.setHeaderRows(2);

            document.add(table);
        }*/
