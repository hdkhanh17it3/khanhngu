package baitaptrenlop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;


public class bai2 extends JFrame{

	private JFrame frmClient;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txtresult;
	
	private Socket socketClient;
	private DataInputStream dis;
	private DataOutputStream dos;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bai2 window = new bai2();
					window.frmClient.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
		});
	}

	/**
	 * Create the application.
	 */
	public bai2() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClient = new JFrame();
		frmClient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmClient.setTitle("Client");
		frmClient.setBounds(100, 100, 382, 208);
		frmClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txt1 = new JTextField();
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		
		txtresult = new JTextField();
		txtresult.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("First Number:");
		lblNewLabel.setBackground(Color.BLACK);
		
		JLabel lblSecondNumber = new JLabel("Second Number:");
		
		JLabel lblNewLabel_1 = new JLabel("Result from server:");
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					socketClient = new Socket("localhost", 1234);
					JOptionPane.showMessageDialog(null, "Kết nối thành công");
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConnect.setBackground(Color.WHITE);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String vt1 = txt1.getText();
					String vt2 = txt2.getText();
					int a = Integer.parseInt(vt1);
					int b = Integer.parseInt(vt2);
					int c = a+b;
					String result = String.valueOf(c);
					txtresult.setText(result);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Lỗi nhập vào sai định dạng, vui lòng nhập bằng số ");
				}

				
			}
		});
		btnSend.setBackground(Color.WHITE);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(frmClient.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblSecondNumber)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtresult, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txt2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnSend, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txt1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnConnect)))
					.addContainerGap(111, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txt1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConnect))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txt2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSecondNumber)
						.addComponent(btnSend))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtresult, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnExit))
						.addComponent(lblNewLabel_1))
					.addContainerGap(133, Short.MAX_VALUE))
		);
		frmClient.getContentPane().setLayout(groupLayout);
	}
}
