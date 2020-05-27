package dsa;
import java.lang.InterruptedException;
import java.util.Scanner;
import java.lang.NullPointerException;
public class WaitNotifyExanple {

	public static void main(String[] args) {
		System.out.println("Enter Max Value:");
		 final Scanner scanner = new Scanner(System.in); //스캐너 생성
		 
		final int Max = scanner.nextInt(); //멕스에 값을 받음.

	WorkObject sharedObject = new WorkObject();//공유객체를 생성한다.

	sharedObject.count = Max;//카운트에 맥스값을 준다.
	ThreadA threadA=new ThreadA(sharedObject);//쓰래드 A의 객체 생성
	
	ThreadB threadB=new ThreadB(sharedObject);//쓰래드 B의 객체를 생성

	 
	 
	//쓰래드 시작
	threadA.start();
	threadB.start();
	try{threadA.join();//각 쓰래드가 종료될때까지 멈춤
		System.out.println("End ThreadA");
		threadB.join();
		System.out.println("End ThreadB");
		
	}catch(InterruptedException e) {
		
	}
		System.out.println("결과= "+sharedObject.count);//결과 확인
	}

}
