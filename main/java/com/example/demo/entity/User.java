package com.example.demo.entity;

import javax.persistence.Column;

import lombok.Data;
/**
 * ユーザー情報 Entity
 */

@Data

public class User{
    /**
     * ID
     */
	@Column(nullable = false)
    private Long id;
    /**
     * 名前
     */
	@Column(nullable = false)
    private String name;
}