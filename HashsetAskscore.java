package student;

// Hashset ���� ���� �ڵ� �Դϴ�.
// arrayList�ʹ� �ٸ��� �ߺ��� �л��� ������ ������� �ʴ� ������ ������ �Ǿ��ֽ��ϴ�.

import java.util.Scanner;
import java.util.HashSet;

public class HashsetAskscore {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Hashset�� �����Ͽ� �л� ������ ������ student ������ ����ϴ�.
		HashSet<AddStudent> student = new HashSet<>();

		// �̿��´� �ʿ��� ������ �����մϴ�.
		String studentName;
		String inputName;
		int inputNum;
		int studentKor;
		int studentEng;
		int studentMath;
		
		// �Է¹��� �л��� ����ŭ �л� ������ �Է¹ް�
		System.out.println("����� �Է��Ұǰ���? :");
		inputNum = sc.nextInt();
		for (int i = 0; i < inputNum; i++) {
			// �Է�
			System.out.println("�л� �̸��� �Է��ϼ���: ");
			studentName = sc.next();

			System.out.println("���� ������ �Է��ϼ���: ");
			studentKor = sc.nextInt();

			System.out.println("���� ������ �Է��ϼ���: ");
			studentEng = sc.nextInt();

			System.out.println("���� ������ �Է��ϼ���: ");
			studentMath = sc.nextInt();
			
			// AddStudent ��ü�� �����Ͽ� student ���տ� add�� �߰��մϴ�.
			
			student.add(new AddStudent(studentName, studentKor, studentEng, studentMath)); // ���ο� ��ü ����
		}
		
		while (true) {

			// ����ڷκ��� �۾� �׸��� �Է¹޽��ϴ�.
			System.out.println("1.�̸��˻�   2.������ �˻�   3.80�� �̻��� ���ģ�� ���   4.��ü���   5.����   6.����");
			int inputSearchData = sc.nextInt();

			switch (inputSearchData) {

			case 1:
				// case1�� �̸� �˻��� �����ϴ� �κ��Դϴ�.
				
				System.out.println("�̸��˻�: ");
				inputName = sc.next();
				
				// student ���տ��� ��ġ�ϴ� ������ ã�� equals�� �̸��� ����մϴ�.
				for (AddStudent studentData : student) {

					if (studentData.getStudentName().equals(inputName)) {
						System.out.println("ã���ִ� ��� : " + studentData.getStudentName() + " �Դϴ�.");
					}
				}
				break;
			case 2:
				// case2�� ���������� �л��� �˻��ϴ� �κ��Դϴ�.
				
				String findStudentName;
				System.out.println("�˻��� �̸��� �Է�: ");
				findStudentName = sc.next();

				// student ���տ��� �̸��� ��ġ�ϴ� ������ ã�� �ش� ������ ����մϴ�.
				for (AddStudent studentData : student) {

					if (findStudentName.equals(studentData.getStudentName())) {
						System.out.println("�̸�, ����, ����, ����, ����, ���");
						System.out.println(studentData.getStudentName() + " " + studentData.getStudentKor() + " "
								+ studentData.getStudentEng() + " " + studentData.getStudentMath() + " "
								+ studentData.getSumStudent() + " " + studentData.getAvgStudent());
						break;
					} else if (!(findStudentName.equals(studentData.getStudentName()))) {
						System.out.println("�л��� ã�� �� �����ϴ�.");
						break;
					}
				}

				break;

			case 3:
				// case3�� 80�� �̻��� �л��� ����ϴ� �κ��Դϴ�.
				
				System.out.println("80�� �̻��� ģ�� ���");

				for (AddStudent studentData : student) {
					// student ���տ��� 80�� �̻��� �л��� �̸��� ����մϴ�.
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
				// case4�� ��� �л��� ������ ����ϴ� �κ��Դϴ�.
				
				System.out.println("��ü ���");

				// student ������ ��� �л��� ������ ����մϴ�.
				for (AddStudent studentData : student) {

					System.out.println("�̸�, ����, ����, ����, ����, ���");
					System.out.println(studentData.getStudentName() + " " + studentData.getStudentKor() + " "
							+ studentData.getStudentEng() + " " + studentData.getStudentMath() + " "
							+ studentData.getSumStudent() + " " + studentData.getAvgStudent());

					break;
				}
				break;

			case 5:
				// case5�� �л� ������ �����ϴ� �κ��Դϴ�.
				
				String remakeName;
				System.out.println("�����ϰ� ���� �̸��� �Է��ϼ���");
				remakeName = sc.next();

				for (AddStudent studentData : student) {

					if (remakeName.equals(studentData.getStudentName())) {

						System.out.println("������ �̸��� �Է�: ");
						studentData.setStudentName(sc.next());

						System.out.println("������ ���������� �Է�: ");
						studentData.setScoreStudent1(sc.nextInt());

						System.out.println("������ ���������� �Է�: ");
						studentData.setScoreStudent2(sc.nextInt());

						System.out.println("������ ���������� �Է�: ");
						studentData.setScoreStudent3(sc.nextInt());

					}
					break;
				}
				break;
			case 6:
				// case6�� �л��� ������ �����ϴ� �κ��Դϴ�.
				
				
				String DeleteName;
				System.out.println("�����ϰ� ���� �̸��� �Է��ϼ���");
				DeleteName = sc.next();
				
				// student ���տ��� �̸��� ��ġ�ϴ� �л��� ã�� remove�� ����Ͽ� �ش� �����͸� �����߽��ϴ�.
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