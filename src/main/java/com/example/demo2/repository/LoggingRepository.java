package com.example.demo2.repository;

import com.example.demo2.model.entity.User;
import com.example.demo2.model.entity.resours.Logging;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface LoggingRepository extends JpaRepository<Logging,Integer> {
     Optional<List<Logging>> findAllByCreatedAt(Date date);
}
