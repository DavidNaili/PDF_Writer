import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;

public class RemovingPages {

   public static void main(String args[]) throws IOException {

      // Ein existierendes Dokument laden
      File file = new File("F:/Projekt/PDF Dateien schreiben/PDF writer/Dokumente/Leere PDF.pdf");
      PDDocument document = Loader.loadPDF(file);{
       
      // Auflistung der vorhandenen Seiten
      int noOfPages= document.getNumberOfPages();
      System.out.print(noOfPages);
       
      // Entfernen der Seiten
      document.removePage(8);
      document.removePage(7);
      
      System.out.println("Seiten entfernt");

      // Dokument speichern
      document.save("F:/Projekt/PDF Dateien schreiben/PDF writer/Dokumente/Leere PDF.pdf");

      // Dokument schließen
      document.close();

      }
   }
}