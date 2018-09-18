package com.walkBAM.util;

public class AjaxResult {
    private static final String OK = "ok";
    private static final String ERROR = "error";
    private boolean isError = false;
    private String msg = OK;

    public AjaxResult success() {
        return this;
    }

    public AjaxResult failure() {
        isError = true;
        msg = ERROR;
        return this;
    }

    public AjaxResult failure(String message) {
        isError = true;
        msg = message;
        return this;
    }

    public boolean getIsError() {
        return isError;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
