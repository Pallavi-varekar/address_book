package com.example.address_book.Exception;

import com.example.address_book.dto.AddressBookResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class AddressBookException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AddressBookResponseDto> handleMethodNotValidException(MethodArgumentNotValidException exception){
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMessages = errorList.stream().map(objectErr -> objectErr.getDefaultMessage()).collect(Collectors.toList());
        AddressBookResponseDto addressBookResponseDto = new AddressBookResponseDto("Exception while processing REST Request ",errMessages);
        return new ResponseEntity<>(addressBookResponseDto, HttpStatus.CREATED);
    }

    @ExceptionHandler(AddressBookCustomException.class)
    public ResponseEntity<AddressBookResponseDto> handleException(AddressBookCustomException exception){
        AddressBookResponseDto addressBookResponseDto = new AddressBookResponseDto("Employee Pay roll Exception",exception.getMessage());
        return new  ResponseEntity<> (addressBookResponseDto,HttpStatus.BAD_REQUEST);
    }
}
