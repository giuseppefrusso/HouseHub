/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfgenerator;

import com.itextpdf.io.image.*;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.extgstate.PdfExtGState;
import com.itextpdf.layout.*;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import models.*;
import utils.Format;

/**
 *
 * @author Pepito
 */
public class PDFGenerator {

    public static void generatePDF(String fileProgetto, Computo computo, String PDFfilepath, boolean cliente) throws IOException, ClassNotFoundException, NullPointerException {
        //Load necessary files
        Progetto progetto = Progetto.caricaProgetto(fileProgetto);
        Capitolato capitolato = Capitolato.caricaCapitolato();
        Cliente utente = progetto.getUtente();
        //

        PdfWriter writer = new PdfWriter(PDFfilepath);
        PdfDocument pdf = new PdfDocument(writer);

        try (Document document = new Document(pdf)) {
            //Dichiarazione delle variabili;
            Paragraph paragraph;
            Table table;
            Cell cell;
            Text text;

            //Intestazione del computo metrico
            paragraph = new Paragraph("COMPUTO METRICO").setBold().setTextAlignment(TextAlignment.CENTER);
            document.add(paragraph);

            paragraph = new Paragraph();
            text = new Text("Committente: ").setBold();
            paragraph.add(text);
            text = new Text(utente.getNome().toUpperCase() + " " + utente.getCognome().toUpperCase());
            paragraph.add(text);
            paragraph.setMargin(50);
            document.add(paragraph);

            paragraph = new Paragraph();
            text = new Text("Indirizzo del cantiere: ").setBold();
            paragraph.add(text);
            text = new Text(utente.getIndirizzoCantiere().toUpperCase());
            paragraph.add(text);
            paragraph.setMargin(50);
            document.add(paragraph);

            paragraph = new Paragraph();
            text = new Text("Tecnico: ").setBold();
            paragraph.add(text);
            text = new Text(utente.getTecnico().toUpperCase());
            paragraph.add(text);
            paragraph.setMargin(50);
            document.add(paragraph);

            document.add(new AreaBreak());

            int numCols = 11;
            table = new Table(numCols);
            table.setFontSize(8);

            //Intestazione della tabella
            cell = new Cell(2, 1);
            cell.add(new Paragraph("N° ord.\nTariffa"));
            cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
            table.addHeaderCell(cell);

            cell = new Cell(2, 1);
            cell.add(new Paragraph("Designazione dei lavori"));
            cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
            cell.setTextAlignment(TextAlignment.CENTER);
            table.addHeaderCell(cell);

            cell = new Cell(1, 6);
            cell.add(new Paragraph("Dimensioni"));
            cell.setTextAlignment(TextAlignment.CENTER);
            table.addHeaderCell(cell);

            cell = new Cell(2, 1);
            cell.add(new Paragraph("Quantità"));
            cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
            table.addHeaderCell(cell);

            cell = new Cell(1, 2);
            cell.add(new Paragraph("Importi"));
            cell.setTextAlignment(TextAlignment.CENTER);
            table.addHeaderCell(cell);

            cell = new Cell(1, 1);
            cell.add(new Paragraph("Un. mis."));
            table.addHeaderCell(cell);

            cell = new Cell(1, 1);
            cell.add(new Paragraph("Misuraz."));
            table.addHeaderCell(cell);

            cell = new Cell(1, 1);
            cell.add(new Paragraph("Par. ug."));
            table.addHeaderCell(cell);

            cell = new Cell(1, 1);
            cell.add(new Paragraph("Lung."));
            table.addHeaderCell(cell);

            cell = new Cell(1, 1);
            cell.add(new Paragraph("Larg."));
            table.addHeaderCell(cell);

            cell = new Cell(1, 1);
            cell.add(new Paragraph("H/peso"));
            table.addHeaderCell(cell);

            cell = new Cell(1, 1);
            cell.add(new Paragraph("Unitario"));
            table.addHeaderCell(cell);

            cell = new Cell(1, 1);
            cell.add(new Paragraph("Compl."));
            table.addHeaderCell(cell);

            //Cambia impostazioni dell'header
            table.getHeader()
                    .setBold()
                    //.setBorder(new SolidBorder(ColorConstants.RED, 2))
                    .setBackgroundColor(ColorConstants.LIGHT_GRAY)
                    .setFontColor(ColorConstants.RED);
            //

            Double totale;

            if (cliente) {
                totale = computo.getTotale();
            } else {
                totale = 0.0;
            }

            for (Integer numProgr : computo.getVociComputo().keySet()) {
                VoceComputo vc = computo.getVociComputo().get(numProgr);
                String codice = vc.getCodice();
                String descrizione;
                Double prezzoUnitario, prezzoComplessivo, quantita = vc.getQuantita(computo);

                if (cliente) {
                    descrizione = vc.getDescrizione();
                    prezzoUnitario = vc.getPrezzoUnitario();
                    prezzoComplessivo = vc.getPrezzoComplessivo(computo);
                } else {
                    Voce sub = capitolato.getCapitolatoSubappaltatori().get(codice);
                    descrizione = sub.getDescrizione();
                    prezzoUnitario = sub.getPrezzoUnitario();
                    prezzoComplessivo = prezzoUnitario * quantita;
                    totale += prezzoComplessivo;
                }

                for (Integer numProgrVediVoce : vc.getVediVoce()) {
                    VoceComputo vediVoce = computo.getVociComputo().get(numProgrVediVoce);
                    String vediVoceInfo = vediVoce.getUnitaDiMisura() + " " + vediVoce.getQuantita(computo);
                    descrizione = descrizione.concat("\n\nVedi voce n°" + numProgrVediVoce + " [" + vediVoceInfo + "]");
                }

                cell = new Cell(1, 1);
                cell.add(new Paragraph(numProgr.toString() + "\n" + codice));
                cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(cell);

                cell = new Cell(1, 1);
                cell.add(new Paragraph(descrizione));
                //cell.setTextAlignment(TextAlignment.JUSTIFIED);
                table.addCell(cell);

                cell = new Cell(1, 1);
                cell.add(new Paragraph(vc.getUnitaDiMisura()));
                table.addCell(cell);

                String misurazioni = "", partiUguali = "", lunghezze = "", larghezze = "", altezze = "";
                if (vc.getMisurazioni().size() == 1 && vc.getPartiUguali().get(0) != 0) {
                    partiUguali = Format.formatDouble(vc.getPartiUguali().get(0));
                    lunghezze = vc.lunghezzeToString();
                    larghezze = vc.larghezzeToString();
                    altezze = vc.altezzePesiToString();
                } else {
                    if (vc.getPartiUguali().get(0) != 0) {
                        misurazioni = misurazioni.concat("\n\n");
                        partiUguali = partiUguali.concat(Format.formatDouble(vc.getPartiUguali().get(0)) + "\n\n");
                        lunghezze = lunghezze.concat(Format.formatDouble(vc.getLunghezze().get(0)) + "\n\n");
                        larghezze = larghezze.concat(Format.formatDouble(vc.getLarghezze().get(0)) + "\n\n");
                        altezze = altezze.concat(Format.formatDouble(vc.getAltezze_pesi().get(0)) + "\n\n");
                    }

                    for (int i = 1; i < vc.getMisurazioni().size(); i++) {
                        misurazioni = misurazioni.concat(vc.getMisurazioni().get(i) + "\n\n");
                        partiUguali = partiUguali.concat(Format.formatDouble(vc.getPartiUguali().get(i)) + "\n\n");
                        lunghezze = lunghezze.concat(Format.formatDouble(vc.getLunghezze().get(i)) + "\n\n");
                        larghezze = larghezze.concat(Format.formatDouble(vc.getLarghezze().get(i)) + "\n\n");
                        altezze = altezze.concat(Format.formatDouble(vc.getAltezze_pesi().get(i)) + "\n\n");
                    }
                }

                cell = new Cell(1, 1);
                cell.add(new Paragraph(misurazioni));
                table.addCell(cell);
                cell = new Cell(1, 1);
                cell.add(new Paragraph(partiUguali));
                table.addCell(cell);
                cell = new Cell(1, 1);
                cell.add(new Paragraph(lunghezze));
                table.addCell(cell);
                cell = new Cell(1, 1);
                cell.add(new Paragraph(larghezze));
                table.addCell(cell);
                cell = new Cell(1, 1);
                cell.add(new Paragraph(altezze));
                table.addCell(cell);

                cell = new Cell(1, 1);
                cell.add(new Paragraph(Format.formatDouble(quantita)));
                table.addCell(cell);

                cell = new Cell(1, 1);
                cell.add(new Paragraph(Format.formatDouble(prezzoUnitario)));
                table.addCell(cell);
                cell = new Cell(1, 1);
                cell.add(new Paragraph(Format.formatDouble(prezzoComplessivo)));
                table.addCell(cell);
            }

            cell = new Cell(1, numCols - 1);
            cell.add(new Paragraph("TOTALE").setBold());
            cell.setTextAlignment(TextAlignment.RIGHT);
            table.addCell(cell);
            cell = new Cell(1, 1);
            cell.add(new Paragraph(Format.formatDouble(totale) + " €").setBold());
            table.addCell(cell);

            document.add(table);
        }

        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(new File(PDFfilepath));
        }
    }

    public static void setBackgroundImage(String PDFfilepath) throws FileNotFoundException, MalformedURLException, IOException {
        String IMAGE = "src\\icons\\logo.png";
        
        PdfWriter writer = new PdfWriter(PDFfilepath);
        PdfDocument pdf = new PdfDocument(writer);

        try (Document document = new Document(pdf)) {
            ImageData image = ImageDataFactory.create(IMAGE);
            PdfCanvas canvas = new PdfCanvas(pdf.addNewPage());
            canvas.saveState();
            PdfExtGState state = new PdfExtGState().setFillOpacity(0.6f);
            Rectangle rect = new Rectangle(0, 0);
            canvas.addImageFittedIntoRectangle(image, rect, false);
            canvas.restoreState();
            document.add(new Paragraph("Ciao!"));
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
        String filePath = "C:\\Users\\Pepito\\Desktop\\House Hub Manager\\";
        String fileProgetto = filePath + "progetto.hhp";
        String nomeComputo = "computo1";

        Progetto p = Progetto.caricaProgetto(fileProgetto);
        Computo c = p.getListaComputi().get(nomeComputo);

        String filePDF = filePath + nomeComputo + "_cliente.pdf";
        //PDFGenerator.generatePDF(fileProgetto, c, filePDF, true);
        PDFGenerator.setBackgroundImage(filePDF);
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
