package com.yedam.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Student {
	String name;
	int score;

	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}
}

public class LambdaExpressionExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("Hong", 90), new Student("Hwang", 92));
		Stream<Student> stream = list.stream();
		stream.forEach(s -> { // forEach = 반환값이 없다.
			String name = s.getName();
			int score = s.getScore();
			System.out.println(name + "," + score);
		});
	}
}
