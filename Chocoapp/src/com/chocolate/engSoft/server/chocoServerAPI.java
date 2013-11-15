/**
 * 
 */
package com.chocolate.engSoft.server;

import java.util.List;

import org.json.JSONObject;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * This is the real signature of the service
 * 
 * @author João Marco Maciel da Silva
 * 
 */
public interface chocoServerAPI {

	@POST("/auth/")
	String auth(@Body String jsonString);

	@POST("/auth/")
	void auth(@Body String jsonString, Callback<String> cb);

	@GET("/l/")
	List<JSONObject> getL(@Header(value = "token") String token);

	@GET("/l/")
	void getL(@Header(value = "token") String token,
			Callback<List<JSONObject>> cb);

	@POST("/l/")
	Long postL(@Header(value = "token") String token, @Body String place);

	@POST("/l/")
	void postL(@Header(value = "token") String token, @Body String place,
			Callback<Long> cb);

	@GET("/l/{id}/")
	JSONObject getL(@Header(value = "token") String token, @Path("id") Long id);

	@GET("/l/{id}/")
	void getL(@Header(value = "token") String token, @Path("id") Long id,
			Callback<JSONObject> cb);

	@POST("/l/busca/")
	List<JSONObject> postLBusca(@Header(value = "token") String token,
			@Body String criteria);

	@POST("/l/busca/")
	void postLBusca(@Header(value = "token") String token,
			@Body String criteria, Callback<List<JSONObject>> cb);

	@POST("/u/")
	String postU(@Body String user);

	@POST("/u/")
	void postU(@Body String user, Callback<String> cb);

	@GET("/u/{username}/")
	JSONObject getU(@Header(value = "token") String token,
			@Path("username") String username);

	@GET("/u/{username}/")
	void getU(@Header(value = "token") String token,
			@Path("username") String username, Callback<JSONObject> cb);

	@POST("/u/{username}/")
	void postU(@Header(value = "token") String token,
			@Path("username") String username, @Body String nome);

	@DELETE("/u/{username}/")
	void deleteU(@Header(value = "token") String token,
			@Path("username") String username);

	@GET("/u/{username}/notificacoes/")
	List<JSONObject> getUNotificacoes(@Header(value = "token") String token,
			@Path("username") String username);

	@GET("/u/{username}/notificacoes/")
	void getUNotificacoes(@Header(value = "token") String token,
			@Path("username") String username, Callback<List<JSONObject>> cb);

	@POST("/u/{username}/adicionar/")
	void postUAdicionar(@Header(value = "token") String token,
			@Path("username") String username);

	@POST("/u/busca/")
	List<JSONObject> postUBusca(@Header(value = "token") String token,
			@Body String jsonString);

	@POST("/u/busca/")
	void postUBusca(@Header(value = "token") String token,
			@Body String jsonString, Callback<List<JSONObject>> cb);
}
