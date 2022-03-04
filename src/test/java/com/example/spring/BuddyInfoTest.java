package com.example.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuddyInfoTest{
    BuddyInfo buddyInfo;

    @BeforeEach
    void setUp(){
        buddyInfo = new BuddyInfo();
    }

    @Test
    void constructorTest(){
        assertNotNull(buddyInfo);
        assertEquals(0L, buddyInfo.getAddressBookId(), "ID");
        assertEquals("", buddyInfo.getPhone(), "Phone");
        assertEquals("", buddyInfo.getName(), "Name");
    }

    @Test
    void phone(){
        buddyInfo.setPhone("1234567890");
        assertEquals("1234567890", buddyInfo.getPhone());
    }

    @Test
    void name(){
        buddyInfo.setName("John Doe");
        assertEquals("John Doe", buddyInfo.getName());
    }

    @Test
    void addressBookID(){
        buddyInfo.setAddressBookId(1L);
        assertEquals(1L, buddyInfo.getAddressBookId());
    }

    @Test
    void id(){
        assertNull(buddyInfo.getId());
    }
}