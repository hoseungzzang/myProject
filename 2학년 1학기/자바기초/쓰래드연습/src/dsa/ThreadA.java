package dsa;


public class ThreadA extends Thread{

	private WorkObject workObject;
	WaitNotifyExanple wait = new WaitNotifyExanple();
	int i=0;
	public ThreadA(WorkObject workObject)
	{
		this.workObject =workObject;
	}
	@Override
	public void run() {
	
		while(true) {
			if(workObject.count!=0)//ī��Ʈ���� 0�̾ƴϸ� �޼ҵ� A�� �����Ѵ�.
			{
				workObject.methodA(); 
			}
			else
			{
				break; //�����
			}
		}
		}
}
