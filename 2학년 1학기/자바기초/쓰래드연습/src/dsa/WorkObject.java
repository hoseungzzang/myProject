package dsa;

public class WorkObject extends WaitNotifyExanple{

	WaitNotifyExanple wait=new WaitNotifyExanple();
		 static int count;//ī��Ʈ�� �ƽ��� ����.
		 
	 	public synchronized void methodA() { 
	 		
	 		count--; //�Ҹ������� ī��Ʈ 1�� ���ҽ�Ŵ.
	 		System.out.println("ThreadA ����  : " + count ); //ǥ��
	 		notify(); //��������·� ����
	 		try { 
				wait(); //�Ͻ��������·θ����. 
	 		} catch (InterruptedException e) { 
			} 
	 		notifyAll(); //0�ϰ�� �ѹ��� �����ϱ� ���� ����
		} 
	
	 
		public synchronized void methodB() { 
	 		count--;//�Ҹ������� 1�� ����
			System.out.println("ThreadB ����  : "+ count); //ǥ��
			notify(); //��������·� �����.
			try { 
			wait(); //�Ϛ�������·θ����.
			} catch (InterruptedException e) { 
			} 
			notifyAll(); //0�ϰ�� �ѹ��� �����Ͽ����ϱ����Ѱ�
			} 
		 }


