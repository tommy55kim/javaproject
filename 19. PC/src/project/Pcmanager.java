package project;


import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Stack;
import java.awt.event.ActionEvent;
import java.awt.Color;

import oracle.jdbc.proxy.annotation.SetDelegate;

public class Pcmanager extends JFrame{
	
	Connection con = null;                  // DB와 연결하는 객체
	PreparedStatement pstmt = null;         // SQL문을 DB에 전송하는 객체
	ResultSet rs = null;                    // SQL문 실행 결과를 가지고 있는 객체
	String sql = null;                      // SQL문을 저장하는 문자열 변수.

	private JFrame frame;
	
	JButton seat_1, seat_2, seat_3, seat_4, seat_5,
	seat_6, seat_7, seat_8, seat_9, seat_10, seat_11, seat_12;
	
	JTextArea textArea;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pcmanager window = new Pcmanager();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pcmanager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();
		
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 727, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
	
		
		
		JLabel title = new JLabel("관리자");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("굴림", Font.BOLD, 30));
		title.setBounds(38, 26, 129, 32);
		frame.getContentPane().add(title);
		
		JButton sales = new JButton("매출관리");
		sales.setBackground(Color.WHITE);
		sales.setBounds(38, 87, 174, 23);
		frame.getContentPane().add(sales);
		
		
		JButton member = new JButton("회원관리");
		member.setBackground(Color.WHITE);
		member.setBounds(38, 119, 174, 23);
		frame.getContentPane().add(member);

		JButton stock = new JButton("재고관리");
		stock.setBackground(Color.WHITE);
		stock.setBounds(38, 151, 174, 23);
		frame.getContentPane().add(stock);
		
		seat_1 = new JButton("좌석 1");
		seat_1.setBackground(Color.WHITE);
		seat_1.setBounds(235, 87, 98, 85);
		frame.getContentPane().add(seat_1);
		
		seat_2 = new JButton("좌석 2");
		seat_2.setBackground(Color.WHITE);
		seat_2.setBounds(348, 86, 98, 86);
		frame.getContentPane().add(seat_2);
		
		seat_3 = new JButton("좌석 3");
		seat_3.setBackground(Color.WHITE);
		seat_3.setBounds(461, 86, 98, 86);
		frame.getContentPane().add(seat_3);
		
		seat_4 = new JButton("좌석 4");
		seat_4.setBackground(Color.WHITE);
		seat_4.setBounds(574, 86, 98, 86);
		frame.getContentPane().add(seat_4);
		
		seat_5 = new JButton("좌석 5");
		seat_5.setBackground(Color.WHITE);
		seat_5.setBounds(235, 185, 98, 85);
		frame.getContentPane().add(seat_5);
		
		seat_6 = new JButton("좌석 6");
		seat_6.setBackground(Color.WHITE);
		seat_6.setBounds(348, 184, 98, 86);
		frame.getContentPane().add(seat_6);
		
		seat_7 = new JButton("좌석 7");
		seat_7.setBackground(Color.WHITE);
		seat_7.setBounds(461, 184, 98, 86);
		frame.getContentPane().add(seat_7);
		
		seat_8 = new JButton("좌석 8");
		seat_8.setBackground(Color.WHITE);
		seat_8.setBounds(574, 184, 98, 86);
		frame.getContentPane().add(seat_8);
		
		seat_9 = new JButton("좌석 9");
		seat_9.setBackground(Color.WHITE);
		seat_9.setBounds(235, 283, 98, 85);
		frame.getContentPane().add(seat_9);
		
		seat_10 = new JButton("좌석 10");
		seat_10.setBackground(Color.WHITE);
		seat_10.setBounds(348, 282, 98, 86);
		frame.getContentPane().add(seat_10);
		
		seat_11 = new JButton("좌석 11");
		seat_11.setBackground(Color.WHITE);
		seat_11.setBounds(461, 282, 98, 86);
		frame.getContentPane().add(seat_11);
		
		seat_12 = new JButton("좌석 12");
		seat_12.setBackground(Color.WHITE);
		seat_12.setBounds(574, 282, 98, 86);
		frame.getContentPane().add(seat_12);
		
		JLabel orderlist = new JLabel("상품주문내역");
		orderlist.setForeground(Color.WHITE);
		orderlist.setBounds(38, 218, 84, 18);
		frame.getContentPane().add(orderlist);
		
		textArea = new JTextArea();
		textArea.setToolTipText("");
		textArea.setText("");
		textArea.setBounds(38, 245, 174, 122);
		frame.getContentPane().add(textArea);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(sales);	bg1.add(member); bg1.add(stock);
		
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(seat_1);	bg2.add(seat_2);	bg2.add(seat_3);
		bg2.add(seat_4);	bg2.add(seat_5);	bg2.add(seat_6);
		bg2.add(seat_7);	bg2.add(seat_8);	bg2.add(seat_9);
		bg2.add(seat_10);	bg2.add(seat_11);	bg2.add(seat_12);
	
	JButton order = new JButton("주문현황");
	order.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	order.setBackground(Color.WHITE);
	order.setBounds(38, 183, 174, 23);
	frame.getContentPane().add(order);
		
		
		
		
		// 매출관리 이벤트처리
		sales.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new Sales();
				
				
			}
		});
		
		
		// 회원관리 이벤트처리
		member.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
				new Pcmember();
				
			} 
		});
	
		
		// 재고관리 이벤트처리
		stock.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				new Stock();
				
				
			}
		});
	
		
		// 주문현황 이벤트처리
		order.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		
		
		
		
		
		
		
		
		
		//좌석관리
		seat_1.addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent e) {

			}	
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				seat_1.setBackground(Color.cyan);
				JOptionPane.showMessageDialog(null, "ㅇㅇㅇ고객정보");;
				connect();
				showmenu(1);
				seat_1.setBackground(Color.white);
			}
		});
		
		seat_2.addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent e) {

			}	
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				seat_2.setBackground(Color.cyan);
				JOptionPane.showMessageDialog(null, "ㅇㅇㅇ고객정보");;
				connect();
				showmenu(2);
				seat_2.setBackground(Color.white);
			}
		});
		
		seat_3.addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent e) {

			}	
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				seat_3.setBackground(Color.cyan);
				JOptionPane.showMessageDialog(null, "ㅇㅇㅇ고객정보");;
				connect();
				showmenu(3);
				seat_3.setBackground(Color.white);
			}
		});
		
		seat_4.addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent e) {

			}	
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				seat_4.setBackground(Color.cyan);
				JOptionPane.showMessageDialog(null, "ㅇㅇㅇ고객정보");;
				connect();
				showmenu(4);
				seat_4.setBackground(Color.white);
			}
		});
		
		seat_5.addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent e) {

			}	
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				seat_5.setBackground(Color.cyan);
				JOptionPane.showMessageDialog(null, "ㅇㅇㅇ고객정보");;
				connect();
				showmenu(5);
				seat_5.setBackground(Color.white);
			}
		});
		
		seat_6.addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent e) {

			}	
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				seat_6.setBackground(Color.cyan);
				JOptionPane.showMessageDialog(null, "ㅇㅇㅇ고객정보");;
				connect();
				showmenu(6);
				seat_6.setBackground(Color.white);
			}
		});
		
		seat_7.addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent e) {

			}	
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				seat_7.setBackground(Color.cyan);
				JOptionPane.showMessageDialog(null, "ㅇㅇㅇ고객정보");;
				connect();
				showmenu(7);
				seat_7.setBackground(Color.white);
			}
		});
		
		seat_8.addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent e) {

			}	
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				seat_8.setBackground(Color.cyan);
				JOptionPane.showMessageDialog(null, "ㅇㅇㅇ고객정보");;
				connect();
				showmenu(8);
				seat_8.setBackground(Color.white);
			}
		});
		
		seat_9.addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent e) {

			}	
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				seat_9.setBackground(Color.cyan);
				JOptionPane.showMessageDialog(null, "ㅇㅇㅇ고객정보");;
				connect();
				showmenu(9);
				seat_9.setBackground(Color.white);
			}
		});
		
		seat_10.addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent e) {

			}	
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				seat_10.setBackground(Color.cyan);
				JOptionPane.showMessageDialog(null, "ㅇㅇㅇ고객정보");;
				connect();
				showmenu(10);
				seat_10.setBackground(Color.white);
			}
		});
		
		seat_11.addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent e) {

			}	
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				seat_11.setBackground(Color.cyan);
				JOptionPane.showMessageDialog(null, "ㅇㅇㅇ고객정보");;
				connect();
				showmenu(11);
				seat_11.setBackground(Color.white);
			}
		});
		
		seat_12.addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent e) {

			}	
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				seat_12.setBackground(Color.cyan);
				JOptionPane.showMessageDialog(null, "ㅇㅇㅇ고객정보");;
				connect();
				showmenu(12);
				seat_12.setBackground(Color.white);
			}
		});

		
		
	
	}
	
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
	
	
	void showmenu(int seatnumber) {
		
		
		
		try {
			sql = "select * from menuorder where seat = ?";
			
			pstmt = con.prepareStatement(sql);
		
			
			pstmt.setObject(1, seatnumber);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int seat = rs.getInt("seat");
				int sin = rs.getInt("sin");
				int jin = rs.getInt("jin");
				int jjapa = rs.getInt("jjapa");
				int cheese = rs.getInt("cheese");
				int bob = rs.getInt("bob");
				int sasauge = rs.getInt("sasauge");
				int pop = rs.getInt("pop");
				int ggang = rs.getInt("ggang");
				int coke = rs.getInt("coke");
				int icetea = rs.getInt("icetea");
				
				textArea.append(seat + "번 자리\n");
				
				if(sin > 0) {
					textArea.append("신라면 - " + sin + "개\n");
				}
				if(jin > 0) {
					textArea.append("진라면 - " + jin + "개\n");
				}
				if(jjapa > 0) {
					textArea.append("짜파게티 - " + jjapa + "개\n");
				}
				if(cheese > 0) {
					textArea.append("치즈추가 - " + cheese + "개\n");
				}
				if(bob > 0) {
					textArea.append("밥추가 - " + bob + "개\n");
				}
				if(sasauge > 0) {
					textArea.append("소세지 - " + sasauge + "개\n");
				}
				if(pop > 0) {
					textArea.append("콜팝 - " + pop + "개\n");
				}
				if(ggang > 0) {
					textArea.append("새우깡 - " + ggang + "개\n");
				}
				if(coke > 0) {
					textArea.append("콜라 - " + coke + "개\n");
				}
				if(icetea > 0) {
					textArea.append("아이스티 - " + icetea + "개");
				}
				
					
			}
			
			pstmt.close(); con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
