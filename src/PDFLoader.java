import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;

public class PDFLoader {
          
    
    // Loading an existing document
          File file = new File("F:/Projekt/PDF Dateien schreiben/PDF writer/Dokumente/Leere PDF.pdf");
          PDDocument document = PDDocument.load(file);
    
          System.out.println("PDF loaded");
}
