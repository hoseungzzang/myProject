//������ : ��ȣ��
//���� ���� : �������� ����.
//���� ������ :2018.03.18
//���� ������ :2018.03.19
package pro;
import java.util.Scanner;
import java.io.*;
public class Three {

	public static void main(String[] args)throws Exception/*���ڿ��Է¹���������.*/ {
	
	Scanner scanner = new Scanner(System.in);//���ɳ� Ŭ������ ��ĳ�� �������,�Է��Ҽ��ְ�����.
	InputStreamReader insr = new InputStreamReader(System.in);//�����Է�Ŭ������ insr�����Է�,�����Է°���
	BufferedReader inbr = new BufferedReader(insr);//��Ʈ�����Է¹������ִ� Ŭ������ inbr ���� ���, ���ڿ����Է¹���������.
	int a;//�Է¹��� ���� a����
	int b;//b����


	System.out.println("�ΰ��� �ǿ����ڿ� ��������� �ϳ��� �Է��Ͻÿ�.");//������ �Է¹������ΰ�.
	System.out.println("ù��° �ǿ����ڸ� �Է��Ͻÿ�.\n");//ù��° �ǿ������Է�
	a = scanner.nextInt();//�Է¹���.
	System.out.println("�ι�° �ǿ����ڸ� �Է��Ͻÿ�.");//�ι�°�ǿ������Է�
	b = scanner.nextInt();//�Է¹���.
	System.out.println("��������� �ϳ��� �Է��Ͻÿ�.");//����������ϳ��Է¹���.
	String c = inbr.readLine();//����������Է�. ���ڿ� �Է¹���.
	
	System.out.printf("ù��°�Է¹��� ���� %d�̰� �ι�°�� %d �����ڴ� %s�Դϴ�.\n",a,b,c);//������ �Է¹޾Ҵ��� �˷���.
	if(c.equals("+")==true)//c���Է¹������� +�� ������
		System.out.printf("%d+%d=%d\n",a,b,a+b);//����� �� �� ���
	else if(c.equals("-")==true)// -�� ������ 
		System.out.printf("%d-%d=%d\n",a,b,a-b);//����İ� �� ���
	else if(c.equals("*")==true)//*�� ������ 
		System.out.printf("%d*%d=%d\n",a,b,a*b);//����İ� �� ���
	else if(c.equals("/")==true)// /�� ������ 
		System.out.printf("%d/%d=%d\n",a,b,a/b);//����İ� �� ���
	else if(c.equals("%")==true)//%��������
		System.out.printf("%d%%%d=%d\n",a,b,a%b);//����İ� �� ��� 
	else 
		System.out.println("������ ���� �����մϴ�.");//�ƹ��͵� ���� ������ ����
	
	
	}

}
