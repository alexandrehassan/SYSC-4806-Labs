package com.example.repository;

import com.example.AddressBook;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "addressbooks", path = "addressbooks")
public interface AddressBookRepository extends PagingAndSortingRepository<AddressBook, Long>{
    AddressBook findAddressBookById(@Param("id") Long id);
}
