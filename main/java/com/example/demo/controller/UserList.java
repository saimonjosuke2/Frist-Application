package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.User;
import com.example.demo.service.ListService;

@Controller
public class UserList {
	/**
	   * ユーザー情報 Service
	   */
	  @Autowired
	  private ListService listService;
	  /**
	   * ユーザー情報一覧画面を表示
	   * @param model Model
	   * @return ユーザー情報一覧画面
	   */
	  @GetMapping(value = "userlist")
	  public String displayList(Model model) {
	    List<User> userlist = listService.searchAll();
	    model.addAttribute("userlist", userlist);
	    return "userlist";
	  }

}
