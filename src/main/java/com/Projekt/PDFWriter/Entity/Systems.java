package main.java.com.Projekt.PDFWriter.Entity;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="DATEN")
public class Systems {

    private String hostname;
    public String getHostname() {
        return hostname;
    }
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
    private String fqdn;
    private String primaryIPv4Address;
    private String mac;
    private String serial;
    private LocalDateTime timestamp;
    private LocalDateTime lastboot;

    public Systems(final String hostname, final String fqdn, final String primaryIPv4Address, final String mac, final String serial,
            final LocalDateTime timestamp, final LocalDateTime lastboot) {
        this.hostname = hostname;
        this.fqdn = fqdn;
        this.primaryIPv4Address = primaryIPv4Address;
        this.mac = mac;
        this.serial = serial;
        this.timestamp = timestamp;
        this.lastboot = lastboot;
    }
    public static List<Systems> getSystemList() {
        final Systems s1 = new Systems("s1", "s1.fleckerlteppich.frickeldave.de", "192.168.1.1", "001122334401", "abc1", 
            LocalDateTime.of(2022, Month.OCTOBER, 12, 9, 34), LocalDateTime.of(2022, Month.SEPTEMBER, 01, 13, 01));
        final Systems s2 = new Systems("s2", "s2.fleckerlteppich.frickeldave.de", "192.168.1.2", "001122334402", "abc2", 
            LocalDateTime.of(2022, Month.OCTOBER, 12, 9, 35), LocalDateTime.of(2022, Month.SEPTEMBER, 01, 13, 02));
        final Systems s3 = new Systems("s3", "s3.fleckerlteppich.frickeldave.de", "192.168.1.3", "001122334403", "abc3", 
            LocalDateTime.of(2022, Month.OCTOBER, 12, 9, 36), LocalDateTime.of(2022, Month.SEPTEMBER, 01, 13, 03));
        final List<Systems> systemList = new ArrayList<Systems>();
        systemList.add(s1);
        systemList.add(s2);
        systemList.add(s3);
        return systemList;
    }
    
}
