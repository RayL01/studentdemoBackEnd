package com.lhr.studentdemo.exception;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/10/21/01:29
 * @Description:
 */
public class ApiRequestException extends RuntimeException{
  public ApiRequestException(String message) {
    super(message);
  }

  public ApiRequestException(String message, Throwable cause) {
    super(message, cause);
  }
}
