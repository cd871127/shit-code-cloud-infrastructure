package com.shit.code.cloud.infrastructure.security;


import com.shit.code.common.web.response.HttpResponse;

/**
 * @author Anthony
 * @date 11/1/20
 **/
public enum SecurityExceptionEnum implements HttpResponse {
    /**
     *
     */
    ERR_DATA_NOT_EXIST("00100001", "数据不存在,key:%s"),

    ERR_INSERT_COUNT("00100002", "插入数据量异常，预期:%s, 实际:%s"),

    ERR_DELETE_COUNT("00100003", "删除数据量异常，预期:%s, 实际:%s"),
    ERR_UPDATE_COUNT("00100004", "更新数据量异常，预期:%s, 实际:%s"),
    ;

    SecurityExceptionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private final String code;
    private final String msg;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
