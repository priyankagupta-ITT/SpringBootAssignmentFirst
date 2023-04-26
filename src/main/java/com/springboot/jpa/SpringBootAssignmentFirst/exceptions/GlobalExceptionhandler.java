package com.springboot.jpa.SpringBootAssignmentFirst.exceptions;

import com.springboot.jpa.SpringBootAssignmentFirst.payload.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionhandler extends RuntimeException{

   private Logger logger = LoggerFactory.getLogger(GlobalExceptionhandler.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
        logger.info("Resource Exception Handler invoked !!");
        ApiResponse apiResponse =ApiResponse.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND).success(true).build();
        return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String , Object>> handlerMethodArgNotValidException(MethodArgumentNotValidException ex){
        logger.info("Method Arg Exception Handler invoked !!");
        List<ObjectError> allError = ex.getBindingResult().getAllErrors();
        Map<String,Object>  apiResponse = new HashMap<>();
        allError.stream().forEach(objectError -> {
            String messgae = objectError.getDefaultMessage();
            String field = ((FieldError)objectError).getField();
            apiResponse.put(messgae,field);
        });

        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

}
