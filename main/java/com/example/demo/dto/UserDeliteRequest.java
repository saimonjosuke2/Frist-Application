package com.example.demo.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserDeliteRequest implements Serializable{
	  /**
	   * ユーザーID
	   */
		
		private Long id;
		
		private String name;
	  
}
