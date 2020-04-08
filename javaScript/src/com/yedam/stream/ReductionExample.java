package com.yedam.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class ReductionExample {
   public static void main(String[] args) {
      List<Student> list = Arrays.asList(new Student("Hong", 92), //
            new Student("Hwang", 95), //
            new Student("Park", 88));

      //Student.getScore int형 리턴타입을 sum메서드로 집계처리를 한 결과를 가져옴
      int sum = list.stream().mapToInt(s -> s.getScore()).sum();
      
      //Student.getScore reduce메서드를 통해 집계처리한 결과를 가져옴.
      OptionalInt oi = list.stream().mapToInt(s -> s.getScore()).reduce((a, b) -> a + b);
      if (oi.isPresent()) { //isPresent  - filter 값이 빠졌을때, 요소가 있는지 체크해줌
         System.out.println(oi.getAsInt());
      }
      int result  = list.stream()
      .mapToInt(s -> s.getScore())
      .reduce(0, (a,b) -> a+b);
      System.out.println(result);
   }
}