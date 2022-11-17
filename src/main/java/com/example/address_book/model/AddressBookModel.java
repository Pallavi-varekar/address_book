package com.example.address_book.model;

import com.example.address_book.dto.AddressBookDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
@Data
@NoArgsConstructor
public class AddressBookModel {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNo;
    private String state;
    private String city;
    private String zipCode;

    public AddressBookModel(int id, AddressBookDto addressBookModel ) {
        this.id = id;
        this.firstName = addressBookModel.getFirstName();
        this.lastName = addressBookModel.getLastName();
        this.address =addressBookModel.getAddress();
        this.phoneNo = addressBookModel.getPhoneNo();
        this.state = addressBookModel.getState();
        this.city = addressBookModel.getCity();
        this.zipCode = addressBookModel.getZipCode();
    }

    public AddressBookModel(AddressBookDto addressBookDto) {
        this.firstName =addressBookDto.getFirstName();
        this.lastName = addressBookDto.getLastName();
        this.address = addressBookDto.getAddress();
        this.phoneNo = addressBookDto.getPhoneNo();
        this.state =addressBookDto.getState();
        this.city = addressBookDto.getCity();
        this.zipCode = addressBookDto.getZipCode();
    }
}