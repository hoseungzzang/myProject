
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;



import java.io.*;

public class Server {
	ServerSocket ss = null;
	static ArrayList<ConnectedClient> clients  = new ArrayList<ConnectedClient>();//Ŀ��Ƽ�� Ŭ���̾�Ʈ���Ÿ������ ��̸���Ʈ ����.

	
	static String ids=null;//���̵� �ޱ����� �ʵ�
	public static void main(String[] args) {
		Server server = new Server(); //Server ��ü ���� �ʵ� ����� ����.
		
		try {//���ϻ����� �ͼ����� �Ͼ �� ����.
			server.ss = new ServerSocket(12345);//��Ʈ��ȣ12345���� ������;���.
			System.out.println("���� ������ ������.");
			while(true) {//���� �����ø��� �����ؾ� �ϱ� ������ ���ѷ��� ����.
				Socket socket = server.ss.accept(); //�����̶�� Ŭ������ socket�̶�� ��ü�� new�� ���� ������ �ƴ� server.ss.accept()�� ������ �ϳ� ��������.
				ConnectedClient c = new ConnectedClient(socket);//�ܺ�Ŭ���� Ŀ��Ƽ�� Ŭ���̾�Ʈ�� c�� �����ϰ� �ܺ�Ŭ������ socket�� ���ڷ� ������.
				server.clients.add(c);//��̸���Ʈ�� �����Ŵ.
				c.start();//�� �޼ҵ� ����.
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		//ex)server.ss.close(); ������
		
	}

	
}

class ConnectedClient extends Thread{//������ ���
	Socket socket;//���� �ϳ� ���� 
	OutputStream outStream;//��ǲ �ƿ�ǲ ��Ʈ�� ���� �ְ�ޱ� ����.
	DataOutputStream dataOutStream;
	InputStream inStream;
	DataInputStream dataInStream;
	
	
	
	ConnectedClient(Socket _s){ //_s�� ���ڷ� ���� ������ ����
		this.socket = _s;//Ŭ���� ����Ʈ Ŭ���̾�Ʈ�� ���Ͽ� _s ���ڷ� ���� ������ ����.
		
	}
	public void run() {//�����尡 ���ư��� ���� ������ �־���ϴ� �޼ҵ�
		System.out.println("Server>"+this.socket.toString()+"���� ������ ����Ǿ����ϴ�.");//�����ɶ����� ����.toString �ϸ� ������ ��Ʈ��ȣ�� ������ ��ȣ�� ��µǰԲ� ����.
		try {
			outStream = this.socket.getOutputStream();
			dataOutStream = new DataOutputStream(outStream);
			inStream = this.socket.getInputStream();
			dataInStream = new DataInputStream(inStream);
		
			
			
			
			dataOutStream.writeUTF("Welcome");
			while(true) {//������
				//String msg=dataInStream.readUTF();//msg�� ������ �ؽ�Ʈ ����
				//dataOutStream.writeUTF(msg);
			
				
				String msg = dataInStream.readUTF();//Ŭ���̾�Ʈ�κ��� �����͸� �޾ƿ�.
				
				String line[] = msg.split("/");//���ο� /�� �������� �ڸ�
				
				if(line[0].equals("joo"))/// ���� JOO�ϰ�� ���̵�
				{
					Server.ids = Server.ids+"@"+line[1];//�޾ƿ� ���̵� IDS ���ڿ��� �߰�
					
					for(int a =0; a<Server.clients.size();a++) {//���� Ŭ���̾�Ʈ ����ŭ ����
						outStream = Server.clients.get(a).socket.getOutputStream();//�����ϸ鼭 ���� Ŭ���̾�Ʈ���� ����������
																				//�ش� Ŭ���̾�Ʈ�鿡�� ������ ����
						dataOutStream = new DataOutputStream(outStream);
						//System.out.println(Server.clients.size());	
						dataOutStream.writeUTF("joo"+"/"+Server.ids);//Ŭ���̾�Ʈ�� ���̵�� �ؽ�Ʈ�� �����ϱ� ���� JOO�� /�� �ٿ��� ������
						
						
					}
					
				}
				else if(line[0].equals("!"))///���� !�̸� ����
				{
					String ids2 ;
					//System.out.println(line[1]);
					//System.out.println(Server.ids);
					ids2=Server.ids.replaceFirst(line[1],"");//IDS2�� IDS�� ������ ���� ����γ�������Ȯ��
					
					Server.ids = ids2;//IDS�� �ٽ� �� �־���.
					
					//Server.ids=Server.ids.replaceFirst(line[1],"");
					//System.out.println(Server.ids);
					for(int a =0; a<Server.clients.size();a++) {//���̵�� �Ȱ��� Ŭ���̾�Ʈ�鿡�� ������.
						outStream = Server.clients.get(a).socket.getOutputStream();
						dataOutStream = new DataOutputStream(outStream);
						System.out.println(Server.clients.size());	
						dataOutStream.writeUTF("joo"+"/"+Server.ids);
						
						
					}
					
				}
				else {
				for(int i=0;i<Server.clients.size();i++)///�տ� �ƹ��͵� ������ �޼���
				{
					outStream = Server.clients.get(i).socket.getOutputStream();//�޼����� �ٸ� Ŭ���̾�Ʈ�鿡�� �������.
					dataOutStream = new DataOutputStream(outStream);
					dataOutStream.writeUTF(msg); 
				}
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	
	}
}
