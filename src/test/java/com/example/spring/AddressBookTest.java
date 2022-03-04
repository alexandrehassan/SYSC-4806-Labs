package com.example.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest{
    private AddressBook addressBook;
    private String name;
    private BuddyInfo buddyInfo;
    @BeforeEach
    void setUp(){
        addressBook = new AddressBook();
        name = "test";
        buddyInfo = new BuddyInfo();
    }

    @Test
    void userName(){
        addressBook.setUserName(name);
        assertEquals(name, addressBook.getUserName());
    }

    @Test
    void ID(){
        assertEquals(addressBook.getAddressBookId(), addressBook.getId());
    }

    @Test
    void buddies(){
        addressBook.addBuddy(buddyInfo);
        assertEquals(1, addressBook.getNumBuddies());
        assertEquals(buddyInfo, addressBook.getBuddies().get(0));
        assertEquals(addressBook.getAddressBookId(), buddyInfo.getAddressBookId());
    }

}