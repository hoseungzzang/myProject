//���� ���� : �䱸������ �м��� ���ھ߱� ���α׷� �����

//������ :��ǻ�� ���а� ��ȣ�� 2015244071

//���� ������ : 2018.05.01

//���� ������ : 2018.05.03

#pragma warning(disable:4996)
#include<stdio.h>
#include<time.h>//�����Լ����������Ÿ���������
#include<stdlib.h>
#include<string.h>//���ڿ��Լ�������������
char random(char randomsu[5]);//������ ����
char nope(char *innumber);//����ڰ� ���� �Է���.
int cpn(char *randomsu, char*innumber);//�������� ����ڰ� �Է��� ���� ��
int main()
{

	char randomsu[10] = { 0 };//������ �ʱ�ȭ
	char innum[20] = { 0 };//����ڰ� ���� �� �ʱ�ȭ
	int cnt = 0;//ī��Ʈ �ʱ�ȭ
	random(randomsu);//�������� �޾ƿ��� ���� �����Լ� ȣ��
	printf("\n�������� �����Ǿ����ϴ�.\n");//������ �����Ȱ� �˸�
	while (cnt != 5)//cnt�� 5�� �ƴҶ� ��� ����.
	{
		nope(&innum);//����ڰ� �Է��� ���� �ߺ��Ǵ� ���� ������,5�ڸ����� �Է��ߴ��� Ȯ�� �� �Էµȼ� �޾ƿ�.
		cnt = cpn(randomsu, innum);//�������� ����� �Է� ���� �� �� ������� cnt�� �޾���.��Ʈ����ũ��
								   /*5�̸� cnt�� 5�� �Ǽ� ���Ϲ� ����*/
	}
	getch();
}
char random(char randomsu[5])//������ ����
{
	int i = 0;//i�ʱ�ȭ
	int cnt = 0;//cnt�ʱ�ȭ
	srand((unsigned)time(NULL));//��������

	while (cnt != 5)//cnt�� 5�� �ƴҶ� ��� ����.
	{

		randomsu[i] = rand() % ((57 - 49) + 1) + 49;//�ƽ�Ű�ڵ� 1~9�� �迭�� ����.

		if (i == 0)//�迭�� �ƹ��͵������� �ٷ� �߰�.
		{

			i++;//i����
			cnt++;//ī��Ʈ ����
		}
		else if (randomsu[i] != randomsu[i - 1] && randomsu[i] != randomsu[i - 2] && randomsu[i] != randomsu[i - 3] && randomsu[i] != randomsu[i - 4])
		/*�迭�� ���� ���� �ִ��� ��*/
		{
			
			cnt++;//ī��Ʈ ����
			i++;//i����
		}

		else//�ߺ��Ǵ¼����ִٸ�
		{
			continue;//���Ϲ�ó�����ε��ư�.
		}
	}
	printf("������ �� : %s\n", randomsu);
	return randomsu;//������ �����Լ��� ���ο� ������.

}
char nope(char *innumber)//����ڰ� �Է��ϴ� ��
{
	int i, j, cnt;//i,j,cnt����
	int len = 0;//���̺��ϱ����� ��Ʈ�� ���� len ����
	while (1)//��ӵ���.
	{
		cnt = 0;//���� �ߺ��Ǵ� ���� ���� �� �ٽ� ���� cnt�� 0���� �ʱ�ȭ����.
		printf("���� �Է��Ͻÿ�.\n");//�������̽�
		scanf("%s", innumber);//�� �Է�
		len = strlen(innumber);//���̸� ���ϱ����� �γ��� ���̸� ����.
		if (len == 5)//�Էµ� ���� 5�ڸ���
		{

			for (i = 0; i < 5; i++)//�Էµ� �ڸ��� �ϳ��ϳ� ���ϱ����� 2������
			{

				for (j = i + 1; j < 5; j++)
				{
					if (innumber[i] == innumber[j])//���� ���� �ִٸ�
					{
						cnt++;//cnt�� �����Ѵ�.

					}

				}
			}
			if (cnt != 0) {//cnt�� 0�̾ƴϸ� �������
				printf("�����Դϴ�. �ߺ��Ǵ� ���� �Է����� ���ÿ�.\n");
				continue;//���Ϲ��� �ٽ� ������.
			}
			
			break;//cnt�� 0�̸� ���Ϲ��� �����.
		}
		else//5�ڸ� ���� �ƴ϶�� �������
		{

			printf("�����Դϴ�. ���ڴ� 5���� �Է��ϼž��մϴ�.\n");
			continue;//���Ϲ��� �ٽõ�����.
		}




	}
	printf("�÷��̾� �Է°� : %s\n", innumber);//�Է��� �� ���

	return innumber;//�Է��� ���� ���ο� �������ش�.

}
int cpn(char *randomsu, char*innumber)//���Լ�
{
	int strike = 0;//��Ʈ����ũ ����
	int ball = 0;//�� ����
	int i = 0;//i,j����
	int j = 0;

	for (i = 0; i < 5; i++)//�����Լ��� ����ڰ� �Է��� ���� ���ϱ� ���� 2������
	{
		for (j = 0; j < 5; j++)
		{
			if (randomsu[i] == innumber[j])//�����Լ��� ����ڰ� �Է��� ���� ���� ���� �ִٸ�
			{
				if (randomsu[i] == innumber[i])//���� ���� ���� ��ġ�� �ִٸ�
				{
					strike += 1;//��Ʈ����ũ ����.
				}
				else {//���� �ٸ� ��ġ�� �ִٸ�
					ball += 1;//�� ����
				}
			}
		}
	}
	printf("����� : %dS %dB\n", strike, ball);//�� ��Ʈ����ũ �� ������ �������.
	if (strike == 5)//��Ʈ����ũ�� 5��� ���� ���
	{
		printf("�����մϴ�. �����Դϴ�.\n");
	}
	return strike;//��Ʈ����ũ�� �������ش�.

}
