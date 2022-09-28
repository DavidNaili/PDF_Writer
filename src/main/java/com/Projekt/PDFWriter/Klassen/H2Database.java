package main.java.com.Projekt.PDFWriter.Klassen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Database {
    
    /**
    * @param args
    * @throws IOException
    */

    // static String jdbcURL = "jdbc:h2:~/PDF Dateien schreiben"; (Direkt ins user Verzeichnis auf C: = relativer Pfad)
    // static String jdbcURL = "jdbc:h2:file:~/subdirectory/demodb" (in ein Unterverzeichnis vom user Verzeichnis)
    static String jdbcURL = "jdbc:h2:f:/Projekt/PDF Dateien schreiben/PDF writer/Datenbank/H2Database"; // in ein ausgewähltes Verzeichnis = absoluter Pfad
    static String username = "Naili";           // optional, wenn festgelegt muss es allerdings benutzt werden
    static String password = "nami1980";        // optional, wenn festgelegt muss es allerdings benutzt werden

    public void datenbank() throws SQLException {

        Connection connection = DriverManager.getConnection(jdbcURL, username, password);
        System.out.println("Mit eingebetteter H2 Datenbank verbunden.");
        connection.close();
    }
}