package project;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.util.Stack;
import java.awt.event.ActionEvent;
import java.awt.Color;

import oracle.jdbc.proxy.annotation.SetDelegate;

public class Test02 extends JFrame{

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test02 window = new Test02();
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
	public Test02() {
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
		
		JButton seat_1 = new JButton("좌석 1");
		seat_1.setBackground(Color.WHITE);
		seat_1.setBounds(235, 87, 98, 85);
		frame.getContentPane().add(seat_1);
		
		JButton seat_2 = new JButton("좌석 2");
		seat_2.setBackground(Color.WHITE);
		seat_2.setBounds(348, 86, 98, 86);
		frame.getContentPane().add(seat_2);
		
		JButton seat_3 = new JButton("좌석 3");
		seat_3.setBackground(Color.WHITE);
		seat_3.setBounds(461, 86, 98, 86);
		frame.getContentPane().add(seat_3);
		
		JButton seat_4 = new JButton("좌석 4");
		seat_4.setBackground(Color.WHITE);
		seat_4.setBounds(574, 86, 98, 86);
		frame.getContentPane().add(seat_4);
		
		JButton seat_5 = new JButton("좌석 5");
		seat_5.setBackground(Color.WHITE);
		seat_5.setBounds(235, 185, 98, 85);
		frame.getContentPane().add(seat_5);
		
		JButton seat_6 = new JButton("좌석 6");
		seat_6.setBackground(Color.WHITE);
		seat_6.setBounds(348, 184, 98, 86);
		frame.getContentPane().add(seat_6);
		
		JButton seat_7 = new JButton("좌석 7");
		seat_7.setBackground(Color.WHITE);
		seat_7.setBounds(461, 184, 98, 86);
		frame.getContentPane().add(seat_7);
		
		JButton seat_8 = new JButton("좌석 8");
		seat_8.setBackground(Color.WHITE);
		seat_8.setBounds(574, 184, 98, 86);
		frame.getContentPane().add(seat_8);
		
		JButton seat_9 = new JButton("좌석 9");
		seat_9.setBackground(Color.WHITE);
		seat_9.setBounds(235, 283, 98, 85);
		frame.getContentPane().add(seat_9);
		
		JButton seat_10 = new JButton("좌석 10");
		seat_10.setBackground(Color.WHITE);
		seat_10.setBounds(348, 282, 98, 86);
		frame.getContentPane().add(seat_10);
		
		JButton seat_11 = new JButton("좌석 11");
		seat_11.setBackground(Color.WHITE);
		seat_11.setBounds(461, 282, 98, 86);
		frame.getContentPane().add(seat_11);
		
		JButton seat_12 = new JButton("좌석 12");
		seat_12.setBackground(Color.WHITE);
		seat_12.setBounds(574, 282, 98, 86);
		frame.getContentPane().add(seat_12);
		
		JLabel orderlist = new JLabel("상품주문내역");
		orderlist.setForeground(Color.WHITE);
		orderlist.setBounds(38, 218, 84, 18);
		frame.getContentPane().add(orderlist);
		
		JTextArea textArea = new JTextArea();
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
				seat_12.setBackground(Color.white);
			}
		});

		
		
	
	}
}
