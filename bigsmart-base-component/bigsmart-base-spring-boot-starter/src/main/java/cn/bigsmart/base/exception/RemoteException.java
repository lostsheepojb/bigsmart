package cn.bigsmart.base.exception;


import cn.bigsmart.base.errocode.RemoteErrorCodeEnum;

/**
 * 第三方服务异常
 *
 * @author cjj
 * @date 2023-06-18
 */
public class RemoteException extends AbstractException {

    public RemoteException() {
        this(RemoteErrorCodeEnum.REMOTE_ERROR);
    }

    public RemoteException(String errorMessage) {
        super(RemoteErrorCodeEnum.REMOTE_ERROR.code(), errorMessage);
    }

    public RemoteException(RemoteErrorCodeEnum errorCode) {
        super(errorCode);
    }

    @Override
    public String toString() {
        return "RemoteException{" + "code=" + errorCode + "," + "message=" + errorMessage + "}";
    }
}
