package cn.bigsmart.base.errocode;

/**
 * 基础错误码定义
 *
 * @author cjj
 * @date 2023-06-18
 */
public enum RemoteErrorCodeEnum implements ErrorCode {

    // ========== 一级宏观错误码 调用第三方服务出错 ==========
    REMOTE_ERROR("T000001", "调用第三方服务出错");

    private final String code;

    private final String message;

    RemoteErrorCodeEnum(String code, String message) {
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
