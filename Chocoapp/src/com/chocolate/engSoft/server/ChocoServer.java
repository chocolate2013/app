/**
 * 
 */
package com.chocolate.engSoft.server;

import java.util.List;

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

	// TODO password needs to be encrypted
	/**
	 * GET /auth/
	 * 
	 * @param user
	 * @param password
	 * @return Token with a the token's value
	 */
	public String authenticate(String user, String password);

	/**
	 * GET /l/
	 * 
	 * @param token
	 * @return list of places
	 */
	public List<Place> getPlaces(String token);

	/**
	 * POST /l/
	 * 
	 * @param place
	 * @return id
	 */
	public Long addPlace(String token, Place place);

	/**
	 * GET /l/<id>/
	 * 
	 * @param id
	 * @return Place with id and comments
	 */
	public Place getPlace(String token, Long id);

	/**
	 * POST /l/busca/
	 * 
	 * @param token
	 * @param point
	 * @return list of places in a determined place
	 */
	public List<Place> getPlacesByPoint(String token, Point point);

	/**
	 * POST /l/busca/
	 * 
	 * @param token
	 * @param name
	 * @return list of places with the same name
	 */
	public List<Place> getPlacesByName(String token, String name);

	/**
	 * POST /l/busca/
	 * 
	 * @param token
	 * @param tag
	 * @return list of places with a tag
	 */
	public List<Place> getPlacesByTag(String token, String tag);

	/**
	 * POST /u/
	 * 
	 * @param token
	 * @param user
	 * @return token
	 */
	public String registerUser(String token, User user);

	/**
	 * GET /u/<username>
	 * 
	 * @param token
	 * @param userName
	 * @return User without password
	 */
	public User getUserProfile(String token, String userName);

	/**
	 * POST /u/<username> Change the user`s name if he is the owner of the token
	 * 
	 * @param token
	 * @param name
	 */
	public void setName(String token, String name);

	/**
	 * DELETE /u/<username>
	 * 
	 * @param token
	 * @param username
	 */
	public void deleteUser(String token, String username);

	/**
	 * GET /u/<username>/notificacoes/
	 * 
	 * @param token
	 * @param username
	 * @return list of notifications
	 */
	public List<ServiceNotification> getNotifications(String token,
			String username);

	/**
	 * POST /u/<username>/adicionar/ Send a friendship invitation, if the
	 * username had already sent a friendship invitation it just accepts it
	 * 
	 * @param token
	 * @param username
	 */
	public void addFriend(String token, String username);

	/**
	 * POST /u/busca/
	 * 
	 * @param token
	 * @param username
	 * @param name
	 * @return list of User a the search criteria
	 */
	public List<User> searchUsers(String token, String username, String name);
}
