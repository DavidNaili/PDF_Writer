package main.java.com.Projekt.PDFWriter.Main;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import main.java.com.Projekt.PDFWriter.Klassen.BildHinzufuegen;
import main.java.com.Projekt.PDFWriter.Klassen.DDocumentInformation;
import main.java.com.Projekt.PDFWriter.Klassen.H2Database;
import main.java.com.Projekt.PDFWriter.Klassen.Protection;
import main.java.com.Projekt.PDFWriter.Klassen.Rechteck;
import main.java.com.Projekt.PDFWriter.Klassen.Textverarbeitung;

@SpringBootApplication

public class Application {


   public static void main(String args[]) throws IOException, SQLException {
      SpringApplication.run(Application.class, args);
 
      // Erstellen einer neuen Datenbank und mit dieser verbinden
      H2Database Datenbank = new H2Database();
      Datenbank.datenbank();

      // Erstellen eines PDF Dokuments
      PDDocument document = new PDDocument();

      // In dieser Schleife werden Seiten erstellt
      for (int i = 0; i < 3; i++) {
         // Erstellen einer leeren Seite
         PDPage blankPage = new PDPage();

         // Leere Seiten dem Dokument hinzufügen
         document.addPage(blankPage);
      }

      Textverarbeitung Text = new Textverarbeitung();
      Text.text(document);

      BildHinzufuegen Bild = new BildHinzufuegen();
      Bild.bild(document);

      Rechteck Struktur = new Rechteck();
      Struktur.struktur(document);

      DDocumentInformation Information = new DDocumentInformation();
      Information.information(document);

      Protection Sicherheit = new Protection();
      Sicherheit.sicherheit(document);

      // Speichern des Dokuments
      document.save("F:/Projekt/PDF Dateien schreiben/PDF writer/Dokumente/Formular.pdf");

      // Konsolenausgabe
      System.out.println("PDF erfolgreich erstellt");

      // Schließen des Dokuments
      document.close();
   }
}