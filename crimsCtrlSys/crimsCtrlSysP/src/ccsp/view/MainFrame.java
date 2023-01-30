package ccsp.view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame {
			private JTabbedPane tp; // 상단의 기본 탭
			private TotalPane tpa;
			private LookupByConditionPane lbcp;
			//생성자 호출
			public MainFrame() {
				tp = new JTabbedPane();
				tpa = new TotalPane();	//4개의 패널
				lbcp = new LookupByConditionPane();

				tp.addTab("전체보기", tpa);
				tp.addTab("조건 별 조회", lbcp);
				getContentPane().add(tp);	//this가 생략(메인프레임 상속받음)
				setTitle("범죄 관리"); // 프레임의 타이틀 달기

				pack();	//묶는 것, 정리
				setVisible(true); // 프레임 화면에 출력
				setDefaultCloseOperation(EXIT_ON_CLOSE); // x단추 활성화, 창 닫을 때 프로그램 종료
			}

			public static void main(String[] args) { // main 메서드
				new MainFrame();	//메인프레임을 인스턴스화 해라(실제 프로그램은 생성자 호출)
			}
		

}


