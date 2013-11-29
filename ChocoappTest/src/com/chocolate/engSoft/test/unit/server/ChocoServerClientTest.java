package com.chocolate.engSoft.test.unit.server;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.legacy.PowerMockRunner;

import retrofit.RestAdapter;

import com.chocolate.engSoft.server.ChocoServerAPI;
import com.chocolate.engSoft.server.ChocoServerClient;
import com.chocolate.engSoft.server.Utils;
import com.chocolate.engSoft.server.model.User;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ RestAdapter.Builder.class, JsonObject.class })
public class ChocoServerClientTest extends TestCase {

	RestAdapter restAdapter;
	RestAdapter.Builder restAdapterBuilder;
	ChocoServerAPI service;
	ChocoServerClient chocoServerClient;
	JsonObject jsonObject;
	JsonArray jsonArray;
	User user;

	@Before
	protected void setUp() throws Exception {
		super.setUp();

		restAdapterBuilder = PowerMock
				.createNiceMock(RestAdapter.Builder.class);
		restAdapter = PowerMock.createNiceMock(RestAdapter.class);
		user = PowerMock.createNiceMock(User.class);

		service = PowerMock.createNiceMock(ChocoServerAPI.class);

		PowerMock.mockStatic(Utils.class);
		PowerMock.createNiceMockAndExpectNew(RestAdapter.Builder.class);

		EasyMock.expect(restAdapterBuilder.setServer("http://app.chocoapp.tk"))
				.andReturn(restAdapterBuilder);
		EasyMock.expect(restAdapterBuilder.build()).andReturn(restAdapter);
		EasyMock.expect(restAdapter.create(ChocoServerAPI.class)).andReturn(
				service);

		chocoServerClient = new ChocoServerClient();
	}

	@Test
	public final void testChocoServerClientConstructorWithoutParameters() {
		assertNotNull(chocoServerClient);
	}

	@Test
	public final void testChocoServerClientConstructorWithParameters()
			throws Exception {
		PowerMock.expectNew(RestAdapter.Builder.class).andReturn(
				restAdapterBuilder);
		EasyMock.expect(restAdapterBuilder.setServer("http://app.chocoapp.tk"))
				.andReturn(restAdapterBuilder);
		EasyMock.expect(
				restAdapterBuilder.setServer("https://app.chocoapp.usp.br"))
				.andReturn(restAdapterBuilder);
		EasyMock.expect(restAdapterBuilder.build()).andReturn(restAdapter);
		EasyMock.expect(restAdapter.create(ChocoServerAPI.class)).andReturn(
				service);

		assertNotNull(new ChocoServerClient("https", "app.chocoapp.usp.br"));
		assertNotNull(new ChocoServerClient(null, null));
	}

	public final void testAuthenticate() throws Exception {
		user = PowerMock.createNiceMockAndExpectNew(User.class, "username",
				null, "pass");
		PowerMock.replay(Utils.class);
		EasyMock.expect(Utils.userToJson(user)).andReturn(jsonObject);
		EasyMock.expect(service.auth(jsonObject.toString())).andReturn("token");
		Boolean bool = chocoServerClient.authenticate("username", "pass");
		PowerMock.verify(Utils.class);
		assertTrue(bool);

		PowerMock.expectNew(User.class, null, null, null).andReturn(user);
		EasyMock.expect(service.auth(jsonObject.toString())).andThrow(
				new Exception());
		assertFalse(chocoServerClient.authenticate(null, null));
	}

	public final void testGetPlaces() {
		fail("Not yet implemented"); // TODO
	}

	public final void testAddPlace() {
		fail("Not yet implemented"); // TODO
	}

	public final void testGetPlace() {
		fail("Not yet implemented"); // TODO
	}

	public final void testGetPlacesByPoint() {
		fail("Not yet implemented"); // TODO
	}

	public final void testGetPlacesByName() {
		fail("Not yet implemented"); // TODO
	}

	public final void testGetPlacesByTag() {
		fail("Not yet implemented"); // TODO
	}

	public final void testRegisterUser() {
		fail("Not yet implemented"); // TODO
	}

	public final void testGetUserProfile() {
		fail("Not yet implemented"); // TODO
	}

	public final void testSetName() {
		fail("Not yet implemented"); // TODO
	}

	public final void testDeleteUser() {
		fail("Not yet implemented"); // TODO
	}

	public final void testGetNotifications() {
		fail("Not yet implemented"); // TODO
	}

	public final void testAddFriend() {
		fail("Not yet implemented"); // TODO
	}

	public final void testSearchUsers() {
		fail("Not yet implemented"); // TODO
	}

}
