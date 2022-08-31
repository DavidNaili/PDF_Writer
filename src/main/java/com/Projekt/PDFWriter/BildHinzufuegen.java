package main.java.com.Projekt.PDFWriter;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class BildHinzufuegen {

    void loadPDF(File file) throws IOException {
        
        // Ein existierendes Dokument laden
        PDDocument document = Loader.loadPDF(file);{

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
        }
    }
}
