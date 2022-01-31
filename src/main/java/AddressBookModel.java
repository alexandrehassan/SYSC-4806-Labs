public class AddressBookModel{
    private AddressBook addressBook;

    public AddressBookModel(){
        addressBook=new AddressBook();
        System.out.println("Yes");
    }

    public void addBuddy(String name, String number){
        BuddyInfo buddyInfo=new BuddyInfo(name, number);
        addressBook.addBuddy(buddyInfo);
        System.out.println(buddyInfo);
    }

    public void printBuddies(){
        System.out.println(addressBook);
    }
}
