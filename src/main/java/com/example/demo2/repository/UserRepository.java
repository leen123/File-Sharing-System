package com.example.demo2.repository;

import com.example.demo2.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Integer> {
    @Override
    boolean existsById(Integer integer);





    Optional<User> findByEmail(String email);
    Optional<User> existsByEmail(String email);
    Optional<User> deleteByEmail(String email);

    Optional<User> findByUserName(String userName);
    Optional<User> existsByUserName(String userName);
    Optional<User> deleteByUserName(String userName);


}
