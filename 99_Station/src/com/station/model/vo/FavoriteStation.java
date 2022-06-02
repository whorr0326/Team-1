package com.station.model.vo;

public class FavoriteStation {
	private int bookmarkNo; // 즐겨찾기 번호
	private int stationId; // 주유소 코드
	private String stationNm; // 주유소 상호
	String userId; // 사용자 아이디

	public FavoriteStation() {
		super();
	}

	public FavoriteStation(int bookmarkNo, int stationId, String stationNm, String userId) {
		super();
		this.bookmarkNo = bookmarkNo;
		this.stationId = stationId;
		this.stationNm = stationNm;
		this.userId = userId;
	}

	public int getBookmarkNo() {
		return bookmarkNo;
	}

	public int getStationId() {
		return stationId;
	}

	public String getStationNm() {
		return stationNm;
	}

	public String getUserId() {
		return userId;
	}

	// 즐겨찾기 출력
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("즐겨찾기 [즐겨찾기 번호 : ");
		sb.append(bookmarkNo);
		sb.append(", 지점아이디 : ");
		sb.append(stationId);
		sb.append(", 지점명 : ");
		sb.append(stationNm);
		sb.append("]");
		return sb.toString();
	}

}