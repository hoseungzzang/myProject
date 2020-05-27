import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Firstfeame extends JFrame{//제이프레임을 상속받음.
	double a;//입력받을 실수 a

	double c;//입력받을 실수 b
	double d;//연산결과값 d 
	String choice;//어떻게 연산할 것인가 선택
	String result;//연산결과값을 문자열로 받아주기위한 결과
	JTextField tp = new JTextField("");//택스트 필드 tp
	JButton btReset = new JButton("Reset");//리셋버튼 생성
	JButton btCalculator = new JButton("Calculator");//계산버튼 생성
	JButton bt1 = new JButton("1");//1부터 연산까지 전부 생성
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
		setTitle("Calculator");//제목
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//이 
		//코드를 추가해야 종료를 눌렀을때 프로그램이 완전히 꺼짐.
		Container cp = getContentPane();
		Container cp2 = new Container();
		Container cb= new Container();
		cb.setLayout(new GridLayout(4,4));
		cp.setBackground(Color.WHITE);//컨텐츠팬영역 색깔을 바꿔줌.
		//cp.setLayout(new FlowLayout());//어떤식으로 배열할지 결정하는 것.
		cp.setLayout(new BorderLayout());
		cp2.setLayout(new BorderLayout());
		/*cp.add(new JButton("k"));//버튼객체하나만들어서 더함.
		cp.add(new JButton("no"));
		cp.add(new JButton("+"));
		cp.add(new JTextField("호승짱"));*/
		cp.add(btCalculator,BorderLayout.NORTH);//처음 컨테이너의 붂족과 남쪽에 칼큘레이터와 리솔트 그림
		cp.add(btReset,BorderLayout.SOUTH);
		cp.add(cp2,BorderLayout.CENTER);//처음 컨테이너의 센터에 cp2의 자리를 할당
		cp2.add(tp,BorderLayout.NORTH);
		cp2.add(cb,BorderLayout.CENTER);//센터자리를 가진 두번째 컨테이너에 또 새로운 컨테이너를 올림. 
		cb.add(bt1);//버튼 생성
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
		
		
		setSize(300,300);//크기"
		setVisible(true);//펄스를주면안보임

		btReset.addActionListener(new MyActionListener());//버튼마다 이벤트를 입힘
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
		Firstfeame mf = new Firstfeame();//생성
		
	}
class MyActionListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
		
			JButton b =  (JButton)e.getSource();
			String choice1 = b.getText();//버튼에 눌려지는 값을 받아줌.
			if(choice1=="0") {//눌려지는 버튼 값을 텍스트 필드에 나타냄
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
			if(choice1=="Reset")//리셋은 전부 초기화 해야하기 때문에 택스트 필드를 초기화해주고 그 이전 값들도 전부 0으로 초기화한다.
			{
				
				tp.setText("");
				a=0;
				d=0;
				
			}
			if(choice1=="+") {//연산식들을 선택
				a=Double.parseDouble(tp.getText());//tp에 들어간 값이 문자열이기 때문에 더블형으로 형변환을한 후 a에 넣어준다.
				tp.setText("");//넣어준 후 새로운 값을 받아야 하기 때문에 초기화
				choice=("+");//초이스를 +로 한다.
			}
			if(choice1=="-") {//+와 같은 구조
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
			if(choice1=="Calculator")//계산을 누르면
			{
			c=Double.parseDouble(tp.getText());//지워진 필드에 연산하기 위한 두번째 숫자를 c에 형변환 후 넣어줌.
			
			if(choice=="+") {//초이스에 선택됐던 연산을 실행
				d=a+c;
				result=Double.toString(d);//결과값이 더블형이기 때문에 필드에 표시하기 위하여 스트링으로 형변환.
				tp.setText(result);//필드에 결과값 표시
			}
			else if(choice=="-") {//+에 설명한 것과 같은 구조.
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
