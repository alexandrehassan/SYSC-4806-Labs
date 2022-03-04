package com.example.spring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Alexandre Hassan
 * @version March 03, 2022
 */
@Entity
public class BuddyInfo{
    private String name;
    private String phone;
    private Long addressBookId;

    @Id
    @GeneratedValue
    private Long id;

    public BuddyInfo(){
        this.name = "";
        this.phone = "";
        this.addressBookId = 0L;
    }


    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public Long getId(){
        return id;
    }



    public Long getAddressBookId(){
        return addressBookId;
    }

    public void setAddressBookId(Long addressBookId){
        this.addressBookId = addressBookId;
    }

}
