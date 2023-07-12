

package student;

//ArrayList로 만든 코드

import java.util.ArrayList;
import java.util.Scanner;

public class Askscore {

	public static void main(String[] args) {

		// 입력 객체 선언
		Scanner sc = new Scanner(System.in);

		// 학생 정보를 저장할 student List 생성
		ArrayList<AddStudent> student = new ArrayList<AddStudent>();

		// 필요 변수 선언
		String studentName;
		String inputName;
		int inputNum;
		int studentKor;
		int studentEng;
		int studentMath;

		// 입력할 학생수만큼 반복문을 사용하여 데이터를 입력받습니다.
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

			// student list에 add를 사용하여 이름, 국 영 수와 같은 정보를 추가합니다.
			student.add(new AddStudent(studentName, studentKor, studentEng, studentMath));
		}

		// 무한 반복문을 돌려서 항목에 맞는 역할을 반복해서 실행할수 있게 합니다.
		while (true) {

			// 항목 입력
			System.out.println("1.이름검색   2.성적순 검색   3.80점 이상의 모든친구 출력   4.전체출력   5.수정   6.삭제");
			int inputSearchData = sc.nextInt();

			// swtich문을 사용하여 입력된 작업 항목에 따라 각각의 작업이 실행됩니다.
			switch (inputSearchData) {

			case 1:
				System.out.println("이름검색: ");
				inputName = sc.next();

				boolean found = false;

				// list의 크기만큼 반복하여 equals를 사용하여 일치할경우 이름을 출력합니다.
				for (int i = 0; i < student.size(); i++) {

					AddStudent sl = student.get(i);

					if (inputName.equals(sl.getStudentName())) {
						System.out.println("찾고있는 사람 : " + sl.getStudentName() + " 입니다.");
						found = true;
						break;
					}
				}
				if (!found) {
					System.out.println("찾고있는 사람이 없습니다.");
				}
				break;

			case 2:
				String findStudentName;
				// 사용자로부터 검색할 이름을 입력받고 find변수에 넣습니다.
				System.out.println("검색할 이름을 입력: ");
				findStudentName = sc.next();
				found = false;

				// 반복문으로 student 리스트의 학생 중 이름과 일치하는 학생을 찾고 해당 정보를 출력합니다.
				for (AddStudent studentData : student) {

					if (findStudentName.equals(studentData.getStudentName())) {
						System.out.println("이름, 국어, 영어, 수학, 총점, 평균");
						System.out.println(studentData.getStudentName() + " " + studentData.getStudentKor() + " "
								+ studentData.getStudentEng() + " " + studentData.getStudentMath() + " "
								+ studentData.getSumStudent() + " " + studentData.getAvgStudent());
						found = true;
						break;
					}
				}
				if (!found) {
					System.out.println("학생을 찾을 수 없습니다.");
				}
				break;

			case 3:
				// 80점 이상의 학생을 출력하는 case 입니다.
				System.out.println("80점 이상의 친구 출력");
				found = false;

				// 반목문을 사용하여 student 리스트의 학생중 국,영,수중 하나라도
				// 80점 이상인 학생이 있으면 학생의 이름을 출력하도록 했습니다.
				for (AddStudent studentData : student) {

					if ((studentData.getStudentKor() >= 80) || (studentData.getStudentEng() >= 80)
							|| (studentData.getStudentMath() >= 80)) {

						System.out.println("80점 이상의 친구: " + studentData.getStudentName());
						found = true;
					}
				}

				if (!found) {
					System.out.println("80점 이상을 받은 친구가 없습니다.");
				}
				break;

			case 4:
				// case4에서는 모든 학생 정보를 출력하는 부분입니다.
				System.out.println("전체 출력");

				// 반복문을 사용하여 stdent 리스트의 모든 학생의 정보를 출력합니다.
				for (AddStudent studentData : student) {

					System.out.println("이름, 국어, 영어, 수학, 총점, 평균");
					System.out.println(studentData.getStudentName() + " " + studentData.getStudentKor() + " "
							+ studentData.getStudentEng() + " " + studentData.getStudentMath() + " "
							+ studentData.getSumStudent() + " " + studentData.getAvgStudent());
				}
				break;

			case 5:
				// case5 에서는 학생 정보를 수정하는 부분입니다.
				String remakeName;
				// 수정하고 싶은 이름을 입력받고
				System.out.println("수정하고 싶은 이름을 입력하세요");
				remakeName = sc.next();

				// 반복문과 equals를 사용하여 stdent 리스트의 학생중 이름과 일치하는 학생을 찾습니다.
				for (AddStudent studentData : student) {

					if (remakeName.equals(studentData.getStudentName())) {
						
						// 정보를 수정할때는 set을 사용하여 정보를 수정합니다.
						
						System.out.println("변경할 이름을 입력: ");
						studentData.setStudentName(sc.next());

						System.out.println("변경할 국어점수을 입력: ");
						studentData.setScoreStudent1(sc.nextInt());

						System.out.println("변경할 영어점수을 입력: ");
						studentData.setScoreStudent2(sc.nextInt());

						System.out.println("변경할 수학점수을 입력: ");
						studentData.setScoreStudent3(sc.nextInt());
						break;
					}
				}
				break;

			case 6:
				// case 6은 학생 정보를 삭제하는 부분입니다.
				// 삭제하고 싶은 이름을 입력받고 list에 해당이름이 있으면
				// remove를 통해 데이터를 지웁니다.
				String DeleteName;
				System.out.println("삭제하고 싶은 이름을 입력하세요");
				DeleteName = sc.next();

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