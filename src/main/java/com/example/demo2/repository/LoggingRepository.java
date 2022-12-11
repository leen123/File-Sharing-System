package com.example.demo2.repository;

import com.example.demo2.model.entity.User;
import com.example.demo2.model.entity.resours.Logging;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface LoggingRepository extends JpaRepository<Logging,Integer> {


}
