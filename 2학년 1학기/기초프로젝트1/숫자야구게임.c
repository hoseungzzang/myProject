//개발 목적 : 요구사항을 분석한 숫자야구 프로그램 만들기

//개발자 :컴퓨터 공학과 주호승 2015244071

//과제 시작일 : 2018.05.01

//과제 마감일 : 2018.05.03

#pragma warning(disable:4996)
#include<stdio.h>
#include<time.h>//랜덤함수사용을위한타임헤더선언
#include<stdlib.h>
#include<string.h>//문자열함수사용을위한헤더
char random(char randomsu[5]);//랜덤수 생성
char nope(char *innumber);//사용자가 수를 입력함.
int cpn(char *randomsu, char*innumber);//랜덤수와 사용자가 입력한 수를 비교
int main()
{

	char randomsu[10] = { 0 };//랜덤수 초기화
	char innum[20] = { 0 };//사용자가 넣을 수 초기화
	int cnt = 0;//카운트 초기화
	random(randomsu);//랜덤수를 받아오기 위해 랜덤함수 호출
	printf("\n랜덤수가 생성되었습니다.\n");//랜덤수 생성된것 알림
	while (cnt != 5)//cnt가 5가 아닐때 계속 돈다.
	{
		nope(&innum);//사용자가 입력한 수가 중복되는 수가 없는지,5자리수를 입력했는지 확인 후 입력된수 받아옴.
		cnt = cpn(randomsu, innum);//랜덤수와 사용자 입력 수를 비교 후 결과값을 cnt로 받아줌.스트라이크가
								   /*5이면 cnt가 5가 되서 와일문 종료*/
	}
	getch();
}
char random(char randomsu[5])//랜덤수 생성
{
	int i = 0;//i초기화
	int cnt = 0;//cnt초기화
	srand((unsigned)time(NULL));//난수생성

	while (cnt != 5)//cnt가 5가 아닐때 계속 돈다.
	{

		randomsu[i] = rand() % ((57 - 49) + 1) + 49;//아스키코드 1~9를 배열에 저장.

		if (i == 0)//배열에 아무것도없으면 바로 추가.
		{

			i++;//i증가
			cnt++;//카운트 증가
		}
		else if (randomsu[i] != randomsu[i - 1] && randomsu[i] != randomsu[i - 2] && randomsu[i] != randomsu[i - 3] && randomsu[i] != randomsu[i - 4])
		/*배열에 같은 수가 있는지 비교*/
		{
			
			cnt++;//카운트 증가
			i++;//i증가
		}

		else//중복되는수가있다면
		{
			continue;//와일문처음으로돌아감.
		}
	}
	printf("숨겨진 값 : %s\n", randomsu);
	return randomsu;//생성된 랜덤함수를 메인에 리턴함.

}
char nope(char *innumber)//사용자가 입력하는 값
{
	int i, j, cnt;//i,j,cnt선언
	int len = 0;//길이비교하기위한 인트형 정수 len 선언
	while (1)//계속돈다.
	{
		cnt = 0;//만일 중복되는 수가 있을 시 다시 돌때 cnt를 0으로 초기화해줌.
		printf("수를 입력하시오.\n");//인터페이스
		scanf("%s", innumber);//값 입력
		len = strlen(innumber);//길이를 비교하기위해 인넘의 길이를 읽음.
		if (len == 5)//입력된 수가 5자리면
		{

			for (i = 0; i < 5; i++)//입력된 자리수 하나하나 비교하기위한 2중포문
			{

				for (j = i + 1; j < 5; j++)
				{
					if (innumber[i] == innumber[j])//같은 수가 있다면
					{
						cnt++;//cnt가 증가한다.

					}

				}
			}
			if (cnt != 0) {//cnt가 0이아니면 오류출력
				printf("오류입니다. 중복되는 수를 입력하지 마시오.\n");
				continue;//와일문을 다시 돌린다.
			}
			
			break;//cnt가 0이면 와일문을 멈춘다.
		}
		else//5자리 수가 아니라면 오류출력
		{

			printf("오류입니다. 숫자는 5개만 입력하셔야합니다.\n");
			continue;//와일문을 다시돌린다.
		}




	}
	printf("플레이어 입력값 : %s\n", innumber);//입력한 수 출력

	return innumber;//입력한 수를 메인에 리턴해준다.

}
int cpn(char *randomsu, char*innumber)//비교함수
{
	int strike = 0;//스트라이크 선언
	int ball = 0;//볼 선언
	int i = 0;//i,j선언
	int j = 0;

	for (i = 0; i < 5; i++)//랜덤함수와 사용자가 입력한 수를 비교하기 위한 2중포문
	{
		for (j = 0; j < 5; j++)
		{
			if (randomsu[i] == innumber[j])//랜덤함수와 사용자가 입력한 수에 같은 값이 있다면
			{
				if (randomsu[i] == innumber[i])//같은 값이 같은 위치에 있다면
				{
					strike += 1;//스트라이크 증가.
				}
				else {//값이 다른 위치에 있다면
					ball += 1;//볼 증가
				}
			}
		}
	}
	printf("결과값 : %dS %dB\n", strike, ball);//몇 스트라이크 몇 볼인지 출력해줌.
	if (strike == 5)//스트라이크가 5라면 정답 출력
	{
		printf("축하합니다. 정답입니다.\n");
	}
	return strike;//스트라이크를 리턴해준다.

}
