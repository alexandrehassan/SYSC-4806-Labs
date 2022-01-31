import com.AddressBook.AddressBook;
import com.AddressBook.BuddyInfo;
import org.junit.Test;
import javax.persistence.*;
import static org.junit.Assert.*;

/**
 * Incomplete test class for lab 2 of SYSC 4806
 *
 * @author Alexandre Hassan
 * @version january 26, 2022
 */
public class AddressBookTest{

    @Test
    public void addBuddy(){
        AddressBook addressBook=new AddressBook();
        BuddyInfo buddyInfo=new BuddyInfo("Name", "413");
        addressBook.addBuddy(buddyInfo);
        assertEquals(buddyInfo.getId(),addressBook.getBuddyInfo(0).getId());
    }

    @Test
    public void removeBuddy(){
        AddressBook addressBook=new AddressBook();
        BuddyInfo buddyInfo=new BuddyInfo("Name", "413");
        addressBook.addBuddy(buddyInfo);
        assertEquals(addressBook.removeBuddy(0), buddyInfo);
        assertNull(addressBook.removeBuddy(0));
    }


    @Test
    public void persistence(){
        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab");
        EntityManager em = emf.createEntityManager();


        Long testID = addTestObjects(em);
        AddressBook addressBook = queryTestObjects(em, testID);
        assertNotNull(addressBook);
        removeTestObject(em,addressBook);
        assertNull(queryTestObjects(em, testID));
    }



    private void removeTestObject(EntityManager em, AddressBook addressBook){
        em.getTransaction().begin();
        em.remove(addressBook);
        em.getTransaction().commit();
    }

    private Long addTestObjects(EntityManager em){
        AddressBook addressBook=new AddressBook();
        BuddyInfo buddyInfo;

        for(int i =0; i<5;i++){
            buddyInfo = new BuddyInfo(i+"", i+"");
            addressBook.addBuddy(buddyInfo);
        }

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(addressBook);

        tx.commit();
        return addressBook.getId();
    }

    private AddressBook queryTestObjects(EntityManager em, Long id){
        // Querying the contents of the database using JPQL query
        return em.find(AddressBook.class, id);
    }
}