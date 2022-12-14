package com.utfda.springbootjpa100.user.repository;


import com.utfda.springbootjpa100.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    int countByEmail(String email);

}
