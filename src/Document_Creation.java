import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class Document_Creation {

   /**
    * @param args
    * @throws IOException
    */
   public static void main(String args[]) throws IOException {

      // Erstellen eines PDF Dokuments
      PDDocument document = new PDDocument();

      // In dieser Schleife werden Seiten erstellt
      for (int i = 0; i < 10; i++) {
         // Erstellen einer leeren Seite
         PDPage blankPage = new PDPage();

         // Leere Seiten dem Dokument hinzufügen
         document.addPage(blankPage);
      }

      // Speichern des Dokuments
      document.save("F:/Projekt/PDF Dateien schreiben/PDF writer/Dokumente/Leere PDF.pdf");

      System.out.println("PDF erfolgreich erstellt");

      // Schließen des Dokuments
      document.close();

   }
}