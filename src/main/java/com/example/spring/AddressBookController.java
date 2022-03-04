package com.example.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for the address book application.
 * @author Alexandre Hassan
 * @version March 03, 2022
 */
@Controller
public class AddressBookController {
    //Add address book repository
    @Autowired
    AddressBookRepository addressBookRepository;

    //add buddy info repository
    @Autowired
    BuddyInfoRepository buddyInfoRepository;


    @PostMapping("/AddressBook/new")
    public void newAddressBook(@RequestBody AddressBook book) {
        addressBookRepository.save(book);
    }


    @PostMapping("/AddressBook/addBuddy")
    public void addBuddy(@RequestBody BuddyInfo buddy) {
        AddressBook book = addressBookRepository.findAddressBookById(buddy.getAddressBookId());
        buddyInfoRepository.save(buddy);
        book.addBuddy(buddy);
        addressBookRepository.save(book);
    }

}
