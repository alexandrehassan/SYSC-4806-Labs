package com.example.spring;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "AddressBook", path = "AddressBook")
public interface AddressBookRepository extends PagingAndSortingRepository<AddressBook, Long>{
    AddressBook findAddressBookById(@Param("id") Long id);
}
