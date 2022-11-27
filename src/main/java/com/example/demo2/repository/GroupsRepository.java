package com.example.demo2.repository;

import com.example.demo2.model.entity.Groups;
import com.example.demo2.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
public interface GroupsRepository extends JpaRepository<Groups,Integer> {
    @Override
    boolean existsById(Integer integer);

    boolean existsByName(String name);
    List<Groups> findAllByTypeGroup(String name);


}
