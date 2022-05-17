/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.TreeMap;
import utils.Pickle;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Pepito
 */
public class Capitolato implements Serializable {

    private TreeMap<LocalDateTime, Voce> capitolatoClienti, capitolatoSubappaltatori;
    private static final String FILEPATH = System.getProperty("user.dir") + "/capitolato";

    private static final String FILEPATH_CLIENTI = FILEPATH + "Clienti.csv";
    private static final String FILEPATH_SUBAPPALTATORI = FILEPATH + "Subappaltatori.csv";

    public Capitolato() {
        capitolatoClienti = new TreeMap<>();
        capitolatoSubappaltatori = new TreeMap<>();
    }

    public Voce addVoceCliente(Voce voce) {
        return capitolatoClienti.put(LocalDateTime.now(), voce);
    }

    public Voce addVoceSubappaltori(Voce voce) {
        return capitolatoSubappaltatori.put(LocalDateTime.now(), voce);
    }

    public Voce removeVoceCliente(String codice) {
        for (LocalDateTime key : capitolatoClienti.keySet()) {
            Voce v = capitolatoClienti.get(key);
            if (v.getCodice().equalsIgnoreCase(codice)) {
                return capitolatoClienti.remove(key);
            }
        }
        return null;
    }

    public Voce removeVoceSubappaltatori(String codice) {
        for (LocalDateTime key : capitolatoSubappaltatori.keySet()) {
            Voce v = capitolatoSubappaltatori.get(key);
            if (v.getCodice().equalsIgnoreCase(codice)) {
                return capitolatoSubappaltatori.remove(key);
            }
        }
        return null;
    }

    public Collection<Voce> getCapitolatoClienti() {
        return capitolatoClienti.values();
    }

    public Collection<Voce> getCapitolatoSubappaltatori() {
        return capitolatoSubappaltatori.values();
    }

    public Voce getVoceCliente(String codice) {
        for (LocalDateTime key : capitolatoClienti.keySet()) {
            Voce v = capitolatoClienti.get(key);
            if (v.getCodice().equalsIgnoreCase(codice)) {
                return v;
            }
        }
        return null;
    }

    public Voce getVoceSubappaltatore(String codice) {
        for (LocalDateTime key : capitolatoSubappaltatori.keySet()) {
            Voce v = capitolatoSubappaltatori.get(key);
            if (v.getCodice().equalsIgnoreCase(codice)) {
                return v;
            }
        }
        return null;
    }

    public void salvaCapitolato() throws FileNotFoundException, IOException {
        Pickle.save(FILEPATH + ".hhc", this);
    }

    public void caricaCapitolato() throws FileNotFoundException, IOException, ClassNotFoundException, CsvException, ParseException, InterruptedException {
        int i;
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        NumberFormat format = NumberFormat.getInstance(Locale.ITALY);

        capitolatoClienti.clear();

        try (CSVReader reader = new CSVReaderBuilder(new FileReader(FILEPATH_CLIENTI))
                .withCSVParser(csvParser)
                .withSkipLines(1)
                .build()) {
            List<String[]> lines = reader.readAll();

            for (String[] l : lines) {
                //System.out.println(format.parse(l[3]).doubleValue());
                Voce v = new Voce(l[0], l[1], l[2], format.parse(l[3]).doubleValue());
                capitolatoClienti.put(LocalDateTime.now(), v);
                Thread.sleep(1);
            }
        }

        /*List<Voce> beansC = new CsvToBeanBuilder(new FileReader(FILEPATH_CLIENTI))
                .withSeparator(';')
                .withType(Voce.class)
                .build()
                .parse();

        i = 0;
        for(Voce v : beansC) {
            if(i==1 && !v.getCodice().equalsIgnoreCase("Codice")) 
                capitolatoClienti.put(LocalDateTime.now(), v);
            i++;
        }*/
        capitolatoSubappaltatori.clear();

        try (CSVReader reader = new CSVReaderBuilder(new FileReader(FILEPATH_SUBAPPALTATORI))
                .withCSVParser(csvParser)
                .withSkipLines(1)
                .build()) {
            List<String[]> lines = reader.readAll();

            for (String[] l : lines) {
                //System.out.println(format.parse(l[3]).doubleValue());
                Voce v = new Voce(l[0], l[1], l[2], format.parse(l[3]).doubleValue());
                capitolatoSubappaltatori.put(LocalDateTime.now(), v);
                Thread.sleep(1);
            }
        }

        /*List<Voce> beansS = new CsvToBeanBuilder(new FileReader(FILEPATH_SUBAPPALTATORI))
                .withSeparator(';')
                .withType(Voce.class)
                .build()
                .parse();

        for(Voce v : beansS) {
            if(i==1 && !v.getCodice().equalsIgnoreCase("Codice")) 
                capitolatoSubappaltatori.put(LocalDateTime.now(), v);
            i++;
        }*/
        //return (Capitolato) Pickle.load(FILEPATH);
    }
}
