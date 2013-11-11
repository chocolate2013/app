package com.chocolate.engSoft.server.model;

import java.util.Date;

public class Comment extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1621884859882810233L;
	private String username;
	private Place place;
	private String text;
	private Date date;

	/**
	 * 
	 */
	public Comment() {
		super();
	}

	/**
	 * @param username
	 * @param text
	 */
	public Comment(String username, String text) {
		super();
		this.username = username;
		this.text = text;
	}

	/**
	 * @param username
	 * @param place
	 * @param text
	 */
	public Comment(String username, Place place, String text, Date date) {
		super();
		this.username = username;
		this.place = place;
		this.text = text;
		this.setDate(date);
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the place
	 */
	public Place getPlace() {
		return place;
	}

	/**
	 * @param place
	 *            the position to set
	 */
	public void setPlace(Place place) {
		this.place = place;
	}

	/**
	 * @return the texto
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the texto to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
