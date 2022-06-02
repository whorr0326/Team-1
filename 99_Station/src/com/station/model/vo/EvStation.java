package com.station.model.vo;

public class EvStation {
	private int evId; // 충전소 아이디
	private String evName; // 충전소 이름
	private String evAddr; // 충전소 주소
	private int evTel; // 충전소 전화번호
	private String chargerState; // 충전 현황
	private String chargerType; // 충전기 타입
	private int regionCode; // 지역코드

	public EvStation() {
		super();
	}

	public EvStation(int evId, String evName, String evAddr, int evTel,
			String chargerState, String chargerType, int regionCode) {
		super();
		this.evId = evId;
		this.evName = evName;
		this.evAddr = evAddr;
		this.evTel = evTel;
		this.chargerState = chargerState;
		this.chargerType = chargerType;
		this.regionCode = regionCode;
	}

	public int getEvId() {
		return evId;
	}

	public String getEvName() {
		return evName;
	}

	public String getEvAddr() {
		return evAddr;
	}

	public int getEvTel() {
		return evTel;
	}

	public String getChargerState() {
		return chargerState;
	}

	public String getChargerType() {
		return chargerType;
	}

	public int getRegionCode() {
		return regionCode;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("충전소 정보 [지점아이디 : ");
		sb.append(evId);
		sb.append(", 상호 : ");
		sb.append(evName);
		sb.append(", 주소 : ");
		sb.append(evAddr);
		sb.append(", 전화번호 : ");
		sb.append(evTel);
		sb.append(", 충전기 현황 : ");
		sb.append(chargerState);
		sb.append(", 충전기 타입 : ");
		sb.append(chargerType);
		sb.append(", 지역코드 : ");
		sb.append(regionCode);
		sb.append("]");
		return sb.toString();
	}

}
