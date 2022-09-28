package main.java.com.Projekt.PDFWriter.Klassen;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

public class Textverarbeitung {

    public void text(PDDocument document) throws IOException {

            // Die Seitenanzahl des Dokumentes ermitteln
            PDPage page = document.getPage(0);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Anfangspunkt des Textes
            contentStream.beginText();

            // Schriftart auswählen
            PDFont font = PDType0Font.load(document, new File("C:/Windows/Fonts/verdana.ttf"));
            contentStream.setFont(font, 20);

            contentStream.setLeading(19.5f);

            // Zeilenposition einstellen
            contentStream.newLineAtOffset(25, 730);

            // Text schreiben
            String text1 = "Dies ist mein erster Versuch.";
            String text2 = "Und dies ist die Erweiterung.";
            String text3 = "Noch eine Zeile mehr!";
            String text4 = "Aller guten Dinge sind dieses mal 4.";

            // Text als String hinzufügen
            contentStream.showText(text1);
            // Und um weitere Zeilen erweitern
            contentStream.newLine();
            contentStream.showText(text2);
            contentStream.newLine();
            contentStream.showText(text3);
            contentStream.newLine();
            contentStream.showText(text4);

            // Endpunkt des Textes
            contentStream.endText();

            // Konsolenausgabe
            System.out.println("Text hinzugefügt");

            // Inhaltsstream schließen
            contentStream.close();
        }   
    }

