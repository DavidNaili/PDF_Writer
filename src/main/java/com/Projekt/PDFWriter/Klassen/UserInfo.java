package main.java.com.Projekt.PDFWriter.Klassen;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.context.annotation.Role;
import lombok.Data;

@Data
@Entity
public class UserInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String firstName;
  private String lastName;
  private Role role;
  private boolean active = true;
  private LocalDateTime createdAt = LocalDateTime.now();
}
