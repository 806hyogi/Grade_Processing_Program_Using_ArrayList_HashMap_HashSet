// ArrayList
package student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddStudent {

	// 필드에 이름과 국영수와 같은 필요한 값을 private 선언하고
	private String studentName; // 이름
	private int studentKor; // 국어
	private int studentEng; // 영어
	private int studentMath; // 수학
	private int sumStudent; // 합
	private int avgStudent; // 평균값
	private int[] scoreStudent; // 점수

	// 생성자에 이름과 국영수를 매개변수로 받아 객체를 초기화 합니다.
	// 초기화 과정에서 scoreStudent 3크기의 배열이 생성되고 각각의 점수들이 배열에 저장됩니다.
	public AddStudent(String name, int korea, int english, int math) {
		scoreStudent = new int[3];
		studentName = name;
		scoreStudent[0] = korea;
		scoreStudent[1] = english;
		scoreStudent[2] = math;
	}

	// getter setter
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentKor() {
		return scoreStudent[0]; // 국어를 반환
	}

	public void setStudentKor(int studentKor) {
		this.studentKor = studentKor;
	}

	public int getStudentEng() {
		return scoreStudent[1]; // 영어를 반환
	}

	public void setStudentEng(int studentEng) {
		this.studentEng = studentEng;
	}

	public int getStudentMath() {
		return scoreStudent[2]; // 수학을 반환
	}

	public void setStudentMath(int studentMath) {
		this.studentMath = studentMath;
	}

	// getSumStudent는 국영수를 모두 더한값을 반환히고
	public int getSumStudent() {
		return scoreStudent[0] + scoreStudent[1] + scoreStudent[2];
	}

	public void setSumStudent(int sumStudent) {
		this.sumStudent = sumStudent;
	}

	// getAvgStudent는 국영수를 더한값에 3을 나눈값을 반환합니다.
	public int getAvgStudent() {
		return avgStudent = (scoreStudent[0] + scoreStudent[1] + scoreStudent[2]) / 3;
	}

	// 국, 영, 수를 매개변수로 받아 해당 필드를 설정합니다. 

	public int getScoreStudent1() {
		return scoreStudent[0];
	}

	public void setScoreStudent1(int studentKor) {
		this.scoreStudent[0] = studentKor;
	}

	public int getScoreStudent2() {
		return scoreStudent[1];
	}

	public void setScoreStudent2(int studentEng) {
		this.scoreStudent[1] = studentEng;
	}

	public int getScoreStudent3() {
		return scoreStudent[2];
	}

	public void setScoreStudent3(int studentMath) {
		this.scoreStudent[2] = studentMath;
	}

}