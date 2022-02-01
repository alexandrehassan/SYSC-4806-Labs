package com.example.labs;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo,Long>{
    List<BuddyInfo> findByName(String name);
    BuddyInfo findByPhoneNumber(String num);
    BuddyInfo findById(long id);
}
