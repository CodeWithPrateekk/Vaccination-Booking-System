package com.example.VaccinationBookingSystems.dto.RequestDto;

import com.example.VaccinationBookingSystems.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class VaccinationCenterRequestDto {
    CenterType centerType;

    String address;

    String centerName;
}
