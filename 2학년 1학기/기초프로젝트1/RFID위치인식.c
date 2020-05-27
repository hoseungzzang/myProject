//������ : ��ȣ��
//���� ���� :â������� ���� �����ϰ� �ϱ� ���� ���α׷��� ����.
//���� ������ : 2018.05.04
//���� ������: 2018.05.22

#include<stdio.h>
#include<stdlib.h>
#include<stdint.h>
#include<string.h>
#pragma warning(disable:4996)

typedef struct taginfo1 {//���Ḯ��Ʈ ����ü
	char id[27];//�ּ�
	float rssi;//RSSI��
	double identifiedTime;//���͹���
	struct taginfo1 *next;//���Ḯ��Ʈ�� �������
} TAGINFO1;
typedef struct taginfo2 {//���Ḯ��Ʈ�� ���� ���۷������� ��� RSSI���� ��� ���͹� ���� ���Ḯ��Ʈ�� ����.
	
	double total;
	int fo[2];
	struct taginfo2 *next;
} result;

TAGINFO1*head; result*head1;//�� ���Ḯ��Ʈ�� head ����
char addnode(char *in1, char* rssi, char *total);//���Ḯ��Ʈ ����
double search(char(*ID)[27]);//A���� ���Ḯ��Ʈ�� �־��� �� ã��
double search2(char*ID[27]);//B���� ���Ḯ��Ʈ�� �־��� �� ã��
double search3(double inza, int x, int y);//C���� ���Ḯ��Ʈ�� �־��� �� ã��
void print();
void print1();//Ÿ���� ��ǥ ���
int main()
{
	char targetID[27] = "0x35E0170044CF0D590000F5A5";//Ÿ�� �ּ�
	char referenceIDs[60][27] = {//���۷������� �ּ�
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
	int referecePoints[60][2] = {//���۷������� ��ǥ
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
	char fstring[2650];//������ ������ �о�������� ����
	head = NULL;//��� �ʱ�ȭ
	char choice;//�Է¹�������
	int i = 0;////�ε����ʱ�ȭ
	char in1[120];
	int j = 0;
	float num = 0;//������ ��ȯ�� ���ڿ� �־���.
	float num1 = 0; double num2 = 0; double num3 = 0; double num4 = 0; double num5 = 0;//���� ��ȯ�� ���ڿ� �޴� ����
	char in2[120], in3[120], in4[120], in5[120], in6[120], in7[120];//������ ���ڿ��� , ���ڿ��� ������ ��Ȱ�Ҷ� ���
	char *tok;//�ڸ� ���ڿ� �޴� ����
	int cnt = 0;//���°�� �ڸ��� ���� ����
	double inza[70][50];//���Ǿ� ���� ���rssi�� �ޱ����� ����
	double inza2 = 0;//Ÿ���� RSSI��հ� �ޱ����� ����
	double inza3;//Ÿ�ٰ� ��� rssi������ �޴� ����
	int x = 0;//x��ǥ���޴º���
	int y = 0;//y��ǥ�� �޴� ����
	
	double inza6;//-�� RSSI���� +�� �ٲ��ֱ�  ���� ����
	printf("=============================================================\n");
	printf("RFID Tag Information Analysis based Localization System\n");
	printf("=============================================================\n");
	printf("A.Reference Tag Analysis\n");         // ���� �� �����±׵��� ���� �м� �� ���
	printf("B.Target Tag Analysis\n");            // ���� �� Ÿ�� �±��� ���� �м� �� ���
	printf("C.Estimation of Target Position\n");   // ���� �� Ÿ���� ��ġ ���� �� ���
	printf("D.Quit\n"); // ���� �� ����

	
	
		FILE* fp = fopen("RFID_Data.txt", "r"); //���óѹ� ���� �ҷ���.

		while (!feof(fp))//�����ǳ����� �ݺ�
		{
			cnt = 0;//����������� Ȯ��
			fgets(fstring, 120, fp);//���Ͽ��� �� ���ܾ� �о�� 
			
			tok = strtok(fstring, ".=,-:T");//.+,-:T���� ���´�.
			while (cnt != 19)//�������� ���ڿ��� �� 18�� ���� 19���Ǹ� ����
			{
				tok = strtok(NULL, ".=,-:T");//.+,-:T���� ���´�.
				cnt++;//ī��Ʈ ����
				if (cnt == 3)//ī��Ʈ��3�̸�
				{
					
					strcpy(in1, tok);//in1�� tok�� ī���Ѵ�.
				}

				if (cnt == 9)//ī��Ʈ�� 9�̸�
				{
					
					strcpy(in2, tok);//in2�� tok�� ī���Ѵ�.
					num = atoi(tok);//�ѿ��� ���ڿ��� tok�� �������� �ѿ� �־���.

				}
				if (cnt == 14)//ī��Ʈ�� 14�̸�
				{
					
					strcpy(in3, tok);//in3�� tok ī��
					num1 = atoi(tok) * 60 * 60 * 1000;//��1�� ������ �ٲ� ���ڿ��� �и������� ��ȯ���Ļ��
				}
				if (cnt == 15)//ī��Ʈ�� 15�̸�
				{
					
					strcpy(in4, tok);//in4�� tokī��
					num2 = atoi(tok) * 60 * 1000;//��2�� ������ �ٲ� ���ڿ��� �и������� ��ȯ���Ļ��
				}
				if (cnt == 16)//ī��Ʈ�� 16�̸�
				{
				
					strcpy(in5, tok);//in5�� tokī��
					num3 = atoi(tok) * 1000;//��3�� ������ �ٲ� ���ڿ��� �и������� ��ȯ���� ���
				}
				if (cnt == 17)//ī��Ʈ�� 17�̸�
				{
					
					num4 = atoi(tok);//��4�� �и������� ����
				}
				if (cnt == 18)//ī��Ʈ�� 18�̸�
				{
					num5 = num1 + num2 + num3 + num4;//�� 5�� ��ȯ�� �и������� �� �־���.
					
					itoa(num5, in7, 10);//��5�� �ٽ� ���ڷ� �ٲ�
					
					addnode(in1, &in2, &in7);//��忡 �߰�

				}
			}

		}
		scanf("%c", &choice);//� ���α׷� �������� ��

		if (choice == 'A')//A�̸�
		{
			for (j = 0; j < 60; j++)//j�� 60�϶�����
			{
				inza[j][10]=search(referenceIDs[j]);//���۷��� ���̵� �ش��ϴ� ���� ���Ḯ��Ʈ�� ���� ã�� RSSI���� ��� ���͹� ���
				
			}
		}
		else if (choice == 'B')//B�϶�
		{
			inza2=search2(targetID);//Ÿ���� ��� RSSI���� ���͹��� ����
			
		}
		else if (choice == 'C')//C�϶�
		{
			for (j = 0; j < 60; j++)//60���ݺ�
			{
				inza[j][50] = search(referenceIDs[j]);//���Ḯ��Ʈ�� ����� ���۷������� ��� rssi,���͹��� ������
			}
			
			for (i = 0; i < 60; i++)
			{
				inza2 = 158.779999;//inza2�� 158.779999�� ����
				inza3=inza2-inza[i][50];//inza3�� Ÿ���� rssi�� ���۷������� ��� rssi�� ��
				if (inza3<0)//���� ������
				{
					inza6=-1 * inza3;//-1�� ������ ����� ����
				}
				else//�ƴϸ�
				{
					inza6 = inza3;//�װ� �״�� ����
				}
				printf("%lf\n", inza6);//���
			
				
				x = referecePoints[i][0];//���۷��� ������� ��ǥ�� ����.x
				y = referecePoints[i][1];//y
				search3(inza6, x,y);//������������ ������
				
				
			}
			print1();//���

		

		}
		else if (choice == 'D')//D�̸�
		{
			return 0;//���α׷� ����
		}
			getch();//cmdâ�� ������ �ʰ� ��.
			return 0;

		fclose(fp);//���� ����.
}
char addnode(char *in1, char* rssi, char *total)//�߷��� ���ڿ� ���Ḯ��Ʈ�� �߰�
{
	float rssi1 = 0;//rssi����
	double total1 = 0;//���͹�������
	total1 = atoi(total);//�޾ƿ� ���͹��� ������ �ٲ�
	rssi1 = atoi(rssi);//�޾ƿ� rssi�� ������ �ٲ�
	TAGINFO1*newnode;//����� ����
	newnode = (TAGINFO1*)malloc(sizeof(TAGINFO1));//�����Ҵ�
	newnode->next = NULL;//�������� ���̴�
	strcpy(newnode->id, in1);//����� id�� ���۷��� �ּ� ī��
	newnode->rssi = rssi1;//rssi�� rssi������
	newnode->identifiedTime = total1;//���͹��� ����

	if (head == NULL)//��尡 ���̸�
	{
		head = newnode;//���� ��带 ����ġ����.
	}
	else//���̾ƴϸ�
	{
		newnode->next = head->next;//����� ���� ��带 ����Ǵ���������Ű���ϰ�
		head->next = newnode;//���� ����带 ����Ű����.
	}
}
double search(char(*ID)[27])//�ּҰ� ���� �͵��� ��� rssi���� ���͹��� ���
{
	int i = 0;//�ε�����
	double num = 0; double num1 = 0;//���͹��� ���ϱ� ���� ����
	float num2 = 0; float num3 = 0;//rssi�� ���ϱ� ���� ����
	int cnt = 0;//ī��Ʈ
	TAGINFO1*temp = head;//temp����
	while (temp != NULL)//������ ���̾ƴϸ�
	{
		if (strcmp(temp->id, ID) == 0)//���۷��� id�� ���Ḯ��Ʈ�� �ִ� id�� ������
		{

			num2 = temp->rssi;//��2�� rssi���� �ְ�
			num1 = temp->identifiedTime;//��1�� ���͹����ִ´�
			num3 += num2;//num3�� �޾ƿ��� rssi�������δ��Ѵ�
			num += num1;//num�� �޾ƿ��� ���͹��� ���� ���Ѵ�.
			cnt++;//ī��Ʈ ����
			temp = temp->next;//�������� �̵�
		}

		else {
			temp = temp->next;//�ش������ ���������̵�
		}
	}
	num3 = num3 / cnt;//��������ϱ����� ����ŭ������.
	num = num / cnt;//����� ���ϱ� ���� �� ��ŭ ������.
	printf("%s�� RSSI���� %f �̰� ���͹� ����� %lf�̴�.\n",ID, num3, num);//���
	return num3;//rssi�� ��ȯ



}

double search2(char*ID)//Ÿ���� ��� ���ϱ�
{
	int i = 0;//�ε����� ����
	double num = 0; double num1 = 0;//���͹��� ��ճ������Ѻ���
	float num2 = 0; float num3 = 0;//RSSI�� ��ճ������Ѻ���
	int cnt = 0;//ī��Ʈ
	TAGINFO1*temp = head;//������ ��带 �ٶ󺸰���
	while (temp != NULL)//������ �ξƴϸ鵷��
	{
		if (strcmp(temp->id, ID) == 0)//���̵� �����ϸ�
		{

			num2 = temp->rssi;//��2�� rssi���ְ�
			num1 = temp->identifiedTime;//��1�� ���͹����ְ�
			num3 += num2;//�ٴ����ش�
			num += num1;//�ٴ����ش�
			cnt++;//ī��Ʈ����
			temp = temp->next;//���������̵�
		}

		else {
			temp = temp->next;//���������̵�
		}
	}
	num3 = num3 / cnt;//��ճ���
	num = num / cnt;//��ճ���
	printf("%s�� RSSI���� %f �̰� ���͹� ����� %lf�̴�.\n", ID, num3, num);//���
	return num3;//RSSI�� ��ȯ



}

double search3(double inza, int x, int y)//�������� ���� �� ���Ḯ��Ʈ �߰�
{//��ó http://egloos.zum.com/aneedyou/v/846196 �������� �ڵ� �� ���� ������.

	result*cur;//cur ����
	cur = head1;//cur�� ���1��������.
	result*newnode;//��������
	newnode = (result*)malloc(sizeof(result));//�����Ҵ�
	newnode->total = inza;//���� rssi�� �־���
	newnode->fo[0] = x;//x��ǥ�־���
	newnode->fo[1] = y;//y��ǥ�־���
	
	

	if (head1 == NULL)//�ص尡 ���̸�
	{
		head1 = newnode;//���1�� ����� ������
		newnode->next = NULL;//������� �������� ���̴�
		return;

	}
	if (newnode->total <head1->total)//���ο�� ��忡�ִ°�����������
	{
		newnode->next = head1;//�Ǿ��߰�
		head1 = newnode;
		return;
	}
		
		while (1)//���ѷ���
		{
			if (cur->next == NULL)//cur�� ������尡 ���̸� 
			{
				cur->next = newnode;//�ǵڻ���
				newnode->next = NULL;
				return;
			}
			else if (cur->next->total > newnode->total)//cur�� ��������� ���� ������� ������ Ŭ���
			{
				newnode->next = cur->next;//�߰�����
				cur->next = newnode;
				return;
			}
			else
			{
				cur = cur->next;//���������̵�
			}
	
		
	}

}
void print1() {//��ºκ�

	result *cur;//cur ����
	double result[10000];//1/����*������ ���꺯��
	double result1 = 0.0;//1/����*�������� �� �޾��ֱ����Ѻ���
	int fom[10][2];//��ǥ �޾��ֱ� ���� ����
	cur = head1;//cur�� ��带����Ų��.
	double x;//��ǥx�ޱ����Ѻ���
	double x2=0;//�����x�ޱ����Ѻ���
	double y;//y����
	double y2=0;//����Ⱥ���y�ޱ�
	int choice;//�����������
	int cnt = 0;//
	int i = 0;
	int j = 0;
	int cnt2 = 0;
	double a = 0;
	printf("���������� �����Ͻÿ�.\n");
	scanf("%d", &choice);//����
		while (cur->next != NULL)//cur�� ���̾ƴϸ�
		{
			if (cnt == choice)//���õȸ�ŭ��������
			{
				break;
			}
			
			a = cur->total;//a�� ����������
			fom[i][0] = cur->fo[0];//��ǥx����
			fom[i][1] = cur->fo[1];//��ǥy����
			
			result[i] = 1/(a*a);//1�� �������� �������� ����Ʈ�� ����
			cnt++;//ī��Ʈ ����
			i++;//�ε�������
			result1 += result[i];//����Ʈ1�� ���� ����.
			cur = cur->next;//���������̵�
		}
		while (cnt2 != choice)//cnt�� ���̽��� �ƴϸ�
		{
			
			x=(double)fom[j][0]*(result[j] / result1);//�� �ش� ���۷����� �ش��ϴ� ��ǥ�� rssi��
													//�����Ͽ� ����ġ���
			y=(double)fom[j][1] * (result[j] / result1);//����ġ���
			x2 += x;//���� ���� x2�� ���� ����.
			y2 += y;//���� ���� y2�� ���� ����
			cnt2++;//cnt����
			j++;//j����
		}
		printf("x �� %lf y�� %lf�̴�\n", x2, y2);//��ǥ�� ���
		
	

}
	





