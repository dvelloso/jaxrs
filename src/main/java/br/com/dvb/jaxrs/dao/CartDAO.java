package br.com.dvb.jaxrs.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import br.com.dvb.jaxrs.model.Address;
import br.com.dvb.jaxrs.model.Cart;
import br.com.dvb.jaxrs.model.Product;
import br.com.dvb.jaxrs.model.User;

public class CartDAO {
	
	private static Map<Long, Cart> dataBase = new HashMap<Long, Cart>();
	private static AtomicLong counter = new AtomicLong();
	
	static {
		Product videoGame = new Product(counter.incrementAndGet(), "PS4", BigDecimal.valueOf(1500), 1L);
		Product noteBook = new Product(counter.incrementAndGet(), "ASUS NoteBook", BigDecimal.valueOf(2350.99), 1L);
		User user = new User("user@gmail.com", new Address("020000-00", "Rua", "São Paulo", 123L));
		Cart cart = new Cart().
				add(videoGame).
				add(noteBook).
				to(user);
		dataBase.put(1L, cart);
	}
	
	public void add(Cart cart) {
		long id = counter.incrementAndGet();
		cart.setId(id);
		dataBase.put(id, cart);
	}
	
	public Cart get(Long id) {
		return dataBase.get(id);
	}
	
	public Cart remove(Long id) {
		return dataBase.remove(id);
	}

}
