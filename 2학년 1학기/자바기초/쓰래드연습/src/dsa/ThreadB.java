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
			if(workObject.count!=0)//count값이 0이 아니면
				workObject.methodB(); //메소드B 호출
			else
				break; //멈춘다
		}
	}
}
