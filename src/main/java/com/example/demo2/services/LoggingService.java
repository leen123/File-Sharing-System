package com.example.demo2.services;

import com.example.demo2.model.entity.User;
import com.example.demo2.model.entity.resours.Logging;
import com.example.demo2.repository.LoggingRepository;
import com.example.demo2.repository.UserRepository;
import com.example.demo2.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LoggingService {
    @Autowired
    private LoggingRepository loggingRepository;
    public Logging save(Logging logging){

        return this.loggingRepository.save(logging);
    }
    public  int rateApiDay(){
        return loggingRepository.findAllByCreatedAt(new Date(System.currentTimeMillis())).get().size();
    }




}
