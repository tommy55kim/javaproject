package khie;

import java.awt.EventQueue;

import javax.swing.JFrame;



import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Main {
	
	
	Connection con = null;                       // DB와 연결하는 객체
	
	PreparedStatement pstmt = null;              // SQL문을 DB에 전송하는 객체
	
	ResultSet rs = null;                         // SQL문 실행 결과를 가지고 있는 객체
	
	String sql = null;                           // SQL문을 저장하는 문자열 변수
	
	int num;
	
	String food;
	
	JCheckBox
	chckbxNewCheckBox_0,
	chckbxNewCheckBox_1,
	chckbxNewCheckBox_2,
	chckbxNewCheckBox_3,
	chckbxNewCheckBox_4,
	chckbxNewCheckBox_5,
	chckbxNewCheckBox_6,
	chckbxNewCheckBox_7,
	chckbxNewCheckBox_8,
	chckbxNewCheckBox_9;
	
	JComboBox<String> comboBox;
	
	
	

	private JFrame frmMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmMenu.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
		private void initialize() {
		frmMenu = new JFrame();
		frmMenu.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmMenu.setBackground(Color.LIGHT_GRAY);
		frmMenu.setTitle("Menu");
		frmMenu.getContentPane().setLayout(null);
		frmMenu.setBounds(200, 200, 700, 500);
		frmMenu.setVisible(true);
		
		
		
		JLabel lblNewLabel = new JLabel("메뉴");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 86, 30);
		frmMenu.getContentPane().add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("현금\r\n");
		rdbtnNewRadioButton.setFont(new Font("굴림", Font.PLAIN, 18));
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton.setBounds(333, 337, 86, 30);
		frmMenu.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("카드");
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton_1.setFont(new Font("굴림", Font.PLAIN, 18));
		rdbtnNewRadioButton_1.setBounds(415, 337, 86, 30);
		frmMenu.getContentPane().add(rdbtnNewRadioButton_1);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton_4 = new JButton("문의하기");
		btnNewButton_4.setForeground(Color.BLACK);
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Inq();
			}
		});
		btnNewButton_4.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton_4.setBounds(520, 306, 142, 35);
		frmMenu.getContentPane().add(btnNewButton_4);
		
		JTextArea textArea = new JTextArea("상품 주문 목록\n");
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(32, 306, 270, 116);
		frmMenu.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(Color.WHITE);
		textArea_1.setFont(new Font("Monospaced", Font.BOLD, 25));
		textArea_1.setBounds(333, 373, 168, 42);
		frmMenu.getContentPane().add(textArea_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\바탕 화면\\사진\\1111.png"));
		lblNewLabel_1.setBounds(61, 72, 80, 62);
		frmMenu.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\바탕 화면\\사진\\진라면 수정.png"));
		lblNewLabel_1_1.setBounds(173, 72, 80, 62);
		frmMenu.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\바탕 화면\\사진\\짜파게티.jpg"));
		lblNewLabel_1_2.setBounds(293, 72, 80, 62);
		frmMenu.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("New label");
		lblNewLabel_1_3.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\바탕 화면\\사진\\치즈추가.jpg"));
		lblNewLabel_1_3.setBounds(415, 72, 80, 62);
		frmMenu.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("New label");
		lblNewLabel_1_4.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\바탕 화면\\사진\\밥추가.png"));
		lblNewLabel_1_4.setBounds(531, 72, 80, 62);
		frmMenu.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("New label");
		lblNewLabel_1_5.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\바탕 화면\\사진\\소세지.jpg"));
		lblNewLabel_1_5.setBounds(61, 168, 80, 62);
		frmMenu.getContentPane().add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("New label");
		lblNewLabel_1_6.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\바탕 화면\\사진\\콜팝.jfif"));
		lblNewLabel_1_6.setBounds(173, 168, 80, 62);
		frmMenu.getContentPane().add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("New label");
		lblNewLabel_1_7.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\바탕 화면\\사진\\새우깡.jfif"));
		lblNewLabel_1_7.setBounds(293, 168, 80, 62);
		frmMenu.getContentPane().add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("New label");
		lblNewLabel_1_8.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\바탕 화면\\사진\\콜라.jfif"));
		lblNewLabel_1_8.setBounds(415, 168, 80, 62);
		frmMenu.getContentPane().add(lblNewLabel_1_8);
		JLabel lblNewLabel_1_9 = new JLabel("New label");
		lblNewLabel_1_9.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\바탕 화면\\사진\\아이스티.jpg"));
		lblNewLabel_1_9.setBounds(531, 168, 80, 62);
		frmMenu.getContentPane().add(lblNewLabel_1_9);
		
		chckbxNewCheckBox_0 = new JCheckBox("신라면");
		chckbxNewCheckBox_0.setBackground(Color.LIGHT_GRAY);
		chckbxNewCheckBox_0.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_0.setBounds(61, 143, 80, 23);
		frmMenu.getContentPane().add(chckbxNewCheckBox_0);
		
		chckbxNewCheckBox_1 = new JCheckBox("진라면");
		chckbxNewCheckBox_1.setBackground(Color.LIGHT_GRAY);
		chckbxNewCheckBox_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_1.setBounds(173, 143, 80, 23);
		frmMenu.getContentPane().add(chckbxNewCheckBox_1);
		
		chckbxNewCheckBox_2 = new JCheckBox("짜파게티");
		chckbxNewCheckBox_2.setBackground(Color.LIGHT_GRAY);
		chckbxNewCheckBox_2.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_2.setBounds(293, 143, 80, 23);
		frmMenu.getContentPane().add(chckbxNewCheckBox_2);
		
		chckbxNewCheckBox_3 = new JCheckBox("치즈추가");
		chckbxNewCheckBox_3.setBackground(Color.LIGHT_GRAY);
		chckbxNewCheckBox_3.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_3.setBounds(415, 143, 80, 23);
		frmMenu.getContentPane().add(chckbxNewCheckBox_3);
		
		chckbxNewCheckBox_4 = new JCheckBox("밥추가");
		chckbxNewCheckBox_4.setBackground(Color.LIGHT_GRAY);
		chckbxNewCheckBox_4.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_4.setBounds(531, 143, 80, 23);
		frmMenu.getContentPane().add(chckbxNewCheckBox_4);
		
		chckbxNewCheckBox_5 = new JCheckBox("소세지");
		chckbxNewCheckBox_5.setBackground(Color.LIGHT_GRAY);
		chckbxNewCheckBox_5.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_5.setBounds(61, 233, 80, 23);
		frmMenu.getContentPane().add(chckbxNewCheckBox_5);
		
		chckbxNewCheckBox_6 = new JCheckBox("콜팝");
		chckbxNewCheckBox_6.setBackground(Color.LIGHT_GRAY);
		chckbxNewCheckBox_6.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_6.setBounds(173, 233, 80, 23);
		frmMenu.getContentPane().add(chckbxNewCheckBox_6);
		
		chckbxNewCheckBox_7 = new JCheckBox("새우깡");
		chckbxNewCheckBox_7.setBackground(Color.LIGHT_GRAY);
		chckbxNewCheckBox_7.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_7.setBounds(293, 233, 80, 23);
		frmMenu.getContentPane().add(chckbxNewCheckBox_7);
		
		chckbxNewCheckBox_8 = new JCheckBox("콜라");
		chckbxNewCheckBox_8.setBackground(Color.LIGHT_GRAY);
		chckbxNewCheckBox_8.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_8.setBounds(415, 233, 80, 23);
		frmMenu.getContentPane().add(chckbxNewCheckBox_8);
		
		chckbxNewCheckBox_9 = new JCheckBox("아이스티");
		chckbxNewCheckBox_9.setBackground(Color.LIGHT_GRAY);
		chckbxNewCheckBox_9.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_9.setBounds(531, 233, 80, 23);
		frmMenu.getContentPane().add(chckbxNewCheckBox_9);
		
		String[] seat = {"좌석선택", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
		comboBox = new JComboBox<String>(seat);
		comboBox.setBounds(333, 306, 168, 21);
		frmMenu.getContentPane().add(comboBox);
		
		JToggleButton btnNewButton_4_1 = new JToggleButton("선택완료");
		btnNewButton_4_1.setForeground(Color.BLACK);
		btnNewButton_4_1.setBackground(Color.WHITE);
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				int sum = 0;
				
				
				if(chckbxNewCheckBox_0.isSelected()) {
					textArea.append("신라면 - 4000원\n");
					sum = sum + 4000;
				}
				
				if(chckbxNewCheckBox_1.isSelected()) {
					textArea.append("진라면 - 3500원\n");
					sum = sum + 3500;
				}
				
				if(chckbxNewCheckBox_2.isSelected()) {
					textArea.append("짜파게티 - 4000원\n");
					sum = sum + 3500;
				}

				if(chckbxNewCheckBox_3.isSelected()) {
					textArea.append("치즈추가 - 500원\n");
					sum = sum + 500;
				}
				
				if(chckbxNewCheckBox_4.isSelected()) {
					textArea.append("밥추가 - 1000\n원");
					sum = sum + 1000;
				}
				
				if(chckbxNewCheckBox_5.isSelected()) {
					textArea.append("소세지 - 2000원\n");
					sum = sum + 2000;
				}
				
				if(chckbxNewCheckBox_6.isSelected()) {
					textArea.append("콜팝 - 3000원\n");
					sum = sum + 3000;
				}
				
				if(chckbxNewCheckBox_7.isSelected()) {
					textArea.append("새우깡 - 1500원\n");
					sum = sum + 1500;
				}
				
				if(chckbxNewCheckBox_8.isSelected()) {
					textArea.append("콜라 - 1500원\n");
					sum = sum + 1500;
				}
				
				if(chckbxNewCheckBox_9.isSelected()) {
					textArea.append("아이스티 - 1500원\n");
					sum = sum + 1500;
				}
				
				
				textArea_1.append(sum + "원");
			
			}
		});
		btnNewButton_4_1.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton_4_1.setBounds(520, 351, 142, 35);
		frmMenu.getContentPane().add(btnNewButton_4_1);
		
		JButton btnNewButton_4_2 = new JButton("결제하기");
		btnNewButton_4_2.setForeground(Color.BLACK);
		btnNewButton_4_2.setBackground(Color.WHITE);
		btnNewButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(btnNewButton_4_1.isSelected()) {
					JOptionPane.showMessageDialog(null, "결제 완료");
					connect();
					buy();
					order();
					
					chckbxNewCheckBox_0.setSelected(false);
					chckbxNewCheckBox_1.setSelected(false);
					chckbxNewCheckBox_2.setSelected(false);
					chckbxNewCheckBox_3.setSelected(false);
					chckbxNewCheckBox_4.setSelected(false);
					chckbxNewCheckBox_5.setSelected(false);
					chckbxNewCheckBox_6.setSelected(false);
					chckbxNewCheckBox_7.setSelected(false);
					chckbxNewCheckBox_8.setSelected(false);
					chckbxNewCheckBox_9.setSelected(false);
					
					bg.clearSelection();
					
					btnNewButton_4_1.setSelected(false);
					
					comboBox.setSelectedIndex(0);
					
				}else {
					JOptionPane.showMessageDialog(null, "상품 선택을 완료해주세요.");
				}
				
				
				
				textArea.setText(null);
				textArea_1.setText(null);
				
				
			}
		});
		btnNewButton_4_2.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton_4_2.setBounds(520, 396, 142, 35);
		frmMenu.getContentPane().add(btnNewButton_4_2);
		
		
		

		
	}
	
		
	void connect() {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "web";
		String password = "1234";
		
		try {
			// 1. 접속할 오라클 데이터베이스 드라이버를 메모리에 올리자.
			Class.forName(driver);
			
			// 2. 오라클 데이터베이스와 연결을 시도.
			con = DriverManager.getConnection(url, user, password);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}     // connect() 메서드 end
	
	
	void buy() {
		
			
		
		try {
			sql = "update pcfoods set stock = stock -1 where fnum = ?";
			
			pstmt = con.prepareStatement(sql);
			
			if(chckbxNewCheckBox_0.isSelected()) {
				num = 1;
				
				pstmt.setInt(1, num);
				
				pstmt.executeUpdate();
			}
			
			if(chckbxNewCheckBox_1.isSelected()) {
				num = 2;
				
				pstmt.setInt(1, num);
				
				pstmt.executeUpdate();
			}
			
			if(chckbxNewCheckBox_2.isSelected()) {
				num = 3;
				
				pstmt.setInt(1, num);
				
				pstmt.executeUpdate();
			}

			if(chckbxNewCheckBox_3.isSelected()) {
				num = 4;
				
				pstmt.setInt(1, num);
				
				pstmt.executeUpdate();
			}
			
			if(chckbxNewCheckBox_4.isSelected()) {
				num = 5;
				
				pstmt.setInt(1, num);
				
				pstmt.executeUpdate();
			}
			
			if(chckbxNewCheckBox_5.isSelected()) {
				num = 6;
				
				pstmt.setInt(1, num);
				
				pstmt.executeUpdate();
			}
			
			if(chckbxNewCheckBox_6.isSelected()) {
				num = 7;
				
				pstmt.setInt(1, num);
				
				pstmt.executeUpdate();
			}
			
			if(chckbxNewCheckBox_7.isSelected()) {
				num = 8;
				
				pstmt.setInt(1, num);
				
				pstmt.executeUpdate();
			}
			
			if(chckbxNewCheckBox_8.isSelected()) {
				num = 9;
				
				pstmt.setInt(1, num);
				
				pstmt.executeUpdate();
			}
			
			if(chckbxNewCheckBox_9.isSelected()) {
				num = 10;
				
				pstmt.setInt(1, num);
				
				pstmt.executeUpdate();
			}
			
			
			
			pstmt.close(); // con.close();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void order() {
		
		
		
		try {
			
			
			
			
			if(chckbxNewCheckBox_0.isSelected()) {
				
				sql = "update menuorder set sin = sin + 1 where seat = ?";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, Integer.parseInt(comboBox.getSelectedItem().toString()));

				pstmt.executeUpdate();
			}
			
			if(chckbxNewCheckBox_1.isSelected()) {
				
				sql = "update menuorder set jin = jin + 1 where seat = ?";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, Integer.parseInt(comboBox.getSelectedItem().toString()));

				pstmt.executeUpdate();
			}
			
			if(chckbxNewCheckBox_2.isSelected()) {

				sql = "update menuorder set jjapa = jjapa + 1 where seat = ?";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, Integer.parseInt(comboBox.getSelectedItem().toString()));

				pstmt.executeUpdate();
			}

			if(chckbxNewCheckBox_3.isSelected()) {

				sql = "update menuorder set cheese = cheese + 1 where seat = ?";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, Integer.parseInt(comboBox.getSelectedItem().toString()));
				
				pstmt.executeUpdate();
			}
			
			if(chckbxNewCheckBox_4.isSelected()) {

				sql = "update menuorder set bob = bob + 1 where seat = ?";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, Integer.parseInt(comboBox.getSelectedItem().toString()));
				
				pstmt.executeUpdate();
			}
			
			if(chckbxNewCheckBox_5.isSelected()) {

				sql = "update menuorder set sasauge = sasauge + 1 where seat = ?";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, Integer.parseInt(comboBox.getSelectedItem().toString()));
				
				pstmt.executeUpdate();
			}
			
			if(chckbxNewCheckBox_6.isSelected()) {

				sql = "update menuorder set pop = pop + 1 where seat = ?";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, Integer.parseInt(comboBox.getSelectedItem().toString()));
				
				pstmt.executeUpdate();
			}
			
			if(chckbxNewCheckBox_7.isSelected()) {

				sql = "update menuorder set ggang = ggang + 1 where seat = ?";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, Integer.parseInt(comboBox.getSelectedItem().toString()));
				
				pstmt.executeUpdate();
			}
			
			if(chckbxNewCheckBox_8.isSelected()) {

				sql = "update menuorder set coke = coke + 1 where seat = ?";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, Integer.parseInt(comboBox.getSelectedItem().toString()));
				
				pstmt.executeUpdate();
			}
			
			if(chckbxNewCheckBox_9.isSelected()) {

				sql = "update menuorder set icetea = icetea + 1 where seat = ?";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, Integer.parseInt(comboBox.getSelectedItem().toString()));
				
				pstmt.executeUpdate();
			}
			
			pstmt.close(); con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}

	
