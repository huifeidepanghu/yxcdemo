package com.sgcc.epri.dataexchangeplatform.Service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.sgcc.epri.dataexchangeplatform.Datasource.CustomerContextHolder;
import com.sgcc.epri.dataexchangeplatform.Mapper.SubjectMapper;
import com.sgcc.epri.dataexchangeplatform.Model.ModelVo;
import com.sgcc.epri.dataexchangeplatform.Service.ModelManager;
import com.sgcc.epri.dataexchangeplatform.Utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：wmq
 * @date ：Created in 2019/5/12 14:50
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@Service("modelManager")
public class ModelManagerImpl implements ModelManager {
    public ModelManagerImpl(){
        changeDb();
    }

    private static Logger log = LoggerFactory.getLogger(ModelManagerImpl.class);
    String schemea = Constant.OPERATION_DB;

    @Autowired
    private SubjectMapper subjectmapper;

    @Override
    public String getModelType() {
        changeDb();
        String sql ="SELECT CODE,NAME FROM DKY_DB.EXCPLF.EXCPLF_CONF_DATATYPE";
        List<Map<String, Object>> list= subjectmapper.getData(sql);

        return JSONObject.toJSONString(list);
    }

    @Override
    public String getScreeningConditions() {
        changeDb();
        String sql = "select ID,NAME_ABBREVIATION as NAME from \"DKY_DB\".\"EXCPLF\".\"EXCPLF_CONF_DATASOURCE\" WHERE \"LEVEL\"<1004\n" +
                "union\n" +
                "select distinct object_id,object_name from \"DKY_DB\".\"EXCPLF\".\"EXCPLF_CONF_MEASURE\"\n" +
                "union select code,name from \"DKY_DB\".\"EXCPLF\".\"EXCPLF_CONF_VOLTAGETYPE\";\n";
        List<Map<String, Object>> list= subjectmapper.getData(sql);
        System.out.println("*******************"+list.toString());
        Map<String,Object> mapDataList = new HashMap<>();
        List<ModelVo> listDatasource =new ArrayList<>();
        List<ModelVo> listObjectType =new ArrayList<>();
        List<ModelVo> listVoletage = new ArrayList<>();


        for (Map<String, Object> map : list) {
           String id = map.get("ID")+"";
           String name = map.get("NAME")+"";
           if(id.length()>4){
               ModelVo modelVo = new ModelVo();
               modelVo.setName(name);
               modelVo.setId(id);
//               Map<String,Object> mapDatasource = new HashMap<>();
//               mapDatasource.put("name",name);
//               mapDatasource.put("id",id);
               listDatasource.add(modelVo);
           }else if(id.substring(0,2).equals("10")){
               ModelVo modelVo = new ModelVo();
               modelVo.setName(name);
               modelVo.setId(id);
               listVoletage.add(modelVo);
           }else{
               ModelVo modelVo = new ModelVo();
               modelVo.setName(name);
               modelVo.setId(id);
               listObjectType.add(modelVo);
           }
        }
        mapDataList.put("datasource",listDatasource);
        mapDataList.put("objectType",listObjectType);
        mapDataList.put("voltage",listVoletage);
        return JSONObject.toJSONString(mapDataList);
    }

    @Override
    public String getModelManagerView(int page, int limit) {
        changeDb();
        int rowsPage = limit;// 每页行数
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("status",200);
        map.put("message","");

        String table_name=schemea+"EXCPLF_TEMPLATE_B";
        int count =subjectmapper.countResult(table_name);
        System.out.println("*********"+count);
        int offset = (page - 1 < 0 ? 0 : page - 1) * rowsPage;
        String sql = "SELECT ID ,NAME, to_char(CREATE_TIME,'yyyy-MM-dd hh:mi:ss') AS DATE, TYPE from "+schemea+"EXCPLF_TEMPLATE_B LIMIT  "+limit+" OFFSET "+offset;
        //List<Map<String, Object>> listData =new ArrayList<>();

        List<Map<String, Object>> list =subjectmapper.getData(sql);

        map.put("total",count);
        map.put("rows",list);
        return JSONObject.toJSONString(map);
    }

    /*@Override
    public String getParticularList(String name) {
        changeDb();
        //视图的vo
        ModelVo modelVo = new ModelVo();
        String sql ="SELECT NAME FROM EXCPLF_TEMPLATE_B WHERE NAME ="+ name;
        List<Map<String, Object>> list= subjectmapper.getData(sql);
            if (modelVo.isFlag() == true){

            }
        return JSONObject.toJSONString(list);

    }*/

    /**
     * 删除模板列表
     * @param name
     * @return
     */
    @Override
    public String delectModel(String name) {
        changeDb();
        String sql = "DELECT FROM EXCPLF_TEMPLATE_B WHERE NAME = "+name;
        boolean model = subjectmapper.delectModel(sql);
        if (model == false){
            return Constant.DBoperationFail_MSG;
        }
        return JSONObject.toJSONString(model);
    }
    /**
     * 查询列表
     * @param name
     * @param
     * @return
     */
    @Override
    public String getParticularList(String name, int page,int limit, Integer ft) {
        changeDb();
        if (ft == null){
           //根据选中的id查询对应的数据  并分页
            String sql ="SELECT TYPE OBJECT_ID 量测类型 MEASTYPE TIMESTEP FROM";
            List<Map<String, Object>> data = subjectmapper.getData(sql);

        }else{
            //根据选中的id和ft查出对应的数据 并分页

        }
//        int rowsPage = limit;
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("status", 200);
//        map.put("message", "");
//
//        String table_name= schemea+"EXCPLF_TEMPLATE_B";
//        int count = subjectmapper.countResult(table_name);
//        int offset = (page -1<0 ? 0:page-1)*rowsPage;
//        String sql ="SELECT 序号 对象类型 对象ID 量测类型 量测类型ID 数据间隔 ";
//        List<Map<String, Object>> list =subjectmapper.getData(sql);
//
//        map.put("total",count);
//        map.put("rows",list);
//       return JSONObject.toJSONString(map);
    }


    public void changeDb(){
        if(Constant.DB_TYPE.equals("dm")){
            CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_DM6);
        }else{
            CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_GBASE);
        }
    }
}
