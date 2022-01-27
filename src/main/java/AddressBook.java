import java.util.ArrayList;

/**
 * Class made for SYSC 4806 course lab 1 to multiple a Buddies information
 *
 * @author Alexandre Hassan
 * @version january 20, 2022
 */
public class AddressBook{

    private ArrayList<BuddyInfo> myBuddies;

    public AddressBook(){
        myBuddies=new ArrayList<>();
    }

    public void addBuddy(BuddyInfo aBuddy){
        if (aBuddy != null) {
            myBuddies.add(aBuddy);
        }
    }

    public BuddyInfo removeBuddy(int index){
        if (index >= 0 && index < myBuddies.size()) {
            return myBuddies.remove(index);
        }
        return null;
    }

    public String getBuddyInfo(int index){
        if (index >= 0 && index < myBuddies.size()) {
            BuddyInfo buddy;
            buddy=myBuddies.get(index);
            return buddy.getName() + "'s address is: " + " Phone: " + buddy.getPhoneNumber();
        }
        return "invalid index";
    }


    public static void main(String[] args){
        BuddyInfo buddy=new BuddyInfo("Tom", "613");
        AddressBook addressBook=new AddressBook();
        addressBook.addBuddy(buddy);
        System.out.println(addressBook.getBuddyInfo(0));
    }

}
