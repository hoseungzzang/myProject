// ��ǻ�� ���а� 2015244071 ��ȣ��
// ���� ������Ʈ 
import java.awt.*;//gui,����,�̺�Ʈ sql�����ϱ� ���� ����
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
public class GuiPart extends JFrame{//jframe��ӹ���. �������� ��Ʈ

	DefaultMutableTreeNode root = new DefaultMutableTreeNode("Student");//jtree�� ���� ��Ʈ���� �ڽĳ��,�θ���� ����
	DefaultMutableTreeNode comGong = new DefaultMutableTreeNode("��ǻ�Ͱ��к�");
	DefaultMutableTreeNode jeonGong = new DefaultMutableTreeNode("���ڰ��а�");
	DefaultMutableTreeNode gyungGong = new DefaultMutableTreeNode("�濵�а�");
	DefaultMutableTreeNode one = new DefaultMutableTreeNode("1�г�");
	DefaultMutableTreeNode two = new DefaultMutableTreeNode("2�г�");
	DefaultMutableTreeNode three = new DefaultMutableTreeNode("3�г�");
	DefaultMutableTreeNode four = new DefaultMutableTreeNode("4�г�");
	DefaultMutableTreeNode jeonOne = new DefaultMutableTreeNode("1�г�");
	DefaultMutableTreeNode jeonTwo = new DefaultMutableTreeNode("2�г�");
	DefaultMutableTreeNode jeonThree = new DefaultMutableTreeNode("3�г�");
	DefaultMutableTreeNode jeonFour = new DefaultMutableTreeNode("4�г�");
	DefaultMutableTreeNode gyungOne = new DefaultMutableTreeNode("1�г�");
	DefaultMutableTreeNode gyungTwo = new DefaultMutableTreeNode("2�г�");
	DefaultMutableTreeNode gyungThree = new DefaultMutableTreeNode("3�г�");
	DefaultMutableTreeNode gyungFour = new DefaultMutableTreeNode("4�г�");
	
	String value3 = null;//�����ͺ��̽����� �о�ͼ� jtable�� �߰��ϱ� ���� ����
	
	String sID=null;
	String sName = null;
	String sSex = null;
	String sYear = null;
	String sDeID = null;
	String sGrade = null;  //�����ͺ��̽����� �о�� �� �����͸� ������ ���� ����
	String dName = null;
	String cSub1 = null;
	String cSub2 = null;
	String cSub3 = null;
	
	JTree rootTree = new JTree(root);//roottree�� jtree����
	JScrollPane scroll = new JScrollPane(rootTree);
	JTable table;//jtable ����
	Vector<String>Title = new Vector<String>();//jtable�� Ÿ��Ʋ�� �ֱ����� ���� ����
	DefaultTableModel model;//���������� �׋����� �־��ֱ����� �� ����
	Vector<String>userRow;//�� �࿡ �� ���ҵ� ���� ����

	JLabel jName = new JLabel("�̸�:");
	JLabel jName2=new JLabel();
	JLabel jSex = new JLabel("����:");
	JLabel jSex2=new JLabel();
	JLabel jYear = new JLabel("�������:");
	JLabel jYear2=new JLabel();
	JLabel jStudentID = new JLabel("�й�:");
	JLabel jStudentID2=new JLabel();		//JLable�� �̸� ���� �־���� �Ͱ����߿� ������ �޾Ƽ� ������� ���� ����.
	JLabel jDepartmentName= new JLabel("��:");
	JLabel jDepartmentName2=new JLabel();
	JLabel jLv= new JLabel("�г�:");
	JLabel jLv2=new JLabel();
	JLabel jClass= new JLabel("��������:");
	JLabel jClass2=new JLabel();
	JLabel jClass3=new JLabel();
	JLabel jClass4=new JLabel();
	
	JTextField tf = new JTextField();
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();	//�����Ҷ� � ���� ������ ���ΰ� �־��ִ� �ؽ�Ʈ�ʵ�
	JTextField tf4 = new JTextField();
	JTextField tf5 = new JTextField();
	JTextField tf6 = new JTextField();
	
	String tfF =null;
	String tfF1 =null;
	String tfF2 =null;//�ؽ�Ʈ �ʵ忡 �ִ� �� �޾��ֱ� ���� ����.
	String tfF3 =null;
	String tfF4 =null;
	String tfF5 =null;
	

	JTextField tfF6 = new JTextField();
	JTextField tfF7 = new JTextField();
	JTextField tfF8 = new JTextField();
	JTextField tfF9 = new JTextField();		//������Ʈ �ؽ�Ʈ�ʵ�
	JTextField tfF10 = new JTextField();
	JTextField tfF11= new JTextField();
	
	JButton ok = new JButton("OK");//���� �ϷḦ ���� ���� ok��ư ����
	JButton inS = new JButton("INSERT");//���� ��ư ����
	JButton deL = new JButton("DELETE");//������ư ����
	JButton up = new JButton("UPDATE");//������ư����
	Container cp = getContentPane();//������Ʈ�� ���� �����̳� 
	
	
	GuiPart(){
		setTitle("�л� ���� ���α׷�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//gui�� ���Ḧ ������ ���α׷��� �����
		cp.setLayout(null);//���̾ƿ� �����ڸ� �η� ǥ�������� ��ǥ�������� ���� �� ������Ʈ�� ���ϴ� ��ǥ�� ���԰���
		
		root.add(comGong);
		root.add(jeonGong); 	//��ǻ�� ����, ���ڰ���, �濵�� ī�װ� �߰�
		root.add(gyungGong);
		
		comGong.add(one);
		comGong.add(two);	//��ǻ�� ���а� 1234�г� ����.
		comGong.add(three);
		comGong.add(four);
		
		jeonGong.add(jeonOne);
		jeonGong.add(jeonTwo);
		jeonGong.add(jeonThree);	//���ڰ��а� 1234�г� ����.
		jeonGong.add(jeonFour);
		
		gyungGong.add(gyungOne);
		gyungGong.add(gyungTwo);	//�濵�а� 1234�г� ����.
		gyungGong.add(gyungThree);
		gyungGong.add(gyungFour);
		
		rootTree.setLocation(5,8);//jtree ��ġ �����
		rootTree.setSize(150,250);
		
		cp.add(rootTree);//jtree �߰�.
		
		Title.addElement("�̸�");//Ÿ��Ʋ ���Ϳ� jtable �� �������־���..
		Title.addElement("�й�");
		
		model = new DefaultTableModel(Title,0);//�𵨿� Ÿ��Ʋ�� 0 �־���.
		table = new JTable(model);//���̺� �������� �� �� �־� ����
		table.setLocation(5,280);//���̺� ��ġ�� ������ ����
		table.setSize(150,250);
		cp.add(table);//���̺� �߰�
	
		
		model.addRow(Title);//jtable�� Ÿ��Ʋ  �߰�
	
		deL.setLocation(200,350);//������ư ��ġ ������ ����
		deL.setSize(100,50);
		
		up.setLocation(200,400); // ������Ʈ ��ư ��ġ�� ������ ����
		up.setSize(100,50);
		
		inS.setLocation(200,450);//���� ��ư ��ġ�� ������ ����
		inS.setSize(100,50);
		
		tf.setLocation(350,460); 
		tf.setSize(50,20);
		tf1.setLocation(400,460);
		tf1.setSize(50,20);
		tf2.setLocation(450,460);//�����ϰ� ���� �̸�,�������� ���� �ؽ�Ʈ �ʵ� ������� ��ġ ����
		tf2.setSize(50,20);
		tf3.setLocation(500,460);
		tf3.setSize(50,20);
		tf4.setLocation(550,460);
		tf4.setSize(50,20);
		tf5.setLocation(600,460);
		tf5.setSize(50,20);
		
		cp.add(tf);
		cp.add(tf1);
		cp.add(tf2); // �ؽ�Ʈ�ʵ� �߰�.
		cp.add(tf3);
		cp.add(tf4);
		cp.add(tf5);
	
		cp.add(inS);
		cp.add(deL);//����,����,���� ��ư �߰� 
		cp.add(up);
		
		jName.setLocation(250,5);
		jName.setSize(200,30);
		jSex.setLocation(250,50);
		jSex.setSize(200,30);
		jStudentID.setLocation(250,100);
		jStudentID.setSize(200,30);
		jYear.setLocation(250,150);				//�л������� ��� ������ ���� ���� �ʿ��� ��ҵ� ��ġ�� ������ ����
		jYear.setSize(200,30);
		jDepartmentName.setLocation(250,200);
		jDepartmentName.setSize(200,30);
		jLv.setLocation(250,250);
		jLv.setSize(200,30);
		jClass.setLocation(250,300);
		jClass.setSize(200,30);
		
		cp.add(jName);
		cp.add(jSex);
		cp.add(jStudentID);// �̸� ���� �й� ���� �����̵� �г� �������� �߰�.
		cp.add(jYear);
		cp.add(jDepartmentName);
		cp.add(jLv);
		cp.add(jClass);
		
		
		rootTree.addMouseListener(new MyMouseListener());
		table.addMouseListener(new MyMouseListener2());
		deL.addActionListener(new MyActionListener()); // ����,����,���� , ���̺�, Ʈ���� ���� ������ �̺�Ʈ�� �߰�.
		inS.addActionListener(new MyActionListener());
		up.addActionListener(new MyActionListener());
		
		
		setSize(1000,600);//�����̳� ũ�� ���� 
		setVisible(true);//�޽����ָ�Ⱥ���
	
	}
	
	class MyMouseListener implements MouseListener{//Ʈ���� ���� ���콺 ������
		
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseClicked(MouseEvent e1) {
			MutableTreeNode node = (MutableTreeNode)rootTree.getLastSelectedPathComponent();//Ʈ���� � ��尡 Ŭ���Ǿ����� �о��.		
			String URL = "jdbc:mysql://localhost/university?serverTimezone=Asia/Seoul";//����ȣ��Ʈ�κ� : ��ǻ�� �ּ� .ä�ü��񽺶�� �ý��� ���
			//����Ÿ���� �ƽþ� ���� : �ð��� ����
			Connection con = null; //���� ��ü
			Statement stmt = null; //� ���� ��ų���� �����ϴ� ��ü ex)���� ���� �˻� �� 
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(Exception e5) {
				System.out.println(e5.toString());
			}
			try {//����
				con= DriverManager.getConnection(URL, "root", "admin");//upl,���̵�,��й�ȣ sql�� ����ϴ� ���̵� ��й�ȣ���
																//Ŀ�ؼǰ�ü����
				
				stmt = con.createStatement();//������Ʈ��Ʈ��ü����
			
			}catch(Exception e9) {
				e9.printStackTrace();
			}
			if(node.equals(one)) {//�İ� 1�г� �����ͺ��̽����� �޾ƿ�.
				try {
					ResultSet result = stmt.executeQuery("SELECT name,StudentID FROM student WHERE departmentID='c-1' AND grade=1");//���� . ��ǻ�Ͱ��а��л��̰� 1�г�
					while(result.next()) {
						userRow=new Vector<String>();//���߰�
						String resultStr = result.getString("name");//�̸��� �й� �޾ƿ�.
						String resultStr2=result.getString("StudentID");
						userRow.addElement(resultStr);//��ҿ� �߰�
						userRow.addElement(resultStr2);
						model.addRow(userRow);//���̺� �����.
					}
					
					stmt.close();//�����ͺ��̽�����.
					con.close();
				}catch(Exception e2) {
					System.out.println(e2.toString());
				}
		
			}
			else if(node.equals(two))//�İ� 2�г� �����ͺ��̽����� �޾ƿ�
			{
				try {
					ResultSet result = stmt.executeQuery("SELECT name,StudentID FROM student WHERE departmentID='c-1' AND grade=2");//����. �İ����鼭 2�г�
					while(result.next()) {
						userRow=new Vector<String>();//���߰�
						String resultStr = result.getString("name");//�̸��й��޾Ƽ� ����
						String resultStr2=result.getString("StudentID");
						userRow.addElement(resultStr);//��ҿ� �߰�
						userRow.addElement(resultStr2);
						model.addRow(userRow);//���̺� ���.
					}
					
					stmt.close();//�����ͺ��̽�����.
					con.close();
				}catch(Exception e2) {
					System.out.println(e2.toString());
				}
			}
			else if(node.equals(three))//�İ� 3�г� db���� �޾ƿ�
			{
				try {
					ResultSet result = stmt.executeQuery("SELECT name,StudentID FROM student WHERE departmentID='c-1' AND grade=3");//����.�İ��̸鼭 3�г�
					while(result.next()) {
						userRow=new Vector<String>();//���߰�
						String resultStr = result.getString("name");//�̸� �й� �޾ƿ�
						String resultStr2=result.getString("StudentID");
						userRow.addElement(resultStr);//��� �߰�
						userRow.addElement(resultStr2);
						model.addRow(userRow);//���̺� ���
					}
					
					stmt.close();//����
					con.close();
				}catch(Exception e2) {
					System.out.println(e2.toString());
				}
			}
			else if(node.equals(four))//�İ��̸缭 4�г� �����ͺ��̽����� �޾ƿ� 
			{
				try {
					ResultSet result = stmt.executeQuery("SELECT name,StudentID FROM student WHERE departmentID='c-1' AND grade=4");//����.�İ��̸鼭 4�г�
					while(result.next()) {
						userRow=new Vector<String>();//���߰�
						String resultStr = result.getString("name");//�̸�,�й� ������
						String resultStr2=result.getString("StudentID");
						userRow.addElement(resultStr);//����߰�
						userRow.addElement(resultStr2);
						model.addRow(userRow);//���̺� �߰�
					}
					
					stmt.close();
					con.close();
				}catch(Exception e2) {
					System.out.println(e2.toString());
				}
			}
			else if(node.equals(jeonOne))//���ڰ����̸鼭 1�г� �����ͺ��̽����� ������
			{
				try {
					ResultSet result = stmt.executeQuery("SELECT name,StudentID FROM student WHERE departmentID='j-1' AND grade=1");//���ڰ��̸鼭 1�г� ����
					while(result.next()) {
						userRow=new Vector<String>();//���߰�
						String resultStr = result.getString("name");//�̸�
						String resultStr2=result.getString("StudentID");//�й�
						userRow.addElement(resultStr);//����߰�
						userRow.addElement(resultStr2);
						model.addRow(userRow);//���̺� ��� 
					}
					
					stmt.close();
					con.close();
				}catch(Exception e2) {
					System.out.println(e2.toString());
				}
				
			}
			else if(node.equals(jeonTwo))//���ڰ��̸鼭 2�г� �������� ������
			{
				try {
					ResultSet result = stmt.executeQuery("SELECT name,StudentID FROM student WHERE departmentID='j-1' AND grade=2");//����. ���ڰ��̸鼭 2�г�
					while(result.next()) {
						userRow=new Vector<String>();//���߰�
						String resultStr = result.getString("name");//�̸��й�������
						String resultStr2=result.getString("StudentID");
						userRow.addElement(resultStr);//����߰�
						userRow.addElement(resultStr2);
						model.addRow(userRow);//���̺��߰�
					}
					
					stmt.close();
					con.close();
				}catch(Exception e2) {
					System.out.println(e2.toString());
				}
				
			}
			else if(node.equals(jeonThree))//���ڰ��̸鼭 3�г� �������� ������
			{
				try {
					ResultSet result = stmt.executeQuery("SELECT name,StudentID FROM student WHERE departmentID='j-1' AND grade=3");//���ڰ��̸鼭 3�г� ����
					while(result.next()) {
						userRow=new Vector<String>();//���߰�
						String resultStr = result.getString("name");//�̸� �й� ������
						String resultStr2=result.getString("StudentID");
						userRow.addElement(resultStr);//����߰�
						userRow.addElement(resultStr2);
						model.addRow(userRow);//���̺� �߰�
					}
					
					stmt.close();
					con.close();
				}catch(Exception e2) {
					System.out.println(e2.toString());
				}
				
			}
			else if(node.equals(jeonFour))//���ڰ��̸鼭 4�г�
			{
				try {
					ResultSet result = stmt.executeQuery("SELECT name,StudentID FROM student WHERE departmentID='j-1' AND grade=4");//���� ���ڰ��̸鼭 4�г�
					while(result.next()) {
						userRow=new Vector<String>();//���߰�
						String resultStr = result.getString("name");//�̸� �й� �޾ƿ�
						String resultStr2=result.getString("StudentID");
						userRow.addElement(resultStr);
						userRow.addElement(resultStr2);//��ҿ� ����
						model.addRow(userRow);//���̺� ���
					}
					
					stmt.close();
					con.close();
				}catch(Exception e2) {
					System.out.println(e2.toString());
				}
				
			}
			else if(node.equals(gyungOne))//�濵�а��鼭 1�г� �������� ������
			{
				try {
					ResultSet result = stmt.executeQuery("SELECT name,StudentID FROM student WHERE departmentID='g-1' AND grade=1");//���� �濵�а��鼭 1�г�
					while(result.next()) {
						userRow=new Vector<String>();//���߰�
						String resultStr = result.getString("name");//�̸� �й� ������
						String resultStr2=result.getString("StudentID");
						userRow.addElement(resultStr);//��� �߰�
						userRow.addElement(resultStr2);
						model.addRow(userRow);//���̺� ����
					}
					
					stmt.close();
					con.close();
				}catch(Exception e2) {
					System.out.println(e2.toString());
				}
				
			}
			else if(node.equals(gyungTwo))//�濵�а��鼭 2�г� �������� ������
			{
				try {
					ResultSet result = stmt.executeQuery("SELECT name,StudentID FROM student WHERE departmentID='g-1' AND grade=2");//�濵�а��鼭2�г� ����
					while(result.next()) {
						userRow=new Vector<String>();//���߰�
						String resultStr = result.getString("name");//�̸��� �й� ������
						String resultStr2=result.getString("StudentID");
						userRow.addElement(resultStr);//��� �߰�
						userRow.addElement(resultStr2);
						model.addRow(userRow);//���̺� �߰�
					}
					
					stmt.close();
					con.close();
				}catch(Exception e2) {
					System.out.println(e2.toString());
				}
				
			}
			else if(node.equals(gyungThree))//�濵�а��鼭 3�г� �������� ������
			{
				try {
					ResultSet result = stmt.executeQuery("SELECT name,StudentID FROM student WHERE departmentID='g-1' AND grade=3");//�濵���̸鼭 3�г� ����
					while(result.next()) {
						userRow=new Vector<String>();//���߰�
						String resultStr = result.getString("name");//�̸� �й� ������
						String resultStr2=result.getString("StudentID");
						userRow.addElement(resultStr);//����߰�
						userRow.addElement(resultStr2);
						model.addRow(userRow);//���̺��߰�
					}
					
					stmt.close();
					con.close();
				}catch(Exception e2) {
					System.out.println(e2.toString());
				}
				
			}
			else if(node.equals(gyungFour))//�濵���̸鼭 4�г� �������� ������
			{
				try {
					ResultSet result = stmt.executeQuery("SELECT name,StudentID FROM student WHERE departmentID='g-1' AND grade=4");//���� 4�г��̸鼭 �濵��
					while(result.next()) {
						userRow=new Vector<String>();//���߰�
						String resultStr = result.getString("name");//�̸� �й� ������
						String resultStr2=result.getString("StudentID");
						userRow.addElement(resultStr);//����߰�
						userRow.addElement(resultStr2);
						model.addRow(userRow);//���̺��߰�
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
	class MyActionListener implements ActionListener{//���� ���� ���� ������
		public void actionPerformed(ActionEvent e6) {
			String cmd = e6.getActionCommand();
			String URL = "jdbc:mysql://localhost/university?serverTimezone=Asia/Seoul";//����ȣ��Ʈ�κ� : ��ǻ�� �ּ� .ä�ü��񽺶�� �ý��� ���
			//����Ÿ���� �ƽþ� ���� : �ð��� ����
			Connection con = null; //���� ��ü
			Statement stmt = null; //� ���� ��ų���� �����ϴ� ��ü ex)���� ���� �˻� �� 
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(Exception e5) {
				System.out.println(e5.toString());
			}
			try {//����
				con= DriverManager.getConnection(URL, "root", "admin");//upl,���̵�,��й�ȣ sql�� ����ϴ� ���̵� ��й�ȣ���
																//Ŀ�ؼǰ�ü����
				System.out.println("Connection ok");
				stmt = con.createStatement();//������Ʈ��Ʈ��ü����
				
				System.out.println("OK2");
			}catch(Exception e2) {
				System.out.println(e2.toString());
			}
			switch(cmd) {
			case "INSERT" ://����
				tfF=tf.getText();
				tfF1=tf1.getText();
				tfF2=tf2.getText();
				tfF3=tf3.getText();//�ؽ�Ʈ�ʵ忡�ִ°����ΰ�����
				tfF4=tf4.getText();
				tfF5=tf5.getText();
				
				String in[]=new String[6];//���̺� �߰��ϱ� ���� ��ҵ鸸 ���� ������
				
				in[0] = tf1.getText();//�־���
				in[1] = tf.getText();
				try {//���� �� �ش��ϴ� ��ҵ� �����ͺ��̽��� �߰�.
				stmt.executeUpdate("insert into student(StudentID,name,sex,year,departmentID,grade) values ('"+tfF+"','"+tfF1+"','"+tfF2+"','"+tfF3+"','"+tfF4+"','"+tfF5+"')");
				stmt.close();//�����ͺ��̽�����
				con.close();
				
				tf.setText("");
				tf1.setText("");
				tf2.setText("");//�ؽ�Ʈ�ʵ� �ʱ�ȭ
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
				}catch(Exception a3) {
					a3.printStackTrace();
				}
				model.addRow(in);//���̺� �߰��ϱ� ���� ��ҵ� �߰�.
				
				
				break;
			
			case "DELETE" ://����
				
				int row = table.getSelectedRow();
				int column = table.getColumnCount();//�����ϱ����� �л��� �й��� ������������ ����.
				String value2 = null;
				for(int i=0; i<column;i++)
				{
					Object value = table.getValueAt(row, i);//value2�� �й��� �����.
					System.out.println(value);
					value2=(String) value;
				}
			
				try {
					stmt.executeUpdate("delete from student where StudentID='"+value2+"'");//���� �й��� �������մ� �л��� ����.

					stmt.close();//�����ͺ��̽� ����.
					con.close();
				}catch(Exception a2) {
					a2.printStackTrace();
				}
	
					
					
				
				model.removeRow(table.getSelectedRow());//���̺��� �ش� �л� ����.
				break;
			
			case "UPDATE" ://����
				ok.setLocation(800,450);//ok��ư ������� ��ġ ���� 
				ok.setSize(100,100);
				
				cp.add(ok);
				int row1 = table.getSelectedRow();
				int column1 = table.getColumnCount();//�й��� ������������ ����
				
				for(int i=0; i<column1;i++)
				{
					Object value = table.getValueAt(row1, i);//value3�� �й� ������.
					System.out.println(value);
					value3=(String) value;
				}
				//�����Ұű� ������ �η���
				jName2.setText("");
				jSex2.setText("");
				jYear2.setText("");
				jDepartmentName2.setText("");
				jLv2.setText("");
				
				
				tfF6.setLocation(300,5);
				tfF6.setSize(200,30);
				tfF8.setLocation(300,50);
				tfF8.setSize(200,30);
				tfF9.setLocation(330,150);//�����ؾ��ϴ� �� jlabel���� �ؽ�Ʈ�ʵ�ιٲ�.
				tfF9.setSize(200,30);
				tfF10.setLocation(300,200);
				tfF10.setSize(200,30);
				tfF11.setLocation(300,250);
				tfF11.setSize(200,30);
				
				cp.add(tfF6);
				cp.add(tfF7);
				cp.add(tfF8);
				cp.add(tfF9);//�ؽ�Ʈ�ʵ� �������濡�ø�
				cp.add(tfF10);
				cp.add(tfF11);
				ok.addActionListener(new MyActionListener2());//ok��ư �̺�Ʈ
				
				break;
				
				
			
			}
			
		}
	}
	
	class MyMouseListener2 implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			int row = table.getSelectedRow();
			int column = table.getColumnCount();//�й��˱����ؼ���
			String value2 = null;
			for(int i=0; i<column;i++)
			{
				Object value = table.getValueAt(row, i);
				System.out.println(value);//value2�� �й� ��.
				value2=(String) value;
			}
		
				String URL = "jdbc:mysql://localhost/university?serverTimezone=Asia/Seoul";//����ȣ��Ʈ�κ� : ��ǻ�� �ּ� .ä�ü��񽺶�� �ý��� ���
				//����Ÿ���� �ƽþ� ���� : �ð��� ����
				Connection con = null; //���� ��ü
				Statement stmt = null; //� ���� ��ų���� �����ϴ� ��ü ex)���� ���� �˻� �� 
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				}catch(Exception e5) {
					System.out.println(e5.toString());
				}
				try {//����
					con= DriverManager.getConnection(URL, "root", "admin");//upl,���̵�,��й�ȣ sql�� ����ϴ� ���̵� ��й�ȣ���
																	//Ŀ�ؼǰ�ü����
					System.out.println("Connection ok");
					stmt = con.createStatement();//������Ʈ��Ʈ��ü����
					
					System.out.println("OK2");//���� ���õ� �й��� �л��� ��� ������ �ҷ��Ͷ�.
					ResultSet result = stmt.executeQuery("SELECT * FROM student s,department d,class c WHERE StudentID='"+value2+"'And s.departmentID=d.departmentID AND s.departmentID=c.departmentID");
					while(result.next()) {
						
						
							sID=result.getString("StudentID");
							sName = result.getString("name");
							sSex = result.getString("sex");
							sYear = result.getString("year");
							sDeID = result.getString("departmentID");//������� ������ ����
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
					jDepartmentName2.setText(sDeID);//�ش� ������ �޾ƿ°�����
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
					jYear2.setLocation(330,150);		//�������� ��ġ ����
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
					cp.add(jYear2);				//�������濡�ø�
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
	class MyActionListener2 implements ActionListener{//ok��ư�� �̺�Ʈ ������
		public void actionPerformed(ActionEvent e7) {
			String cmd = e7.getActionCommand();
			switch (cmd) {
			case "OK" : //ok�϶�
				
				try {
					String URL = "jdbc:mysql://localhost/university?serverTimezone=Asia/Seoul";//����ȣ��Ʈ�κ� : ��ǻ�� �ּ� .ä�ü��񽺶�� �ý��� ���
					//����Ÿ���� �ƽþ� ���� : �ð��� ����
					Connection con = null; //���� ��ü
					Statement stmt = null; //� ���� ��ų���� �����ϴ� ��ü ex)���� ���� �˻� �� 
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					}catch(Exception e5) {
						System.out.println(e5.toString());
					}
					//����
						con= DriverManager.getConnection(URL, "root", "admin");//upl,���̵�,��й�ȣ sql�� ����ϴ� ���̵� ��й�ȣ���
																		//Ŀ�ؼǰ�ü����
						System.out.println("Connection ok");
						stmt = con.createStatement();//������Ʈ��Ʈ��ü����
						
						System.out.println("OK2");
						//�ؽ�Ʈ�ʵ忡 �Էµ� ������ �ش� ��ҵ����� ������.
					stmt.executeUpdate("update student set name='"+tfF6.getText()+"',sex='"+tfF8.getText()+"',year='"+tfF9.getText()+"',departmentID='"+tfF10.getText()+"',grade='"+tfF11.getText()+"' where StudentID='"+value3+"'");
					tfF6.setVisible(false);
					tfF8.setVisible(false);
					tfF9.setVisible(false);//���� �� �ؽ�Ʈ �ʵ� �Ⱥ��̰� �ٲ�.
					tfF10.setVisible(false);
					tfF11.setVisible(false);
					jName2.setText(tfF6.getText());
					jSex2.setText(tfF8.getText());
					jYear2.setText(tfF9.getText());	//������ ����� jlabel ��ü
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

	
	


	


