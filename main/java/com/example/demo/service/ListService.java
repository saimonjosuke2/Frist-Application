package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.ListMapper;
/**
 * ユーザー情報 Service
 */
@Service
public class ListService {
  /**
   * ユーザー情報 Repository
   */
    @Autowired
    private ListMapper listMapper;
  /**
   * ユーザー情報 全検索
   * @return 検索結果
   */
  public List<User> searchAll() {
    return listMapper.findAll();
  }
}

