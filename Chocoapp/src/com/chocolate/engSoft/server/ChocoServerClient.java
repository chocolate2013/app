package com.chocolate.engSoft.server;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import retrofit.RestAdapter;

import com.appsolut.api.cloudmade.geometry.Point;
import com.chocolate.engSoft.server.model.Place;
import com.chocolate.engSoft.server.model.ServiceNotification;
import com.chocolate.engSoft.server.model.User;
import com.google.gson.JsonObject;

public class ChocoServerClient implements ChocoServer {
	private static String token;
	private String protocol;
	private String host;
	private RestAdapter restAdapter;
	private ChocoServerAPI service;

	/**
	 * 
	 */
	public ChocoServerClient() {
		super();
		protocol = "http";
		host = "app.chocoapp.tk";
		restAdapter = new RestAdapter.Builder().setServer(
				protocol + "://" + host).build();
		service = restAdapter.create(ChocoServerAPI.class);
	}

	/**
	 * @param protocol
	 * @param host
	 * @param port
	 */
	public ChocoServerClient(String protocol, String host) {
		super();
		this.protocol = protocol == null ? "http" : protocol;
		this.host = host == null ? "app.chocoapp.tk" : host;
		restAdapter = new RestAdapter.Builder().setServer(
				protocol + "://" + host).build();
		service = restAdapter.create(ChocoServerAPI.class);
	}

	@Override
	public boolean authenticate(String username, String password) {
		try {
			JsonObject json = Utils.userToJson(new User(username, null,
					password));
			token = service.auth(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Place> getPlaces() {
		return Utils.placesFromJson(service.getL(token));
	}

	@Override
	public Long addPlace(Place place) {
		JsonObject json;
		try {
			json = Utils.placeToJson(place);
			return service.postL(token, json.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Place getPlace(Long id) {
		try {
			JsonObject json = service.getL(token, id);
			return Utils.placeFromJson(json);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Place> getPlacesByPoint(Point point) {
		JsonObject json = new JsonObject();
		try {
			json.add("coordenada", Utils.pointToJson(point));
			return Utils.placesFromJson(service.postLBusca(token,
					json.toString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Place> getPlacesByName(String name) {
		JsonObject json = new JsonObject();
		json.addProperty("nome", name);
		return Utils.placesFromJson(service.postLBusca(token, json.toString()));
	}

	@Override
	public List<Place> getPlacesByTag(String tag) {
		JsonObject json = new JsonObject();
		json.addProperty("tag", tag);
		return Utils.placesFromJson(service.postLBusca(token, json.toString()));
	}

	@Override
	public boolean registerUser(User user) {
		try {
			token = service.postU(Utils.userToJson(user).toString());
			return true;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getUserProfile(String username) {
		try {
			JsonObject json = service.getU(token, username);
			return Utils.userFromJson(json);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void setName(String username, String newName) {
		service.postU(token, username, newName);
	}

	@Override
	public void deleteUser(String username) {
		service.deleteU(token, username);
	}

	@Override
	public List<ServiceNotification> getNotifications(String username) {
		try {
			return Utils.notificationsFromJson(service.getUNotificacoes(token,
					username));
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<ServiceNotification>();
	}

	@Override
	public void addFriend(String username) {
		service.postUAdicionar(token, username);
	}

	@Override
	public List<User> searchUsers(String username, String name) {
		JsonObject json;
		try {
			json = Utils.userToJson(new User(username, name));
			return Utils.usersFromJson(service.postUBusca(username,
					json.toString()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
