/**
 * 
 */
package com.chocolate.engSoft.server;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.json.JSONException;

import com.appsolut.api.cloudmade.geometry.Point;
import com.chocolate.engSoft.server.model.Place;
import com.chocolate.engSoft.server.model.ServiceNotification;
import com.chocolate.engSoft.server.model.User;

/**
 * This package is the implementation of the server
 * 
 * @author João Marco Maciel da Silva
 * 
 */
public interface ChocoServer {

	/**
	 * POST /auth/
	 * 
	 * @param user
	 * @param password
	 * @return true if success
	 * @throws JSONException
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public boolean authenticate(String username, String password)
			throws UnsupportedEncodingException, NoSuchAlgorithmException,
			JSONException;

	/**
	 * GET /l/
	 * 
	 * @return list of places
	 */
	public List<Place> getPlaces();

	/**
	 * POST /l/
	 * 
	 * @param place
	 * @return id
	 */
	public Long addPlace(Place place);

	/**
	 * GET /l/<id>/
	 * 
	 * @param id
	 * @return Place with id and comments
	 */
	public Place getPlace(Long id);

	/**
	 * POST /l/busca/
	 * 
	 * @param point
	 * @return list of places in a determined place
	 */
	public List<Place> getPlacesByPoint(Point point);

	/**
	 * POST /l/busca/
	 * 
	 * @param name
	 * @return list of places with the same name
	 */
	public List<Place> getPlacesByName(String name);

	/**
	 * POST /l/busca/
	 * 
	 * @param tag
	 * @return list of places with a tag
	 */
	public List<Place> getPlacesByTag(String tag);

	/**
	 * POST /u/
	 * 
	 * @param user
	 * @return true for success
	 */
	public boolean registerUser(User user);

	/**
	 * GET /u/<username>
	 * 
	 * @param userName
	 * @return User without password
	 */
	public User getUserProfile(String userName);

	/**
	 * POST /u/<username> Change the user`s name if he is the owner of the token
	 * 
	 * @param name
	 */
	public void setName(String name);

	/**
	 * DELETE /u/<username>
	 * 
	 * @param username
	 */
	public void deleteUser(String username);

	/**
	 * GET /u/<username>/notificacoes/
	 * 
	 * @param username
	 * @return list of notifications
	 */
	public List<ServiceNotification> getNotifications(String username);

	/**
	 * POST /u/<username>/adicionar/ Send a friendship invitation, if the
	 * username had already sent a friendship invitation it just accepts it
	 * 
	 * @param username
	 */
	public void addFriend(String username);

	/**
	 * POST /u/busca/
	 * 
	 * @param username
	 * @param name
	 * @return list of User a the search criteria
	 */
	public List<User> searchUsers(String username, String name);
}
