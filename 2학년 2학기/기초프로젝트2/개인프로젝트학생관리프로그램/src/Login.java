import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.*;


public class Login extends JFrame{
	JTextField tp1 = new JTextField();//���̵����� �ؽ�Ʈ�ʵ�
	JTextField tp2 = new JTextField();//��й�ȣ�� ���� �ؽ�Ʈ �ʵ�
	JButton login = new JButton("Login");//�α��ι�ư����
	JButton cancel = new JButton("Cancle");//�˽���ư����
	String tID=null;
	String tPass=null;
	Login(){
		setTitle("Login");//gui�̸� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ϸ� ���α׷��� ����
		Container L = getContentPane();//������Ʈ ��
		
		L.setBackground(Color.GREEN);//�������ҿ��� ������ �ٲ���.
		L.setLayout(null);//���̾ƿ� ������ ��
		JLabel Lla =new JLabel("ID");//�޼����ڽ��Է�
		Lla.setLocation(30,8);//��ġ�� ũ�� , �����̳ʿ� �����
		Lla.setSize(200,20);
		L.add(Lla);
		JLabel Lla1 =new JLabel("Password");//�޼����ڽ��Է�
		Lla1.setLocation(8,30);//��ġ�� ũ�� , �����̳ʿ� �����
		Lla1.setSize(200,20);
		L.add(Lla1);
		
		tp1.setLocation(80,8);//�ؽ�Ʈ�ʵ�κ�
		tp1.setSize(180,20);//��ġ�� ũ�� �����̳ʿ� �ø�
		L.add(tp1);
		
		tp2.setLocation(80,30);//�ؽ�Ʈ�ʵ�κ�
		tp2.setSize(180,20);//��ġ�� ũ�� �����̳ʿ� �ø�
		L.add(tp2);
		
		login.setLocation(8,60);//�α��ι�ư ��ġ�� ũ�� ,�����̳ʿ��÷���
		login.setSize(130,30);//
		L.add(login);
		
		cancel.setLocation(135,60);//�˽���ư ��ġ�� ũ�� �����̳ʿ��÷���.
		cancel.setSize(130,30);
		L.add(cancel);
		
		
		login.addActionListener(new BtnActionListener());//�α��� ��ư Ŭ���ϸ� �̺�Ʈ ����
		cancel.addActionListener(new BtnActionListener());//ĵ�������� ����
		setSize(300,150);//ũ��"
		setVisible(true);//�޽����ָ�Ⱥ���
	}
	
	class BtnActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();//cmd�� �޴��� �̺�Ʈ�� ����� ������
			
			switch(cmd) {//����ġ���� �̿��� �α��� ��ư ������ �α��� ����
			case "Login" : 
				tID=tp1.getText();
				tPass=tp2.getText();
				String URL = "jdbc:mysql://localhost/university?serverTimezone=Asia/Seoul";//����ȣ��Ʈ�κ� : ��ǻ�� �ּ� .ä�ü��񽺶�� �ý��� ���
			//����Ÿ���� �ƽþ� ���� : �ð��� ����
			Connection con = null; //���� ��ü
			Statement stmt = null; //� ���� ��ų���� �����ϴ� ��ü ex)���� ���� �˻� �� 
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(Exception e1) {
				System.out.println(e1.toString());
			}
			try {//����
				con= DriverManager.getConnection(URL, "root", "admin");//upl,���̵�,��й�ȣ sql�� ����ϴ� ���̵� ��й�ȣ���
																		//Ŀ�ؼǰ�ü����
				System.out.println("Connection ok");
				stmt = con.createStatement();//������Ʈ��Ʈ��ü����
			
				System.out.println("OK2");
				ResultSet result = stmt.executeQuery("SELECT * FROM login");//���� �α��ο� �ִ� ���� ������.
				int count=0;
				while(result.next()) {//���̵�� ��й�ȣ ������
					String resultStr = result.getString("id");
					String resultStr2=result.getString("password");
					if(tID.equals(resultStr)&&tPass.equals(resultStr2))//������ ���̵� ��й�ȣ�� �ۼ��� ���̵� ��й�ȣ�� ������ 
					{
						GuiPart gui = new GuiPart();//�������� ����.
						
						break;
					}
					
				
				}
				
				stmt.close();
				con.close();
			}catch(Exception e2) {
				System.out.println(e2.toString());
			}
			break;
							
			case "Cancle" : //�α׾ƿ� ������ ���� �����Ǵ� �� ���̵� ����
				System.exit(1);//�α׾ƿ�
			
			
		}
}
}
}
