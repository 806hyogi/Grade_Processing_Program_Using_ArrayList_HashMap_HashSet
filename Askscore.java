

package student;

//ArrayList�� ���� �ڵ�

import java.util.ArrayList;
import java.util.Scanner;

public class Askscore {

	public static void main(String[] args) {

		// �Է� ��ü ����
		Scanner sc = new Scanner(System.in);

		// �л� ������ ������ student List ����
		ArrayList<AddStudent> student = new ArrayList<AddStudent>();

		// �ʿ� ���� ����
		String studentName;
		String inputName;
		int inputNum;
		int studentKor;
		int studentEng;
		int studentMath;

		// �Է��� �л�����ŭ �ݺ����� ����Ͽ� �����͸� �Է¹޽��ϴ�.
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

			// student list�� add�� ����Ͽ� �̸�, �� �� ���� ���� ������ �߰��մϴ�.
			student.add(new AddStudent(studentName, studentKor, studentEng, studentMath));
		}

		// ���� �ݺ����� ������ �׸� �´� ������ �ݺ��ؼ� �����Ҽ� �ְ� �մϴ�.
		while (true) {

			// �׸� �Է�
			System.out.println("1.�̸��˻�   2.������ �˻�   3.80�� �̻��� ���ģ�� ���   4.��ü���   5.����   6.����");
			int inputSearchData = sc.nextInt();

			// swtich���� ����Ͽ� �Էµ� �۾� �׸� ���� ������ �۾��� ����˴ϴ�.
			switch (inputSearchData) {

			case 1:
				System.out.println("�̸��˻�: ");
				inputName = sc.next();

				boolean found = false;

				// list�� ũ�⸸ŭ �ݺ��Ͽ� equals�� ����Ͽ� ��ġ�Ұ�� �̸��� ����մϴ�.
				for (int i = 0; i < student.size(); i++) {

					AddStudent sl = student.get(i);

					if (inputName.equals(sl.getStudentName())) {
						System.out.println("ã���ִ� ��� : " + sl.getStudentName() + " �Դϴ�.");
						found = true;
						break;
					}
				}
				if (!found) {
					System.out.println("ã���ִ� ����� �����ϴ�.");
				}
				break;

			case 2:
				String findStudentName;
				// ����ڷκ��� �˻��� �̸��� �Է¹ް� find������ �ֽ��ϴ�.
				System.out.println("�˻��� �̸��� �Է�: ");
				findStudentName = sc.next();
				found = false;

				// �ݺ������� student ����Ʈ�� �л� �� �̸��� ��ġ�ϴ� �л��� ã�� �ش� ������ ����մϴ�.
				for (AddStudent studentData : student) {

					if (findStudentName.equals(studentData.getStudentName())) {
						System.out.println("�̸�, ����, ����, ����, ����, ���");
						System.out.println(studentData.getStudentName() + " " + studentData.getStudentKor() + " "
								+ studentData.getStudentEng() + " " + studentData.getStudentMath() + " "
								+ studentData.getSumStudent() + " " + studentData.getAvgStudent());
						found = true;
						break;
					}
				}
				if (!found) {
					System.out.println("�л��� ã�� �� �����ϴ�.");
				}
				break;

			case 3:
				// 80�� �̻��� �л��� ����ϴ� case �Դϴ�.
				System.out.println("80�� �̻��� ģ�� ���");
				found = false;

				// �ݸ��� ����Ͽ� student ����Ʈ�� �л��� ��,��,���� �ϳ���
				// 80�� �̻��� �л��� ������ �л��� �̸��� ����ϵ��� �߽��ϴ�.
				for (AddStudent studentData : student) {

					if ((studentData.getStudentKor() >= 80) || (studentData.getStudentEng() >= 80)
							|| (studentData.getStudentMath() >= 80)) {

						System.out.println("80�� �̻��� ģ��: " + studentData.getStudentName());
						found = true;
					}
				}

				if (!found) {
					System.out.println("80�� �̻��� ���� ģ���� �����ϴ�.");
				}
				break;

			case 4:
				// case4������ ��� �л� ������ ����ϴ� �κ��Դϴ�.
				System.out.println("��ü ���");

				// �ݺ����� ����Ͽ� stdent ����Ʈ�� ��� �л��� ������ ����մϴ�.
				for (AddStudent studentData : student) {

					System.out.println("�̸�, ����, ����, ����, ����, ���");
					System.out.println(studentData.getStudentName() + " " + studentData.getStudentKor() + " "
							+ studentData.getStudentEng() + " " + studentData.getStudentMath() + " "
							+ studentData.getSumStudent() + " " + studentData.getAvgStudent());
				}
				break;

			case 5:
				// case5 ������ �л� ������ �����ϴ� �κ��Դϴ�.
				String remakeName;
				// �����ϰ� ���� �̸��� �Է¹ް�
				System.out.println("�����ϰ� ���� �̸��� �Է��ϼ���");
				remakeName = sc.next();

				// �ݺ����� equals�� ����Ͽ� stdent ����Ʈ�� �л��� �̸��� ��ġ�ϴ� �л��� ã���ϴ�.
				for (AddStudent studentData : student) {

					if (remakeName.equals(studentData.getStudentName())) {
						
						// ������ �����Ҷ��� set�� ����Ͽ� ������ �����մϴ�.
						
						System.out.println("������ �̸��� �Է�: ");
						studentData.setStudentName(sc.next());

						System.out.println("������ ���������� �Է�: ");
						studentData.setScoreStudent1(sc.nextInt());

						System.out.println("������ ���������� �Է�: ");
						studentData.setScoreStudent2(sc.nextInt());

						System.out.println("������ ���������� �Է�: ");
						studentData.setScoreStudent3(sc.nextInt());
						break;
					}
				}
				break;

			case 6:
				// case 6�� �л� ������ �����ϴ� �κ��Դϴ�.
				// �����ϰ� ���� �̸��� �Է¹ް� list�� �ش��̸��� ������
				// remove�� ���� �����͸� ����ϴ�.
				String DeleteName;
				System.out.println("�����ϰ� ���� �̸��� �Է��ϼ���");
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