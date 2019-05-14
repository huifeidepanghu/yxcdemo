package com.sgcc.epri.dataexchangeplatform.Controller;

import com.alibaba.fastjson.JSONObject;
import com.sgcc.epri.dataexchangeplatform.Service.ModelManager;
import com.sgcc.epri.dataexchangeplatform.Vo.RequestParams;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：wmq
 * @date ：Created in 2019/5/12 14:50
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@RestController
@RequestMapping("/data-exchange-platform")
public class ModelManagerController {
    @Autowired
    ModelManager modelManager;

    @ApiOperation(value = "获取模板类型")
    @RequestMapping(value="getModelType",method= RequestMethod.GET,produces="text/html;charset=utf-8")
    public String getModelType(){
        return modelManager.getModelType();
    }

    @ApiOperation(value = "筛选条件")
    @RequestMapping(value="getScreeningConditions",method= RequestMethod.GET,produces="text/html;charset=utf-8")
    public String getScreeningConditions(){
        return modelManager.getScreeningConditions();
    }

    @ApiOperation(value = "模板管理主界面")
    @RequestMapping(value="getModelManagerView",method= RequestMethod.GET,produces="text/html;charset=utf-8")
    public String getModelManagerView(int page, int size){
        return modelManager.getModelManagerView(page,size);
    }

	@RequestMapping(value="getTestPostClass",method=RequestMethod.POST,produces="text/html;charset=utf-8")
	public String getTestPostClass(@RequestBody RequestParams requestParam){

		return JSONObject.toJSONString(requestParam.toString());
	}
	@ApiOperation(value = "查看详情")
	@RequestMapping(value = "getParticularList",method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    public String getParticularList(@PathVariable("name") String name ,
                                    @RequestParam("page") int page,
                                    @RequestParam("size") int size,
                                    @RequestParam("ft") int ft){
        return modelManager.getParticularList(name,page,size,ft);
    }
    @ApiOperation(value = "删除模板列表")
    @RequestMapping(value = "DelectModel",method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    public String DelectModel(@PathVariable("name") String name){
        String model= modelManager.delectModel(name);
        return model;
    }

}
