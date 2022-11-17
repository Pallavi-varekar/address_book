package com.example.address_book.service;

import com.example.address_book.Exception.AddressBookCustomException;
import com.example.address_book.dto.AddressBookDto;
import com.example.address_book.dto.AddressBookResponseDto;
import com.example.address_book.model.AddressBookModel;
import com.example.address_book.repository.IAddressBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AddressBookService implements IAddressBookService {
    @Autowired
    IAddressBook IAddressBook;
    public static String printMessages() {
        return "Address Book App";
    }
    @Override
    public ResponseEntity<AddressBookResponseDto> fillInformationOfPerson(AddressBookDto addressBookDto) {
        AddressBookModel addressBookModel = new AddressBookModel(addressBookDto);
        IAddressBook.save(addressBookModel);                                              // save in repository
        AddressBookResponseDto addressBookResponseDto = new AddressBookResponseDto(" Successfully Add in database",addressBookDto);
        return new ResponseEntity<>(addressBookResponseDto, HttpStatus.CREATED);
    }
    @Override
    public ResponseEntity<AddressBookResponseDto> deletePersonDetails(int id) {
        Optional<AddressBookModel> addressBookModel = IAddressBook.findById(id);
        if (addressBookModel.isEmpty()){
            throw new AddressBookCustomException("Employee is ID is not fount");
        }else {
            AddressBookResponseDto addressBookResponseDto = new AddressBookResponseDto(" Successfully delete employee ", addressBookModel);
            IAddressBook.delete(addressBookModel.get());                            // delete in repository
            return new ResponseEntity<>(addressBookResponseDto, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<AddressBookResponseDto> getpersondetailsbyId(int id) {
        Optional<AddressBookModel> addressBookModel=IAddressBook.findById(id);          // get Employee in repository
        if (addressBookModel.isEmpty()){
            throw new AddressBookCustomException("Employee is ID is not fount");
        }else {
            AddressBookResponseDto addressBookResponseDto = new AddressBookResponseDto(" Successfully getting employee ",addressBookModel);
            return  new ResponseEntity<>(addressBookResponseDto, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<AddressBookResponseDto> searchAllPersonInAddressBook() {
        List<AddressBookModel> person = IAddressBook.findAll();        // get all Employee in repository
        if (person.isEmpty()){
            throw new AddressBookCustomException("Employee Payroll list is Empty");
        }else {
            AddressBookResponseDto addressBookResponseDto= new AddressBookResponseDto("All Employee Details", person);
            return new ResponseEntity<>(addressBookResponseDto, HttpStatus.OK);
        }
    }
    @Override
    public ResponseEntity<AddressBookResponseDto> findPersonByNameInAddressBook(String name){
        List<AddressBookModel> listperson =  IAddressBook.findPersonByFirstName(name);
        if (listperson.isEmpty()){
            throw new AddressBookCustomException("Person is not Found");
        }else {
            AddressBookResponseDto addressBookResponseDto = new AddressBookResponseDto(" Successfully getting person",listperson);
            return new ResponseEntity<AddressBookResponseDto>(addressBookResponseDto, HttpStatus.CREATED);
        }}

    @Override
    public ResponseEntity<AddressBookResponseDto> editPersonDetails(int id, AddressBookDto addressBookDto){
        Optional <AddressBookModel> addressBookModel = IAddressBook.findById(id);                    // get Employee in repository
        if (addressBookModel.get().getId() == id){
            AddressBookModel employee3 = new AddressBookModel(id,addressBookDto);
            IAddressBook.save(employee3);                                           // update Employee in repository
            AddressBookResponseDto addressBookResponseDto = new AddressBookResponseDto(" Successfully Update ",employee3);
            return  new ResponseEntity<>(addressBookResponseDto, HttpStatus.CREATED);
        }else {
            throw new AddressBookCustomException("Employee is not present");
        }
    }


    }


