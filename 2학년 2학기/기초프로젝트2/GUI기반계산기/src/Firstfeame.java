import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Firstfeame extends JFrame{//������������ ��ӹ���.
	double a;//�Է¹��� �Ǽ� a

	double c;//�Է¹��� �Ǽ� b
	double d;//�������� d 
	String choice;//��� ������ ���ΰ� ����
	String result;//���������� ���ڿ��� �޾��ֱ����� ���
	JTextField tp = new JTextField("");//�ý�Ʈ �ʵ� tp
	JButton btReset = new JButton("Reset");//���¹�ư ����
	JButton btCalculator = new JButton("Calculator");//����ư ����
	JButton bt1 = new JButton("1");//1���� ������� ���� ����
	JButton bt2 = new JButton("2");
	JButton bt3 = new JButton("3");
	JButton bt4 = new JButton("4");
	JButton bt5 = new JButton("5");
	JButton bt6 = new JButton("6");
	JButton bt7 = new JButton("7");
	JButton bt8 = new JButton("8");
	JButton bt9 = new JButton("9");
	JButton bt0 = new JButton("0");
	JButton btPlus = new JButton("+");

	JButton btMinus = new JButton("-");

	JButton btGob = new JButton("*");

	JButton btNa = new JButton("/");

	JButton btJum = new JButton(".");

	JButton btGong = new JButton(" ");
	Firstfeame(){
		setTitle("Calculator");//����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�� 
		//�ڵ带 �߰��ؾ� ���Ḧ �������� ���α׷��� ������ ����.
		Container cp = getContentPane();
		Container cp2 = new Container();
		Container cb= new Container();
		cb.setLayout(new GridLayout(4,4));
		cp.setBackground(Color.WHITE);//�������ҿ��� ������ �ٲ���.
		//cp.setLayout(new FlowLayout());//������� �迭���� �����ϴ� ��.
		cp.setLayout(new BorderLayout());
		cp2.setLayout(new BorderLayout());
		/*cp.add(new JButton("k"));//��ư��ü�ϳ����� ����.
		cp.add(new JButton("no"));
		cp.add(new JButton("+"));
		cp.add(new JTextField("ȣ��¯"));*/
		cp.add(btCalculator,BorderLayout.NORTH);//ó�� �����̳��� ������ ���ʿ� Įŧ�����Ϳ� ����Ʈ �׸�
		cp.add(btReset,BorderLayout.SOUTH);
		cp.add(cp2,BorderLayout.CENTER);//ó�� �����̳��� ���Ϳ� cp2�� �ڸ��� �Ҵ�
		cp2.add(tp,BorderLayout.NORTH);
		cp2.add(cb,BorderLayout.CENTER);//�����ڸ��� ���� �ι�° �����̳ʿ� �� ���ο� �����̳ʸ� �ø�. 
		cb.add(bt1);//��ư ����
		cb.add(bt2);
		cb.add(bt3);
		cb.add(btPlus);	
		cb.add(bt4);
		cb.add(bt5);
		cb.add(bt6);
		cb.add(btMinus);
		cb.add(bt7);
		cb.add(bt8);
		cb.add(bt9);
		cb.add(btGob);
		cb.add(bt0);
		cb.add(btGong);
		cb.add(btJum);
		cb.add(btNa);
		
		
		setSize(300,300);//ũ��"
		setVisible(true);//�޽����ָ�Ⱥ���

		btReset.addActionListener(new MyActionListener());//��ư���� �̺�Ʈ�� ����
		btCalculator.addActionListener(new MyActionListener());
		bt0.addActionListener(new MyActionListener());
		bt1.addActionListener(new MyActionListener());
		bt2.addActionListener(new MyActionListener());
		bt3.addActionListener(new MyActionListener());
		bt4.addActionListener(new MyActionListener());
		bt5.addActionListener(new MyActionListener());
		bt6.addActionListener(new MyActionListener());
		bt7.addActionListener(new MyActionListener());
		bt8.addActionListener(new MyActionListener());
		bt9.addActionListener(new MyActionListener());
		btPlus.addActionListener(new MyActionListener());
		btMinus.addActionListener(new MyActionListener());
		btGob.addActionListener(new MyActionListener());
		btGong.addActionListener(new MyActionListener());
		btNa.addActionListener(new MyActionListener());
		btJum.addActionListener(new MyActionListener());
		
	}
	public static void main(String[] args) {
		Firstfeame mf = new Firstfeame();//����
		
	}
class MyActionListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
		
			JButton b =  (JButton)e.getSource();
			String choice1 = b.getText();//��ư�� �������� ���� �޾���.
			if(choice1=="0") {//�������� ��ư ���� �ؽ�Ʈ �ʵ忡 ��Ÿ��
				tp.setText(tp.getText()+"0");
			}
			if(choice1=="1") {
				tp.setText(tp.getText()+"1");
			}
			if(choice1=="2") {
				tp.setText(tp.getText()+"2");
			}
			if(choice1=="3") {
				tp.setText(tp.getText()+"3");
			}
			if(choice1=="4") {
				tp.setText(tp.getText()+"4");
			}
			if(choice1=="5") {
				tp.setText(tp.getText()+"5");
			}
			if(choice1=="6") {
				tp.setText(tp.getText()+"6");
			}
			if(choice1=="7") {
				tp.setText(tp.getText()+"7");
			}
			if(choice1=="8") {
				tp.setText(tp.getText()+"8");
			}
			if(choice1=="9") {
				tp.setText(tp.getText()+"9");
			}
			if(choice1=="Reset")//������ ���� �ʱ�ȭ �ؾ��ϱ� ������ �ý�Ʈ �ʵ带 �ʱ�ȭ���ְ� �� ���� ���鵵 ���� 0���� �ʱ�ȭ�Ѵ�.
			{
				
				tp.setText("");
				a=0;
				d=0;
				
			}
			if(choice1=="+") {//����ĵ��� ����
				a=Double.parseDouble(tp.getText());//tp�� �� ���� ���ڿ��̱� ������ ���������� ����ȯ���� �� a�� �־��ش�.
				tp.setText("");//�־��� �� ���ο� ���� �޾ƾ� �ϱ� ������ �ʱ�ȭ
				choice=("+");//���̽��� +�� �Ѵ�.
			}
			if(choice1=="-") {//+�� ���� ����
				a=Double.parseDouble(tp.getText());
				tp.setText("");
				choice=("-");
			}
			if(choice1=="*") {
				a=Double.parseDouble(tp.getText());
				tp.setText("");
				choice=("*");
			}
			if(choice1=="/") {
				a=Double.parseDouble(tp.getText());
				tp.setText("");
				choice=("/");
			}
			if(choice1=="Calculator")//����� ������
			{
			c=Double.parseDouble(tp.getText());//������ �ʵ忡 �����ϱ� ���� �ι�° ���ڸ� c�� ����ȯ �� �־���.
			
			if(choice=="+") {//���̽��� ���õƴ� ������ ����
				d=a+c;
				result=Double.toString(d);//������� �������̱� ������ �ʵ忡 ǥ���ϱ� ���Ͽ� ��Ʈ������ ����ȯ.
				tp.setText(result);//�ʵ忡 ����� ǥ��
			}
			else if(choice=="-") {//+�� ������ �Ͱ� ���� ����.
				d=a-c;
				result=Double.toString(d);
				tp.setText(result);
			}
			else if(choice=="*") {
				d=a*c;
				result=Double.toString(d);
				tp.setText(result);
			}
			else if(choice=="/") {
				d=a/c;
				result=Double.toString(d);
				tp.setText(result);
			}
			}
			
		
		}
		
	}


}
