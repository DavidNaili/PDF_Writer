package main.java.com.Projekt.PDFWriter.Klassen;

import java.io.IOException;

import java.awt.Color;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

public class Rechteck {

    public void struktur(PDDocument document) throws IOException {

            // Die Seitenanzahl des Dokumentes ermitteln
            PDPage page = document.getPage(2);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Farbe setzen
            contentStream.setNonStrokingColor(Color.BLACK);

            // Rechteck zeichnen
            contentStream.addRect(100, 450, 150, 100);

            // Rechteck ausfüllen
            contentStream.fill();

            System.out.println("Rechteck hinzugefügt");
            contentStream.close();
        }
    }