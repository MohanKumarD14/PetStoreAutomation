package api.endpoints;

/*Swagger --> https://petstore.swagger.io/#/user/createUser

CreatUser-->POST-->   https://petstore.swagger.io/v2/user
GetUser -->GET-->     https://petstore.swagger.io/v2/user/{username}
Update User-->PUT-->  https://petstore.swagger.io/v2/user/{username}
DeleteUser-->Delete-->https://petstore.swagger.io/v2/user/{username}
 */
// https://petstore.swagger.io/v2 --> Base URL
// user/{username} --> End Point
public class Routes {

	//Routes used Maintain the URLS or contain URLS
	//Static --> access this variable directly using class name without using any  object 
	public static String base_url="https://petstore.swagger.io/v2";

	//User Module URLS

	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String update_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";

    //Store Module URLS
	
	   //Here You will create Store module URL's
	
	//Pet Module URLS
	
	   //Here You will create Pet module URL's

}
