import com.example.BuddyInfo;
import org.junit.Test;
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



}