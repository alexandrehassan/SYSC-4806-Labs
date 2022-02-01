package com.example.labs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class made for SYSC 4806 course lab 3 to multiple a Buddies information
 *
 * @author Alexandre Hassan
 * @version january 31, 2022
 */
@Entity
public class AddressBook{
    @OneToMany(cascade=CascadeType.PERSIST)
    private List<BuddyInfo> buddyInfoList;
    @Id
    @GeneratedValue
    private Long id;

    public AddressBook(){
        buddyInfoList=new ArrayList<>();
    }

    public void addBuddy(BuddyInfo aBuddy){
        if (aBuddy != null) {
            buddyInfoList.add(aBuddy);
        }
    }

    public BuddyInfo removeBuddy(int index){
        if (index >= 0 && index < buddyInfoList.size()) {
            return buddyInfoList.remove(index);
        }
        return null;
    }

    public BuddyInfo getBuddyInfo(int index){
        try {
            return buddyInfoList.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid Index");
            return null;
        }
    }

    public BuddyInfo getBuddyInfo(Long id){
        for (BuddyInfo buddyInfo : buddyInfoList) {
            if (buddyInfo.getId().equals(id)) {
                return buddyInfo;
            }
        }
        return null;
    }

    public List<BuddyInfo> getBuddyInfoList(){
        return buddyInfoList;
    }

    public void setBuddyInfoList(List<BuddyInfo> buddyInfoList){
        this.buddyInfoList=buddyInfoList;
    }

    /**
     * Gets the id of this Player. The persistence provider should
     * autogenerate a unique id for new player objects.
     *
     * @return the id
     */

    public Long getId(){
        return this.id;
    }

    /**
     * Sets the id of this Player to the specified value.
     *
     * @param id the new id
     */
    public void setId(Long id){
        this.id=id;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBook that=(AddressBook) o;
        return Objects.equals(buddyInfoList, that.buddyInfoList) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(buddyInfoList, id);
    }

    @Override
    public String toString(){
        StringBuilder str=new StringBuilder();
        str.append("id=").append(id).append("\n");
        for (BuddyInfo b : buddyInfoList) {
            str.append(" Buddy: ").append(b.getName())
                    .append(" Phone: ").append(b.getPhoneNumber()).append("\n");
        }
        return str.toString();
    }

}
