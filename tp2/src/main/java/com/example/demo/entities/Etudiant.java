package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name="Etudiant")
@Data @NoArgsConstructor @AllArgsConstructor @Setter @Getter
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="Registration_number",unique = true)
    private String registration_num;
    @Column(name = "Name",length = 30,nullable = false)
    private String fullName;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    private Boolean stillActive;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastConnection;
}
