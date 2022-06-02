package com.station.model.vo;

public class FavoriteEv {
	private int bookmarkNo; // 즐겨찾기 번호
	private int evCode; // 충전소 코드
	private int evName; // 충전소 이름
	private String userId; // 사용자 아이디

	public FavoriteEv() {
		super();
	}

	public FavoriteEv(int bookmarkNo, int evCode, int evName, String userId) {
		super();
		this.bookmarkNo = bookmarkNo;
		this.evCode = evCode;
		this.evName = evName;
		this.userId = userId;
	}

	// 즐겨찾기 VO
	public FavoriteEv(int bookmarkNo, int evCode, int evName) {
		super();
		this.bookmarkNo = bookmarkNo;
		this.evCode = evCode;
		this.evName = evName;
	}

	public int getBookmarkNo() {
		return bookmarkNo;
	}

	public void setBookmarkNo(int bookmarkNo) {
		this.bookmarkNo = bookmarkNo;
	}

	public int getevCode() {
		return evCode;
	}

	public void setevCode(int evCode) {
		this.evCode = evCode;
	}

	public int getevName() {
		return evName;
	}

	public void setevName(int evName) {
		this.evName = evName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	// 즐겨찾기 출력
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("즐겨찾기 [즐겨찾기 번호 : ");
		sb.append(bookmarkNo);
		sb.append(", 지점코드 : ");
		sb.append(evCode);
		sb.append(", 지점명 : ");
		sb.append(evName);
		sb.append("]");
		return sb.toString();
	}

}