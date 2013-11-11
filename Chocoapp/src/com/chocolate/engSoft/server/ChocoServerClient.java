package com.chocolate.engSoft.server;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit.RestAdapter;

import com.appsolut.api.cloudmade.geometry.Point;
import com.chocolate.engSoft.server.model.Place;
import com.chocolate.engSoft.server.model.ServiceNotification;
import com.chocolate.engSoft.server.model.User;

public class ChocoServerClient implements ChocoServer {
	private static String token;
	private String protocol = "http";
	private String host = "app.chocoapp.tk";
	private int port = 80;
	RestAdapter restAdapter = new RestAdapter.Builder().setServer(
			protocol + "://" + host).build();
	chocoServerAPI service;

	/**
	 * 
	 */
	public ChocoServerClient() {
		super();
		service = restAdapter.create(chocoServerAPI.class);
	}

	/**
	 * @param host
	 * @param port
	 */
	public ChocoServerClient(String protocol, String host, Integer port) {
		super();
		this.protocol = protocol == null ? this.protocol : protocol;
		this.host = host == null ? this.host : host;
		this.port = port == null ? this.port : port;
		restAdapter = new RestAdapter.Builder().setServer(
				protocol + "://" + host).build();
		service = restAdapter.create(chocoServerAPI.class);
	}

	@Override
	public boolean authenticate(String username, String password) {
		try {
			JSONObject json = Utils.userToJson(new User(username, null,
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
		return service.getL(token);
	}

	@Override
	public Long addPlace(Place place) {
		JSONObject json;
		try {
			json = Utils.placeToJson(place);
			return service.postL(token, json.toString());
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Place getPlace(Long id) {
		try {
			JSONObject json = service.getL(token, id);
			return Utils.placeFromJson(json);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Place> getPlacesByPoint(Point point) {
		JSONObject json = new JSONObject();
		try {
			json.put("coordenada", Utils.pointToJson(point));
			return service.postLBusca(token, json.toString());
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Place> getPlacesByName(String name) {
		JSONObject json = new JSONObject();
		try {
			json.put("nome", name);
			return service.postLBusca(token, json.toString());
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Place> getPlacesByTag(String tag) {
		JSONObject json = new JSONObject();
		try {
			json.put("tag", tag);
			return service.postLBusca(token, json.toString());
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean registerUser(User user) {
		try {
			token = service.postU(Utils.userToJson(user).toString());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public User getUserProfile(String username) {
		try {
			JSONObject json = service.getU(token, username);
			return Utils.userFromJson(json);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void setName(String username) {
		service.postU(token, username);
	}

	@Override
	public void deleteUser(String username) {
		service.deleteU(token, username);
	}

	@Override
	public List<ServiceNotification> getNotifications(String username) {
		return service.getUNotificacoes(token, username);
	}

	@Override
	public void addFriend(String username) {
		service.postUAdicionar(token, username);
	}

	@Override
	public List<User> searchUsers(String username, String name) {
		JSONObject json;
		try {
			json = Utils.userToJson(new User(username, name));
			return service.postUBusca(username, json.toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
}
