package com.example.address_book.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressBookResponseDto {
    private String message;
    private Object data;

    public AddressBookResponseDto(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
