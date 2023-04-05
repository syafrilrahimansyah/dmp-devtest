package com.dmp.devtest.persistence;

import com.dmp.devtest.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT password FROM user WHERE username = ?1",nativeQuery = true)
    String getPassword(String username);

    @Query(value = "SELECT * FROM user WHERE username = ?1",nativeQuery = true)
    User getUserByUsername(String username);
}
