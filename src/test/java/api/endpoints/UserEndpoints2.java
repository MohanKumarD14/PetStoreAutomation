package api.endpoints;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// UserEndpoints.java
// Created for Perform Create, read, update, delete requests in the user API

public class UserEndpoints2 {

	// method created for getting URL's from properties file
	static ResourceBundle getURL()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");  // Load properties file  // name of the properties file
		return routes;

	}

	public static Response createUser(User payload)
	{
		String post_url=getURL().getString("post_url");

		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(post_url);
		return response;
	}

	public static Response readUser(String userName)
	{

		String get_url=getURL().getString("get_url");
		Response response=given()
				.pathParam("username", userName)
				.when()
				.get(get_url);
		return response;
	}

	public static Response updateUser(String userName,User payload)
	{
		String update_url=getURL().getString("update_url");

		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username", userName)
				.when()
				.put(update_url);
		return response;
	}

	public static Response deleteUser(String userName)
	{
		String delete_url=getURL().getString("delete_url");

		Response response=given()
				.pathParam("username", userName)
				.when()
				.delete(delete_url);
		return response;
	}
}
