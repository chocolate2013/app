package com.chocolate.engSoft.test.unit.server.model;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.easymock.IMockBuilder;

import com.appsolut.api.cloudmade.geometry.Point;
import com.chocolate.engSoft.server.model.Comment;
import com.chocolate.engSoft.server.model.Place;

public class PlaceTest extends TestCase {

	private Long id;
	private IMockBuilder<Point> pointMockBuilder;
	private Point point;
	private String name;
	private String description;
	private List<String> tags;
	private IMockBuilder<Comment> commentsMockBuilder;
	private List<Comment> comments;
	private Place place;

	protected void setUp() throws Exception {
		super.setUp();
		pointMockBuilder = EasyMock.createMockBuilder(Point.class);
		commentsMockBuilder = EasyMock.createMockBuilder(Comment.class);

		id = 1L;
		point = pointMockBuilder.createMock();
		name = "Name";
		description = "description";

		String tag1 = "tag1";
		String tag2 = "tag2";
		tags = new ArrayList<String>();
		tags.add(tag1);
		tags.add(tag2);

		Comment comment1 = commentsMockBuilder.createMock();
		Comment comment2 = commentsMockBuilder.createMock();
		comments = new ArrayList<Comment>();
		comments.add(comment1);
		comments.add(comment2);

		place = new Place(id, point, name, description, tags, comments);

	}

	public void testPlaceConstructorWithAllParameters() {
		assertNotNull(place);
		assertTrue(1L == place.getId());
		assertNotNull(point);
		assertEquals(name, place.getName());
		assertEquals(description, place.getDescription());
		assertEquals(tags, place.getTags());
		assertEquals(comments, place.getComments());
	}

	public void testPlaceConstructorWithoutComments() {
		Place place = new Place(id, point, name, description, tags);
		assertNotNull(place);
		assertTrue(1L == place.getId());
		assertNotNull(point);
		assertEquals(name, place.getName());
		assertEquals(description, place.getDescription());
		assertEquals(tags, place.getTags());
		assertNull(place.getComments());
	}

	public void testSetId() {
		place.setId(2L);
		assertTrue(2L == place.getId());
		place.setId(1L);
	}

	public void testSetPoint() {
		Point point = pointMockBuilder.createMock();
		place.setPoint(point);
		assertEquals(point, place.getPoint());
		place.setPoint(this.point);
	}

	public void testSetName() {
		String name = "newName";
		place.setName(name);
		assertEquals(name, place.getName());
		place.setName(this.name);
	}

	public void testSetDescription() {
		String description = "newDescription";
		place.setDescription(description);
		assertEquals(description, place.getDescription());
		place.setDescription(this.description);
		assertNotSame(description, place.getDescription());
	}

	public void testSetTags() {
		ArrayList<String> tags = new ArrayList<String>();
		place.setTags(tags);
		assertTrue(place.getTags().isEmpty());
		place.setTags(this.tags);
		assertEquals(this.tags, place.getTags());
	}

	public void testSetComments() {
		ArrayList<Comment> comments = new ArrayList<Comment>();
		place.setComments(comments);
		assertTrue(place.getComments().isEmpty());
		place.setComments(this.comments);
		assertEquals(this.comments, place.getComments());
	}

}
