package br.com.dvb.jaxrs.resource;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.dvb.jaxrs.dao.CartDAO;
import br.com.dvb.jaxrs.model.Cart;

@Path("carts")
public class CartResource {

	@GET
	@Path("{id}")
	@Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Cart getCart(@PathParam("id") Long id) {
		Cart cart = new CartDAO().get(id);
		return cart;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response add(Cart cart) {
		new CartDAO().add(cart);
		URI uri = URI.create("/carts/" + cart.getId());
		return Response.created(uri).build();
	}
	
	@DELETE
	@Path("{id}/products/{productId}")
	public Response remove(@PathParam("id") Long id, @PathParam("productId") Long productId) {
		Cart cart = new CartDAO().get(id);
		cart.removeProduct(productId);
		return Response.ok().build();
	}
	
}
