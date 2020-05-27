// 컴퓨터 공학과 2015244071 주호승
// 개인 프로젝트 
import java.awt.*;//gui,벡터,이벤트 sql여동하기 위해 선언
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.tree.*;
import java.util.Vector;
import java.awt.event.*;
public class GuiPart extends JFrame{//jframe상속받음. 쥐유아이 파트

	DefaultMutableTreeNode root = new DefaultMutableTreeNode("Student");//jtree에 넣을 루트노드와 자식노드,부모노드들 선언
	DefaultMutableTreeNode comGong = new DefaultMutableTreeNode("컴퓨터공학부");
	DefaultMutableTreeNode jeonGong = new DefaultMutableTreeNode("전자공학과");
	DefaultMutableTreeNode gyungGong = new DefaultMutableTreeNode("경영학과");
	DefaultMutableTreeNode one = new DefaultMutableTreeNode("1학년");
	DefaultMutableTreeNode two = new DefaultMutableTreeNode("2학년");
	DefaultMutableTreeNode three = new DefaultMutableTreeNode("3학년");
	DefaultMutableTreeNode four = new DefaultMutableTreeNode("4학년");
	DefaultMutableTreeNode jeonOne = new DefaultMutableTreeNode("1학년");
	DefaultMutableTreeNode jeonTwo = new DefaultMutableTreeNode("2학년");
	DefaultMutableTreeNode jeonThree = new DefaultMutableTreeNode("3학년");
	DefaultMutableTreeNode jeonFour = new DefaultMutableTreeNode("4학년");
	DefaultMutableTreeNode gyungOne = new DefaultMutableTreeNode("1학년");
	DefaultMutableTreeNode gyungTwo = new DefaultMutableTreeNode("2학년");
	DefaultMutableTreeNode gyungThree = new DefaultMutableTreeNode("3학년");
	DefaultMutableTreeNode gyungFour = new DefaultMutableTreeNode("4학년");
	
	String value3 = null;//데이터베이스에서 읽어와서 jtable에 추가하기 위한 변수
	
	String sID=null;
	String sName = null;
	String sSex = null;
	String sYear = null;
	String sDeID = null;
	String sGrade = null;  //데이터베이스에서 읽어온 각 데이터를 저장할 변수 선언
	String dName = null;
	String cSub1 = null;
	String cSub2 = null;
	String cSub3 = null;
	
	JTree rootTree = new JTree(root);//roottree에 jtree생성
	JScrollPane scroll = new JScrollPane(rootTree);
	JTable table;//jtable 선언
	Vector<String>Title = new Vector<String>();//jtable에 타이틀에 넣기위한 벡터 선언
	DefaultTableModel model;//엘리멘츠를 그떄마다 넣어주기위해 모델 선언
	Vector<String>userRow;//각 행에 들어갈 원소들 넣을 벡터

	JLabel jName = new JLabel("이름:");
	JLabel jName2=new JLabel();
	JLabel jSex = new JLabel("성별:");
	JLabel jSex2=new JLabel();
	JLabel jYear = new JLabel("생년월일:");
	JLabel jYear2=new JLabel();
	JLabel jStudentID = new JLabel("학번:");
	JLabel jStudentID2=new JLabel();		//JLable을 미리 값을 넣어놓은 것과나중에 변수를 받아서 집어넣을 변수 선언.
	JLabel jDepartmentName= new JLabel("과:");
	JLabel jDepartmentName2=new JLabel();
	JLabel jLv= new JLabel("학년:");
	JLabel jLv2=new JLabel();
	JLabel jClass= new JLabel("수강과목:");
	JLabel jClass2=new JLabel();
	JLabel jClass3=new JLabel();
	JLabel jClass4=new JLabel();
	
	JTextField tf = new JTextField();
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();	//삽입할때 어떤 것을 삽입할 것인가 넣어주는 텍스트필드
	JTextField tf4 = new JTextField();
	JTextField tf5 = new JTextField();
	JTextField tf6 = new JTextField();
	
	String tfF =null;
	String tfF1 =null;
	String tfF2 =null;//텍스트 필드에 있는 값 받아주기 위한 변수.
	String tfF3 =null;
	String tfF4 =null;
	String tfF5 =null;
	

	JTextField tfF6 = new JTextField();
	JTextField tfF7 = new JTextField();
	JTextField tfF8 = new JTextField();
	JTextField tfF9 = new JTextField();		//수정파트 텍스트필드
	JTextField tfF10 = new JTextField();
	JTextField tfF11= new JTextField();
	
	JButton ok = new JButton("OK");//수정 완료를 묻기 위해 ok버튼 생성
	JButton inS = new JButton("INSERT");//삽입 버튼 생성
	JButton deL = new JButton("DELETE");//삭제버튼 생성
	JButton up = new JButton("UPDATE");//수정버튼생성
	Container cp = getContentPane();//컴포넌트를 넣을 컨테이너 
	
	
	GuiPart(){
		setTitle("학생 관리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//gui가 종료를 누르면 프로그렘이 종료댐
		cp.setLayout(null);//레이아웃 관리자를 널로 표현함으로 좌표지정으로 인해 각 컴포넌트를 원하는 좌표에 삽입가능
		
		root.add(comGong);
		root.add(jeonGong); 	//컴퓨터 공학, 전자공학, 경영학 카테고리 추가
		root.add(gyungGong);
		
		comGong.add(one);
		comGong.add(two);	//컴퓨터 공학과 1234학년 넣음.
		comGong.add(three);
		comGong.add(four);
		
		jeonGong.add(jeonOne);
		jeonGong.add(jeonTwo);
		jeonGong.add(jeonThree);	//전자공학과 1234학년 넣음.
		jeonGong.add(jeonFour);
		
		gyungGong.add(gyungOne);
		gyungGong.add(gyungTwo);	//경영학과 1234학년 넣음.
		gyungGong.add(gyungThree);
		gyungGong.add(gyungFour);
		
		rootTree.setLocation(5,8);//jtree 위치 선언부
		rootTree.setSize(150,250);
		
		cp.add(rootTree);//jtree 추가.
		
		Title.addElement("이름");//타이틀 벡터에 jtable 열 제목을넣어줌..
		Title.addElement("학번");
		
		model = new DefaultTableModel(Title,0);//모델에 타이틀과 0 넣어줌.
		table = new JTable(model);//테이블에 열제목이 들어간 모델 넣어 생성
		table.setLocation(5,280);//테이블 위치와 사이즈 지정
		table.setSize(150,250);
		cp.add(table);//테이블 추가
	
		
		model.addRow(Title);//jtable에 타이틀  추가
	
		deL.setLocation(200,350);//삭제버튼 위치 사이즈 설정
		deL.setSize(100,50);
		
		up.setLocation(200,400); // 업데이트 버튼 위치와 사이즈 설정
		up.setSize(100,50);
		
		inS.setLocation(200,450);//삽입 버튼 위치와 사이즈 설정
		inS.setSize(100,50);
		
		tf.setLocation(350,460); 
		tf.setSize(50,20);
		tf1.setLocation(400,460);
		tf1.setSize(50,20);
		tf2.setLocation(450,460);//삽입하고 싶은 이름,성별등을 쓰는 텍스트 필드 사이즈와 위치 지정
		tf2.setSize(50,20);
		tf3.setLocation(500,460);
		tf3.setSize(50,20);
		tf4.setLocation(550,460);
		tf4.setSize(50,20);
		tf5.setLocation(600,460);
		tf5.setSize(50,20);
		
		cp.add(tf);
		cp.add(tf1);
		cp.add(tf2); // 텍스트필드 추가.
		cp.add(tf3);
		cp.add(tf4);
		cp.add(tf5);
	
		cp.add(inS);
		cp.add(deL);//삽입,수정,삭제 버튼 추가 
		cp.add(up);
		
		jName.setLocation(250,5);
		jName.setSize(200,30);
		jSex.setLocation(250,50);
		jSex.setSize(200,30);
		jStudentID.setLocation(250,100);
		jStudentID.setSize(200,30);
		jYear.setLocation(250,150);				//학생에대한 모든 정보를 띄우기 위해 필요한 요소들 위치와 사이즈 지정
		jYear.setSize(200,30);
		jDepartmentName.setLocation(250,200);
		jDepartmentName.setSize(200,30);
		jLv.setLocation(250,250);
		jLv.setSize(200,30);
		jClass.setLocation(250,300);
		jClass.setSize(200,30);
		
		cp.add(jName);
		cp.add(jSex);
		cp.add(jStudentID);// 이름 성별 학번 나이 과아이디 학년 수강과목 추가.
		cp.add(jYear);
		cp.add(jDepartmentName);
		cp.add(jLv);
		cp.add(jClass);
		
		
		rootTree.addMouseListener(new MyMouseListener());
		table.addMouseListener(new MyMouseListener2());
		deL.addActionListener(new MyActionListener()); // 수정,삽입,삭제 , 테이블, 트리에 대한 각각의 이벤트를 추가.
		inS.addActionListener(new MyActionListener());
		up.addActionListener(new MyActionListener());
		
		
		setSize(1000,600);//컨테이너 크기 설정 
		setVisible(true);//펄스를주면안보임
	
	}
	
	class MyMouseListener implements MouseListener{//트리에 대한 마우스 리스너
		
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseClicked(MouseEvent e1) {
			MutableTreeNode node = (MutableTreeNode)rootTree.getLastSelectedPathComponent();//트리의 어떤 노드가 클릭되었는지 읽어옴.		
			String URL = "jdbc:mysql://localhost/university?serverTimezone=Asia/Seoul";//로컬호스트부분 : 컴퓨터 주소 .채팅서비스라는 시스템 사용
			//서비스타임존 아시아 서울 : 시간대 설정
			Connection con = null; //연결 객체
			Statement stmt = null; //어떤 일을 시킬건지 정의하는 객체 ex)삽입 삭제 검색 등 
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(Exception e5) {
				System.out.println(e5.toString());
			}
			try {//접근
				con= DriverManager.getConnection(URL, "root", "admin");//upl,아이디,비밀번호 sql에 사용하는 아이디 비밀번호사용
																//커넥션객체생성
				
				stmt = con.createStatement();//스테이트먼트객체생성
			
			}catch(Exception e9) {
				e9.printStackTrace();
			}
			if(node.equals(one)) {//컴공 1학년 데이터베이스에서 받아옴.
				try {
					ResultSet result = stmt.executeQuery("SELECT name,StudentID FROM student WHERE departmentID='c-1' AND grade=1");//질의 . 컴퓨터공학과학생이고 1학년
					while(result.next()) {
						userRow=new Vector<String>();//행추가
						String resultStr = result.getString("name");//이름과 학번 받아옴.
						String resultStr2=result.getString("StudentID");
						userRow.addElement(resultStr);//요소에 추가
						userRow.addElement(resultStr2);
						model.addRow(userRow);//테이블에 띄워줌.
					}
					
					stmt.close();//데이터베이스닫음.
					con.close();
				}catch(Exception e2) {
					System.out.println(e2.toString());
				}
		
			}
			else if(node.equals(two))//컴공 2학년 데이터베이스에서 받아옴
			{
				try {
					ResultSet result = stmt.executeQuery("SELECT name,StudentID FROM student WHERE departmentID='c-1' AND grade=2");//질의. 컴공과면서 2학년
					while(result.next()) {
						userRow=new Vector<String>();//행추가
						String resultStr = result.getString("name");//이름학번받아서 저장
						String resultStr2=result.getString("StudentID");
						userRow.addElement(resultStr);//요소에 추가
						userRow.addElement(resultStr2);
						model.addRow(userRow);//테이블에 띄움.
					}
					
					stmt.close();//데이터베이스닫음.
					con.close();
				}catch(Exception e2) {
					System.out.println(e2.toString());
				}
			}
			else if(node.equals(three))//컴공 3학년 db에서 받아옴
			{
				try {
					ResultSet result = stmt.executeQuery("SELECT name,StudentID FROM student WHERE departmentID='c-1' AND grade=3");//질의.컴공이면서 3학년
					while(result.next()) {
						userRow=new Vector<String>();//행추가
						String resultStr = result.getString("name");//이름 학번 받아옴
						String resultStr2=result.getString("StudentID");
						userRow.addElement(resultStr);//요소 추가
						userRow.addElement(resultStr2);
						model.addRow(userRow);//테이블에 띄움
					}
					
					stmt.close();//닫음
					con.close();
				}catch(Exception e2) {
					System.out.println(e2.toString());
				}
			}
			else if(node.equals(four))//컴공이며서 4학년 데이터베이스에서 받아옴 
			{
				try {
					ResultSet result = stmt.executeQuery("SELECT name,StudentID FROM student WHERE departmentID='c-1' AND grade=4");//질의.컴공이면서 4학년
					while(result.next()) {
						userRow=new Vector<String>();//행추가
						String resultStr = result.getString("name");//이름,학번 가져옴
						String resultStr2=result.getString("StudentID");
						userRow.addElement(resultStr);//요소추가
						userRow.addElement(resultStr2);
						model.addRow(userRow);//테이블에 추가
					}
					
					stmt.close();
					con.close();
				}catch(Exception e2) {
					System.out.println(e2.toString());
				}
			}
			else if(node.equals(jeonOne))//전자공학이면서 1학년 데이터베이스에서 가져옴
			{
				try {
					ResultSet result = stmt.executeQuery("SELECT name,StudentID FROM student WHERE departmentID='j-1' AND grade=1");//전자공이면서 1학년 질의
					while(result.next()) {
						userRow=new Vector<String>();//행추가
						String resultStr = result.getString("name");//이름
						String resultStr2=result.getString("StudentID");//학번
						userRow.addElement(resultStr);//요소추가
						userRow.addElement(resultStr2);
						model.addRow(userRow);//테이블에 띄움 
					}
					
					stmt.close();
					con.close();
				}catch(Exception e2) {
					System.out.println(e2.toString());
				}
				
			}
			else if(node.equals(jeonTwo))//전자공이면서 2학년 데베에서 가져옴
			{
				try {
					ResultSet result = stmt.executeQuery("SELECT name,StudentID FROM student WHERE departmentID='j-1' AND grade=2");//질의. 전자공이면서 2학년
					while(result.next()) {
						userRow=new Vector<String>();//행추가
						String resultStr = result.getString("name");//이름학번가져옴
						String resultStr2=result.getString("StudentID");
						userRow.addElement(resultStr);//요소추가
						userRow.addElement(resultStr2);
						model.addRow(userRow);//테이블에추가
					}
					
					stmt.close();
					con.close();
				}catch(Exception e2) {
					System.out.println(e2.toString());
				}
				
			}
			else if(node.equals(jeonThree))//전자공이면서 3학년 데베에서 가져옴
			{
				try {
					ResultSet result = stmt.executeQuery("SELECT name,StudentID FROM student WHERE departmentID='j-1' AND grade=3");//전자공이면서 3학년 질의
					while(result.next()) {
						userRow=new Vector<String>();//행추가
						String resultStr = result.getString("name");//이름 학번 가져옴
						String resultStr2=result.getString("StudentID");
						userRow.addElement(resultStr);//요소추가
						userRow.addElement(resultStr2);
						model.addRow(userRow);//테이블에 추가
					}
					
					stmt.close();
					con.close();
				}catch(Exception e2) {
					System.out.println(e2.toString());
				}
				
			}
			else if(node.equals(jeonFour))//전자공이면서 4학년
			{
				try {
					ResultSet result = stmt.executeQuery("SELECT name,StudentID FROM student WHERE departmentID='j-1' AND grade=4");//질의 전자공이면서 4학년
					while(result.next()) {
						userRow=new Vector<String>();//행추가
						String resultStr = result.getString("name");//이름 학번 받아옴
						String resultStr2=result.getString("StudentID");
						userRow.addElement(resultStr);
						userRow.addElement(resultStr2);//요소에 전달
						model.addRow(userRow);//테이블에 띄움
					}
					
					stmt.close();
					con.close();
				}catch(Exception e2) {
					System.out.println(e2.toString());
				}
				
			}
			else if(node.equals(gyungOne))//경영학과면서 1학년 데베에서 가져옴
			{
				try {
					ResultSet result = stmt.executeQuery("SELECT name,StudentID FROM student WHERE departmentID='g-1' AND grade=1");//질의 경영학과면서 1학년
					while(result.next()) {
						userRow=new Vector<String>();//행추가
						String resultStr = result.getString("name");//이름 학번 가져옴
						String resultStr2=result.getString("StudentID");
						userRow.addElement(resultStr);//요소 추가
						userRow.addElement(resultStr2);
						model.addRow(userRow);//테이블에 ㅊ가
					}
					
					stmt.close();
					con.close();
				}catch(Exception e2) {
					System.out.println(e2.toString());
				}
				
			}
			else if(node.equals(gyungTwo))//경영학과면서 2학년 데베에서 가져옴
			{
				try {
					ResultSet result = stmt.executeQuery("SELECT name,StudentID FROM student WHERE departmentID='g-1' AND grade=2");//경영학과면서2학년 질의
					while(result.next()) {
						userRow=new Vector<String>();//행추가
						String resultStr = result.getString("name");//이름과 학번 가져옴
						String resultStr2=result.getString("StudentID");
						userRow.addElement(resultStr);//요소 추가
						userRow.addElement(resultStr2);
						model.addRow(userRow);//테이블에 추가
					}
					
					stmt.close();
					con.close();
				}catch(Exception e2) {
					System.out.println(e2.toString());
				}
				
			}
			else if(node.equals(gyungThree))//경영학과면서 3학년 데베에서 가져옴
			{
				try {
					ResultSet result = stmt.executeQuery("SELECT name,StudentID FROM student WHERE departmentID='g-1' AND grade=3");//경영학이면서 3학년 질의
					while(result.next()) {
						userRow=new Vector<String>();//행추가
						String resultStr = result.getString("name");//이름 학번 가져옴
						String resultStr2=result.getString("StudentID");
						userRow.addElement(resultStr);//요소추가
						userRow.addElement(resultStr2);
						model.addRow(userRow);//테이블에추가
					}
					
					stmt.close();
					con.close();
				}catch(Exception e2) {
					System.out.println(e2.toString());
				}
				
			}
			else if(node.equals(gyungFour))//경영학이면서 4학년 데베에서 가져옴
			{
				try {
					ResultSet result = stmt.executeQuery("SELECT name,StudentID FROM student WHERE departmentID='g-1' AND grade=4");//질의 4학년이면서 경영학
					while(result.next()) {
						userRow=new Vector<String>();//행추가
						String resultStr = result.getString("name");//이름 학번 가져옴
						String resultStr2=result.getString("StudentID");
						userRow.addElement(resultStr);//요소추가
						userRow.addElement(resultStr2);
						model.addRow(userRow);//테이블에추가
					}
					
					stmt.close();
					con.close();
				}catch(Exception e2) {
					System.out.println(e2.toString());
				}
				
			}
		}

		@Override
		public void mouseEntered(MouseEvent e2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e3) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e4) {
			// TODO Auto-generated method stub
			
		}
	}	 
	class MyActionListener implements ActionListener{//삽입 삭제 수정 리스너
		public void actionPerformed(ActionEvent e6) {
			String cmd = e6.getActionCommand();
			String URL = "jdbc:mysql://localhost/university?serverTimezone=Asia/Seoul";//로컬호스트부분 : 컴퓨터 주소 .채팅서비스라는 시스템 사용
			//서비스타임존 아시아 서울 : 시간대 설정
			Connection con = null; //연결 객체
			Statement stmt = null; //어떤 일을 시킬건지 정의하는 객체 ex)삽입 삭제 검색 등 
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(Exception e5) {
				System.out.println(e5.toString());
			}
			try {//접근
				con= DriverManager.getConnection(URL, "root", "admin");//upl,아이디,비밀번호 sql에 사용하는 아이디 비밀번호사용
																//커넥션객체생성
				System.out.println("Connection ok");
				stmt = con.createStatement();//스테이트먼트객체생성
				
				System.out.println("OK2");
			}catch(Exception e2) {
				System.out.println(e2.toString());
			}
			switch(cmd) {
			case "INSERT" ://삽입
				tfF=tf.getText();
				tfF1=tf1.getText();
				tfF2=tf2.getText();
				tfF3=tf3.getText();//텍스트필드에있는값전부가져옴
				tfF4=tf4.getText();
				tfF5=tf5.getText();
				
				String in[]=new String[6];//테이블에 추가하기 위한 요소들만 따로 가져옴
				
				in[0] = tf1.getText();//넣어줌
				in[1] = tf.getText();
				try {//질의 각 해당하는 요소들 데이터베이스에 추가.
				stmt.executeUpdate("insert into student(StudentID,name,sex,year,departmentID,grade) values ('"+tfF+"','"+tfF1+"','"+tfF2+"','"+tfF3+"','"+tfF4+"','"+tfF5+"')");
				stmt.close();//데이터베이스닫음
				con.close();
				
				tf.setText("");
				tf1.setText("");
				tf2.setText("");//텍스트필드 초기화
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
				}catch(Exception a3) {
					a3.printStackTrace();
				}
				model.addRow(in);//테이블에 추가하기 위한 요소들 추가.
				
				
				break;
			
			case "DELETE" ://삭제
				
				int row = table.getSelectedRow();
				int column = table.getColumnCount();//삭제하기위한 학생의 학번을 가져오기위해 선언.
				String value2 = null;
				for(int i=0; i<column;i++)
				{
					Object value = table.getValueAt(row, i);//value2에 학번이 저장됨.
					System.out.println(value);
					value2=(String) value;
				}
			
				try {
					stmt.executeUpdate("delete from student where StudentID='"+value2+"'");//질의 학번을 가지고잇는 학생을 삭제.

					stmt.close();//데이터베이스 닫음.
					con.close();
				}catch(Exception a2) {
					a2.printStackTrace();
				}
	
					
					
				
				model.removeRow(table.getSelectedRow());//테이블에서 해당 학생 지움.
				break;
			
			case "UPDATE" ://수정
				ok.setLocation(800,450);//ok버튼 사이즈와 위치 지정 
				ok.setSize(100,100);
				
				cp.add(ok);
				int row1 = table.getSelectedRow();
				int column1 = table.getColumnCount();//학번을 가져오기위해 선언
				
				for(int i=0; i<column1;i++)
				{
					Object value = table.getValueAt(row1, i);//value3에 학번 가져옴.
					System.out.println(value);
					value3=(String) value;
				}
				//수정할거기 때문에 널로줌
				jName2.setText("");
				jSex2.setText("");
				jYear2.setText("");
				jDepartmentName2.setText("");
				jLv2.setText("");
				
				
				tfF6.setLocation(300,5);
				tfF6.setSize(200,30);
				tfF8.setLocation(300,50);
				tfF8.setSize(200,30);
				tfF9.setLocation(330,150);//수정해야하는 곳 jlabel에서 텍스트필드로바꿈.
				tfF9.setSize(200,30);
				tfF10.setLocation(300,200);
				tfF10.setSize(200,30);
				tfF11.setLocation(300,250);
				tfF11.setSize(200,30);
				
				cp.add(tfF6);
				cp.add(tfF7);
				cp.add(tfF8);
				cp.add(tfF9);//텍스트필드 컨텐츠펜에올림
				cp.add(tfF10);
				cp.add(tfF11);
				ok.addActionListener(new MyActionListener2());//ok버튼 이벤트
				
				break;
				
				
			
			}
			
		}
	}
	
	class MyMouseListener2 implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			int row = table.getSelectedRow();
			int column = table.getColumnCount();//학번알기위해선언
			String value2 = null;
			for(int i=0; i<column;i++)
			{
				Object value = table.getValueAt(row, i);
				System.out.println(value);//value2에 학번 들어감.
				value2=(String) value;
			}
		
				String URL = "jdbc:mysql://localhost/university?serverTimezone=Asia/Seoul";//로컬호스트부분 : 컴퓨터 주소 .채팅서비스라는 시스템 사용
				//서비스타임존 아시아 서울 : 시간대 설정
				Connection con = null; //연결 객체
				Statement stmt = null; //어떤 일을 시킬건지 정의하는 객체 ex)삽입 삭제 검색 등 
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				}catch(Exception e5) {
					System.out.println(e5.toString());
				}
				try {//접근
					con= DriverManager.getConnection(URL, "root", "admin");//upl,아이디,비밀번호 sql에 사용하는 아이디 비밀번호사용
																	//커넥션객체생성
					System.out.println("Connection ok");
					stmt = con.createStatement();//스테이트먼트객체생성
					
					System.out.println("OK2");//질의 선택된 학번의 학생의 모든 정보를 불러와라.
					ResultSet result = stmt.executeQuery("SELECT * FROM student s,department d,class c WHERE StudentID='"+value2+"'And s.departmentID=d.departmentID AND s.departmentID=c.departmentID");
					while(result.next()) {
						
						
							sID=result.getString("StudentID");
							sName = result.getString("name");
							sSex = result.getString("sex");
							sYear = result.getString("year");
							sDeID = result.getString("departmentID");//모든정보 변수에 저장
							sGrade = result.getString("grade");
							dName = result.getString("departmentname");
							cSub1 = result.getString("sub1");
							cSub2 = result.getString("sub2");
							cSub3 = result.getString("sub3");
						
					
					}
					
					cp.setVisible(false);
					
					jName2.setText(sName);
					jSex2.setText(sSex);
					jStudentID2.setText(sID);
					jYear2.setText(sYear);
					jDepartmentName2.setText(sDeID);//해당 변수에 받아온값저장
					jLv2.setText(sGrade);
					jClass2.setText(cSub1);
					jClass3.setText(cSub2);
					jClass4.setText(cSub3);
					
					jName2.setLocation(300,5);
					jName2.setSize(200,30);
					jSex2.setLocation(300,50);
					jSex2.setSize(200,30);
					jStudentID2.setLocation(300,100);
					jStudentID2.setSize(200,30);
					jYear2.setLocation(330,150);		//변수들의 위치 선언
					jYear2.setSize(200,30);
					jDepartmentName2.setLocation(300,200);
					jDepartmentName2.setSize(200,30);
					jLv2.setLocation(300,250);
					jLv2.setSize(200,30);
					jClass2.setLocation(330,300);
					jClass2.setSize(200,30);
					jClass3.setLocation(330,350);
					jClass3.setSize(200,30);
					jClass4.setLocation(330,400);
					jClass4.setSize(200,30);
					
					cp.add(jName2);
					cp.add(jSex2);
					cp.add(jStudentID2);
					cp.add(jYear2);				//컨텐츠펜에올림
					cp.add(jDepartmentName2);
					cp.add(jLv2);
					cp.add(jClass2);
					cp.add(jClass3);
					cp.add(jClass4);
					
					cp.setVisible(true);
					
					
					stmt.close();
					con.close();
				}catch(Exception e2) {
					System.out.println(e2.toString());
				}
		
			
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		}
	class MyActionListener2 implements ActionListener{//ok버튼의 이벤트 리스너
		public void actionPerformed(ActionEvent e7) {
			String cmd = e7.getActionCommand();
			switch (cmd) {
			case "OK" : //ok일때
				
				try {
					String URL = "jdbc:mysql://localhost/university?serverTimezone=Asia/Seoul";//로컬호스트부분 : 컴퓨터 주소 .채팅서비스라는 시스템 사용
					//서비스타임존 아시아 서울 : 시간대 설정
					Connection con = null; //연결 객체
					Statement stmt = null; //어떤 일을 시킬건지 정의하는 객체 ex)삽입 삭제 검색 등 
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					}catch(Exception e5) {
						System.out.println(e5.toString());
					}
					//접근
						con= DriverManager.getConnection(URL, "root", "admin");//upl,아이디,비밀번호 sql에 사용하는 아이디 비밀번호사용
																		//커넥션객체생성
						System.out.println("Connection ok");
						stmt = con.createStatement();//스테이트먼트객체생성
						
						System.out.println("OK2");
						//텍스트필드에 입력된 값으로 해당 요소들전부 수정함.
					stmt.executeUpdate("update student set name='"+tfF6.getText()+"',sex='"+tfF8.getText()+"',year='"+tfF9.getText()+"',departmentID='"+tfF10.getText()+"',grade='"+tfF11.getText()+"' where StudentID='"+value3+"'");
					tfF6.setVisible(false);
					tfF8.setVisible(false);
					tfF9.setVisible(false);//수정 후 텍스트 필드 안보이게 바꿈.
					tfF10.setVisible(false);
					tfF11.setVisible(false);
					jName2.setText(tfF6.getText());
					jSex2.setText(tfF8.getText());
					jYear2.setText(tfF9.getText());	//수정된 값들로 jlabel 교체
					jDepartmentName2.setText(tfF10.getText());
					jLv2.setText(tfF11.getText());
					stmt.close();
					con.close();
				}catch(Exception a3) {
					a3.printStackTrace();
				}
				break;
				
			}
		}
	
	}
}

	
	


	


