package com.chocolate.engSoft.server;

import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import com.appsolut.api.cloudmade.geometry.Point;
import com.chocolate.engSoft.server.model.Place;
import com.chocolate.engSoft.server.model.ServiceNotification;
import com.chocolate.engSoft.server.model.User;

public class ChocoServerClient implements ChocoServer {
	private static String token;
	private String host = "app.chocoapp.tk";
	private int port = 80;
	HttpClient httpClient = new DefaultHttpClient();
	
	/**
	 * 
	 */
	public ChocoServerClient() {
		super();
	}

	/**
	 * @param host
	 * @param port
	 */
	public ChocoServerClient(String host, int port) {
		super();
		this.port = port;
	}

	@Override
	public boolean authenticate(String user, String password) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<Place> getPlaces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long addPlace(Place place) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Place getPlace(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Place> getPlacesByPoint(Point point) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Place> getPlacesByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Place> getPlacesByTag(String tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUserProfile(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ServiceNotification> getNotifications(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFriend(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> searchUsers(String username, String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
