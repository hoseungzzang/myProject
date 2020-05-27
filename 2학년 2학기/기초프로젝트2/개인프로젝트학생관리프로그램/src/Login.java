import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.*;


public class Login extends JFrame{
	JTextField tp1 = new JTextField();//아이디를위한 텍스트필드
	JTextField tp2 = new JTextField();//비밀번호를 위한 텍스트 필드
	JButton login = new JButton("Login");//로그인버튼생성
	JButton cancel = new JButton("Cancle");//켄슬버튼생성
	String tID=null;
	String tPass=null;
	Login(){
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
		cancel.addActionListener(new BtnActionListener());//캔슬누르면 종료
		setSize(300,150);//크기"
		setVisible(true);//펄스를주면안보임
	}
	
	class BtnActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();//cmd에 메뉴바 이벤트가 어떤건지 가져옴
			
			switch(cmd) {//스위치문을 이용해 로그인 버튼 눌리면 로그인 실행
			case "Login" : 
				tID=tp1.getText();
				tPass=tp2.getText();
				String URL = "jdbc:mysql://localhost/university?serverTimezone=Asia/Seoul";//로컬호스트부분 : 컴퓨터 주소 .채팅서비스라는 시스템 사용
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
				ResultSet result = stmt.executeQuery("SELECT * FROM login");//질의 로그인에 있는 모든것 가져옴.
				int count=0;
				while(result.next()) {//아이디와 비밀번호 가져옴
					String resultStr = result.getString("id");
					String resultStr2=result.getString("password");
					if(tID.equals(resultStr)&&tPass.equals(resultStr2))//가져온 아이디 비밀번호와 작성한 아이디 비밀번호가 맞으면 
					{
						GuiPart gui = new GuiPart();//쥐유아이 생성.
						
						break;
					}
					
				
				}
				
				stmt.close();
				con.close();
			}catch(Exception e2) {
				System.out.println(e2.toString());
			}
			break;
							
			case "Cancle" : //로그아웃 누를시 접속 해제되는 것 아이디 삭제
				System.exit(1);//로그아웃
			
			
		}
}
}
}
