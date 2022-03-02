/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfgenerator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import models.Capitolato;
import models.Computo;
import models.Progetto;
import org.apache.pdfbox.pdmodel.*;

/**
 *
 * @author Pepito
 */
public class PDFGenerator {

    public static void generatePDF(String fileProgetto, Computo computo, String PDFfilepath, boolean cliente) throws IOException, ClassNotFoundException {
        //Load necessary files
        Progetto p = Progetto.caricaProgetto(fileProgetto);
        Capitolato c = Capitolato.caricaCapitolato();
        //
        
        //Create blank document
        PDDocument document = new PDDocument();
        PDPage blankPage = new PDPage();
        document.addPage(blankPage);
        //

        //Set document properties
        PDDocumentInformation pdd = document.getDocumentInformation();
        pdd.setAuthor(p.getUtente().getTecnico());
        pdd.setTitle(computo.getNome());
        pdd.setCreator(p.getUtente().getCognome()+" "+p.getUtente().getNome());
        pdd.setSubject("Computo metrico");

        Calendar date = new GregorianCalendar();
        System.out.println(computo.getData());
        String dateFields[] = computo.getData().split("-");
        Integer year = new Integer(dateFields[0]), month = new Integer(dateFields[1]), dayOfMonth = new Integer(dateFields[2]);
        date.set(year, month, dayOfMonth);
        pdd.setCreationDate(date);
        //

        if(cliente) {
            
        } else {
            
        }
        
        //Save document
        document.save(PDFfilepath);
        document.close();
        System.out.println("Saved document");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Creating PDF document object
        PDDocument document = new PDDocument();

        //Creating a blank page
        PDPage blankPage = new PDPage();

        //Adding the blank page to the document
        document.addPage(blankPage);

        //Creating the PDDocumentInformation object 
        PDDocumentInformation pdd = document.getDocumentInformation();

        //Setting the author of the document
        pdd.setAuthor("Tutorialspoint");

        // Setting the title of the document
        pdd.setTitle("Sample document");

        //Setting the creator of the document 
        pdd.setCreator("PDF Examples");

        //Setting the subject of the document 
        pdd.setSubject("Example document");

        //Setting the created date of the document 
        Calendar date = new GregorianCalendar();
        date.set(2015, 11, 5);
        pdd.setCreationDate(date);
        //Setting the modified date of the document 
        date.set(2016, 6, 5);
        pdd.setModificationDate(date);

        //Setting keywords for the document 
        pdd.setKeywords("sample, first example, my pdf");

        //Saving the document 
        document.save("my_doc.pdf");

        System.out.println("Properties added successfully ");

        //Closing the document
        document.close();
    }

}
