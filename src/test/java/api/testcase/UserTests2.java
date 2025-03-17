package api.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.endpoints.UserEndpoints2;
import api.payload.User;
import groovyjarjarantlr4.v4.runtime.misc.LogManager;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import org.apache.logging.log4j.Logger;

public class UserTests2{

	Faker faker;
	User userPayload;
	@BeforeClass
	public void setupData()
	{
		faker=new Faker();
		userPayload=new User();

		userPayload.setId(faker.number().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		System.out.println("User payload data:"+ userPayload);
		
		//Logs
	}

	@Test(priority=1)
	public void testPostUser()
	{
		Response response=UserEndpoints2.createUser(this.userPayload);
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(),200);
	}

	@Test(priority=2)
	public void testGetUserByName()
	{
		Response response=UserEndpoints2.readUser(this.userPayload.getUsername());
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(),200);
	}

	@Test(priority=3)
	public void testUpdateUserByName()
	{
		//Update data using payload
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());

		Response response=UserEndpoints2.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().body();

		//response.then().log().body().statusCode(200); --> Rest Assured validation 

		Assert.assertEquals(response.getStatusCode(),200);

		//Check data after update
		Response responseAfterUpdate=UserEndpoints2.readUser(this.userPayload.getUsername());		
		Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);		
	}

	@Test(priority=4)
	public void testDeleteUserByName()
	{
		Response response=UserEndpoints2.deleteUser(this.userPayload.getUsername());

		Assert.assertEquals(response.getStatusCode(),200);
	}
}
