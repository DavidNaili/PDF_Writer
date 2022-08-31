package main.java.com.Projekt.PDFWriter;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;

public class Protection {

    void sicherheit(PDDocument document) throws IOException {
        
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

