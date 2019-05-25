package me.rpn.exception;

/**
 * 操作符 不够的异常
 * Create by songwenchao on 2019-05-25
 */
public class InsufficientParamException extends RuntimeException {

  private String message;

  public InsufficientParamException(String message) {
    super(message);
    this.message = message;
  }
}
