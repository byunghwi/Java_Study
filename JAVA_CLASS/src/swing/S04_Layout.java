package swing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class S04_Layout extends JFrame{
	
	ArrayList<JButton> btns = new ArrayList<JButton>(25);
	
	{
		for (int i = 1; i <= 25; i++) {
			btns.add(new JButton("button" + i ));
		}
		
	}
	
	public S04_Layout(String ltype) {
		SwingTools.initTestFrame(this);
		
		switch (ltype) {
		case "border":
			// # BorderLayout
			//	- 동서남북과 가운데로 이루어진 레이아웃
			//	- 컴포넌트를 붙일 때 위치를 함께 지정해야 한다.
			// 	- 생성자 값 2개는 수평(horizon) 여백과 수직 (vertical)여백이다.
			setLayout(new BorderLayout(10, 20));
			
			add(btns.get(0), BorderLayout.EAST);
			add(btns.get(1), BorderLayout.WEST);
			add(btns.get(2), BorderLayout.SOUTH);
			add(btns.get(3), BorderLayout.NORTH);
			add(btns.get(4), BorderLayout.CENTER);
			break;
		case "grid":
			// # GridLayout
			// - 행/열로 이루어진 레이아웃
			// - 컴포넌트를 순서대로 붙이면 된다ㅣ.
			// - 생성자 인자값 2개는 행과 열의 갯수이다.
			// - 모든 칸을 채울 수 없을 때는 행을 우선시 한다.
			setLayout(new GridLayout(2, 3));
			add(btns.get(0));
			add(btns.get(1));
			add(btns.get(2));
			add(btns.get(3));
			add(btns.get(4));
			break;
			
		case "flow" :
			// # flowLayout
			// - 텍스트처럼 컴포넌트를 추가한다.
			
			setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			for (int i = 0; i < 10; i++) {
				add(btns.get(i));
			}
			
			break;
		case "card" :
			//# CardLayout
			// - 컴퓨넌트를 카드처럼 넘기면서 사용하는 레이아웃
			// - 생성자로는 바깥쪽 여백을 설정할 수 있다.
			// - 카드 레이아웃을 제어하기 위해서 레이아웃이 속해있는 부모 컨테이너를 전달해야 한다.
			Container c = this.getContentPane();
			
			CardLayout cards = new CardLayout(10, 20);
			setLayout(cards);
			
			add("a", btns.get(0));
			add("b", btns.get(1));
			add("c", btns.get(2));
			
			ActionListener next_card = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//cards.first(c);
					//cards.last(c);
					//cards.show(c, "c");
					//cards.previous(c);
					
					cards.next(c);
				}
			};
			
			btns.get(0).addActionListener(next_card);
			btns.get(1).addActionListener(next_card);
			btns.get(2).addActionListener(next_card);
			
			break;
		default:
			add(btns.get(0));
			add(btns.get(1));
			add(btns.get(2));
			add(btns.get(3));
			add(btns.get(4));
			break;
		}
		
		
		
	}
	
	public static void main(String[] args) {
		//new S04_Layout("border");
		//new S04_Layout("grid");
		//new S04_Layout("flow");
		//new S04_Layout("card");
	}
}
