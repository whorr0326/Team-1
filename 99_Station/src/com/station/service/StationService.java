package com.station.service;

import static com.station.common.JDBCTemplate.commit;
import static com.station.common.JDBCTemplate.rollback;
import static com.station.common.JDBCTemplate.openConnection;

import java.sql.Connection;

import com.station.dao.StationDao;
import com.station.model.vo.GasStation;

public class StationService {
	StationDao stationDao = new StationDao();
	private Connection conn = null;
	
	public StationService() {
		conn = openConnection();
	}

	

	// 상호로 검색
//	public User selectByStationName(String stationNm) {
//		return stationDao.selectByStationName(conn, stationNm);
//	}

	// 지점아이디로 검색
	public GasStation selectByStationId(String stationId) {
		return stationDao.selectByStationId(conn, stationId);
	}
	
	public int insert(GasStation station) {
		int	result = stationDao.insert(conn, station);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

//	// 최저가 검색
//	public Station selectByStationMin() {
//		return stationDao.selectByStationMin();
//	}
//
//	// 평균가 검색
//	public Station selectByStationAvg() {
//		return stationDao.selectByStationAvg();
//	}

}
