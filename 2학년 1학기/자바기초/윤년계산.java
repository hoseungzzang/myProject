//개발자 : 주호승
//개발 목적 : 내가 살아온 일수를 알아보자. 
//개발 시작일 : 2018.03.22
//개발 종료일: 2018.03.25
package pro;
import java.util.Calendar;//날짜함수
import java.util.Scanner;//스케너 함수
public class Daycounter {
	 int cYear, cMonth, cDay;//올해 년,월,일
	 int bYear, bMonth, bDay;//태어난 년,월,일
	 int cnt_normalYear;//평년
	 int cnt_leapYear;//윤년
	 int sum;//내가 살아온 일수 
	public static void main(String[] args) {
		  Daycounter dct = new Daycounter();//daycounter을 dct라는 생성자로 생성
		  dct.getBirthDate();//태어난 년,월,일을 입력시킴.
		  dct.countLeapYear();//윤년평년계산한거불러옴
		  dct.showCountedResult();//살아온일자 계산한거 불러옴
		  

	}


public Daycounter() {     //생성자
	   initiation();//선언한 변수들을 초기화시킴
	   
	   
	 }
//객체의 에트리뷰트들의 초기화 
public void initiation() {
Calendar cal = Calendar.getInstance();//날짜 함수를 cal이라고 정의하고 사용하겠다.
cYear=cal.get(Calendar.YEAR);//현재 년도를 넣어줌.
cMonth=cal.get(Calendar.MONTH)+1;//현재 달을 넣어줌.
cDay=cal.get(Calendar.DATE);//현재 일을 넣어줌.
cnt_normalYear=0;//평년초기화
cnt_leapYear=0;//윤년초기화
sum=0;//초기화

System.out.println("Today : " + cYear + "-"+ cMonth + "-"+ cDay);//현재 몇년 몇월 몇일인지 출력



}

// 계산된 살아온 일수를 출력
public void showCountedResult() {
sum = dayCountForBirthYear()+dayCountForThisYear()+(cnt_leapYear*366)+(cnt_normalYear*365);
//계산된 출생년에 살아온 일수와 홀해에 살았온 일수를 더하고 그사이 년도에 윤년엔366을 곱하고 평년엔 365를곱함 그후 다 더함.
System.out.printf("살아온 일수는 %d일이다.\n",sum);//그렇게 계산된 결과 출력
}

// 사용자로부터 생년월일을 입력받음 
public void getBirthDate() {
 Scanner scan=new Scanner(System.in);//스캐너함수를 scan이란 이름으로사용
 System.out.println("태어난 해 : ");
 bYear = scan.nextInt();//태어난 해 입력
 System.out.println("태어난 월 : ");
 bMonth = scan.nextInt();//태어난 월 입력
 System.out.println("태어난 일 : ");
 bDay = scan.nextInt();//태어난 일 입력
 
 
}




//윤년 및 평년 수 계산 (단 출생년과 현재 년도는 계산에서 제외)
public void countLeapYear() {

 for(int i = bYear+1; i<cYear;i++)//i는 태어난 년에서 1더하고 현재년도 1빼준거까지 증가
 {                                //이유는 태어난년을 전부 다산게 아니고 현재년도를 다산것이 아니기떄문
  if(i%4==0 && i%100!=0 || i%400==0)//윤년일경우엔
  {
   cnt_leapYear++;//윤년카운트증가
  }
  else//윤년이 아닌 평년일경우
  {
   cnt_normalYear++;//평년카운트 증가
  }
  }
 System.out.printf("윤년은 %d년이고 평년은 %d년이다.\n",cnt_leapYear,cnt_normalYear);//출력

 }

       // 출생년의 일수 계산 (결과는 정수형으로 반환됨)
public int dayCountForBirthYear() {

	int bnum=0;//일수를 받아내기위한 변수
	int bnum2=0;//태어난 월의 일수를 받아내기위한변수
	int i=bYear;//i는 태어난 년도
	
	int j=bMonth+1;//j는 태어난 월에+1
	int result=0;//총 일수 
	for(;j<13;j++)//태어난월+1부터 12월까지 증가
	{
		if(i%4==0 && i%100!=0 || i%400==0)//윤년이면
		{
			if(j==2)//2월일 경우
			{
				bnum+=29;//29일 더한다.
			}
			else if(j==1||j==3||j==5||j==7||j==8||j==10||j==12)//1또는3또는5또는7또는8또는10또는12월일경우
			{
				bnum+=31;//31일 더한다.
			}
			else//그외 4,6,8,11월일경우
			{
				bnum+=30;//30일 더한다.
			}
		}
		else
		{
			
			if(j==2)//평년2월일경우
			{
				bnum+=28;//28을 더한다.
			}
			else if(j==1||j==3||j==5||j==7||j==8||j==10||j==12)//평년 1또는3또는5또는7또는8또는10또는12월일경우
			{
				bnum+=31;//31을더한다.
			}
			else//그외일 경우
			{
				bnum+=30;//30일을 더한다.
			}
		}
	    
		
	}
	if(i%4==0 && i%100!=0 || i%400==0)//윤년일경우
	{
		if(j==2)//2월일 경우 
		{
			bnum2+=(29-bDay);//29-태어난일을 빼준다.
		}
		else if(j==1||j==3||j==5||j==7||j==8||j==10||j==12)//1또는3또는5또는7또는8또는10또는12월일경우
		{
			bnum2+=(31-bDay);//31-태어난일을 빼준다.
		}
		else//그 외일 경우
		{
			bnum2+=(30-bDay);//30 - 태어난일을 빼준다.
		}
	}
	else//평년일경우
	{
		
		if(j==2)//2월일경우
		{
			bnum2+=(28-bDay);//28에서 태어난일을빼준다.
		}
		else if(j==1||j==3||j==5||j==7||j==8||j==10||j==12)//1또는3또는5또는7또는8또는10또는12월일경우
		{
			bnum2+=(31-bDay);//31에서 태어난일을빼준다.
		}
		else//그 외일 경우
		{
			bnum2+=(30-bDay);//30일에서 태어난 일을 빼준다.
		}
	}
	result = bnum+bnum2;//윤년 평년 계산해서 나온 일수를 다 더해 result에 넣는다.
	System.out.printf("출생년은 %d 일이다\n",result);//결과값 출력
	
	return result;//결과값을 반환한다.
	

}
       // 올해의 일수 계산  (결과는 정수형으로 반환됨)
public int dayCountForThisYear() {

	int i=cYear;//i는 현재 년
	int bnum=0;//일수를 받아주는 변수
	int c=cMonth;//c는 현재 월
	int result=0;//결과값 초기화
	for(int j=1; j<=c-1;j++)//j는 현재 월-1까지 증가 
	{                       //현재 월은 다산게 아니라서 빼줌.
		if(i%4==0 && i%100!=0 || i%400==0)//윤년일 경우
		{
			if(j==2)//2월일 경우
			{
				bnum+=29; // 29일을 더한다.
			}
			else if(j==1||j==3||j==5||j==7||j==8||j==10||j==12)//1또는3또는5또는7또는8또는10또는12월일경우
			{
				bnum+=31;//31일을 더한다.
			}
			else//그 외일경우
			{
				bnum+=30;//30일을 더한다.
			}
		}
		else//평년일경우
		{
			
			if(j==2)//2월일경우
			{
				bnum+=28;//28일을 더한다.
			}
			else if(j==1||j==3||j==5||j==7||j==8||j==10||j==12)//1또는3또는5또는7또는8또는10또는12월일경우
			{
				bnum+=31;//31일을더한다.
			}
			else//그 외일 경우 
			{
				bnum+=30;//30일을 더한다.
			}
		}
		
	}
	result = bnum+cDay;//평년 윤년 계산된 일 수에다가 이번년도 일을 더하면 이번년도에 산 일수가 나옴. result에 넣음.
	System.out.printf("올해 일수 계산은 %d 일이다.\n",result);//결과값 출력
	
	return result;//결과값 리턴
	
}
}


	



