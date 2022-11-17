package com.example.address_book.service;

import com.example.address_book.dto.AddressBookDto;
import com.example.address_book.dto.AddressBookResponseDto;
import com.example.address_book.model.AddressBookModel;
import org.springframework.http.ResponseEntity;

public interface IAddressBookService {

    public ResponseEntity<AddressBookResponseDto> fillInformationOfPerson(AddressBookDto addressBookDto);
    public ResponseEntity<AddressBookResponseDto> getpersondetailsbyId(int id);
    public ResponseEntity<AddressBookResponseDto> deletePersonDetails(int id);
    public ResponseEntity<AddressBookResponseDto> searchAllPersonInAddressBook();
    public ResponseEntity<AddressBookResponseDto> editPersonDetails(int id, AddressBookDto addressBookDto);

    ResponseEntity<AddressBookResponseDto> findPersonByNameInAddressBook(String firstName);
}
