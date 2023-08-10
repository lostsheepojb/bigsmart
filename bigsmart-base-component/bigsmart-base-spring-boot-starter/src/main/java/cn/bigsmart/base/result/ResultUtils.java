package cn.bigsmart.base.result;

import cn.bigsmart.base.errocode.ServiceErrorCodeEnum;
import cn.bigsmart.base.exception.AbstractException;

import java.util.Optional;

/**
 * 返回结果工具类
 */
public class ResultUtils {

    /**
     * 构造成功响应
     *
     * @return
     */
    public static Result<Void> success() {
        Result<Void> result = new Result<>();
        result.setCode(Result.SUCCESS_CODE);
        return result;

    }

    /**
     * 构造带返回数据的成功响应
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(Result.SUCCESS_CODE);
        result.setData(data);
        return result;
    }

    /**
     * 构建服务端失败响应
     *
     * @return
     */
    protected static Result<Void> failure() {
        Result<Void> result = new Result<>();
        result.setCode(ServiceErrorCodeEnum.SERVICE_ERROR.code());
        result.setMessage(ServiceErrorCodeEnum.SERVICE_ERROR.message());
        return result;

    }

    /**
     * 通过 {@link AbstractException} 构建失败响应
     *
     * @param abstractException
     * @return
     */
    protected static Result<Void> failure(AbstractException abstractException) {
        String errorCode = Optional.ofNullable(abstractException.getErrorCode()).orElse(ServiceErrorCodeEnum.SERVICE_ERROR.code());
        String errorMessage = Optional.ofNullable(abstractException.getErrorMessage()).orElse(ServiceErrorCodeEnum.SERVICE_ERROR.message());
        Result<Void> result = new Result<>();
        result.setCode(errorCode);
        result.setMessage(errorMessage);
        return result;
    }

    /**
     * 通过 errorCode、errorMessage 构建失败响应
     *
     * @param errorCode
     * @param errorMessage
     * @return
     */
    protected static Result<Void> failure(String errorCode, String errorMessage) {
        Result<Void> result = new Result<>();
        result.setCode(errorCode);
        result.setMessage(errorMessage);
        return result;
    }

}
