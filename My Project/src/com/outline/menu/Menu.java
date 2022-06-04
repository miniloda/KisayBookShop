package com.outline.menu;
import com.data.datamanagement.DataManagementPane;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;

import com.transactions.TransactionsPane;
/**
 * Opens the application menu
 * @author jacob
 *
 */
public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JButton btnTransactions = new JButton("Transactions");
		JButton btnDataManagement = new JButton("Data Management");
		ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("menu.png"));
		
		frame = new JFrame();//create frame
		frame.setTitle("Menu");
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(793,564);
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("icon.jpg"));
		frame.setIconImage(icon.getImage());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		;
		btnTransactions.setBackground(Color.WHITE);
		btnTransactions.setForeground(Color.BLACK);
		btnTransactions.setBounds(207, 394, 145, 23);
		frame.getContentPane().add(btnTransactions);
		
		btnDataManagement.setBounds(420, 394, 158, 23);
		frame.getContentPane().add(btnDataManagement);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBounds(-569, -24, 1391, 591);
		lblNewLabel.setIcon(image);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		//Action Listeners
		/**
		 * Opens the TransactionsPane when button is pressed
		 */
		btnTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TransactionsPane();
			}
		});
		/**
		 * Opens the DataManagementPane when button is pressed
		 */
		btnDataManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DataManagementPane();
				
		
		}
		});
	}
}
