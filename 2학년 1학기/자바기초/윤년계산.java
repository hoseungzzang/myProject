//������ : ��ȣ��
//���� ���� : ���� ��ƿ� �ϼ��� �˾ƺ���. 
//���� ������ : 2018.03.22
//���� ������: 2018.03.25
package pro;
import java.util.Calendar;//��¥�Լ�
import java.util.Scanner;//���ɳ� �Լ�
public class Daycounter {
	 int cYear, cMonth, cDay;//���� ��,��,��
	 int bYear, bMonth, bDay;//�¾ ��,��,��
	 int cnt_normalYear;//���
	 int cnt_leapYear;//����
	 int sum;//���� ��ƿ� �ϼ� 
	public static void main(String[] args) {
		  Daycounter dct = new Daycounter();//daycounter�� dct��� �����ڷ� ����
		  dct.getBirthDate();//�¾ ��,��,���� �Է½�Ŵ.
		  dct.countLeapYear();//����������Ѱźҷ���
		  dct.showCountedResult();//��ƿ����� ����Ѱ� �ҷ���
		  

	}


public Daycounter() {     //������
	   initiation();//������ �������� �ʱ�ȭ��Ŵ
	   
	   
	 }
//��ü�� ��Ʈ����Ʈ���� �ʱ�ȭ 
public void initiation() {
Calendar cal = Calendar.getInstance();//��¥ �Լ��� cal�̶�� �����ϰ� ����ϰڴ�.
cYear=cal.get(Calendar.YEAR);//���� �⵵�� �־���.
cMonth=cal.get(Calendar.MONTH)+1;//���� ���� �־���.
cDay=cal.get(Calendar.DATE);//���� ���� �־���.
cnt_normalYear=0;//����ʱ�ȭ
cnt_leapYear=0;//�����ʱ�ȭ
sum=0;//�ʱ�ȭ

System.out.println("Today : " + cYear + "-"+ cMonth + "-"+ cDay);//���� ��� ��� �������� ���



}

// ���� ��ƿ� �ϼ��� ���
public void showCountedResult() {
sum = dayCountForBirthYear()+dayCountForThisYear()+(cnt_leapYear*366)+(cnt_normalYear*365);
//���� ����⿡ ��ƿ� �ϼ��� Ȧ�ؿ� ��ҿ� �ϼ��� ���ϰ� �׻��� �⵵�� ���⿣366�� ���ϰ� ��⿣ 365������ ���� �� ����.
System.out.printf("��ƿ� �ϼ��� %d���̴�.\n",sum);//�׷��� ���� ��� ���
}

// ����ڷκ��� ��������� �Է¹��� 
public void getBirthDate() {
 Scanner scan=new Scanner(System.in);//��ĳ���Լ��� scan�̶� �̸����λ��
 System.out.println("�¾ �� : ");
 bYear = scan.nextInt();//�¾ �� �Է�
 System.out.println("�¾ �� : ");
 bMonth = scan.nextInt();//�¾ �� �Է�
 System.out.println("�¾ �� : ");
 bDay = scan.nextInt();//�¾ �� �Է�
 
 
}




//���� �� ��� �� ��� (�� ������ ���� �⵵�� ��꿡�� ����)
public void countLeapYear() {

 for(int i = bYear+1; i<cYear;i++)//i�� �¾ �⿡�� 1���ϰ� ����⵵ 1���ذű��� ����
 {                                //������ �¾���� ���� �ٻ�� �ƴϰ� ����⵵�� �ٻ���� �ƴϱ⋚��
  if(i%4==0 && i%100!=0 || i%400==0)//�����ϰ�쿣
  {
   cnt_leapYear++;//����ī��Ʈ����
  }
  else//������ �ƴ� ����ϰ��
  {
   cnt_normalYear++;//���ī��Ʈ ����
  }
  }
 System.out.printf("������ %d���̰� ����� %d���̴�.\n",cnt_leapYear,cnt_normalYear);//���

 }

       // ������� �ϼ� ��� (����� ���������� ��ȯ��)
public int dayCountForBirthYear() {

	int bnum=0;//�ϼ��� �޾Ƴ������� ����
	int bnum2=0;//�¾ ���� �ϼ��� �޾Ƴ������Ѻ���
	int i=bYear;//i�� �¾ �⵵
	
	int j=bMonth+1;//j�� �¾ ����+1
	int result=0;//�� �ϼ� 
	for(;j<13;j++)//�¾��+1���� 12������ ����
	{
		if(i%4==0 && i%100!=0 || i%400==0)//�����̸�
		{
			if(j==2)//2���� ���
			{
				bnum+=29;//29�� ���Ѵ�.
			}
			else if(j==1||j==3||j==5||j==7||j==8||j==10||j==12)//1�Ǵ�3�Ǵ�5�Ǵ�7�Ǵ�8�Ǵ�10�Ǵ�12���ϰ��
			{
				bnum+=31;//31�� ���Ѵ�.
			}
			else//�׿� 4,6,8,11���ϰ��
			{
				bnum+=30;//30�� ���Ѵ�.
			}
		}
		else
		{
			
			if(j==2)//���2���ϰ��
			{
				bnum+=28;//28�� ���Ѵ�.
			}
			else if(j==1||j==3||j==5||j==7||j==8||j==10||j==12)//��� 1�Ǵ�3�Ǵ�5�Ǵ�7�Ǵ�8�Ǵ�10�Ǵ�12���ϰ��
			{
				bnum+=31;//31�����Ѵ�.
			}
			else//�׿��� ���
			{
				bnum+=30;//30���� ���Ѵ�.
			}
		}
	    
		
	}
	if(i%4==0 && i%100!=0 || i%400==0)//�����ϰ��
	{
		if(j==2)//2���� ��� 
		{
			bnum2+=(29-bDay);//29-�¾���� ���ش�.
		}
		else if(j==1||j==3||j==5||j==7||j==8||j==10||j==12)//1�Ǵ�3�Ǵ�5�Ǵ�7�Ǵ�8�Ǵ�10�Ǵ�12���ϰ��
		{
			bnum2+=(31-bDay);//31-�¾���� ���ش�.
		}
		else//�� ���� ���
		{
			bnum2+=(30-bDay);//30 - �¾���� ���ش�.
		}
	}
	else//����ϰ��
	{
		
		if(j==2)//2���ϰ��
		{
			bnum2+=(28-bDay);//28���� �¾�������ش�.
		}
		else if(j==1||j==3||j==5||j==7||j==8||j==10||j==12)//1�Ǵ�3�Ǵ�5�Ǵ�7�Ǵ�8�Ǵ�10�Ǵ�12���ϰ��
		{
			bnum2+=(31-bDay);//31���� �¾�������ش�.
		}
		else//�� ���� ���
		{
			bnum2+=(30-bDay);//30�Ͽ��� �¾ ���� ���ش�.
		}
	}
	result = bnum+bnum2;//���� ��� ����ؼ� ���� �ϼ��� �� ���� result�� �ִ´�.
	System.out.printf("������� %d ���̴�\n",result);//����� ���
	
	return result;//������� ��ȯ�Ѵ�.
	

}
       // ������ �ϼ� ���  (����� ���������� ��ȯ��)
public int dayCountForThisYear() {

	int i=cYear;//i�� ���� ��
	int bnum=0;//�ϼ��� �޾��ִ� ����
	int c=cMonth;//c�� ���� ��
	int result=0;//����� �ʱ�ȭ
	for(int j=1; j<=c-1;j++)//j�� ���� ��-1���� ���� 
	{                       //���� ���� �ٻ�� �ƴ϶� ����.
		if(i%4==0 && i%100!=0 || i%400==0)//������ ���
		{
			if(j==2)//2���� ���
			{
				bnum+=29; // 29���� ���Ѵ�.
			}
			else if(j==1||j==3||j==5||j==7||j==8||j==10||j==12)//1�Ǵ�3�Ǵ�5�Ǵ�7�Ǵ�8�Ǵ�10�Ǵ�12���ϰ��
			{
				bnum+=31;//31���� ���Ѵ�.
			}
			else//�� ���ϰ��
			{
				bnum+=30;//30���� ���Ѵ�.
			}
		}
		else//����ϰ��
		{
			
			if(j==2)//2���ϰ��
			{
				bnum+=28;//28���� ���Ѵ�.
			}
			else if(j==1||j==3||j==5||j==7||j==8||j==10||j==12)//1�Ǵ�3�Ǵ�5�Ǵ�7�Ǵ�8�Ǵ�10�Ǵ�12���ϰ��
			{
				bnum+=31;//31�������Ѵ�.
			}
			else//�� ���� ��� 
			{
				bnum+=30;//30���� ���Ѵ�.
			}
		}
		
	}
	result = bnum+cDay;//��� ���� ���� �� �����ٰ� �̹��⵵ ���� ���ϸ� �̹��⵵�� �� �ϼ��� ����. result�� ����.
	System.out.printf("���� �ϼ� ����� %d ���̴�.\n",result);//����� ���
	
	return result;//����� ����
	
}
}


	



