package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.UserSearchRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;


@Controller
public class UserController {
	/**
	   * ユーザー情報 Service
	   */
	  @Autowired
	  UserService userService;
	  /**
	   * ユーザー情報検索画面を表示
	   * @param model Model
	   * @return ユーザー情報一覧画面
	   */
	  
	  @GetMapping(value = "/search")
	  public String displaySearch(Model model) {
	    return "search";
	  }
	  
	  /**
	   * ユーザー情報検索
	   * @param userSearchRequest リクエストデータ
	   * @param model Model
	   * @return ユーザー情報一覧画面
	   */
	  @RequestMapping(value = "/id_search", method = RequestMethod.POST)
	  public String search(@ModelAttribute UserSearchRequest userSearchRequest, Model model, BindingResult bindingResult) {
		  	if(bindingResult.hasErrors()) {
		  		return "index";
		  		
		  	}
		    User user = userService.search(userSearchRequest);
		    model.addAttribute("userinfo", user);
		    return "search";
		  }
		}

	  


