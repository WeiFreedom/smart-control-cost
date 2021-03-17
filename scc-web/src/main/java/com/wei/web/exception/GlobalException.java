package com.wei.web.exception;


import com.wei.utils.constant.AppCode;
import com.wei.utils.constant.AppConstant;
import com.wei.utils.exception.AuthenticationException;
import com.wei.utils.exception.ValidatorException;
import com.wei.utils.exception.WorkingException;
import com.wei.web.domain.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalException {

    @ExceptionHandler(value = Exception.class)
    public ResultVo workingException(HttpServletRequest request, Exception e) {
        log.error(e.getMessage(),e);
        if (e instanceof WorkingException) {
            return new ResultVo(AppCode.ERROR, e.getMessage(), e.toString());
        } else if (e instanceof AuthenticationException) {
            return new ResultVo(AppCode.UNAUTHENTICATED, e.getMessage(), e.toString());
        } else if (e instanceof ValidatorException) {
            return new ResultVo(AppCode.VALIDATOR_ERROR, e.getMessage(), e.toString());
        }
        return new ResultVo(AppCode.ERROR, e.getMessage(), e.toString());
    }

}
