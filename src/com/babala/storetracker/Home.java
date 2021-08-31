package com.babala.storetracker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import com.github.lgooddatepicker.components.DatePicker;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Home {

	public JFrame homeFrame;
	private JTextField txtFieldFirstName;
	private JTextField txtFieldMiddleName;
	private JTextField txtFieldLastName;
	private JTextField txtFieldPhoneNumb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.homeFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		homeFrame = new JFrame();
		homeFrame.setTitle("COVID-19 Store Tracker");
		homeFrame.setResizable(false);
		homeFrame.setBounds(100, 100, 450, 300);
		homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblTitle = new JLabel("COVID-19 Store Logger");
		lblTitle.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblLiveDateTime = new JLabel("March 27, 2021 04:00:00 PM");
		lblLiveDateTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblLiveDateTime.setFont(new Font("Arial", Font.PLAIN, 12));
		LiveDateTime(lblLiveDateTime);
		
		txtFieldFirstName = new JTextField();
		txtFieldFirstName.setColumns(10);
		
		txtFieldMiddleName = new JTextField();
		txtFieldMiddleName.setColumns(10);
		
		txtFieldLastName = new JTextField();
		txtFieldLastName.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setHorizontalAlignment(SwingConstants.LEFT);
		lblMiddleName.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastName.setFont(new Font("Arial", Font.BOLD, 12));
		
		txtFieldPhoneNumb = new JTextField();
		txtFieldPhoneNumb.setColumns(10);
		
		JLabel lblPhoneNumb = new JLabel("Phone Number");
		lblPhoneNumb.setHorizontalAlignment(SwingConstants.LEADING);
		lblPhoneNumb.setVerticalAlignment(SwingConstants.CENTER);
		lblPhoneNumb.setFont(new Font("Arial", Font.BOLD, 12));
		
		DatePicker datePicker = new DatePicker();
		
		JLabel lblDatePicker = new JLabel("Birth Date");
		lblDatePicker.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = txtFieldFirstName.getText();
				
				if (firstName.length() <= 0) {
					
					JOptionPane.showMessageDialog(homeFrame, "First name is required");
					return;
				}
				
				
				String middleName = txtFieldMiddleName.getText();
				String lastName = txtFieldLastName.getText();
				
	            if (lastName.length() <= 0) {
					
					JOptionPane.showMessageDialog(homeFrame, "Last name is required");
					return;
				}
				
				String phoneNumber = txtFieldPhoneNumb.getText();
				
		         if (phoneNumber.length() <= 0) {
						
						JOptionPane.showMessageDialog(homeFrame, "Phone number is required");
						return;
					}
				
				
				if (phoneNumber.length() != 10 && phoneNumber.length() != 11) {
				
					
					JOptionPane.showMessageDialog(homeFrame, "Phone number length is incorrect");
					return;
				}
				
				LocalDate birthDate = datePicker.getDate();
				
				if (birthDate == null) {
					
					JOptionPane.showMessageDialog(homeFrame, "Birthdate is required");
					return;
				}
				
				Visitor newVisitor = new Visitor(firstName, middleName, lastName, phoneNumber, birthDate);
				Visitor.visitorList.add(newVisitor);				
								
				JOptionPane.showMessageDialog(homeFrame, "Visitor details successfully logged.");
				txtFieldFirstName.setText("");
				txtFieldLastName.setText("");
				txtFieldMiddleName.setText("");
				txtFieldPhoneNumb.setText("");
				datePicker.clear();
				
				System.out.println("Number of visitors: " + Visitor.visitorList.size());
			}
		});
		
		JLabel lblAdminPanel = new JLabel("Admin Panel");
		lblAdminPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminLogin adminLogin = new AdminLogin();
				adminLogin.frmAdminLogin.setVisible(true);
				
				homeFrame.setVisible(false);
			}
		});
		lblAdminPanel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdminPanel.setFont(new Font("Arial", Font.BOLD, 12));
		
		GroupLayout groupLayout = new GroupLayout(homeFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addComponent(lblLiveDateTime, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
					.addGap(52))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(95)
					.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
					.addGap(94))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(txtFieldPhoneNumb, Alignment.LEADING)
							.addComponent(txtFieldFirstName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
							.addComponent(lblFirstName, Alignment.LEADING))
						.addComponent(lblPhoneNumb))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDatePicker)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtFieldMiddleName, 116, 116, 116)
								.addComponent(lblMiddleName))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLastName)
								.addComponent(txtFieldLastName, 105, 105, 105)))
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(38, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(190)
					.addComponent(btnSubmit)
					.addContainerGap(189, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(388, Short.MAX_VALUE)
					.addComponent(lblAdminPanel)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblLiveDateTime)
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMiddleName)
						.addComponent(lblFirstName)
						.addComponent(lblLastName))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFieldFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFieldMiddleName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFieldLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhoneNumb)
						.addComponent(lblDatePicker))
					.addGap(3)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtFieldPhoneNumb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(btnSubmit)
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addComponent(lblAdminPanel)
					.addGap(21))
		);
		homeFrame.getContentPane().setLayout(groupLayout);
	}

	
	private void LiveDateTime(JLabel label) {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy KK:mm:ss a");
					LocalDateTime now = LocalDateTime.now();
					label.setText(dtf.format(now));
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		};
		
		Thread t = new Thread(runnable);
		t.start();
	}
}
