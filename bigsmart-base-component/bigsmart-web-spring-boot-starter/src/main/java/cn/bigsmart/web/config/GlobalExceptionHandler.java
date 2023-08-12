package cn.bigsmart.web.config;

import cn.bigsmart.base.errocode.ClientErrorCodeEnum;
import cn.bigsmart.base.exception.AbstractException;
import cn.bigsmart.base.result.Result;
import cn.bigsmart.web.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 拦截参数验证异常
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result validExceptionHandler(HttpServletRequest request, MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        FieldError firstFieldError = fieldErrors.get(0);
        String msg = Optional.ofNullable(firstFieldError)
                .map(FieldError::getDefaultMessage)
                .orElse("");
        log.error("[{}]{}, [msg]{}", request.getMethod(), getUrl(request), msg);
        return ResultUtils.failure(ClientErrorCodeEnum.REQUEST_ARGUMENT_ERROR.code(), msg);
    }

    /**
     * 拦截参数验证异常
     */
    @ExceptionHandler(value = BindException.class)
    public Result validExceptionHandler(HttpServletRequest request, BindException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        FieldError firstFieldError = fieldErrors.get(0);
        String msg = Optional.ofNullable(firstFieldError)
                .map(FieldError::getDefaultMessage)
                .orElse("");
        log.error("[{}]{}, [msg]{}", request.getMethod(), getUrl(request), msg);
        return ResultUtils.failure(ClientErrorCodeEnum.REQUEST_ARGUMENT_ERROR.code(), msg);
    }

    /**
     * 拦截参数验证异常
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public Result validExceptionHandler(HttpServletRequest request, ConstraintViolationException e) {
        String msg = e.getConstraintViolations().stream().map(cv -> cv.getMessage()).collect(Collectors.joining(","));
        log.error("[{}]{}, [msg]{}", request.getMethod(), getUrl(request), msg);
        return ResultUtils.failure(ClientErrorCodeEnum.REQUEST_ARGUMENT_ERROR.code(), msg);
    }

    /**
     * 拦截应用内抛出的异常
     */
    @ExceptionHandler(value = {AbstractException.class})
    public Result abstractException(HttpServletRequest request, AbstractException ex) {
        if (ex.getCause() != null) {
            log.error("[{}] {} [msg] {}", request.getMethod(), request.getRequestURL().toString(), ex.toString(), ex.getCause());
            return ResultUtils.failure(ex);
        }
        log.error("[{}] {} [msg] {}", request.getMethod(), request.getRequestURL().toString(), ex.toString());
        return ResultUtils.failure(ex);
    }

    /**
     * 拦截其他未知异常
     */
    @ExceptionHandler(value = Throwable.class)
    public Result defaultErrorHandler(HttpServletRequest request, Throwable throwable) {
        log.error("[{}] {} ", request.getMethod(), getUrl(request), throwable);
        return ResultUtils.failure();
    }

    private String getUrl(HttpServletRequest request) {
        if (StringUtils.isEmpty(request.getQueryString())) {
            return request.getRequestURL().toString();
        }
        return request.getRequestURL().toString() + "?" + request.getQueryString();
    }
}
