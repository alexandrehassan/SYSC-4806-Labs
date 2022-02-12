package com.example.repository;

import java.util.List;

import com.example.BuddyInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "buddy", path="buddy")
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo,Long>{
    List<BuddyInfo> findByName(String name);
    BuddyInfo findByPhoneNumber(String num);
    BuddyInfo findById(long id);
}
