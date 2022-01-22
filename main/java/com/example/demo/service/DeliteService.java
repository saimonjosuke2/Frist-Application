package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.DeliteUser;
import com.example.demo.repository.DeliteMapper;
import com.example.demo.dto.UserDeliteRequest;


@Service
public class DeliteService {
	
	
    @Autowired
    private DeliteMapper deliteMapper;
    
    public void deleteOne(UserDeliteRequest userDeliteRequest) {
        deliteMapper.deleteOne(userDeliteRequest);
    }   
    

}
