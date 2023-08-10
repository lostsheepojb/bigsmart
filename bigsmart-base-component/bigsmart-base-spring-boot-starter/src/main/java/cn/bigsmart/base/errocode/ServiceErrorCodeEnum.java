package cn.bigsmart.base.errocode;

/**
 * 基础错误码定义
 *
 * @author cjj
 * @date 2023-06-18
 */
public enum ServiceErrorCodeEnum implements ErrorCode {

    // ========== 一级宏观错误码 系统执行出错 ==========
    SERVICE_ERROR("S000001", "系统执行出错"),

    // ========== 二级宏观错误码 系统执行超时 ==========
    SERVICE_TIMEOUT_ERROR("S000100", "系统执行超时");

    private final String code;

    private final String message;

    ServiceErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
