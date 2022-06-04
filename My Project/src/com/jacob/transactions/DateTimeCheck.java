package com.jacob.transactions;

import java.text.SimpleDateFormat;
import java.util.Date;;

/**
 * Checks for the time
 * 
 * @author jacob
 *
 */
public class DateTimeCheck {
	private Date currentDate;
	private SimpleDateFormat timeFormat;

	/**
	 * Creates a new instance of CurrentDate
	 */
	public DateTimeCheck() {
		currentDate = new Date();

	}

	/**
	 * returns current date in format
	 * 
	 * @return current date MM/dd/yyyy hh:mm:ss
	 */
	public String getDate() {
		timeFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		return timeFormat.format(currentDate);
	}

	/**
	 * Generate the Date for the Database
	 * 
	 * @return
	 */
	public String getDateDB() {
		timeFormat = new SimpleDateFormat("yyyy-MM-dd");
		return timeFormat.format(currentDate);
	}

	/**
	 * Generate the time for the Database
	 * 
	 * @return
	 */
	public String getTime() {
		timeFormat = new SimpleDateFormat("hh:mm:ss");
		return timeFormat.format(currentDate);
	}
}
