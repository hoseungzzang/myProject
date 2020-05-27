package dsa;
import java.lang.InterruptedException;
import java.util.Scanner;
import java.lang.NullPointerException;
public class WaitNotifyExanple {

	public static void main(String[] args) {
		System.out.println("Enter Max Value:");
		 final Scanner scanner = new Scanner(System.in); //��ĳ�� ����
		 
		final int Max = scanner.nextInt(); //�߽��� ���� ����.

	WorkObject sharedObject = new WorkObject();//������ü�� �����Ѵ�.

	sharedObject.count = Max;//ī��Ʈ�� �ƽ����� �ش�.
	ThreadA threadA=new ThreadA(sharedObject);//������ A�� ��ü ����
	
	ThreadB threadB=new ThreadB(sharedObject);//������ B�� ��ü�� ����

	 
	 
	//������ ����
	threadA.start();
	threadB.start();
	try{threadA.join();//�� �����尡 ����ɶ����� ����
		System.out.println("End ThreadA");
		threadB.join();
		System.out.println("End ThreadB");
		
	}catch(InterruptedException e) {
		
	}
		System.out.println("���= "+sharedObject.count);//��� Ȯ��
	}

}
