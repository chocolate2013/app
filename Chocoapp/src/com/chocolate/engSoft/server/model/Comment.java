package com.chocolate.engSoft.server.model;

public class Comment extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1621884859882810233L;
	private String username;
	private Position position;
	private String text;

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
	 * @param position
	 * @param text
	 */
	public Comment(String username, Position position, String text) {
		super();
		this.username = username;
		this.position = position;
		this.text = text;
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
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
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
}
