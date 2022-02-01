package com.example.labs;

import java.awt.event.ActionEvent;

public class PrintBuddiesActionListener extends AddressBookActionListener{
    public void actionPerformed(ActionEvent e){
        model.printBuddies();
    }
}