package me.rpn;

import java.util.Scanner;

/**
 * 客户端程序
 * Create by songwenchao on 2019-05-25
 */
public class Client {
  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    Scanner sc = new Scanner(System.in);
    while (true) {
      String inputString = sc.nextLine();
      calculator.setReadStr(inputString);
      try {
        System.out.println("stack: " + calculator.calculate());
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
