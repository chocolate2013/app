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
import java.util.Iterator;
import java.util.List;

import android.annotation.SuppressLint;

import com.appsolut.api.cloudmade.geometry.Point;
import com.chocolate.engSoft.server.model.Comment;
import com.chocolate.engSoft.server.model.Place;
import com.chocolate.engSoft.server.model.Position;
import com.chocolate.engSoft.server.model.ServiceNotification;
import com.chocolate.engSoft.server.model.User;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

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
	 * @throws Exception
	 */
	public static String tokenFromJson(JsonObject obj) throws Exception {
		if (obj == null)
			return null;
		return obj.get("token").getAsString();
	}

	/**
	 * "GET /l/" and "POST /l/busca/" helper
	 * 
	 * @param placesJson
	 * @return list of places
	 * @throws Exception
	 * @throws ParseException
	 */
	public static List<Place> placesFromJson(List<JsonObject> jsonList) {
		if (jsonList == null)
			return null;
		List<Place> places = new ArrayList<Place>();
		try {
			for (JsonObject jsonObject : jsonList) {
				places.add(Utils.placeFromJson(jsonObject));
			}
		} catch (Exception e) {
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
	 * @throws Exception
	 */
	public static Long idFromJson(JsonObject obj) throws Exception {
		if (obj == null)
			return null;
		return obj.get("id").getAsLong();
	}

	/**
	 * "POST /l/" and "POST /l/busca/" helper
	 * 
	 * @param place
	 * @return Json object with a place
	 * @throws Exception
	 */
	public static JsonObject placeToJson(Place place) throws Exception {
		if (place == null)
			return null;
		JsonObject obj = new JsonObject();
		obj.add("coordenada", pointToJson(place.getPoint()));
		obj.addProperty("nome", place.getName());
		obj.addProperty("descricao", place.getDescription());
		obj.add("tags", stringListToJson(place.getTags()));
		return obj;
	}

	/**
	 * "GET /l/<id>/" helper
	 * 
	 * @param obj
	 * @return a place
	 * @throws Exception
	 * @throws ParseException
	 */
	public static Place placeFromJson(JsonObject obj) throws Exception,
			ParseException {
		if (obj == null)
			return null;
		return new Place(obj.get("id").getAsLong(),
				pointFromJson(obj.getAsJsonArray("coordenada")), obj
						.get("nome").getAsString(), obj.get("descricao")
						.getAsString(),
				tagsFromJson(obj.getAsJsonArray("tags")),
				commentsFromJson(obj.getAsJsonArray("comentarios")));
	}

	/**
	 * "POST /auth/", "POST /u/" and POST "/u/busca/" helper
	 * 
	 * @param user
	 * @return Json object with user information
	 * @throws Exception
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static JsonObject userToJson(User user)
			throws UnsupportedEncodingException, NoSuchAlgorithmException,
			Exception {
		if (user == null)
			return null;
		JsonObject obj = new JsonObject();
		obj.addProperty("username", user.getUsername());
		obj.addProperty("nome", user.getName());
		obj.addProperty("senha", convertStringToMd5(user.getPassword()));
		return obj;
	}

	/**
	 * "GET /u/<username>" helper
	 * 
	 * @param obj
	 * @return user profile
	 * @throws Exception
	 * @throws ParseException
	 */
	public static User userFromJson(JsonObject obj) throws Exception,
			ParseException {
		if (obj == null)
			return null;
		return new User(obj.get("username").getAsString(), obj.get("nome")
				.getAsString(),
				friendListFromJson(obj.getAsJsonArray("amigos")),
				placeHistoryFromJson(obj.getAsJsonArray("posicoes")));
	}

	/**
	 * "POST /u/<username>" helper
	 * 
	 * @param name
	 * @return Json object with a name
	 * @throws Exception
	 */
	public static JsonObject nameToJson(String name) throws Exception {
		JsonObject obj = new JsonObject();
		obj.addProperty("nome", name);
		return obj;
	}

	/**
	 * "GET /u/<username>/notificacoes/" helper
	 * 
	 * @param array
	 * @return list of notifications
	 * @throws Exception
	 * @throws ParseException
	 */
	public static List<ServiceNotification> notificationsFromJson(
			List<JsonObject> array) throws Exception, ParseException {
		if (array == null)
			return null;
		List<ServiceNotification> notifications = new ArrayList<ServiceNotification>();
		for (JsonObject jsonObject : array) {
			notifications.add(notificationFromJson(jsonObject));
		}
		return notifications;
	}

	/**
	 * "/l/busca/" helper
	 * 
	 * @param point
	 * @return an array with the coordinates
	 * @throws Exception
	 */
	public static JsonArray pointToJson(Point point) throws Exception {
		if (point == null)
			return null;
		JsonArray array = new JsonArray();
		array.add(new JsonPrimitive(point.lat));
		array.add(new JsonPrimitive(point.lon));
		return array;
	}

	/**
	 * "/l/busca/" helper
	 * 
	 * @param jsonList
	 * @return a list of users with a search criteria
	 */
	public static List<User> usersFromJson(List<JsonObject> jsonList) {
		if (jsonList == null)
			return null;
		List<User> users = new ArrayList<User>();
		try {
			for (JsonObject jsonObject : jsonList) {
				users.add(userFromJson(jsonObject));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	// private
	private static JsonArray stringListToJson(List<String> tags) {
		if (tags == null)
			return null;
		JsonArray array = new JsonArray();
		Iterator<String> it = tags.iterator();
		while (it.hasNext()) {
			array.add(new JsonPrimitive(it.next()));
		}
		return array;
	}

	private static List<Comment> commentsFromJson(JsonArray array)
			throws Exception, ParseException {
		if (array == null)
			return null;
		List<Comment> comments = new ArrayList<Comment>();
		for (int i = 0; i < array.size(); i++) {
			comments.add(commentFromJson(array.get(i).getAsJsonObject()));
		}
		return comments;
	}

	private static Comment commentFromJson(JsonObject obj) throws Exception,
			ParseException {
		if (obj == null)
			return null;
		return new Comment(obj.get("username").getAsString(), placeFromJson(obj
				.get("lugar").getAsJsonObject()), obj.get("texto")
				.getAsString(), dateFromJson(obj.get("datahora").getAsString()));
	}

	private static List<String> tagsFromJson(JsonArray array) throws Exception {
		if (array == null)
			return null;
		List<String> tags = new ArrayList<String>();
		for (int i = 0; i < array.size(); i++) {
			tags.add(array.get(i).getAsString());
		}
		return tags;
	}

	private static List<Position> placeHistoryFromJson(JsonArray array)
			throws Exception, ParseException {
		if (array == null)
			return null;
		List<Position> placeHistory = new ArrayList<Position>();
		for (int i = 0; i < array.size(); i++) {
			placeHistory.add(positionFromJson(array.get(i).getAsJsonObject()));
		}
		return placeHistory;
	}

	private static Position positionFromJson(JsonObject obj) throws Exception,
			ParseException {
		if (obj == null)
			return null;
		return new Position(pointFromJson(obj.get("coordenada")
				.getAsJsonArray()), placeFromJson(obj.get("lugar")
				.getAsJsonObject()), dateFromJson(obj.get("datahora")
				.getAsString()));
	}

	private static Point pointFromJson(JsonArray array) {
		if (array == null)
			return null;
		if (array.size() == 1)
			array = array.get(0).getAsJsonArray(); // Fix of the 0.4 version
		return new Point(array.get(0).getAsDouble(), array.get(1).getAsDouble());
	}

	private static List<String> stringListFromJson(JsonArray array)
			throws Exception {
		if (array == null)
			return null;
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < array.size(); i++) {
			list.add(array.get(i).getAsString());
		}
		return list;
	}

	private static List<User> friendListFromJson(JsonArray array)
			throws Exception {
		if (array == null)
			return null;
		List<User> list = new ArrayList<User>();
		for (int i = 0; i < array.size(); i++) {
			JsonObject obj = array.get(i).getAsJsonObject();
			User user = new User(obj.get("username").getAsString(), obj.get(
					"nome").getAsString(), null);
			list.add(user);
		}
		return list;
	}

	private static ServiceNotification notificationFromJson(JsonObject obj)
			throws Exception, ParseException {
		if (obj == null)
			return null;
		return new ServiceNotification(obj.get("tipo").getAsString(),
				stringListFromJson(obj.get("usuarios").getAsJsonArray()),
				dateFromJson(obj.get("datahora").getAsString()), obj
						.get("lida").getAsBoolean());
	}

	@SuppressLint("SimpleDateFormat")
	private static Date dateFromJson(String string) throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(string);
	}
}
