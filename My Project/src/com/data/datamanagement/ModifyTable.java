package com.data.datamanagement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

/**
 * Used to Modify the tables
 * 
 * @author jacob
 *
 */
public class ModifyTable {
	JTable jTable1 = new JTable();
	Connection con;
	PreparedStatement pst;

	public ModifyTable() {

	}

	@SuppressWarnings("unchecked")
	public static void table_update(PreparedStatement pst, JTable table, String[] columns) {

		int c;
		try {

			ResultSet rs = pst.executeQuery();

			ResultSetMetaData rsd = rs.getMetaData();
			c = rsd.getColumnCount();

			DefaultTableModel d = (DefaultTableModel) table.getModel();
			d.setRowCount(0);

			while (rs.next()) {
				Vector v2 = new Vector();
				for (int i = 1; i <= c; i++) {
					v2.add(rs.getString(columns[i - 1]));

				}
				d.addRow(v2);

			}
		} catch (SQLException ex) {

		}
	}

	/**
	 * Clears the table that is passed
	 * 
	 * @param table
	 */
	public void clearTable(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

	}

}
