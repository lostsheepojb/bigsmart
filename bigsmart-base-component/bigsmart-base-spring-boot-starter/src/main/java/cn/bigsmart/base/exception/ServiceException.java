package cn.bigsmart.base.exception;


import cn.bigsmart.base.errocode.ServiceErrorCodeEnum;

/**
 * 服务端异常
 *
 * @author cjj
 * @date 2023-06-18
 */
public class ServiceException extends AbstractException {

    public ServiceException() {
        this(ServiceErrorCodeEnum.SERVICE_ERROR);
    }

    public ServiceException(String errorMessage) {
        super(ServiceErrorCodeEnum.SERVICE_ERROR.code(), errorMessage);
    }

    public ServiceException(ServiceErrorCodeEnum errorCode) {
        super(errorCode);
    }

    @Override
    public String toString() {
        return "ServiceException{" + "code=" + errorCode + "," + "message=" + errorMessage + "}";
    }
}
