import java.awt.event.ActionEvent;

public class AddNewBuddyActionListener extends AddressBookActionListener{
    public void actionPerformed(ActionEvent e){
        model.addBuddy(nameField.getText(), phoneField.getText());
        nameField.setText("");
        phoneField.setText("");
    }
}