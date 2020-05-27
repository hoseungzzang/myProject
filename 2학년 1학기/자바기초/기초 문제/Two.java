//개발자 : 주호승
//개발 목적 : 교수님의 과제.
//개발 시작일 :2018.03.18
//개발 종료일 :2018.03.19


package pro;
import java.util.Scanner;
public class Two {

	public static void main(String[] args) {
		int num=0;//입력받을 정수 선언
	
		
		System.out.println("1피트는 30.48cm이다.피트를 센티미터 및 미터로 변환해보자.");//어떻게변환할것인가 출력
		Scanner scanner = new Scanner(System.in);//스케너 클래스를 스케너라는변수로 사용,입력할수있게함.
		System.out.print("피트값을 입력하시오.");//피트값입력
		num = scanner.nextInt();//피트값을 입력해 num에 넣어줌.
		
		System.out.printf("입력된 값:%d\ncm:%f\nm=%f\n",num,num*30.48,(num*30.48)*100);//피트값과 cm공식 m공식을 넣어줌.
		
		
		
		
		
	}

}
