package com.assignment.addressbook;
import org.junit.Test;
import javax.persistence.*;
import static org.junit.Assert.*;

/**
 * Incomplete test class for lab 2 of SYSC 4806
 *
 * @author Alexandre Hassan
 * @version january 26, 2022
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


        Long testID = addTestObjects(em);
        BuddyInfo buddyInfo = queryTestObjects(em, testID);

        assertNotNull(buddyInfo);

        assertEquals("TestObject",buddyInfo.getName());
        assertEquals("TestNumber",buddyInfo.getPhoneNumber());
        assertEquals(testID, buddyInfo.getId());

        removeTestObjects(em,buddyInfo);
        assertNull(queryTestObjects(em, testID));
    }



    private void removeTestObjects(EntityManager em, BuddyInfo testBuddy){
        em.getTransaction().begin();
        em.remove(testBuddy);
        em.getTransaction().commit();
    }

    private Long addTestObjects(EntityManager em){
        BuddyInfo buddyInfo = new BuddyInfo("TestObject","TestNumber");
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(buddyInfo);

        tx.commit();
        return buddyInfo.getId();
    }

    private BuddyInfo queryTestObjects(EntityManager em, Long id){
        // Querying the contents of the database using JPQL query
        return em.find(BuddyInfo.class, id);
    }


}