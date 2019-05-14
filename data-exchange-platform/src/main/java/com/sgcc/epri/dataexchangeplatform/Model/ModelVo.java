package com.sgcc.epri.dataexchangeplatform.Model;

import java.io.Serializable;

/**
 * @author ：wmq
 * @date ：Created in 2019/5/13 11:09
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public class ModelVo implements Serializable{
    String name;
    String id;
    boolean flag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
