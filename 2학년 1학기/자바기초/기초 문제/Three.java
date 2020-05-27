//개발자 : 주호승
//개발 목적 : 교수님의 과제.
//개발 시작일 :2018.03.18
//개발 종료일 :2018.03.19
package pro;
import java.util.Scanner;
import java.io.*;
public class Three {

	public static void main(String[] args)throws Exception/*문자열입력받을때선언.*/ {
	
	Scanner scanner = new Scanner(System.in);//스케너 클래스에 스캐너 변수사용,입력할수있게해줌.
	InputStreamReader insr = new InputStreamReader(System.in);//문자입력클래스에 insr변수입력,문자입력가능
	BufferedReader inbr = new BufferedReader(insr);//스트링만입력받을수있는 클래스에 inbr 변수 사용, 문자열을입력받을수있음.
	int a;//입력받을 정수 a선언
	int b;//b선언


	System.out.println("두개의 피연산자와 산술연산자 하나를 입력하시오.");//무엇을 입력받을것인가.
	System.out.println("첫번째 피연산자를 입력하시오.\n");//첫번째 피연산자입력
	a = scanner.nextInt();//입력받음.
	System.out.println("두번째 피연산자를 입력하시오.");//두번째피연산자입력
	b = scanner.nextInt();//입력받음.
	System.out.println("산술연산자 하나를 입력하시오.");//산술연산자하나입력받음.
	String c = inbr.readLine();//산술연산자입력. 문자열 입력받음.
	
	System.out.printf("첫번째입력받은 수는 %d이고 두번째는 %d 연산자는 %s입니다.\n",a,b,c);//무엇을 입력받았는지 알려줌.
	if(c.equals("+")==true)//c에입력받은값이 +가 맞으면
		System.out.printf("%d+%d=%d\n",a,b,a+b);//연산식 과 답 출력
	else if(c.equals("-")==true)// -가 맞으면 
		System.out.printf("%d-%d=%d\n",a,b,a-b);//연산식과 답 출력
	else if(c.equals("*")==true)//*가 맞으면 
		System.out.printf("%d*%d=%d\n",a,b,a*b);//연산식과 답 출력
	else if(c.equals("/")==true)// /가 맞으면 
		System.out.printf("%d/%d=%d\n",a,b,a/b);//연산식과 답 출력
	else if(c.equals("%")==true)//%가맞으면
		System.out.printf("%d%%%d=%d\n",a,b,a%b);//연산식과 답 출력 
	else 
		System.out.println("오류로 인해 종료합니다.");//아무것도 맞지 않으면 종료
	
	
	}

}
