package org.example.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonalInformationDTO {

    private String firstName;
    private String lastName;
    private String email;

}
