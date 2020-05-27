//개발자 : 주호승
//개발 목적 : 교수님의 과제.
//개발 시작일 :2018.03.18
//개발 종료일 :2018.03.19


package pro;

public class Five {

	public static void main(String[] args) {
		int i;//1부터 9까지 곱해줄 정수 선언
		int j;//3부터7까지 곱해질 정수선언
		System.out.println("***Mutiplication Tabel***");//과제와 똑같이만들기위해 출력
		for(i=1;i<10;i++)//1부터9까지 곱해지는 값을 증가시킴.
		{
			for(j=3;j<8;j++)//3부터7까지 단을 증가시킴.
			{
				System.out.printf("%dx%d = %d \t",j,i,j*i);//구구단 수식 출력 
				
			}
			System.out.println("\n");//옆으로 출력하는 일이 끝난 후에 줄바꿈을 해야 과제와 같이 출력이됨.
		
		}
	}

}
