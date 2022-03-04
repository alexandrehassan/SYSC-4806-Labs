package com.example.spring;

import com.example.spring.AddressBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "BuddyInfo", path="BuddyInfo")
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Integer> {
}