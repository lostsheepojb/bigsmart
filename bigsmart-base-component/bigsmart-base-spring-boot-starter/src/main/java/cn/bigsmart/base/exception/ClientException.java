package cn.bigsmart.base.exception;


import cn.bigsmart.base.errocode.ClientErrorCodeEnum;

/**
 * 客户端异常
 *
 * @author cjj
 * @date 2023-06-18
 */
public class ClientException extends AbstractException {

    public ClientException() {
        this(ClientErrorCodeEnum.CLIENT_ERROR);
    }

    public ClientException(String errorMessage) {
        super(ClientErrorCodeEnum.CLIENT_ERROR.code(), errorMessage);
    }

    public ClientException(ClientErrorCodeEnum errorCode) {
        super(errorCode);
    }

    @Override
    public String toString() {
        return "ClientException{" + "code=" + errorCode + "," + "message=" + errorMessage + "}";
    }
}
