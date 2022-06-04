package com.transactions;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
//import com.ibm.as400.access.AS400JDBCDriver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import com.data.datamanagement.ModifyTable;
import com.mysql.jdbc.Connection;

/**
 * Opens up the transcation window
 * 
 * @author jacob
 *
 */
@SuppressWarnings("serial")

public class TransactionsPane extends JFrame {
	JPanel panel_2 = new JPanel();
	ModifyTable ModifyTable;
	DateTimeCheck DateTime;
	AddTransactions AddTransactions;

	/**
	 * Create the application.
	 */
	public TransactionsPane() {

		initComponents();

		Connect();
		AddTransactions = new AddTransactions(con);
		ModifyTable = new ModifyTable();
		DateTime = new DateTimeCheck();

	}

	/**
	 * Connect to mySQL database
	 */
	public void Connect() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/javacrud", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Initialize the contents of the this.
	 */
	@SuppressWarnings({ "serial", "unchecked" })
	private void initComponents() {
		initTotalCost();
		searchTable = new JTable();
		transactionTable = new JTable();

		this.setBounds(100, 100, 1209, 647);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 255));
		panel.setBounds(0, 0, 1193, 88);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Kisay's BookShop Purchase Transaction");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(356, 26, 573, 31);
		panel.add(lblNewLabel);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 110, 1183, 424);
		this.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		BufferedImage image;
		try {
			image = ImageIO.read(getClass().getResource("/src/image/search.png"));

		} catch (Exception ex) {
			System.out.println(ex);
		}
		JScrollPane ScrollPanel2 = new JScrollPane();
		ScrollPanel2.setBackground(SystemColor.desktop);
		ScrollPanel2.setBounds(454, 11, 419, 368);
		panel_1.add(ScrollPanel2);
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(211, 11, 239, 222);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Book Name");
		lblNewLabel_3.setBounds(10, 40, 80, 14);
		panel_3.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Author");
		lblNewLabel_4.setBounds(10, 65, 46, 14);
		panel_3.add(lblNewLabel_4);

		edition = new JLabel("Edition");
		edition.setBounds(10, 90, 102, 14);
		panel_3.add(edition);

		JLabel lblNewLabel_6 = new JLabel("Price");
		lblNewLabel_6.setBounds(10, 115, 46, 14);
		panel_3.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Quantity");
		lblNewLabel_7.setBounds(10, 140, 60, 14);
		panel_3.add(lblNewLabel_7);

		JButton addButton = new JButton("Add");
		addButton.setBounds(127, 188, 80, 23);
		panel_3.add(addButton);

		nametxt = new JTextField();
		nametxt.setBounds(80, 37, 136, 20);
		panel_3.add(nametxt);
		nametxt.setColumns(10);

		authortxt = new JTextField();
		authortxt.setBounds(80, 62, 136, 20);
		panel_3.add(authortxt);
		authortxt.setColumns(10);

		editiontxt = new JTextField();
		editiontxt.setBounds(80, 87, 136, 20);
		panel_3.add(editiontxt);
		editiontxt.setColumns(10);

		pricetxt = new JTextField();
		pricetxt.setBounds(80, 112, 136, 20);
		panel_3.add(pricetxt);
		pricetxt.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("Book Id");
		lblNewLabel_11.setBounds(10, 15, 46, 14);
		panel_3.add(lblNewLabel_11);

		idtxt = new JTextField();
		idtxt.setBounds(80, 12, 46, 20);
		panel_3.add(idtxt);
		idtxt.setColumns(10);

		searchPanel();

		JScrollPane jScrollPane1 = new JScrollPane();
		jScrollPane1.setBounds(10, 244, 438, 169);
		panel_1.add(jScrollPane1);

		JButton CancelTransactionButton = new JButton("Cancel");
		CancelTransactionButton.setBounds(25, 545, 97, 36);
		this.getContentPane().add(CancelTransactionButton);
		CancelTransactionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelTransaction();
			}
		});

		searchTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Book Id", "Book Name", "Author", "Edition", "Price" }

		) {
			Class[] types = new Class[] { java.lang.Integer.class, java.lang.String.class, java.lang.String.class,
					java.lang.Integer.class, java.lang.Integer.class };

			@Override
			@SuppressWarnings("unchecked")
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		});
		searchTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		searchTable.setGridColor(new java.awt.Color(255, 255, 255));
		searchTable.setShowGrid(true);
		searchTable.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTable1MouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(searchTable);
		transactionTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Book ID", "Book Name", "Author", "Edition", "Price", "Quantity", "Total" }

		) {
			Class[] types = new Class[] { java.lang.Integer.class, java.lang.String.class, java.lang.String.class,
					java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class,
					java.lang.Integer.class };

			@Override
			@SuppressWarnings("unchecked")
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		});
		transactionTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		transactionTable.setShowHorizontalLines(true);
		transactionTable.setShowVerticalLines(true);
		transactionTable.setGridColor(new java.awt.Color(255, 255, 255));
		transactionTable.setShowGrid(true);
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		defaults.putIfAbsent("Table.alternateRowColor", Color.LIGHT_GRAY);

		transactionTable.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		transactionTable.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				transactionTableMouseClicked(evt);
			}
		});
		JPanel panel_4 = new JPanel();
		ScrollPanel2.setViewportView(transactionTable);
		panel_4.setBackground(SystemColor.inactiveCaptionBorder);
		panel_4.setBounds(879, 11, 290, 109);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("Total Cost");
		lblNewLabel_8.setBounds(10, 11, 74, 14);
		panel_4.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Cash");
		lblNewLabel_9.setBounds(10, 36, 74, 14);
		panel_4.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("Change");
		lblNewLabel_10.setBounds(10, 61, 74, 14);
		panel_4.add(lblNewLabel_10);

		totalCosttxt = new JTextField();
		totalCosttxt.setBounds(94, 8, 161, 20);
		panel_4.add(totalCosttxt);
		totalCosttxt.setColumns(10);
		totalCosttxt.setEditable(false);

		cashtxt = new JTextField();
		cashtxt.setBounds(94, 33, 161, 20);
		panel_4.add(cashtxt);
		cashtxt.setColumns(10);
		cashtxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				changetxt.setText("");
				String value = cashtxt.getText();
				int l = value.length();
				if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					cashtxt.setEditable(true);

				} else if (ke.getKeyChar() == KeyEvent.VK_ENTER) {
					showTransactionField();

				} else {
					cashtxt.setEditable(false);

				}
			}
		});

		changetxt = new JTextField();
		changetxt.setBounds(94, 58, 161, 20);
		panel_4.add(changetxt);
		changetxt.setColumns(10);
		JLabel lblNewLabel_2 = new JLabel("Student ID");
		lblNewLabel_2.setBounds(10, 84, 60, 14);
		panel_4.add(lblNewLabel_2);

		studenttxt = new JTextField();
		studenttxt.setBounds(94, 81, 161, 20);
		panel_4.add(studenttxt);
		studenttxt.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Search by");
		lblNewLabel_1.setBounds(10, 9, 62, 14);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(10, 146, 191, 87);
		panel_1.add(panel_2);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JButton searchButton = new JButton("Search");

		searchButton.setBounds(103, 41, 78, 23);
		panel_2.add(searchButton);
		searchButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				searchButton1ActionPerformed(evt);
			}
		});

		SearchField = new JTextField();
		SearchField.setBounds(10, 42, 86, 20);
		panel_2.add(SearchField);
		SearchField.setColumns(10);
		searchBox = new JComboBox();
		searchBox.setBackground(Color.GRAY);
		searchBox.setBounds(78, 6, 103, 22);
		searchBox.addItem("Book Id");
		searchBox.addItem("Book Name");
		searchBox.setSelectedItem(null);
		searchBox.addActionListener(new ActionListener() {
			@Override
			@SuppressWarnings("unchecked")
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (evt.getSource() == searchBox) {
					searchAction();
				}
			}
		});
		panel_2.add(searchBox);
		nametxt.setEditable(false);
		pricetxt.setEditable(false);
		authortxt.setEditable(false);
		editiontxt.setEditable(false);

		JButton submitButton = new JButton("Submit");
		submitButton.setBounds(127, 11, 89, 23);
		panel_3.add(submitButton);

		CancelFieldButton = new JButton("Cancel");
		CancelFieldButton.setBounds(32, 188, 80, 23);
		panel_3.add(CancelFieldButton);
		SpinnerModel model = new SpinnerNumberModel(0, 0, 100, 1);
		quantitytxt = new JSpinner(model);
		quantitytxt.setBounds(80, 137, 136, 20);
		panel_3.add(quantitytxt);
		quantitytxt.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				try {
					totaltxt.setText(
							Float.toString((Float.parseFloat(pricetxt.getText()) * (Integer) quantitytxt.getValue())));
				} catch (Exception ex) {

				}
			}
		});
		JLabel totaltxtlabel = new JLabel("Total");
		totaltxtlabel.setBounds(10, 163, 46, 14);
		panel_3.add(totaltxtlabel);

		totaltxt = new JTextField();
		totaltxt.setEditable(false);
		totaltxt.setBounds(80, 160, 136, 20);
		panel_3.add(totaltxt);
		totaltxt.setColumns(10);

		JButton completeTransactionButton = new JButton("Complete Transaction");
		completeTransactionButton.setBounds(920, 131, 230, 36);
		panel_1.add(completeTransactionButton);
		completeTransactionButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				completeTransactionButtonActionPerformed(evt);
			}
		});
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		scrollPane.setBounds(883, 172, 290, 241);
		panel_1.add(scrollPane);

		txtbill = new JTextArea();
		scrollPane.setViewportView(txtbill);

		JButton removeButton = new JButton("Remove");
		removeButton.setBounds(610, 390, 89, 23);
		panel_1.add(removeButton);

		JLabel iconLabel = new JLabel("New label");
		iconLabel.setBounds(0, -11, 204, 152);
		panel_1.add(iconLabel);

		ImageIcon icon1 = new ImageIcon(getClass().getClassLoader().getResource("bookicon.jpg"));
		Image scaleImage = icon1.getImage().getScaledInstance(28, 28, Image.SCALE_DEFAULT);
		iconLabel.setIcon(icon1);
		removeButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				removeButtonActionPerformed(evt);
			}
		});
		CancelFieldButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				clearFields();
			}
		});
		submitButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitButton1ActionPerformed(evt);
			}
		});
		addButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addButton1ActionPerformed(evt);
			}
		});

	}

	/**
	 * Clears the fields
	 */
	private void clearFields() {
		idtxt.setText("");
		nametxt.setText("");
		studenttxt.setText("");
		pricetxt.setText("");
		authortxt.setText("");
		editiontxt.setText("");
		totaltxt.setText("");
		quantitytxt.setValue(0);
	}

	/**
	 * Listens when the row is clicked and display it to the form
	 * 
	 * @param evt
	 */
	private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTable1MouseClicked
		// TODO add your handling code here:
		clearFields();
		RecordTable = (DefaultTableModel) searchTable.getModel();
		SelectedRows = searchTable.getSelectedRow();

		displayFields();

//	    	id1.add(Integer.parseInt(RecordTable.getValueAt(SelectedRows,0).toString()));

	}

	/**
	 * When the table is clicked, it will hold the value of the selected row, and
	 * then proceeds to remove it when remove button is clicked
	 * 
	 * @param evt
	 */
	private void transactionTableMouseClicked(java.awt.event.MouseEvent evt) {
		RecordTable = (DefaultTableModel) searchTable.getModel();
		rowSelected.add(transactionTable.getSelectedRow());
	}

	/**
	 * Display the fields for the book data
	 */
	public void displayFields() {
		try {

			nametxt.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
			authortxt.setText(RecordTable.getValueAt(SelectedRows, 2).toString());

			pricetxt.setText(RecordTable.getValueAt(SelectedRows, 4).toString());
		} catch (Exception ex) {

		}
		try {
			editiontxt.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
		} catch (Exception ex) {

		}
		idtxt.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
	}

	/**
	 * Checks what the searchBox's value
	 * 
	 * @return true if it is bookid, false if it is bookname
	 */
	private boolean searchAction() {

		if (searchBox.getSelectedItem().equals("Book Id")) {
			return true;
		} else {
			return false;
		}
	}

	public void searchPanel() {
		panel_2.setLayout(null);
	}

	/**
	 * Removes the row from the data/costumer cancel
	 * 
	 * @param evt
	 */
	private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {
		DefaultTableModel d = (DefaultTableModel) transactionTable.getModel();
		d.removeRow(transactionTable.getSelectedRow());
		calculateTotalCost();
		showTransactionField();

	}

	/**
	 * When Search button is pressed, it will then query for the books
	 * 
	 * @param evt
	 */
	@SuppressWarnings("static-access")
	private void searchButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		if (searchAction()) {
			try {
				searchID = Integer.parseInt(SearchField.getText());
				pst = con.prepareStatement(
						"SELECT id, bookname, author, edition, price FROM books where id LIKE '" + searchID + "%'");
				ModifyTable.table_update(pst, searchTable, SearchColumns);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Search Field must not be empty");
			}
		} else {
			searchName = SearchField.getText();
			try {
				pst = con
						.prepareStatement("SELECT id, bookname, author, edition, price FROM books where bookname LIKE '"
								+ searchName + "%'");
				ModifyTable.table_update(pst, searchTable, SearchColumns);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Search Field must not be empty");
				e.printStackTrace();
			}
		}
	}

	/**
	 * Handles the submit button actions
	 * 
	 * @param evt
	 */
	private void submitButton1ActionPerformed(java.awt.event.ActionEvent evt) {

		try {
			searchID = Integer.parseInt(idtxt.getText());
			submitQuery();

		} catch (java.lang.NumberFormatException | SQLException ex) {
			JOptionPane.showMessageDialog(null, "You must enter a number!");
		}

	}

	/**
	 * Handles the Button that is responsible for completing the transaction
	 * 
	 * @param evt
	 */

	private void completeTransactionButtonActionPerformed(java.awt.event.ActionEvent evt) {
		clearBill();
		printBill();

		try {
			studentid = Integer.parseInt(studenttxt.getText());
		} catch (Exception ex) {
			studentid = 0;
		}
		cash = Float.parseFloat(cashtxt.getText());
		change = Float.parseFloat(changetxt.getText());
		AddTransactions.transact(transactionTable, TotalCost, cash, change, studentid);
		ModifyTable.clearTable(transactionTable);
		clearFields();
		clearTransactionFields();
	}

	/**
	 * Submits the query to search for the books
	 * 
	 * @throws SQLException
	 */
	private void submitQuery() throws SQLException {

		pst = con.prepareStatement("SELECT id, bookname, author, edition, price FROM books where id = " + searchID);
		// TODO Auto-generated catch block

		ResultSet rs = pst.executeQuery();
		if (!rs.next()) {
			JOptionPane.showMessageDialog(null, "Book ID/record does not exist!");
			clearFields();
		} else {
			nametxt.setText(rs.getString("bookname"));
			authortxt.setText(rs.getString("author"));
			editiontxt.setText(Integer.toString(rs.getInt("edition")));
			pricetxt.setText(Float.toString(rs.getFloat("price")));
		}

	}

	/**
	 * Places the data to the table after the add button is pressed
	 * 
	 * @param evt
	 */
	@SuppressWarnings("unchecked")
	private void addButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		if (checkJSpinner(quantitytxt)) {

			DefaultTableModel d = (DefaultTableModel) transactionTable.getModel();

			Vector v2 = new Vector();

			v2.add(idtxt.getText());
			v2.add(nametxt.getText());
			v2.add(authortxt.getText());
			v2.add(editiontxt.getText());
			v2.add(pricetxt.getText());
			v2.add(quantitytxt.getValue());
			float price = Float.parseFloat(pricetxt.getText());
			int quantity = (Integer) quantitytxt.getValue();
			v2.add(price * quantity);
			d.addRow(v2);
			calculateTotalCost();
			showTransactionField();

			clearFields();

		}
	}

	/**
	 * Calculates the total cost
	 */
	private void calculateTotalCost() {
		DefaultTableModel d = (DefaultTableModel) transactionTable.getModel();
		for (int i = 0; i < d.getRowCount(); i++) { // Loop through the rows

			TotalCost += (float) d.getValueAt(i, 6);
		}

	}

	/**
	 * Shows the transaction field
	 */
	private void showTransactionField() {
		totalCosttxt.setText(Float.toString(TotalCost));
		try {
			changetxt.setText(Float.toString(Float.parseFloat(cashtxt.getText()) - TotalCost));
		} catch (Exception ex) {

		}
	}

	/**
	 * Checks if the field that should be inputed with numerical value is valid
	 * 
	 * @return true if field is valid, false otherwise
	 */
	private boolean checkJSpinner(JSpinner textfield) {

		if ((Integer) textfield.getValue() < 1) {
			JOptionPane.showMessageDialog(null, "Value must be valid");
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Initializes the TotalCost for each transaction
	 */
	private void initTotalCost() {
		TotalCost = 0;
	}

	/**
	 * Cancels the transaction by clearing the fields and set a new transaction
	 */
	public void cancelTransaction() {
		clearFields();
		ModifyTable.clearTable(transactionTable);
		clearTransactionFields();
		clearBill();

	}

	/**
	 * Clears the transaction field
	 */
	public void clearTransactionFields() {
		totalCosttxt.setText("");
		changetxt.setText("");
		cashtxt.setText("");
		studenttxt.setText("");
	}

	/**
	 * Prints the bill
	 */
	@SuppressWarnings("static-access")
	public void printBill() {
		total = totalCosttxt.getText();
		pay = cashtxt.getText();
		bal = changetxt.getText();

		DefaultTableModel model = new DefaultTableModel();

		model = (DefaultTableModel) transactionTable.getModel();

		txtbill.setText(txtbill.getText() + "******************************************************\n");
		txtbill.setText(txtbill.getText() + "Transaction id: " + Integer.toString(AddTransactions.getid())
				+ "                        " + DateTime.getDate() + "\n");
		txtbill.setText(txtbill.getText() + "                                  POSBILL                        \n");
		txtbill.setText(txtbill.getText() + "*******************************************************\n");

		// Heading
		txtbill.setText(txtbill.getText() + "  " + "Product" + "\t" + "Price" + "\t" + "Amount" + "\n");

		for (int i = 0; i < model.getRowCount(); i++) {

			String pname = (String) model.getValueAt(i, 1);
			String price = (String) model.getValueAt(i, 4);
			String amount = model.getValueAt(i, 5).toString();
			String studentid = studenttxt.getText();
			txtbill.setText(txtbill.getText() + pname.substring(0, 10) + "\t" + price + "\t" + amount + "\n");

		}

		txtbill.setText(txtbill.getText() + "\n");

		txtbill.setText(txtbill.getText() + "  " + "\t" + "\t" + "Subtotal :" + total + "\n");
		txtbill.setText(txtbill.getText() + "  " + "\t" + "\t" + "Pay :" + pay + "\n");
		txtbill.setText(txtbill.getText() + "  " + "\t" + "\t" + "Balance :" + bal + "\n");
		txtbill.setText(txtbill.getText() + "  " + "\n");
		txtbill.setText(txtbill.getText() + "*******************************************************\n");
		txtbill.setText(txtbill.getText() + "                      THANK YOU COME AGAIN             \n");

	}

	/**
	 * Clears the bill panel
	 */
	private void clearBill() {
		txtbill.setText("");
	}

	String[] SearchColumns = { "id", "bookname", "author", "edition", "price" };
	private javax.swing.JTable searchTable;
	ArrayList<Integer> id1 = new ArrayList<>();
	private String searchName;
	private int searchID;
	private JComboBox searchBox;
	private JTextField SearchField;
	Connection con;
	PreparedStatement pst;
	private JTextField totalCosttxt;
	private JTextField cashtxt;
	private JTextField changetxt;
	private JTextField studenttxt;
	private JTextField nametxt;
	private JLabel edition;
	private JTextField authortxt;
	private JTextField editiontxt;
	private JTextField pricetxt;
	private JPanel panel_1;
	private JTable transactionTable;
	private JTextField idtxt;
	private DefaultTableModel RecordTable;
	private int SelectedRows;
	private JButton CancelFieldButton;
	float TotalCost; // initializes the total cost
	private JSpinner quantitytxt;
	private String total;
	private String pay;
	private String bal;
	private JTextField totaltxt;
	public JTextArea txtbill;
	ArrayList<Integer> rowSelected = new ArrayList<>();
	private int studentid;
	float change;
	float cash;
}
