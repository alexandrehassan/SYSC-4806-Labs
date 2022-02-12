package com.example;

import com.example.repository.AddressBookRepository;
import com.example.repository.BuddyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController{


    @Autowired
    AddressBookRepository repository;

    @GetMapping("/")
    public String frontPage(Model model){
        model.addAttribute("books", repository.findAll());
        return "index";
    }


    @GetMapping("/new")
    public String newBuddy(Model model){
        AddressBook book = new AddressBook();
        repository.save(book);

        model.addAttribute("addressbook", book);
        model.addAttribute("newBuddy", new BuddyInfo());
        return "redirect:/addressbook/" + book.getId();
    }


    @GetMapping("/addressbook/{ID}")
    public String addBuddy(Model model, @PathVariable Long ID){
        AddressBook book = repository.findById(ID).orElse(null);
        if(book == null){
            book = new AddressBook(ID);
            repository.save(book);
        }
        model.addAttribute("addressbook", book);
        model.addAttribute("newBuddy", new BuddyInfo());
        return "addressbook";
    }

    @PostMapping("/addressbook/{ID}")
    public String addBuddyToAddressBook(@ModelAttribute BuddyInfo buddy, Model model, @PathVariable Long ID){
        AddressBook book = repository.findById(ID).orElse(null);
        if(book == null){
            book = new AddressBook(ID);
            repository.save(book);
        }
        book.addBuddy(buddy);
        buddy.setAddressBook(book);
        repository.save(book);

        model.addAttribute("addressbook", book);
        model.addAttribute("newBuddy", new BuddyInfo());
        return "addressbook";
    }


    @GetMapping("/delete/{ID}")
    public String removeAddressBook(Model model, @PathVariable Long ID){
        repository.findById(ID).ifPresent(book -> repository.delete(book));
        return "redirect:/";
    }


}
