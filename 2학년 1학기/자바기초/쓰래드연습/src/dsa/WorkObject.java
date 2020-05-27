package dsa;

public class WorkObject extends WaitNotifyExanple{

	WaitNotifyExanple wait=new WaitNotifyExanple();
		 static int count;//카운트와 맥스는 같다.
		 
	 	public synchronized void methodA() { 
	 		
	 		count--; //불릴때마다 카운트 1씩 감소시킴.
	 		System.out.println("ThreadA 동작  : " + count ); //표시
	 		notify(); //실행대기상태로 만듬
	 		try { 
				wait(); //일시정지상태로만든다. 
	 		} catch (InterruptedException e) { 
			} 
	 		notifyAll(); //0일경우 한번더 실행하기 위해 쓰임
		} 
	
	 
		public synchronized void methodB() { 
	 		count--;//불릴때마다 1씩 감소
			System.out.println("ThreadB 동작  : "+ count); //표시
			notify(); //실행대기상태로 만든다.
			try { 
			wait(); //일싲어지상태로만든다.
			} catch (InterruptedException e) { 
			} 
			notifyAll(); //0일경우 한번더 실행하여야하기위한것
			} 
		 }


