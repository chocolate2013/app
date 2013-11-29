package com.chocolate.engSoft.test.server.model;

import java.util.Date;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.easymock.IMockBuilder;

import com.chocolate.engSoft.server.model.Comment;
import com.chocolate.engSoft.server.model.Place;

public class CommentTest extends TestCase {

	private String username;
	private String text;
	private IMockBuilder<Place> placeMockBuilder;
	private Place place;
	private IMockBuilder<Date> dateMockBuilder;
	private Date date;
	private Comment comment;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		placeMockBuilder = EasyMock.createMockBuilder(Place.class);
		dateMockBuilder = EasyMock.createMockBuilder(Date.class);
		place = placeMockBuilder.createMock();
		date = dateMockBuilder.createMock();
		username = "João";
		text = "Some text";
		comment = new Comment(username, place, text, date);
	}

	public void testCommentContructorWithoutParameters() {
		Comment comment = new Comment();
		assertNotNull(comment);
		assertNull(comment.getText());
		assertNull(comment.getUsername());
		assertNull(comment.getDate());
		assertNull(comment.getPlace());
	}

	public void testCommentContructorWithUsernameAndText() {
		Comment comment = new Comment(username, text);
		assertNotNull(comment);
		assertEquals(text, comment.getText());
		assertEquals(username, comment.getUsername());
		assertNull(comment.getDate());
		assertNull(comment.getPlace());
	}

	public void testCommentContructorWithAllParameters() {

		Comment comment = new Comment(username, place, text, date);
		assertNotNull(comment);
		assertEquals(text, comment.getText());
		assertEquals(username, comment.getUsername());
		assertTrue(date.equals(comment.getDate()));
		assertNotNull(comment.getPlace());
	}

	public void testSetUsername() {
		String username = "change";
		comment.setUsername(username);
		assertEquals(username, comment.getUsername());
		comment.setUsername(this.username);
	}

	public void testSetPlace() {
		Place place = placeMockBuilder.createMock();
		comment.setPlace(place);
		assertEquals(place.getName(), comment.getPlace().getName());
		comment.setPlace(this.place);
	}

	public void testSetText() {
		String text = "novo texto";
		comment.setText(text);
		assertEquals(text, comment.getText());
		comment.setText(this.text);
	}

	public void testSetDate() {
		Date date = dateMockBuilder.createMock();
		comment.setDate(date);
		assertTrue(date.equals(comment.getDate()));
		comment.setDate(this.date);
	}

}
