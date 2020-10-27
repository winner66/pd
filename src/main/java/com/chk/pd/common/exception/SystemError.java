package com.chk.pd.common.exception;

public enum SystemError implements IError {

    SYSTEM_INTERNAL_ERROR("500", "网络异常，请稍后重试"),
    INVALID_PARAMETER("400", "请输入合法的参数"),
    PAGE_NOT_FOUND("404", "请求的地址不存在"),
    ;

    String code;
    String message;

    SystemError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
