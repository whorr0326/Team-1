package com.station.model.vo;

public class GasStation {
	private String stationId; // 주유소 아이디
	private String stationTm; // 주유소 상표
	private String stationNm; // 주유소 상호
	private String stationAddr; // 주유소 주소
	private String stationTel; // 주유소 전화번호
	private int regionCd; // 지역코드
	private String maintYN; // 경정비 유무
	private String washYN; // 세차장 유무
	private String cvsYN; // 편의점 유무
	private int gasolinePrice; // 휘발유 가격
	private int dieselPrice; // 경유 가격
	private int stationMin; // 휘발유 최저가
	private int dieselMin; // 경유 최저가
	private int gasolineAvg; // 휘발유 평균가
	private int dieselAvg; // 경유 평균가

	public GasStation() {
		super();
	}

	// 주유소 검색
	public GasStation(String stationId, String stationTm, String stationNm, String stationAddr, String stationTel,
			int regionCd, String maintYN, String washYN, String cvsYN, int gasolinePrice, int dieselPrice) {
		super();
		this.stationId = stationId;
		this.stationTm = stationTm;
		this.stationNm = stationNm;
		this.stationAddr = stationAddr;
		this.stationTel = stationTel;
		this.regionCd = regionCd;
		this.maintYN = maintYN;
		this.washYN = washYN;
		this.cvsYN = cvsYN;
		this.gasolinePrice = gasolinePrice;
		this.dieselPrice = dieselPrice;
	}

	// 최저가 조회
	public GasStation(String stationId, String stationNm, int stationMin, int dieselMin) {
		super();
		this.stationId = stationId;
		this.stationNm = stationNm;
		this.stationMin = stationMin;
		this.dieselMin = dieselMin;
	}

	// 평균가 조회
	public GasStation(int regionCd, int gasolineAvg, int dieselAvg) {
		super();
		this.regionCd = regionCd;
		this.gasolineAvg = gasolineAvg;
		this.dieselAvg = dieselAvg;
	}

	public String getStationId() {
		return stationId;
	}

	public String getStationTm() {
		return stationTm;
	}

	public String getStationNm() {
		return stationNm;
	}

	public String getStationAddr() {
		return stationAddr;
	}

	public String getStationTel() {
		return stationTel;
	}

	public int getRegionCd() {
		return regionCd;
	}

	public String getMaintYN() {
		return maintYN;
	}

	public String getWashYN() {
		return washYN;
	}

	public String getCvsYN() {
		return cvsYN;
	}

	public int getGasolinePrice() {
		return gasolinePrice;
	}

	public int getDieselPrice() {
		return dieselPrice;
	}

	public int getStationMin() {
		return stationMin;
	}

	public int getDieselMin() {
		return dieselMin;
	}

	public int getGasolineAvg() {
		return gasolineAvg;
	}

	public int getDieselAvg() {
		return dieselAvg;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("주유소 정보 [지점아이디 : ");
		sb.append(stationId);
		sb.append(", 상표 : ");
		sb.append(stationTm);
		sb.append(", 상호 : ");
		sb.append(stationNm);
		sb.append(", 주소 : ");
		sb.append(stationAddr);
		sb.append(", 전화번호 : ");
		sb.append(stationTel);
		sb.append(", 지역코드 : ");
		sb.append(regionCd);
		sb.append(", 경정비 유무 : ");
		sb.append(maintYN);
		sb.append(", 세차장 유무 : ");
		sb.append(washYN);
		sb.append(", 편의점 유무 : ");
		sb.append(regionCd);
		sb.append(", 지역명 : ");
		sb.append(cvsYN);
		sb.append(", 휘발유가격 : ");
		sb.append(gasolinePrice);
		sb.append(", 경유가격 : ");
		sb.append(dieselPrice);
		sb.append("]");
		return sb.toString();
	}

}
