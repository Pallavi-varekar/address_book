package com.example.address_book.repository;

import com.example.address_book.model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAddressBook extends JpaRepository<AddressBookModel,Integer> {
   /* @Query(value = "SELECT * FROM  where department = :department", nativeQuery = true)
    List<AddressBookModel> employeeFindByDepartment (String department);*/
   @Query(value = "SELECT * FROM address_book_model where first_name = :first_name", nativeQuery = true)
   List<AddressBookModel> findPersonByFirstName(String first_name);
}
