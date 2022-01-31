import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

public abstract class AddressBookActionListener implements ActionListener{
    protected JTable table;
    protected List list;

    public void setList(List list){
        this.list=list;
    }

    public void setTable(JTable itemTable){
        this.table=itemTable;
    }
}