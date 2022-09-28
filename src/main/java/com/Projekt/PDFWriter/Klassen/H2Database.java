package main.java.com.Projekt.PDFWriter.Klassen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

        Connection conn = DriverManager.getConnection(jdbcURL, username, password);
        System.out.println("Mit eingebetteter H2 Datenbank verbunden.");

        // Statement wird erzeugt und ausgeführt.
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM NAMEN ORDER BY ID");
        ResultSet rs = ps.executeQuery();
        convertResultSetToList(rs);
        rs.close();
        conn.close();
        System.out.println(rs);
    }

        public List<HashMap<String,Object>> convertResultSetToList(ResultSet rs) throws SQLException {
            ResultSetMetaData rsmd = rs.getMetaData();
            int numberOfColumns = rsmd.getColumnCount();
            List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
        
            while (rs.next()) {
                HashMap<String,Object> row = new HashMap<String, Object>(numberOfColumns);
                for(int i=1; i<=numberOfColumns; ++i) {
                    row.put(rsmd.getColumnName(i),rs.getObject(i));
                }
                list.add(row);
                System.out.println(row);
            }
            return list;
    }
}


