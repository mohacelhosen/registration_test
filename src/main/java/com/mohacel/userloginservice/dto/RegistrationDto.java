package com.mohacel.userloginservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {
    private Integer userId;
    private String name;
    private String email;
    private String gender;
    private LocalDate dob;
    private String department;
    private AddressDto address;
}
