package com.yedam.lambda;

import java.util.function.BiConsumer;

public class ConsumerExample {
	public static void main(String[] args) {
		BiConsumer<Students, String> biCon = (std, str) -> {
			std.getInfo(); // 안녕하세요 이름:?? , 나이:??
			System.out.println(str);
		};
		Students s1 = new Students("Hwang", 20);
		String s2 = "안녕하세요.";
		biCon.accept(s1, s2);

		BiConsumer<String, String> biStr = (str1, str2) -> {
			System.out.println(str1 + " " + str2);
		};
		biStr.accept("람다는", " 어려워!!");
	}

	static void printAccept(BiConsumer<Students, String> biCon, //
			Students std, //
			String str) {
//		biCon = (s1, s2) -> {
//			System.out.println(s2 + " ");
//			s1.getInfo();
//		};
		biCon.accept(std, str);
	}
}
