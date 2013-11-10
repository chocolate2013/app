package com.chocolate.engSoft.server.model;

import java.util.Date;

public class Position {

	private Place place;
	private Date date;

	/**
	 * @param date
	 */
	public Position(Date date) {
		super();
		this.date = date;
	}

	/**
	 * @param place
	 * @param date
	 */
	public Position(Place place, Date date) {
		super();
		this.place = place;
		this.date = date;
	}

	/**
	 * @return the place
	 */
	public Place getPlace() {
		return place;
	}

	/**
	 * @param place
	 *            the place to set
	 */
	public void setPlace(Place place) {
		this.place = place;
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
}
