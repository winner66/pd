package com.chk.pd.common.exception;

import com.chk.pd.common.vo.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Value("${spring.profiles.active}")
    private String profile;

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Response handException(Throwable e, HttpServletRequest request, HttpServletResponse response) {
        logger.error(e.getLocalizedMessage(), e);
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        logger.debug("客户端ip={}", ip);
        if (e instanceof BaseException) {
            BaseException exception = (BaseException) e;
            response.setStatus(200);
            if (!"production".equals(profile)) {
                return Response.failed(exception.getCode(), exception.getMessage(), exception.getExtMessage());
            }
            return Response.failed(exception.getCode(), exception.getMessage());
        } else if (e.getCause() != null && e.getCause().getCause() != null && e.getCause().getCause() instanceof BaseException) {
            //req类中代码验证抛出的异常，会被spring包装两层
            BaseException exception = (BaseException) e.getCause().getCause();
            response.setStatus(200);
            if (!"production".equals(profile)) {
                return Response.failed(exception.getCode(), exception.getMessage(), exception.getExtMessage());
            }
            return Response.failed(exception.getCode(), exception.getMessage());
        } else if (e instanceof MethodArgumentNotValidException || e instanceof MethodArgumentTypeMismatchException
                || e instanceof ConstraintViolationException) {
            response.setStatus(200);
            if (!"production".equals(profile)) {
                return Response.failed(SystemError.INVALID_PARAMETER, e.toString());
            }
            return Response.failed(SystemError.INVALID_PARAMETER);
        } else if (e instanceof NoHandlerFoundException) {
            response.setStatus(200);
            return Response.failed(SystemError.PAGE_NOT_FOUND);
        } else {
            response.setStatus(500);
            if (!"production".equals(profile)) {
                return Response.failed(SystemError.SYSTEM_INTERNAL_ERROR, e.getLocalizedMessage());
            }
            return Response.failed(SystemError.SYSTEM_INTERNAL_ERROR);
        }
    }
}
