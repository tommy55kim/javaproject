package khie;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class Inq extends JFrame {

	

	public Inq() {
		
		setTitle("문의하기");
		
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		
		JLabel jl1 = new JLabel("문의사항을 적어주세요.");
		
		JTextArea jta = new JTextArea(5, 20);
		JScrollPane jsp = new JScrollPane(
				jta,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		JButton jb1 = new JButton("문의하기");
		JButton jb2 = new JButton("돌아가기");
		
		container1.add(jl1);
		container2.add(jb1);
		container2.add(jb2);
		
		add(container1, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		add(container2, BorderLayout.SOUTH);
		
		setBounds(200, 200, 300, 500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "문의 완료");
				dispose();
				
			}
		});
		
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
				
		
	}
	
	
	public static void main(String[] args) {
		
		new Inq();
		

	}

}
