package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.UserAddRequest;
import com.example.demo.entity.User;
import com.example.demo.service.AddService;

@Controller
public class AddUser {
	
	/**
	   * ユーザー情報 Service
	   */
//	@Autowiredを使うとnewクラスを書かなくても他のクラスを呼び出せる（クラス名は後で変更する必要あり）
	  @Autowired
	  AddService addService;
	  
	  
	  
	  /**
	   * ユーザー情報検索画面を表示
	   * @param model Model
	   * @return ユーザー情報一覧画面
	   */
//	  @RequestMapping(value = "/user/addition", method = RequestMethod.GET)と同じ意味
//	  後でHTMLファイル以外の名前でもいいか確認する
//	  value- 対応させるURL method- 対応させるHTTPメソッド
	  
	  @GetMapping(value = "/addition")
	  public String displayAddition(Model model) {
	    return "addition";
	  }
	  
	  
	  /**
	   * ユーザー情報検索
	   * @param userSearchRequest リクエストデータ
	   * @param model Model
	   * @return ユーザー情報一覧画面
	   */
	  
//	  後でafter_add.htmlを作る必要あり
//	  続きModelの意味
//	  @RequestMappingリクエスト URL に対して、どのメソッドが処理を実行するか定義するアノテーション。
//	  "/user/after_add" にアクセスするとこのコントローラが実行される。
//	  GET でアクセスされたリクエストを処理する場合。
//	  @RequestMapping(value = "/user/after_add", method = RequestMethod.GET)
//	  @ModelAttributeはuserAddRequestをmodelに返す
	  
	  @RequestMapping(value = "/after_add", method = RequestMethod.POST)
	  public String addition(@Validated @ModelAttribute UserAddRequest userAddRequest,BindingResult result, Model model) {

		    User user = addService.add(userAddRequest);
	        if (result.hasErrors()) {
	            List<String> errorList = new ArrayList<String>();
	            for (ObjectError error : result.getAllErrors()) {
	                errorList.add(error.getDefaultMessage());
	            }
	            model.addAttribute("validationError", errorList);
	            return "addition";
	        }

//		    コントローラーからviewに値を渡すuserをhtmlのuserinfo(キー)に紐づけている
		    model.addAttribute("userinfo", user);
		    return  "after_add";
		  }

}
