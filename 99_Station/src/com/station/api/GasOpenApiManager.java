package com.station.api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.station.model.vo.GasStation;

public class GasOpenApiManager {
	
	public static String key = "F220524163";
	
	public static String GasStation_URL = "http://www.opinet.co.kr/api/detailById.do";
	public static String outType = "xml";
//	public static String areaType = "01";	
	
	
	public static GasStation searchByID(String id){
		
		int dieselPrice=0;
		int gasolinePrice=0;
		
		GasStation gasStation = new GasStation();

		
		StringBuffer urlBuffer = new StringBuffer();
		urlBuffer.append(GasStation_URL);
		urlBuffer.append("?" + "code=" + key);
		urlBuffer.append("&" + "id=" + id);
		urlBuffer.append("&" + "out=" + outType);
		
		// http://www.opinet.co.kr/api/detailById.do?code=F220524163&id=A0001145&out=xml
//		urlBuffer.append("&" + "area=" + areaType);
		
		System.out.println(urlBuffer);
		
		try {
			URL url = new URL(urlBuffer.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "applictaion/xml");
			int code = conn.getResponseCode();
			System.out.println("Response Code : " + code);
			
			if(code < 200 || code > 300) {
				System.out.println("페이지가 잘못됨");
				return null;
			}
			
			
			// 페이지 파싱
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			Document doc = db.parse(conn.getInputStream());
			doc.getDocumentElement().normalize();
			
			System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
			System.out.println("=====================================");
			
		

			NodeList nList = doc.getElementsByTagName("OIL");
			
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				System.out.println("\nCurrent Element : " + node.getNodeName());
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					
					String stationID = eElement.getElementsByTagName("UNI_ID").item(0).getTextContent();
					String name= eElement.getElementsByTagName("OS_NM").item(0).getTextContent();
					String address= eElement.getElementsByTagName("NEW_ADR").item(0).getTextContent();
					String tel= eElement.getElementsByTagName("TEL").item(0).getTextContent();
					String trademark= eElement.getElementsByTagName("POLL_DIV_CO").item(0).getTextContent();
					int regionCode 		= Integer.parseInt(eElement.getElementsByTagName("SIGUNCD").item(0).getTextContent());
					String maintYN= eElement.getElementsByTagName("MAINT_YN").item(0).getTextContent();
					String washYN= eElement.getElementsByTagName("CAR_WASH_YN").item(0).getTextContent();
					String cvsYN= eElement.getElementsByTagName("CVS_YN").item(0).getTextContent();
				
					
					
					// 기름값 분기
					NodeList nList2 = doc.getElementsByTagName("OIL_PRICE");
//					System.out.println(nList2.getLength());
//					System.out.println(nList.getLength());
					
					for (int j = 0; j < nList2.getLength(); j++) {
						Node node2 = nList2.item(j);
						System.out.println("\nCurrent Element : " + node2.getNodeName());
						if (node2.getNodeType() == Node.ELEMENT_NODE) {
							Element eElement2 = (Element) node2;
							if(eElement2.getElementsByTagName("PRODCD").item(0).getTextContent().equals("B027")) {
								gasolinePrice = Integer.parseInt(eElement2.getElementsByTagName("PRICE").item(0).getTextContent());
							}
							else if(eElement2.getElementsByTagName("PRODCD").item(0).getTextContent().equals("D047")) {
								dieselPrice = Integer.parseInt(eElement2.getElementsByTagName("PRICE").item(0).getTextContent());
							}
							
						}
						
						
					}
					
					// test
					System.out.println("주유소 ID 	: " + stationID);
					System.out.println("상표 : " + trademark);
					System.out.println("주유소명  : " + name);
					System.out.println("도로명주소 : " + address);
					System.out.println("전화번호 : " + tel);
					System.out.println("지역코드 : " + regionCode);
					System.out.println("경정비유무 : " + maintYN);
					System.out.println("세차장유무 : " + washYN);
					System.out.println("편의점유무 : " + cvsYN);
					System.out.println("휘발유가격 : " + gasolinePrice);
					System.out.println("경유가격 : " + dieselPrice);
				
					
					
					gasStation = new GasStation(stationID,trademark,name,address,tel,regionCode,maintYN,washYN,cvsYN,gasolinePrice,dieselPrice);
					
					
				}
			}
			
				
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return gasStation; 
	}

}
