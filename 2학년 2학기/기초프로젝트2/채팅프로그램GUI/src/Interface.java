import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;

import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Interface extends JFrame{//JFrame ��ӹ���. guiâ ����
	JTextField tp = new JTextField();//���� �޼����� �Է��ϱ� ���� �ؽ�Ʈ �ʵ� ����
	
	JButton send = new JButton("Send");//send��ư ����
	JButton login = new JButton("Login");//�α��ι�ư����
	JButton cancel = new JButton("Cancle");//�˽���ư����
	JTextArea ta = new JTextArea();//ä�������̱����� �ý�Ʈ������
	JTextArea ta1 = new JTextArea();//����ڸ� ǥ���ϱ����� �ؽ�Ʈ������
	JMenuBar mb = new JMenuBar();//�޴��� ������ ���� ����
	JMenuItem item1=new JMenuItem("Login");//�޴��ٿ� �α����߰�
	JMenuItem item2=new JMenuItem("Logout");//�޴��ٿ� �α׾ƿ� �߰�
	JTextField tp1 = new JTextField();//���̵����� �ؽ�Ʈ�ʵ�
	JTextField tp2 = new JTextField();//��й�ȣ�� ���� �ؽ�Ʈ �ʵ�
	
	
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
	
	ta1.setLocation(250,30);//���͵���
	ta1.setSize(120,230);
	cp.add(ta1);
	
	tp.setLocation(5,280);//�ؽ�Ʈ�ʵ�κ� ��ǥ�� ũ��, �����̳ʿ� �ø�
	tp.setSize(270,25);
	cp.add(tp);
	
	send.setLocation(280,280);//�����ư ��ǥ�� ũ�� , �����̳ʿ� �÷���
	send.setSize(90,25);
	cp.add(send);
	setSize(400,400);//�����̳� ũ�� ���� 
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
			case "Login" : Log log = new Log(); break;//�α��� ��ü ���� (����)
							
			case "Logout" : break;
			}
			
			
		}
}
	class BtnActionListener implements ActionListener{//��ư �̺�Ʈ ��Ʈ
		public void actionPerformed(ActionEvent e) {
		
			File dfile = new File("./user.txt");//�������� ����
			String id="";//���̵� �ʱ�ȭ
			String password="";//��й�ȣ �ʱ�ȭ
			id = tp1.getText();//���̵� ���̵� �ؽ�Ʈ�ʵ忡�ִ� ���� ������
			password = tp2.getText();//��й�ȣ�� ��й�ȣ �ؽ�Ʈ�ʵ忡�ִ¹��� ������
			  String da="";//���Ͽ��ִ� ����Ÿ ������������ ����
			  try {
				
				
				  BufferedReader dreader = new BufferedReader(new InputStreamReader(new FileInputStream(dfile),"EUC-KR"));//euc-kr���� ����Ÿ������ ������.���پ�����.
				  while((da = dreader.readLine())!=null) {//������ ������ �о��.
				
					String da1[] =da.split("/");//split���� /�� �������� ���ķ� ������ da1�� �迭�� �־���.
					
					if(da1[0].equals(id)&&da1[1].equals(password)==true) {//da10���� �迭�� id�� ���Ͽ� ���̰�, da1 1���� �迭�� �н����带 ���Ͽ� ���϶��� ����
						ta.setText("�α��� ����");//�ؽ�Ʈ ����� �α��μ��� �޼��� ���
					}
					else {
						ta.setText("�α��� ����");//�ƴϸ���и޼��� ���
					}
					
				  }
			  
				 
			  	}catch(IOException a) {
				  a.printStackTrace();
			  }
			
			}
		
}


	
}
