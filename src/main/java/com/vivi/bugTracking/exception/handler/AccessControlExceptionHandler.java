package com.vivi.bugTracking.exception.handler;

import com.vivi.bugTracking.exception.ApiResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.NotFoundException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@ControllerAdvice(basePackages = {"com.vivi.bugTracking.controller"})
public class AccessControlExceptionHandler {
    @ExceptionHandler(UnauthenticatedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ApiResponseMessage handleException(UnauthenticatedException e) {
        log.error("Unauthorized.", e);
        return new ApiResponseMessage("unauthorized", e.getMessage());
    }

    @ExceptionHandler(AuthorizationException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ApiResponseMessage handleException(AuthorizationException e) {
        log.error("Authorization failure", e);
        return new ApiResponseMessage("authorizationFailure", e.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ApiResponseMessage handleException(NotFoundException e) {
        log.error("resource not found", e);
        return new ApiResponseMessage("resourceNotFound", e.getMessage());
    }

    @ExceptionHandler(UnknownAccountException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ApiResponseMessage handleException(UnknownAccountException e) {
        log.error("unknown account", e);
        return new ApiResponseMessage("unknownAccount", e.getMessage());
    }
}

