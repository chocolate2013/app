package com.chocolate.engSoft.server.model;

import java.util.List;

/**
 * @author João Marco Maciel da Silva
 * 
 */
public class User {

	private String username;
	private String name;
	private String password;
	private List<String> friendList;
	private List<Position> placeHistory;

	/**
	 * @param username
	 * @param name
	 * @param password
	 */
	public User(String username, String name, String password) {
		super();
		this.username = username;
		this.name = name;
		this.password = password;
	}

	/**
	 * @param username
	 * @param name
	 * @param password
	 * @param friendList
	 * @param placeHistory
	 */
	public User(String username, String name, String password,
			List<String> friendList, List<Position> placeHistory) {
		super();
		this.username = username;
		this.name = name;
		this.password = password;
		this.friendList = friendList;
		this.placeHistory = placeHistory;
	}

	/**
	 * @param username
	 * @param name
	 * @param friendList
	 * @param placeHistory
	 */
	public User(String username, String name, List<String> friendList,
			List<Position> placeHistory) {
		super();
		this.username = username;
		this.name = name;
		this.friendList = friendList;
		this.placeHistory = placeHistory;
	}

	/**
	 * 
	 */
	public User() {
		super();
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the friendList
	 */
	public List<String> getFriendList() {
		return friendList;
	}

	/**
	 * @param friendList
	 *            the friendList to set
	 */
	public void setFriendList(List<String> friendList) {
		this.friendList = friendList;
	}

	/**
	 * @return the placeHistory
	 */
	public List<Position> getPlaceHistory() {
		return placeHistory;
	}

	/**
	 * @param placeHistory
	 *            the placeHistory to set
	 */
	public void setPlaceHistory(List<Position> placeHistory) {
		this.placeHistory = placeHistory;
	}
}
