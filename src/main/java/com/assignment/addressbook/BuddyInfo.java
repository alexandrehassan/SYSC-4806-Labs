package com.assignment.addressbook;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Class made for SYSC 4806 course lab 2 to store a buddy's information
 *
 * @author Alexandre Hassan
 * @version january 26, 2022
 */
@Entity
public class BuddyInfo{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String phoneNumber;


    /**
     * Creates an instance of BuddyInfo with empty name and number
     */
    public BuddyInfo(){
        this.name="";
        this.phoneNumber="";
    }

    /**
     * Creates an instance of BuddyInfo with given name and number
     * @param name the name of the buddy
     * @param phoneNumber the phone number of the buddy
     */
    public BuddyInfo(String name, String phoneNumber){
        this.name=name;
        this.phoneNumber=phoneNumber;
    }

    /**
     * Gets the id of this Player. The persistence provider should
     * autogenerate a unique id for new player objects.
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of this Player to the specified value.
     * @param id the new id
     */
    public void setId(Long id){
        this.id=id;
    }


    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.name=phoneNumber;
    }

//    @Override
//    public String toString(){
//        return "Name=" + name + ", phoneNumber=" + phoneNumber ;
//    }

}
