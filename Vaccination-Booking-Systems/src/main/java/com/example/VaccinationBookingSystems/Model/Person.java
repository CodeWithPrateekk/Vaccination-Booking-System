package com.example.VaccinationBookingSystems.Model;

import com.example.VaccinationBookingSystems.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter


public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    @Column(unique = true)
    String emailId;

    @Enumerated(EnumType.STRING)
    Gender gender;

    boolean isDose1Taken;
    boolean isDose2Taken;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    List<Dose> dosesTaken = new ArrayList<>();

    @OneToOne(mappedBy = "person",cascade=CascadeType.ALL)
    Certificate certificate;
}
