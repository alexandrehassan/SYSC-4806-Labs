package com.example;

public class InvalidAddressBookException extends RuntimeException{
    public InvalidAddressBookException(Long id){
        super("Could not find AddressBook " + id);
    }
}
