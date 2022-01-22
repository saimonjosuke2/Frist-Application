package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.UserDeliteRequest;

@Mapper
public interface DeliteMapper {
	
    void deleteOne(UserDeliteRequest userDeliteRequest);
    
}
