package com.example.demo2.repository;


import com.example.demo2.model.entity.File;
import com.example.demo2.model.entity.Groups;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepository extends JpaRepository<File,Integer> {
    boolean existsByNameAndGroups(String name, Groups groups);
}
