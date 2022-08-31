package main.java.com.Projekt.PDFWriter;

import java.io.File;
import java.io.IOException;

import java.awt.Color;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

public class Rechteck {

    void loadPDF(File file) throws IOException {
        
        // Ein existierendes Dokument laden
        PDDocument document = Loader.loadPDF(file);{

            // Die Seitenanzahl des Dokumentes ermitteln
            PDPage page = document.getPage(0);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Farbe setzen
            contentStream.setNonStrokingColor(Color.BLACK);

            // Rechteck zeichnen
            contentStream.addRect(200, 650, 100, 100);

            // Rechteck ausfüllen
            contentStream.fill();

            System.out.println("Rechteck hinzugefügt");
            contentStream.close();
        }
    }
}
