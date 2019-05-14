package com.sgcc.epri.dataexchangeplatform.Mapper;

import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public interface SubjectMapper {

	List<Map<String, Object>> getInfoByParam(Map<String, Object> map);
	
	List<LinkedHashMap<String, Object>> getInfoByParamXe(Map<String, Object> map);
	
	List<Map<String, Object>> getData(@Param(value = "sql") String sql);

	/**
	 * 统计记录条数
	 *
	 * @param
	 * @return
	 * int
	 */
	int countResult(@Param(value = "table_name") String table_name);


	boolean delectModel(String sql);
}
