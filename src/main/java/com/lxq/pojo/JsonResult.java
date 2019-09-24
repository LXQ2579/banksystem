package com.lxq.pojo;

/**
 * @author 刘小七
 * @date 2019/09/19  14:02:00
 */
public class JsonResult {

    private Integer code;
    private Object info;

    public JsonResult() {
    }

    public JsonResult(Integer code, Object info) {
        this.code = code;
        this.info = info;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }
}
