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

public class Stock extends JFrame{


	
	Connection con = null;                  // DB와 연결하는 객체
	PreparedStatement pstmt = null;         // SQL문을 DB에 전송하는 객체
	ResultSet rs = null;                    // SQL문 실행 결과를 가지고 있는 객체
	String sql = null;                      // SQL문을 저장하는 문자열 변수.
	
	DefaultTableModel model;
	JTable table;
	JTextField jtf1, jtf2, jtf3 ;
	JComboBox<String> jcb1, jcb2, jcb3;
	
	
	public Stock(){
		
		setTitle("재고관리 화면");
	
	JPanel container1 = new JPanel();	
	JPanel container2 = new JPanel();		

	
	// 1. 컴포넌트들을 만들어 보자.
	// 1-1. 상단-1 컨테이너에 들어갈 컴포넌트들을 만들어 보자.
	//JLabel jl1 = new JLabel("이용회원: ");
	//jtf1 = new JTextField(6);
	
	//JLabel jl2 = new JLabel("이용금액 : ");
	//jtf2 = new JTextField(6);
	
	//JLabel jl3 = new JLabel("총매출액 : ");
	//jtf3 = new JTextField(10);
	


	String[] header = 
		{ "상품명", "금액", "입고", "재고" };
	
	model = new DefaultTableModel(header, 0	);
	table = new JTable(model);
	
	JScrollPane jsp = new JScrollPane(table,
			ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
	JButton jb1 = new JButton("조회");
	JButton jb2 = new JButton("확인");
	
//	container1.add(jl1);	container1.add(jtf1);
//	container1.add(jl2);	container1.add(jtf2);
	//container1.add(jl3);	container1.add(jtf3);

	container1.add(jb1);	container1.add(jb2);
	
	

	add(jsp, BorderLayout.NORTH);
	add(container1, BorderLayout.CENTER);

	
	
	
	setBounds(200, 200, 800, 350);
	pack();
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

	//조회메서드
	void select() {
		
		
		try {
			sql = "select fname,price from pcfoods order by fnum";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String fname = rs.getString("fname");
				int price = rs.getInt("price");
				
				Object[] date = {fname,price};
				
				model.addRow(date);
				
			}
			
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	public static void main(String[] args) {

		new Stock();
		
	}

}
