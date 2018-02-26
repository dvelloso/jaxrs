package br.com.dvb.jaxrs;

import java.math.BigDecimal;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.dvb.jaxrs.model.Address;
import br.com.dvb.jaxrs.model.Cart;
import br.com.dvb.jaxrs.model.Product;
import br.com.dvb.jaxrs.model.User;

public class ClientTest {

	private Builder request;
	private Client client;
	private Response response;
	private static final String URI = "http://localhost:8080/jaxrs/carts";
	
	@Before
	public void initialize(){
		client = ClientBuilder.newClient();
	}
	
	@After
	public void finalize(){
		client.close();
	}

	@Test
	public void TestThatReturnsTheExpectedCart() {
		Builder request = client.target(URI.concat("/1")).request().accept(MediaType.APPLICATION_XML);
		Response response = request.buildGet().invoke();
		
		Assert.assertEquals("PS4", response.readEntity(Cart.class).getProducts().get(0).getName());
	}
	
	@Test
	public void TestAddChart() {
		Cart cart3 = new Cart().add(new Product(3L, "IPAD", BigDecimal.valueOf(500), 1L)).
				to(new User("user2@email.com", new Address("00000-00", "rua 1", "Taubaté", 123L)));
		
		request = client.target(URI).request().accept(MediaType.APPLICATION_XML);
		Entity<Cart> entity = Entity.entity(cart3, MediaType.APPLICATION_XML);
		response = request.buildPost(entity).invoke();
		
		Assert.assertEquals(201, response.getStatus());
	}
	
	@Test
	public void TestDeleteChart() {
		request = client.target(URI.concat("/1/products/2")).request().accept(MediaType.APPLICATION_XML);
		response = request.buildDelete().invoke();
		
		Assert.assertEquals(200, response.getStatus());
	}
}
