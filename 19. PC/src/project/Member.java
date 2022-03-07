package project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Member extends JFrame {
	
	
	Connection con = null;                  // DB와 연결하는 객체
	PreparedStatement pstmt = null;         // SQL문을 DB에 전송하는 객체
	ResultSet rs = null;                    // SQL문 실행 결과를 가지고 있는 객체
	String sql = null;                      // SQL문을 저장하는 문자열 변수.
	
	DefaultTableModel model;
	JTable table;
	JTextField jtf1, jtf2, jtf3, jtf4, jtf5, jtf6, jtf7, jtf8, jtf9;
	
	
	public Member() {

		setTitle("회원관리 화면");
		
	JPanel container1 = new JPanel();		// 상단-1 컨테이너
	JPanel container2 = new JPanel();		// 상단-2 컨테이너
	JPanel container3 = new JPanel();		// 하단컨테이너
	
	// 1. 컴포넌트들을 만들어 보자.
	// 1-1. 상단-1 컨테이너에 들어갈 컴포넌트들을 만들어 보자.
	JLabel jl1 = new JLabel("회원번호 : ");
	jtf1 = new JTextField(6);
	
	JLabel jl2 = new JLabel("아이디 : ");
	jtf2 = new JTextField(6);
	
	JLabel jl3 = new JLabel("비밀번호 : ");
	jtf3 = new JTextField(10);
	
	JLabel jl4 = new JLabel("이 름 : ");
	jtf4 = new JTextField(5);
	
	JLabel jl5 = new JLabel("생년월일 : ");
	jtf5 = new JTextField(6);
	
	JLabel jl6 = new JLabel("연락처 : ");
	jtf6 = new JTextField(10);
	
	JLabel jl7 = new JLabel("주소 : ");
	jtf7 = new JTextField(10);
	
	JLabel jl8 = new JLabel("가입일 : ");
	jtf8 = new JTextField(10);
	
	JLabel jl9 = new JLabel("잔여시간 : ");
	jtf9 = new JTextField(10);
	

	
	String[] header = 
		{ "회원번호", "아이디", "비밀번호", "이 름", "생년월일", "연락처", "주소", "가입일", "잔여시간"};
	
	model = new DefaultTableModel(header, 0	);
	table = new JTable(model);
	
	JScrollPane jsp = new JScrollPane(table,
			ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
	JButton jb1 = new JButton("회원 목록조회");
	JButton jb2 = new JButton("신규회원 등록");
	JButton jb3 = new JButton("회원정보 수정");
	JButton jb4 = new JButton("회원정보 삭제");
	
	container1.add(jl1);	container1.add(jtf1);
	container1.add(jl2);	container1.add(jtf2);
	container1.add(jl3);	container1.add(jtf3);
	container2.add(jl4);	container2.add(jtf4);
	
	container2.add(jl5);	container2.add(jtf5);
	container2.add(jl6);	container2.add(jtf6);
	container2.add(jl7);	container2.add(jtf7);
	container2.add(jl8);	container2.add(jtf8);
	container1.add(jl9);	container1.add(jtf9);
	
	container3.add(jb1);	container3.add(jb2);
	container3.add(jb3);	container3.add(jb4);
	
	JPanel group = new JPanel(new BorderLayout());
	group.add(container2, BorderLayout.NORTH);
	group.add(jsp, BorderLayout.CENTER);
	group.add(container3, BorderLayout.SOUTH);
	
	add(container1, BorderLayout.NORTH);
	add(group, BorderLayout.CENTER);
	
	setBounds(200, 200, 800, 350);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setVisible(true);
	
	
	
	
	
	
	
	
	
	jb1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			connect();
			model.setRowCount(0);
			select();

		}
	});
	
	
	}
	
	//오라클 데이터 베이스와 연결해주는 메서드.
	void connect() {
		
	      String driver = "oracle.jdbc.driver.OracleDriver";
	      String url = "jdbc:oracle:thin:@localhost:1521:xe";
	      String user = "web";
	      String password = "1234";
			try {
				Class.forName(driver);
				
				
				con = DriverManager.getConnection(url, user, password);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	} // conect() 메서드 end
	
	
	
	
	
	
	
	
	//전체목록을 조회하는 메서드
	void select() {
		
		try {
			sql = "select * from pcmember order by regdate desc";
			pstmt = con.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String memid = rs.getString("memid");
				String pwd = rs.getString("pwd");
				String memname = rs.getString("memname");
				String birthdate = rs.getString("birthdate");
				String memphone = rs.getString("memphone");
				String addr = rs.getString("addr");
				String regdate = rs.getString("regdate");
				
				Object[] date =
					{num, memid, pwd, memname, birthdate, memphone,addr,regdate};
				
				model.addRow(date);
				
				rs.close(); pstmt.close(); con.close();
				
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
	
	
	
	
	
	}
	public static void main(String[] args) {

		new Member();
		
	}
	
}
