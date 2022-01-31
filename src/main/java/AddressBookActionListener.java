import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class AddressBookActionListener implements ActionListener{
    protected JTextField nameField;
    protected JTextField phoneField;
    protected AddressBookModel model;

    public void setNameField(JTextField nameField){
        this.nameField=nameField;
    }

    public void setPhoneField(JTextField phoneField){
        this.phoneField=phoneField;
    }

    public void setModel(AddressBookModel model){
        this.model=model;
    }
}