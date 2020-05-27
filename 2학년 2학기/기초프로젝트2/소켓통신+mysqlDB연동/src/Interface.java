import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.util.ArrayList;
import java.util.*;
public class Interface extends JFrame{//JFrame 상속받음. gui창 생성
	JTextField tp = new JTextField();//보낼 메세지를 입력하기 위한 텍스트 필드 선언
	
	JButton send = new JButton("Send");//send버튼 생성
	JButton login = new JButton("Login");//로그인버튼생성
	JButton cancel = new JButton("Cancle");//켄슬버튼생성
	JButton find = new JButton("Find");//켄슬버튼생성
	JTextArea ta = new JTextArea();//채팅을보이기위한 택스트에리어
	JTextArea ta1 = new JTextArea();//사용자를 표시하기위한 텍스트에리어
	JMenuBar mb = new JMenuBar();//메뉴바 생성을 위한 선언
	JMenuItem item1=new JMenuItem("Login");//메뉴바에 로그인추가
	JMenuItem item2=new JMenuItem("Logout");//메뉴바에 로그아웃 추가
	JTextField tp1 = new JTextField();//아이디를위한 텍스트필드
	JTextField tp2 = new JTextField();//비밀번호를 위한 텍스트 필드
	JTextField tp4 = new JTextField();//비밀번호를 위한 텍스트 필드
	String textL="";
	String resultStr=null;
	String resultStr2 =null;
	String line[] = new String[100];
	String idLine[] = new String[100];
	JList il = new JList();
	DefaultListModel lim = new DefaultListModel();
	int cnt =0;
	InputStream inStream;
	DataInputStream dataInStream;
	String tID =null;//데이베이스에서 불러온 아이디와 비교해주기 위한 아이디 변수
	InputStreamReader isr = null;
	BufferedReader br = null;
	OutputStreamWriter osw = null;
	BufferedWriter bw = null;
	Socket mySocket = null;
	 MessageListener msgListener = null;
	 OutputStream outStream = null;
	 DataOutputStream dataOutStream = null;
	 Scanner scan = new Scanner(System.in);
	 Vector<String> vector = new Vector<String>();
	 String id;
	int a=0;
	Interface(){//인터페이스 객체 생성
		setTitle("My Chatting V0.1");//gui 제목 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//gui가 종료를 누르면 프로그렘이 종료댐
		Container cp = getContentPane();//컴포넌트를 넣을 컨테이너 
		creatMenu();//메뉴바 생성 메소드 실행
		
		
		
		
	cp.setBackground(Color.GREEN);//컨텐츠팬영역 색깔을 바꿔줌.
	cp.setLayout(null);//레이아웃 관리자를 널로 표현함으로 좌표지정으로 인해 각 컴포넌트를 원하는 좌표에 삽입가능

	JLabel la =new JLabel("Message box");//메세지박스입력
	la.setLocation(5,8);//좌표
	la.setSize(200,20);//크기
	cp.add(la);//컨테이너에 올림
	JLabel la1 =new JLabel("Members");//메세지박스입력 위와 동일.
	la1.setLocation(250,8);
	la1.setSize(200,20);
	cp.add(la1);
	
	ta.setLocation(5,30);//텍스트에리어부분 좌표와 크기
	ta.setSize(240,230);//크기
	cp.add(ta);//컨테이너에올림
	
	il.setLocation(250,30);//위와동일
	il.setSize(120,230);
	cp.add(il);
	
	tp.setLocation(5,280);//텍스트필드부분 좌표와 크기, 컨테이너에 올림
	tp.setSize(270,25);
	cp.add(tp);
	
	tp4.setLocation(5,310);//텍스트필드부분 좌표와 크기, 컨테이너에 올림
	tp4.setSize(270,25);
	cp.add(tp4);
	
	send.setLocation(280,280);//센드버튼 좌표와 크기 , 컨테이너에 올려줌
	send.setSize(90,25);
	cp.add(send);
	
	find.setLocation(280,310);//센드버튼 좌표와 크기 , 컨테이너에 올려줌
	find.setSize(90,25);
	cp.add(find);
	
	
	send.addActionListener(new BtnActionListener());//센드버튼 이벤트 실행
	find.addActionListener(new BtnActionListener());//검색버튼 이벤트 실행
	setSize(400,450);//컨테이너 크기 설정 
	setVisible(true);//펄스를주면안보임
	}
	
	void creatMenu() {//메뉴바 생성 메소드
		JMenuItem [] menuItem = new JMenuItem[2];//메뉴아이탬 생성 몇개쓸건지 정해져있기떄문에 2를 인자로줌
		String[] itemTitle = {"Login","Logout"};//아이템 타이틀 배열에 로그인과 로그아웃을 줌.
		JMenu screenMenu = new JMenu("Menu");//메뉴바 맨 위에 보여질 글자 할당.
		mb.add(screenMenu);//스크린 매뉴 컨테이너에 올림
		
		
		setJMenuBar(mb);//메뉴바 추가
		MenuActionListener listener = new MenuActionListener();//메뉴 이벤트 넣기위해 메뉴엑션리스너 생성
		for(int i=0; i<menuItem.length;i++)//메뉴아이템이 담고있는 수만큼 반복
		{
			menuItem[i]=new JMenuItem(itemTitle[i]);//아이템 타이틀에 있는 두개를 메뉴아이템으로 생성시켜줌.
			menuItem[i].addActionListener(listener);//i번쨰에 배열에 있는 메뉴아이템에 이벤트를 입혀줌
			screenMenu.addSeparator();//메뉴아이템 사이에 줄그음
			screenMenu.add(menuItem[i]);//메뉴아이템을 메뉴바에 추가
		}
		
	}
	class Log extends JFrame{//로그인 창을 새로 띄우기 위해 제이프레임 상속
		Log(){//log 객체생성
		setTitle("Login");//gui이름 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//종료하면 프로그램도 종료
		Container L = getContentPane();//컴포넌트 줌
		
		L.setBackground(Color.GREEN);//컨텐츠팬영역 색깔을 바꿔줌.
		L.setLayout(null);//레이아웃 관리자 널
		JLabel Lla =new JLabel("ID");//메세지박스입력
		Lla.setLocation(30,8);//위치와 크기 , 컨테이너에 띄워줌
		Lla.setSize(200,20);
		L.add(Lla);
		JLabel Lla1 =new JLabel("Password");//메세지박스입력
		Lla1.setLocation(8,30);//위치와 크기 , 컨테이너에 띄워줌
		Lla1.setSize(200,20);
		L.add(Lla1);
		
		tp1.setLocation(80,8);//텍스트필드부분
		tp1.setSize(180,20);//위치와 크기 컨테이너에 올림
		L.add(tp1);
		
		tp2.setLocation(80,30);//텍스트필드부분
		tp2.setSize(180,20);//위치와 크기 컨테이너에 올림
		L.add(tp2);
		
		login.setLocation(8,60);//로그인버튼 위치와 크기 ,컨테이너에올려줌
		login.setSize(130,30);//
		L.add(login);
		
		cancel.setLocation(135,60);//켄슬버튼 위치와 크기 컨테이너에올려줌.
		cancel.setSize(130,30);
		L.add(cancel);
		
		
		login.addActionListener(new BtnActionListener());//로그인 버튼 클릭하면 이벤트 실행
		
		setSize(300,150);//크기"
		setVisible(true);//펄스를주면안보임
		
		}
		
	}
	public static void main(String[] args) {
	Interface inter = new Interface();//인터페이스 객체 생성

	}

	class MenuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();//cmd에 메뉴바 이벤트가 어떤건지 가져옴
			switch(cmd) {//스위치문을 이용해 로그인 버튼 눌리면 로그인 실행
			case "Login" : Log log = new Log(); //로그 클래스 생성 사용
		
			
			
			break;
							
			case "Logout" : //로그아웃 누를시 접속 해제되는 것 아이디 삭제
				try {
				dataOutStream.writeUTF("!"+"/"+id); // !은 삭제 아이디임을 식별하기 위한 문자, /는 자르기위해 , 아이디는 삭제할 아이디
				System.exit(1);//로그아웃
				
				break;
				}catch(Exception e3)
				{
					System.out.println(e.getSource());
				}
	
			}
			
			
		}
}
	class BtnActionListener implements ActionListener{//버튼 이벤트 파트
	
		String password="";//비밀번호 초기화
		public void actionPerformed(ActionEvent e) {
		

			JButton b =  (JButton)e.getSource();
			String btnCho = b.getText();//버튼에 눌려지는 값을 받아줌.
			if(btnCho=="Login") {
				
			
			File dfile = new File("./user.txt");//유저파일 생성
			
			id = tp1.getText();//아이디에 아이디 텍스트필드에있는 문자 가져옴
			password = tp2.getText();//비밀번호에 비밀번호 텍스트필드에있는문자 가져옴
			  String da="";//파일에있는 데이타 가져오기위한 변수
			  try {
				
				  FileReader filereader = new FileReader(dfile);
				  BufferedReader dreader = new BufferedReader(filereader);//euc-kr언어로 데이타파일을 열어줌.한줄씩읽음.
				  while((da = dreader.readLine())!=null) {//파일의 끝까지 읽어옴.
				
					String da1[] =da.split("/");//split으로 /을 기준으로 전후로 나눠서 da1의 배열에 넣어줌.
					try {
						
						tID=tp4.getText();
						String URL = "jdbc:mysql://localhost/friend?serverTimezone=Asia/Seoul";//로컬호스트부분 : 컴퓨터 주소 .채팅서비스라는 시스템 사용
						//서비스타임존 아시아 서울 : 시간대 설정
						Connection con = null; //연결 객체
						Statement stmt = null; //어떤 일을 시킬건지 정의하는 객체 ex)삽입 삭제 검색 등 
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
						}catch(Exception e1) {
							System.out.println(e1.toString());
						}
						try {//접근
							con= DriverManager.getConnection(URL, "root", "admin");//upl,아이디,비밀번호 sql에 사용하는 아이디 비밀번호사용
																					//커넥션객체생성
							System.out.println("Connection ok");
							stmt = con.createStatement();//스테이트먼트객체생성
						
							System.out.println("OK2");
							ResultSet result = stmt.executeQuery("SELECT * FROM friend.login");//friend에 있는 모든것 가져옴.
							int count=0;
							while(result.next()) {//아이디와 비밀번호 가져옴
								 resultStr = result.getString("id");//아이디 비번 가져옴
								 resultStr2 = result.getString("pw");
								
							
							}
							
							stmt.close();
							con.close();
						}catch(Exception e2) {
							System.out.println(e2.toString());
						}
					}catch(Exception a) {
					System.out.println(a.toString());	
					}
					if(resultStr.equals(id)&&resultStr2.equals(password)==true) {//da10번쨰 배열과 id를 비교하여 참이고, da1 1번쨰 배열과 패스워드를 비교하여 참일때만 실행
						ta.setText("로그인 성공");//텍스트 에리어에 로그인성공 메세지 출력
						
						 try {
							 mySocket = new Socket("localhost",12345);//소켓 생성
							 System.out.println("Client> 서버로 연결되었습니다.");	
							 msgListener = new MessageListener(mySocket);//msgListener에 소켓 인자로 넘겨줌
							 
							 outStream = mySocket.getOutputStream();
							 dataOutStream = new DataOutputStream(outStream);
							
							
							 msgListener.start();//런 메소드 실행
							 dataOutStream.writeUTF("joo"+"/"+id);//식별하기위한 코드 JOO와 자르기 위한 / 아이디 보냄.
							 Thread.sleep(100);
							 
								break;
								// System.out.println("Client(Enter Message)>");
								// msg = scan.nextLine();
								 //dataOutStream.writeUTF(msg);
								 
							 
							 
						 }catch(IOException  | InterruptedException e2) {
							 
							 e2.printStackTrace();	
									
								
						 }
					
					}
					else {
						ta.setText("로그인 실패");
					}
				
					
				  }
			  
				 
			  	}catch(IOException a) {
				  a.printStackTrace();
			  }
			
			}
			
			else if(btnCho=="Send")//센드버튼 이벤트
			{
				try {
				
				
				outStream =mySocket.getOutputStream();
				
				dataOutStream = new DataOutputStream(outStream);
				String tpl = tp.getText();//텍스트 필드에 있는 값 TPL에 넣어줌
				
				dataOutStream.writeUTF(tpl);//서버로 보내줌
				
				}catch(Exception a) {
				System.out.println(a.toString());	
				}
			
			}
			else if(btnCho=="Find")//센드버튼 이벤트
			{
				try {
				
					tID=tp4.getText();
					String URL = "jdbc:mysql://localhost/friend?serverTimezone=Asia/Seoul";//로컬호스트부분 : 컴퓨터 주소 .채팅서비스라는 시스템 사용
					//서비스타임존 아시아 서울 : 시간대 설정
					Connection con = null; //연결 객체
					Statement stmt = null; //어떤 일을 시킬건지 정의하는 객체 ex)삽입 삭제 검색 등 
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					}catch(Exception e1) {
						System.out.println(e1.toString());
					}
					try {//접근
						con= DriverManager.getConnection(URL, "root", "admin");//upl,아이디,비밀번호 sql에 사용하는 아이디 비밀번호사용
																				//커넥션객체생성
						System.out.println("Connection ok");
						stmt = con.createStatement();//스테이트먼트객체생성
					
						System.out.println("OK2");
						ResultSet result = stmt.executeQuery("SELECT id FROM friend.cid");//friend에 있는 모든것 가져옴.
						int count=0;
						while(result.next()) {//아이디와 비밀번호 가져옴
							String resultStr = result.getString("id");
							
							if(tID.equals(resultStr))//가져온 아이디 와 작성한 아이디  맞으면 
							{
								
								ta.setText(tID+"님은 친구가 맞습니다.");//텍스트 에리어에 출력
								break;
							}
							
						
						}
						
						stmt.close();
						con.close();
					}catch(Exception e2) {
						System.out.println(e2.toString());
					}
				}catch(Exception a) {
				System.out.println(a.toString());	
				}
			
			}
		}
		
}
	
	

	class MessageListener extends Thread{//쓰래드 상속
		Socket socket;//소켓
		InputStream inStream;//서버에서 오는 것 받아주기 위함.
		
		DataInputStream dataInStream;//받아오는 것을 데이터화시켜서 받아줌.
		OutputStream outStream;//서버로 보내주기 위한 것 
		DataOutputStream dataOutStream;//보낼 것을 데이터화 시키기위함
		
		
		MessageListener(Socket _s){//_s에 인자로 받을 소켓을 저장
			this.socket = _s;//클래스 컨넥트 클라이언트의 소켓에 _s 인자로 받은 소켓을 저장.
		}
		public void run() {
			try {
			
				inStream = this.socket.getInputStream();
				dataInStream = new DataInputStream(inStream);
				

				
				
				while(true) {//무한반복을 돌면서 
				
				//String msg=dataInStream.readUTF();
				//System.out.println("Client> "+msg);
					
				String msg=dataInStream.readUTF();//서버에서 오는것 받음
				String line[] = msg.split("/");// /를 기준으로 자름
				
				
				if(line[0].equals("joo"))//라인 0이 JOO이면 아이디
				{
					String ids[] = line[1].split("@");//아이디를 식별하기 위해 @로 자르고 구분
					lim.removeAllElements();//모든 엘레멘트 삭제
					for(int n=1; n<ids.length; n++) {//아이디 배열의 길이만큼 반복
						
							lim.insertElementAt(ids[n],n-1);//JLIST에 올릴 인자를 DEFAULTLISTMODEL로 받고 인덱스 배열의 값과 추가할 인덱스번호 추가
							il.setModel(lim);//JLIST에 올림
					}
					
					
				}
				else {//텍스트의 경우
				textL = textL+"\n"+msg;//메세지가 추가되면 삭제되므로 전부 더하고 띄어쓰기로 구분
				ta.setText(textL);//텍스트 에리어에 올림
				
				}
				
				}
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}


		
}



