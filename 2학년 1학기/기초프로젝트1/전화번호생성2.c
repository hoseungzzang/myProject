//������ : ��ȣ��
//���� ���� : ����ִ� ���ÿ� ���� �Է¹޾� �׿� �´� ��ȣ�� �ް� ���ι�ȣ�� �������� �����Ǵ� ���α׷�. 
//���� ������ : 2018.03.14
//���� ������: 2018.03.28

#pragma warning(disable:4996)
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<time.h>
typedef struct num //num�̶�� ����ü��num�̶�� �̸����� ����
{
	char insernum[5];
	char sublocalnum[5];//�Լ����� �����Į���� ������ ���ο��� �����Į���ǰ��� ������ ���
	char gainnumber[20];//����� ���� �Ѿ�� ���� ���γѿ� ������ ���


}num;
typedef struct node//���Ḯ��Ʈ ����ü����
{
	char dosinum[10];//���ù�ȣ
	char gunum[10];//����ȣ
	char gainnum[10];//���ι�ȣ ����
	struct node *next;//����� �ؽ�Ʈ node�� �����ͺ�������
	
}no;
//�Լ� ���� 
char dosi(char *dosi2);//���ù�ȣ ���ϱ�
void sublo(char *ingu, num *lnum);//������ù�ȣ���ϱ�
char gain(char gainnum[10]);//���ι�ȣ���ϱ�
void innode(no *list, num *NUM, char *dosi2);//���Ḯ��Ʈ ����
int find(no*list, num*NUM, char *dosi2, int i);//�ߺ�ã���Լ�

int main() {
	num *NUM = (num*)malloc(sizeof(num) * 20);//�����Ҵ�
	no *noo = (no*)malloc(sizeof(no));
	no *list, *newnode, *temp = NULL;;//���Ḯ��Ʈ �ʱ�ȭ
	list = (no*)malloc(sizeof(no));//����Ʈ �����Ҵ�.
	newnode = (no*)malloc(sizeof(no));//����� �����Ҵ�
	char dosi2[20];//���ø��Է� ����
	char ingu[20];//���Էº���
	char gainnum[5] = { NULL };//���ι�ȣ �޴� ����
	int end = 0;//���� Ȥ�� ���ϴ°��ι�ȣ ���� �Ǵ� ���������� ��ȣ ����
	int i = 0;
	FILE *fp= fopen("ExistingPhoneNumber.txt", "a+");//�̾�Ⱑ����.
	
	list->next = NULL;//����Ʈ�ؽ�Ʈ�ʱ�ȭ
	

	
	while (!feof(fp))//�����ߴ� ��ȭ��ȣ�� �ٽ� �������������˷��ִ°�
	{
		fscanf(fp, "%s %s %s", dosi2, NUM->sublocalnum, NUM->gainnumber);//���ϰ�����.
		printf("%s-%s-%s�� ������ �� ����.\n", dosi2, NUM->sublocalnum, NUM->gainnumber);//�����Ҽ����°���������.
		innode(list,NUM,dosi2);//�ִ� ��ȣ�� �޾Ƽ� ���Ḯ��Ʈ�� �߰�
	}



	while (1)//���ѷ��� ����.
	{
		
		printf("��ȣ�� �����Ͻðڽ��ϱ�?\n 1�� : ������ȣ����\n 2�� : ���ϴ� ���ι�ȣ ����\n 3��: ������\n");
		scanf("%d", &end);//��� �����ΰ� �����ΰ��� ����.
		if (end == 1 || end==2)//����
		{
			printf("�����Ͻ� ������ �̸��� �Է��Ͻÿ� :\n");
			scanf("%s", dosi2);//�Է��� ���� �̸� �Է�

			dosi(dosi2);//dosi�Լ��� �Է��� ���� �̸� �Ѱ���
			printf("�����Ͻ� ���� �̸��� �Է��Ͻÿ� :\n");
			scanf("%s", ingu);//���� �̸� �Է�
			sublo(ingu, NUM);//���� ���óѹ� ���ϴ� �Լ��� �� �̸��� ����ü�ϳ� �Ѱ���.
			printf("�����Ͻ� ���� ��ȣ�� %s �Դϴ�.\n", NUM->sublocalnum);//�޾ƿ� ������óѹ��� ��ȣ ���
			do
			{
				if (end == 1)//������ȣ����
				{
					printf("���� ��ȣ 4�ڸ��� �����Դϴ�.\n");
					gain(&gainnum);//���ι�ȣ�� gainnum�� �ּҿ� �޾ƿ�.
					find(list, NUM, dosi2, i);//�ߺ�����Ȯ��.
						if (i != 1)//��ȯ���� 1�̾ƴ϶��
						{
							

							printf("���ι�ȣ�� %s �Դϴ�.\n", gainnum);//���ι�ȣ ���

							strcpy(NUM->gainnumber, gainnum);//���ι�ȣ�� ����ü�� ���γѿ��� ����
							printf("%s-%s-%s �� ����� ��ȣ�Դϴ�.\n", dosi2, NUM->sublocalnum, NUM->gainnumber);//��ȣ �����Ϸ�
						}

				}
				else if (end == 2)//���ϴ¹�ȣ����
				{
					printf("����ϰ���� ��ȣ 4�ڸ��� �Է��Ͻÿ�\n");
					scanf("%s", NUM->gainnumber);//�Է¹���.
					printf("������ ��ȣ�� %s �Դϴ�.\n", NUM->gainnumber);

					i = find(list, NUM, dosi2, i);//�ߺ����� ã�´�.
					if (i != 1)//i��1�̾ƴ϶�� ���
					{
						printf("%s-%s-%s �� ����� ��ȣ�Դϴ�.\n", dosi2, NUM->sublocalnum, NUM->gainnumber);//��ȣ �����Ϸ�
					}


				}

			} while (i == 1);//�ѹ� ������ i�� 1�̸� ��� ����.

				innode(list, NUM, dosi2);//���Ϲ����� ���� ������� ���Ḯ��Ʈ�� �߰�.
			
			fprintf(fp, "%s %s %s\n", dosi2, NUM->sublocalnum, NUM->gainnumber);//���� ���� ���Ͽ� ��ִ´�.
	
		}  
		else {//end�� 1�̳� 2�� �ƴϸ� ����

			return 0;
		}
		
			
	}


	getch();
	return 0;
}
char dosi(char*dosi2) //����ȣ ���. �������
{
	FILE* fp = fopen("LocalNumberList.txt", "r"); //���óѹ� ���� �ҷ���.
	char local[20];//���� ���� ����.
	char numb[20];//���� �ѹ� ����.

	while (!feof(fp))//�����ǳ����� �ݺ�
	{
		fscanf(fp, "%s%s", numb, local);//�о��.

		if (strcmp(dosi2, local) == 0)//���ڿ��� �Է°��� ���Ͽ������� ���� ������
		{

			strcpy(dosi2, numb);// �ѹ��� dosi2�� ����

			printf("�����Ͻ� ������ ��ȣ�� %s �Դϴ�.\n", dosi2);//Ȯ���� ���� ���
			return dosi2;//dosi2���� �ǵ�����

		}
	}

	fclose(fp);//���� ����.
}

void sublo(char *ingu, num *lnum) // ����ȣ�� �����. ���۷��� ���
{
	FILE* fp = fopen("SubLocalNumberList.txt", "r"); //������óѹ�����Ʈ�� ����.
	char dosi[20];//������ ���ø� �б����� ����
	char gu[20];// �� �̸��� �б����� ����
	char gunum2[4][20];//���� ��ȣ�� �����ϱ����� ����
	char gunum[20];//��ȣ���б����Ѻ���
	int i = 0;//gunum2�� �������� ���� ����
	int count = 0;//�����Լ��� ����ϱ����� ī��Ʈ
	srand(time(NULL));//���������Լ� ����
	while (!feof(fp))//������ ������ �ݺ�
	{
		fscanf(fp, "%s %s %s", dosi, gu, gunum);//����,��,����ȣ�� �о��.
		if (strncmp(ingu, gu, sizeof(gu)) == 0)//�Է¹��� �� �̸��� ���Ͽ��� ���� ���� �� �� ������
		{
			strcpy(gunum2[i], gunum);//���ѹ��� 2�߹迭�� gunum2�� ����.

			i++; //gunum2�� [0][1][2]�� �濡 �־��ֱ����� ����
			count++;//if���� ��� �ߴ��� ī��Ʈ.

		}
	}
	fclose(fp);//���� �ݾ���.
	strcpy(lnum->sublocalnum, gunum2[rand() % count]);//gunum2�� 2�߹迭�� ���� �����Լ��� �����ϰ� sublocalnum�� ������. �濡 ���� ������ count�� ������ ��߿� ������ �������� ����.
}

char gain(char gainnum[10])//���ι�ȣ�� �����. �������
{

	int i = 0;//���� �����ֱ� ���� i

	srand((unsigned)time(NULL));//��������


	for (; i < 4; i++)//i�� 0���� 3���� �ݺ�
	{
		gainnum[i] = rand() % ((57 - 48) + 1) + 48;//�ƽ�Ű�ڵ� 0���� 9�� 48���� 57������ ���
												   //���γ��� 0 1 2 3��°�� �� ����
												   //���ڿ��� ���������� �����ι����� 0111�� ��µǾ������ 
												   //0�� ����̾ȵ�.
	}
	return gainnum;//���ڸ� ������ ���γ� ��ȯ.
}

void innode(no *list, num *NUM, char *dosi2)//���Ḯ��Ʈ����
{
	
	no *newnode = (no *)malloc(sizeof(no));//�����Ҵ�
	no *temp = (no *)malloc(sizeof(no));//�����Ҵ�
	newnode->next = NULL;//�ʱ�ȭ
	strcpy(newnode->dosinum, dosi2);//������� ���ð��� ����2�� �ּҰ��� ����  
	strcpy(newnode->gunum, NUM->sublocalnum);// �ּҰ��� ����
	strcpy(newnode->gainnum, NUM->gainnumber);//�ּҰ��� ����


		newnode->next = list->next;//������� next�� ����Ʈ�� ������带 ����Ű����.
		list->next = newnode;//����Ʈ�� next�� newnode������Ű���� 
		                      //���Ḯ��Ʈ ����.
}

int find(no*list, num*NUM, char *dosi2, int i)//�ߺ��� ã���Լ�
{
	
	no*temp = (no*)malloc(sizeof(no));//�����Ҵ�.
	temp->next = list->next;//������ next�� ����Ʈ�� ������带����Ű����.

	while (temp != NULL)//������ ���϶����� ������.
	{
		if (strcmp(dosi2, temp->dosinum) == 0 && strcmp(NUM->sublocalnum, temp->gunum) == 0 && strcmp(NUM->gainnumber, temp->gainnum) == 0)
		{//3���� �ѹ��� ��� �����ϸ�.
			printf("�ߺ��Դϴ�.\n");//�ߺ���.
			i = 1;//1������ȯ�Ұ���.
			return i;//i��ȯ.
		}
		temp = temp->next;//������ ������ ���� ��带 ����Ų��.
		if (temp == NULL)//������ ���̸�.
		{
			printf("�����մϴ� ��ȣ�� �����Ǿ����ϴ�.\n");//��ȣ����
			i = 2;//2������ȯ.
			return i;//i��ȯ.
		}
	}

	
}






