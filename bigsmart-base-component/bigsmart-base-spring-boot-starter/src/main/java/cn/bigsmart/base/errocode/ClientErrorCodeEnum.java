package cn.bigsmart.base.errocode;

/**
 * 基础错误码定义
 *
 * @author cjj
 * @date 2023-06-18
 */
public enum ClientErrorCodeEnum implements ErrorCode {
    
    // ========== 客户端错误 ==========
    CLIENT_ERROR("C000001", "用户端错误"),
    
    // ========== 二级客户端错误：用户注册错误 ==========
    ACCESS_TOKEN_NULL_ERROR("C000100", "访问token为空"),
    ACCESS_TOKEN_DELETE_ERROR("C000101", "幂等token已被使用或失效");

    private final String code;
    private final String message;
    
    ClientErrorCodeEnum(String code, String message) {
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
