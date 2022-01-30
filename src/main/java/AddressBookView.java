import javax.swing.*;
import java.awt.*;

public class AddressBookView extends JFrame{
    JButton button;

    public void init(){
        // Set up the frame
        setLayout(new GridLayout(3,2,20,20));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(300,300);

        JLabel nameLabel = new JLabel("Name: ");
        getContentPane().add(nameLabel);
        JTextField nameField=new JTextField();
        getContentPane().add(nameField);

        JLabel numberLabel = new JLabel("Number: ");
        getContentPane().add(numberLabel);
        JTextField numberField=new JTextField();
        getContentPane().add(numberField);

        // Create the button and add it
        button = new JButton("Add buddy to address book");
        getContentPane().add(button);
        setVisible(true);
    }

}
