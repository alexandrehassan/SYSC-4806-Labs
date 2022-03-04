package com.example.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the address book application.
 *
 * @author Alexandre Hassan
 * @version March 03, 2022
 */
@RestController
public class AddressBookController{
    @Autowired
    AddressBookRepository addressBookRepository;
    @Autowired
    BuddyInfoRepository buddyInfoRepository;

    @PostMapping("/AddressBook/new")
    public void newAddressBook(@RequestBody AddressBook book){
        addressBookRepository.save(book);

    }

    @PostMapping("/AddressBook/addBuddy")
    public void addBuddy(@RequestBody BuddyInfo buddy){
        AddressBook book = addressBookRepository.findAddressBookById(buddy.getAddressBookId());
        buddyInfoRepository.save(buddy);
        book.addBuddy(buddy);
        addressBookRepository.save(book);
    }

}
