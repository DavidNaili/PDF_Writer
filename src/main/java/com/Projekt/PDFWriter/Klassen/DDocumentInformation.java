package main.java.com.Projekt.PDFWriter.Klassen;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;

public class DDocumentInformation {

    public void information(PDDocument document) throws IOException {

            // Objekt PDDocumentInformation erhalten
            PDDocumentInformation pdd = document.getDocumentInformation();

            // Den Autor des Dokumentes festlegen
            pdd.setAuthor("David Naili");

            // Den Titel des Dokumentes festlegen
            pdd.setTitle("Test Dokument");

            // Den Ersteller des Dokumentes festlegen
            pdd.setCreator("PDF Beispiele");

            // Das Thema des Dokumentes festlegen
            pdd.setSubject("Beispiel Dokument");

            // Das Datum des erstellten Dokumentes festlegen
            Calendar date = new GregorianCalendar();
            date.set(2022, 8, 23);
            pdd.setCreationDate(date);

            // Das Datum des veränderten Dokumentes festlegen
            date.set(2022, 8, 23);
            pdd.setModificationDate(date);

            // Schlüsselwörter für das Dokument festlegen
            pdd.setKeywords("Probe, erstes Beispiel, meine pdf");

            // Infos aus dem PDF Dokument empfangen
            System.out.println("Author of the document is :" + pdd.getAuthor());
            System.out.println("Title of the document is :" + pdd.getTitle());
            System.out.println("Subject of the document is :" + pdd.getSubject());
            System.out.println("Creator of the document is :" + pdd.getCreator());
            // System.out.println("Creation date of the document is :"+
            // pdd.getCreationDate());
            // System.out.println("Modification date of the document is :"+
            // pdd.getModificationDate());
            System.out.println("Keywords of the document are :" + pdd.getKeywords());
            System.out.println("Daten der erstellten PDF hinzugefügt");
        }
    }

