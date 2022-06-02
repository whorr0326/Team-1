package com.station.model.vo;

public class User {
	private String userId;
	private String userPw;
	private String userNm;
	private String userPhone;
	private String userEmail;
	private String carType;
	
	public User() {
		super();
	}

	// 회원가입
	public User(String userId, String userPw, String userNm, String userPhone, String userEmail, String carType) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userNm = userNm;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.carType = carType;
	}

	// 로그인
	public User(String userId, String userPw) {	
		super();
		this.userId = userId;
		this.userPw = userPw;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userNm;
	}

	public void setUserName(String userName) {
		this.userNm = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("사용자 정보 [아이디 : ");
		sb.append(userId);
		sb.append(", 비밀번호 : ");
		sb.append(userPw);
		sb.append(", 이름 : ");
		sb.append(userNm);
		sb.append(", 핸드폰 번호 : ");
		sb.append(userPhone);
		sb.append( ", 이메일 : ");
		sb.append(userEmail);
		sb.append(", 차종 : ");
		sb.append(carType);
		sb.append("]");
		return sb.toString();
	}
}