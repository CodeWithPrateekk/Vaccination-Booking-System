package com.example.VaccinationBookingSystems.Model;

import com.example.VaccinationBookingSystems.Enum.CenterType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class VaccinationCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    CenterType centerType;

    String address;

    String centerName;

//    @OneToMany
//    Doctor doctor;


}
