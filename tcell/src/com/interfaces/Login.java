package com.interfaces;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.Patient.TcellDAOToken;
import java.awt.Color;
import javax.swing.UIManager;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField UserNameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)  throws IOException  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.shadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setBounds(177, 76, 92, 15);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(177, 123, 92, 15);
		contentPane.add(lblPassword);
		
		UserNameField = new JTextField();
		UserNameField.setBounds(287, 74, 114, 19);
		contentPane.add(UserNameField);
		UserNameField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)   {
				int loginexist = TcellDAOToken.getInstance(false).getLoginName(UserNameField.getText());
				int passexist = TcellDAOToken.getInstance(false).getLoginPass(passwordField.getText());
				int myInfo = loginexist + passexist; 
				System.out.print(myInfo);
				if (myInfo == 2){
					JOptionPane.showMessageDialog(null,"Welcom back Doctor "+UserNameField.getText());
					contentPane.disable();
					Index idx =new Index();
					idx.setVisible(true);
					}
				else {
					JOptionPane.showMessageDialog(null,"Sorry username or password is not correct Try Again");
				}
				myInfo=0;
			}});
		btnNewButton.setBounds(256, 211, 155,50);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(287, 119, 114, 19);
		contentPane.add(passwordField);
		
		JLabel labelimg = new JLabel("");
		 ImageIcon img = new ImageIcon(this.getClass().getResource("/login.png"));
		labelimg.setIcon(img);
		labelimg.setBounds(22, 28, 143, 223);
		contentPane.add(labelimg);
	}
}
