package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UpdateService;

@Controller
public class UppdateUser {

	  @Autowired
	  UpdateService updateService;
	  
	  
	  //編集画面中処理
	  @RequestMapping(value ="/edit/{id}", method = RequestMethod.GET)
	  public String search(@ModelAttribute UserUpdateRequest userUpdateRequest, Model model, BindingResult bindingResult) {
		  	if(bindingResult.hasErrors()) {
		  		return "index";
		  		
		  	}
		    User user = updateService.search(userUpdateRequest);
		    model.addAttribute("userinfo", user);
		    return "/update";
		  }
		
	  /**
	   * ユーザー更新
	   * @param userRequest リクエストデータ
	   * @param model Model
	   * @return ユーザー情報詳細画面
	   */
	  @RequestMapping(value = "/after_update", method = RequestMethod.POST)
	  	public String update(@Validated @ModelAttribute UserUpdateRequest userUpdateRequest, BindingResult result, Model model) {
		
	    if (result.hasErrors()) {
	      List<String> errorList = new ArrayList<String>();
	      for (ObjectError error : result.getAllErrors()) {
	        errorList.add(error.getDefaultMessage());
	      }
	      model.addAttribute("validationError", errorList);
	      return "user/edit";
	    }
	    
	    // ユーザー情報の更新
	    updateService.update(userUpdateRequest);
	    return "after_update";

	  }
	  

	  
		  
}
