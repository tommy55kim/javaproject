package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Seat extends JFrame{
	
	Connection con = null;                  // DB와 연결하는 객체
	PreparedStatement pstmt = null;         // SQL문을 DB에 전송하는 객체
	ResultSet rs = null;                    // SQL문 실행 결과를 가지고 있는 객체
	String sql = null;                      // SQL문을 저장하는 문자열 변수.
	
	DefaultTableModel model;
	JTable table;
	
	public Seat() {

	
		setTitle("좌석사용정보");
		
		JPanel container = new JPanel();
		JLabel jl1 = new JLabel("아이디 : ");
		JLabel jl2 = new JLabel("이름 : ");
		JLabel jl3 = new JLabel("잔여시간 : ");
	
		String[] header = 
			{"좌석번호","아이디","이름","잔여시간"};
		
		model = new DefaultTableModel(header, 0	);
		table = new JTable(model);
		
		JScrollPane jsp = new JScrollPane(table,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		container.add(jl1); 	container.add(jl2);		container.add(jl3);
		
		add(container);
		
		setBounds(200, 200, 200, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
	
		
		
		
		
	
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		new Seat();
	}

}
