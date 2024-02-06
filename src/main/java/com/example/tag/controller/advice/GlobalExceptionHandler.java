package com.example.tag.controller.advice;

import com.example.tag.dto.response.BaseResponseModel;
import com.example.tag.exception.OAuth2Exception;
import com.example.tag.exception.ServiceAndPriceException;
import com.example.tag.exception.TagException;
import com.example.tag.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({TagException.class})
    @ResponseBody
    ResponseEntity<BaseResponseModel> handle(TagException tagException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BaseResponseModel.builder().success(false).errorMessage(tagException.getMessage()).build());
    }

    @ExceptionHandler({ServiceAndPriceException.class})
    @ResponseBody
    ResponseEntity<BaseResponseModel> handle(ServiceAndPriceException serviceAndPriceException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BaseResponseModel.builder().success(false).errorMessage(serviceAndPriceException.getMessage()).build());
    }

    @ExceptionHandler({UserException.class})
    @ResponseBody
    ResponseEntity<BaseResponseModel> handle(UserException userException) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(BaseResponseModel.builder().success(false).errorMessage(userException.getMessage()).build());
    }

    @ExceptionHandler({OAuth2Exception.class})
    @ResponseBody
    ResponseEntity<BaseResponseModel> handle(OAuth2Exception oAuth2Exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(BaseResponseModel.builder().success(false).errorMessage(oAuth2Exception.getMessage()).build());
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    ResponseEntity<BaseResponseModel> handle(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(BaseResponseModel.builder().success(false).errorMessage(exception.getMessage()).build());
    }
}
