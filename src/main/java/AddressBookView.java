import javax.swing.*;
import java.awt.*;

public class AddressBookView extends JFrame{

    public void init(){
        // Set up the frame
        setLayout(new GridLayout(3,2,20,20));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(300,300);

        setVisible(true);
    }

}
