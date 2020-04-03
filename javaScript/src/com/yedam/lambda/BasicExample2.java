package com.yedam.lambda;

@FunctionalInterface
interface MyInterface1<T> {
	void get(T t);
}

@FunctionalInterface
interface MyInterface2 {
	String get(String str, String str1);
}

interface Consumer<T> {
	void get(T t);
}

class Students {
	String name;
	int age;

	Students(String name, int age) {
		this.name = name;
		this.age = age;
	}

	void getInfo() {
		System.out.println("이름: " + this.name + ", 나이: " + this.age);
	}
}

class ConsumerClasses<T> implements Consumer<T> {
	@Override
	public void get(T t) {
		System.out.println(t);
	}
}

//class MyInterClass implements MyInterface1 {
//	@Override
//	public void get() {
//		System.out.println("Hello");
//	}
//}
public class BasicExample2 {
	public static void main(String[] args) {
		Consumer<String> conString = new ConsumerClasses<String>();
		conString.get("Hello");

		Consumer<Students> conStudents = (Students t) -> { // 람다 표현식
			t.getInfo();
		};
		conStudents.get(new Students("Yoon", 26));
//		MyInterface1<String> mi = (s) -> {
////			@Override  
////			public void get() {     // 익명 객체
//			System.out.println("Hello" + s);
////			}
//		};
//		mi.get("Hong");
//
//		MyInterface2 mi2 = new MyInterface2() {
//			@Override
//			public String get(String str, String str1) {
//				return str.concat(str1); // str + str1
//			}
//		};
//		String result = mi2.get("Hello", " World");
//		System.out.println(result);
	}
}
