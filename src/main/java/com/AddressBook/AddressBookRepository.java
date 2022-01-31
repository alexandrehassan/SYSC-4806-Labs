package com.AddressBook;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressBookRepository extends CrudRepository{
    List<BuddyInfo> findByName(String name);
    BuddyInfo findByNumber(String num);
}
