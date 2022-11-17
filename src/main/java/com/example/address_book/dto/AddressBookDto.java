package com.example.address_book.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class AddressBookDto {
    @NotEmpty(message = "Person First name is mandatory")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Person First Name Invalid")
    private String firstName;
    @NotEmpty(message = "Person Last name is mandatory")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Person Last Name Invalid")
    private String lastName;
    @NotEmpty(message = "Person address is mandatory")
    private String address;
    @Pattern(regexp = "[0-9]{10}$", message = "Phone Number State Invalid")
    private String phoneNo;
    @NotEmpty(message = "Person State is mandatory")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Person State Invalid")
    private String state;
    @NotEmpty(message = "Person City is mandatory")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Person City Invalid")
    private String city;
    @Pattern(regexp = "^[0-9]{6}$", message = "Zip code State Invalid")
    private String zipCode;
}
