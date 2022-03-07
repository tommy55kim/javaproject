package project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Pcmember extends JFrame {
	
	
	Connection con = null;                  // DB와 연결하는 객체
	PreparedStatement pstmt = null;         // SQL문을 DB에 전송하는 객체
	ResultSet rs = null;                    // SQL문 실행 결과를 가지고 있는 객체
	String sql = null;                      // SQL문을 저장하는 문자열 변수.
	
	DefaultTableModel model;
	JTable table;
	JTextField jtf1, jtf2, jtf3, jtf4, jtf5, jtf6, jtf7, jtf8, jtf9;
	
	
	public Pcmember() {

		setTitle("회원관리 화면");
		
	JPanel container1 = new JPanel();		// 상단-1 컨테이너
	JPanel container2 = new JPanel();		// 상단-2 컨테이너
	JPanel container3 = new JPanel();		// 하단컨테이너
	
	// 1. 컴포넌트들을 만들어 보자.
	// 1-1. 상단-1 컨테이너에 들어갈 컴포넌트들을 만들어 보자.

	
	JLabel jl1 = new JLabel("아이디 : ");
	jtf1 = new JTextField(6);
	
	JLabel jl2 = new JLabel("비밀번호 : ");
	jtf2 = new JTextField(10);
	
	JLabel jl3 = new JLabel("이 름 : ");
	jtf3 = new JTextField(5);
	
	JLabel jl4 = new JLabel("생년월일 : ");
	jtf4 = new JTextField(10);
	
	JLabel jl5 = new JLabel("연락처 : ");
	jtf5 = new JTextField(10);
	
	JLabel jl6 = new JLabel("주소 : ");
	jtf6 = new JTextField(10);
	
	JLabel jl7 = new JLabel("가입일 : ");
	jtf7 = new JTextField(10);
	
	JLabel jl8 = new JLabel("잔여시간 : ");
	jtf8 = new JTextField(10);
	

	
	String[] header = 
		{ "아이디", "비밀번호", "이 름", "생년월일", "연락처", "주소", "가입일" , "잔여시간"};
	
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
	container1.add(jl4);	container1.add(jtf4);
	
	container2.add(jl5);	container2.add(jtf5);
	container2.add(jl6);	container2.add(jtf6);
	container2.add(jl7);	container2.add(jtf7);
	container2.add(jl8);	container2.add(jtf8);

	
	container3.add(jb1);	container3.add(jb2);
	container3.add(jb3);	container3.add(jb4);
	
	JPanel group = new JPanel(new BorderLayout());
	group.add(container2, BorderLayout.NORTH);
	group.add(jsp, BorderLayout.CENTER);
	group.add(container3, BorderLayout.SOUTH);
	
	add(container1, BorderLayout.NORTH);
	add(group, BorderLayout.CENTER);
	
	setBounds(200, 200, 800, 350);
	pack();
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setVisible(true);
	
	
	
	
	
	
	
	
	//jb1(회원 목록조회) 이벤트
	jb1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		
			connect();
			model.setRowCount(0);
			select();

		}
	});
	
	//jb2(신규회원등록) 이벤트
	jb2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {

			connect();
			insert();
			
			jtf1.setText("");	jtf2.setText("");
			jtf3.setText("");	jtf4.setText("");
			jtf5.setText("");	jtf6.setText("");
			jtf7.setText("");	jtf8.setText("");
			jtf9.setText("");
			
			model.setRowCount(0);
			
			select();
			
			
		}
	});
	
	//jb3(회원정보수정) 이벤트
	jb3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			connect();
			update();
			
			jtf1.setText("");	jtf2.setText("");
			jtf3.setText("");	jtf4.setText("");
			jtf5.setText("");	jtf6.setText("");
			jtf7.setText("");	jtf8.setText("");
			jtf9.setText("");
			jtf1.requestFocus();	
			
			model.setRowCount(0);
			
			select();
			
		}
	});
	
	//jb4(회원정보삭제) 이벤트
	jb4.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			connect();
			delete();
			
			jtf1.setText("");	jtf2.setText("");
			jtf3.setText("");	jtf4.setText("");
			jtf5.setText("");	jtf6.setText("");
			jtf7.setText("");	jtf8.setText("");
			jtf9.setText("");
			jtf1.requestFocus();	
			
			model.setRowCount(0);
			
			select();
			
		}
	});
	
	
	//텍스트필드 이벤트
	table.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) { }
		
		@Override
		public void mousePressed(MouseEvent e) { }
		
		@Override
		public void mouseExited(MouseEvent e) { }
		
		@Override
		public void mouseEntered(MouseEvent e) { }
		
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();
			jtf1.setText(model.getValueAt(row, 0).toString());
			jtf2.setText(model.getValueAt(row, 1).toString());
			jtf3.setText(model.getValueAt(row, 2).toString());
			jtf4.setText(model.getValueAt(row, 3).toString());
			jtf5.setText(model.getValueAt(row, 4).toString());
			jtf6.setText(model.getValueAt(row, 5).toString());
			jtf7.setText(model.getValueAt(row, 6).toString());
			jtf8.setText(model.getValueAt(row, 7).toString());

			
	
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
	
	//전체회원조회 메서드
	void select() {
		
		
		try {
			sql = "select * from pcmember order by regdate desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String memid = rs.getString("memid");
				String pwd = rs.getString("pwd");
				String memname = rs.getString("memname");
				String birthdate = rs.getString("birthdate").substring(0,10);
				String memphone = rs.getString("memphone");
				String addr = rs.getString("addr");
				String regdate = rs.getString("regdate").substring(0,10);
				String pctime = rs.getString("pctime");
				
				
				Object[] date =
					{memid, pwd, memname, birthdate, memphone,addr,regdate, pctime};
				
				model.addRow(date);
			
			}
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	//신규회원등록 메서드
	void insert() {
		
	
		try {
			sql = "insert into pcmember values(?, ?, ?, ?, ?, ?, sysdate,?)";
			pstmt = con.prepareStatement(sql);
			
		
			pstmt.setString(2, jtf2.getText());		//아이디
			pstmt.setString(3, jtf3.getText());		//비밀번호
			pstmt.setString(4, jtf4.getText());		//이름
			pstmt.setString(5, jtf5.getText());		//생년월일
			pstmt.setString(6, jtf6.getText());		//연락처
			pstmt.setString(7, jtf7.getText());		//주소
		//	pstmt.setInt(8, Integer.parseInt(jtf8.getText())); //가입일
			pstmt.setString(8, jtf9.getText());		//잔여시간
			
			
			int res = pstmt.executeUpdate();
			
			if(res >0) {
				JOptionPane.showMessageDialog(null, "신규회원 등록성공");
			}else {
				JOptionPane.showMessageDialog(null, "신규회원 등록실패");
			}
			
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//회원정보수정 메서드
	void update() {
		
	
		try {
			sql = "update pcmember set memid=?,pwd=?,memname=?,birthdate=?,memphone=?,addr=?,pctime=? where memid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, jtf2.getText());		//아이디
			pstmt.setString(2, jtf3.getText());		//비밀번호
			pstmt.setString(3, jtf4.getText());		//이름
			pstmt.setString(4, jtf5.getText());		//생년월일
			pstmt.setString(5, jtf6.getText());		//연락처
			pstmt.setString(6, jtf7.getText());		//주소
			pstmt.setString(7, jtf9.getText());		//잔여시간

		
			int res = pstmt.executeUpdate();
			
			if(res > 0) {
				JOptionPane.showMessageDialog(null, "사원 정보 수정 성공");
			}else {
				JOptionPane.showMessageDialog(null, "사원 정보 수정 실패");
			}
			pstmt.close();
				
		
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	//회원정보삭제 메서드
	void delete() {
		
	
		try {
			sql = "delete from pcmember where num = ?";
			pstmt = con.prepareStatement(sql);
			
			int row = table.getSelectedRow();
			
			pstmt.setInt(1, (int)model.getValueAt(row, 0));
			
			int res = pstmt.executeUpdate();
			
			if(res >0) {
				JOptionPane.showMessageDialog(null, "사원 삭제 성공");
			}else {
				JOptionPane.showMessageDialog(null, "사원 삭제 실패");
			}
			
			model.removeRow(row);
			
			pstmt.close(); 
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) {

		new Pcmember();
		
	}
	
}
