package com.chocolate.engSoft.server.model;

import java.util.Date;

import com.appsolut.api.cloudmade.geometry.Point;

public class Position extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 688457570258176696L;
	private Place place;
	private Date date;
	private Point point;

	/**
	 * @param date
	 */
	public Position(Date date) {
		super();
		this.date = date;
	}

	/**
	 * @param point 
	 * @param place
	 * @param date
	 */
	public Position(Point point, Place place, Date date) {
		super();
		this.point = point;
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

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
}
