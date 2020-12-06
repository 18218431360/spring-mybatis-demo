package com.lks.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Msg
 * @Description TODO
 * @Author lks
 * @Date 2020/4/18 12:45
 * @Version 1.0
 */
public class Msg {

    // 状态码 100:成功 200:失败
    private int code;

    // 返回信息
    private String msg;

    // 返回数据
    private HashMap<String, Object> extend = new HashMap<>();

    // 操作成功
    public Msg success() {
        Msg msg = new Msg();
        msg.setCode(100);
        msg.setMsg("操作成功");
        return msg;
    }

    // 操作失败
    public Msg fail() {
        Msg msg = new Msg();
        msg.setCode(200);
        msg.setMsg("操作失败");
        return msg;
    }

    public Msg add(String key, Object object) {
        this.getExtend().put(key, object);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public HashMap<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(HashMap<String, Object> extend) {
        this.extend = extend;
    }
}
