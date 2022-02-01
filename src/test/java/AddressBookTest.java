import com.example.labs.AddressBook;
import com.example.labs.BuddyInfo;
import org.junit.Test;
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



}