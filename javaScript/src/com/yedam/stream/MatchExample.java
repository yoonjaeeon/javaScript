package com.yedam.stream;

import java.util.Arrays;

public class MatchExample {
	public static void main(String[] args) {
		int[] intArr = { 2, 4, 6, 5 };
		boolean isTrue = Arrays.stream(intArr).allMatch(n -> n % 2 == 0);
//		boolean isTrue = Arrays.stream(intArr).anyMatch(n -> n % 2 == 0); 
//		boolean isTrue = Arrays.stream(intArr).noneMatch(n -> n % 2 == 0);
		if (isTrue) {
			System.out.println("전체 짝수.");
		} else {
			System.out.println("전체 짝수가 아님.");
		}
	}
}
