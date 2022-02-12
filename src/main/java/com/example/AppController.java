package com.example;

import com.example.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController{
    @Autowired
    AddressBookRepository addressBookRepository;


    @GetMapping("/")
    public String frontPage(Model model){
        model.addAttribute("books", addressBookRepository.findAll());
        return "index";
    }


    @GetMapping("/new")
    public String newBuddy(Model model){
        return "redirect:/addressbook/" + addressBookRepository.save(new AddressBook()).getId();
    }


    @GetMapping("/addressbook/{ID}")
    public String addBuddy(Model model, @PathVariable Long ID){
        AddressBook book = addressBookRepository.findById(ID).orElse(null);
        if(book == null) return "redirect:/new";

        model.addAttribute("addressbook", book).addAttribute("newBuddy", new BuddyInfo());
        return "addressbook";
    }

    @PostMapping("/addressbook/{ID}")
    public String addBuddyToAddressBook(@ModelAttribute BuddyInfo buddy, Model model, @PathVariable Long ID){
        AddressBook book = addressBookRepository.findById(ID).orElseThrow();

        addressBookRepository.save(book.addBuddy(buddy));

        model.addAttribute("addressbook", book).addAttribute("newBuddy", new BuddyInfo());
        return "addressbook";
    }


    @GetMapping("/delete/{ID}")
    public String removeAddressBook(@PathVariable Long ID){
        addressBookRepository.findById(ID).ifPresent(book -> addressBookRepository.delete(book));
        return "redirect:/";
    }

    @GetMapping("/deletebuddy/{ID}/{BID}")
    public String removeBuddy(@PathVariable Long ID, @PathVariable Long BID){
        AddressBook book = addressBookRepository.findById(ID).orElse(null);
        if(book == null) return "redirect:/";

        addressBookRepository.save(book.removeBuddy(BID));
        return "redirect:/addressbook/" + book.getId();
    }


}
