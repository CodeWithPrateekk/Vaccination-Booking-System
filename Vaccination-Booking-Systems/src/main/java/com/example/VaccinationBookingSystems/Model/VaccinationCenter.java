package com.example.VaccinationBookingSystems.Model;

import com.example.VaccinationBookingSystems.Enum.CenterType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

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

    @Enumerated(value = EnumType.STRING)
    CenterType centerType;

    String address;

    String centerName;

    @OneToMany(mappedBy = "center",cascade = CascadeType.ALL)
    List<Doctor> doctors = new ArrayList<>();


}
