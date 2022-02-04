package apiAction;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;

import com.testing.POJO.Product;
import com.testing.POJO.User;
import com.testing.Utilities.ConfigLoader;

import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class CartAPI {

	private Cookies cookies;
	public CartAPI() {}
		
	public CartAPI(Cookies cookies)
	{
		this.cookies = cookies;
	}
	
	public Cookies getCookies()
	{
		return cookies;
	}
	
	public Response addToCart(int productId, int quantity) throws IOException
	{
		
		Header header = new Header("content-type", "application/x-www-form-urlencoded");
		Headers headers = new Headers(header);
		
		HashMap<String, Object> formParams = new HashMap<>();
		
		formParams.put("product_sku", "");
		formParams.put("product_id", productId);
		formParams.put("quantity", quantity);
		//formParams.put("woocommerce-register-nonce", fetchRegisterElementUsingJSoup());
		//formParams.put("register", "Register");
		
		if(cookies ==null)
			cookies = new Cookies();
		
		Response response = given()
				.baseUri(ConfigLoader.getInstance().getURL())
				.headers(headers)
				.formParams(formParams)
			.cookies(cookies).
			log().all().
		
		when()
			.post("/?wc-ajax=add_to_cart").
		
		then()
		.log().all()
			.extract()
			.response();
		
		if(response.getStatusCode() != 200)
			throw new RuntimeException("Failed to add" +productId+ " to the cart response HTTP Status " + response.getStatusCode());
		this.cookies = response.getDetailedCookies();
		return response;
	}
}
