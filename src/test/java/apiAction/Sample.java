package apiAction;

import java.io.IOException;

import com.testing.POJO.User;
import com.testing.Utilities.FakerUtils;

public class Sample {

	public static void main (String Args[]) throws IOException
	{
		SignUpAPI signup = new SignUpAPI();
		FakerUtils faker = new FakerUtils();
		User user = new User();
		
		String username = "sample"+faker.randomNumber();
		user.setUsername(username);
		user.setEmail(username+"@email.com");
		user.setPassword("smaple1234");
		
		System.out.println(signup.register(user));
		System.out.println("SIGNUP COOKIES: "+signup.getCookies());
		
		CartAPI cart = new CartAPI(signup.getCookies());
		System.out.println(cart.addToCart(1215, 1));
		System.out.println("CART COOKIES: " +cart.getCookies());
		
	}
}
