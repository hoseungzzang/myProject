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
			if(workObject.count!=0)//카운트값이 0이아니면 메소드 A를 실행한다.
			{
				workObject.methodA(); 
			}
			else
			{
				break; //멈춘다
			}
		}
		}
}
