package com.example.VaccinationBookingSystems.dto.RequestDto;

import com.example.VaccinationBookingSystems.Enum.DoseType;
import jakarta.persistence.Access;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BookDose1RequestDto {
    int personId;
    DoseType doseType;
}
