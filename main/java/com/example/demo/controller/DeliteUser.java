package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.UserDeliteRequest;
import com.example.demo.service.DeliteService;


@Controller
public class DeliteUser {

//	@Autowiredを使うとnewクラスを書かなくても他のクラスを呼び出せる（クラス名は後で変更する必要あり）
	  @Autowired
	  DeliteService deliteService;
	  
 //@PathVariableとはURLに含まれた文字列をパラメータとして受け取るためのアノテーションです。(idの値をString idに入れる)
	  @GetMapping(value = "delete/{id}")
	  public String delite(@PathVariable Long id, @ModelAttribute UserDeliteRequest userDeliteRequest) {
		  deliteService.deleteOne(userDeliteRequest);
		  return "redirect:/userlist";
	  }

}
