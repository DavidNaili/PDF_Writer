package main.java.com.Projekt.PDFWriter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class Document_Creation {

   /**
    * @param args
    * @throws IOException
    */

    static String jdbcURL = "jdbc:h2:~/PDF Dateien schreiben";
    static String username = "Naili";
    static String password = "nami1980";

   public static void main(String args[]) throws IOException, SQLException {

      Connection connection = DriverManager.getConnection(jdbcURL, username, password);
      System.out.println("Mit eingebetteter H2 Datenbank verbunden.");

      connection.close();

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
      document.save("F:/Projekt/PDF Dateien schreiben/PDF writer/Dokumente/Testfile.pdf");

      // Konsolenausgabe
      System.out.println("PDF erfolgreich erstellt");

      // Schließen des Dokuments
      document.close();

   }
}
