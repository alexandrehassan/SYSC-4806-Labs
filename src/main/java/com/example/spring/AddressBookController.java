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

    /**
     * Controller to create a new addressbook using a POST request using JSON
     * Used in js ajax call
     * can be run using a curl or http request, an example request can be found in the http folder "NewAddressBook"
     */
    @PostMapping("/AddressBook/new")
    public void newAddressBook(@RequestBody AddressBook book) {
        addressBookRepository.save(book);
    }

    /**
     * Controller to create a new buddy in an addressbook using a POST request using JSON
     * Can only be used once an addressbook has been made
     * used in js ajax call
     * can be run using a curl or http request, an example request can be found in the http folder "AddBuddy"
     */
    @PostMapping("/AddressBook/addBuddy")
    public void addBuddy(@RequestBody BuddyInfo buddy) {
        AddressBook book = addressBookRepository.findAddressBookById(buddy.getAddressBookId());
        buddyInfoRepository.save(buddy);
        book.addBuddy(buddy);
        addressBookRepository.save(book);
    }

    /**
     * Controller to show New Address Book Page form
     *
     */
    @GetMapping("/newAddressBook")
    public String newAddressBookForm(Model model) {
        model.addAttribute("addressbook", new AddressBook());
        return "newaddressbook";
    }

    /**
     *Controller used on new address book form submission to save new book and show all saved books
     */
    @PostMapping("/newAddressBook")
    public String newAddressBookSubmit(@ModelAttribute AddressBook addressBook, Model model) {
        addressBookRepository.save(addressBook);
        model.addAttribute("addressbooks", addressBookRepository.findAll());
        model.addAttribute("addressbook", addressBook);
        return "newaddressbook";
    }

    /**
     *Controller used to show view address book page
     * gets saved address books and gives to model to show
     */
    @GetMapping("/viewAddressBooks")
    public String viewAddressBooks(Model model) {
        model.addAttribute("addressbooks", addressBookRepository.findAll());
        return "viewaddressbooks";
    }

    /**
     *Controller to show add buddy form
     * Auto shows first address book to display, but buddy can be added to any saved addressbook using the aBID
     */
    @GetMapping("/addBuddy")
    public String addBuddyForm(Model model) {
        AddressBook addressBook = addressBookRepository.findAddressBookById(1L);
        if (addressBook == null) {
            addressBook = new AddressBook("Address Book");
        }
        BuddyInfo buddy = new BuddyInfo();
        model.addAttribute("addressbook", addressBook);
        model.addAttribute("buddy", buddy);
        return "addbuddy";
    }

    /**
     * Controller to submit add buddy form
     * saves new buddy, gets the address book it is to be added to, adds it, saves addressbook, and displays the buddy and addressbook
     */
    @PostMapping("/addBuddy")
    public String addBuddySubmit(@ModelAttribute BuddyInfo buddyInfo, Model model) {
        buddyInfoRepository.save(buddyInfo);
        AddressBook book = addressBookRepository.findAddressBookById(buddyInfo.getAddressBookId());
        book.addBuddy(buddyInfo);
        addressBookRepository.save(book);
        model.addAttribute("buddy", buddyInfo);
        model.addAttribute("addressbook", book);
        return "addbuddy";
    }
}
