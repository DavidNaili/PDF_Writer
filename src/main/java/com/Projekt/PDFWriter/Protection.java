package main.java.com.Projekt.PDFWriter;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.Loader;

public class Protection {

    void loadPDF(File file) throws IOException {
        
        // Ein existierendes Dokument laden
        PDDocument document = Loader.loadPDF(file);{

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

            System.out.println("Dokument verschlüsselt");
        }
    }
}
