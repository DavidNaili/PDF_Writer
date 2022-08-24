import java.awt.Color;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionJavaScript;

public class Document_Creation {

   /**
    * @param args
    * @throws IOException
    */
   public static void main(String args[]) throws IOException {

      // Erstellen eines PDF Dokuments
      PDDocument document = new PDDocument();

      // In dieser Schleife werden Seiten erstellt
      for (int i = 0; i < 2; i++) {
         // Erstellen einer leeren Seite
         PDPage blankPage = new PDPage();

         // Leere Seiten dem Dokument hinzufügen
         document.addPage(blankPage);
      }
       // Objekt PDDocumentInformation erhalten
       PDDocumentInformation pdd = document.getDocumentInformation();

       // Den Author des Dokumentes festlegen
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
      System.out.println("Author of the document is :"+ pdd.getAuthor());
      System.out.println("Title of the document is :"+ pdd.getTitle());
      System.out.println("Subject of the document is :"+ pdd.getSubject());
      System.out.println("Creator of the document is :"+ pdd.getCreator());
      //System.out.println("Creation date of the document is :"+ pdd.getCreationDate());
      //System.out.println("Modification date of the document is :"+ pdd.getModificationDate()); 
      System.out.println("Keywords of the document are :"+ pdd.getKeywords()); 
       
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
      
      // Anfangspunkt des Textes
      contentStream.beginText();
       
      // Schriftart auswählen
      contentStream.setFont(PDType1Font.TIMES_ROMAN, 20);

      //Setting the leading
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

      // Seite ermitteln die verändert werden soll
      PDPage page1 = document.getPage(1);
       
      // PDImageXObject Objekt erstellen
      PDImageXObject pdImage = PDImageXObject.createFromFile("F:/Haus.PNG", document);
       
      // PDPageContentStream Objekt erstellen
      PDPageContentStream contents = new PDPageContentStream(document, page1);

      // Bild dem PDF Dokument hinzufügen
      contents.drawImage(pdImage, 70, 150);

      System.out.println("Bild eingefügt");
      
      // PDPageContentStream Objekt schließen
      contents.close();

      String javaScript = "app.alert( {cMsg: 'Dies ist ein Beispiel', nIcon: 3,"
      + " nType: 0, cTitle: 'PDFBox Javascript example’} );";

      // PDActionJavaScript Objekt erzeugen
      PDActionJavaScript PDAjavascript = new PDActionJavaScript(javaScript);

      // Java Skript einbetten
      document.getDocumentCatalog().setOpenAction(PDAjavascript);

      // Access permission Objekt erzeugen
      AccessPermission ap = new AccessPermission();         

      // StandardProtectionPolicy Objekt erzeugen
      StandardProtectionPolicy spp = new StandardProtectionPolicy("6227", "6227", ap);
      
      // Länge des Kodierungsschlüssels festlegen
      spp.setEncryptionKeyLength(128);
   
      // Access permissions festlegen
      spp.setPermissions(ap);
      
      // Dokument schützen
      document.protect(spp);
      
      System.out.println("Daten der erstellten PDF hinzugefügt"); 
      System.out.println("Dokument verschlüsselt");

      // Speichern des Dokuments
      document.save("F:/Projekt/PDF Dateien schreiben/PDF writer/Dokumente/Testfile.pdf");

      // Konsolenausgabe
      System.out.println("PDF erfolgreich erstellt");

      // Schließen des Dokuments
      document.close();
   }
}
