import java.awt.event.ActionEvent;
public class AddNewButtonActionListener extends AddressBookActionListener {
    public void actionPerformed(ActionEvent e) {
        list.add("New Item");
        table.revalidate();
    }
}