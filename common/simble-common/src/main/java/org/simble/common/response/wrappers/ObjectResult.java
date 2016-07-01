package org.simble.common.response.wrappers;

import java.io.Serializable;

import static org.simble.common.response.wrappers.ReturnCode.SUCCESS;

public class ObjectResult<T> implements Serializable {

    private static final long serialVersionUID = 4491955986842745524L;

    private T data;

    private String returnCode;

    private String returnMsg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public static <T> ObjectResult <T> success(T data) {
        ObjectResult<T> result = new ObjectResult<>();
        result.setReturnCode(SUCCESS.getReturnCode());
        result.setReturnMsg(SUCCESS.getReturnMsg());
        result.setData(data);
        return result;
    }

    public static ObjectResult success() {
        return success(null);
    }

    public static <T> ObjectResult <T> fail(ReturnCode returnCode, String returnMsg) {
        ObjectResult<T> result = new ObjectResult<>();
        result.setReturnCode(returnCode.getReturnCode());
        result.setReturnMsg(returnCode.getReturnMsg() + returnMsg);
        return result;
    }

    public static <T> ObjectResult <T> fail(ReturnCode returnCode) {
        ObjectResult<T> result = new ObjectResult<>();
        result.setReturnCode(returnCode.getReturnCode());
        result.setReturnMsg(returnCode.getReturnMsg());
        return result;
    }

}
