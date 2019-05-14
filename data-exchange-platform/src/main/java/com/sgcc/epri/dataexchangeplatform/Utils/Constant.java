package com.sgcc.epri.dataexchangeplatform.Utils;

import javax.annotation.PostConstruct;


public class Constant {
	
	public static final int Success_CODE = 200;
	public static final int InvalidParameter_CODE = 401;
	public static final int MissingParameter_CODE = 402;
	public static final int DBoperationFail_CODE = 501;
	public static final int NoDataFound_CODE = 302;
	
	public static final String Success_MSG = "获取成功";
	public static final String InvalidParameter_MSG  = "请求参数有误";
	public static final String MissingParameter_MSG  = "参数缺失";
	public static final String DBoperationFail_MSG  = "DB操作失败";
	public static final String NoDataFound_MSG  = "未查询到数据";

	public static String region="bj";
	public static String application="test";
	public static String vendor="epria";
	public static String version="v1";

	public static String driver;
	public static String url;
	public static String username;
	public static String password;
	
	public static String DATASYNC_DB;
	public static String OPERATION_DB;
	public static String DB_TYPE;
	
	
	public static String DB_DM = "dm";
	public static String DB_KING = "dmking";
	public static String DB_GBASE = "gbase";
	
	public static String SCHEME_NAME;
	public static String DB_NAME;
	public static String PROVICE_OWNER;
	public static String PROVICE_NAME;
	public static String SG_DATASOURCE;
	public static String FREQUENCYTYPE;
	public static String PROVICESERVICEAREA;

	static {
//		driver = PropertiesUtil.getProperty("/jdbc.properties", "jdbc.driver");
//		url = PropertiesUtil.getProperty("/jdbc.properties", "jdbc.url");
//		username = PropertiesUtil.getProperty("/jdbc.properties","jdbc.username");
//		password = PropertiesUtil.getProperty("/jdbc.properties","jdbc.password");
		OPERATION_DB = PropertiesUtil.getProperty("/application.properties", "op.db");
		DB_TYPE = PropertiesUtil.getProperty("/application.properties", "jdbc.type");
//		PROVICE_OWNER = PropertiesUtil.getProperty("/config-params.properties", "provice.owner");
//		SG_DATASOURCE = PropertiesUtil.getProperty("/config-params.properties", "sg.datasourceId");
//		FREQUENCYTYPE = PropertiesUtil.getProperty("/config-params.properties", "frequency.type");
//		PROVICE_NAME = PropertiesUtil.getProperty("/config-params.properties", "provice.name");
//		PROVICESERVICEAREA = PropertiesUtil.getProperty("/config-params.properties", "provice.name.eng");


//		if (DB_TYPE.equalsIgnoreCase("dm7")) {
//			DB_NAME ="";
//			SCHEME_NAME=OPERATION_DB;
//		} else {
//		 DB_NAME = OPERATION_DB.split( DB_TYPE.equals(DB_GBASE) ? ":" :
//		 "\\.")[0];
//		 System.out.println(DB_NAME);
//		 SCHEME_NAME = OPERATION_DB.split( DB_TYPE.equals(DB_GBASE) ? ":" :
//		 "\\.")[1];
//		}
	}
	
}
