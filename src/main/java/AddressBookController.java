import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class AddressBookController implements ActionListener{
    private ActionListener actionListener;
    private AddressBookModel model;

    public void setActionListener(ActionListener actionListener){
        this.actionListener=actionListener;
    }

    public void init(){
        this.model=model;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand() == null) return;

        e.getSource();
    }
}
