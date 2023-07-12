package student;

// hashMap�� ����ϴ� �ڵ�
// �̸��� key�� ����Ͽ� �ߺ��� �̸��� ���� �л��� ó���� �� �ֽ��ϴ�.

import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;

public class HashMapAskscore {

   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);

      // Hashmap �����ϰ� �л��̸��� key, addStudent��ü�� ������ �����մϴ�.
      HashMap<String, AddStudent> student = new HashMap<>();

      String studentName;
      String inputName;
      int studentKor;
      int studentEng;
      int studentMath;
      int inputNum;
      
      // ����ڷκ��� �л��� ������ �Է¹޽��ϴ�.
      System.out.println("����� �Է��Ұǰ���? :");
      inputNum = sc.nextInt();

      for (int i = 0; i < inputNum; i++) {
         
         System.out.println("�л� �̸��� �Է��ϼ���: "); 
         studentName = sc.next();
   
         System.out.println("���� ������ �Է��ϼ���: ");
         studentKor = sc.nextInt();
   
         System.out.println("���� ������ �Է��ϼ���: ");
         studentEng = sc.nextInt();
   
         System.out.println("���� ������ �Է��ϼ���: ");
         studentMath = sc.nextInt();
   
         // �л� ������ put �޼��带 ����Ͽ� �߰��մϴ�.
         student.put(studentName, new AddStudent(studentName, studentKor, studentEng, studentMath)); // ���ο� ��ü ����

      }
      while (true) {

         // switch������ �۾��� ���� �پ��� �۾��� �����մϴ�.
         System.out.println("1.�̸��˻�   2.������ �˻�   3.80�� �̻��� ���ģ�� ���   4.��ü���   5.����   6.����");
         int inputSearchData = sc.nextInt();

         switch (inputSearchData) {

         case 1:
        	// �̸��� �˻��ϴ� case��
            System.out.println("�̸��˻�: ");
            inputName = sc.next();

            // containsKey�� ����Ͽ� �Է°��� ���ؼ� �˻�
            if (student.containsKey(inputName)) {
               System.out.println("ã���ִ� ��� : " + student.get(inputName).getStudentName() + " �Դϴ�.");

               break;
            } else {
               System.out.println("ã�� �ִ� ����� �����ϴ�.");
            }

            break;

         case 2:
        	// �̸��� ���� ������ ����ϴ� �ڵ�
            String findStudentName;
            System.out.println("�˻��� �̸��� �Է�: ");
            findStudentName = sc.next();

            if (student.containsKey(findStudentName)) {
               AddStudent studentData = student.get(findStudentName);
               System.out.println("�̸�, ����, ����, ����, ����, ���");
               System.out.println(studentData.getStudentName() + " " + studentData.getStudentKor() + " "
                     + studentData.getStudentEng() + " " + studentData.getStudentMath() + " "
                     + studentData.getSumStudent() + " " + studentData.getAvgStudent());

               break;

            } else {
               System.out.println("�л��� ã�� �� �����ϴ�.");
            }

            break;

         case 3:
        	// 80�� �̻��� ģ���� ����ϴ� �ڵ�
        	 
            System.out.println("80�� �̻��� ģ�� ���");

            for (AddStudent studentData : student.values()) {
               // ����, ����, ������ 80�� �̻����� ���ϴ� if��
               if ((studentData.getStudentKor() >= 80) || (studentData.getStudentEng() >= 80)
                     || (studentData.getStudentMath() >= 80)) {

                  System.out.println("80�� �̻��� ģ��: " + studentData.getStudentName());
               } else {
                  System.out.println("80�� �̻��� ���� ģ���� �����ϴ�.");
               }
               break;
            }
            break;

         case 4:
        	// �Էµ� ���� ��ü ����ϴ� �ڵ�
            System.out.println("��ü ���");
            
            // HashMap�� ����� ��� ������ �÷��� ���·� ��ȸ�ϸ鼭 ���� studentData�� �����մϴ�.
            for (AddStudent studentData : student.values()) {

               System.out.println("�̸�, ����, ����, ����, ����, ���");
               System.out.println(studentData.getStudentName() + " " + studentData.getStudentKor() + " "
                     + studentData.getStudentEng() + " " + studentData.getStudentMath() + " "
                     + studentData.getSumStudent() + " " + studentData.getAvgStudent());

            }
            break;

         case 5:
        	// ������ �����ϴ� �ڵ�
            String remakeName;
            System.out.println("�����ϰ� ���� �̸��� �Է��ϼ���");
            remakeName = sc.next();
            
            // Key���� �̸��� �����ϴ��� ���θ� Ȯ���մϴ�.
            if (student.containsKey(remakeName)) {

               AddStudent studentData = student.get(remakeName);

               System.out.println("������ �̸��� �Է�: ");
               studentData.setStudentName(sc.next());

               System.out.println("������ ���������� �Է�: ");
               studentData.setScoreStudent1(sc.nextInt());

               System.out.println("������ ���������� �Է�: ");
               studentData.setScoreStudent2(sc.nextInt());

               System.out.println("������ ���������� �Է�: ");
               studentData.setScoreStudent3(sc.nextInt());

            } else {
               System.out.println("�л��� ã�� �� �����ϴ�.");
            }
            break;

         case 6:
        	
        	// ������ �����ϴ� �ڵ�
            String DeleteName;
            System.out.println("�����ϰ� ���� �̸��� �Է��ϼ���");
            DeleteName = sc.next();
            
            // student�� �Է��� �̸��� �����ϴ� Ű�� ������ remove�� ���� �����մϴ�.
            if (student.containsKey(DeleteName)) {
                 student.remove(DeleteName);
                 System.out.println(DeleteName + " �л��� �����߽��ϴ�.");
            } else {
                System.out.println("�Է��� �̸��� ���� �л��� ã�� �� �����ϴ�.");
            }
            
            
            break;

         }
      }
   }
}