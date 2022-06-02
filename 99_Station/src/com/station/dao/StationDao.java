package com.station.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.station.model.vo.GasStation;
import com.station.model.vo.User;

public class StationDao {

//	public User selectByStationName(Connection conn, String stationNm) {
//		return null;
//	}

	public GasStation selectByStationId(Connection conn, String stationId) {
		GasStation info = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM TBL_GAS_STATION WHERE STATION_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,stationId);
			
			System.out.println(pstmt.toString());
			rs = pstmt.executeQuery();
		

			while (rs.next()) {
				int count = 1;
				String stationId2 = rs.getString(count++);
				String stationTm = rs.getString(count++);
				String stationNm = rs.getString(count++);
				String stationAddr = rs.getString(count++);
				String stationTel = rs.getString(count++);
				int regionCd = rs.getInt(count++);
				String maintYN = rs.getString(count++);
				String washYN = rs.getString(count++);
				String cvsYN = rs.getString(count++);
				int gasolinePrice = rs.getInt(count++);
				int dieselPrice = rs.getInt(count++);

				info = new GasStation(stationId2, stationTm, stationNm, stationAddr, stationTel, regionCd, maintYN, washYN,
						cvsYN, gasolinePrice, dieselPrice);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			close(pstmt);
//			close(rs);
		}
		return info;

	}

//	public User selectByStationMin() {
//		return null;
//	}
//
//	public User selectByStationAvg() {
//		return null;
//	}

	public  int insert(Connection conn, GasStation station) {
		try {
			String sql = "INSERT INTO "
					+ "TBL_GAS_STATION(G_STATION_ID, G_STATION_TRADEMARK, G_STATION_NAME, G_STATION_ADDRESS, G_STATION_TEL, "
					+ "	   REGION_CODE, MAINT_YN, WASH_YN, CVS_YN, GASOLINE_PRICE, DIESEL_PRICE) " 
					+ "VALUES("
					+ "		   ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			int cnt = 1;
			pstmt.setString(cnt++, station.getStationId());
			pstmt.setString(cnt++, station.getStationTm());
			pstmt.setString(cnt++, station.getStationNm());
			pstmt.setString(cnt++, station.getStationAddr());
			pstmt.setString(cnt++, station.getStationTel());
			pstmt.setInt(cnt++, station.getRegionCd());
			pstmt.setString(cnt++, station.getMaintYN());
			pstmt.setString(cnt++, station.getWashYN());
			pstmt.setString(cnt++, station.getCvsYN());
			pstmt.setInt(cnt++, station.getGasolinePrice());
			pstmt.setInt(cnt++, station.getDieselPrice());

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
