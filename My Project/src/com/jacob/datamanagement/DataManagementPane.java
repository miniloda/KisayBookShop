package com.jacob.datamanagement;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * Creates the DataManagement Window
 * 
 * @author jacob
 *
 */
@SuppressWarnings("serial")
public class DataManagementPane extends JFrame {

	/**
	 * Creates new form DataManagementPane
	 */
	public DataManagementPane() {
		initComponents();
		Connect();
		table = new ModifyTable();
		try {
			table.table_update(con.prepareStatement("Select * from books"), jTable1, columns);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}

	Connection con;
	PreparedStatement pst;
	ModifyTable table;

	public class CategoryItem {
		int id;
		String name;

		@Override
		public String toString() {
			return name;
		}
	}

	/**
	 * Connects to the database
	 */
	@SuppressWarnings("unchecked")

	public void Connect() {
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = DriverManager.getConnection("jdbc:mysql://localhost/javacrud", "root", "");

		} catch (SQLException ex) {

		}

	}

	/**
	 * Initializes the components
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		this.setVisible(true);
		ImageIcon image = new ImageIcon("/image/124383.jpg");
		jPanel2 = new javax.swing.JPanel();
		jLabel9 = new javax.swing.JLabel();
		jLabel9.setBackground(new Color(0, 0, 0));
		txtname = new javax.swing.JTextField();
		addButton = new javax.swing.JButton();
		editButton = new javax.swing.JButton();
		deleteButton = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jLabel11 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		isbntxt = new javax.swing.JTextField();
		jLabel13 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		editiontxt = new javax.swing.JTextField();
		jLabel16 = new javax.swing.JLabel();
		pricetxt = new javax.swing.JTextField();
		cancelButton = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		catBox = new JComboBox();
		genreBox = new JComboBox();
//        setContentPane(new JLabel(new ImageIcon("C:\\Users\\jacob\\eclipse-workspace\\My Project\\src\\image124383.jpg")));
		CreateComboBox();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Book",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 1, 14))); // NOI18N

		jLabel9.setText("Book Name");

		addButton.setText("Add");
		addButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addButtonActionPerformed(evt);
			}
		});

		editButton.setText("Edit");
		editButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				updateButtonActionPerformed(evt);
			}
		});

		deleteButton.setText("Delete");
		deleteButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteButtonActionPerformed(evt);
			}
		});

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Id", "BookName", "Category", "Genre", "Author", "Publisher", "Year Published", "ISBN",
				"Edition", "Price" }

		) {
			Class[] types = new Class[] { java.lang.Integer.class, java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class,
					java.lang.Integer.class, java.lang.String.class, java.lang.String.class };

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
		jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		jTable1.setGridColor(new java.awt.Color(255, 255, 255));
		jTable1.setShowGrid(true);
		jTable1.setShowHorizontalLines(true);
		jTable1.setShowVerticalLines(true);
		jTable1.setGridColor(Color.GRAY);
		jTable1.setShowGrid(true);

		jTable1.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTable1MouseClicked(evt);
			}
		});
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		defaults.putIfAbsent("Table.alternateRowColor", Color.LIGHT_GRAY);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		jTable1.setDefaultRenderer(String.class, centerRenderer);
		jScrollPane1.setViewportView(jTable1);

		jLabel11.setText("Category");

		jLabel12.setText("Price");

		jLabel13.setText("Author");

		jLabel14.setText("Publisher");

		jLabel15.setText("ISBN");

		jLabel16.setText("Edition");

		cancelButton.setText("Cancel");
		cancelButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});

		authortxt = new JTextField();

		publishertxt = new JTextField();

		genrelabel = new JLabel("Genre");

		lblNewLabel = new JLabel("Year Published");

		yeartxt = new JTextField();
		yeartxt.setColumns(10);

		SearchPanel = new JPanel();
		CreateSearchPanel();
		CreateLayout();
		jTable1.setAutoCreateRowSorter(true);

		JLabel lblNewLabel_1 = new JLabel("Search by");
		lblNewLabel_1.setBounds(23, 8, 77, 14);
		SearchPanel.add(lblNewLabel_1);

		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		searchButton.setBounds(153, 56, 89, 23);
		SearchPanel.add(searchButton);
		searchButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				searchButton1ActionPerformed(evt);
			}
		});
		jPanel2.setLayout(jPanel2Layout);

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
		jLabel1.setText("Book Data");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(616).addComponent(jLabel1))
								.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanel2,
										GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(44).addComponent(jLabel1)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		getContentPane().setLayout(layout);

		pack();
		setLocationRelativeTo(null);

	}// </editor-fold>//GEN-END:initComponents

	/**
	 * Creates the Search Panel
	 */
	public void CreateSearchPanel() {

		SearchPanel.setLayout(null);

		SearchField = new JTextField();
		SearchField.setBounds(23, 57, 120, 20);
		SearchPanel.add(SearchField);
		SearchField.setColumns(10);
		SearchBox = new JComboBox();
		SearchBox.setBackground(Color.GRAY);
		SearchBox.setBounds(84, 5, 79, 20);
		SearchBox.addItem("Book Id");
		SearchBox.addItem("Book Name");
		SearchBox.setSelectedItem(null);
		SearchBox.addActionListener(new ActionListener() {
			@Override
			@SuppressWarnings("unchecked")
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (evt.getSource() == SearchBox) {
					searchAction();
				}
			}
		});

		SearchPanel.add(SearchBox);
	}

	/**
	 * Checks if what the searchAction for the search comboBox is
	 * 
	 * @return true if SearchBox is Book Id, false if otherwise
	 */
	private boolean searchAction() {

		if (SearchBox.getSelectedItem().equals("Book Id")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Performs the process when search button is pressed
	 * 
	 * @param evt
	 */
	private void searchButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// queries to the database
		if (searchAction()) {
			try {
				SearchID = Integer.parseInt(SearchField.getText());
				pst = con.prepareStatement("SELECT * FROM books where id = " + SearchID);
				ModifyTable.table_update(pst, jTable1, columns);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Search Field must not be empty");
			}
		} else {
			searchName = SearchField.getText();
			try {
				pst = con.prepareStatement("SELECT * FROM books where bookname LIKE '" + searchName + "%'");
				table.table_update(pst, jTable1, columns);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Search Field must not be empty");
				e.printStackTrace();
			}
		}
	}

	/**
	 * Handles the action for adding the data when button is pressed
	 * 
	 * @param evt
	 */
	private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		if (PriceCheck()) {
			/*
			 * we need to make sure that the price field isnt empty before /add the data to
			 * remove errors and complication
			 */
			addData();
		}
	}

	/**
	 * Checks the price
	 * 
	 * @return returns true if price field is not empty, false otherwise
	 */
	private boolean PriceCheck() {
		try {
			price = Integer.parseInt(pricetxt.getText());
			return true;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Price should not be empty");
			return false;
		}

	}

	/**
	 * Attempts to add the data to the database
	 */
	private void addData() {
		String name = txtname.getText();
		String category = (java.lang.String) catBox.getSelectedItem();
		String genre = (java.lang.String) genreBox.getSelectedItem();
		String author = authortxt.getText();
		String isbn = editiontxt.getText();
		String edition = pricetxt.getText();
		String publisher = publishertxt.getText();
		String year = yeartxt.getText();

		try {
			QueryLastPKey();
			pst = con.prepareStatement(
					"insert into books(id,bookname,category, genre, author,publisher, yearpublished, isbn,edition, price)values(?,?,?,?,?,?,?,?,?,?)");

			pst.setInt(1, n);
			pst.setString(2, name);
			pst.setString(3, category);
			pst.setString(4, genre);
			pst.setString(5, author);
			pst.setString(6, publisher);
			try {
				pst.setInt(7, Integer.parseInt(year));
			} catch (Exception ex) {
				pst.setNull(7, Types.NULL);
			}
			try {
				String pages = isbntxt.getText();
				pst.setInt(8, Integer.parseInt(pages));
			} catch (Exception ex) {
				pst.setNull(8, Types.NULL);
			}
			pst.setString(9, isbn);
			pst.setString(10, edition);

			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Book Added Successfully!");
			table.table_update(con.prepareStatement("Select * from books"), jTable1, columns);
			clearFields();

		} catch (SQLException ex) {
			Logger.getLogger(DataManagementPane.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Updates the Data in the database
	 */
	private void updateData() {
		String name = txtname.getText();
		String category = (java.lang.String) catBox.getSelectedItem();
		String genre = (java.lang.String) genreBox.getSelectedItem();
		String author = authortxt.getText();
		String isbn = editiontxt.getText();
		String edition = pricetxt.getText();
		String publisher = publishertxt.getText();
		String year = yeartxt.getText();

		try {
			pst = con.prepareStatement(
					"update books set bookname = ?, category = ?, genre = ?, author = ?, publisher = ?, yearpublished = ?,  isbn = ?, edition = ?, price = ? where ID = "
							+ id1.get(id1.size() - 1));

			pst.setString(1, name);
			pst.setString(2, category);
			pst.setString(3, genre);
			pst.setString(4, author);
			pst.setString(5, publisher);
			try {
				pst.setInt(6, Integer.parseInt(year));
			} catch (Exception ex) {
				pst.setNull(6, Types.NULL);
			}
			try {
				String pages = isbntxt.getText();
				pst.setInt(7, Integer.parseInt(pages));
			} catch (Exception ex) {
				pst.setNull(7, Types.NULL);
			}
			pst.setString(8, isbn);
			pst.setString(9, edition);

			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Book Updated Successfully!");
			table.table_update(con.prepareStatement("Select * from books"), jTable1, columns);
			clearFields();

		} catch (SQLException ex) {
			Logger.getLogger(DataManagementPane.class.getName()).log(Level.SEVERE, null, ex);
		}
		ArrayList<Integer> id1 = new ArrayList<>();
	}

	/**
	 * Clears the field in the form
	 */
	private void clearFields() {
		txtname.setText("");
		editiontxt.setText("");
		isbntxt.setText("");
		pricetxt.setText("");
		catBox.setSelectedItem(null);
		genreBox.setSelectedItem(null);
		txtname.requestFocus();
		authortxt.setText("");
		publishertxt.setText("");
		yeartxt.setText("");
	}

	/**
	 * Deletes the data in the database
	 */
	private void deleteData() {
		try {
			pst = con.prepareStatement("delete from books where id = " + id1.get(id1.size() - 1)); // we get the last
																									// added id from the
																									// id arraylist
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Book Data Deleted Successfully!");

		ArrayList<Integer> id1 = new ArrayList<>();
		table.table_update(pst, jTable1, columns);
		clearFields();
	}

	// GEN-LAST:event_jButton1ActionPerformed
	/**
	 * if Update button is clicked, it will try to update the data in the database
	 * 
	 * @param evt
	 */
	private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_updateButtonActionPerformed
		// TODO add your handling code here:
		if (PriceCheck()) {
			updateData();
		}

	}// GEN-LAST:event_updateButtonActionPerformed

	@SuppressWarnings("static-access")
	private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
		// TODO add your handling code here:
		int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Delete",
				JOptionPane.YES_NO_OPTION);
		if (opt == 0) {
			deleteData();
			try {
				table.table_update(con.prepareStatement("Select * from books"), jTable1, columns);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}// GEN-LAST:event_jButton3ActionPerformed

	/**
	 * When Table is clicked, it will automatically fill the fields to be edited
	 * 
	 * @param evt
	 */
	private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTable1MouseClicked
		// TODO add your handling code here:
		clearFields();
		DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
		int SelectedRows = jTable1.getSelectedRow();

		try {

			txtname.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
			authortxt.setText(RecordTable.getValueAt(SelectedRows, 4).toString());
			pricetxt.setText(RecordTable.getValueAt(SelectedRows, 9).toString());
		} catch (Exception ex) {

		}
		try {
			catBox.setSelectedItem(RecordTable.getValueAt(SelectedRows, 2).toString());
		} catch (Exception ex) {

		}
		try {
			genreBox.setSelectedItem(RecordTable.getValueAt(SelectedRows, 3).toString());
		} catch (Exception ex) {

		}
		try {
			publishertxt.setText(RecordTable.getValueAt(SelectedRows, 5).toString());
		} catch (Exception ex) {

		}
		try {
			isbntxt.setText(RecordTable.getValueAt(SelectedRows, 7).toString());
		} catch (Exception ex) {

		}
		try {
			yeartxt.setText(RecordTable.getValueAt(SelectedRows, 6).toString());
		} catch (Exception ex) {

		}
		try {
			editiontxt.setText(RecordTable.getValueAt(SelectedRows, 8).toString());
		} catch (Exception ex) {

		}

		id1.add(Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString()));

	}// GEN-LAST:event_jTable1MouseClicked

	/**
	 * Closes the Data Management Window
	 * 
	 * @param evt
	 */
	private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancelButtonActionPerformed
		// TODO add your handling code here:
		this.setVisible(false);
	}// GEN-LAST:event_cancelButtonActionPerformed

	/**
	 * Finds the maximum id value to generate the unique id for the next book
	 */
	private void QueryLastPKey() {
		try {
			pst = con.prepareStatement("SELECT MAX(id) FROM books");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				n = rs.getInt(1);

				n++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Creates the combobox for the genre and category
	 */
	private void CreateComboBox() {
		String[] FictionGenre = { "Action and adventure", "Alternate history", "Anthology", "Chick lit", "Children's",
				"Classic", "Comic book", "Coming-of-age", "Crime", "Drama", "Fairytale", "Fantasy", "Graphic novel",
				"Historical fiction", "Horror", "Mystery", "Picture book", "Poetry", "Political thriller", "Romance",
				"Satire", "SciFi", "Short story", "Suspense", "Thriller", "Western", "Young adult" };

		String[] NonFictionGenre = { "Art/architecture", "Autobiography", "Biography", "Business/economics",
				"Crafts/hobbies", "Cookbook", "Diary", "Dictionary", "Encyclopedia", "Guide", "Health/fitness",
				"History", "Home and garden", "Humor", "Journal", "Math", "Memoir", "Philosophy", "Prayer",
				"Religion, spirituality, and new age", "Review", "Science", "Self help", "sports and leisure", "Travel",
				"True Crime" };

		catBox.addItem("Fiction");
		catBox.addItem("Non-Fiction");
		catBox.setSelectedItem(null);

		catBox.addActionListener(new ActionListener() {
			@Override
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				try {
					if (e.getSource() == catBox) {
						if (catBox.getSelectedItem().equals("Fiction")) {
							genreBox.removeAllItems();
							for (String genre : FictionGenre) {

								genreBox.setSelectedItem(null);
								genreBox.addItem(genre);
							}
						} else if (catBox.getSelectedItem().equals("Non-Fiction")) {
							genreBox.removeAllItems();
							for (String genre : NonFictionGenre) {

								genreBox.setSelectedItem(null);
								genreBox.addItem(genre);
							}
						}
					}
				} catch (Exception ex) {

				}
			}
		});

	}

	/**
	 * Creates the layout of the frame
	 */
	public void CreateLayout() {
		jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout
				.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(
								jPanel2Layout.createSequentialGroup().addGap(77)
										.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 86,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(editButton,
												GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(
												deleteButton, GroupLayout.PREFERRED_SIZE, 89,
												GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(26).addGroup(jPanel2Layout
								.createParallelGroup(Alignment.LEADING).addComponent(jLabel15).addComponent(jLabel9)
								.addComponent(jLabel13)
								.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(genrelabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(jLabel11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
								.addComponent(jLabel12).addComponent(jLabel14).addComponent(jLabel16)
								.addComponent(lblNewLabel)).addGap(28)
								.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(yeartxt).addComponent(editiontxt)
										.addComponent(isbntxt, Alignment.TRAILING)
										.addComponent(pricetxt, 163, 163, Short.MAX_VALUE)
										.addComponent(genreBox, 163, 163, Short.MAX_VALUE)
										.addComponent(catBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtname, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 222,
												Short.MAX_VALUE)
										.addComponent(authortxt, Alignment.TRAILING)
										.addComponent(publishertxt, Alignment.TRAILING))))
				.addGap(18)
				.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup()
								.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 655, Short.MAX_VALUE)
								.addComponent(SearchPanel, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
								.addGap(12))
						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE))
				.addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout
				.createSequentialGroup()
				.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(21)
								.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel9))
								.addGap(23)
								.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel11)
										.addComponent(catBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(23)
								.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(genreBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(genrelabel))
								.addGap(18)
								.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel13)
										.addComponent(authortxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(publishertxt, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel14))
								.addGap(9)
								.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(yeartxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(isbntxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel15))
								.addGap(18)
								.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(editiontxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel16))
								.addGap(18)
								.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(pricetxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel12))
								.addGap(35)
								.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(addButton, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
										.addComponent(editButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(deleteButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(cancelButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)))
						.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
								.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(SearchPanel,
										GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
				.addGap(24)));
	}

	private javax.swing.JButton addButton;
	private javax.swing.JButton editButton;
	private javax.swing.JButton deleteButton;
	private javax.swing.JButton cancelButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField isbntxt;
	private javax.swing.JTextField txtname;
	private javax.swing.JTextField editiontxt;
	private javax.swing.JTextField pricetxt;
	private JTextField authortxt;
	private JTextField publishertxt;
	private JLabel genrelabel;
	private JComboBox catBox;
	private JComboBox genreBox;
	private int n;
	ArrayList<Integer> id1 = new ArrayList<>();
	private JLabel lblNewLabel;
	private JTextField yeartxt;
	String year;
	int price;
	private JPanel SearchPanel;
	private javax.swing.GroupLayout jPanel2Layout;
	JTextField SearchField;
	JComboBox SearchBox;
	int SearchID;
	String searchName;
	String[] SearchColumns;
	private String[] columns = { "id", "bookname", "category", "genre", "author", "publisher", "yearpublished",
			"edition", "isbn", "price" };

}
