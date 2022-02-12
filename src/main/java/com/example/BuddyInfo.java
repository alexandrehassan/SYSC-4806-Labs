package com.example;

import javax.persistence.*;
import java.util.Objects;

/**
 * Class made for SYSC 4806 course lab 3 to store a buddy's information
 * @author Alexandre Hassan
 * @version january 31, 2022
 */
@Entity
public class BuddyInfo{
    private final String phoneNumber;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne
//    @JoinColumn(name = "addressbookId")
    private AddressBook addressBook;


    /**
     * Creates an instance of com.AddressBook.BuddyInfo with empty name and number
     */
    protected BuddyInfo(){
        this.name = "";
        this.phoneNumber = "";
    }

    /**
     * Creates an instance of com.AddressBook.BuddyInfo with given name and number
     * @param name        the name of the buddy
     * @param phoneNumber the phone number of the buddy
     */
    public BuddyInfo(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public BuddyInfo(String name, String phoneNumber, AddressBook addressBook){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.addressBook = addressBook;
    }

    /**
     * Gets the id of this Player. The persistence provider should
     * autogenerate a unique id for new player objects.
     * @return the id
     */
    public Long getId(){
        return this.id;
    }

    /**
     * Sets the id of this Player to the specified value.
     * @param id the new id
     */
    public void setId(Long id){
        this.id = id;
    }


    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.name = phoneNumber;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        BuddyInfo buddyInfo = (BuddyInfo) o;
        return Objects.equals(id, buddyInfo.id) && Objects.equals(name, buddyInfo.name) && Objects.equals(phoneNumber, buddyInfo.phoneNumber);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name, phoneNumber);
    }

    @Override
    @Transient
    public String toString(){
        return "Name=" + name + ", phoneNumber=" + phoneNumber;
    }

    public void setAddressBook(AddressBook book){
        addressBook = book;
    }

    public Long getAddressBookId(){
        return addressBook.getId();
    }
}
