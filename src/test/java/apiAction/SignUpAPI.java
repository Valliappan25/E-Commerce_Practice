package apiAction;

import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import java.io.IOException;
import java.util.HashMap;

import com.testing.POJO.User;
import com.testing.Utilities.ConfigLoader;

public class SignUpAPI {

	private Cookies cookies;
	
	public Cookies getCookies()
	{
		return cookies;
	}
	
	private String fetchRegisterElementUsingJSoup() throws IOException
	{
		Response response = getAccount();
		Document doc = Jsoup.parse(response.body().prettyPrint());
		Element element = doc.selectFirst("#woocommerce-register-nonce");
		return element.attr("value");
	}
	
	private Response getAccount() throws IOException
	{
		Cookies cookies = new Cookies();
		Response response = given().baseUri(ConfigLoader.getInstance().getURL())
			.cookies(cookies).
			log().all().
		
		when()
			.get("/account").
		
		then()
		.log().all()
			.extract()
			.response();
		
		if(response.getStatusCode() != 200)
			throw new RuntimeException("Failed to Fetch the response HTTP Status " + response.getStatusCode());
		return response;
	}
	
	public Response register(User user) throws IOException
	{
		Cookies cookies = new Cookies();
		Header header = new Header("content-type", "application/x-www-form-urlencoded");
		Headers headers = new Headers(header);
		
		HashMap<String, String> formParams = new HashMap<>();
		
		formParams.put("username", user.getUsername());
		formParams.put("email", user.getEmail());
		formParams.put("password", user.getPassword());
		formParams.put("woocommerce-register-nonce", fetchRegisterElementUsingJSoup());
		formParams.put("register", "Register");
		
		Response response = given()
				.baseUri(ConfigLoader.getInstance().getURL())
				.headers(headers)
				.formParams(formParams)
			.cookies(cookies).
			log().all().
		
		when()
			.post("/account").
		
		then()
		.log().all()
			.extract()
			.response();
		
		if(response.getStatusCode() != 302)
			throw new RuntimeException("Failed to Register the account response HTTP Status " + response.getStatusCode());
		this.cookies = response.getDetailedCookies();
		return response;
	}
}
