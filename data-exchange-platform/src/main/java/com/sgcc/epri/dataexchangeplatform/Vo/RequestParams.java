package com.sgcc.epri.dataexchangeplatform.Vo;

import java.io.Serializable;

/**
 * @author ：wmq
 * @date ：Created in 2019/4/29 12:26
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public class RequestParams implements Serializable {

    String id;
    String startTimeStr;
    String endTimeStr;
    double offsetValue;
    Integer offsetType;
    Integer planDataType;
    Integer activeDataType;
    Integer xeInt;
    Integer sgId;
    Integer areaId;
    String compareTime;
    String compareId;
    String curveType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartTimeStr() {
        return startTimeStr;
    }

    public void setStartTimeStr(String startTimeStr) {
        this.startTimeStr = startTimeStr;
    }

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
    }

    public double getOffsetValue() {
        return offsetValue;
    }

    public void setOffsetValue(double offsetValue) {
        this.offsetValue = offsetValue;
    }

    public Integer getOffsetType() {
        return offsetType;
    }

    public void setOffsetType(Integer offsetType) {
        this.offsetType = offsetType;
    }

    public Integer getPlanDataType() {
        return planDataType;
    }

    public void setPlanDataType(Integer planDataType) {
        this.planDataType = planDataType;
    }

    public Integer getActiveDataType() {
        return activeDataType;
    }

    public void setActiveDataType(Integer activeDataType) {
        this.activeDataType = activeDataType;
    }

    public Integer getXeInt() {
        return xeInt;
    }

    public void setXeInt(Integer xeInt) {
        this.xeInt = xeInt;
    }

    public Integer getSgId() {
        return sgId;
    }

    public void setSgId(Integer sgId) {
        this.sgId = sgId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getCompareTime() {
        return compareTime;
    }

    public void setCompareTime(String compareTime) {
        this.compareTime = compareTime;
    }

    public String getCompareId() {
        return compareId;
    }

    public void setCompareId(String compareId) {
        this.compareId = compareId;
    }

    public String getCurveType() {
        return curveType;
    }

    public void setCurveType(String curveType) {
        this.curveType = curveType;
    }

    @Override
    public String toString() {
        return "RequestParams{" +
                "id='" + id + '\'' +
                ", startTimeStr='" + startTimeStr + '\'' +
                ", endTimeStr='" + endTimeStr + '\'' +
                ", offsetValue=" + offsetValue +
                ", offsetType=" + offsetType +
                ", planDataType=" + planDataType +
                ", activeDataType=" + activeDataType +
                ", xeInt=" + xeInt +
                ", sgId=" + sgId +
                ", areaId=" + areaId +
                ", compareTime='" + compareTime + '\'' +
                ", compareId='" + compareId + '\'' +
                ", curveType='" + curveType + '\'' +
                '}';
    }
}
