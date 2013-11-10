package com.chocolate.engSoft.server.model;

import java.util.Date;
import java.util.List;

/**
 * @author João Marco MAciel da Silva
 * 
 */
public class ServiceNotification {

	private String type;
	private List<String> usernames;
	private Date date;
	private boolean read;

	/**
	 * @param type
	 * @param usernames
	 * @param date
	 * @param read
	 */
	public ServiceNotification(String type, List<String> usernames, Date date,
			boolean read) {
		super();
		this.type = type;
		this.usernames = usernames;
		this.date = date;
		this.read = read;
	}

	/**
	 * 
	 */
	public ServiceNotification() {
		super();
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the usernames
	 */
	public List<String> getUsernames() {
		return usernames;
	}

	/**
	 * @param usernames
	 *            the usernames to set
	 */
	public void setUsernames(List<String> usernames) {
		this.usernames = usernames;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the read
	 */
	public boolean isRead() {
		return read;
	}

	/**
	 * @param read
	 *            the read to set
	 */
	public void setRead(boolean read) {
		this.read = read;
	}
}
