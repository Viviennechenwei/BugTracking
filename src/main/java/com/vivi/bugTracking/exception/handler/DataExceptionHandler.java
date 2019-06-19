package com.vivi.bugTracking.exception.handler;

import com.vivi.bugTracking.exception.ApiResponseMessage;
import com.vivi.bugTracking.exception.DataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice(basePackages = {"com.vivi.bugTracking.controller"})
public class DataExceptionHandler {
    @ExceptionHandler(DataException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ApiResponseMessage handleException(DataException e) {
        log.error("Data error.", e);
        return new ApiResponseMessage("dataError", e.getMessage());
    }
}

