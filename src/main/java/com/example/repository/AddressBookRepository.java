package com.example.repository;

import com.example.AddressBook;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "addressbooks", path = "addressbooks")
public interface AddressBookRepository extends PagingAndSortingRepository<AddressBook, Long>{
}
