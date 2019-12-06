package com.poshist.signClass.common;

public class RunTimeException extends Exception {
    String code;
    String msg;

    public RunTimeException(String msg) {
        super(msg);
    }

    public RunTimeException(String code, String msg) {

        super("code:" + code + ",msg:" + msg);
        setCode(code);
        setMsg(msg);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
