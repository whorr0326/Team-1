
DROP TABLE TBL_GAS_STATION;

CREATE TABLE TBL_GAS_STATION (
	STATION_ID	VARCHAR(255)	NOT NULL,
	STATION_TRADEMARK	VARCHAR(255)	NULL,
	STATION_NAME	VARCHAR(255)	NULL,
	STATION_ADDRESS	VARCHAR(255)	NULL,
	STATION_TEL	VARCHAR(255)	NULL,
	REGION_CODE	VARCHAR(255)	NOT NULL,
	MAINT_YN	VARCHAR(255)	NULL,
	WASH_YN	VARCHAR(255)	NULL,
	CVS_YN	VARCHAR(255)	NULL,
	GASOLINE_PRICE	VARCHAR(255)	NULL,
	DIESEL_PRICE	VARCHAR(255)	NULL
);

INSERT INTO TBL_GAS_STATION VALUES('A0001145', 'gs', '보라매주유소', '서울','010-2020-2020','0101','y','y','y', '1111','1234');