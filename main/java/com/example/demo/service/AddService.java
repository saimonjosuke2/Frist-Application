package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserAddRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.AddMapper;


/**
 * ユーザー情報 Service
 */
@Service
public class AddService {
    /**
     * ユーザー情報 Mapper
     */
    @Autowired
    private AddMapper addMapper;
    
    /**
     * ユーザー情報検索
 　　　* @param userSearchRequest リクエストデータ
      * @return 検索結果
      */
    public User add(UserAddRequest userAddRequest) {
        addMapper.add(userAddRequest);
        return addMapper.search(userAddRequest);
   }

}
