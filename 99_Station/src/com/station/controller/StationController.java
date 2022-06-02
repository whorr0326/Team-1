package com.station.controller;



import com.station.api.GasOpenApiManager;
import com.station.controller.StationController;
import com.station.model.vo.GasStation;
import com.station.service.StationService;

public class StationController {
	StationService stationService = new StationService();
	
	

	public GasStation searchByStationId(String stationId){
		GasStation station = GasOpenApiManager.searchByID(stationId);
		
		
		System.out.println(station);
		stationService.insert(station);
		return stationService.selectByStationId(stationId);
	}
	
//	public List<Station> searchStationName(String StationNm){
//		return stationService.selectByStationName(StationNm);
//	}
//	
//	public List<Station> searchByStationMin(){
//		return stationService.selectByStationMin();	
//	}
//	
//	public List<Station> searchByStationAvg(){
//		return stationService.selectByStationAvg();
//	}
//	

	
	
}
