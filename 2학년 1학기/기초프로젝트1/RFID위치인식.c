//개발자 : 주호승
//개발 목적 :창고관리를 더욱 원할하게 하기 위해 프로그램을 만듦.
//개발 시작일 : 2018.05.04
//개발 종료일: 2018.05.22

#include<stdio.h>
#include<stdlib.h>
#include<stdint.h>
#include<string.h>
#pragma warning(disable:4996)

typedef struct taginfo1 {//연결리스트 구조체
	char id[27];//주소
	float rssi;//RSSI값
	double identifiedTime;//인터벌값
	struct taginfo1 *next;//연결리스트의 다음노드
} TAGINFO1;
typedef struct taginfo2 {//연결리스트에 넣은 레퍼런스들의 평균 RSSI값과 평균 인터벌 값을 연결리스트에 넣음.
	
	double total;
	int fo[2];
	struct taginfo2 *next;
} result;

TAGINFO1*head; result*head1;//각 연결리스트의 head 선언
char addnode(char *in1, char* rssi, char *total);//연결리스트 연결
double search(char(*ID)[27]);//A구현 연결리스트에 넣어진 값 찾기
double search2(char*ID[27]);//B구현 연결리스트에 넣어진 값 찾기
double search3(double inza, int x, int y);//C구현 연결리스트에 넣어진 값 찾기
void print();
void print1();//타겟의 좌표 출력
int main()
{
	char targetID[27] = "0x35E0170044CF0D590000F5A5";//타겟 주소
	char referenceIDs[60][27] = {//레퍼런스들의 주소
		"0x35E0170044CF0D590000F544","0x35E0170044CF0D590000F543","0x35E0170044CF0D590000F542","0x35E0170044CF0D590000F551","0x35E0170044CF0D590000F550","0x35E0170044CF0D590000F54F",
		"0x35E0170044CF0D590000F61D","0x35E0170044CF0D590000F61C","0x35E0170044CF0D590000F61B","0x35E0170044CF0D590000F61A","0x35E0170044CF0D590000F629","0x35E0170044CF0D590000F628",
		"0x35E0170044CF0D590000F54E","0x35E0170044CF0D590000F55D","0x35E0170044CF0D590000F55C","0x35E0170044CF0D590000F55B","0x35E0170044CF0D590000F55A","0x35E0170044CF0D590000F569",
		"0x35E0170044CF0D590000F627","0x35E0170044CF0D590000F626","0x35E0170044CF0D590000F635","0x35E0170044CF0D590000F634","0x35E0170044CF0D590000F633","0x35E0170044CF0D590000F632",
		"0x35E0170044CF0D590000F568","0x35E0170044CF0D590000F567","0x35E0170044CF0D590000F566","0x35E0170044CF0D590000F575","0x35E0170044CF0D590000F574","0x35E0170044CF0D590000F573",
		"0x35E0170044CF0D590000F641","0x35E0170044CF0D590000F640","0x35E0170044CF0D590000F63F","0x35E0170044CF0D590000F63E","0x35E0170044CF0D590000F64D","0x35E0170044CF0D590000F64C",
		"0x35E0170044CF0D590000F572","0x35E0170044CF0D590000F581","0x35E0170044CF0D590000F580","0x35E0170044CF0D590000F57F","0x35E0170044CF0D590000F57E","0x35E0170044CF0D590000F58D",
		"0x35E0170044CF0D590000F64B","0x35E0170044CF0D590000F64A","0x35E0170044CF0D590000F659","0x35E0170044CF0D590000F658","0x35E0170044CF0D590000F657","0x35E0170044CF0D590000F656",
		"0x35E0170044CF0D590000F58C","0x35E0170044CF0D590000F58B","0x35E0170044CF0D590000F58A","0x35E0170044CF0D590000F599","0x35E0170044CF0D590000F598","0x35E0170044CF0D590000F597",
		"0x35E0170044CF0D590000F603","0x35E0170044CF0D590000F5F8","0x35E0170044CF0D590000F5F7","0x35E0170044CF0D590000F5F6","0x35E0170044CF0D590000F605","0x35E0170044CF0D590000F604"
	};
	int referecePoints[60][2] = {//레퍼런스들의 좌표
		{ 7, 1 },{ 22, 1 },{ 37, 1 },{ 52, 1 },{ 67, 1 },{ 81, 1 },
	{ 101, 1 },{ 116, 1 },{ 131, 1 },{ 146, 1 },{ 161, 1 },{ 176, 1 },
	{ 7, 41 },{ 22, 41 },{ 37, 41 },{ 52, 41 },{ 67, 41 },{ 81, 41 },
	{ 101, 41 },{ 116, 41 },{ 131, 41 },{ 146, 41 },{ 161, 41 },{ 176, 41 },
	{ 7, 80 },{ 22, 80 },{ 37, 80 },{ 52, 80 },{ 67, 80 },{ 81, 80 },
	{ 101, 80 },{ 116, 80 },{ 131, 80 },{ 146, 80 },{ 161, 80 },{ 176, 80 },
	{ 7, 115 },{ 22, 115 },{ 37, 115 },{ 52, 115 },{ 67, 115 },{ 81, 115 },
	{ 101, 115 },{ 116, 115 },{ 131, 115 },{ 146, 115 },{ 161, 115 },{ 176, 115 },
	{ 7, 144 },{ 22, 144 },{ 37, 144 },{ 52, 144 },{ 67, 144 },{ 81, 144 },
	{ 101, 144 },{ 116, 144 },{ 131, 144 },{ 146, 144 },{ 161, 144 },{ 176, 144 }
	};
	char fstring[2650];//파일의 값들을 읽어오기위한 변수
	head = NULL;//헤드 초기화
	char choice;//입력받을변수
	int i = 0;////인덱스초기화
	char in1[120];
	int j = 0;
	float num = 0;//정수로 변환된 문자열 넣어줌.
	float num1 = 0; double num2 = 0; double num3 = 0; double num4 = 0; double num5 = 0;//수로 변환된 문자열 받는 변수
	char in2[120], in3[120], in4[120], in5[120], in6[120], in7[120];//정수를 문자열로 , 문자열을 정수로 변활할때 사용
	char *tok;//자른 문자열 받는 변수
	int cnt = 0;//몇번째에 자를지 세는 변수
	double inza[70][50];//계산되어 나온 평균rssi값 받기위한 변수
	double inza2 = 0;//타겟의 RSSI평균값 받기위한 변수
	double inza3;//타겟과 평균 rssi뺀값을 받는 변수
	int x = 0;//x좌표값받는변수
	int y = 0;//y좌표값 받는 변수
	
	double inza6;//-인 RSSI값을 +로 바꿔주기  위한 변수
	printf("=============================================================\n");
	printf("RFID Tag Information Analysis based Localization System\n");
	printf("=============================================================\n");
	printf("A.Reference Tag Analysis\n");         // 선택 시 참조태그들의 정보 분석 값 출력
	printf("B.Target Tag Analysis\n");            // 선택 시 타켓 태그의 정보 분석 값 출력
	printf("C.Estimation of Target Position\n");   // 선택 시 타켓의 위치 예측 값 출력
	printf("D.Quit\n"); // 선택 시 종료

	
	
		FILE* fp = fopen("RFID_Data.txt", "r"); //로컬넘버 파일 불러옴.

		while (!feof(fp))//파일의끝까지 반복
		{
			cnt = 0;//몇번끊었는지 확인
			fgets(fstring, 120, fp);//파일에서 한 문단씩 읽어옴 
			
			tok = strtok(fstring, ".=,-:T");//.+,-:T에서 끊는다.
			while (cnt != 19)//끊어지는 문자열이 총 18개 여서 19개되면 멈춤
			{
				tok = strtok(NULL, ".=,-:T");//.+,-:T에서 끊는다.
				cnt++;//카운트 증가
				if (cnt == 3)//카운트가3이면
				{
					
					strcpy(in1, tok);//in1에 tok를 카피한다.
				}

				if (cnt == 9)//카운트가 9이면
				{
					
					strcpy(in2, tok);//in2에 tok를 카피한다.
					num = atoi(tok);//넘에다 문자열인 tok을 정수값인 넘에 넣어줌.

				}
				if (cnt == 14)//카운트가 14이면
				{
					
					strcpy(in3, tok);//in3에 tok 카피
					num1 = atoi(tok) * 60 * 60 * 1000;//넘1에 정수로 바뀐 문자열에 밀리세컨드 변환공식사용
				}
				if (cnt == 15)//카운트가 15이면
				{
					
					strcpy(in4, tok);//in4에 tok카피
					num2 = atoi(tok) * 60 * 1000;//넘2에 정수로 바뀐 문자열에 밀리세컨드 변환공식사용
				}
				if (cnt == 16)//카운트가 16이면
				{
				
					strcpy(in5, tok);//in5에 tok카피
					num3 = atoi(tok) * 1000;//넘3에 정수로 바뀐 문자열에 밀리세컨드 변환공식 사용
				}
				if (cnt == 17)//카운트가 17이면
				{
					
					num4 = atoi(tok);//넘4에 밀리세컨드 넣음
				}
				if (cnt == 18)//카운트가 18이면
				{
					num5 = num1 + num2 + num3 + num4;//넘 5에 변환된 밀리세컨드 값 넣어줌.
					
					itoa(num5, in7, 10);//넘5를 다시 문자로 바꿈
					
					addnode(in1, &in2, &in7);//노드에 추가

				}
			}

		}
		scanf("%c", &choice);//어떤 프로그램 실행할지 고름

		if (choice == 'A')//A이면
		{
			for (j = 0; j < 60; j++)//j가 60일때까지
			{
				inza[j][10]=search(referenceIDs[j]);//레퍼런스 아이디에 해당하는 값을 연결리스트를 통해 찾고 RSSI값과 평균 인터벌 계산
				
			}
		}
		else if (choice == 'B')//B일때
		{
			inza2=search2(targetID);//타겟의 평균 RSSI값과 인터벌값 연산
			
		}
		else if (choice == 'C')//C일때
		{
			for (j = 0; j < 60; j++)//60번반복
			{
				inza[j][50] = search(referenceIDs[j]);//연결리스트에 저장된 레퍼런스들의 평균 rssi,인터벌값 가져옴
			}
			
			for (i = 0; i < 60; i++)
			{
				inza2 = 158.779999;//inza2는 158.779999로 고정
				inza3=inza2-inza[i][50];//inza3에 타겟의 rssi와 레퍼런스들의 평균 rssi를 뺌
				if (inza3<0)//값이 음수면
				{
					inza6=-1 * inza3;//-1을 곱해줘 양수로 만듬
				}
				else//아니면
				{
					inza6 = inza3;//그값 그대로 넣음
				}
				printf("%lf\n", inza6);//출력
			
				
				x = referecePoints[i][0];//레퍼런스 순서대로 좌표값 넣음.x
				y = referecePoints[i][1];//y
				search3(inza6, x,y);//오름차순으로 정렬함
				
				
			}
			print1();//출력

		

		}
		else if (choice == 'D')//D이면
		{
			return 0;//프로그램 종료
		}
			getch();//cmd창이 꺼지지 않게 함.
			return 0;

		fclose(fp);//파일 닫음.
}
char addnode(char *in1, char* rssi, char *total)//잘려진 문자열 연결리스트에 추가
{
	float rssi1 = 0;//rssi변수
	double total1 = 0;//인터벌값변수
	total1 = atoi(total);//받아온 인터벌값 정수로 바꿈
	rssi1 = atoi(rssi);//받아온 rssi값 정수로 바꿈
	TAGINFO1*newnode;//뉴노드 생성
	newnode = (TAGINFO1*)malloc(sizeof(TAGINFO1));//동적할당
	newnode->next = NULL;//다음노드는 널이다
	strcpy(newnode->id, in1);//노드의 id에 레퍼런스 주소 카피
	newnode->rssi = rssi1;//rssi에 rssi값넣음
	newnode->identifiedTime = total1;//인터벌값 넣음

	if (head == NULL)//헤드가 널이면
	{
		head = newnode;//헤드는 노드를 가르치게함.
	}
	else//널이아니면
	{
		newnode->next = head->next;//노드의 다음 노드를 헤드의다음을가르키게하고
		head->next = newnode;//헤드는 뉴노드를 가르키게함.
	}
}
double search(char(*ID)[27])//주소가 같은 것들의 평균 rssi값과 인터벌값 계산
{
	int i = 0;//인덱스값
	double num = 0; double num1 = 0;//인터벌값 더하기 위한 변수
	float num2 = 0; float num3 = 0;//rssi값 더하기 위한 변수
	int cnt = 0;//카운트
	TAGINFO1*temp = head;//temp선언
	while (temp != NULL)//템프가 널이아니면
	{
		if (strcmp(temp->id, ID) == 0)//레퍼런스 id와 연결리스트에 있는 id가 같으면
		{

			num2 = temp->rssi;//넘2에 rssi값을 넣고
			num1 = temp->identifiedTime;//넘1에 인터벌값넣는다
			num3 += num2;//num3은 받아오는 rssi값을전부더한다
			num += num1;//num은 받아오는 인터벌값 전부 더한다.
			cnt++;//카운트 증가
			temp = temp->next;//다음노드로 이동
		}

		else {
			temp = temp->next;//해당없으면 다음노드로이동
		}
	}
	num3 = num3 / cnt;//평균을구하기위해 들어간만큼나눈다.
	num = num / cnt;//평균을 구하기 위해 들어간 만큼 나눈다.
	printf("%s의 RSSI값은 %f 이고 인터벌 평균은 %lf이다.\n",ID, num3, num);//출력
	return num3;//rssi값 반환



}

double search2(char*ID)//타겟의 평균 구하기
{
	int i = 0;//인덱스값 변수
	double num = 0; double num1 = 0;//인터벌값 평균내기위한변수
	float num2 = 0; float num3 = 0;//RSSI값 평균내기위한변수
	int cnt = 0;//카운트
	TAGINFO1*temp = head;//템프는 헤드를 바라보게함
	while (temp != NULL)//템프가 널아니면돈다
	{
		if (strcmp(temp->id, ID) == 0)//아이디가 동일하면
		{

			num2 = temp->rssi;//넘2에 rssi값넣고
			num1 = temp->identifiedTime;//넘1에 인터벌값넣고
			num3 += num2;//다더해준다
			num += num1;//다더해준다
			cnt++;//카운트증가
			temp = temp->next;//다음노드로이동
		}

		else {
			temp = temp->next;//다음노드로이동
		}
	}
	num3 = num3 / cnt;//평균내기
	num = num / cnt;//평균내기
	printf("%s의 RSSI값은 %f 이고 인터벌 평균은 %lf이다.\n", ID, num3, num);//출력
	return num3;//RSSI값 반환



}

double search3(double inza, int x, int y)//오름차순 정렬 및 연결리스트 추가
{//출처 http://egloos.zum.com/aneedyou/v/846196 오름차순 코드 잘 몰라 참고함.

	result*cur;//cur 선언
	cur = head1;//cur이 헤드1을보게함.
	result*newnode;//뉴노드생성
	newnode = (result*)malloc(sizeof(result));//동적할당
	newnode->total = inza;//계산된 rssi값 넣어줌
	newnode->fo[0] = x;//x좌표넣어줌
	newnode->fo[1] = y;//y좌표넣어줌
	
	

	if (head1 == NULL)//해드가 널이면
	{
		head1 = newnode;//헤드1이 뉴노드 보게함
		newnode->next = NULL;//뉴노드의 다음노드는 널이다
		return;

	}
	if (newnode->total <head1->total)//새로운값이 노드에있는값보다작으면
	{
		newnode->next = head1;//맨앞추가
		head1 = newnode;
		return;
	}
		
		while (1)//무한루프
		{
			if (cur->next == NULL)//cur의 다음노드가 널이면 
			{
				cur->next = newnode;//맨뒤삽입
				newnode->next = NULL;
				return;
			}
			else if (cur->next->total > newnode->total)//cur의 다음노드의 값이 뉴노드의 값보다 클경우
			{
				newnode->next = cur->next;//중간삽입
				cur->next = newnode;
				return;
			}
			else
			{
				cur = cur->next;//다음노드로이동
			}
	
		
	}

}
void print1() {//출력부분

	result *cur;//cur 선언
	double result[10000];//1/오차*오차들 연산변수
	double result1 = 0.0;//1/오차*오차들의 합 받아주기위한변수
	int fom[10][2];//좌표 받아주기 위한 변수
	cur = head1;//cur은 헤드를가르킨다.
	double x;//좌표x받기위한변수
	double x2=0;//연산된x받기위한변수
	double y;//y변수
	double y2=0;//연산된변수y받기
	int choice;//몇번돌지선택
	int cnt = 0;//
	int i = 0;
	int j = 0;
	int cnt2 = 0;
	double a = 0;
	printf("오차범위를 선택하시오.\n");
	scanf("%d", &choice);//선택
		while (cur->next != NULL)//cur이 널이아니면
		{
			if (cnt == choice)//선택된만큼돌고종료
			{
				break;
			}
			
			a = cur->total;//a에 오차값넣음
			fom[i][0] = cur->fo[0];//좌표x넣음
			fom[i][1] = cur->fo[1];//좌표y넣음
			
			result[i] = 1/(a*a);//1에 오차제곱 나눈것을 리솔트에 넣음
			cnt++;//카운트 증가
			i++;//인덱스증가
			result1 += result[i];//리솔트1에 전부 더함.
			cur = cur->next;//다음노드로이동
		}
		while (cnt2 != choice)//cnt가 초이스가 아니면
		{
			
			x=(double)fom[j][0]*(result[j] / result1);//각 해당 레퍼런스에 해당하는 좌표와 rssi를
													//연산하여 가중치계산
			y=(double)fom[j][1] * (result[j] / result1);//가중치계산
			x2 += x;//나온 값을 x2에 전부 더함.
			y2 += y;//나온 값을 y2에 전부 더함
			cnt2++;//cnt증가
			j++;//j증가
		}
		printf("x 는 %lf y는 %lf이다\n", x2, y2);//좌표값 출력
		
	

}
	





