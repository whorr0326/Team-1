package com.station.api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.station.model.vo.EvStation;

public class EvOpenApiManager {

	public static String key = "Bc1LLgHM%2Fgc%2FUrkBzSZURJM4qgoSFZ%2BA8whQuKAsyCCkNITBjNzxvWMB8ahECCyTKM%2BpHcVmZANaAH2wu9jS2w%3D%3D";
	public static String GasStation_URL = "http://apis.data.go.kr/B552584/EvCharger/getChargerInfo";
//	public static String numOfRows = ""; //한 페이지 결과 수 (최소 10, 최대 9999)
//	public static String pageNo = ""; //조회 페이지 정수
	
//	지역명으로 찾기!
//	11	서울특별시, 26	부산광역시, 27	대구광역시, 28	인천광역시, 29	광주광역시, 30	대전광역시, 31	울산광역시, 36	세종특별자치시, 41	경기도
//	42	강원도, 43	충청북도, 44	충청남도, 45	전라북도, 46	전라남도, 47	경상북도, 48	경상남도, 50	제주특별자치도
	// 지역으로 검색 -> 충전소명, 충전소주소, 충전소타입, 충전기갯수(충전기상태), 휴점일, 관리업체 전화번호
	public static List<EvStation> searchArea(String Area){
			List<EvStation> list = new ArrayList<>();
			
			StringBuffer urlBuffer = new StringBuffer();
			urlBuffer.append(GasStation_URL);
			urlBuffer.append("?" + "serviceKey=" + key); // 첫 번째만 물음표로 설정
//			urlBuffer.append("&" + "numOfRows=" + numOfRows);
//			urlBuffer.append("&" + "pageNo=" + pageNo);
			urlBuffer.append("&" + "zcode=" + Area);
			
			System.out.println(urlBuffer);
			
			try {
				URL url = new URL(urlBuffer.toString());
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/xml");
				int code = conn.getResponseCode(); // 실제 호출하는 부
				System.out.println("ResponseCode : " + code);
				
				if(code < 200 || code > 300) {
					System.out.println("페이지가 잘못되었습니다.");
					return null;
				}
				
				//페이지 Parsing
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				 
				Document doc = db.parse(conn.getInputStream()); // xml 부를 파싱하여 객체화
				
				doc.getDocumentElement().normalize();
				
				System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
				System.out.println("======================================================");
				// 지역으로 검색 -> 충전소명, 충전소주소, 충전소타입, 충전기갯수, 휴점일, 관리업체 전화번호

				NodeList nList = doc.getElementsByTagName("item");
				for(int i = 0; i < nList.getLength(); i++) {
					Node node = nList.item(i);
					System.out.println("\nCurrent Element : " + node.getNodeName());
					if(node.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) node;
						System.out.println("충전소 ID 	: "  + eElement.getElementsByTagName("statId").item(0).getTextContent());
						System.out.println("충전소명 		: "  + eElement.getElementsByTagName("statNm").item(0).getTextContent());
						System.out.println("충전기타입 		: "  + eElement.getElementsByTagName("chgerType").item(0).getTextContent());
						//(01:DC차데모, 02: AC완속, 03: DC차데모+AC3상, 04: DC콤보, 
						// 05: DC차데+DC콤보, 06: DC차데모+AC3상+DC콤보, 07: AC3상)
						System.out.println("충전소 주소 	: "  + eElement.getElementsByTagName("addr").item(0).getTextContent());
						System.out.println("이용가능시간 	: "  + eElement.getElementsByTagName("useTime").item(0).getTextContent());
						System.out.println("충전기상태  	: "  + eElement.getElementsByTagName("stat").item(0).getTextContent());			
						//충전기상태(1: 통신이상, 2: 충전대기,3: 충전중, 4: 운영중지,5: 점검중, 9: 상태미확인)
						System.out.println("주차료무료(Y/N)	: "  + eElement.getElementsByTagName("parkingFree").item(0).getTextContent());
						System.out.println("운영기관명		: "  + eElement.getElementsByTagName("busiNm").item(0).getTextContent());
						System.out.println("운영기관 연락처 	: "  + eElement.getElementsByTagName("busiCall").item(0).getTextContent());
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return list;
	}
}