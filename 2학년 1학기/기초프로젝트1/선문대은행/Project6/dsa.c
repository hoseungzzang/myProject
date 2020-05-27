#pragma warning(disable:4996)
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<string.h>

int payment();
int sunmoonpayment();
int card();
int search(char* i);
int interface();
int member(char *ID, int pass);
void UserRegister();
void withdraw(char *ID);
void insertMoney(char *ID);
void sendMoney();
void haksik(float total, char *ID);
float total;
int ne = 0;
int main()
{
	int key = 40;
	int i = 0;//로그인 인덱스
	char ID[10];//아이디
	int pass, enpass;
	int choice = 0;
	int choice2 = 0;
	FILE*fp = NULL;

	while (1)
	{
		choice = interface();//인터페이스 지속적으로 불러옴
		system("cls");

		if (choice == 1)//입금
		{
			while (1) {//로그인 파트
				printf("ID를 입력하시오:");
				scanf("%s", ID);
				if ((pass = search(ID)) == 1) {//실패시
					printf("다시 입력하시오.\n");
					continue;
				}
				else {
					while (1) {
						printf("비밀번호를 입력하시오.:");
						scanf("%d", &enpass);
						if (pass == enpass ^ key) { break; }//맞을시 나감 , 비트연산자 이용한 암호화
						i++;
						printf("%d time\n", i);
						if (i == 3) {//3번 실수하면 끝남 
							printf("입력제한으로 인해 종료합니다.\n");
							return 0;
						}
					}
					break;
				}
			}
			system("cls");
			insertMoney(ID);
			printf("더 이용하시겠습니까?\n");//더 이용할지 여부 확인
			printf("1) 예\n2) 아니오");
			scanf("%d", &ne);
			system("cls");
			if (ne == 1)
			{
				continue;

			}
			else
			{
				return 0;
			}
		}

		else if (choice == 2)//출금
		{

			while (1) {
				printf("ID를 입력하시오:");//로그인 파트
				scanf("%s", ID);
				if ((pass = search(ID)) == 1) {
					printf("다시 입력하시오.\n");
					continue;
				}
				else {
					while (1) {
						printf("비밀번호를 입력하시오.:");
						scanf("%d", &enpass);
						if (pass == enpass ^ key) { break; }//암호화,맞으면 나감.
						i++;
						printf("%d time\n", i);
						if (i == 3) {//3번 실수하면 끝남 
							printf("입력제한으로 인해 종료합니다.\n");
							return 0;
						}
					}
					break;
				}
			}
			printf("connected\n");
			withdraw(ID);
			printf("더 이용하시겠습니까?\n");//더 이용할지 여부 확인
			printf("1) 예\n2) 아니오");
			scanf("%d", &ne);
			system("cls");
			if (ne == 1)
			{
				continue;

			}
			else
			{
				return 0;
			}
		}
		else if (choice == 3)//신규계좌생성
		{
			while (1) {
				printf("ID를 입력하시오:");//로그인 파트
				scanf("%s", ID);
				if ((pass = search(ID)) == 1) {
					printf("다시 입력하시오.\n");
					continue;
				}
				else {
					while (1) {
						printf("비밀번호를 입력하시오.:");
						scanf("%d", &enpass);
						if (pass == enpass^key) { break; }//암호화,맞을시 나감.
						i++;
						printf("%d time\n", i);
						if (i == 3) {//3번 실수하면 끝남 
							printf("입력제한으로 인해 종료합니다.\n");
							return 0;
						}
					}
					break;
				}
			}

			member(ID, enpass);
			system("cls");

		}
		else if (choice == 4)//혜택보기
		{
			card();
			printf("계속 이용하기 : 1\n종료하기 :2\n");
			scanf("%d", &choice2);
			system("cls");
			if (choice2 == 1)
			{
				continue;
			}
			else if (choice2 == 2)
			{
				return 0;
			}
		}
		else if (choice == 5)
		{
			sendMoney();//송금파트
		}

		else if (choice == 6)//결제파트
		{

			while (1) {
				printf("ID를 입력하시오:");//로그인부
				scanf("%s", ID);
				if ((pass = search(ID)) == 1) {
					printf("다시 입력하시오.\n");
					continue;
				}
				else {
					while (1) {
						printf("비밀번호를 입력하시오.:");
						scanf("%d", &enpass);
						if (pass == enpass^key) { break; }//암호화 맞을시 탈출
						i++;
						printf("%d time\n", i);
						if (i == 3) {//3번 실수하면 끝남 
							printf("입력제한으로 인해 종료합니다.\n");
							return 0;
						}
					}
					break;
				}
			}
			printf("connected\n");
			
			sunmoonpayment();
		}
		else if (choice == 9)//종료
		{
			return 0;
		}
		else if (choice == 7)//학식총액조회
		{
			while (1) {
				printf("ID를 입력하시오:");//로그인파트
				scanf("%s", ID);
				if ((pass = search(ID)) == 1) {
					printf("다시 입력하시오.\n");
					continue;
				}
				else {
					while (1) {
						printf("비밀번호를 입력하시오.:");
						scanf("%d", &enpass);
						if (pass == enpass^key) { break; }//암호화,맞을시 탈출
						i++;
						printf("%d time\n", i);
						if (i == 3) {//3번 실수하면 끝남 
							printf("입력제한으로 인해 종료합니다.\n");
							return 0;
						}
					}
					break;
				}
			}
			printf("connected\n");
			haksik(total, ID);

		}
		else if (choice == 8)
		{
			UserRegister();//회원가입 파트
		}
	}
	system("pause");
}

int sunmoonpayment()//결제파트
{

	char sid[20]; char sname[20]; int smoney = 0;//변수선언
	int choice = 0;
	int menuchoice = 0;
	int konaking = 0;
	int momstouch = 0;
	int Sfood = 0;
	int Sfood1 = 0;
	int Sfood2 = 0;
	int Sfood3 = 0;
	int Sfoodtotal = 0;
	int order = 0;
	int nextorder = 0;
	int orange = 0;
	int cnt1 = 0; int cnt2 = 0; int cnt3 = 0;
	int ssmoney = 0;
	FILE*fp = fopen("mo.txt", "a");//파일오픈
	FILE*fp2 = fopen("mo.txt", "r");
	FILE*fp1 = fopen("haks.txt", "a");
	FILE*fp3 = fopen("haks.txt", "r");
	while (!feof(fp2))//돈,정보 들어있는 파일 오픈
	{
		fscanf(fp2, "%s %s %d", sid, sname, &smoney);
	}
	while (!feof(fp3))//학식 총액 쓰기위한파일
	{
		fscanf(fp3, "%d", &ssmoney);
	}
	printf("어떤 음식을 드시겠 습니까?\n");
	printf("1:코나킹 2:맘스터치 3:학식 4:오랜지식당\n");
	scanf("%d", &menuchoice);
	if (menuchoice == 1)
	{
		while (order != 3)
		{
			printf("코나킹 메뉴\n");
			printf("1)아이스티[2000원]  2)아메리카노[2500원]  3)카푸치노[3000원]\n");
			scanf("%d", &konaking);//15퍼
			if (konaking == 1)
			{

				printf("더 구매하시겠 습니까?\n");
				printf("1:예\n2:아니오\n");
				scanf("%d", &nextorder);
				if (nextorder == 1)
				{
					order = 0;
				}
				else if (nextorder == 2)
				{
					order = 3;
				}
				cnt1++;
			}
			else if (konaking == 2)
			{

				printf("더 구매하시겠 습니까?\n");
				printf("1:예\n2:아니오\n");
				scanf("%d", &nextorder);
				if (nextorder == 1)
				{
					order = 0;
				}
				else if (nextorder == 2)
				{
					order = 3;
				}
				cnt2++;
			}
			else if (konaking == 3)
			{

				printf("더 구매하시겠 습니까?\n");
				printf("1:예\n2:아니오\n");
				scanf("%d", &nextorder);
				if (nextorder == 1)
				{
					order = 0;
				}
				else if (nextorder == 2)
				{
					order = 3;
				}
				cnt3++;
			}

		}
		printf("합산액은 %d 입니다.\n", cnt1* (2000 - (2000 * 0.15)) + cnt2 * (2500 - (2500 * 0.15)) + cnt3 * (3000 - (3000 * 0.15)));//전부 합산해 가지고있는 돈에서 빼준다.
		smoney -= (cnt1 * (2000 - (2000 * 0.15))) + (cnt2 * (2500 - (2500 * 0.15))) + (cnt3 * (3000 - (3000 * 0.15)));
		fprintf(fp, "%s %s %d", sid, sname, smoney);
		fclose(fp); fclose(fp1);
	}//코나킹 
	else if (menuchoice == 2)
	{
		while (order != 3)
		{
			printf("맘스터치 메뉴\n");
			printf("1)싸이버거 세트[6500원]  2)휠렛버거세트[6700원]  3)햄치즈휠렛버거세트[7000원]\n");
			scanf("%d", &momstouch);
			if (momstouch == 1)
			{
				printf("더 구매하시겠 습니까?\n");
				printf("1:예\n2:아니오\n");
				scanf("%d", &nextorder);
				if (nextorder == 1)
				{
					order = 0;
				}
				else if (nextorder == 2)
				{
					order = 3;
				}
				cnt1++;
			}
			else if (momstouch == 2)
			{
				printf("더 구매하시겠 습니까?\n");
				printf("1:예\n2:아니오\n");
				scanf("%d", &nextorder);
				if (nextorder == 1)
				{
					order = 0;
				}
				else if (nextorder == 2)
				{
					order = 3;
				}
				cnt2++;
			}
			else if (momstouch == 3)
			{
				printf("더 구매하시겠 습니까?\n");
				printf("1:예\n2:아니오\n");
				scanf("%d", &nextorder);
				if (nextorder == 1)
				{
					order = 0;
				}
				else if (nextorder == 2)
				{
					order = 3;
				}
				cnt3++;
			}


		}
		printf("합산액은 %d 입니다.", cnt1* (6500 - (6500 * 0.10)) + cnt2 * (6700 - (6700 * 0.10)) + cnt3 * (7000 - (7000 * 0.10)));//전부 합산해 가지고 있는 돈에서 빼줌
		smoney -= (cnt1 * (6500 - (6500 * 0.10))) + (cnt2 * (6700 - (6700 * 0.10))) + (cnt3 * (7000 - (7000 * 0.10)));
		fprintf(fp, "%s %s %d", sid, sname, smoney);
		fclose(fp);
	}
	else if (menuchoice == 3)
	{
		while (order != 3)
		{
			printf("학식 메뉴\n");
			printf("1)돈까스[4500원]  2)오므라이스[4000원]  3)함박스테이크[4500원]\n");
			scanf("%d", &Sfood);
			if (Sfood == 1)
			{
				printf("돈까스를 결제했습니다.\n");
				Sfood1++;
				printf("더 구매하시겠 습니까?\n");
				printf("1:예\n2:아니오\n");
				scanf("%d", &nextorder);
				if (nextorder == 1)
				{
					order = 0;
				}
				else if (nextorder == 2)
				{
					order = 3;
				}
			}
			else if (Sfood == 2)
			{
				printf("오므라이스를 결제했습니다.\n");
				Sfood2++;
				printf("더 구매하시겠 습니까?\n");
				printf("1:예\n2:아니오\n");
				scanf("%d", &nextorder);
				if (nextorder == 1)
				{
					order = 0;
				}
				else if (nextorder == 2)
				{
					order = 3;
				}
			}
			else if (Sfood == 3)
			{
				printf("함박 스테이크를 결제했습니다.\n");
				Sfood3++;
				printf("더 구매하시겠 습니까?\n");
				printf("1:예\n2:아니오\n");
				scanf("%d", &nextorder);
				if (nextorder == 1)
				{
					order = 0;
				}
				else if (nextorder == 2)
				{
					order = 3;
				}
			}
		}

		Sfoodtotal = (Sfood1 * (4500 - (4500 * 0.10))) + (Sfood2 * (4000 - (4000 * 0.10))) + (Sfood3 * (4500 - (4500 * 0.10)));//전부 합산해 학식 총액에 넣어줌.
		printf("합산 결제액은 %d입니다.\n", Sfoodtotal);
		ssmoney += Sfoodtotal;
		fprintf(fp1, "%d\n", ssmoney);
		system("pause");
		system("cls");
	}
	else if (menuchoice == 4)
	{
		while (order != 3)
		{
			printf("오랜지 식당 메뉴\n");
			printf("1)짜장면[3500원]  2)짬뽕[4000원]  3)볶음밥[4000원]\n");
			scanf("%d", &orange);
			if (orange == 1)
			{

				cnt1++;
				printf("더 구매하시겠 습니까?\n");
				printf("1:예\n2:아니오\n");
				scanf("%d", &nextorder);
				if (nextorder == 1)
				{
					order = 0;
				}
				else if (nextorder == 2)
				{
					order = 3;
				}
			}
			else if (orange == 2)
			{

				cnt2++;
				printf("더 구매하시겠 습니까?\n");
				printf("1:예\n2:아니오\n");
				scanf("%d", &nextorder);
				if (nextorder == 1)
				{
					order = 0;
				}
				else if (nextorder == 2)
				{
					order = 3;
				}
			}
			else if (orange == 3)
			{

				cnt3++;
				printf("더 구매하시겠 습니까?\n");
				printf("1:예\n2:아니오\n");
				scanf("%d", &nextorder);
				if (nextorder == 1)
				{
					order = 0;
				}
				else if (nextorder == 2)
				{
					order = 3;
				}
			}


		}
		printf("합산액은 %d 입니다.", cnt1* (3500 - (3500 * 0.10)) + cnt1 * (4000 - (4000 * 0.10)) + cnt1 * (4000 - (3000 * 0.10)));
		smoney -= (cnt1 * (3500 - (3500 * 0.10))) + (cnt1 * (4000 - (4000 * 0.10))) + (cnt1 * (3000 - (3000 * 0.10)));//전부 합산해 소지금에서 뺸다.
		fprintf(fp, "%s %s %d", sid, sname, smoney);
		fclose(fp);
	}

}
int card() {//혜택 조회 파트
	printf("선문대학생을 위한 할인혜택입니다.\n");
	printf("혜택 1) 코나킹 모든 메뉴 15%할인\n");
	printf("혜택 2) 맘스터치 모든 메뉴 10%할인\n");
	printf("혜택 3) 학식을 바로 결제하지 않고, 나중에 일괄 결제 가능\n");
	printf("혜택 4) 오랜지식당 모든 메뉴 15%할인\n");
}
int search(char* i) {
	//로그인 파트
	FILE*fp;//아이디 비밀번호 파일 열어서 확인
	char id[10];
	int pass = 0;
	fp = fopen("login.txt", "r");

	while (fscanf(fp, "%s %d", id, &pass) != EOF) {
		if (strcmp(i, id) == 0) {//맞으면 pass리턴
			return pass;
		}

	}



	fclose(fp);
	printf("아이디 또는 패스워드가 잘못됨.\n");
	return 1;
}
int interface() {//인터페이스
	int choice = 0;
	printf("\t\t\t원하는 거래를 선택해주세요.\n");
	printf("-------------------\t\t\t\t\t");

	printf("-------------------\n");
	printf("            1.입금\t\t\t\t\t6.결제\n");
	printf("-------------------\t\t\t\t\t");
	printf("-------------------\n");
	printf("-------------------\t\t\t\t\t");

	printf("-------------------\n");
	printf("            2.출금\t\t\t\t\t7.학식총액조회\n");
	printf("-------------------\t\t\t\t\t");
	printf("-------------------\n");
	printf("-------------------\t\t\t\t\t");
	printf("-------------------\n");

	printf("        3.계좌생성\t\t\t\t\t8.아이디 생성\n");
	printf("-------------------\t\t\t\t\t");
	printf("-------------------\n");
	printf("-------------------\t\t\t\t\t");
	printf("-------------------\n");
	printf("     4.카드혜택조회\t\t\t\t\t9.종료\n");
	printf("-------------------\t\t\t\t\t");
	printf("-------------------\n");

	printf("-------------------\n");
	printf("            5.송금\t\t\t\t\n");
	printf("-------------------\t\t\t\t\t");







	scanf("%d", &choice);//원하는 거래 정수로 입력
	return choice;
}
void UserRegister()//아이디 비밀번호 생성
{
	char ch, id[20], name[20], firstMoney[20] = { 0 };//변수선언부
	int password = 0;
	int key = 40;
	char s1[20], s2[20], s3[20] = { 0 };	int i, j = 0;//포문 돌려주기 위한 i

	FILE *fpin = fopen("login.txt", "a");//파일 열기
	FILE *fps = NULL;
	if (fpin == NULL)
	{
		printf("eror");
	}


	printf("회원가입\n\n");//정보입력

	printf("Input Id : ");
	scanf("%s", id);
	printf("Input password : ");
	scanf("%d", &password);
	password^key;//암호화
	printf("Input name : ");
	scanf("%s", name);
	fprintf(fpin, "%s %d %s", id, password, name);
	fclose(fpin);

	printf("당신의 아이디는:%s 비밀번호는:%d 이름은:%s 입니다.\n", id, password, name);
}
int member(char *ID, int pass) {//계좌 생성파트
	int i;//변수 선언
	int size = 0;
	int j = 0;
	char sname[20]; int sage = 0; char smajor[20]; char shagbun[20]; int sphonenum = 0; int smoney = 0; char sun[20];
	char name[20] = { 0 };  char  major[20] = { 0 }; char sun1[20] = "sunmoonmember"; int count = 0; char live[20]; char nosun[20] = "nosunmoon";
	char hagbun[20] = { 0 }; int age = 0; int phonenum = 0; int money = 0; char slive[20]; char stong[20]; char tong[20]; char sid[20] = { 0 }; int spass = 0;
	srand((unsigned)time(NULL));//난수생성
	char random[8] = { 0 }; char random1[10] = { 0 };//랜덤함수 사용
	FILE*fp = NULL;//오픈할 파일 선언부
	FILE*fps = NULL;
	FILE*fp1 = NULL;
	FILE*fp2 = NULL;
	FILE*fp3 = NULL;

	printf("┌------------------------------------------------------------------------------------┐\n");
	printf("│                   ┌--------------------------------------------┐                 │\n");
	printf("│                   │     ★★★계  좌를 발급해 주세요★★★     │                 │\n");
	printf("│                   └--------------------------------------------┘                 │\n");
	printf("│                   ┌--------------------------------------------┐                 │\n");
	printf("│                   │			    1.선문대학생 계좌 발급         │                 │\n");
	printf("│                   │             2.일반인 계좌 발급             │                 │\n");
	printf("│                   └--------------------------------------------┘                 │\n");
	printf("└------------------------------------------------------------------------------------┘\n");

	scanf("%d", &i);
	system("cls");
	if (i == 1)//개인정보 입력
	{
		printf("1. 이름을 입력하세요 :");
		scanf("%s", name);
		printf("\n");
		printf("2. 나이를 입력하세요 :");
		scanf("%d", &age);
		printf("\n");
		printf("3. 학과를 입력하세요 :");
		scanf("%s", major);
		printf("\n");
		printf("4. 학번을 입력하세요 :");
		scanf("%s", hagbun);
		printf("\n");
		printf("5. 전화번호를 입력하세요 :");
		scanf("%d", &phonenum);
		printf("\n");
		printf("6. 소지금액을 입력하세요 :");
		scanf("%d", &money);
		printf("\n");
		//printf("%s %d %s %s %d %d", name, age, major, hagbun, phonenum, money);
		printf("입력을 완료하였습니다.");
		size++;

		fp = fopen("info.txt", "r");
		while (!feof(fp))//학번으로 계좌가 존제하는지 여부 확인
		{
			fscanf(fp, "%s %s %d %s %s %d %d %s %s", sid, sname, &sage, smajor, shagbun, &sphonenum, &smoney, stong, sun);
			if (strcmp(hagbun, shagbun) == 0)
			{
				printf("이미 계좌가 존제합니다.\n");
				count = 1;
				fclose(fp);

				break;
			}
			else
			{
				count = 2;

			}
		}
		if (count == 2)//계좌 랜덤으로 생성 후 파일에 쓰기
		{
			printf("계좌는 랜덤으로 생성됩니다.\n");
			for (i = 0; i < 7; i++)//i는 0부터 3까지 반복
			{
				random[i] = rand() % ((57 - 48) + 1) + 48;//아스키코드 0부터 9가 48에서 57인점을 사용
														  //개인넘의 0 1 2 3번째에 수 저장
														  //문자열로 받은이유는 정수로받으면 0111이 출력되었을경우 
														  //0이 출력이안됨.
			}

			printf("%s가 당신의 계좌입니다.\n", random);

			strcpy(tong, random);

			fps = fopen("info.txt", "a");
			fprintf(fps, "%s %s %d %s %s %d %d %s %s\n", ID, name, age, major, hagbun, phonenum, money, tong, sun1);
			fp3 = fopen("mo.txt", "a");
			fprintf(fp3, "%s %s %d", ID, name, money);
			fclose(fp3);
			fclose(fps);

		}


	}
	else if (i == 2)
	{
		system("cls");
		printf("┌---------------------------------------------------------------┐\n");
		printf("│      ★선문대학생이 아니면 혜택을 받을 수 없습니다.★         │\n");
		printf("└---------------------------------------------------------------┘\n");
		printf("1. 이름을 입력하세요 :");
		scanf("%s", name);
		printf("2. 나이를 입력하세요 :");
		scanf("%d", &age);
		printf("\n");
		printf("3. 전화번호를 입력하세요 :");
		scanf("%d", &phonenum);
		printf("\n");
		printf("4. 지역 입력하세요 :");
		scanf("%s", live);
		printf("\n");
		printf("5. 소지금액을 입력하세요 :");
		scanf("%d", &money);
		printf("\n");
		//printf("%s %d %d %s %d\n", name, age,phonenum,live, money);
		fp1 = fopen("info2.txt", "r");
		while (!feof(fp1))
		{
			fscanf(fp1, "%s %s %d %d %s %d %s %s", sid, sname, &sage, &sphonenum, slive, &smoney, stong, sun);
			if (sphonenum == phonenum)
			{
				printf("는이미 계좌가 존제합니다.\n");
				count = 1;
				fclose(fp1);
				break;
			}
			else
			{
				count = 2;

			}
		}
		if (count == 2)
		{
			printf("계좌는 랜덤으로 생성됩니다.\n");
			for (i = 0; i < 7; i++)//i는 0부터 3까지 반복
			{
				random[i] = rand() % ((57 - 48) + 1) + 48;//아스키코드 0부터 9가 48에서 57인점을 사용
														  //개인넘의 0 1 2 3번째에 수 저장
														  //문자열로 받은이유는 정수로받으면 0111이 출력되었을경우 
														  //0이 출력이안됨.
			}

			printf("%s가 당신의 계좌입니다.\n", random);
			strcpy(tong, random);
			fp2 = fopen("info2.txt", "a");
			fprintf(fp2, "%s %s %d %d %s %d %s %s\n", ID, name, age, phonenum, live, money, tong, nosun);
			fclose(fp2);
		}


	}
}
void withdraw(char *ID) {//출금파트
	char sname[20]; int sage = 0; char smajor[20]; char shagbun[20]; int sphonenum = 0; int smoney = 0; char sun[20]; char a[20], b[20]; int c = 0;//변수선언부
	char slive[20]; char stong[20]; char tong[20]; char sid[20] = { 0 }; int lmoney = 0; int ssmoney=0; char ssid[20]; char ssname[20];
	int num = 0; int money = 0;
	FILE *fp = fopen("info.txt", "r");//파일 오픈
	FILE*fp2 = fopen("info2.txt", "r");
	FILE*fp3 = fopen("mo.txt", "a");
	FILE*fp4 = fopen("mo.txt", "r");
	while (!feof(fp4))//정보,돈 읽어옴
	{
		fscanf(fp4, "%s %s %d", ssid, ssname, &ssmoney);

	}
	printf("아이디: %s 이름: %s 현재 금액: %d\n", ssid, ssname, ssmoney);//확인
	
	
		if (strcmp(ID, ssid) == 0)//id와 로그인 id 비교 후 맞으면 출금
		{

			
				printf("          ┌---------------------------------------------------------------┐\n");
				printf("          │                    얼마를 출금 하시겠습니까?                  │\n");
				printf("          └---------------------------------------------------------------┘\n");
				printf("                             출금하실 금액을 입력하여주세요 : ");

				scanf("%d", &num);

				lmoney = ssmoney - num;
				printf("          ┌---------------------------------------------------------------┐\n");
				printf("          │                        출금되었습니다!!!:                     │\n");
				printf("          └---------------------------------------------------------------┘\n");

				printf("%s %s 잔액:%d\n", ssid, ssname, lmoney);
				fprintf(fp3, "%s %s 잔액:%d\n", ssid, ssname, lmoney);
				fclose(fp3);
				
			
			
		}


	


}
void insertMoney(char *ID) {//입금파트
	char sname[20]; int sage = 0; char smajor[20]; char shagbun[20]; int sphonenum = 0; int smoney = 0; char sun[20]; char a[20], b[20]; int c = 0;//변수선언부
	char slive[20]; char stong[20]; char tong[20]; char sid[20] = { 0 }; int lmoney = 0; int ssmoney = 0; char ssid[20]; char ssname[20];
	int num = 0; int money = 0;
	FILE *fp = fopen("info.txt", "r");//파일 읽고 쓰기 오픈
	FILE*fp2 = fopen("info2.txt", "r");
	FILE*fp3 = fopen("mo.txt", "a");
	FILE*fp4 = fopen("mo.txt", "r");
	printf("로그인 되었습니다.\n");
	while (!feof(fp4))//정보,돈 파일 불러옴
	{
		fscanf(fp4, "%s %s %d", ssid, ssname, &ssmoney);
	}

	while (!feof(fp))//해당 계좌에 돈 입금.
	{
		fscanf(fp, "%s %s %d %s %s %d %d %s %s", sid, sname, &sage, smajor, shagbun, &sphonenum, &smoney, stong, sun);

		printf("          ┌---------------------------------------------------------------┐\n");
		printf("          │                    얼마를 입금 하시겠습니까?                  │\n");
		printf("          └---------------------------------------------------------------┘\n");
		printf("                             입금하실 금액을 입력하여주세요 : ");
		int num = 0;
		scanf("%d", &num);
		system("cls");
		ssmoney += num;
		printf("          ┌---------------------------------------------------------------┐\n");
		printf("          │                        입금되었습니다!!!:                     │\n");
		printf("          └---------------------------------------------------------------┘\n");
		fprintf(fp3, "%s %s %d\n", sid, sname, ssmoney);
		fclose(fp); fclose(fp2); fclose(fp3); fclose(fp4);
		break;
	}

}
void sendMoney() {//송금파트
	char num[40] = { 0 };//파일 입출력에 필요한 변수 선언부
	char sname[20]; int sage = 0; char smajor[20]; char shagbun[20]; int sphonenum = 0; int smoney = 0; char sun[20]; char sid[20]; char stong[20];
	char ssname[20]; char ssid[20]; int ssmoney = 0;
	FILE *fp = fopen("info.txt", "a+");//파일 열고 쓰기 오픈
	FILE*fp2 = fopen("mo.txt", "a");
	FILE*fp3 = fopen("mo.txt", "r");
	int num2 = 0;
	while (!feof(fp3))//정보,돈 파일 읽기
	{
		fscanf(fp3, "%s %s %d", ssid, ssname, &ssmoney);
	}

	while (!feof(fp))//학생 학번으로 조회 후 해당학생에게 송금.
	{
		fscanf(fp, "%s %s %d %s %s %d %d %s %s", sid, sname, &sage, smajor, shagbun, &sphonenum, &smoney, stong, sun);
		printf("          ┌---------------------------------------------------------------┐\n");
		printf("          │                송금하실 학생번호를 입력해주세요               │\n");
		printf("          └---------------------------------------------------------------┘\n");
		printf("                       송금받을 학생번호를 입력하세요 :");
		scanf("%s", num);
		system("cls");
		if (strcmp(num, shagbun) == 0)//학번이 맞으면
		{
			printf("          ┌---------------------------------------------------------------┐\n");
			printf("          │                    얼마를 송금 하시겠습니까?                  │\n");
			printf("          └---------------------------------------------------------------┘\n");
			printf("                             송금하실 금액을 입력하여주세요 : ");
			scanf("%d", &num2);
			ssmoney += num2;
			fprintf(fp2, "%s %s %d", ssid, ssname, ssmoney);
			printf("잔액:%d\n", ssmoney);
			break;

		}
		else {//없으면
			printf("          ┌---------------------------------------------------------------┐\n");
			printf("          │                     없는 학번입니다.                          │\n");
			printf("          └---------------------------------------------------------------┘\n");
		}
	}
}
void haksik(float total, char*ID) {//학식 조회 파트
	
	FILE*fp = fopen("haks.txt", "r");//파일 읽고 이어쓰기 모드 
	FILE*fp2 = fopen("haks.txt","a");
	FILE*fp1 = fopen("mo.txt", "r");
	char sid[20]; char sname[20]; int smoney = 0; int choice = 0; int tal = 0;//파일 오픈에 필요한 변수 선언
	while (!feof(fp1))//정보와 돈 파일 불러오기
	{
		fscanf(fp1, "%s %s %d", sid, sname, &smoney);
	}
	while (!feof(fp))//현재 쌓인 금액 불러오기
	{
		fscanf(fp, "%d", &tal);

	}
	printf("          ┌---------------------------------------------------------------┐\n");
	printf("                                  현재 총 금액 : %d                          \n", tal); //잔액 출력
	printf("          └---------------------------------------------------------------┘\n");
	printf("결제하시겠습니까?\n1)예,2)아니오\n");//잔액 결제할 것인지 여부 확인
	scanf("%d", &choice);
	if (choice == 1)
	{
		smoney -= tal;//현 돈에 결제
		fprintf(fp1, "%s %s %d", sid, sname, smoney);//다시 파일에 쓰기
		tal = 0;//총 금액 0원으로 초기화
		fprintf(fp2, "%d\n", tal);//파일에 쓰기
		printf("잔액은 : %d 입니다.\n", smoney);//잔고 표시
	}
	else//인터페이스로 돌아감
	{
		system("pause");
		system("cls");
		return;
	}
	
}