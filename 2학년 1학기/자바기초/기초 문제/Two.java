//������ : ��ȣ��
//���� ���� : �������� ����.
//���� ������ :2018.03.18
//���� ������ :2018.03.19


package pro;
import java.util.Scanner;
public class Two {

	public static void main(String[] args) {
		int num=0;//�Է¹��� ���� ����
	
		
		System.out.println("1��Ʈ�� 30.48cm�̴�.��Ʈ�� ��Ƽ���� �� ���ͷ� ��ȯ�غ���.");//��Ժ�ȯ�Ұ��ΰ� ���
		Scanner scanner = new Scanner(System.in);//���ɳ� Ŭ������ ���ɳʶ�º����� ���,�Է��Ҽ��ְ���.
		System.out.print("��Ʈ���� �Է��Ͻÿ�.");//��Ʈ���Է�
		num = scanner.nextInt();//��Ʈ���� �Է��� num�� �־���.
		
		System.out.printf("�Էµ� ��:%d\ncm:%f\nm=%f\n",num,num*30.48,(num*30.48)*100);//��Ʈ���� cm���� m������ �־���.
		
		
		
		
		
	}

}
