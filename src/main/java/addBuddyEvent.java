import javax.swing.*;
import java.util.EventObject;

public class addBuddyEvent extends EventObject{
    private String name;
    private String phone;


    public addBuddyEvent(AddressBookModel model, JTextField nameField, JTextField phoneField){
        super(model);
        this.name=nameField.getText();
        this.name=phoneField.getText();
    }

    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }
}
