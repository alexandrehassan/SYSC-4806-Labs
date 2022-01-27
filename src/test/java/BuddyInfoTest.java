import org.junit.Test;

import javax.persistence.*;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Incomplete test class for lab 1 of SYSC 4806
 *
 * @author Alexandre Hassan
 * @version january 20, 2022
 */

public class BuddyInfoTest{
    @Test
    public void getName(){
        BuddyInfo buddyInfo = new BuddyInfo("Name", "413");
        assertEquals(buddyInfo.getName(), "Name");
    }

    @Test
    public void getPhoneNumber(){
        BuddyInfo buddyInfo = new BuddyInfo("Name", "413");
        assertEquals(buddyInfo.getPhoneNumber(), "413");
    }

    @Test
    public void persistence(){
        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab");
        EntityManager em = emf.createEntityManager();


        int testID = addTestObjects(em);
        List<BuddyInfo> results = queryTestObjects(em);

        assertEquals("Query returned more than one object",1,results.size());
        BuddyInfo testBuddy = results.get(0);

        assertEquals("TestObject",testBuddy.getName());
        assertEquals("TestNumber",testBuddy.getPhoneNumber());
        assertEquals(testID, testBuddy.getId());
        removeTestObjects(em,testBuddy);

        results = queryTestObjects(em);
        assertEquals("Object not removed correctly",0,results.size());
    }



    private void removeTestObjects(EntityManager em, BuddyInfo testBuddy){
        em.getTransaction().begin();
        em.remove(testBuddy);
        em.getTransaction().commit();
    }

    private int addTestObjects(EntityManager em){
        BuddyInfo buddyInfo = new BuddyInfo("TestObject","TestNumber");

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(buddyInfo);

        tx.commit();
        return buddyInfo.getId();
    }

    private List<BuddyInfo> queryTestObjects(EntityManager em){
        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT b FROM BuddyInfo b where b.name LIKE 'TestObject%'");

        return q.getResultList();
    }


}