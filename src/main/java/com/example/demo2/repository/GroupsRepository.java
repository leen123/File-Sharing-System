package com.example.demo2.repository;

import com.example.demo2.model.entity.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface GroupsRepository extends JpaRepository<Groups,Integer> {

}
