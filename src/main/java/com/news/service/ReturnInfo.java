package com.news.service;


public class ReturnInfo {


    /**
     * 返回码 20:成功 30:程序异常 80:业务异常
     */
    Integer code;

    /**
     * 返回描述
     */
    String msg;

    /**
     * 详细信息，改对象可以是复杂的组合对象
     */
    Object data;




    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
