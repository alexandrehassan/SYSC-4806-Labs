/**
 * Class made for SYSC 4806 course lab 1 to store a buddy's information
 *
 * @author Alexandre Hassan
 * @version january 20, 2022
 */
public class BuddyInfo{

    private String name;
    private String phoneNumber;


    public BuddyInfo(String name, String phoneNumber){
        this.name=name;
        this.phoneNumber=phoneNumber;
    }

    public String getName(){
        return name;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

}
