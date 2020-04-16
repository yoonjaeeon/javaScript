package com.yedam.network;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList; 
import java.util.Scanner;

class Address {
   String name;
   String age;
   String phone;

   public Address(String name, String age, String phone) {
      super();
      this.name = name;
      this.age = age;
      this.phone = phone;
   }

}// end of address

public class CellPhone {
   static String fileName = "src/com/yedam/network/phoneList.txt";

   static Scanner scn = new Scanner(System.in);

   public static void main(String[] args) {

      String name, age, phone;
      
      
      System.out.println("친구 연락처 관리");

      ArrayList<Address> list = new ArrayList<>();

      System.out.println("이름 입력>");
      name = scn.nextLine();

      System.out.println("나이 입력>");
      age = scn.nextLine();

      System.out.println("핸드폰번호 입력");
      phone = scn.nextLine();
      
      System.out.println("입력 완료");
      Address addr = new Address(name, age, phone);

      FileWriter fw;
      try {
         fw = new FileWriter(fileName, true);
         fw.write(addr.name + ", " + addr.age + ", " + addr.phone + "\\n");
         fw.flush();
         fw.close();
      } catch (IOException e) {
         e.printStackTrace();
      }

//      FileOutputStream fos = new FileOutputStream(fileName);
//      for (Address adr : list) {
//         fos.write(adr.getBytes());
//      }

   }// end of main
}// end of CellPhone