package com.example.spring;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class made for SYSC 4806 course to hold multiple a Buddies information
 *
 * @author Alexandre Hassan
 * @version March 03, 2022
 */
@Entity
public class AddressBook{
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<BuddyInfo> buddies;
    @Id
    @GeneratedValue
    private Long id;
    private String userName;

    public AddressBook(){
        buddies = new ArrayList<>();
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void addBuddy(BuddyInfo buddy){
        buddies.add(buddy);
    }


    public int getNumBuddies(){
        return buddies.size();
    }

    public Long getAddressBookId(){
        return id;
    }


    public Long getId(){
        return id;
    }


}
