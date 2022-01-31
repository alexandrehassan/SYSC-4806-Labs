import java.awt.event.ActionEvent;

public class printBuddiesActionListener extends AddressBookActionListener{
    public void actionPerformed(ActionEvent e){
        model.printBuddies();
    }
}