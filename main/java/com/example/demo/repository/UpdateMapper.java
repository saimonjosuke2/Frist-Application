package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.User;

@Mapper
public interface UpdateMapper {
	User search(UserUpdateRequest user);
	void update(UserUpdateRequest user);
}
