import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Incomplete test class for lab 1 of SYSC 4806
 *
 * @author Alexandre Hassan
 * @version january 20, 2022
 */
public class AddressBookTest{

    @Test
    public void addBuddy(){
        AddressBook addressBook=new AddressBook();
        BuddyInfo buddyInfo=new BuddyInfo("Name", "413");
        addressBook.addBuddy(buddyInfo);
        assertEquals(addressBook.getBuddyInfo(0), "Name's address is:  Phone: 413");
    }

    @Test
    public void removeBuddy(){
        AddressBook addressBook=new AddressBook();
        BuddyInfo buddyInfo=new BuddyInfo("Name", "413");
        addressBook.addBuddy(buddyInfo);
        assertEquals(addressBook.removeBuddy(0), buddyInfo);
        assertEquals(addressBook.removeBuddy(0), null);
    }

    @Test
    public void getBuddyInfo(){
        AddressBook addressBook=new AddressBook();
        BuddyInfo buddyInfo=new BuddyInfo("Name", "413");
        addressBook.addBuddy(buddyInfo);
        assertEquals(addressBook.getBuddyInfo(0), "Name's address is:  Phone: 413");
    }
}