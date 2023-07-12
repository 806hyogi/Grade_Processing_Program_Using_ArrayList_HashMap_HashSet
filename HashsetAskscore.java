package student;

// Hashset 으로 만든 코드 입니다.
// arrayList와는 다르게 중복된 학생의 정보를 허용하지 않는 데이터 구조로 되어있습니다.

import java.util.Scanner;
import java.util.HashSet;

public class HashsetAskscore {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Hashset을 생성하여 학생 정보를 저장할 student 집합을 만듭니다.
		HashSet<AddStudent> student = new HashSet<>();

		// 이에맞는 필요한 변수를 선언합니다.
		String studentName;
		String inputName;
		int inputNum;
		int studentKor;
		int studentEng;
		int studentMath;
		
		// 입력받은 학생의 수만큼 학생 정보를 입력받고
		System.out.println("몇명을 입력할건가요? :");
		inputNum = sc.nextInt();
		for (int i = 0; i < inputNum; i++) {
			// 입력
			System.out.println("학생 이름을 입력하세요: ");
			studentName = sc.next();

			System.out.println("국어 점수를 입력하세요: ");
			studentKor = sc.nextInt();

			System.out.println("영어 점수를 입력하세요: ");
			studentEng = sc.nextInt();

			System.out.println("수학 점수를 입력하세요: ");
			studentMath = sc.nextInt();
			
			// AddStudent 객체를 생성하여 student 집합에 add로 추가합니다.
			
			student.add(new AddStudent(studentName, studentKor, studentEng, studentMath)); // 새로운 객체 생성
		}
		
		while (true) {

			// 사용자로부터 작업 항목을 입력받습니다.
			System.out.println("1.이름검색   2.성적순 검색   3.80점 이상의 모든친구 출력   4.전체출력   5.수정   6.삭제");
			int inputSearchData = sc.nextInt();

			switch (inputSearchData) {

			case 1:
				// case1는 이름 검색을 수행하는 부분입니다.
				
				System.out.println("이름검색: ");
				inputName = sc.next();
				
				// student 집합에서 일치하는 정보를 찾고 equals로 이름을 출력합니다.
				for (AddStudent studentData : student) {

					if (studentData.getStudentName().equals(inputName)) {
						System.out.println("찾고있는 사람 : " + studentData.getStudentName() + " 입니다.");
					}
				}
				break;
			case 2:
				// case2는 성적순으로 학생을 검색하는 부분입니다.
				
				String findStudentName;
				System.out.println("검색할 이름을 입력: ");
				findStudentName = sc.next();

				// student 집합에서 이름이 일치하는 정보를 찾고 해당 정보를 출력합니다.
				for (AddStudent studentData : student) {

					if (findStudentName.equals(studentData.getStudentName())) {
						System.out.println("이름, 국어, 영어, 수학, 총점, 평균");
						System.out.println(studentData.getStudentName() + " " + studentData.getStudentKor() + " "
								+ studentData.getStudentEng() + " " + studentData.getStudentMath() + " "
								+ studentData.getSumStudent() + " " + studentData.getAvgStudent());
						break;
					} else if (!(findStudentName.equals(studentData.getStudentName()))) {
						System.out.println("학생을 찾을 수 없습니다.");
						break;
					}
				}

				break;

			case 3:
				// case3는 80점 이상의 학생을 출력하는 부분입니다.
				
				System.out.println("80점 이상의 친구 출력");

				for (AddStudent studentData : student) {
					// student 집합에서 80점 이상인 학생의 이름을 출력합니다.
					if ((studentData.getStudentKor() >= 80) || (studentData.getStudentEng() >= 80)
							|| (studentData.getStudentMath() >= 80)) {

						System.out.println("80점 이상의 친구: " + studentData.getStudentName());
					} else {
						System.out.println("80점 이상을 받은 친구가 없습니다.");
					}
					break;
				}
				break;

			case 4:
				// case4는 모든 학생의 정보를 출력하는 부분입니다.
				
				System.out.println("전체 출력");

				// student 집합의 모든 학생의 정보를 출력합니다.
				for (AddStudent studentData : student) {

					System.out.println("이름, 국어, 영어, 수학, 총점, 평균");
					System.out.println(studentData.getStudentName() + " " + studentData.getStudentKor() + " "
							+ studentData.getStudentEng() + " " + studentData.getStudentMath() + " "
							+ studentData.getSumStudent() + " " + studentData.getAvgStudent());

					break;
				}
				break;

			case 5:
				// case5는 학생 정보를 수정하는 부분입니다.
				
				String remakeName;
				System.out.println("수정하고 싶은 이름을 입력하세요");
				remakeName = sc.next();

				for (AddStudent studentData : student) {

					if (remakeName.equals(studentData.getStudentName())) {

						System.out.println("변경할 이름을 입력: ");
						studentData.setStudentName(sc.next());

						System.out.println("변경할 국어점수을 입력: ");
						studentData.setScoreStudent1(sc.nextInt());

						System.out.println("변경할 영어점수을 입력: ");
						studentData.setScoreStudent2(sc.nextInt());

						System.out.println("변경할 수학점수을 입력: ");
						studentData.setScoreStudent3(sc.nextInt());

					}
					break;
				}
				break;
			case 6:
				// case6는 학생의 정보를 삭제하는 부분입니다.
				
				
				String DeleteName;
				System.out.println("삭제하고 싶은 이름을 입력하세요");
				DeleteName = sc.next();
				
				// student 집합에서 이름이 일치하는 학생을 찾고 remove를 사용하여 해당 데이터를 삭제했습니다.
				for (AddStudent studentData : student) {

					if (studentData.getStudentName().equals(DeleteName)) {

						student.remove(studentData);

						break;

					}

				}
				break;
			}

		}

	}

}