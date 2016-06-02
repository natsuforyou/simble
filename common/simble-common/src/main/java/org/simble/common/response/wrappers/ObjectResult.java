package org.simble.common.response.wrappers;

import java.io.Serializable;

public class ObjectResult<T> implements Serializable {

    private static final long serialVersionUID = 4491955986842745524L;

    private T data;

    private ReturnCode returnCode;

    private String returnMsg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ReturnCode getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(ReturnCode returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public static <T> ObjectResult <T> success(String returnMsg, T data) {
        ObjectResult<T> result = new ObjectResult<>();
        result.setReturnCode(ReturnCode.SUCCESS);
        result.setReturnMsg(returnMsg);
        result.setData(data);
        return result;
    }

    public static ObjectResult success(String returnMsg) {
        return success(returnMsg, null);
    }

    public static <T> ObjectResult <T> fail(ReturnCode returnCode, String returnMsg) {
        ObjectResult<T> result = new ObjectResult<>();
        result.setReturnCode(returnCode);
        result.setReturnMsg(returnMsg);
        return result;
    }
}
