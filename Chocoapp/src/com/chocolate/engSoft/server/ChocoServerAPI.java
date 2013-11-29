/**
 * 
 */
package com.chocolate.engSoft.server;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Path;

import com.google.gson.JsonObject;

/**
 * This is the real signature of the service
 * 
 * @author João Marco Maciel da Silva
 * 
 */
public interface ChocoServerAPI {

	@POST("/auth/")
	String auth(@Body String jsonString);

	@POST("/auth/")
	void auth(@Body String jsonString, Callback<String> cb);

	@GET("/l/")
	List<JsonObject> getL(@Header(value = "token") String token);

	@GET("/l/")
	void getL(@Header(value = "token") String token,
			Callback<List<JsonObject>> cb);

	@POST("/l/")
	Long postL(@Header(value = "token") String token, @Body String place);

	@POST("/l/")
	void postL(@Header(value = "token") String token, @Body String place,
			Callback<Long> cb);

	@GET("/l/{id}/")
	JsonObject getL(@Header(value = "token") String token, @Path("id") Long id);

	@GET("/l/{id}/")
	void getL(@Header(value = "token") String token, @Path("id") Long id,
			Callback<JsonObject> cb);

	@POST("/l/busca/")
	List<JsonObject> postLBusca(@Header(value = "token") String token,
			@Body String criteria);

	@POST("/l/busca/")
	void postLBusca(@Header(value = "token") String token,
			@Body String criteria, Callback<List<JsonObject>> cb);

	@POST("/u/")
	String postU(@Body String user);

	@POST("/u/")
	void postU(@Body String user, Callback<String> cb);

	@GET("/u/{username}/")
	JsonObject getU(@Header(value = "token") String token,
			@Path("username") String username);

	@GET("/u/{username}/")
	void getU(@Header(value = "token") String token,
			@Path("username") String username, Callback<JsonObject> cb);

	@POST("/u/{username}/")
	void postU(@Header(value = "token") String token,
			@Path("username") String username, @Body String nome);

	@DELETE("/u/{username}/")
	void deleteU(@Header(value = "token") String token,
			@Path("username") String username);

	@GET("/u/{username}/notificacoes/")
	List<JsonObject> getUNotificacoes(@Header(value = "token") String token,
			@Path("username") String username);

	@GET("/u/{username}/notificacoes/")
	void getUNotificacoes(@Header(value = "token") String token,
			@Path("username") String username, Callback<List<JsonObject>> cb);

	@POST("/u/{username}/adicionar/")
	void postUAdicionar(@Header(value = "token") String token,
			@Path("username") String username);

	@POST("/u/busca/")
	List<JsonObject> postUBusca(@Header(value = "token") String token,
			@Body String jsonString);

	@POST("/u/busca/")
	void postUBusca(@Header(value = "token") String token,
			@Body String jsonString, Callback<List<JsonObject>> cb);
}
