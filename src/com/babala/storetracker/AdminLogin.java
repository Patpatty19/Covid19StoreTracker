package com.babala.storetracker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminLogin {

	public JFrame frmAdminLogin;
	private JTextField txtFieldUsername;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
					window.frmAdminLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	
	
		frmAdminLogin = new JFrame();
		frmAdminLogin.setResizable(false);
		frmAdminLogin.setTitle("Admin Login");
		frmAdminLogin.setBounds(100, 100, 450, 300);
		frmAdminLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 12));
		
		txtFieldUsername = new JTextField();
		txtFieldUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		
		passwordField = new JPasswordField();
	
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean checkLogin = true;
				String Username = txtFieldUsername.getText();
				String Password = String.valueOf(passwordField.getPassword());
			
				
	            if (Username.length() <= 0) {
					
					JOptionPane.showMessageDialog(frmAdminLogin, "Username is required");
					return;
				}
	            
	            
               if (Password.length() <= 0) {
					
					JOptionPane.showMessageDialog(frmAdminLogin, "Password is required");
					return;
				}
				
				
				if (Username.equals("storetracker") && Password.equals("covid")) {
					checkLogin = true;
				}  else {
					checkLogin = false;
				}
				
			if (checkLogin == true) {

				AdminPanel adminPanel = new AdminPanel();
				adminPanel.frmAdminPanel.setVisible(true);
				
				frmAdminLogin.setVisible(false);
			} else {
			
				JOptionPane.showMessageDialog(frmAdminLogin, "Error wrong password and username");
				txtFieldUsername.setText("");
				passwordField.setText("");
			}
				
									
			
			}
		});
		
		JLabel lblReturn = new JLabel("Back");
		lblReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home newHome = new Home();
				newHome.homeFrame.setVisible(true);
				
				frmAdminLogin.setVisible(false);
			}
		});
		lblReturn.setFont(new Font("Arial", Font.BOLD, 12));
		GroupLayout groupLayout = new GroupLayout(frmAdminLogin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(lblReturn)
							.addGap(129)
							.addComponent(lblAdminLogin))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(193)
							.addComponent(lblUsername))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(194)
							.addComponent(lblPassword))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(182)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(141)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField)
								.addComponent(txtFieldUsername, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))))
					.addContainerGap(141, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(lblAdminLogin)
							.addGap(18)
							.addComponent(lblUsername)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtFieldUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(17)
							.addComponent(lblPassword)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnLogin))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblReturn)))
					.addContainerGap(72, Short.MAX_VALUE))
		);
		frmAdminLogin.getContentPane().setLayout(groupLayout);
	}
	
	
}