package com.example.spring;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class made for SYSC 4806 course to hold multiple a Buddies information
 * @author Alexandre Hassan
 * @version March 03, 2022
 */
@Entity
public class AddressBook{
    @OneToMany (cascade = CascadeType.PERSIST)
    private List<BuddyInfo> buddies;
    @Id
    @GeneratedValue
    private Long id;
    private String userName;

    public AddressBook(){
        buddies = new ArrayList<>();
    }

    public AddressBook(String userName) {
        this.userName = userName;
        buddies = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void addBuddy(BuddyInfo buddy) {
        buddies.add(buddy);
    }


    public int findBuddyIndex(String userName, String phone) {
        BuddyInfo toFind = new BuddyInfo(userName, phone, this.id);

        for (BuddyInfo buddy : buddies) if(buddy.equals(toFind)) return buddies.indexOf(buddy);
        return -1;
    }
    public List<BuddyInfo> getBuddies() { return buddies; }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    public BuddyInfo getBuddyAt(int index) {
        return buddies.get(index);
    }

    public int getNumBuddies() {
        return buddies.size();
    }

    public Long getAddressBookId() {
        return id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

}
