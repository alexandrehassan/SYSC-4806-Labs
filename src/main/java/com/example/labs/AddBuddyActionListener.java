package com.example.labs;

import java.awt.event.ActionEvent;

public class AddBuddyActionListener extends AddressBookActionListener{
    public void actionPerformed(ActionEvent e){
        model.addBuddy(nameField.getText(), phoneField.getText());
        nameField.setText("");
        phoneField.setText("");
    }
}