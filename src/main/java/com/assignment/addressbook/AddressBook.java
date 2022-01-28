package com.assignment.addressbook;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class made for SYSC 4806 course lab 1 to multiple a Buddies information
 *
 * @author Alexandre Hassan
 * @version january 20, 2022
 */
@Entity
public class AddressBook{
    @OneToMany( cascade = CascadeType.PERSIST)
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
        }catch (IndexOutOfBoundsException e){
            System.out.println("Invalid Index");
            return null;
        }
    }

    public BuddyInfo getBuddyInfo(Long id){
        for(BuddyInfo buddyInfo: buddyInfoList){
            if (buddyInfo.getId().equals(id)){
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

//    @Override
//    public String toString(){
//        StringBuilder str =new StringBuilder();
//        for (BuddyInfo b: buddyInfoList){
//            str.append(b).append("\n");
//        }
//        return str.toString();
//    }


    public static void main(String[] args){
        AddressBook addressBook=new AddressBook();
        BuddyInfo buddyInfo;

        for(int i =0; i<5;i++){
            buddyInfo = new BuddyInfo("Buddy: "+i, "Buddy: "+i);
            addressBook.addBuddy(buddyInfo);
        }

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(addressBook);

        tx.commit();

    }

}
