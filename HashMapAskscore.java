package student;

// hashMap을 사용하는 코드
// 이름을 key로 사용하여 중복된 이름을 가진 학생을 처리할 수 있습니다.

import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;

public class HashMapAskscore {

   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);

      // Hashmap 생성하고 학생이름을 key, addStudent객체를 값으로 선언합니다.
      HashMap<String, AddStudent> student = new HashMap<>();

      String studentName;
      String inputName;
      int studentKor;
      int studentEng;
      int studentMath;
      int inputNum;
      
      // 사용자로부터 학생의 정보를 입력받습니다.
      System.out.println("몇명을 입력할건가요? :");
      inputNum = sc.nextInt();

      for (int i = 0; i < inputNum; i++) {
         
         System.out.println("학생 이름을 입력하세요: "); 
         studentName = sc.next();
   
         System.out.println("국어 점수를 입력하세요: ");
         studentKor = sc.nextInt();
   
         System.out.println("영어 점수를 입력하세요: ");
         studentEng = sc.nextInt();
   
         System.out.println("수학 점수를 입력하세요: ");
         studentMath = sc.nextInt();
   
         // 학생 정보를 put 메서드를 사용하여 추가합니다.
         student.put(studentName, new AddStudent(studentName, studentKor, studentEng, studentMath)); // 새로운 객체 생성

      }
      while (true) {

         // switch문으로 작업에 따라 다양한 작업을 진행합니다.
         System.out.println("1.이름검색   2.성적순 검색   3.80점 이상의 모든친구 출력   4.전체출력   5.수정   6.삭제");
         int inputSearchData = sc.nextInt();

         switch (inputSearchData) {

         case 1:
        	// 이름을 검색하는 case문
            System.out.println("이름검색: ");
            inputName = sc.next();

            // containsKey를 사용하여 입력값과 비교해서 검색
            if (student.containsKey(inputName)) {
               System.out.println("찾고있는 사람 : " + student.get(inputName).getStudentName() + " 입니다.");

               break;
            } else {
               System.out.println("찾고 있는 사람이 없습니다.");
            }

            break;

         case 2:
        	// 이름에 따른 정보를 출력하는 코드
            String findStudentName;
            System.out.println("검색할 이름을 입력: ");
            findStudentName = sc.next();

            if (student.containsKey(findStudentName)) {
               AddStudent studentData = student.get(findStudentName);
               System.out.println("이름, 국어, 영어, 수학, 총점, 평균");
               System.out.println(studentData.getStudentName() + " " + studentData.getStudentKor() + " "
                     + studentData.getStudentEng() + " " + studentData.getStudentMath() + " "
                     + studentData.getSumStudent() + " " + studentData.getAvgStudent());

               break;

            } else {
               System.out.println("학생을 찾을 수 없습니다.");
            }

            break;

         case 3:
        	// 80점 이상의 친구를 출력하는 코드
        	 
            System.out.println("80점 이상의 친구 출력");

            for (AddStudent studentData : student.values()) {
               // 국어, 영어, 수학이 80점 이상인지 비교하는 if문
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
        	// 입력된 값을 전체 출력하는 코드
            System.out.println("전체 출력");
            
            // HashMap에 저장된 모든 값들을 컬렉션 형태로 순회하면서 값을 studentData에 저장합니다.
            for (AddStudent studentData : student.values()) {

               System.out.println("이름, 국어, 영어, 수학, 총점, 평균");
               System.out.println(studentData.getStudentName() + " " + studentData.getStudentKor() + " "
                     + studentData.getStudentEng() + " " + studentData.getStudentMath() + " "
                     + studentData.getSumStudent() + " " + studentData.getAvgStudent());

            }
            break;

         case 5:
        	// 정보를 수정하는 코드
            String remakeName;
            System.out.println("수정하고 싶은 이름을 입력하세요");
            remakeName = sc.next();
            
            // Key값인 이름을 포함하는지 여부를 확인합니다.
            if (student.containsKey(remakeName)) {

               AddStudent studentData = student.get(remakeName);

               System.out.println("변경할 이름을 입력: ");
               studentData.setStudentName(sc.next());

               System.out.println("변경할 국어점수을 입력: ");
               studentData.setScoreStudent1(sc.nextInt());

               System.out.println("변경할 영어점수을 입력: ");
               studentData.setScoreStudent2(sc.nextInt());

               System.out.println("변경할 수학점수을 입력: ");
               studentData.setScoreStudent3(sc.nextInt());

            } else {
               System.out.println("학생을 찾을 수 없습니다.");
            }
            break;

         case 6:
        	
        	// 정보를 삭제하는 코드
            String DeleteName;
            System.out.println("삭제하고 싶은 이름을 입력하세요");
            DeleteName = sc.next();
            
            // student에 입력한 이름을 포함하는 키가 있으면 remove를 통해 삭제합니다.
            if (student.containsKey(DeleteName)) {
                 student.remove(DeleteName);
                 System.out.println(DeleteName + " 학생을 삭제했습니다.");
            } else {
                System.out.println("입력한 이름을 가진 학생을 찾을 수 없습니다.");
            }
            
            
            break;

         }
      }
   }
}