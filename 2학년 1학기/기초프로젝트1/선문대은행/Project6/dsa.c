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
	int i = 0;//�α��� �ε���
	char ID[10];//���̵�
	int pass, enpass;
	int choice = 0;
	int choice2 = 0;
	FILE*fp = NULL;

	while (1)
	{
		choice = interface();//�������̽� ���������� �ҷ���
		system("cls");

		if (choice == 1)//�Ա�
		{
			while (1) {//�α��� ��Ʈ
				printf("ID�� �Է��Ͻÿ�:");
				scanf("%s", ID);
				if ((pass = search(ID)) == 1) {//���н�
					printf("�ٽ� �Է��Ͻÿ�.\n");
					continue;
				}
				else {
					while (1) {
						printf("��й�ȣ�� �Է��Ͻÿ�.:");
						scanf("%d", &enpass);
						if (pass == enpass ^ key) { break; }//������ ���� , ��Ʈ������ �̿��� ��ȣȭ
						i++;
						printf("%d time\n", i);
						if (i == 3) {//3�� �Ǽ��ϸ� ���� 
							printf("�Է��������� ���� �����մϴ�.\n");
							return 0;
						}
					}
					break;
				}
			}
			system("cls");
			insertMoney(ID);
			printf("�� �̿��Ͻðڽ��ϱ�?\n");//�� �̿����� ���� Ȯ��
			printf("1) ��\n2) �ƴϿ�");
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

		else if (choice == 2)//���
		{

			while (1) {
				printf("ID�� �Է��Ͻÿ�:");//�α��� ��Ʈ
				scanf("%s", ID);
				if ((pass = search(ID)) == 1) {
					printf("�ٽ� �Է��Ͻÿ�.\n");
					continue;
				}
				else {
					while (1) {
						printf("��й�ȣ�� �Է��Ͻÿ�.:");
						scanf("%d", &enpass);
						if (pass == enpass ^ key) { break; }//��ȣȭ,������ ����.
						i++;
						printf("%d time\n", i);
						if (i == 3) {//3�� �Ǽ��ϸ� ���� 
							printf("�Է��������� ���� �����մϴ�.\n");
							return 0;
						}
					}
					break;
				}
			}
			printf("connected\n");
			withdraw(ID);
			printf("�� �̿��Ͻðڽ��ϱ�?\n");//�� �̿����� ���� Ȯ��
			printf("1) ��\n2) �ƴϿ�");
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
		else if (choice == 3)//�ű԰��»���
		{
			while (1) {
				printf("ID�� �Է��Ͻÿ�:");//�α��� ��Ʈ
				scanf("%s", ID);
				if ((pass = search(ID)) == 1) {
					printf("�ٽ� �Է��Ͻÿ�.\n");
					continue;
				}
				else {
					while (1) {
						printf("��й�ȣ�� �Է��Ͻÿ�.:");
						scanf("%d", &enpass);
						if (pass == enpass^key) { break; }//��ȣȭ,������ ����.
						i++;
						printf("%d time\n", i);
						if (i == 3) {//3�� �Ǽ��ϸ� ���� 
							printf("�Է��������� ���� �����մϴ�.\n");
							return 0;
						}
					}
					break;
				}
			}

			member(ID, enpass);
			system("cls");

		}
		else if (choice == 4)//���ú���
		{
			card();
			printf("��� �̿��ϱ� : 1\n�����ϱ� :2\n");
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
			sendMoney();//�۱���Ʈ
		}

		else if (choice == 6)//������Ʈ
		{

			while (1) {
				printf("ID�� �Է��Ͻÿ�:");//�α��κ�
				scanf("%s", ID);
				if ((pass = search(ID)) == 1) {
					printf("�ٽ� �Է��Ͻÿ�.\n");
					continue;
				}
				else {
					while (1) {
						printf("��й�ȣ�� �Է��Ͻÿ�.:");
						scanf("%d", &enpass);
						if (pass == enpass^key) { break; }//��ȣȭ ������ Ż��
						i++;
						printf("%d time\n", i);
						if (i == 3) {//3�� �Ǽ��ϸ� ���� 
							printf("�Է��������� ���� �����մϴ�.\n");
							return 0;
						}
					}
					break;
				}
			}
			printf("connected\n");
			
			sunmoonpayment();
		}
		else if (choice == 9)//����
		{
			return 0;
		}
		else if (choice == 7)//�н��Ѿ���ȸ
		{
			while (1) {
				printf("ID�� �Է��Ͻÿ�:");//�α�����Ʈ
				scanf("%s", ID);
				if ((pass = search(ID)) == 1) {
					printf("�ٽ� �Է��Ͻÿ�.\n");
					continue;
				}
				else {
					while (1) {
						printf("��й�ȣ�� �Է��Ͻÿ�.:");
						scanf("%d", &enpass);
						if (pass == enpass^key) { break; }//��ȣȭ,������ Ż��
						i++;
						printf("%d time\n", i);
						if (i == 3) {//3�� �Ǽ��ϸ� ���� 
							printf("�Է��������� ���� �����մϴ�.\n");
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
			UserRegister();//ȸ������ ��Ʈ
		}
	}
	system("pause");
}

int sunmoonpayment()//������Ʈ
{

	char sid[20]; char sname[20]; int smoney = 0;//��������
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
	FILE*fp = fopen("mo.txt", "a");//���Ͽ���
	FILE*fp2 = fopen("mo.txt", "r");
	FILE*fp1 = fopen("haks.txt", "a");
	FILE*fp3 = fopen("haks.txt", "r");
	while (!feof(fp2))//��,���� ����ִ� ���� ����
	{
		fscanf(fp2, "%s %s %d", sid, sname, &smoney);
	}
	while (!feof(fp3))//�н� �Ѿ� ������������
	{
		fscanf(fp3, "%d", &ssmoney);
	}
	printf("� ������ ��ð� ���ϱ�?\n");
	printf("1:�ڳ�ŷ 2:������ġ 3:�н� 4:�������Ĵ�\n");
	scanf("%d", &menuchoice);
	if (menuchoice == 1)
	{
		while (order != 3)
		{
			printf("�ڳ�ŷ �޴�\n");
			printf("1)���̽�Ƽ[2000��]  2)�Ƹ޸�ī��[2500��]  3)īǪġ��[3000��]\n");
			scanf("%d", &konaking);//15��
			if (konaking == 1)
			{

				printf("�� �����Ͻð� ���ϱ�?\n");
				printf("1:��\n2:�ƴϿ�\n");
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

				printf("�� �����Ͻð� ���ϱ�?\n");
				printf("1:��\n2:�ƴϿ�\n");
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

				printf("�� �����Ͻð� ���ϱ�?\n");
				printf("1:��\n2:�ƴϿ�\n");
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
		printf("�ջ���� %d �Դϴ�.\n", cnt1* (2000 - (2000 * 0.15)) + cnt2 * (2500 - (2500 * 0.15)) + cnt3 * (3000 - (3000 * 0.15)));//���� �ջ��� �������ִ� ������ ���ش�.
		smoney -= (cnt1 * (2000 - (2000 * 0.15))) + (cnt2 * (2500 - (2500 * 0.15))) + (cnt3 * (3000 - (3000 * 0.15)));
		fprintf(fp, "%s %s %d", sid, sname, smoney);
		fclose(fp); fclose(fp1);
	}//�ڳ�ŷ 
	else if (menuchoice == 2)
	{
		while (order != 3)
		{
			printf("������ġ �޴�\n");
			printf("1)���̹��� ��Ʈ[6500��]  2)�ٷ����ż�Ʈ[6700��]  3)��ġ���ٷ����ż�Ʈ[7000��]\n");
			scanf("%d", &momstouch);
			if (momstouch == 1)
			{
				printf("�� �����Ͻð� ���ϱ�?\n");
				printf("1:��\n2:�ƴϿ�\n");
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
				printf("�� �����Ͻð� ���ϱ�?\n");
				printf("1:��\n2:�ƴϿ�\n");
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
				printf("�� �����Ͻð� ���ϱ�?\n");
				printf("1:��\n2:�ƴϿ�\n");
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
		printf("�ջ���� %d �Դϴ�.", cnt1* (6500 - (6500 * 0.10)) + cnt2 * (6700 - (6700 * 0.10)) + cnt3 * (7000 - (7000 * 0.10)));//���� �ջ��� ������ �ִ� ������ ����
		smoney -= (cnt1 * (6500 - (6500 * 0.10))) + (cnt2 * (6700 - (6700 * 0.10))) + (cnt3 * (7000 - (7000 * 0.10)));
		fprintf(fp, "%s %s %d", sid, sname, smoney);
		fclose(fp);
	}
	else if (menuchoice == 3)
	{
		while (order != 3)
		{
			printf("�н� �޴�\n");
			printf("1)���[4500��]  2)���Ƕ��̽�[4000��]  3)�Թڽ�����ũ[4500��]\n");
			scanf("%d", &Sfood);
			if (Sfood == 1)
			{
				printf("����� �����߽��ϴ�.\n");
				Sfood1++;
				printf("�� �����Ͻð� ���ϱ�?\n");
				printf("1:��\n2:�ƴϿ�\n");
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
				printf("���Ƕ��̽��� �����߽��ϴ�.\n");
				Sfood2++;
				printf("�� �����Ͻð� ���ϱ�?\n");
				printf("1:��\n2:�ƴϿ�\n");
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
				printf("�Թ� ������ũ�� �����߽��ϴ�.\n");
				Sfood3++;
				printf("�� �����Ͻð� ���ϱ�?\n");
				printf("1:��\n2:�ƴϿ�\n");
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

		Sfoodtotal = (Sfood1 * (4500 - (4500 * 0.10))) + (Sfood2 * (4000 - (4000 * 0.10))) + (Sfood3 * (4500 - (4500 * 0.10)));//���� �ջ��� �н� �Ѿ׿� �־���.
		printf("�ջ� �������� %d�Դϴ�.\n", Sfoodtotal);
		ssmoney += Sfoodtotal;
		fprintf(fp1, "%d\n", ssmoney);
		system("pause");
		system("cls");
	}
	else if (menuchoice == 4)
	{
		while (order != 3)
		{
			printf("������ �Ĵ� �޴�\n");
			printf("1)¥���[3500��]  2)«��[4000��]  3)������[4000��]\n");
			scanf("%d", &orange);
			if (orange == 1)
			{

				cnt1++;
				printf("�� �����Ͻð� ���ϱ�?\n");
				printf("1:��\n2:�ƴϿ�\n");
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
				printf("�� �����Ͻð� ���ϱ�?\n");
				printf("1:��\n2:�ƴϿ�\n");
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
				printf("�� �����Ͻð� ���ϱ�?\n");
				printf("1:��\n2:�ƴϿ�\n");
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
		printf("�ջ���� %d �Դϴ�.", cnt1* (3500 - (3500 * 0.10)) + cnt1 * (4000 - (4000 * 0.10)) + cnt1 * (4000 - (3000 * 0.10)));
		smoney -= (cnt1 * (3500 - (3500 * 0.10))) + (cnt1 * (4000 - (4000 * 0.10))) + (cnt1 * (3000 - (3000 * 0.10)));//���� �ջ��� �����ݿ��� �A��.
		fprintf(fp, "%s %s %d", sid, sname, smoney);
		fclose(fp);
	}

}
int card() {//���� ��ȸ ��Ʈ
	printf("�������л��� ���� ���������Դϴ�.\n");
	printf("���� 1) �ڳ�ŷ ��� �޴� 15%����\n");
	printf("���� 2) ������ġ ��� �޴� 10%����\n");
	printf("���� 3) �н��� �ٷ� �������� �ʰ�, ���߿� �ϰ� ���� ����\n");
	printf("���� 4) �������Ĵ� ��� �޴� 15%����\n");
}
int search(char* i) {
	//�α��� ��Ʈ
	FILE*fp;//���̵� ��й�ȣ ���� ��� Ȯ��
	char id[10];
	int pass = 0;
	fp = fopen("login.txt", "r");

	while (fscanf(fp, "%s %d", id, &pass) != EOF) {
		if (strcmp(i, id) == 0) {//������ pass����
			return pass;
		}

	}



	fclose(fp);
	printf("���̵� �Ǵ� �н����尡 �߸���.\n");
	return 1;
}
int interface() {//�������̽�
	int choice = 0;
	printf("\t\t\t���ϴ� �ŷ��� �������ּ���.\n");
	printf("-------------------\t\t\t\t\t");

	printf("-------------------\n");
	printf("            1.�Ա�\t\t\t\t\t6.����\n");
	printf("-------------------\t\t\t\t\t");
	printf("-------------------\n");
	printf("-------------------\t\t\t\t\t");

	printf("-------------------\n");
	printf("            2.���\t\t\t\t\t7.�н��Ѿ���ȸ\n");
	printf("-------------------\t\t\t\t\t");
	printf("-------------------\n");
	printf("-------------------\t\t\t\t\t");
	printf("-------------------\n");

	printf("        3.���»���\t\t\t\t\t8.���̵� ����\n");
	printf("-------------------\t\t\t\t\t");
	printf("-------------------\n");
	printf("-------------------\t\t\t\t\t");
	printf("-------------------\n");
	printf("     4.ī��������ȸ\t\t\t\t\t9.����\n");
	printf("-------------------\t\t\t\t\t");
	printf("-------------------\n");

	printf("-------------------\n");
	printf("            5.�۱�\t\t\t\t\n");
	printf("-------------------\t\t\t\t\t");







	scanf("%d", &choice);//���ϴ� �ŷ� ������ �Է�
	return choice;
}
void UserRegister()//���̵� ��й�ȣ ����
{
	char ch, id[20], name[20], firstMoney[20] = { 0 };//���������
	int password = 0;
	int key = 40;
	char s1[20], s2[20], s3[20] = { 0 };	int i, j = 0;//���� �����ֱ� ���� i

	FILE *fpin = fopen("login.txt", "a");//���� ����
	FILE *fps = NULL;
	if (fpin == NULL)
	{
		printf("eror");
	}


	printf("ȸ������\n\n");//�����Է�

	printf("Input Id : ");
	scanf("%s", id);
	printf("Input password : ");
	scanf("%d", &password);
	password^key;//��ȣȭ
	printf("Input name : ");
	scanf("%s", name);
	fprintf(fpin, "%s %d %s", id, password, name);
	fclose(fpin);

	printf("����� ���̵��:%s ��й�ȣ��:%d �̸���:%s �Դϴ�.\n", id, password, name);
}
int member(char *ID, int pass) {//���� ������Ʈ
	int i;//���� ����
	int size = 0;
	int j = 0;
	char sname[20]; int sage = 0; char smajor[20]; char shagbun[20]; int sphonenum = 0; int smoney = 0; char sun[20];
	char name[20] = { 0 };  char  major[20] = { 0 }; char sun1[20] = "sunmoonmember"; int count = 0; char live[20]; char nosun[20] = "nosunmoon";
	char hagbun[20] = { 0 }; int age = 0; int phonenum = 0; int money = 0; char slive[20]; char stong[20]; char tong[20]; char sid[20] = { 0 }; int spass = 0;
	srand((unsigned)time(NULL));//��������
	char random[8] = { 0 }; char random1[10] = { 0 };//�����Լ� ���
	FILE*fp = NULL;//������ ���� �����
	FILE*fps = NULL;
	FILE*fp1 = NULL;
	FILE*fp2 = NULL;
	FILE*fp3 = NULL;

	printf("��------------------------------------------------------------------------------------��\n");
	printf("��                   ��--------------------------------------------��                 ��\n");
	printf("��                   ��     �ڡڡڰ�  �¸� �߱��� �ּ���ڡڡ�     ��                 ��\n");
	printf("��                   ��--------------------------------------------��                 ��\n");
	printf("��                   ��--------------------------------------------��                 ��\n");
	printf("��                   ��			    1.�������л� ���� �߱�         ��                 ��\n");
	printf("��                   ��             2.�Ϲ��� ���� �߱�             ��                 ��\n");
	printf("��                   ��--------------------------------------------��                 ��\n");
	printf("��------------------------------------------------------------------------------------��\n");

	scanf("%d", &i);
	system("cls");
	if (i == 1)//�������� �Է�
	{
		printf("1. �̸��� �Է��ϼ��� :");
		scanf("%s", name);
		printf("\n");
		printf("2. ���̸� �Է��ϼ��� :");
		scanf("%d", &age);
		printf("\n");
		printf("3. �а��� �Է��ϼ��� :");
		scanf("%s", major);
		printf("\n");
		printf("4. �й��� �Է��ϼ��� :");
		scanf("%s", hagbun);
		printf("\n");
		printf("5. ��ȭ��ȣ�� �Է��ϼ��� :");
		scanf("%d", &phonenum);
		printf("\n");
		printf("6. �����ݾ��� �Է��ϼ��� :");
		scanf("%d", &money);
		printf("\n");
		//printf("%s %d %s %s %d %d", name, age, major, hagbun, phonenum, money);
		printf("�Է��� �Ϸ��Ͽ����ϴ�.");
		size++;

		fp = fopen("info.txt", "r");
		while (!feof(fp))//�й����� ���°� �����ϴ��� ���� Ȯ��
		{
			fscanf(fp, "%s %s %d %s %s %d %d %s %s", sid, sname, &sage, smajor, shagbun, &sphonenum, &smoney, stong, sun);
			if (strcmp(hagbun, shagbun) == 0)
			{
				printf("�̹� ���°� �����մϴ�.\n");
				count = 1;
				fclose(fp);

				break;
			}
			else
			{
				count = 2;

			}
		}
		if (count == 2)//���� �������� ���� �� ���Ͽ� ����
		{
			printf("���´� �������� �����˴ϴ�.\n");
			for (i = 0; i < 7; i++)//i�� 0���� 3���� �ݺ�
			{
				random[i] = rand() % ((57 - 48) + 1) + 48;//�ƽ�Ű�ڵ� 0���� 9�� 48���� 57������ ���
														  //���γ��� 0 1 2 3��°�� �� ����
														  //���ڿ��� ���������� �����ι����� 0111�� ��µǾ������ 
														  //0�� ����̾ȵ�.
			}

			printf("%s�� ����� �����Դϴ�.\n", random);

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
		printf("��---------------------------------------------------------------��\n");
		printf("��      �ڼ������л��� �ƴϸ� ������ ���� �� �����ϴ�.��         ��\n");
		printf("��---------------------------------------------------------------��\n");
		printf("1. �̸��� �Է��ϼ��� :");
		scanf("%s", name);
		printf("2. ���̸� �Է��ϼ��� :");
		scanf("%d", &age);
		printf("\n");
		printf("3. ��ȭ��ȣ�� �Է��ϼ��� :");
		scanf("%d", &phonenum);
		printf("\n");
		printf("4. ���� �Է��ϼ��� :");
		scanf("%s", live);
		printf("\n");
		printf("5. �����ݾ��� �Է��ϼ��� :");
		scanf("%d", &money);
		printf("\n");
		//printf("%s %d %d %s %d\n", name, age,phonenum,live, money);
		fp1 = fopen("info2.txt", "r");
		while (!feof(fp1))
		{
			fscanf(fp1, "%s %s %d %d %s %d %s %s", sid, sname, &sage, &sphonenum, slive, &smoney, stong, sun);
			if (sphonenum == phonenum)
			{
				printf("���̹� ���°� �����մϴ�.\n");
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
			printf("���´� �������� �����˴ϴ�.\n");
			for (i = 0; i < 7; i++)//i�� 0���� 3���� �ݺ�
			{
				random[i] = rand() % ((57 - 48) + 1) + 48;//�ƽ�Ű�ڵ� 0���� 9�� 48���� 57������ ���
														  //���γ��� 0 1 2 3��°�� �� ����
														  //���ڿ��� ���������� �����ι����� 0111�� ��µǾ������ 
														  //0�� ����̾ȵ�.
			}

			printf("%s�� ����� �����Դϴ�.\n", random);
			strcpy(tong, random);
			fp2 = fopen("info2.txt", "a");
			fprintf(fp2, "%s %s %d %d %s %d %s %s\n", ID, name, age, phonenum, live, money, tong, nosun);
			fclose(fp2);
		}


	}
}
void withdraw(char *ID) {//�����Ʈ
	char sname[20]; int sage = 0; char smajor[20]; char shagbun[20]; int sphonenum = 0; int smoney = 0; char sun[20]; char a[20], b[20]; int c = 0;//���������
	char slive[20]; char stong[20]; char tong[20]; char sid[20] = { 0 }; int lmoney = 0; int ssmoney=0; char ssid[20]; char ssname[20];
	int num = 0; int money = 0;
	FILE *fp = fopen("info.txt", "r");//���� ����
	FILE*fp2 = fopen("info2.txt", "r");
	FILE*fp3 = fopen("mo.txt", "a");
	FILE*fp4 = fopen("mo.txt", "r");
	while (!feof(fp4))//����,�� �о��
	{
		fscanf(fp4, "%s %s %d", ssid, ssname, &ssmoney);

	}
	printf("���̵�: %s �̸�: %s ���� �ݾ�: %d\n", ssid, ssname, ssmoney);//Ȯ��
	
	
		if (strcmp(ID, ssid) == 0)//id�� �α��� id �� �� ������ ���
		{

			
				printf("          ��---------------------------------------------------------------��\n");
				printf("          ��                    �󸶸� ��� �Ͻðڽ��ϱ�?                  ��\n");
				printf("          ��---------------------------------------------------------------��\n");
				printf("                             ����Ͻ� �ݾ��� �Է��Ͽ��ּ��� : ");

				scanf("%d", &num);

				lmoney = ssmoney - num;
				printf("          ��---------------------------------------------------------------��\n");
				printf("          ��                        ��ݵǾ����ϴ�!!!:                     ��\n");
				printf("          ��---------------------------------------------------------------��\n");

				printf("%s %s �ܾ�:%d\n", ssid, ssname, lmoney);
				fprintf(fp3, "%s %s �ܾ�:%d\n", ssid, ssname, lmoney);
				fclose(fp3);
				
			
			
		}


	


}
void insertMoney(char *ID) {//�Ա���Ʈ
	char sname[20]; int sage = 0; char smajor[20]; char shagbun[20]; int sphonenum = 0; int smoney = 0; char sun[20]; char a[20], b[20]; int c = 0;//���������
	char slive[20]; char stong[20]; char tong[20]; char sid[20] = { 0 }; int lmoney = 0; int ssmoney = 0; char ssid[20]; char ssname[20];
	int num = 0; int money = 0;
	FILE *fp = fopen("info.txt", "r");//���� �а� ���� ����
	FILE*fp2 = fopen("info2.txt", "r");
	FILE*fp3 = fopen("mo.txt", "a");
	FILE*fp4 = fopen("mo.txt", "r");
	printf("�α��� �Ǿ����ϴ�.\n");
	while (!feof(fp4))//����,�� ���� �ҷ���
	{
		fscanf(fp4, "%s %s %d", ssid, ssname, &ssmoney);
	}

	while (!feof(fp))//�ش� ���¿� �� �Ա�.
	{
		fscanf(fp, "%s %s %d %s %s %d %d %s %s", sid, sname, &sage, smajor, shagbun, &sphonenum, &smoney, stong, sun);

		printf("          ��---------------------------------------------------------------��\n");
		printf("          ��                    �󸶸� �Ա� �Ͻðڽ��ϱ�?                  ��\n");
		printf("          ��---------------------------------------------------------------��\n");
		printf("                             �Ա��Ͻ� �ݾ��� �Է��Ͽ��ּ��� : ");
		int num = 0;
		scanf("%d", &num);
		system("cls");
		ssmoney += num;
		printf("          ��---------------------------------------------------------------��\n");
		printf("          ��                        �ԱݵǾ����ϴ�!!!:                     ��\n");
		printf("          ��---------------------------------------------------------------��\n");
		fprintf(fp3, "%s %s %d\n", sid, sname, ssmoney);
		fclose(fp); fclose(fp2); fclose(fp3); fclose(fp4);
		break;
	}

}
void sendMoney() {//�۱���Ʈ
	char num[40] = { 0 };//���� ����¿� �ʿ��� ���� �����
	char sname[20]; int sage = 0; char smajor[20]; char shagbun[20]; int sphonenum = 0; int smoney = 0; char sun[20]; char sid[20]; char stong[20];
	char ssname[20]; char ssid[20]; int ssmoney = 0;
	FILE *fp = fopen("info.txt", "a+");//���� ���� ���� ����
	FILE*fp2 = fopen("mo.txt", "a");
	FILE*fp3 = fopen("mo.txt", "r");
	int num2 = 0;
	while (!feof(fp3))//����,�� ���� �б�
	{
		fscanf(fp3, "%s %s %d", ssid, ssname, &ssmoney);
	}

	while (!feof(fp))//�л� �й����� ��ȸ �� �ش��л����� �۱�.
	{
		fscanf(fp, "%s %s %d %s %s %d %d %s %s", sid, sname, &sage, smajor, shagbun, &sphonenum, &smoney, stong, sun);
		printf("          ��---------------------------------------------------------------��\n");
		printf("          ��                �۱��Ͻ� �л���ȣ�� �Է����ּ���               ��\n");
		printf("          ��---------------------------------------------------------------��\n");
		printf("                       �۱ݹ��� �л���ȣ�� �Է��ϼ��� :");
		scanf("%s", num);
		system("cls");
		if (strcmp(num, shagbun) == 0)//�й��� ������
		{
			printf("          ��---------------------------------------------------------------��\n");
			printf("          ��                    �󸶸� �۱� �Ͻðڽ��ϱ�?                  ��\n");
			printf("          ��---------------------------------------------------------------��\n");
			printf("                             �۱��Ͻ� �ݾ��� �Է��Ͽ��ּ��� : ");
			scanf("%d", &num2);
			ssmoney += num2;
			fprintf(fp2, "%s %s %d", ssid, ssname, ssmoney);
			printf("�ܾ�:%d\n", ssmoney);
			break;

		}
		else {//������
			printf("          ��---------------------------------------------------------------��\n");
			printf("          ��                     ���� �й��Դϴ�.                          ��\n");
			printf("          ��---------------------------------------------------------------��\n");
		}
	}
}
void haksik(float total, char*ID) {//�н� ��ȸ ��Ʈ
	
	FILE*fp = fopen("haks.txt", "r");//���� �а� �̾�� ��� 
	FILE*fp2 = fopen("haks.txt","a");
	FILE*fp1 = fopen("mo.txt", "r");
	char sid[20]; char sname[20]; int smoney = 0; int choice = 0; int tal = 0;//���� ���¿� �ʿ��� ���� ����
	while (!feof(fp1))//������ �� ���� �ҷ�����
	{
		fscanf(fp1, "%s %s %d", sid, sname, &smoney);
	}
	while (!feof(fp))//���� ���� �ݾ� �ҷ�����
	{
		fscanf(fp, "%d", &tal);

	}
	printf("          ��---------------------------------------------------------------��\n");
	printf("                                  ���� �� �ݾ� : %d                          \n", tal); //�ܾ� ���
	printf("          ��---------------------------------------------------------------��\n");
	printf("�����Ͻðڽ��ϱ�?\n1)��,2)�ƴϿ�\n");//�ܾ� ������ ������ ���� Ȯ��
	scanf("%d", &choice);
	if (choice == 1)
	{
		smoney -= tal;//�� ���� ����
		fprintf(fp1, "%s %s %d", sid, sname, smoney);//�ٽ� ���Ͽ� ����
		tal = 0;//�� �ݾ� 0������ �ʱ�ȭ
		fprintf(fp2, "%d\n", tal);//���Ͽ� ����
		printf("�ܾ��� : %d �Դϴ�.\n", smoney);//�ܰ� ǥ��
	}
	else//�������̽��� ���ư�
	{
		system("pause");
		system("cls");
		return;
	}
	
}