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
        Progetto p = Progetto.caricaProgetto(fileProgetto);
        Capitolato c = Capitolato.caricaCapitolato();
        
        PDDocument document = new PDDocument();
        PDPage blankPage = new PDPage();
        document.addPage(blankPage);

        PDDocumentInformation pdd = document.getDocumentInformation();
        pdd.setAuthor(p.getUtente().getTecnico());
        pdd.setTitle(computo.getNome());
        pdd.setCreator(p.getUtente().getCognome()+" "+p.getUtente().getNome());
        pdd.setSubject("Computo metrico");

        Calendar date = new GregorianCalendar();
        String dateFields[] = computo.getData().split("-");
        date.set(new Integer(dateFields[0]), new Integer(dateFields[1]), new Integer(dateFields[2]));
        pdd.setCreationDate(date);
        

        //Setting keywords for the document 
        pdd.setKeywords("sample, first example, my pdf");

        //Saving the document 
        document.save("my_doc.pdf");

        System.out.println("Properties added successfully ");

        
        
        if(cliente) {
            
        } else {
            
        }
        
        //Closing the document
        document.close();
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
