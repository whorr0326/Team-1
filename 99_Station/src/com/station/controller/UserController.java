package com.station.controller;

import java.util.HashMap;
import java.util.Scanner;

import com.station.model.vo.User;

public class UserController {
	private HashMap<String, User> map = new HashMap<>();
	private Scanner sc = new Scanner(System.in);
	
	// 회원가입
	public boolean createUser(String id, User user) {	
		boolean isCreate;
		if (map.containsKey(id)) {
			isCreate = false;
		} else {
			map.put(id, user);
			isCreate = true;
		}
		return isCreate;
	}
	
	// 로그인
	public String login(String id, String pw) {	
		if (map.get(id) == null) {
			return null;
		} else {
			if (map.get(id).getUserPw().equals(pw)) {
				return map.get(id).getUserName();
			} else {
				return null;
			}
		}
	}
	
}
