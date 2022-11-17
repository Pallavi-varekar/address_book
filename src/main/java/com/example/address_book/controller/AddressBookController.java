package com.example.address_book.controller;

import com.example.address_book.dto.AddressBookDto;
import com.example.address_book.dto.AddressBookResponseDto;
import com.example.address_book.model.AddressBookModel;
import com.example.address_book.service.AddressBookService;
import com.example.address_book.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.util.List;
@RequestMapping("/address")
@RestController
public class AddressBookController {
    @Autowired
    IAddressBookService IAddressBookService;
    @PostMapping("/post")
    public String post(){
        return AddressBookService.printMessages();
    }
    @PostMapping("/insert")
    public ResponseEntity<AddressBookResponseDto> fillInformationOfPerson(@Valid @RequestBody AddressBookDto addressBookDto){
        return IAddressBookService.fillInformationOfPerson(addressBookDto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBookResponseDto> getpersondetailsbyId(@PathVariable int id){
        return  IAddressBookService.getpersondetailsbyId(id);
    }

    @GetMapping("/searchAllPerson")
    public ResponseEntity<AddressBookResponseDto> searchAllPersonInAddressBook(){
        return IAddressBookService.searchAllPersonInAddressBook();
    }
    @GetMapping("/searchPersonByName/{firstName}")
    public ResponseEntity<AddressBookResponseDto> searchPersonInAddressBook(@PathVariable String firstName){
        return IAddressBookService.findPersonByNameInAddressBook(firstName);
    }
    @PutMapping(value = "/update/{id}")
    public  ResponseEntity<AddressBookResponseDto> editPersonDetails(@RequestBody AddressBookDto addressBookDto,
                                                                 @PathVariable int id){
        return IAddressBookService.editPersonDetails(id,addressBookDto);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<AddressBookResponseDto> deletePersonDetails(@PathVariable int id){
        return IAddressBookService.deletePersonDetails(id);
    }


}
