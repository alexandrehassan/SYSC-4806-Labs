package com.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class made for SYSC 4806 course lab 3 to multiple a Buddies information
 * @author Alexandre Hassan
 * @version january 31, 2022
 */
@Entity
public class AddressBook{
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "addressBook")
    private List<BuddyInfo> buddies;
    @Id
    @GeneratedValue
    private Long id;

    public AddressBook(){
        buddies = new ArrayList<>();
    }

    public AddressBook(Long id){
        buddies = new ArrayList<>();
        this.id = id;
    }

    public void addBuddy(BuddyInfo aBuddy){
        if(aBuddy != null){
            buddies.add(aBuddy);
        }
    }


    public void removeBuddy(Long id){
        for(int i = 0; i < buddies.size(); i++){
            if(buddies.get(i).getId().equals(id)){
                buddies.get(i).setAddressBook(null);
                buddies.remove(i);
                return;
            }
        }
    }

    public BuddyInfo getBuddyInfo(int index){
        try{
            return buddies.get(index);
        } catch (IndexOutOfBoundsException e){
            System.out.println("Invalid Index");
            return null;
        }
    }

    public BuddyInfo getBuddyInfo(Long id){
        for(BuddyInfo buddyInfo : buddies){
            if(buddyInfo.getId().equals(id)){
                return buddyInfo;
            }
        }
        return null;
    }

    public List<BuddyInfo> getBuddies(){
        return buddies;
    }

    public void setBuddies(List<BuddyInfo> buddyInfoList){
        this.buddies = buddyInfoList;
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

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        AddressBook that = (AddressBook) o;
        return Objects.equals(buddies, that.buddies) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(buddies, id);
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("id=").append(id).append("\n");
        for(BuddyInfo b : buddies){
            str.append(" Buddy: ").append(b.getName())
                    .append(" Phone: ").append(b.getPhoneNumber()).append("\n");
        }
        return str.toString();
    }

}
