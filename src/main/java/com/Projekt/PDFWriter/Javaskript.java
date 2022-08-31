package main.java.com.Projekt.PDFWriter;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionJavaScript;

public class Javaskript {

    void loadPDF(File file) throws IOException {
        // Ein existierendes Dokument laden
        PDDocument document = Loader.loadPDF(file);{

        String javaScript = "app.alert( {cMsg: 'Dies ist ein Beispiel', nIcon: 3,"
                + " nType: 0, cTitle: 'PDFBox Javascript example’} );";

        // PDActionJavaScript Objekt erzeugen
        PDActionJavaScript PDAjavascript = new PDActionJavaScript(javaScript);

        // Java Skript einbetten
        document.getDocumentCatalog().setOpenAction(PDAjavascript);
        }
        
    }
}