/**
 * 
 */
package com.chocolate.engSoft.server;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;

import com.appsolut.api.cloudmade.geometry.Point;
import com.chocolate.engSoft.server.model.Comment;
import com.chocolate.engSoft.server.model.Place;
import com.chocolate.engSoft.server.model.Position;
import com.chocolate.engSoft.server.model.ServiceNotification;
import com.chocolate.engSoft.server.model.User;

/**
 * @author João Marco Maciel da Silva
 * 
 */
public class Utils {

	/**
	 * @param string
	 * @return a md5 encrypted string
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 */
	public static String convertStringToMd5(String string)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		if (string == null)
			return null;
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.reset();
		md.update(string.getBytes("UTF-8"));
		byte[] digest = md.digest();
		BigInteger bigInt = new BigInteger(1, digest);
		String hashtext = bigInt.toString(16);
		while (hashtext.length() < 32) {
			hashtext = "0" + hashtext;
		}
		return hashtext;
	}

	/**
	 * "POST /auth/" and "POST /u/" helper
	 * 
	 * @param obj
	 * @return token
	 * @throws JSONException
	 */
	public static String tokenFromJson(JSONObject obj) throws JSONException {
		if (obj == null)
			return null;
		return obj.getString("token");
	}

	/**
	 * "GET /l/" and "POST /l/busca/" helper
	 * 
	 * @param placesJson
	 * @return list of places
	 * @throws JSONException
	 * @throws ParseException
	 */
	public static List<Place> placesFromJson(List<JSONObject> jsonList) {
		if (jsonList == null)
			return null;
		List<Place> places = new ArrayList<Place>();
		try {
			for (JSONObject jsonObject : jsonList) {
				places.add(Utils.placeFromJson(jsonObject));
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return places;
	}



	/**
	 * "POST /l/" helper
	 * 
	 * @param obj
	 * @return id
	 * @throws JSONException
	 */
	public static Long idFromJson(JSONObject obj) throws JSONException {
		if (obj == null)
			return null;
		return obj.getLong("id");
	}

	/**
	 * "POST /l/" and "POST /l/busca/" helper
	 * 
	 * @param place
	 * @return JSON object with a place
	 * @throws JSONException
	 */
	public static JSONObject placeToJson(Place place) throws JSONException {
		if (place == null)
			return null;
		JSONObject obj = new JSONObject();
		obj.put("coordenada", pointToJson(place.getPoint()));
		obj.put("nome", place.getName());
		obj.put("descricao", place.getDescription());
		obj.put("tags", stringSetToJson(place.getTags()));
		return obj;
	}

	/**
	 * "GET /l/<id>/" helper
	 * 
	 * @param obj
	 * @return a place
	 * @throws JSONException
	 * @throws ParseException
	 */
	public static Place placeFromJson(JSONObject obj) throws JSONException,
			ParseException {
		if (obj == null)
			return null;
		return new Place(obj.getLong("id"),
				com.appsolut.api.cloudmade.Utils.pointFromJson(obj
						.getJSONArray("coordenada")), obj.getString("nome"),
				obj.getString("descricao"),
				tagsFromJson(obj.getJSONArray("tags")),
				commentsFromJson(obj.getJSONArray("comentarios")));
	}

	/**
	 * "POST /auth/", "POST /u/" and POST "/u/busca/" helper
	 * 
	 * @param user
	 * @return JSON object with user information
	 * @throws JSONException
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static JSONObject userToJson(User user)
			throws UnsupportedEncodingException, NoSuchAlgorithmException,
			JSONException {
		if (user == null)
			return null;
		JSONObject obj = new JSONObject();
		obj.put("username", user.getUsername());
		obj.put("nome", user.getName());
		obj.put("senha", convertStringToMd5(user.getPassword()));
		return obj;
	}

	/**
	 * "GET /u/<username>" helper
	 * 
	 * @param obj
	 * @return user profile
	 * @throws JSONException
	 * @throws ParseException
	 */
	public static User userFromJson(JSONObject obj) throws JSONException,
			ParseException {
		if (obj == null)
			return null;
		return new User(obj.getString("username"), obj.getString("nome"),
				friendListFromJson(obj.getJSONArray("amigos")),
				placeHistoryFromJson(obj.getJSONArray("posicoes")));
	}

	/**
	 * "POST /u/<username>" helper
	 * 
	 * @param name
	 * @return JSON object with a name
	 * @throws JSONException
	 */
	public static JSONObject nameToJson(String name) throws JSONException {
		JSONObject obj = new JSONObject();
		obj.put("nome", name);
		return obj;
	}

	/**
	 * "GET /u/<username>/notificacoes/" helper
	 * 
	 * @param array
	 * @return list of notifications
	 * @throws JSONException
	 * @throws ParseException
	 */
	public static List<ServiceNotification> notificationsFromJson(
			List<JSONObject> array) throws JSONException, ParseException {
		if (array == null)
			return null;
		List<ServiceNotification> notifications = new ArrayList<ServiceNotification>();
		for (JSONObject jsonObject : array) {
			notifications.add(notificationFromJson(jsonObject));
		}
		return notifications;
	}

	/**
	 * "/l/busca/" helper
	 * 
	 * @param point
	 * @return an array with the coordinates
	 * @throws JSONException
	 */
	public static JSONArray pointToJson(Point point) throws JSONException {
		if (point == null)
			return null;
		JSONArray array = new JSONArray();
		array.put(0, point.lat);
		array.put(1, point.lon);
		return array;
	}
	
	/**
	 * "/l/busca/" helper
	 * 
	 * @param jsonList
	 * @return a list of users with a search criteria
	 */
	public static List<User> usersFromJson(List<JSONObject> jsonList) {
		if (jsonList == null)
			return null;
		List<User> users = new ArrayList<User>();
		try {
		for (JSONObject jsonObject : jsonList) {
				users.add(userFromJson(jsonObject));
		}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	// private
	private static JSONArray stringSetToJson(Set<String> tags) {
		if (tags == null)
			return null;
		JSONArray array = new JSONArray();
		Iterator<String> it = tags.iterator();
		while (it.hasNext()) {
			array.put(it.next());
		}
		return array;
	}

	private static List<Comment> commentsFromJson(JSONArray array)
			throws JSONException, ParseException {
		if (array == null)
			return null;
		List<Comment> comments = new ArrayList<Comment>();
		for (int i = 0; i < array.length(); i++) {
			comments.add(commentFromJson(array.getJSONObject(i)));
		}
		return comments;
	}

	private static Comment commentFromJson(JSONObject obj)
			throws JSONException, ParseException {
		if (obj == null)
			return null;
		return new Comment(obj.getString("username"),
				placeFromJson(obj.getJSONObject("lugar")),
				obj.getString("texto"), dateFromJson(obj.getString("datahora")));
	}

	private static Set<String> tagsFromJson(JSONArray array)
			throws JSONException {
		if (array == null)
			return null;
		Set<String> tags = new HashSet<String>();
		for (int i = 0; i < array.length(); i++) {
			tags.add(array.getString(i));
		}
		return tags;
	}

	private static List<Position> placeHistoryFromJson(JSONArray array)
			throws JSONException, ParseException {
		if (array == null)
			return null;
		List<Position> placeHistory = new ArrayList<Position>();
		for (int i = 0; i < array.length(); i++) {
			placeHistory.add(positionFromJson(array.getJSONObject(i)));
		}
		return placeHistory;
	}

	private static Position positionFromJson(JSONObject obj)
			throws JSONException, ParseException {
		if (obj == null)
			return null;
		return new Position(com.appsolut.api.cloudmade.Utils.pointFromJson(obj
				.getJSONArray("coordenada")),
				placeFromJson(obj.getJSONObject("lugar")),
				dateFromJson(obj.getString("datahora")));
	}

	private static List<String> stringListFromJson(JSONArray array)
			throws JSONException {
		if (array == null)
			return null;
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < array.length(); i++) {
			list.add(array.getString(i));
		}
		return list;
	}

	private static List<User> friendListFromJson(JSONArray array)
			throws JSONException {
		if (array == null)
			return null;
		List<User> list = new ArrayList<User>();
		for (int i = 0; i < array.length(); i++) {
			JSONObject obj = array.getJSONObject(i);
			User user = new User(obj.getString("username"),
					obj.getString("nome"), null);
			list.add(user);
		}
		return list;
	}

	private static ServiceNotification notificationFromJson(JSONObject obj)
			throws JSONException, ParseException {
		if (obj == null)
			return null;
		return new ServiceNotification(obj.getString("tipo"),
				stringListFromJson(obj.getJSONArray("usuarios")),
				dateFromJson(obj.getString("datahora")), obj.getBoolean("lida"));
	}

	@SuppressLint("SimpleDateFormat")
	private static Date dateFromJson(String string) throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(string);
	}
}
