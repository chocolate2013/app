package com.chocolate.engSoft.test.unit.server.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.easymock.IMockBuilder;

import com.chocolate.engSoft.server.model.ServiceNotification;

public class ServiceNotificationTest extends TestCase {

	private String type;
	private List<String> usernames;
	private IMockBuilder<Date> dateMockBuilder;
	private Date date;
	private boolean read;
	private ServiceNotification serviceNotification;

	protected void setUp() throws Exception {
		super.setUp();
		dateMockBuilder = EasyMock.createMockBuilder(Date.class);

		type = "A";
		usernames = new ArrayList<String>();
		usernames.add("username 1");
		usernames.add("username 2");
		date = dateMockBuilder.createMock();
		read = true;

		serviceNotification = new ServiceNotification(type, usernames, date,
				read);
	}

	public void testServiceNotificationWithAllParameters() {
		assertEquals(type, serviceNotification.getType());
		assertEquals(usernames, serviceNotification.getUsernames());
		assertEquals(date, serviceNotification.getDate());
		assertEquals(read, serviceNotification.isRead());
	}

	public void testServiceNotificationWithoutAnyParameters() {
		ServiceNotification serviceNotification = new ServiceNotification();
		assertNull(serviceNotification.getType());
		assertNull(serviceNotification.getUsernames());
		assertNull(serviceNotification.getDate());
	}

	public void testSetType() {
		serviceNotification.setType(null);
		assertNull(serviceNotification.getType());
		serviceNotification.setType(type);
		assertEquals(type, serviceNotification.getType());
	}

	public void testSetUsernames() {
		serviceNotification.setUsernames(new ArrayList<String>());
		assertTrue(serviceNotification.getUsernames().isEmpty());
		serviceNotification.setUsernames(usernames);
		assertEquals(usernames, serviceNotification.getUsernames());
	}

	public void testSetDate() {
		serviceNotification.setDate(dateMockBuilder.createMock());
		assertNotSame(date, serviceNotification.getDate());
		serviceNotification.setDate(date);
		assertEquals(date, serviceNotification.getDate());
	}

	public void testSetRead() {
		serviceNotification.setRead(false);
		assertFalse(serviceNotification.isRead());
		serviceNotification.setRead(true);
		assertTrue(serviceNotification.isRead());
	}

}
