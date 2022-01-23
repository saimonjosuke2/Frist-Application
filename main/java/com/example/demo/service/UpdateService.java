package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UpdateMapper;

/**
 * ユーザー情報 Service
 */
@Service
public class UpdateService {
    /**
     * ユーザー情報 Mapper
     */
    @Autowired
    private UpdateMapper updateMapper;
    
    public User search(UserUpdateRequest userUpdateRequest) {
        return updateMapper.search(userUpdateRequest);
    }
    
    public void update(UserUpdateRequest userUpdateRequest) {
        updateMapper.update(userUpdateRequest);
   }

}
