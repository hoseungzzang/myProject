//개발자 : 주호승
//개발 목적 : 살고있는 도시와 구를 입력받아 그에 맞는 번호를 받고 개인번호는 랜덤으로 생성되는 프로그램. 
//개발 시작일 : 2018.03.14
//개발 종료일: 2018.03.28

#pragma warning(disable:4996)
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<time.h>
typedef struct num //num이라는 구조체를num이라는 이름으로 생성
{
	char sublocalnum[5];//함수에서 서브로칼넘을 저장후 메인에서 서브로칼넘의값을 가져와 출력
	char gainnumber[20];//밸류로 인해 넘어온 값을 개인넘에 복사후 출력

}num;
//함수 선언 
char dosi(char *dosi2);//로컬번호 구하기
void sublo(char *ingu,num *lnum);//서브로컬번호구하기
char gain(char gainnum[10]);//게인번호구하기
int main() {
	num *NUM = (num*)malloc(sizeof(num) * 20);//동적할당
	char dosi2[20];//도시명입력 변수
	char ingu[20];//구입력변수
	char gainnum[5] = { NULL };//개인번호 받는 변수
	int end = 0;
	while (1)//무한루프 생성.
	{
		printf("번호를 생성하시겠습니까?\n 1번 : 진행\n 2번 : 끝내기\n");
		scanf("%d", &end);//계속 돌것인가 말것인가를 정함.
		if (end == 1)//진행
		{
			printf("선택하실 도시의 이름을 입력하시오 :\n");
			scanf("%s", dosi2);//입력할 도시 이름 입력

			dosi(dosi2);//dosi함수에 입력한 도시 이름 넘겨줌
			printf("선택하실 구의 이름을 입력하시오 :\n");
			scanf("%s", ingu);//구의 이름 입력
			sublo(ingu, NUM);//서브 로컬넘버 구하는 함수에 구 이름과 구조체하나 넘겨줌.
			printf("선택하신 구의 번호는 %s 입니다.\n", NUM->sublocalnum);//받아온 서브로컬넘버의 번호 출력
			printf("개인 번호 4자리는 랜덤입니다.\n");
			gain(&gainnum);//개인번호를 gainnum의 주소에 받아옴.

			printf("개인번호는 %s 입니다.\n", gainnum);//개인번호 출력
			strcpy(NUM->gainnumber, gainnum);//개인번호를 구조체의 개인넘에게 복사

			printf("%s-%s-%s 가 당신의 번호입니다.\n", dosi2, NUM->sublocalnum, NUM->gainnumber);//번호 생성완료
		}
		else//끝내기
			break;
	}




	getch();
	return 0;
}
char dosi(char*dosi2) //국번호 계산. 벨류사용
{
	FILE* fp = fopen("LocalNumberList.txt", "r"); //로컬넘버 파일 불러옴.
	char local[20];//로컬 지역 읽음.
	char numb[20];//로컨 넘버 읽음.

	while (!feof(fp))//파일의끝까지 반복
	{
		fscanf(fp, "%s%s", numb, local);//읽어옴.

		if (strcmp(dosi2, local) == 0)//문자열비교 입력값과 파일에서읽은 값이 같으면
		{
			
			strcpy(dosi2, numb);// 넘버를 dosi2에 복사
			
			printf("선택하신 도시의 번호는 %s 입니다.\n", dosi2);//확인을 위한 출력
			return dosi2;//dosi2값을 되돌려줌

		}
	}

	fclose(fp);//파일 닫음.
}

void sublo(char *ingu,num *lnum) // 구번호를 계산함. 레퍼런스 사용
{
	FILE* fp = fopen("SubLocalNumberList.txt", "r"); //서브로컬넘버리스트를 읽음.
	char dosi[20];//파일의 도시를 읽기위한 변수
	char gu[20];// 구 이름을 읽기위한 변수
	char gunum2[4][20];//읽은 번호를 저장하기위한 변수
	char gunum[20];//번호를읽기위한변수
	int i = 0;//gunum2의 방증가를 위한 변수
	int count = 0;//렌덤함수에 사용하기위한 카운트
	srand(time(NULL));//난수생성함수 선언
	while (!feof(fp))//파일의 끝까지 반복
	{
		fscanf(fp, "%s %s %s", dosi, gu, gunum);//도시,구,구번호를 읽어옴.
		if (strncmp(ingu, gu,sizeof(gu))== 0)//입력받은 구 이름과 파일에서 읽은 구를 비교 후 맞으면
		{
			strcpy(gunum2[i], gunum);//구넘버를 2중배열인 gunum2에 넣음.
			
			i++; //gunum2의 [0][1][2]의 방에 넣어주기위한 증가
			count++;//if문을 몇번 했는지 카운트.
			
		}
	}
	fclose(fp);//파일 닫아줌.
	 strcpy(lnum->sublocalnum, gunum2[rand() % count]);//gunum2의 2중배열의 방을 랜드함수로 랜덤하게 sublocalnum에 복사함. 방에 들어온 개수를 count로 저장해 몇개중에 난수를 생성할지 정함.
}

char gain(char gainnum[10])//개인번호를 계산함. 벨류사용
{

	int i=0;//포문 돌려주기 위한 i
	
		srand((unsigned)time(NULL));//난수생성

	
		for (; i < 4; i++)//i는 0부터 3까지 반복
		{
			gainnum[i] = rand() % ((57 - 48) + 1) + 48;//아스키코드 0부터 9가 48에서 57인점을 사용
			                                           //개인넘의 0 1 2 3번째에 수 저장
			                                           //문자열로 받은이유는 정수로받으면 0111이 출력되었을경우 
			                                           //0이 출력이안됨.
		}
		return gainnum;//숫자를 저장한 개인넘 반환.
}