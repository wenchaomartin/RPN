package me.rpn.exception;

/**
 * 除数为0 异常
 * Create by songwenchao on 2019-05-25
 */
public class ByzeroException extends RuntimeException {

  private String message;

  public ByzeroException(String message) {
    super(message);
    this.message = message;
  }
}
