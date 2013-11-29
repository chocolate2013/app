package com.chocolate.engSoft.test.unit.server.model;

import java.util.Date;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.easymock.IMockBuilder;

import com.appsolut.api.cloudmade.geometry.Point;
import com.chocolate.engSoft.server.model.Place;
import com.chocolate.engSoft.server.model.Position;

public class PositionTest extends TestCase {

	private IMockBuilder<Place> placeMockBuilder;
	private Place place;
	private IMockBuilder<Date> dateMockBuilder;
	private Date date;
	private IMockBuilder<Point> pointMockBuilder;
	private Point point;
	private Position position;

	protected void setUp() throws Exception {
		super.setUp();
		placeMockBuilder = EasyMock.createMockBuilder(Place.class);
		dateMockBuilder = EasyMock.createMockBuilder(Date.class);
		pointMockBuilder = EasyMock.createMockBuilder(Point.class);

		place = placeMockBuilder.createMock();
		date = dateMockBuilder.createMock();
		point = pointMockBuilder.createMock();

		position = new Position(point, place, date);
	}

	public void testPositionConstructorWithDate() {
		Position position = new Position(date);
		assertEquals(date, position.getDate());
		assertNull(position.getPlace());
		assertNull(position.getPoint());
	}

	public void testPositionConstructorWithAllParameters() {
		assertEquals(place, position.getPlace());
		assertEquals(date, position.getDate());
		assertEquals(point, position.getPoint());
	}

	public void testSetPlace() {
		Place place = placeMockBuilder.createMock();
		position.setPlace(place);
		assertEquals(place, position.getPlace());
		position.setPlace(this.place);
		assertEquals(this.place, position.getPlace());
	}

	public void testSetDate() {
		Date date = dateMockBuilder.createMock();
		position.setDate(date);
		assertEquals(date, position.getDate());
		position.setDate(this.date);
		assertNotSame(date, position.getDate());
	}

	public void testSetPoint() {
		Point point = pointMockBuilder.createMock();
		position.setPoint(point);
		assertEquals(point, position.getPoint());
		position.setPoint(this.point);
		assertNotSame(point, position.getPoint());
	}

}
