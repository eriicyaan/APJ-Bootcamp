package com.domain.handler;

import com.domain.exception.GameAlreadyFinishedException;
import com.domain.exception.NotValidFieldException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(NotValidFieldException.class)
    public ProblemDetail handleNotValidField(NotValidFieldException exception) {

        return ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                exception.getMessage());
    }


    @ExceptionHandler(GameAlreadyFinishedException.class)
    public ProblemDetail handleGameOver(GameAlreadyFinishedException exception) {

        return ProblemDetail.forStatusAndDetail(
                HttpStatus.CONFLICT,
                exception.getMessage());
    }

}
