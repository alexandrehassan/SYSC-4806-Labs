import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

@Configuration
public class AppContext{
    @Bean(initMethod="init")
    public AddressBookView view(BoxLayoutPanel mainPanel){
        AddressBookView view=new AddressBookView();
        view.setContentPane(mainPanel);
        view.setTitle("Address Book");
        view.setSize(new Dimension(600, 400));
        return view;
    }

    @Bean
    public BoxLayoutPanel mainPanel(BoxLayoutPanel namePanel, BoxLayoutPanel phonePanel, BoxLayoutPanel buttonPanel){
        BoxLayoutPanel mainPanel=new BoxLayoutPanel(1);
        mainPanel.displayPanelComponents(Arrays.asList(namePanel, phonePanel, buttonPanel));
        return mainPanel;
    }

    @Bean
    public BoxLayoutPanel namePanel(JLabel nameLabel, JTextField nameTextField){
        BoxLayoutPanel panel=new BoxLayoutPanel(0);
        panel.displayPanelComponents(Arrays.asList(nameLabel, nameTextField));
        return panel;
    }

    @Bean
    public BoxLayoutPanel phonePanel(JLabel phoneLabel, JTextField phoneTextField){
        BoxLayoutPanel panel = new BoxLayoutPanel(0);
        panel.displayPanelComponents(Arrays.asList(phoneLabel, phoneTextField));
        return panel;
    }

    @Bean
    public JLabel nameLabel(){
        return new JLabel("name:  ");
    }

    @Bean
    public JTextField nameTextField(){
        return new JTextField();
    }

    @Bean
    public JLabel phoneLabel(){
        return new JLabel("phone: ");
    }

    @Bean
    public JTextField phoneTextField(){
        return new JTextField();
    }


    @Bean
    public AddressBookModel model(){
        return new AddressBookModel();
    }

    @Bean
    public BoxLayoutPanel buttonPanel(JButton printBuddiesButton, JButton addBuddyButton){
        BoxLayoutPanel panel = new BoxLayoutPanel(0);
        panel.displayPanelComponents(Arrays.asList(addBuddyButton,printBuddiesButton));
        return panel;
    }

    @Bean(initMethod="init")
    public ActionListenerButton printBuddiesButton(PrintBuddiesActionListener printActionListener){
        ActionListenerButton button = new ActionListenerButton();
        button.setText("Print buddies");
        button.setActionListener(printActionListener);
        return button;
    }

    @Bean
    public PrintBuddiesActionListener printActionListener(AddressBookModel model){
        PrintBuddiesActionListener actionListener=new PrintBuddiesActionListener();
        actionListener.setModel(model);
        return actionListener;
    }

    @Bean(initMethod="init")
    public ActionListenerButton addBuddyButton(AddBuddyActionListener addBuddyActionListener){
        ActionListenerButton button = new ActionListenerButton();
        button.setText("Add Buddy");
        button.setActionListener(addBuddyActionListener);
        return button;
    }

    @Bean
    public AddBuddyActionListener addBuddyActionListener(AddressBookModel model, JTextField nameTextField, JTextField phoneTextField){
        AddBuddyActionListener actionListener = new AddBuddyActionListener();
        actionListener.setModel(model);
        actionListener.setNameField(nameTextField);
        actionListener.setPhoneField(phoneTextField);
        return actionListener;
    }


}
