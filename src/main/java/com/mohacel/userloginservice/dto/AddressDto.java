package com.mohacel.userloginservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Integer addressId;
    private String country;
    private String state;
    private Integer postalCode;
    private String streetAddress;
}
