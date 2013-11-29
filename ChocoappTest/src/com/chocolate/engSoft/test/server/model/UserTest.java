package com.chocolate.engSoft.test.server.model;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.easymock.IMockBuilder;

import com.chocolate.engSoft.server.model.Position;
import com.chocolate.engSoft.server.model.User;

public class UserTest extends TestCase {

	private String username;
	private String name;
	private String password;
	private IMockBuilder<User> userMockBuilder;
	private List<User> friendList;
	private IMockBuilder<Position> positionMockBuilder;
	private List<Position> placeHistory;
	private User user;

	protected void setUp() throws Exception {
		super.setUp();
		userMockBuilder = EasyMock.createMockBuilder(User.class);
		positionMockBuilder = EasyMock.createMockBuilder(Position.class);

		username = "username";
		name = "name";
		password = "password";

		friendList = new ArrayList<User>();
		friendList.add(userMockBuilder.createMock());
		friendList.add(userMockBuilder.createMock());

		placeHistory = new ArrayList<Position>();
		placeHistory.add(positionMockBuilder.createMock());
		placeHistory.add(positionMockBuilder.createMock());

		user = new User(username, name, password, friendList, placeHistory);
	}

	public void testUserConstructorWithUsernameNameAndPasswrd() {
		User user = new User(username, name, password);
		assertEquals(username, user.getUsername());
		assertEquals(name, user.getName());
		assertEquals(password, user.getPassword());
	}

	public void testUserConstructorWithAllParameters() {
		assertEquals(username, user.getUsername());
		assertEquals(name, user.getName());
		assertEquals(password, user.getPassword());
		assertEquals(friendList, user.getFriendList());
		assertEquals(placeHistory, user.getPlaceHistory());
	}

	public void testUserConstructorWithoutPassword() {
		User user = new User(username, name, friendList, placeHistory);
		assertEquals(username, user.getUsername());
		assertEquals(name, user.getName());
		assertNull(user.getPassword());
		assertEquals(friendList, user.getFriendList());
		assertEquals(placeHistory, user.getPlaceHistory());
	}

	public void testUserConstructorWithoutParameters() {
		User user = new User();
		assertNull(user.getUsername());
		assertNull(user.getName());
		assertNull(user.getPassword());
		assertNull(user.getFriendList());
		assertNull(user.getPlaceHistory());
	}

	public void testUserConstructorWithUsernameAndName() {
		User user = new User(username, name);
		assertEquals(username, user.getUsername());
		assertEquals(name, user.getName());
		assertNull(user.getPassword());
		assertNull(user.getFriendList());
		assertNull(user.getPlaceHistory());
	}

	public void testSetUsername() {
		user.setUsername(null);
		assertNull(user.getUsername());
		user.setUsername(username);
		assertEquals(username, user.getUsername());
	}

	public void testSetName() {
		user.setName(null);
		assertNull(user.getName());
		user.setName(name);
		assertEquals(name, user.getName());
	}

	public void testSetPassword() {
		user.setPassword(null);
		assertNull(user.getPassword());
		user.setPassword(password);
		assertEquals(password, user.getPassword());
	}

	public void testSetFriendList() {
		user.setFriendList(new ArrayList<User>());
		assertTrue(user.getFriendList().isEmpty());
		user.setFriendList(friendList);
		assertEquals(friendList, user.getFriendList());
	}

	public void testSetPlaceHistory() {
		user.setPlaceHistory(new ArrayList<Position>());
		assertTrue(user.getPlaceHistory().isEmpty());
		user.setPlaceHistory(placeHistory);
		assertEquals(placeHistory, user.getPlaceHistory());
	}

}
