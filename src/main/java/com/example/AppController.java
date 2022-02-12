package com.example;

import com.example.repository.AddressBookRepository;
//import com.example.repository.BuddyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController{


    @Autowired
    AddressBookRepository addressBookRepository;

//    @Autowired
//    BuddyInfoRepository buddyInfoRepository;

    @GetMapping("/")
    public String frontPage(Model model){
        model.addAttribute("books", addressBookRepository.findAll());
        return "index";
    }


    @GetMapping("/new")
    public String newBuddy(Model model){
        AddressBook book = new AddressBook();
        addressBookRepository.save(book);

        model.addAttribute("addressbook", book);
        model.addAttribute("newBuddy", new BuddyInfo());
        return "redirect:/addressbook/" + book.getId();
    }


    @GetMapping("/addressbook/{ID}")
    public String addBuddy(Model model, @PathVariable Long ID){
        AddressBook book = addressBookRepository.findById(ID).orElse(null);
        if(book == null){
            return "redirect:/new";
        }
        model.addAttribute("addressbook", book);
        model.addAttribute("newBuddy", new BuddyInfo());
        return "addressbook";
    }

    @PostMapping("/addressbook/{ID}")
    public String addBuddyToAddressBook(@ModelAttribute BuddyInfo buddy, Model model, @PathVariable Long ID){
        AddressBook book = addressBookRepository.findById(ID).orElse(null);
        if(book == null){
            book = new AddressBook(ID);
            addressBookRepository.save(book);
        }
        book.addBuddy(buddy);
        buddy.setAddressBook(book);
        addressBookRepository.save(book);

        model.addAttribute("addressbook", book);
        model.addAttribute("newBuddy", new BuddyInfo());
        return "addressbook";
    }


    @GetMapping("/delete/{ID}")
    public String removeAddressBook(Model model, @PathVariable Long ID){
        addressBookRepository.findById(ID).ifPresent(book -> addressBookRepository.delete(book));
        return "redirect:/";
    }

    @GetMapping("/deletebuddy/{ID}/{BID}")
    public String removeBuddy(Model model, @PathVariable Long ID,@PathVariable Long BID){
        AddressBook book = addressBookRepository.findById(ID).get();
        book.removeBuddy(BID);
        addressBookRepository.save(book);
        return "redirect:/addressbook/"+book.getId();
    }

    @GetMapping("/error")
    public String errorPage(){
        return "redirect:/";
    }


}
