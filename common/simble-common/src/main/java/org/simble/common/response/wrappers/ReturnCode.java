package org.simble.common.response.wrappers;

enum ReturnCode {

    SUCCESS("SUCCESS", "操作成功"),
    ERROR("ERROR", "操作失败"),
    NO_RECORD("NO_RECORD", "没有相关记录");

    private String returnCode;

    private String returnMsg;

    ReturnCode(String returnCode, String returnMsg) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }
}
