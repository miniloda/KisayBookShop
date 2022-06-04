package com.transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Handles the Adding of Transactions to database
 * 
 * @author jacob
 *
 */
public class AddTransactions {

	public AddTransactions(Connection con) {
		this.con = con;

		DateTime = new DateTimeCheck();
	}

	/**
	 * Connect to sql database
	 */

	/**
	 * Queries the Last Primary Key to generate unique serial number
	 */
	private void queryLastPKey() {
		try {
			pst = con.prepareStatement("SELECT * FROM transactions");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) == 0) {
					transactionid = 1;
				} else {
					transactionid = rs.getInt(1);

					transactionid++;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Gets the id of the transaction and return it
	 * 
	 * @return transaction id
	 * 
	 */
	public static int getid() {

		return transactionid;

	}

	/**
	 * Performs the transaction and sends the transaction to database
	 * 
	 * @param table     the table to be referenced
	 * @param totalCost the totalCost of the transaction
	 * @param cash      the cash received
	 * @param change    the change given
	 * @param studentid the student id if there is
	 */
	public void transact(JTable table, float totalCost, float cash, float change, int studentid) {
		this.table = table;
		this.totalCost = totalCost;
		this.cash = cash;
		this.change = change;
		this.studentid = studentid;
		sendtoTransactionsDB();

	}

	/**
	 * Adds the transaction data to the database
	 */
	private void sendtoTransactionsDB() {
		books = new StringBuilder();
		queryLastPKey();
		DefaultTableModel d = (DefaultTableModel) table.getModel();
		for (int i = 0; i < d.getRowCount(); i++) { // Loop through the rows

			books.append(d.getValueAt(i, 1));
			books.append(", ");
		}
		booksPurchased = books.toString();
		try {
			pst = con.prepareStatement(
					"insert into `transactions`(`transaction_id`, `student id`, `books_purchased`, `total_cost`, `cash`, `money_change`, `date_purchased`, `time_purchased`) VALUES(?,?,?,?,?,?,?,?)");

			pst.setInt(1, transactionid);
			if (studentid != 0) {
				pst.setInt(2, studentid);
			} else {
				pst.setNull(2, Types.NULL);
			}
			pst.setString(3, booksPurchased);
			pst.setFloat(4, totalCost);
			pst.setFloat(5, cash);
			pst.setFloat(6, change);
			pst.setString(7, DateTime.getDateDB());
			pst.setString(8, DateTime.getTime());

			pst.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

	Connection con;
	PreparedStatement pst;
	static int transactionid;
	JTable table;
	float totalCost;
	float cash;
	float change;
	StringBuilder books;
	private int bookid;
	private int studentid;
	private String booksPurchased;
	DateTimeCheck DateTime;
}
