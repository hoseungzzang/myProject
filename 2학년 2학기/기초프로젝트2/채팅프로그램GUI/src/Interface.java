import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;

import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Interface extends JFrame{//JFrame 상속받음. gui창 생성
	JTextField tp = new JTextField();//보낼 메세지를 입력하기 위한 텍스트 필드 선언
	
	JButton send = new JButton("Send");//send버튼 생성
	JButton login = new JButton("Login");//로그인버튼생성
	JButton cancel = new JButton("Cancle");//켄슬버튼생성
	JTextArea ta = new JTextArea();//채팅을보이기위한 택스트에리어
	JTextArea ta1 = new JTextArea();//사용자를 표시하기위한 텍스트에리어
	JMenuBar mb = new JMenuBar();//메뉴바 생성을 위한 선언
	JMenuItem item1=new JMenuItem("Login");//메뉴바에 로그인추가
	JMenuItem item2=new JMenuItem("Logout");//메뉴바에 로그아웃 추가
	JTextField tp1 = new JTextField();//아이디를위한 텍스트필드
	JTextField tp2 = new JTextField();//비밀번호를 위한 텍스트 필드
	
	
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
	
	ta1.setLocation(250,30);//위와동일
	ta1.setSize(120,230);
	cp.add(ta1);
	
	tp.setLocation(5,280);//텍스트필드부분 좌표와 크기, 컨테이너에 올림
	tp.setSize(270,25);
	cp.add(tp);
	
	send.setLocation(280,280);//센드버튼 좌표와 크기 , 컨테이너에 올려줌
	send.setSize(90,25);
	cp.add(send);
	setSize(400,400);//컨테이너 크기 설정 
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
			case "Login" : Log log = new Log(); break;//로그인 객체 생성 (실행)
							
			case "Logout" : break;
			}
			
			
		}
}
	class BtnActionListener implements ActionListener{//버튼 이벤트 파트
		public void actionPerformed(ActionEvent e) {
		
			File dfile = new File("./user.txt");//유저파일 생성
			String id="";//아이디 초기화
			String password="";//비밀번호 초기화
			id = tp1.getText();//아이디에 아이디 텍스트필드에있는 문자 가져옴
			password = tp2.getText();//비밀번호에 비밀번호 텍스트필드에있는문자 가져옴
			  String da="";//파일에있는 데이타 가져오기위한 변수
			  try {
				
				
				  BufferedReader dreader = new BufferedReader(new InputStreamReader(new FileInputStream(dfile),"EUC-KR"));//euc-kr언어로 데이타파일을 열어줌.한줄씩읽음.
				  while((da = dreader.readLine())!=null) {//파일의 끝까지 읽어옴.
				
					String da1[] =da.split("/");//split으로 /을 기준으로 전후로 나눠서 da1의 배열에 넣어줌.
					
					if(da1[0].equals(id)&&da1[1].equals(password)==true) {//da10번쨰 배열과 id를 비교하여 참이고, da1 1번쨰 배열과 패스워드를 비교하여 참일때만 실행
						ta.setText("로그인 성공");//텍스트 에리어에 로그인성공 메세지 출력
					}
					else {
						ta.setText("로그인 실패");//아니면실패메세지 출력
					}
					
				  }
			  
				 
			  	}catch(IOException a) {
				  a.printStackTrace();
			  }
			
			}
		
}


	
}
