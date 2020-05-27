
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;



import java.io.*;

public class Server {
	ServerSocket ss = null;
	static ArrayList<ConnectedClient> clients  = new ArrayList<ConnectedClient>();//커넥티드 클라이언트라는타입으로 어레이리스트 생성.

	
	static String ids=null;//아이디 받기위한 필드
	public static void main(String[] args) {
		Server server = new Server(); //Server 객체 생성 필드 사용을 위함.
		
		try {//소켓생성시 익셉션이 일어날 수 있음.
			server.ss = new ServerSocket(12345);//포트번호12345번을 따라들어와야함.
			System.out.println("서버 소켓이 생성됨.");
			while(true) {//소켓 생성시마다 생성해야 하기 때문에 무한루프 돌림.
				Socket socket = server.ss.accept(); //소켓이라는 클래스를 socket이라는 객체를 new를 통한 생성이 아닌 server.ss.accept()가 소켓을 하나 생성해줌.
				ConnectedClient c = new ConnectedClient(socket);//외부클래스 커넥티드 클라이언트를 c로 생성하고 외부클래스에 socket을 인자로 보내줌.
				server.clients.add(c);//어레이리스트에 저장시킴.
				c.start();//런 메소드 실행.
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		//ex)server.ss.close(); 닫을때
		
	}

	
}

class ConnectedClient extends Thread{//스래드 상속
	Socket socket;//소켓 하나 생성 
	OutputStream outStream;//인풋 아웃풋 스트림 생성 주고받기 위함.
	DataOutputStream dataOutStream;
	InputStream inStream;
	DataInputStream dataInStream;
	
	
	
	ConnectedClient(Socket _s){ //_s에 인자로 받을 소켓을 저장
		this.socket = _s;//클래스 컨넥트 클라이언트의 소켓에 _s 인자로 받은 소켓을 저장.
		
	}
	public void run() {//스래드가 돌아가기 위해 무조건 있어야하는 메소드
		System.out.println("Server>"+this.socket.toString()+"에서 접속이 연결되었습니다.");//생성될때받은 소켓.toString 하면 상대방의 포트번호와 아이피 번호가 출력되게끔 만듦.
		try {
			outStream = this.socket.getOutputStream();
			dataOutStream = new DataOutputStream(outStream);
			inStream = this.socket.getInputStream();
			dataInStream = new DataInputStream(inStream);
		
			
			
			
			dataOutStream.writeUTF("Welcome");
			while(true) {//응답대기
				//String msg=dataInStream.readUTF();//msg에 들어오는 텍스트 저장
				//dataOutStream.writeUTF(msg);
			
				
				String msg = dataInStream.readUTF();//클라이언트로부터 데이터를 받아옴.
				
				String line[] = msg.split("/");//라인에 /를 기준으로 자름
				
				if(line[0].equals("joo"))/// 앞이 JOO일경우 아이디
				{
					Server.ids = Server.ids+"@"+line[1];//받아온 아이디를 IDS 문자열에 추가
					
					for(int a =0; a<Server.clients.size();a++) {//들어온 클라이언트 수만큼 증가
						outStream = Server.clients.get(a).socket.getOutputStream();//연결하면서 받은 클라이언트들의 소켓정보로
																				//해당 클라이언트들에게 데이터 전달
						dataOutStream = new DataOutputStream(outStream);
						//System.out.println(Server.clients.size());	
						dataOutStream.writeUTF("joo"+"/"+Server.ids);//클라이언트도 아이디와 텍스트를 구분하기 위해 JOO와 /를 붙여서 보내줌
						
						
					}
					
				}
				else if(line[0].equals("!"))///앞이 !이면 삭제
				{
					String ids2 ;
					//System.out.println(line[1]);
					//System.out.println(Server.ids);
					ids2=Server.ids.replaceFirst(line[1],"");//IDS2에 IDS의 삭제된 값이 제대로나오는지확인
					
					Server.ids = ids2;//IDS에 다시 값 넣어줌.
					
					//Server.ids=Server.ids.replaceFirst(line[1],"");
					//System.out.println(Server.ids);
					for(int a =0; a<Server.clients.size();a++) {//아이디와 똑같이 클라이언트들에게 보내줌.
						outStream = Server.clients.get(a).socket.getOutputStream();
						dataOutStream = new DataOutputStream(outStream);
						System.out.println(Server.clients.size());	
						dataOutStream.writeUTF("joo"+"/"+Server.ids);
						
						
					}
					
				}
				else {
				for(int i=0;i<Server.clients.size();i++)///앞에 아무것도 없으면 메세지
				{
					outStream = Server.clients.get(i).socket.getOutputStream();//메세지를 다른 클라이언트들에게 출력해줌.
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
