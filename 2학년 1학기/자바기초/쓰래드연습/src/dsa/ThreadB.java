package dsa;


public class ThreadB extends Thread{
	
	private WorkObject workObject;

	int i=0;
	public ThreadB(WorkObject workObject)
	{
		this.workObject =workObject;
	}
	@Override
	public void run() {
		while(true) {
			if(workObject.count!=0)//count���� 0�� �ƴϸ�
				workObject.methodB(); //�޼ҵ�B ȣ��
			else
				break; //�����
		}
	}
}
