package cn.bigsmart.base.exception;

import cn.bigsmart.base.errocode.ErrorCode;
import lombok.Getter;
import lombok.Setter;


/**
 * 项目抽象异常
 *
 * @author cjj
 * @date 2023-06-18
 */
@Getter
@Setter
public abstract class AbstractException extends RuntimeException {

    public final String errorCode;

    public final String errorMessage;

    public AbstractException(ErrorCode errorCode) {
        super(errorCode.message());
        this.errorCode = errorCode.code();
        this.errorMessage = errorCode.message();
    }

    public AbstractException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "AbstractException{" + "code=" + errorCode + "," + "message=" + errorMessage + "}";
    }
}
