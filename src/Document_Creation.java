import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class Document_Creation {

   /**
    * @param args
    * @throws IOException
    */
   public static void main(String args[]) throws IOException {

      // Creating PDF document object
      PDDocument document = new PDDocument();

      for (int i = 0; i < 10; i++) {
         // Creating a blank page
         PDPage blankPage = new PDPage();

         // Adding the blank page to the document
         document.addPage(blankPage);
      }

      // Saving the document
      document.save("F:/Projekt/PDF Dateien schreiben/PDF writer/Dokumente/Leere PDF.pdf");

      System.out.println("PDF erfolgreich erstellt");

      // Closing the document
      document.close();

   }
}