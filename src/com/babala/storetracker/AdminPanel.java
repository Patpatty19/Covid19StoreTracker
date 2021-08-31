package com.babala.storetracker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.github.lgooddatepicker.components.DatePicker;

public class AdminPanel {

	public JFrame frmAdminPanel;
	private JTable tblResults;
	private JTextField txtFieldSearchbar;
	private String searchResult;
	private LocalDate searchDate;
	private SearchType searchSelection;
	
	private String column [] = {"Last Name",  "First Name", "Middle Name", "Birth Date", "Date of Entry"};
	
	
	
	private String data [][] = {{}};
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel window = new AdminPanel();
					window.frmAdminPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminPanel = new JFrame();
		frmAdminPanel.setTitle("Admin Panel");
		frmAdminPanel.setResizable(false);
		frmAdminPanel.setBounds(100, 100, 450, 300);
		frmAdminPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblAdminPanel = new JLabel("Admin Panel");
		lblAdminPanel.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblDateandTime = new JLabel("March 27, 2021 04:00:00 PM");
		lblDateandTime.setFont(new Font("Arial", Font.PLAIN, 12));
	    DateTime(lblDateandTime);
	    
	    
	    DatePicker datePicker = new DatePicker();

		JRadioButton rdbtnLastname = new JRadioButton("Last Name");
		rdbtnLastname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtFieldSearchbar.setEnabled(true);
				datePicker.setEnabled(false);
				
			}
		});
		rdbtnLastname.setFont(new Font("Arial", Font.BOLD, 10));
		
		JRadioButton rdbtnFirstname = new JRadioButton("First Name");
		rdbtnFirstname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				txtFieldSearchbar.setEnabled(true);
				datePicker.setEnabled(false);
			}
		});
		rdbtnFirstname.setFont(new Font("Arial", Font.BOLD, 10));
		
		rdbtnLastname.setSelected(true);
		datePicker.setEnabled(false);
		
		
		JRadioButton rdbtnEntrydate = new JRadioButton("Date of Entry");
		rdbtnEntrydate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtFieldSearchbar.setEnabled(false);
				datePicker.setEnabled(true);
			}
		});
		rdbtnEntrydate.setFont(new Font("Arial", Font.BOLD, 10));
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnLastname);
		buttonGroup.add(rdbtnFirstname);
		buttonGroup.add(rdbtnEntrydate);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin adminLogin = new AdminLogin();
				adminLogin.frmAdminLogin.setVisible(true);
				
				frmAdminPanel.setVisible(false);
			}
		});
	   
	    
		txtFieldSearchbar = new JTextField();
		
		JScrollPane scrollPane = new JScrollPane();
	    
		searchResult = txtFieldSearchbar.getText();
		searchDate = datePicker.getDate();
		
		
	    JButton btnGo = new JButton("GO");
	    
	    if  (searchResult.length() != 0) {
			
				btnGo.setEnabled(false);
			} else  if (searchDate != null )  {
				
				btnGo.setEnabled(false);
			} else {
				btnGo.setEnabled(true); 
			}
			
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchResult = txtFieldSearchbar.getText();
				searchDate = datePicker.getDate();
				
				
				
				if (rdbtnFirstname.isSelected()) {
					searchSelection = SearchType.FirstName;
					data = Visitor.Search(searchResult, searchSelection);
			
					 if (searchResult.length() <= 0) {
							
							JOptionPane.showMessageDialog(frmAdminPanel, "Text is required");
							return;
						}
					
				} else if (rdbtnLastname.isSelected()) {
					searchSelection = SearchType.LastName;
					data = Visitor.Search(searchResult, searchSelection);
					
					
					
					 if (searchResult.length() <= 0) {
							
							JOptionPane.showMessageDialog(frmAdminPanel, "Text is required");
							return;
						}
					
				} else if (rdbtnEntrydate.isSelected()) {
					searchSelection = SearchType.EntryDate;
					data = Visitor.Search(searchDate);
					
					 if (searchDate == null) {
							
							JOptionPane.showMessageDialog(frmAdminPanel, "Date is required");
							return;
						}
				} 
				
				
			
				RedrawTable(data, scrollPane);
			
	
			}
		});
	    
	    
		
	
		
		
		txtFieldSearchbar.setColumns(10);
		

		
		
		btnGo.setFont(new Font("Arial", Font.PLAIN, 10));
	
		JLabel lblSearch = new JLabel("Search Here:");
		lblSearch.setFont(new Font("Arial", Font.PLAIN, 12));
		

		
		
		GroupLayout groupLayout = new GroupLayout(frmAdminPanel.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblSearch)
								.addComponent(btnNewButton))
							.addGap(74))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtFieldSearchbar, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnGo))
						.addComponent(datePicker, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(rdbtnLastname)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(rdbtnFirstname)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rdbtnEntrydate)
								.addGap(65))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(37)
								.addComponent(lblAdminPanel)
								.addContainerGap()))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(lblDateandTime)
							.addContainerGap())))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAdminPanel))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSearch)
						.addComponent(lblDateandTime))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFieldSearchbar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnLastname)
						.addComponent(rdbtnEntrydate)
						.addComponent(rdbtnFirstname))
					.addGap(8)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
					.addGap(6))
		);
		
		
		
		
		
		
		
		
	
		frmAdminPanel.getContentPane().setLayout(groupLayout);
	}
	
	private void DateTime(JLabel label) {
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



void RedrawTable(String[][] data, JScrollPane scrollPane ) {
	
	tblResults = new JTable(data, column);
	tblResults.setEnabled(false);
	tblResults.getTableHeader().setResizingAllowed(false);
	tblResults.getTableHeader().setReorderingAllowed(false);
	scrollPane.setViewportView(tblResults);
	
}

}