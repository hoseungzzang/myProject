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
public class Interface extends JFrame{//JFrame ��ӹ���. guiâ ����
	JTextField tp = new JTextField();//���� �޼����� �Է��ϱ� ���� �ؽ�Ʈ �ʵ� ����
	
	JButton send = new JButton("Send");//send��ư ����
	JButton login = new JButton("Login");//�α��ι�ư����
	JButton cancel = new JButton("Cancle");//�˽���ư����
	JButton find = new JButton("Find");//�˽���ư����
	JTextArea ta = new JTextArea();//ä�������̱����� �ý�Ʈ������
	JTextArea ta1 = new JTextArea();//����ڸ� ǥ���ϱ����� �ؽ�Ʈ������
	JMenuBar mb = new JMenuBar();//�޴��� ������ ���� ����
	JMenuItem item1=new JMenuItem("Login");//�޴��ٿ� �α����߰�
	JMenuItem item2=new JMenuItem("Logout");//�޴��ٿ� �α׾ƿ� �߰�
	JTextField tp1 = new JTextField();//���̵����� �ؽ�Ʈ�ʵ�
	JTextField tp2 = new JTextField();//��й�ȣ�� ���� �ؽ�Ʈ �ʵ�
	JTextField tp4 = new JTextField();//��й�ȣ�� ���� �ؽ�Ʈ �ʵ�
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
	String tID =null;//���̺��̽����� �ҷ��� ���̵�� �����ֱ� ���� ���̵� ����
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
	Interface(){//�������̽� ��ü ����
		setTitle("My Chatting V0.1");//gui ���� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//gui�� ���Ḧ ������ ���α׷��� �����
		Container cp = getContentPane();//������Ʈ�� ���� �����̳� 
		creatMenu();//�޴��� ���� �޼ҵ� ����
		
		
		
		
	cp.setBackground(Color.GREEN);//�������ҿ��� ������ �ٲ���.
	cp.setLayout(null);//���̾ƿ� �����ڸ� �η� ǥ�������� ��ǥ�������� ���� �� ������Ʈ�� ���ϴ� ��ǥ�� ���԰���

	JLabel la =new JLabel("Message box");//�޼����ڽ��Է�
	la.setLocation(5,8);//��ǥ
	la.setSize(200,20);//ũ��
	cp.add(la);//�����̳ʿ� �ø�
	JLabel la1 =new JLabel("Members");//�޼����ڽ��Է� ���� ����.
	la1.setLocation(250,8);
	la1.setSize(200,20);
	cp.add(la1);
	
	ta.setLocation(5,30);//�ؽ�Ʈ������κ� ��ǥ�� ũ��
	ta.setSize(240,230);//ũ��
	cp.add(ta);//�����̳ʿ��ø�
	
	il.setLocation(250,30);//���͵���
	il.setSize(120,230);
	cp.add(il);
	
	tp.setLocation(5,280);//�ؽ�Ʈ�ʵ�κ� ��ǥ�� ũ��, �����̳ʿ� �ø�
	tp.setSize(270,25);
	cp.add(tp);
	
	tp4.setLocation(5,310);//�ؽ�Ʈ�ʵ�κ� ��ǥ�� ũ��, �����̳ʿ� �ø�
	tp4.setSize(270,25);
	cp.add(tp4);
	
	send.setLocation(280,280);//�����ư ��ǥ�� ũ�� , �����̳ʿ� �÷���
	send.setSize(90,25);
	cp.add(send);
	
	find.setLocation(280,310);//�����ư ��ǥ�� ũ�� , �����̳ʿ� �÷���
	find.setSize(90,25);
	cp.add(find);
	
	
	send.addActionListener(new BtnActionListener());//�����ư �̺�Ʈ ����
	find.addActionListener(new BtnActionListener());//�˻���ư �̺�Ʈ ����
	setSize(400,450);//�����̳� ũ�� ���� 
	setVisible(true);//�޽����ָ�Ⱥ���
	}
	
	void creatMenu() {//�޴��� ���� �޼ҵ�
		JMenuItem [] menuItem = new JMenuItem[2];//�޴������� ���� ������� �������ֱ⋚���� 2�� ���ڷ���
		String[] itemTitle = {"Login","Logout"};//������ Ÿ��Ʋ �迭�� �α��ΰ� �α׾ƿ��� ��.
		JMenu screenMenu = new JMenu("Menu");//�޴��� �� ���� ������ ���� �Ҵ�.
		mb.add(screenMenu);//��ũ�� �Ŵ� �����̳ʿ� �ø�
		
		
		setJMenuBar(mb);//�޴��� �߰�
		MenuActionListener listener = new MenuActionListener();//�޴� �̺�Ʈ �ֱ����� �޴����Ǹ����� ����
		for(int i=0; i<menuItem.length;i++)//�޴��������� ����ִ� ����ŭ �ݺ�
		{
			menuItem[i]=new JMenuItem(itemTitle[i]);//������ Ÿ��Ʋ�� �ִ� �ΰ��� �޴����������� ����������.
			menuItem[i].addActionListener(listener);//i������ �迭�� �ִ� �޴������ۿ� �̺�Ʈ�� ������
			screenMenu.addSeparator();//�޴������� ���̿� �ٱ���
			screenMenu.add(menuItem[i]);//�޴��������� �޴��ٿ� �߰�
		}
		
	}
	class Log extends JFrame{//�α��� â�� ���� ���� ���� ���������� ���
		Log(){//log ��ü����
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
		
		setSize(300,150);//ũ��"
		setVisible(true);//�޽����ָ�Ⱥ���
		
		}
		
	}
	public static void main(String[] args) {
	Interface inter = new Interface();//�������̽� ��ü ����

	}

	class MenuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();//cmd�� �޴��� �̺�Ʈ�� ����� ������
			switch(cmd) {//����ġ���� �̿��� �α��� ��ư ������ �α��� ����
			case "Login" : Log log = new Log(); //�α� Ŭ���� ���� ���
		
			
			
			break;
							
			case "Logout" : //�α׾ƿ� ������ ���� �����Ǵ� �� ���̵� ����
				try {
				dataOutStream.writeUTF("!"+"/"+id); // !�� ���� ���̵����� �ĺ��ϱ� ���� ����, /�� �ڸ������� , ���̵�� ������ ���̵�
				System.exit(1);//�α׾ƿ�
				
				break;
				}catch(Exception e3)
				{
					System.out.println(e.getSource());
				}
	
			}
			
			
		}
}
	class BtnActionListener implements ActionListener{//��ư �̺�Ʈ ��Ʈ
	
		String password="";//��й�ȣ �ʱ�ȭ
		public void actionPerformed(ActionEvent e) {
		

			JButton b =  (JButton)e.getSource();
			String btnCho = b.getText();//��ư�� �������� ���� �޾���.
			if(btnCho=="Login") {
				
			
			File dfile = new File("./user.txt");//�������� ����
			
			id = tp1.getText();//���̵� ���̵� �ؽ�Ʈ�ʵ忡�ִ� ���� ������
			password = tp2.getText();//��й�ȣ�� ��й�ȣ �ؽ�Ʈ�ʵ忡�ִ¹��� ������
			  String da="";//���Ͽ��ִ� ����Ÿ ������������ ����
			  try {
				
				  FileReader filereader = new FileReader(dfile);
				  BufferedReader dreader = new BufferedReader(filereader);//euc-kr���� ����Ÿ������ ������.���پ�����.
				  while((da = dreader.readLine())!=null) {//������ ������ �о��.
				
					String da1[] =da.split("/");//split���� /�� �������� ���ķ� ������ da1�� �迭�� �־���.
					try {
						
						tID=tp4.getText();
						String URL = "jdbc:mysql://localhost/friend?serverTimezone=Asia/Seoul";//����ȣ��Ʈ�κ� : ��ǻ�� �ּ� .ä�ü��񽺶�� �ý��� ���
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
							ResultSet result = stmt.executeQuery("SELECT * FROM friend.login");//friend�� �ִ� ���� ������.
							int count=0;
							while(result.next()) {//���̵�� ��й�ȣ ������
								 resultStr = result.getString("id");//���̵� ��� ������
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
					if(resultStr.equals(id)&&resultStr2.equals(password)==true) {//da10���� �迭�� id�� ���Ͽ� ���̰�, da1 1���� �迭�� �н����带 ���Ͽ� ���϶��� ����
						ta.setText("�α��� ����");//�ؽ�Ʈ ����� �α��μ��� �޼��� ���
						
						 try {
							 mySocket = new Socket("localhost",12345);//���� ����
							 System.out.println("Client> ������ ����Ǿ����ϴ�.");	
							 msgListener = new MessageListener(mySocket);//msgListener�� ���� ���ڷ� �Ѱ���
							 
							 outStream = mySocket.getOutputStream();
							 dataOutStream = new DataOutputStream(outStream);
							
							
							 msgListener.start();//�� �޼ҵ� ����
							 dataOutStream.writeUTF("joo"+"/"+id);//�ĺ��ϱ����� �ڵ� JOO�� �ڸ��� ���� / ���̵� ����.
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
						ta.setText("�α��� ����");
					}
				
					
				  }
			  
				 
			  	}catch(IOException a) {
				  a.printStackTrace();
			  }
			
			}
			
			else if(btnCho=="Send")//�����ư �̺�Ʈ
			{
				try {
				
				
				outStream =mySocket.getOutputStream();
				
				dataOutStream = new DataOutputStream(outStream);
				String tpl = tp.getText();//�ؽ�Ʈ �ʵ忡 �ִ� �� TPL�� �־���
				
				dataOutStream.writeUTF(tpl);//������ ������
				
				}catch(Exception a) {
				System.out.println(a.toString());	
				}
			
			}
			else if(btnCho=="Find")//�����ư �̺�Ʈ
			{
				try {
				
					tID=tp4.getText();
					String URL = "jdbc:mysql://localhost/friend?serverTimezone=Asia/Seoul";//����ȣ��Ʈ�κ� : ��ǻ�� �ּ� .ä�ü��񽺶�� �ý��� ���
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
						ResultSet result = stmt.executeQuery("SELECT id FROM friend.cid");//friend�� �ִ� ���� ������.
						int count=0;
						while(result.next()) {//���̵�� ��й�ȣ ������
							String resultStr = result.getString("id");
							
							if(tID.equals(resultStr))//������ ���̵� �� �ۼ��� ���̵�  ������ 
							{
								
								ta.setText(tID+"���� ģ���� �½��ϴ�.");//�ؽ�Ʈ ����� ���
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
	
	

	class MessageListener extends Thread{//������ ���
		Socket socket;//����
		InputStream inStream;//�������� ���� �� �޾��ֱ� ����.
		
		DataInputStream dataInStream;//�޾ƿ��� ���� ������ȭ���Ѽ� �޾���.
		OutputStream outStream;//������ �����ֱ� ���� �� 
		DataOutputStream dataOutStream;//���� ���� ������ȭ ��Ű������
		
		
		MessageListener(Socket _s){//_s�� ���ڷ� ���� ������ ����
			this.socket = _s;//Ŭ���� ����Ʈ Ŭ���̾�Ʈ�� ���Ͽ� _s ���ڷ� ���� ������ ����.
		}
		public void run() {
			try {
			
				inStream = this.socket.getInputStream();
				dataInStream = new DataInputStream(inStream);
				

				
				
				while(true) {//���ѹݺ��� ���鼭 
				
				//String msg=dataInStream.readUTF();
				//System.out.println("Client> "+msg);
					
				String msg=dataInStream.readUTF();//�������� ���°� ����
				String line[] = msg.split("/");// /�� �������� �ڸ�
				
				
				if(line[0].equals("joo"))//���� 0�� JOO�̸� ���̵�
				{
					String ids[] = line[1].split("@");//���̵� �ĺ��ϱ� ���� @�� �ڸ��� ����
					lim.removeAllElements();//��� ������Ʈ ����
					for(int n=1; n<ids.length; n++) {//���̵� �迭�� ���̸�ŭ �ݺ�
						
							lim.insertElementAt(ids[n],n-1);//JLIST�� �ø� ���ڸ� DEFAULTLISTMODEL�� �ް� �ε��� �迭�� ���� �߰��� �ε�����ȣ �߰�
							il.setModel(lim);//JLIST�� �ø�
					}
					
					
				}
				else {//�ؽ�Ʈ�� ���
				textL = textL+"\n"+msg;//�޼����� �߰��Ǹ� �����ǹǷ� ���� ���ϰ� ����� ����
				ta.setText(textL);//�ؽ�Ʈ ����� �ø�
				
				}
				
				}
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}


		
}



