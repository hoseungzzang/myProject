//개발자 : 주호승
//개발 목적 : 교수님의 과제.
//개발 시작일 :2018.03.18
//개발 종료일 :2018.03.19
package pro;

public class four {

	public static void main(String[] args) {
	
		int i=0;//1부터 500까지 증가하는 정수 선언
		int j=0;//10번 출력할 정수 선언
		for(i=1;i<=500;i++)//1부터 500까지 증가 
		{
			for(j=1;j<=10;j++)//숫자를 한줄에 10개 출력함.
			{
				if(i%6==0)//증가하는 정수에 6을나눠서 나머지가 0이라면 출력.
				{
					System.out.printf("%d ",i);//출력
				}
			}
			if(i%6==0)//그냥 다음줄로이동시키면 줄이 너무 많이 떨어져서 6으로나눈후나머지가0일때만 줄이동.
			{
				System.out.println("\n");//줄이동
			}
				
		
		}

	}

}
