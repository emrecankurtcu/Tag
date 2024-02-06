package com.example.tag.repository;

import com.example.tag.model.UserProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProviderRepository extends JpaRepository<UserProvider, Integer> {
    UserProvider findByGoogleSubId(String googleSubId);
}
