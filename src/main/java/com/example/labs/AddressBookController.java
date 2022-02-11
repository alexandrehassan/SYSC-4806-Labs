package com.example.labs;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AddressBookController{
    private final AddressBookRepository repository;
    AddressBookController(AddressBookRepository repository){
        this.repository = repository;
    }

    @GetMapping("/addressbooks")
    public List<AddressBook> all(){
        List<AddressBook> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result;
    }

    @PostMapping("/addressbooks")
    public AddressBook newAddressBook(@RequestBody AddressBook newAddressBook){
        return repository.save(newAddressBook);
    }

    @GetMapping("/addressbook/{id}")
    public AddressBook findByID(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new InvalidAddressBookException(id));
    }

    @GetMapping("/addressbook/{id}/buddies")
    public List<BuddyInfo> getABBuddies(@PathVariable Long id){
        AddressBook ad = findByID(id);
        System.out.println(ad);
        return ad.getBuddies();
    }

    @PostMapping("/addressbook/{id}/buddies")
    public void newBuddyInfo(@PathVariable Long id, @RequestBody BuddyInfo newBuddyInfo){
        System.out.println(newBuddyInfo);
        findByID(id).addBuddy(newBuddyInfo);
        System.out.println(findByID(id));
        repository.save(findByID(id));
    }

    @GetMapping("/addressbook/{id}/buddies/{bid}")
    public BuddyInfo getABBuddies(@PathVariable Long id,@PathVariable Long bid){
        return findByID(id).getBuddyInfo(bid);
    }

}
