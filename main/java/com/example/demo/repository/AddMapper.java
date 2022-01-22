package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.UserAddRequest;
import com.example.demo.entity.User;

/**
 * ユーザー情報 Mapper
 */
@Mapper
public interface AddMapper {
    /**
     * ユーザー情報検索
     * @param user 検索用リクエストデータ
     * @return ユーザー情報
     */
	
//	Useの所voidでもいける？後で試す。
    void add(UserAddRequest user);
    User search(UserAddRequest user);
}
